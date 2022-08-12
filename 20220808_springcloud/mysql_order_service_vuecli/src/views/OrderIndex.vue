<template>
    <div >
        <el-table
                :data="orderData"
                style="width: 100%">
            <el-table-column
                    align="center"
                    label="订单ID"
                    prop="id"
            >
            </el-table-column>

            <el-table-column
                    align="center"
                    label="商品名称"
                    prop="product.name"
            >
            </el-table-column>

            <el-table-column
                    align="center"
                    label="商品数量"
                    prop="count"
            >
            </el-table-column>

            <el-table-column
                    align="center"
                    label="创建时间"
                    prop="createTime"
            >
            </el-table-column>
            <el-table-column
                    align="center"
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
            <el-form :model="order">

                <el-form-item label="商品id" >
                    <el-input v-model="order.productId" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="商品数量" >
                    <el-input v-model="order.count" autocomplete="off"></el-input>
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
        name: "OrderIndex",
        data(){
            return{
                orderData:[],
                order:{id:"-1",productId:"",count:"",createTime:"",updateTime:""},
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
                this.axios.get("/orderlist/"+this.current+"/"+this.size)
                    .then(res => {
                        console.log(res.data);
                        this.orderData = res.data.records;
                        this.total = res.data.total;
                    })
            },
            //保存按钮
            saveFrom() {
                //新增
                if(this.order.id == -1){
                    console.log(this.order)
                    this.order.id = '';
                    this.axios.post("/order/",
                        this.qs.stringify(this.order))
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
                    this.axios.put("/order/",
                        this.order)
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
                this.order={id:"-1",productId:"",count:"",createTime:"",updateTime:""},
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
                this.order = JSON.parse(JSON.stringify(row));
                this.title="修改商品"
                this.dialogFormVisible = true;
            },
            //删除
            handleDelete(index, row) {
                console.log(index, row);
                this.$confirm('确定删除' + row.product.name + '这一项数据吗?', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    this.axios.delete("/order/" + row.id
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
