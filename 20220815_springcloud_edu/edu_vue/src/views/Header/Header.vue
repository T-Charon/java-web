<template>
  <div class="header-pc-wrap">
    <!-- 登录框 开始-->
    <el-dialog
      style="width:800px;margin:0px auto;"
      title=""
      :visible.sync="dialogFormVisible">
      <!-- 登录表单-->
      <div id="loginForm">
        <el-form>
          <el-form-item>
            <h1 style="font-size:30px;color:#00B38A">泡泡</h1>
          </el-form-item>
          <el-form-item>
            <el-input v-model="username" placeholder="请输入账号..."></el-input>
          </el-form-item>
          <el-form-item>
            <el-input type="password" v-model="password" placeholder="请输入密码..."></el-input>
          </el-form-item>
        </el-form>
        <el-button
          style="width:100%;margin:0px auto;background-color: #00B38A;font-size:20px"
          type="primary"
          @click="login">确 定</el-button>
        <p></p>
        <!-- 微信登录图标 -->
        <img
          @click="goToLoginWX"
          src="http://www.lgstatic.com/lg-passport-fed/static/pc/modules/common/img/icon-wechat@2x_68c86d1.png"
          alt=""
        />
      </div>

      <!-- 二维码 -->
      <!--
      <wxlogin id="wxLoginForm" style="display:none" 
              :appid="appid" :scope="scope" :redirect_uri="redirect_uri">
      </wxlogin>
      -->
      <div id="wxLoginForm"></div>

    </el-dialog>
    <!-- 登录框 结束-->

    <!-- 顶部登录条 -->
    <div class="wrap-box">
      <div @click="toToIndex" class="edu-icon"></div>
      <div @click="toToIndex" class="text">泡泡教育</div>
      <div class="right-var-wrap" v-if="!isLogin">
        <div class="login-handler" @click="goToLogin">登录 | 注册</div>
      </div>
      <div class="right-var-wrap" v-if="isLogin">
        <div
          :class="{ 'tip-icon': true, 'has-new-message': isHasNewMessage }"
          @click="toToNotic"
        >
          <i class="el-icon-bell"></i>
        </div>
        <img :src="user.icon" class="avatar-wrap" />
        <div class="bar-wrap" >
          <ul class="account-bar" >
            <li class="user_dropdown" data-lg-tj-track-code="index_user" >
              <span class="unick">{{ user.realname }}</span>
              <i />
              <ul style="">
                <li @click="goToSetting">
                  账号设置
                </li>
                <li @click="logout">
                  退出
                </li>
              </ul>
            </li>
          </ul>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
// import wxlogin from 'vue-wxlogin'; // 引入

