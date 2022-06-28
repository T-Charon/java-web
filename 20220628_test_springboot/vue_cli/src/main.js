import Vue from 'vue'
import App from './App.vue'
import router from './router'
/*引入element-ui*/
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
/*引入axios*/
import axios from "axios";

/*引入qs*/
import qs from "qs";

Vue.use(ElementUI)
Vue.prototype.axios = axios;
Vue.prototype.qs = qs;


Vue.config.productionTip = false;

new Vue({
  router,
  render: function (h) { return h(App) }
}).$mount('#app')
