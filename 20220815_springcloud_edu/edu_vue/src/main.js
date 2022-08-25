import Vue from 'vue'
import App from './App.vue'
import router from './router'
import qs from "qs"


// 导入ele组件库
import ElementUI from 'element-ui'
// 导入ele组件相关样式
import 'element-ui/lib/theme-chalk/index.css'
// 配置ele插件,将其安装到Vue上
Vue.use(ElementUI);

// 引入axios
import axios from 'axios'
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
new Vue({
  router,
  render: function (h) { return h(App) }
}).$mount('#app')