export default {
  name: "Header",
  components:{
    // wxlogin  // 声明引用的组件
  },
  props: {},
  data() {
    return {
      isLogin: false, // 登录状态，true：已登录，false：未登录
      user:null, // 用来保存登录的用户信息
      isHasNewMessage: false, // 是否有新的推送消息
      dialogFormVisible: false, // 是否显示登录框，true：显示，false：隐藏
      username: "", // 双向绑定表单 手机号
      password: "", // 双向绑定表单 密码
      // appid:"wxd99431bbff8305a0", // 应用唯一标识，在微信开放平台提交应用审核通过后获得
      // scope:"snsapi_login", // 应用授权作用域，网页应用目前仅填写snsapi_login即可
      // redirect_uri:"http://www.pinzhi365.com/user/wxlogin",  //重定向地址，(回调地址)
      x:null
    };
  },
  created(){
    // 当刷新页面，组件创建成功之后，立刻检测本地储存中是否存在用户对象
    this.user = JSON.parse( localStorage.getItem("user") );
    if(this.user != null){
        this.isLogin = true; // 已登录
    }else{
      // 去检测微信是否登录过
      // this.axios
      // .get("/user/checkWxStatus")
      // .then( (result)=>{
      //   this.user = result.data;
      //   this.username = this.user.username;
      //   this.password = this.user.password;
      //   this.login();// 走普通登录
      // })
      // .catch( (error)=>{
      //   //this.$message.error("登录失败！");
      // });
    }


!(function(a, b, c) {
      function d(a) {
        var c = "default";
        a.self_redirect === !0
          ? (c = "true")
          : a.self_redirect === !1 && (c = "false");
        var d = b.createElement("iframe"),
          e =
            "https://open.weixin.qq.com/connect/qrconnect?appid=" +
            a.appid +
            "&scope=" +
            a.scope +
            "&redirect_uri=" +
            a.redirect_uri +
            "&state=" +
            a.state +
            "&login_type=jssdk&self_redirect=" +
            c +
            "&styletype=" +
            (a.styletype || "") +
            "&sizetype=" +
            (a.sizetype || "") +
            "&bgcolor=" +
            (a.bgcolor || "") +
            "&rst=" +
            (a.rst || "");
          (e += a.style ? "&style=" + a.style : ""),
          (e += a.href ? "&href=" + a.href : ""),
          (d.src = e),
          (d.frameBorder = "0"),
          (d.allowTransparency = "true"),
          (d.sandbox = "allow-scripts allow-top-navigation allow-same-origin"), // 允许多种请求
          (d.scrolling = "no"),
          (d.width = "300px"),
          (d.height = "400px");
        var f = b.getElementById(a.id);
        (f.innerHTML = ""), f.appendChild(d);
      }
      a.WxLogin = d;
    })(window, document);
    
  },
  methods: {
    goToSetting() {
      this.$router.push("/setting"); // 跳转个人设置页面
    },
    goToLogin() {
      this.dialogFormVisible = true; // 显示登录框
    },
    login(){ // 前去登录
      this.axios
      .post("/login" ,this.qs.stringify({username:this.username,password:this.password}))
      .then( (result)=>{
        console.log(result.data.data)
        if(result.data.data.user){

          console.log("登录成功" + result);
          this.dialogFormVisible = false ; //关闭登录框
          this.$message.success("登录成功！");

          this.user = result.data.data.user; // 保存返回数据中的用户对象信息
          console.log(this.user);
          this.isLogin = true; // 更新登录状态
          localStorage.setItem("user", JSON.stringify(this.user)); // 将登录成功的对象信息保存到本地储存中
          localStorage.setItem("token", result.data.data.token); //保存token
        }else{
          this.$message.error("登录失败："+result.data.data);
        }
        //this.$router.go(0);//刷新页面
      } )
      .catch( (error)=>{
        this.$message.error("登录失败！");
        this.dialogFormVisible = false ; //关闭登录框
      });
    },
    // 微信登录
    goToLoginWX() {
      // 普通的登录表单隐藏
      document.getElementById("loginForm").style.display = "none";
      // 显示二维码的容器
      document.getElementById("wxLoginForm").style.display = "block";
      // 生成二维码
      // 待dom更新之后再用二维码渲染其内容
      this.$nextTick(function(){
        this.createCode(); // 直接调用会报错：TypeError: Cannot read property 'appendChild' of null
      });
    },
    // 生成二维码
    createCode(){
      var obj = new WxLogin({
          id:"wxLoginForm", // 挂载点，二维码的容器
          appid:"wxd99431bbff8305a0", // 应用唯一标识，在微信开放平台提交应用审核通过后获得
          scope:"snsapi_login", // 应用授权作用域，网页应用目前仅填写snsapi_login即可
          redirect_uri:"http://www.pinzhi365.com/user/wxlogin",  //重定向地址，(回调地址)
          href: "data:text/css;base64,LmltcG93ZXJCb3ggLnFyY29kZSB7d2lkdGg6IDIwMHB4O30NCi5pbXBvd2VyQm94IC50aXRsZSB7ZGlzcGxheTogbm9uZTt9DQouaW1wb3dlckJveCAuaW5mbyB7d2lkdGg6IDIwMHB4O30NCi5zdGF0dXNfaWNvbiB7ZGlzcGxheTogbm9uZX1jcw0KLmltcG93ZXJCb3ggLnN0YXR1cyB7dGV4dC1hbGlnbjogY2VudGVyO30=" // 加载修饰二维码的css样式
      });
    },
    toToIndex() {
      this.$router.push("/"); //回到首页
    },
    toToNotic(){
    },
    //登出
    logout(){ 
      localStorage.setItem("user", null); // 将登录成功的对象信息保存到本地储存中
      localStorage.setItem("token", null);
      this.isLogin = false; // 更新登录状态
      this.$message.success("谢谢使用，再见！");
      // 去检测微信是否登录过
      this.axios
      .get("/logout")
      .then( (result)=>{
       this.$router.go(0);//刷新页面
      })
      .catch( (error)=>{
        //this.$message.error("登录失败！");
      });
    }
  },
};
</script>

