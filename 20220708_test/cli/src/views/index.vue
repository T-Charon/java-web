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

            <el-form :model="order"  style="width: 320px">

                    <el-form-item label="商品名称" :label-width="formLabelWidth">
                    <el-select v-model="order.productId" placeholder="请选择"     @change="showInfo" >
                             <el-option
                                     v-for="item in options"
                                     :key="item.productId"
                                     :label="item.name"
                                     :value="item.productId"
                             >
                              </el-option>

                    </el-select>
                </el-form-item>


                <el-form-item label="商品价格" :label-width="formLabelWidth" >
                    <el-input v-model="order.product.price"  autocomplete="off" :disabled="true" ></el-input>
                </el-form-item>

                <el-form-item label="商品类型" :label-width="formLabelWidth" >
                    <el-input v-model="order.product.type" autocomplete="off" :disabled="true"></el-input>
                </el-form-item>

                <el-form-item label="购买用户" :label-width="formLabelWidth" >
                    <el-input v-model="order.userId" autocomplete="off" ></el-input>
                </el-form-item>

                <el-form-item label="购买数量" :label-width="formLabelWidth">
                    <el-input-number v-model="order.num" @change="handleChange" :min="1" :max="9999" ></el-input-number>
                </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button type="primary" @click="save()" >保存</el-button>
            </div>
        </el-dialog>

        <!--数据表格-->
        <el-table
                :data="orders"
                border
                style="width: 100%">
            <el-table-column
                    fixed
                    prop="id"
                    label="id"
                    width="120">
            </el-table-column>
            <el-table-column
                    prop="product.name"
                    label="商品名称"
                    >
            </el-table-column>
            <el-table-column
                    prop="product.type"
                    label="商品类型"
                    >
            </el-table-column>
            <el-table-column
                    prop="product.price"
                    label="商品价格"
                    >
            </el-table-column>
            <el-table-column
                    prop="num"
                    label="商品数量"
                    >
            </el-table-column>
            <el-table-column
                    prop="time"
                    label="购买时间"
                   >
            </el-table-column>
            <el-table-column
                    prop="userId"
                    label="购买用户"
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

        <el-pagination
                @size-change="handleSizeChange"
                @current-change="handleCurrentChange"
                :current-page="current"
                :page-sizes="[2,5, 10, 20, 40]"
                :page-size="size"
                layout="total, sizes, prev, pager, next, jumper"
                :total="total">
        </el-pagination>


    </div>
</template>

<script>
    export default {
        name: "index",
        data(){
            return{
                total:0,    //总数
                current:1,  //当前页
                size:2,     //条数
                orders: [],  //商品集合
                dialogFormVisible: false,  //对话框是否显示
                //表单商品对象
                order:{
                    id:"-1",        //设置默认值为-1（若为-1表示新增）
                    product:{
                        name:"",
                        type:"",
                        price:""
                    },
                    productId:"",
                    num:"1",
                    userId:"",
                    deleteFlag:"0"
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

            //数量计数器
            handleChange(value) {
                console.log(value);
            },

            //下拉菜单与输入框联动
            showInfo(){
                for (let i = 0; i < this.options.length; i++) {
                    if(this.order.productId == this.options[i].productId){
                        this.order.product.type = this.options[i].type
                        this.order.product.price = this.options[i].price
                        break;
                    }
                }
            },

            //分页
            handleSizeChange(val) {
                console.log(`每页 ${val} 条`);
                this.size = val;
                this.loadOrdersList(this.current)
            },
            handleCurrentChange(val) {
                console.log(`当前页: ${val}`);
                this.current = val;
                this.loadOrdersList(this.current)
            },
            //查询分页数据
            loadOrdersList(current) {
                this.axios.get("http://localhost:8080/ordersList/" + this.current + "/" + this.size)
                    .then(result => {
                        console.log(result.data.records)
                        //处理后台数据
                        this.orders = result.data.records;
                        this.total = result.data.total;
                        this.current = result.data.current;
                    })
            },

            //保存按钮
            save(){
                //添加订单信息
                if(this.order.id == "-1"){
                    this.order = this.qs.stringify(this.order);
                    this.axios.post("http://localhost:8080/orders",this.order
                        ).then(result =>{
                            console.log(result.data)
                            if(result.data == "ok"){
                                this.$message({
                                    message: '添加成功',
                                    type: 'success',
                                    duration:2000   //显示时间, 毫秒。
                                });
                            }
                            this.loadOrdersList(this.current)
                        })
                }else{
                    //修改
                    this.order = this.qs.stringify(this.order)
                    this.axios.put("http://localhost:8080/orders", this.order
                        ).then(result =>{
                            if(result.data == "ok"){
                                this.$message({
                                    message: '修改成功',
                                    type: 'success',
                                    duration:2000   //显示时间, 毫秒。
                                });
                                //刷新页面
                                this.loadOrdersList(this.current)
                            }
                        })
                }
                //清空表单
                this.order={
                    id:"-1",        //设置默认值为-1（若为-1表示新增）
                    product:{
                        name:"",
                        type:"",
                        price:""
                    },
                    num:""
                },
                //关闭表单
                this.dialogFormVisible = false;
            },

            //更新回填
            handleEdit(index, row) {
                this.dialogFormVisible = true;
                this.order = JSON.parse(JSON.stringify(row));  //将row对象解析后赋值给表单对象
                console.log(index,row)

            },
            //逻辑删除
            handleDelete(index, row) {
                this.order = this.qs.stringify(this.order);
                console.log(index, row);
                this.axios.delete("http://localhost:8080/orders/" +row.id)
                    .then(result => {
                        console.log("刷新")
                        if (result.data == "ok") {
                            this.$message({
                                message: '删除成功',
                                type: 'success',
                                duration: 2000   //显示时间, 毫秒。
                            });
                            //刷新页面
                            this.loadOrdersList(this.current);
                        }
                    })
            }
        },

        /* 钩子函数，在Vue创建实例后执行*/
        created(){
            //查询商品+订单所有数据
            this.loadOrdersList(this.current);
            //查询商品信息
            this.axios.get("http://localhost:8080/product" )
                .then(result => {
                    this.options = result.data;
                    console.log(this.options)
                })
        },
    }
</script>

