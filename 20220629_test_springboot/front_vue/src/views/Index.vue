<template>
    <div>
        <!--表单对话框-->
        <div style="text-align: left" >
            <el-button type="primary" style="height: 35px ;"@click="dialogFormVisible = true">
                新增文章<i class="el-icon-upload el-icon--right" ></i>
            </el-button></div>

        <el-dialog title="文章信息" :visible.sync="dialogFormVisible">
            <el-form :model="article">
<!--                <el-form-item label="文章id" >-->
<!--                    <el-input v-model="article.articleId" autocomplete="off"></el-input>-->
<!--                </el-form-item>-->
                <el-form-item label="文章标题" >
                    <el-input v-model="article.title" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="文章内容" >
                    <el-input v-model="article.articleContent" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="发表时间" >
                    <el-input v-model="article.releaseTime" autocomplete="off"></el-input>
                </el-form-item>
<!--                <el-form-item label="评论id" >-->
<!--                    <el-input v-model="article.comments.id" autocomplete="off"></el-input>-->
<!--                </el-form-item>-->
<!--                <el-form-item label="评论内容" >-->
<!--                    <el-input v-model="article.comments.content" autocomplete="off"></el-input>-->
<!--                </el-form-item>-->
<!--                <el-form-item label="评论时间" >-->
<!--                    <el-input v-model="article.comments.time" autocomplete="off"></el-input>-->
<!--                </el-form-item>-->

            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button type="primary" @click="saveLogistics()">保存</el-button>
            </div>
        </el-dialog>

        <!--评论数据-->
        <el-dialog title="评论信息" :visible.sync="dialogFormVisible1">
            <el-form :model="article">

                <el-form-item label="评论id" >
                    <el-input v-model="article.comments.id" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="评论内容" >
                    <el-input v-model="article.comments.content" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="评论时间" >
                    <el-input v-model="article.comments.time" autocomplete="off"></el-input>
                </el-form-item>

            </el-form>

            <div slot="footer" class="dialog-footer">
                <el-button type="primary" @click="saveLogistics()">保存</el-button>
            </div>
        </el-dialog>
        <!--数据表格-->
        <el-table
                :data="articles"
                style="width: 100%">
            <el-table-column
                    width="100px"
                    label="文章id">
                <template slot-scope="scope">
                    <span style="margin-left: 10px">{{ scope.row.articleId }}</span>
                </template>
            </el-table-column>
            <el-table-column
                    width="200px"
                    label="文章标题">
                <template slot-scope="scope">
                    <span style="margin-left: 10px">{{ scope.row.title }}</span>
                </template>
            </el-table-column>
            <el-table-column
                    label="文章内容">
                <template slot-scope="scope">
                    <span style="margin-left: 10px">{{ scope.row.articleContent }}</span>
                </template>
            </el-table-column>

            <el-table-column
                    width="250px"
                    label="发表时间">
                <template slot-scope="scope">
                    <span style="margin-left: 10px">{{ scope.row.releaseTime }}</span>
                </template>
            </el-table-column>
<!--            <el-table-column-->
<!--                    label="评论id">-->
<!--                <template slot-scope="scope">-->
<!--                    <span style="margin-left: 10px">{{ scope.row.comments.id }}</span>-->
<!--                </template>-->
<!--            </el-table-column>-->
<!--            <el-table-column-->
<!--                    label="评论内容">-->
<!--                <template slot-scope="scope">-->
<!--                    <span style="margin-left: 10px">{{ scope.row.comments.content}}</span>-->
<!--                </template>-->
<!--            </el-table-column>-->
<!--            <el-table-column-->
<!--                    label="评论时间">-->
<!--                <template slot-scope="scope">-->
<!--                    <span style="margin-left: 10px">{{ scope.row.comments.time }}</span>-->
<!--                </template>-->
<!--            </el-table-column>-->


            <el-table-column label="操作">
                <template slot-scope="scope">
                    <el-button
                            size="mini"
                            @click="handleComent(scope.$index, scope.row)">查看评论</el-button>
                    <el-button
                            size="mini"
                            @click="handleEditComent(scope.$index, scope.row)">添加评论</el-button>
                    <el-button
                            size="mini"
                            @click="handleEdit(scope.$index, scope.row)">编辑文章</el-button>
                    <el-button
                            size="mini"
                            type="danger"
                            @click="handleDelete(scope.$index, scope.row)">删除文章</el-button>
                </template>
            </el-table-column>
        </el-table>
    </div>
</template>

<script>
    export default {
        name: "Index",
        data(){
            return{
                articles:[],
                article:{articleId:"-1",title:"",articleContent:"",releaseTime:"",comments:""},
                dialogFormVisible : false,
                dialogFormVisible1:false,
            }
        },
        methods:{
            loadarticle(){
                this.axios.get("http://localhost:8080/articleList")
                    .then(res => {
                        console.log(res.data);
                        this.articles = res.data;
                    });
            },
            saveLogistics(){
                if(this.article.articleId == -1){
                    this.axios.post("http://localhost:8080/article",
                        this.qs.stringify(this.article))
                        .then(res => {
                            console.log(res.data);
                            if(res.data == "ok"){
                                this.$message({
                                    message: '添加成功',
                                    type: 'success',
                                    duration:2000   //显示时间, 毫秒。
                                });
                                this.loadarticle();
                            }
                        });
                }else{
                    this.axios.put("http://localhost:8080/article",
                        this.article)
                        .then(res => {
                            console.log(res);
                            if(res.data == "ok"){
                                this.$message({
                                    message: '修改成功',
                                    type: 'success',
                                    duration:2000   //显示时间, 毫秒。
                                });
                                this.loadarticle();
                            }
                        });
                }
                this.dialogFormVisible = false;
            },
            handleEdit(index,row){
                this.article = JSON.parse(JSON.stringify(row));
                this.dialogFormVisible = true;
            },
            handleDelete(index,row){
                if(confirm("是否删除？")){
                    this.axios.delete("http://localhost:8080/article/" + row.articleId)
                        .then(res => {
                            if(res.data =="ok"){
                                this.loadarticle();
                            }
                        })
                }
            },

            //查看评论
            handleComent(index,row){
                this.article = JSON.parse(JSON.stringify(row));
                this.dialogFormVisible1 = true;
            },

            //修改评论
            handleEditComent(index,row){

            },
        },
        created() {
            this.loadarticle();
        }
    }
</script>

<style scoped>

</style>