<style lang="less" scoped>
.header-pc-wrap {
  width: 100%;
  height: 40px;
  background: rgba(35, 39, 43, 1);
}
.wrap-box {
  width: 1200px;
  height: 100%;
  margin: 0 auto;
}
.edu-icon {
  float: left;
  width: 24px;
  height: 24px;
  background: url("./static/img/Icon@2x.png") no-repeat;
  background-size: 100% 100%;
  margin-top: 8px;
}
.text {
  font-size: 16px;
  font-weight: 500;
  color: rgba(255, 255, 255, 1);
  line-height: 40px;
  float: left;
  margin-left: 6px;
}
.login-handler {
  font-size: 12px;
  font-weight: 500;
  color: rgba(255, 255, 255, 1);
  line-height: 40px;
  float: left;
  cursor: pointer;
}
.right-var-wrap {
  float: right;
  font-size: 0;
  text-align: right;
}
.tip-icon,
.avatar-wrap,
.bar-wrap {
  display: inline-block;
  vertical-align: top;
}
.tip-icon {
  font-size: 16px;
  line-height: 40px;
  margin-right: 26px;
  color: #818895;
  cursor: pointer;
  &:hover {
    color: #fff;
  }
  &.has-new-message {
    position: relative;
    &:after {
      content: " ";
      display: inline-block;
      position: absolute;
      top: 50%;
      width: 6px;
      height: 6px;
      border-radius: 3px;
      background: red;
      right: 0;
      margin-top: -7px;
    }
  }
}
.user_dropdown {

  position: relative;
  cursor: pointer;
  font-size: 14px;
  text-align: center;
  &:hover {
    .unick {
      color: #fff;
    }
    i {
      -webkit-transform: rotate(180deg);
      -moz-transform: rotate(180deg);
      -ms-transform: rotate(180deg);
      -o-transform: rotate(180deg);
      transform: rotate(180deg);
      animation-fill-mode: forwards;
      border-color: #fff transparent transparent;
    }
    > ul {
      display: block;
      position: absolute;
      top: 40px;
      width: 100%;
      min-width: 80px;
      line-height: 30px;
      background-color: #32373e;
      z-index: 1000;
      list-style: none; margin:0px;padding:0px;
      > li {
        width: 100%;
        height: 30px;
        &:hover {
          background-color: #25282d;
          color: #fff;
        }
      }
    }
  }
  .unick {
    display: block;
    height: 40px;
    line-height: 40px;
    font-size: 14px;
    color: #afb5c0;
    max-width: 96px;
    margin: 0 9px;
    overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;
    word-wrap: normal;
    &:hover {
      color: #fff;
    }
  }
  > i {
    position: absolute;
    top: 17px;
    right: 0;
    font-size: 0;
    height: 0;
    width: 0;
    border-width: 5px 4px 0;
    border-style: solid dashed;
    border-color: #afb5c0 transparent transparent;
    overflow: hidden;
    -webkit-transition: all 0.4s ease 0s;
    -moz-transition: all 0.4s ease 0s;
    -ms-transition: all 0.4s ease 0s;
    -o-transition: all 0.4s ease 0s;
    transition: all 0.4s ease 0s;
  }
  > ul {
    display: none;
    color: #afb5c0;
  }
}
.avatar-wrap {
  width: 40px;
  height: 40px;
  border-radius: 50%;
}
</style>
