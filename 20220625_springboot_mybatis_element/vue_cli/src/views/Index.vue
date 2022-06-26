<template>


    <el-container style="height: 700px; border: 1px solid #eee">
        <el-aside width="200px" style="background-color:  rgb(238, 241, 246)">
            <el-menu >

                <el-menu-item > <i class="el-icon-shopping-bag-1"></i><span style="font-size: medium">京豆豆网上商城</span></el-menu-item>
                <el-submenu index="1">
                    <template slot="title"><i class="el-icon-user-solid"></i>用户管理</template>
                    <el-menu-item-group>
                        <el-menu-item ><router-link to="/user" :underline="false">用户信息</router-link></el-menu-item>
                    </el-menu-item-group>
                </el-submenu>

                <el-submenu index="2">
                    <template slot="title"><i class="el-icon-apple"></i>品牌管理</template>
                    <el-menu-item-group>
                        <el-menu-item index="1-2"><router-link to="/brand" :underline="false">品牌信息</router-link></el-menu-item>
                    </el-menu-item-group>
                </el-submenu>

                <el-submenu index="3">
                    <template slot="title"><i class="el-icon-s-opportunity"></i>品牌类型管理</template>
                    <el-menu-item-group>
                        <el-menu-item index="1-2"><router-link to="/productType" :underline="false">品牌类型</router-link></el-menu-item>
                    </el-menu-item-group>
                </el-submenu>

                <el-submenu index="4">
                    <template slot="title"><i class="el-icon-s-goods"></i>商品管理</template>
                    <el-menu-item-group>
                        <el-menu-item index="1-2"><router-link to="/product" :underline="false">商品信息</router-link></el-menu-item>
                    </el-menu-item-group>
                </el-submenu>

            </el-menu>
        </el-aside>

        <el-container>
            <el-header style="text-align: right; font-size: 12px">
                <el-page-header @back="goBack" content=""  ></el-page-header>
            </el-header>

            <el-main>
               <router-view></router-view>
            </el-main>
        </el-container>
    </el-container>
</template>



<script>
    export default {
        name: "Person.vue",
        methods: {
            goBack() {
                console.log('go back');
                this.$router.push('/')
            }

        },
        data() {
            const item = {
                date: '2016-05-02',
                name: '王小虎',
                address: '上海市普陀区金沙江路 1518 弄'
            };
            return {
                tableData: Array(20).fill(item),
            }
        }
    }
</script>

<style>
    a {
        text-decoration: none;
    }

    .el-header {
        background-color: #B3C0D1;
        color: #333;
        line-height:80px;
    }

    .el-aside {
        color: #333;
    }

</style>