<template>
    <div >
        <el-container style="height: 700px; border: 1px solid #eee">
            <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
                <el-menu :default-openeds="['1']">
                    <el-submenu index="1">
                        <template slot="title"><i class="el-icon-setting"></i>系统管理</template>
                        <el-menu-item-group>
                            <el-menu-item index="1-1" ><router-link to="/order" style="text-decoration: none">订单管理</router-link></el-menu-item>
                            <el-menu-item index="1-2"><router-link to="/product" style="text-decoration: none">商品管理</router-link> </el-menu-item>
                        </el-menu-item-group>

                    </el-submenu>

                </el-menu>

            </el-aside>

            <el-container>
                <el-header style="text-align: right; font-size: 12px">
                    <el-dropdown>
                        <i class="el-icon-setting" style="margin-right: 15px"></i>
                        <el-dropdown-menu slot="dropdown">
                            <el-dropdown-item>查看</el-dropdown-item>
                            <el-dropdown-item>新增</el-dropdown-item>
                            <el-dropdown-item>删除</el-dropdown-item>
                        </el-dropdown-menu>
                    </el-dropdown>
                    <span>王小虎</span>
                </el-header>

                <!--挂载视图-->
                <el-main>
                    <router-view></router-view>
                </el-main>


            </el-container>
        </el-container>
    </div>

</template>

<script>
    export default {
        name: "Index",
        data(){
            return{

            }
        },
        methods:{

        },
        created() {

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
