<template>
    <div class="app-container">
        <div style="text-align: left" >
            <el-button type="primary" style="height: 35px ;"@click="dialogFormVisible = true">
                新增订单<i class="el-icon-upload el-icon--right" ></i>
            </el-button>
        </div>

        <!-- 表单对话框 -->
        <el-button type="text" @click="dialogFormVisible = true"></el-button>
        <el-dialog title="订单信息" :visible.sync="dialogFormVisible"  style="width: 920px">

            <el-form :model="good"  style="width: 320px">

                <el-form-item label="主管编号" :label-width="formLabelWidth">
                    <el-select v-model="good.directorId" placeholder="请选择"    >
                        <el-option
                                v-for="item in options"
                                :key="item.id"
                                :label="item.director"
                                :value="item.id"
                        >
                        </el-option>

                    </el-select>
                </el-form-item>


                <el-form-item label="商品名称" :label-width="formLabelWidth" >
                    <el-input v-model="good.goodsName" autocomplete="off" ></el-input>
                </el-form-item>

                <el-form-item label="商品价格" :label-width="formLabelWidth" >
                    <el-input v-model="good.price" autocomplete="off" ></el-input>
                </el-form-item>

                <el-form-item label="进货单号" :label-width="formLabelWidth">
                    <el-input v-model="good.orderId"></el-input>
                </el-form-item>

                <el-form-item label="保质时间" :label-width="formLabelWidth">
                    <el-input v-model="good.time"   ></el-input>
                </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button type="primary" @click="save()" >保存</el-button>
            </div>
        </el-dialog>



        <!--数据表格-->
        <el-table
                :data="goods"
                border
                style="width: 100%">
            <el-table-column
                    fixed
                    prop="code"
                    label="条形码"
                    width="120">
            </el-table-column>
            <el-table-column
                    prop="goodsName"
                    label="商品名称"
            >
            </el-table-column>
            <el-table-column
                    prop="director"
                    label="主管编号"
            >
            </el-table-column>

            <el-table-column
                    prop="price"
                    label="商品价格"
            >
            </el-table-column>
            <el-table-column
                    prop="time"
                    label="保质时间"
            >
            </el-table-column>
            <el-table-column
                    prop="orderId"
                    label="进货单号"
            >
            </el-table-column>

            <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
                <template slot-scope="scope" >
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
        name: "goods",
        data(){
            return{

                goods: [],  //商品集合
                dialogFormVisible: false,  //对话框是否显示
                //表单商品对象
                good:{
                    code:-1 ,   //设置默认值为-1（若为-1表示新增）
                    director:'',
                    goodsName:'',
                    price:'',
                    orderId:'',
                    time:'',
                    directorId:''

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


            //查询数据
            loadGoodsList() {
                this.axios.get("http://localhost:8080/goods")
                    .then(result => {
                        console.log(result.data)
                        //处理后台数据
                        this.goods = result.data;

                    })
            },

            //保存按钮
            save(){
                //添加订单信息
                if(this.good.code == -1){
                    this.good = this.qs.stringify(this.good);
                    this.axios.post("http://localhost:8080/goods",this.good
                    ).then(result =>{
                        console.log(result.data)
                        if(result.data == "ok"){
                            console.log('新增')
                            this.$message({
                                message: '添加成功',
                                type: 'success',
                                duration:2000   //显示时间, 毫秒。
                            });
                            this.good={
                                code:-1 ,
                                director:'',
                                goodsName:'',
                                price:'',
                                orderId:'',
                                time:'',
                                directorId:''
                            },
                                this.loadGoodsList()
                        }


                    })
                }else{
                    //修改
                    this.good = this.qs.stringify(this.good)
                    this.axios.put("http://localhost:8080/goods", this.good
                    ).then(result =>{
                        if(result.data == "ok"){
                            console.log('修改')
                            this.$message({
                                message: '修改成功',
                                type: 'success',
                                duration:2000   //显示时间, 毫秒。
                            });
                            this.good={
                                code:-1,        //设置默认值为-1（若为-1表示新增）
                                director:'',
                                goodsName:'',
                                price:'',
                                orderId:'',
                                time:'',
                            },
                            //刷新页面
                            this.loadGoodsList()
                        }
                    })
                }
                    //关闭表单
                    this.dialogFormVisible = false;

            },


            //更新回填
            handleEdit(index, row) {
                this.dialogFormVisible = true;
                this.good = JSON.parse(JSON.stringify(row));  //将row对象解析后赋值给表单对象
                console.log(index,row)

            },
            //删除
            handleDelete(index, row) {
                this.good = this.qs.stringify(this.good);
                console.log(index, row);
                this.axios.delete("http://localhost:8080/goods/" +row.code)
                    .then(result => {
                        console.log("刷新")
                        if (result.data == "ok") {
                            this.$message({
                                message: '删除成功',
                                type: 'success',
                                duration: 2000   //显示时间, 毫秒。
                            });
                            //刷新页面
                            this.loadGoodsList();
                        }
                    })
            }
        },

        /* 钩子函数，在Vue创建实例后执行*/
        created(){
            //查询商品+主管信息
            this.loadGoodsList();
            //查询主管信息
            this.axios.get("http://localhost:8080/director" )
                .then(result => {
                    this.options = result.data;
                    console.log(this.options)
                })
        },
    }
</script>

