<template>

    <div >
        <div style="text-align: left" >
            <el-button type="primary" style="height: 35px ;"@click="dialogFormVisible = true">
                新增商品<i class="el-icon-upload el-icon--right" ></i>
            </el-button></div>

        <!-- 表单对话框 -->
        <el-button type="text" @click="dialogFormVisible = true"></el-button>
        <el-dialog title="商品信息" :visible.sync="dialogFormVisible">
            <el-form :model="product">
                <el-form-item label="商品名称" :label-width="formLabelWidth">
                    <el-input v-model="product.productName" autocomplete="off"></el-input>
                </el-form-item>

                <el-form-item label="商品图片" :label-width="formLabelWidth">
                    <el-input v-model="product.productImage" autocomplete="off"></el-input>
                </el-form-item>

                <el-form-item label="商品价格" :label-width="formLabelWidth">
                    <el-input v-model="product.price" autocomplete="off"></el-input>
                </el-form-item>

                <el-form-item label="商品类型" :label-width="formLabelWidth">
                    <el-input v-model="product.productType" autocomplete="off"></el-input>
                </el-form-item>

                <el-form-item label="商品品牌" :label-width="formLabelWidth">
                    <el-input v-model="product.productBrand" autocomplete="off"></el-input>
                </el-form-item>

                <el-form-item label="商品描述" :label-width="formLabelWidth">
                    <el-input v-model="product.productDesc" autocomplete="off"></el-input>
                </el-form-item>



            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button type="primary" @click="save()" >保存</el-button>
            </div>
        </el-dialog>

        <!--数据表格-->
        <template>
            <el-table
                    :data="products"
                    border
                    style="width: 100%">
                <el-table-column
                        fixed
                        prop="id"
                        label="id"
                        width="120">
                </el-table-column>
                <el-table-column
                        prop="productName"
                        label="商品名称"
                        width="250">
                </el-table-column>
                <el-table-column
                        prop="productImage"
                        label="商品图片"
                        width="120">
                    <template slot-scope="scope">
                        <!--                                        <span style="margin-left: 10px">{{ scope.row.brandImg }}</span>-->
                        <!--                    <img src="../assets/6d1d563c31fb48bb8e4018b03fe418fd.jpg">-->
                        <el-image :src="scope.row.productImage" ></el-image>
                    </template>
                </el-table-column>
                <el-table-column
                        prop="price"
                        label="商品价格"
                        width="120">
                </el-table-column>
                <el-table-column
                        prop="productType"
                        label="商品类型"
                        width="120">
                </el-table-column>

                <el-table-column
                        prop="productBrand"
                        label="商品品牌"
                        width="120">
                </el-table-column>
                <el-table-column
                        prop="productDesc"
                        label="商品描述"
                        width="300">
                </el-table-column>
                <el-table-column
                        prop="createTime"
                        label="创建时间"
                        width="120">
                </el-table-column>


                <el-table-column
                        fixed="right"
                        label="操作"
                        width="120">
                <template slot-scope="scope">
                    <el-row>
                        <el-button type="primary" icon="el-icon-edit" circle  @click="handleEdit(scope.$index, scope.row)"></el-button>
                        <el-button type="danger" icon="el-icon-delete" circle @click="handleDelete(scope.$index, scope.row)"></el-button>
                    </el-row>

                </template>
                </el-table-column>

            </el-table>
        </template>

        <div class="block">
            <span class="demonstration"></span>
            <el-pagination
                    @current-change="loadProductList"
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
        name: "Product.vue",
        data(){
            return{
                total:0,    //总数
                current:1,  //当前页
                pageSize:3,     //条数
                products: [],  //商品集合
                dialogFormVisible: false,  //对话框是否显示
                product:{
                    id:"-1",        //设置默认值为-1（若为-1表示新增）
                    productName:"",
                    productName:"",
                    productImage:"",
                    price:"",
                    productType:"",
                    productDesc:"",
                    createTime:"",
                    productBrand:"",

                },
                formLabelWidth: '80px'

            }
        },
        methods: {
            handleCurrentChange(val) {
                console.log(`当前页: ${val}`);
            },
            //查询分页数据
            loadProductList(current){
                //分页

                this.axios.get("http://localhost:8080/productListPage/"+this.current+"/"+this.pageSize)
                    .then(result =>{
                        console.log(result.data)
                        //处理后台数据(将后台result.data数据与users集合绑定)
                        this.products = result.data.records;
                        this.total = result.data.total;
                        this.current = result.data.current;

                    })
            },

            //保存人员信息
            save(){
                if(this.product.id == "-1"){

                    //新增
                    this.axios.post("http://localhost:8080/product",
                        this.qs.stringify(this.product))
                        .then(result =>{
                            console.log(result.data)
                            if(result.data == "ok"){
                                this.$message({
                                    message: '添加成功',
                                    type: 'success',
                                    duration:2000   //显示时间, 毫秒。
                                });
                            }
                            this.loadProductList(this.current)
                        })
                }else{
                    //修改
                    this.axios.put("http://localhost:8080/product", this.product)
                        .then(result =>{
                            console.log(result.data)
                            if(result.data == "ok"){
                                this.$message({
                                    message: '修改成功',
                                    type: 'success',
                                    duration:2000   //显示时间, 毫秒。
                                });
                                //刷新页面
                                this.loadProductList(this.current)
                            }
                        })

                }

                //清空表单
                this.product={ id:"-1",
                    productName:"",
                    productName:"",
                    productImage:"",
                    price:"",
                    productType:"",
                    productDesc:"",
                    createTime:"",
                    productBrand:"",}
                //关闭表单
                this.dialogFormVisible = false;
            },

            //更新回填
            handleEdit(index, row) {
                this.dialogFormVisible =true;
                this.product=JSON.parse(JSON.stringify(row));  //将row对象解析后赋值给表单对象

            },
            handleDelete(index, row) {


                console.log(index, row);
                this.axios.delete("http://localhost:8080/product/"+row.id)
                    .then(result =>{
                        console.log(result.data)
                        if(result.data == "ok" ){
                            this.$message({
                                message: '删除成功',
                                type: 'success',
                                duration:2000   //显示时间, 毫秒。
                            });
                            //刷新页面
                            this.loadProductList(this.current);

                        }
                    })

            }
        },
        /* 钩子函数，在Vue创建实例后执行*/
        created(){
            //查询所有数据
            this.loadProductList(this.current)
        }
    }
</script>

<style scoped>


</style>