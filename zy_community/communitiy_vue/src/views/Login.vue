<template>
    <div class="demo">
        <el-form  status-icon   label-width="100px" class="demo-ruleForm"  >
            <div style="margin-left: 60px">登录系统</div>
            <br>
            <el-form-item label="姓名" prop="pass">
                <el-input type="text" v-model="username" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item label="密码" prop="checkPass">
                <el-input type="password" v-model="password" autocomplete="off"></el-input>
            </el-form-item>

            <el-form-item>
                <el-button type="primary" @click="handleLogin">登录</el-button>
                <el-button @click="ruleForm">重置</el-button>
            </el-form-item>

<!--        <span>{{msg}}</span>-->
<!--        <el-input v-model="username"></el-input><br>-->
<!--        <el-input v-model="password" type="password"></el-input><br>-->
<!--        <el-button type="primary" @click="handleLogin">登录</el-button>-->
        </el-form>
    </div>

</template>

<script>
    export default {
        name: "Login.vue",
        data(){
            return{
                username:"",
                password:"",
                msg:"",

            }
        },
        methods:{
            ruleForm(){
                this.username="", this.password="", this.msg=""
            },
            handleLogin(){
                this.axios.post("http://localhost:8080/login",
                    this.qs.stringify({"username":this.username,"password":this.password}))
                    .then(result => {
                        if(result.data.status == "OK"){
                            //如果登录成功，就获得token,保存到本地
                            localStorage.setItem("username",result.data.data.username);
                            localStorage.setItem("token",result.data.data.token);
                            //跳转到index页面
                            this.$router.push({path:"/index"});
                        }else{
                            this.msg = "账号或密码错误";
                        }
                    });
            }
        }
    }
</script>

<style scoped>
    .demo-ruleForm{
        width: 400px;
    }
</style>