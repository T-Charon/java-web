<template>

    <div >
        <div style="text-align: left" >
            <el-button type="primary" style="height: 35px ;"@click="dialogFormVisible = true">
                新增物流<i class="el-icon-upload el-icon--right" ></i>
            </el-button></div>

        <!-- 表单对话框 -->
        <el-button type="text" @click="dialogFormVisible = true"></el-button>
        <el-dialog title="物流信息" :visible.sync="dialogFormVisible">
            <el-form :model="logistic">
                <el-form-item label="商品名" :label-width="formLabelWidth">
                    <el-input v-model="logistic.goodsId" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="数量" :label-width="formLabelWidth">
                    <el-input v-model="logistic.number" autocomplete="off"></el-input>
                </el-form-item>

                <el-form-item label="发货时间" :label-width="formLabelWidth">
                    <el-input v-model="logistic.deliveryTime" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="收货时间" :label-width="formLabelWidth">
                    <el-input v-model="logistic.arrivalTime" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="发货地址" :label-width="formLabelWidth">
                    <el-input v-model="logistic.addressDeliveryId" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="收货地址" :label-width="formLabelWidth">
                    <el-input v-model="logistic.addressArrivalId" autocomplete="off"></el-input>
                </el-form-item>

            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button type="primary" @click="save()" >保存</el-button>
            </div>
        </el-dialog>

        <!--数据表格-->
        <el-table
                :data="logistics"
                style="width: 100%  ">
            <el-table-column
                    width="120px"
                    label="id">
                <template slot-scope="scope">
                    <span style="margin-left: 10px">{{ scope.row.id }}</span>
                </template>
            </el-table-column>

            <el-table-column
                    width="120px"
                    label="商品名">
                <template slot-scope="scope">
                    <span style="margin-left: 10px">{{ scope.row.goodsId }}</span>
                </template>
            </el-table-column>

            <el-table-column
                    width="120px"
                    label="数量">
                <template slot-scope="scope">
                    <span style="margin-left: 10px">{{ scope.row.number }}</span>
                </template>
            </el-table-column>

            <el-table-column
                    width="200px"
                    label="发货时间">
                <template slot-scope="scope">
                    <span style="margin-left: 10px">{{ scope.row.deliveryTime }}</span>
                </template>
            </el-table-column>

            <el-table-column
                    width="200px"
                    label="到货时间">
                <template slot-scope="scope">
                    <span style="margin-left: 10px">{{ scope.row.arrivalTime }}</span>
                </template>
            </el-table-column>

            <el-table-column
                    width="200px"
                    label="发货地址">
                <template slot-scope="scope">
                    <span style="margin-left: 10px">{{ scope.row.addressDeliveryId }}</span>
                </template>
            </el-table-column>


            <el-table-column
                    width="200px"
                    label="到货地址">
                <template slot-scope="scope">
                    <span style="margin-left: 10px">{{ scope.row.addressArrivalId }}</span>
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


    </div>


</template>

<script>
    export default {
        name: "Index.vue",
        data(){
            return{
                logistics:[],
                dialogFormVisible: false,  //对话框是否显示
                logistic:{
                    id:"-1",        //设置默认值为-1（若为-1表示新增）
                   goodsId:"",
                   deliveryTime:"",
                   arrivalTime:"",
                   number:"",
                   addressDeliveryId:"",
                   addressArrivalId:""
               },
                formLabelWidth: '80px'

            }
        },
        methods: {

            //查询分页数据
            loadlogisticList(){
                console.log("123")
                this.axios.get("http://localhost:8080/list")
                    .then(result =>{
                        console.log(result.data)
                        //处理后台数据(将后台result.data数据与users集合绑定)
                        this.logistics = result.data

                    })
            },

            //保存人员信息
            save(){
                if(this.logistic.id == "-1"){
                    //新增
                    this.axios.post("http://localhost:8080/user",
                        this.qs.stringify(this.logistic))
                        .then(result =>{
                            console.log(result.data)
                            if(result.data.c == "ok"){
                                this.$message({
                                    message: '添加成功',
                                    type: 'success',
                                    duration:2000   //显示时间, 毫秒。
                                });

                            }
                            this.loadlogisticList()
                        })
                }else{
                    //修改
                    this.axios.put("http://localhost:8080/user", this.logistic)
                        .then(result =>{
                            console.log(result.data)
                            if(result.data.data== "ok"){
                                this.$message({
                                    message: '修改成功',
                                    type: 'success',
                                    duration:2000   //显示时间, 毫秒。
                                });

                                //刷新页面
                                this.loadlogisticList()
                            }

                        })

                }

                //清空表单
                this.logistic={id:"-1", username:"", password:"", type:""}
                //关闭表单
                this.dialogFormVisible = false;


            },

            //更新回填
            handleEdit(index, row) {
                this.dialogFormVisible =true;
                this.logistic=JSON.parse(JSON.stringify(row));  //将row对象解析后赋值给表单对象

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
                        }
                        this.loadlogisticList()


                    })

            }
        },
        /* 钩子函数，在Vue创建实例后执行*/
        created(){
            //查询所有数据
            this.loadlogisticList()
        }
    }
</script>

<style scoped>


</style>