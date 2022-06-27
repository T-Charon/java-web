<template>
    <div>
        <span>{{msg}}</span>
        <el-input v-model="username"></el-input><br>
        <el-input v-model="password" type="password"></el-input><br>
        <el-button type="primary" @click="handleLogin">登录</el-button>
    </div>

</template>

<script>
    export default {
        name: "Login.vue",
        data(){
            return{
                username:"",
                password:"",
                msg:""
            }
        },
        methods:{
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

</style>