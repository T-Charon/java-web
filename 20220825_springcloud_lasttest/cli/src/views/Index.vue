<template>
    <div >
        <el-table
                :data="positionData"
                style="width: 100%">
            <el-table-column
                    align="center"
                    label="职位ID"
                    prop="id"
            >
            </el-table-column>

            <el-table-column
                    align="center"
                    label="职位名称"
                    prop="dept.deptName"
            >
            </el-table-column>

            <el-table-column
                    align="center"
                    label="职位名称"
                    prop="positionName"
            >
            </el-table-column>

            <el-table-column
                    align="center"
                    label="岗位级别"
                    prop="jobLevel"
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
                            type="danger"
                            @click="handleDelete(scope.$index, scope.row)">删除</el-button>
                </template>
            </el-table-column>
        </el-table>
        <el-dialog title="添加职位" :visible.sync="dialogFormVisible">
            <el-form :model="position">
                <el-select v-model="position.deptId" placeholder="请选择">
                    <el-option v-for="item in depts"
                               :key="item.id"
                               :label="item.deptName"
                               :value="item.id">
                    </el-option>
                </el-select>


                <el-form-item label="职位名称" >
                    <el-input v-model="position.positionName" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="职位等级" >
                    <el-input v-model="position.jobLevel" autocomplete="off"></el-input>
                </el-form-item>



            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button type="danger" @click="cancel">取消</el-button>
                <el-button type="primary" @click="saveFrom">保存</el-button>

            </div>

        </el-dialog>


        <br>
        
    </div>

</template>

<script>
    export default {
        name: "Index",
        data(){
            return{
                depts:[],
                positionData:[],
                position:{id:"-1",deptId:"",positionName:"",jobLevel:""},
                dialogFormVisible : false,



            }
        },
        methods:{

            loadList(){
                this.axios.get("/position/list")
                    .then(res => {
                        console.log(res.data);
                        this.positionData = res.data

                    })
            },
            //保存按钮
            saveFrom() {
                //新增
                if(this.position.id == -1){
                    console.log(this.position)
                    this.position.id = '';
                    this.axios.post("/position/",
                        this.qs.stringify(this.position))
                        .then(res => {
                            console.log(res.data);
                            if(res.data == "ok"){
                                this.$message({
                                    message: '添加成功',
                                    type: 'success',
                                    duration:2000   //显示时间, 毫秒。
                                });
                                this.loadList();
                            }
                        })
                }
                this.reform();
                this.dialogFormVisible = false

            },
            //重置
            reform(){
                this.position= {id:"-1",deptId:"",positionName:"",jobLevel:""}

            },
            //取消按钮
            cancel() {
                this.reform();
                this.dialogFormVisible = false;

            },
            //新增
            handleAdd(index, row) {
                console.log(index, row);
                this.dialogFormVisible = true;

            },

            //删除
            handleDelete(index, row) {
                console.log(index, row);
                this.$confirm('确定删除这一项数据吗?', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    this.axios.delete("/position/" + row.id
                    ).then(result => {
                        if(result.data =='ok'){
                            this.$message({
                                type: 'success',
                                message: '删除成功!'
                            })

                            // 刷新当前页
                            this.loadList();
                        }

                    })
                }).catch(() => {
                    this.$message({
                        type: 'info',
                        message: '已取消删除'
                    })
                })


            },
            loadDept(){
                this.axios.get("/getAllDept")
                    .then(res => {
                        console.log(res);
                        this.depts = res.data

                    })
            }
        },
        created() {
            this.loadList()
            this.loadDept()
        }
    }
</script>


<style>
    .el-header {
        background-color: #B3C0D1;
        color: #333;
        line-height: 60px;
    }

    .el-aside {
        color: #333;
    }
</style>
