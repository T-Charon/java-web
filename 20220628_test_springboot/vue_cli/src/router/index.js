import Vue from 'vue'
import VueRouter from 'vue-router'
import Index from "@/views/Index";

Vue.use(VueRouter)

/*路由规则*/
const routes = [

  {
    path: '/',  /*路径  开始页面*/
    name: 'Index', /*名字*/
    component: Index /*组件*/
  }
]

const router = new VueRouter({
  routes
})

export default router
