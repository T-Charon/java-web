<template>

<div >
    <div style="text-align: left" >
        <el-button type="primary" style="height: 35px ;"@click="dialogFormVisible = true">
            新增用户<i class="el-icon-upload el-icon--right" ></i>
        </el-button></div>

    <!-- 表单对话框 -->
    <el-button type="text" @click="dialogFormVisible = true"></el-button>
    <el-dialog title="人员信息" :visible.sync="dialogFormVisible">
        <el-form :model="user">
            <el-form-item label="用户名" :label-width="formLabelWidth">
                <el-input v-model="user.username" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item label="密码" :label-width="formLabelWidth">
                <el-input v-model="user.password" autocomplete="off"></el-input>
            </el-form-item>

        </el-form>
        <div slot="footer" class="dialog-footer">
            <el-button type="primary" @click="save()" >保存</el-button>
        </div>
    </el-dialog>

    <!--数据表格-->
    <el-table
            :data="users"
            style="width: 100%  ">
        <el-table-column
                width="320px"
                label="id">
            <template slot-scope="scope">
                <span style="margin-left: 10px">{{ scope.row.id }}</span>
            </template>
        </el-table-column>

        <el-table-column
                width="120px"
                label="姓名">
            <template slot-scope="scope">
                <span style="margin-left: 10px">{{ scope.row.username }}</span>
            </template>
        </el-table-column>

        <el-table-column
                width="320px"
                label="密码">
            <template slot-scope="scope">
                <span style="margin-left: 10px">{{ scope.row.password }}</span>
            </template>
        </el-table-column>

        <el-table-column
                width="320px"
                label="用户类型">

            <template slot-scope="scope">
                <span style="margin-left: 10px" v-if="scope.row.id == 0">超级管理员</span>
                <span style="margin-left: 10px" v-else-if="scope.row.type == 0">管理员</span>
                <span style="margin-left: 10px" v-else>用户</span>
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
                @current-change="loadUserList"
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
        name: "User.vue",
        data(){
            return{
                total:0,    //总数
                current:1,  //当前页
                pageSize:5,     //条数
                users: [],  //人员集合
                dialogFormVisible: false,  //对话框是否显示
                user:{
                    id:"-1",        //设置默认值为-1（若为-1表示新增）
                    username:"",
                    password:"",
                    type:""},
                formLabelWidth: '80px'

            }
        },
        methods: {

            handleCurrentChange(val) {
                console.log(`当前页: ${val}`);
            },
            //查询分页数据
            loadUserList(current){
                //分页

                this.axios.get("http://localhost:8080/userListPage/"+this.current+"/"+this.pageSize)
                    .then(result =>{
                        console.log(result.data)
                        //处理后台数据(将后台result.data数据与users集合绑定)
                        this.users = result.data.records;
                        this.total = result.data.total;
                        this.current = result.data.current;

                    })
            },

            //保存人员信息
            save(){
                    if(this.user.id == "-1"){
                        //新增
                        this.axios.post("http://localhost:8080/user",
                            this.qs.stringify(this.user))
                            .then(result =>{
                                console.log(result.data)
                                if(result.data == "ok"){
                                    this.$message({
                                        message: '添加成功',
                                        type: 'success',
                                        duration:2000   //显示时间, 毫秒。
                                    });

                                }
                                this.loadUserList(this.current)
                            })
                    }else{
                        //修改
                        this.axios.put("http://localhost:8080/user", this.user)
                            .then(result =>{
                                console.log(result.data)
                                if(result.data == "ok"){
                                    this.$message({
                                        message: '修改成功',
                                        type: 'success',
                                        duration:2000   //显示时间, 毫秒。
                                    });

                                    //刷新页面
                                    this.loadUserList(this.current)
                                }

                            })

                    }

                //清空表单
                this.user={id:"-1", username:"", password:"", type:""}
                //关闭表单
                this.dialogFormVisible = false;


            },

            //更新回填
            handleEdit(index, row) {
                this.dialogFormVisible =true;
                this.user=JSON.parse(JSON.stringify(row));  //将row对象解析后赋值给表单对象

            },
            handleDelete(index, row) {


                console.log(index, row);
                this.axios.delete("http://localhost:8080/user/"+row.id)
                    .then(result =>{
                        console.log(result.data)
                        if(result.data == "ok" ){
                            this.$message({
                                message: '删除成功',
                                type: 'success',
                                duration:2000   //显示时间, 毫秒。
                            });
                        }else {
                            this.$message({
                                message: '超级管理员无法删除！！！',
                                type: 'error',
                                duration:2000   //显示时间, 毫秒。
                            });
                        }
                        //刷新页面

                        this.loadUserList(this.current)


                    })

            }
        },
       /* 钩子函数，在Vue创建实例后执行*/
        created(){
            //查询所有数据
            this.loadUserList(this.current)
        }
    }
</script>

<style scoped>


</style>