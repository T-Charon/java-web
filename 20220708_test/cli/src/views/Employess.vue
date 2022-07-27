<template>
    <div class="app-container">
        <!--模糊查询表单-->
        <el-form :inline="true" :model="formInline" class="demo-form-inline"  size="mini">

            <el-form-item label="部门名称：" >
                <el-select v-model="formInline.deptId" placeholder="请选择"    >
                    <el-option
                            v-for="item in options"
                            :key="item.deptId"
                            :label="item.deptName"
                            :value="item.deptId"
                    >
                    </el-option>
                </el-select>
            </el-form-item>


            <el-form-item label="姓名">
                <el-input v-model="formInline.name" placeholder="请输入姓名" clearable ></el-input>
            </el-form-item>

            <el-form-item>
                <el-button type="primary" icon="el-icon-search"  @click="onSubmit" >搜索</el-button>
                <el-button  icon="el-icon-refresh"  @click="reset" >重置</el-button>
            </el-form-item>
        </el-form>

        <!-- 表单对话框 -->
        <el-button type="text" @click="dialogFormVisible = true"></el-button>
        <el-dialog title="人员信息" :visible.sync="dialogFormVisible"  style="width: 920px">

            <el-form :model="employe"  style="width: 320px">

                <el-form-item label="部门" :label-width="formLabelWidth">
                    <el-select v-model="employe.deptId" placeholder="请选择"    >
                        <el-option
                                v-for="item in options"
                                :key="item.deptId"
                                :label="item.deptName"
                                :value="item.deptId"
                        >
                        </el-option>

                    </el-select>
                </el-form-item>


                <el-form-item label="姓名" :label-width="formLabelWidth" >
                    <el-input v-model="employe.name" autocomplete="off" ></el-input>
                </el-form-item>

                <el-form-item label="年龄" :label-width="formLabelWidth" >
                    <el-input v-model="employe.age" autocomplete="off" ></el-input>
                </el-form-item>

                <el-form-item label="性别" :label-width="formLabelWidth">
                    <template>
                        <el-radio v-model="employe.sex" label="男">男</el-radio>
                        <el-radio v-model="employe.sex" label="女">女</el-radio>
                    </template>
                </el-form-item>


                <el-form-item label="家庭住址" :label-width="formLabelWidth">
                    <el-input v-model="employe.address"></el-input>
                </el-form-item>

                <el-form-item label="入职日期" :label-width="formLabelWidth">
                    <div class="block">
                        <el-date-picker
                                v-model="employe.commencementDate"
                                type="date"
                                placeholder="选择日期">
                        </el-date-picker>
                    </div>
                </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button type="primary" @click="save()" >保存</el-button>
                <el-button type="danger" @click="cancel()" >取消</el-button>
            </div>
        </el-dialog>


        <!--数据表格-->
        <el-table
                :data="employes"
                border
                style="width: 100%">
            <el-table-column
                    fixed
                    prop="id"
                    label="编号"
                    width="100">
            </el-table-column>
            <el-table-column
                    prop="name"
                    label="名字"
            >
            </el-table-column>
            <el-table-column
                    prop="age"
                    label="年龄"
            >
            </el-table-column>

            <el-table-column
                    prop="sex"
                    label="性别"
            >
            </el-table-column>
            <el-table-column
                    prop="commencementDate"
                    label="入职日期"
            >
            </el-table-column>
            <el-table-column
                    prop="address"
                    label="家庭住址"
            >
            </el-table-column>
            <el-table-column
                    prop="deptName"
                    label="所属部门"
            >
            </el-table-column>

            <el-table-column label="操作" align="center" class-name="small-padding "
                             width="280">
                <template slot-scope="scope" >
                    <el-button
                            size="mini"
                            type="primary"
                            icon="el-icon-upload el-icon--right"
                            @click="dialogFormVisible = true">
                        新增</el-button>
                    <el-button
                            size="mini"
                            type="success"
                            icon="el-icon-edit"
                            @click="handleEdit(scope.$index, scope.row)">
                        修改</el-button>
                    <el-button
                            size="mini"
                            type="danger"
                            icon="el-icon-delete"
                            @click="handleDelete(scope.$index, scope.row)"
                    >删除</el-button>

                </template>
            </el-table-column>

        </el-table>

    </div>
