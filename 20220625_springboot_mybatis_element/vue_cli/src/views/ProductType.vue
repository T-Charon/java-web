<template>

    <div >
        <div style="text-align: left" >
            <el-button type="primary" style="height: 35px ;"@click="dialogFormVisible = true">
                新增品牌类型<i class="el-icon-upload el-icon--right" ></i>
            </el-button></div>

        <!-- 表单对话框 -->
        <el-button type="text" @click="dialogFormVisible = true"></el-button>
        <el-dialog title="品牌类型信息" :visible.sync="dialogFormVisible" >
            <el-form ref="form" :model="productTypes" >
                <el-form-item label="品牌类型名称" :label-width="formLabelWidth">
                    <el-input v-model="productType.productTypeName" autocomplete="off"></el-input>
                </el-form-item>

                <el-form-item label="品牌类型描述" :label-width="formLabelWidth">
                    <el-input v-model="productType.productTypeDesc" autocomplete="off"></el-input>
                </el-form-item>

                <el-form-item label="类型图标" :label-width="formLabelWidth">
                    <el-input v-model="productType.productTypeIcon" autocomplete="off"></el-input>
                </el-form-item>

            </el-form>
                
            <div slot="footer" class="dialog-footer">
                <el-button type="primary" @click="save()" >保存</el-button>
            </div>
        </el-dialog>
        
        <!--数据表格-->
        <el-table
                :data="productTypes"
                style="width: 100%  ">
            <el-table-column
                    width="320px"
                    label="id">
                <template slot-scope="scope">
                    <span style="margin-left: 10px">{{ scope.row.id }}</span>
                </template>
            </el-table-column>

            <el-table-column
                    width="320px"
                    label="品牌类型名称">
                <template slot-scope="scope">
                    <span style="margin-left: 10px">{{ scope.row.productTypeName }}</span>
                </template>
            </el-table-column>

            <el-table-column
                    width="220px"
                    label="品牌类型描述">
                <template slot-scope="scope">
                    <span style="margin-left: 10px">{{ scope.row.productTypeDesc }}</span>
                </template>
            </el-table-column>

            <el-table-column
                    width="220px"
                    label="图标">
                <template slot-scope="scope">
                    <span style="margin-left: 10px">{{ scope.row.productTypeIcon }}</span>
                </template>
            </el-table-column>

            <el-table-column label="操作">
                <template slot-scope="scope">
                    <el-button
                            size="mini"
                            @click="handleEdit(scope.$index, scope.row)"><i class="el-icon-edit"/> 更新</el-button>
                    <el-button
                            size="mini"
                            type="danger"
                            @click="handleDelete(scope.$index, scope.row)"><i class="el-icon-delete"/> 删除</el-button>


                </template>
            </el-table-column>
        </el-table>

        <div class="block">
            <span class="demonstration"></span>
            <el-pagination
                    @current-change="loadProductTypeList"
                    :current-page.sync="current"
                    :page-size="pageSize"
                    layout="prev, pager, next, jumper"
                    :total="total">
            </el-pagination>
        </div>


    </div>


</template>

<script>
    export default {
        name: "ProductType.vue",
        data(){
            return{
                total:0,    //总数
                current:1,  //当前页
                pageSize:5,     //条数
                productTypes: [],  //品牌集合
                dialogFormVisible: false,  //对话框是否显示

                productType:{
                    id:"-1",        //设置默认值为-1（若为-1表示新增）
                    productTypeName:"",
                    productTypeDesc:"",
                    productTypeIcon:""},
                formLabelWidth: '80px',
               






            }
        },
        methods: {

            handleCurrentChange(val) {
                console.log(`当前页: ${val}`);
            },
            //查询分页数据
            loadProductTypeList(current){
                //分页

                this.axios.get("http://localhost:8080/productTypeListPage/"+this.current+"/"+this.pageSize)
                    .then(result =>{
                        console.log(result.data.data)
                        //处理后台数据(将后台result.data数据与users集合绑定)
                        this.productTypes = result.data.data.records;
                        this.total = result.data.data.total;
                        this.current = result.data.data.current;

                    })
            },

            //保存人员信息
            save(){
                if(this.productType.id == "-1"){
                    //新增
                    this.axios.post("http://localhost:8080/productType",
                        this.qs.stringify(this.productType))
                        .then(result =>{
                            console.log(result.data.data)
                            if(result.data.data == "ok"){
                                this.$message({
                                    message: '添加成功',
                                    type: 'success',
                                    duration:2000   //显示时间, 毫秒。
                                });

                            }
                            this.loadProductTypeList(this.current)
                        })
                }else{
                    //修改
                    this.axios.put("http://localhost:8080/productType", this.productType)
                        .then(result =>{
                            console.log(result.data.data)
                            if(result.data.data == "ok"){
                                this.$message({
                                    message: '修改成功',
                                    type: 'success',
                                    duration:2000   //显示时间, 毫秒。
                                });

                                //刷新页面
                                this.loadProductTypeList(this.current)
                            }

                        })

                }

                //清空表单
                this.productType={id:"-1", productTypeName:"", productTypeDesc:"", productTypeIcon:""}
                //关闭表单
                this.dialogFormVisible = false;


            },

            //更新回填
            handleEdit(index, row) {
                this.dialogFormVisible =true;
                this.productType=JSON.parse(JSON.stringify(row));  //将row对象解析后赋值给表单对象




            },
            handleDelete(index, row) {


                console.log(index, row);
                this.axios.delete("http://localhost:8080/productType/"+row.id)
                    .then(result =>{
                        console.log(result.data.data)
                        if(result.data == "ok" ){
                            this.$message({
                                message: '删除成功',
                                type: 'success',
                                duration:2000   //显示时间, 毫秒。
                            });
                            //刷新页面
                            this.loadProductTypeList(this.current);

                        }
                    })

            }
        },
        /* 钩子函数，在Vue创建实例后执行*/
        created(){
            //查询所有数据
            this.loadProductTypeList(this.current);
            // //查询所有品牌类型信息
            // this.axios.get("http://localhost:8080/productTypeName")
            //     .then(result =>{
            //         console.log(result.data)
            //         this.options = result.data;
            //
            //
            //     })
        }
    }
</script>

<style scoped>


</style>