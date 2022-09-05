package com.charon.edu_search_service.com.charon.mapper;

import com.alibaba.fastjson.JSON;
import com.charon.edu_search_service.com.charon.entity.ElasticEntity;
import com.charon.edu_search_service.com.charon.entity.PageEntity;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.reindex.BulkByScrollResponse;
import org.elasticsearch.index.reindex.DeleteByQueryRequest;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.elasticsearch.search.sort.FieldSortBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.elasticsearch.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author Charon
 * @Date 2022/8/22
 **/

@Slf4j
@Repository
public class ElasticSearchDAO {
    @Autowired
    private RestHighLevelClient client;

    /**
     * 判断索引是否存在
     * @param indexName
     * @return
     * @throws IOException
     */
    public boolean existsIndex(String indexName) throws IOException {
        GetIndexRequest request = new GetIndexRequest(indexName);
        boolean exists = client.indices().exists(request, RequestOptions.DEFAULT);
        log.info("{} exists:{}",indexName,exists);
        return exists;
    }

    /**
     * 创建索引
     * @param indexName
     * @throws IOException
     */
    public void createIndex(String indexName) throws IOException {
        CreateIndexRequest createRequest = new CreateIndexRequest(indexName);
        CreateIndexResponse response = client.indices().create(createRequest, RequestOptions.DEFAULT);
        log.info("{}创建成功 {}",indexName, JSON.toJSONString(response));
    }

    /**
     * 删除索引
     * @param indexName
     * @throws IOException
     */
    public void deleteIndex(String indexName) throws IOException {
        DeleteIndexRequest request = new DeleteIndexRequest(indexName);
        AcknowledgedResponse response = client.indices().delete(request, RequestOptions.DEFAULT);
        log.info("{}删除成功 {}",indexName, JSON.toJSONString(response));
    }

    /**
     * 批量插入数据
     */
    public void insertBatch(String indexName, List<ElasticEntity> list) throws IOException {
        BulkRequest request = new BulkRequest();
        list.forEach(item -> request.add(new IndexRequest(indexName).id(item.getId())
                .source(JSON.toJSONString(item.getData()), XContentType.JSON)));
        BulkResponse response = client.bulk(request, RequestOptions.DEFAULT);
        log.info("{}批量插入数据成功 {}",indexName, JSON.toJSONString(response));
    }

    /**
     * 按多个条件搜索内容
     * @param indexName 索引名
     * @param from 开始位置
     * @param size 分页长度
     * @param map 条件集合
     * @param sort 排序集合
     * @param clazz 搜索的类型
     * @param highlightFields 高亮显示
     * @param <T>
     * @return
     */
    public <T> PageEntity<T> searchPageByMap(String indexName, int from , int size,
                                             Map<String,String>map, Map<String ,String>sort,
                                             Class<T> clazz, String...highlightFields) throws IOException {
        //创建搜索请求
        SearchRequest request = new SearchRequest(indexName);
        //请求生成器
        SearchSourceBuilder builder = new SearchSourceBuilder();
        //创捷bool组合查询
        BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();
        //如果搜索条件不为空，就设置搜索条件
        if(map != null && map.size()> 0){
            for (String key:map.keySet()) {
                String value = map.get(key);
                if(StringUtils.hasText(value)){
                    //设置过滤条件
                    boolQuery.filter(QueryBuilders.matchPhraseQuery(key,value));
                }
            }
        }
        if(boolQuery.filter().size()>0){
            //如果设置了过滤条件，就按过滤搜索
            builder.query(boolQuery);
        }
        //设置分页参数
        builder.from(from);
        builder.size(size);
        //设置排序
        if(sort != null && sort.size()>0){
            String field = sort.get("field");
            String type = sort.get("type");
            if("createTime".equals(field)){
                field = field + ".keyword";
                }
            builder.sort(new FieldSortBuilder(field).order(SortOrder.fromString(type)));


//            builder.sort(SortBuilders.fieldSort(field).order(SortOrder.fromString(type)));

        }
        //创建高亮生成器
        HighlightBuilder highlightBuilder = new HighlightBuilder();
        //设置高亮字段
        for (String field:highlightFields) {
            highlightBuilder.field(field).requireFieldMatch(false);
            //highlightBuilder.field(field);
        }
        //设置前后标签
        highlightBuilder.preTags("<span style= 'color:red'>").postTags("</span>");
        builder.highlighter(highlightBuilder);
        //执行搜索获得结果
        request.source(builder);
        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
        SearchHit[] hits = response.getHits().getHits();
        ArrayList<T> data = new ArrayList<>();
        //将JSON格式转换为java对象
        for (SearchHit hit:hits) {
            T res = JSON.parseObject(hit.getSourceAsString(), clazz);
            data.add(res);
            //获得所有的高亮字段
            Map<String, HighlightField> hFields = hit.getHighlightFields();
            for (String hfield:hFields.keySet()) {
                //获得反射字段
                try {
                    Field declaredField = clazz.getDeclaredField(hfield);
                    //将字段的值替换成带高亮效果的属性值
                    declaredField.setAccessible(true);
                    Text[] fragments = hFields.get(hfield).fragments();
                    if(declaredField != null && fragments.length>0){
                        declaredField.set(res,fragments[0].string());
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }
        //返回分页数据
        return new PageEntity<>(from,response.getHits().getTotalHits().value,size,data);
    }

    //添加或更新数据
    public void savaOrUpdate(String indexName,ElasticEntity entity) throws IOException {
        IndexRequest request = new IndexRequest(indexName);
        request.id(entity.getId()).source(JSON.toJSONString(entity.getData()),XContentType.JSON);
        IndexResponse respose = client.index(request, RequestOptions.DEFAULT);
        log.info("{}添加或更新数据成功",indexName, JSON.toJSONString(respose));

    }

    //通过条件删除对象
    public void deleteByQuery(String indexName, QueryBuilder builder) throws IOException {
        DeleteByQueryRequest request = new DeleteByQueryRequest(indexName);
        request.setQuery(builder);
        BulkByScrollResponse respose = client.deleteByQuery(request, RequestOptions.DEFAULT);
        log.info("{}删除数据成功",indexName, JSON.toJSONString(respose));
    }
}