</template>

<script>
    export default {
        name: "Employess",
        data(){
            return{
                formInline:{
                    deptId:'',
                    name:'',
                    deptName:''
                },

                employes: [],  //人员集合
                dialogFormVisible: false,  //对话框是否显示
                //表单商品对象
                employe:{
                    id:-1 ,   //设置默认值为-1（若为-1表示新增）
                    name:'',
                    age:'',
                    sex:'',
                    commencementDate:'',
                    address:'',
                    deptId:'',
                    deptName:''
                },

                //菜单下拉框
                options:{
                    value:'',
                    label:''
                },
                formLabelWidth: '120px'
            }
        },
        methods: {
            //模糊查询提交按钮
            onSubmit() {
                this.loadEmployessList()

            },
            //重置按钮
            reset() {
                this.formInline = {
                    deptId:'',
                    deptName: '',
                    name: ''
                }
            },



            //查询数据
            loadEmployessList() {
                this.axios.get("http://localhost:8080/employess",
                {
                    params: {
                        deptId:this.formInline.deptId,
                        name: this.formInline.name,
                    }
                }).then(result => {
                        console.log(result.data)
                        //处理后台数据
                        this.employes = result.data;

                    })
            },
            //取消按钮
            cancel(){
                this.employe={
                    id:-1 ,   //设置默认值为-1（若为-1表示新增）
                    name:'',
                    age:'',
                    sex:'',
                    commencementDate:'',
                    address:'',
                    deptId:'',
                    deptName:''
                },
                    this.loadEmployessList();
                //关闭表单
                this.dialogFormVisible = false;
            },

            //保存按钮
            save(){
                //添加订单信息
                if(this.employe.id == -1){
                    this.employe = this.qs.stringify(this.employe);
                    this.axios.post("http://localhost:8080/employess",this.employe
                    ).then(result =>{
                        console.log(result.data)
                        if(result.data == "ok"){
                            console.log('新增')
                            this.$message({
                                message: '添加成功',
                                type: 'success',
                                duration:2000   //显示时间, 毫秒。
                            });
                                this.employe={
                                    id:-1 ,   //设置默认值为-1（若为-1表示新增）
                                    name:'',
                                    age:'',
                                    sex:'',
                                    commencementDate:'',
                                    address:'',
                                    deptId:'',
                                    deptName:''
                            },
                                this.loadEmployessList()
                        }


                    })
                }else{
                    //修改
                    this.employe = this.qs.stringify(this.employe)
                    this.axios.put("http://localhost:8080/employess", this.employe
                    ).then(result =>{
                        if(result.data == "ok"){
                            console.log('修改')
                            this.$message({
                                message: '修改成功',
                                type: 'success',
                                duration:2000   //显示时间, 毫秒。
                            });
                            this.employe={
                                id:-1 ,   //设置默认值为-1（若为-1表示新增）
                                name:'',
                                age:'',
                                sex:'',
                                commencementDate:'',
                                address:'',
                                deptId:'',
                                deptName:''
                            },

                                //刷新页面
                                this.loadEmployessList()
                        }
                    })
                }
                //关闭表单
                this.dialogFormVisible = false;

            },


            //更新回填
            handleEdit(index, row) {
                this.dialogFormVisible = true;
                this.employe = JSON.parse(JSON.stringify(row));  //将row对象解析后赋值给表单对象
                console.log(index,row)

            },
            //删除
            handleDelete(index, row) {
                this.good = this.qs.stringify(this.good);
                console.log(index, row);
                this.axios.delete("http://localhost:8080/employess/" +row.id)
                    .then(result => {
                        console.log("刷新")
                        if (result.data == "ok") {
                            this.$message({
                                message: '删除成功',
                                type: 'success',
                                duration: 2000   //显示时间, 毫秒。
                            });
                            //刷新页面
                            this.loadEmployessList();
                        }
                    })
            }
        },

        /* 钩子函数，在Vue创建实例后执行*/
        created(){
            //查询人员信息
            this.loadEmployessList();
            //查询部门信息
            this.axios.get("http://localhost:8080/dept" )
                .then(result => {
                    this.options = result.data;
                    console.log(this.options)
                })
        },
    }
</script>