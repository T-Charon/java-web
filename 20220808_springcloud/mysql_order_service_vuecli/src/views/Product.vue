<template>
    <div >
        <el-table
                :data="productData"
                style="width: 100%">
            <el-table-column
                    align="center"
                    label="商品ID"
                    prop="id"
                    >
            </el-table-column>

            <el-table-column
                    align="center"
                    label="商品名称"
                    prop="name"
                    >
            </el-table-column>

            <el-table-column
                    align="center"
                    label="商品价格"
                    prop="price"
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
            <el-form :model="product">

                <el-form-item label="商品名称" >
                    <el-input v-model="product.name" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="商品价格" >
                    <el-input v-model="product.price" autocomplete="off"></el-input>
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
        name: "Product",
        data(){
            return{
              productData:[],
              product:{id:"-1",name:"",price:""},
              dialogFormVisible : false,
              current:1,
              size:5,
              total:1,
              title:""

            }
        },
        methods:{
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
                this.axios.get("/productlist/"+this.current+"/"+this.size)
                    .then(res => {
                        console.log(res.data);
                        this.productData = res.data.records;
                        this.total = res.data.total;
                })
            },
            //保存按钮
            saveFrom() {
                //新增
                if(this.product.id == -1){
                    console.log(this.product)
                    this.product.id = '';
                    this.axios.post("/product/",
                        this.qs.stringify(this.product))
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
                    this.axios.put("/product/",
                        this.product)
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
                this.product ={id:"-1",name:"",price:""}
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
                this.title="新增商品"
                this.dialogFormVisible = true;

            },
            //修改
            handleEdit(index, row) {
                this.product = JSON.parse(JSON.stringify(row));
                this.title="修改商品"
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
                    this.axios.delete("/product/" + row.id
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

                // if(confirm("是否删除？")){
                //     this.axios.delete("http://localhost:9003/product/" + row.id)
                //         .then(res => {
                //             if(res.data =="ok"){
                //                 this.loadList(this.current);
                //             }
                //         })
                // }
            },
        },
        created() {
            this.loadList(this.current)
        }
    }
</script>

<style scoped>

</style>