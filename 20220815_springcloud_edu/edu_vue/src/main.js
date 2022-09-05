import Vue from 'vue'
import App from './App.vue'
import router from './router'

/*引入element-ui*/
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import { Message, MessageBox } from 'element-ui'

/*引入axios*/
import axios from "axios";


/*引入qs*/
import qs from "qs";

Vue.use(ElementUI)
Vue.prototype.axios = axios;
Vue.prototype.qs = qs;
Vue.config.productionTip = false
Vue.prototype.axios.defaults.baseURL = "http://localhost:9999";

//允许带cookie
// axios.defaults.withCredentials=true;
//配置axios拦截请求，添加token头信息
axios.interceptors.request.use(
    config => {
      let token = localStorage.getItem("token");
      console.log("token:" + token);
      if (token) {
        //把localStorage的token放在Authorization里
        config.headers.Authorization = token;
      }
      return config;
    },
    function(err) {
      console.log("失败信息" + err);
    }
);
//错误响应拦截
axios.interceptors.response.use(res => {
    console.log('拦截响应');
    console.log(res);
    if( res.data != "验证错误，需要登录" ){
        return res;
    }
    if( res.data == '验证错误，需要登录' ){
        console.log('验证错误，需要登录')
        MessageBox.alert('没有权限,需要登录','权限错误',{
            confirmButtonText:'跳转登录页面',
            callback: action => {
                window.location.href = '/login'
            }
        })
    }else{
        Message.error(res.data.data)
    }
})
new Vue({
  router,
  render: function (h) { return h(App) }
}).$mount('#app')

