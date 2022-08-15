<template>
    <div>
        <el-table
                :data="promotionAdData"
                style="width: 100%">
            <el-table-column
                    width="80"
                    align="center"
                    label="ID"
                    prop="id"
            >
            </el-table-column>

            <el-table-column
                    align="center"
                    label="广告名"
                    prop="name"
            >
            </el-table-column>

            <el-table-column
                    align="center"
                    label="广告区域名"
                    prop="promotionSpace.name"
            >
            </el-table-column>

            <el-table-column
                    align="center"
                    label="图片"
                    prop="img"
                    width="80"

            >
                <template slot-scope="scope">
                    <img :src="scope.row.img" height="80" width="100">
                </template>

            </el-table-column>

            <el-table-column
                    align="center"
                    width="160"
                    label="开始时间"
                    prop="startTime"
            >
            </el-table-column>
            <el-table-column
                    align="center"
                    width="160"
                    label="结束时间"
                    prop="startTime"
            >
            </el-table-column>
            <el-table-column
                    align="center"
                    label="创建时间"
                    width="160"
                    prop="createTime"
            >
            </el-table-column>
            <el-table-column
                    align="center"
                    width="160"
                    label="修改时间"
                    prop="updateTime"
            >
            </el-table-column>


            <el-table-column label="操作"
                             align="center">

                <template slot-scope="scope">
                    <el-button
                            size="mini"
                            type="success"
                            @click="handleAdd(scope.$index, scope.row)">新增</el-button>
                    <el-button
                            size="mini"
                            type="primary"
                            @click="handleEdit(scope.$index, scope.row)">修改</el-button>
                    <el-button
                            size="mini"
                            type="danger"
                            @click="handleDelete(scope.$index, scope.row)">删除</el-button>
                </template>
            </el-table-column>
        </el-table>

        <el-dialog :title="title" :visible.sync="dialogFormVisible">
            <el-form :model="promotionAd">

                <el-form-item label="广告名称" >
                    <el-input v-model="promotionAd.name" autocomplete="off"></el-input>
                </el-form-item>

                <el-form-item label="图片" v-model="promotionAd.img">

                    <el-upload
                    class="uploader"
                    :show-file-list="imgFlag"
                    :headers="headers"
                    action="http://localhost:9999/upload"
                    :on-success="handleAvatarSuccess">

                    <img v-if="promotionAd.img" :src="promotionAd.img" class="avatar">
                    <i v-else class="el-icon-plus avatar-uploader-icon"></i>
                    </el-upload>

                </el-form-item>

                <el-form-item label="时间" >
                    <template>
                        <span class="demonstration"></span>
                        <el-date-picker
                                v-model="time"
                                value-format="yyyy-MM-dd HH:mm:ss"
                                type="datetimerange"
                                range-separator="至"
                                start-placeholder="开始日期"
                                end-placeholder="结束日期">
                        </el-date-picker>
                    </template>

                </el-form-item>



            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button type="danger" @click="cancel">取消</el-button>
                <el-button type="primary" @click="saveFrom">保存</el-button>

            </div>

        </el-dialog>

        <br>

        <el-pagination
                @size-change="handleSizeChange"
                @current-change="handleCurrentChange"
                :current-page="current"
                :page-sizes="[2, 5, 10, 15]"
                :page-size="size"
                layout="total, sizes, prev, pager, next, jumper"
                :total="total">
        </el-pagination>
    </div>
</template>

<script>

    export default {
        name: "PromotionAd",
        data(){
            return{

                headers:{
                    "Authorization":localStorage.getItem("token")
                },
                imgFlag:false,
                promotionAdData:[],
                promotionAd:{id:"-1",name:"",spaceId:"",keyword:"",htmlContent:"",text:"",link:"",startTime:"",
                    endTime:"",createTime:"",updateTime:"",status:"",priority:"",img:""},
                dialogFormVisible : false,
                current:1,
                size:5,
                total:1,
                title:"",
                time:""

            }
        },
        methods:{
            //上传图片
            handleAvatarSuccess(res, file){
                console.log(res)
                this.promotionAd.img = res
            },
            handleSizeChange(val) {
                this.size = val
                this.loadList(this.current);
                console.log(`每页 ${val} 条`);
            },
            handleCurrentChange(val) {
                this.current = val
                this.loadList(this.current);
                console.log(`当前页: ${val}`);
            },
            loadList(){
                this.axios.get("/promotionadlist/"+this.current+"/"+this.size)
                    .then(res => {
                        console.log(res.data);
                        this.promotionAdData = res.data.records;
                        this.total = res.data.total;
                    })
            },
            //保存按钮
            saveFrom() {
                //新增
                if(this.promotionAd.id == -1){
                    console.log(this.promotionAd)
                    console.log(this.time)
                    this.promotionAd.id = '';
                    this.promotionAd.startTime=this.time[0]
                    this.promotionAd.endTime=this.time[1]

                    console.log(this.promotionAd)
                    this.axios.post("/promotionad/",
                        this.qs.stringify(this.promotionAd))
                        .then(res => {
                            console.log(res.data);
                            if(res.data == "ok"){
                                this.$message({
                                    message: '添加成功',
                                    type: 'success',
                                    duration:2000   //显示时间, 毫秒。
                                });
                                this.loadList(this.current);
                            }
                        })
                }else {
                    this.axios.put("/promotionad/",
                        this.promotionAd)
                        .then(res => {
                            console.log(res);
                            if(res.data == "ok"){
                                this.$message({
                                    message: '修改成功',
                                    type: 'success',
                                    duration:2000   //显示时间, 毫秒。
                                });
                                this.loadList(this.current);
                            }
                        })

                }
                this.reform();
                this.dialogFormVisible = false

            },
            //重置
            reform(){
                this.promotionAd ={id:"-1",name:"",spaceId:"",keyword:"",htmlContent:"",text:"",link:"",startTime:"",
                    endTime:"",createTime:"",updateTime:"",status:"",priority:"",img:""}
                this.title = ""

            },
            //取消按钮
            cancel() {
                this.reform();
                this.dialogFormVisible = false;

            },
            //新增
            handleAdd(index, row) {
                console.log(index, row);
                this.title="新增广告信息"
                this.dialogFormVisible = true;

            },
            //修改
            handleEdit(index, row) {
                this.promotionAd = JSON.parse(JSON.stringify(row));
                this.title="修改广告信息"
                this.dialogFormVisible = true;


            },
            //删除
            handleDelete(index, row) {
                console.log(index, row);
                this.$confirm('确定删除' + row.name + '这一项数据吗?', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    this.axios.delete("/promotionad/" + row.id
                    ).then(result => {
                        if(result.data =='ok'){
                            this.$message({
                                type: 'success',
                                message: '删除成功!'
                            })

                            // 刷新当前页
                            this.loadList(this.current);
                        }

                    })
                }).catch(() => {
                    this.$message({
                        type: 'info',
                        message: '已取消删除'
                    })
                })
            },
        },
        created() {
            this.loadList(this.current)
        }
    }
</script>

<style scoped>
    .uploader .el-upload {
        border: 1px dashed #d9d9d9;
        border-radius: 6px;
        cursor: pointer;
        position: relative;
        overflow: hidden;
    }
    .uploader .el-upload:hover {
        border-color: #409EFF;
    }

    .avatar {
        width: 178px;
        height: 178px;
        display: block;
    }
</style>