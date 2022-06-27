import Vue from 'vue'
import VueRouter from 'vue-router'
import Index from "@/views/Index";
import User from "@/views/User";
import Brand from "@/views/Brand";
import Product from "@/views/Product";
import ProductType from "@/views/ProductType";
import Login from "@/views/Login";
Vue.use(VueRouter)

/*路由规则*/
const routes = [
  {
    path: '/',
    name: 'Login',
    component: Login
  },
  {
    path: '/index',  /*路径  开始页面*/
    name: 'Index', /*名字*/
    component: Index, /*组件*/
    children:[
      {
        path: '/user',  /*路径  开始页面*/
        name: 'User', /*名字*/
        component: User /*组件*/
      },
      {
        path: '/brand',  /*路径  开始页面*/
        name: 'Brand', /*名字*/
        component: Brand /*组件*/
      },
      {
        path: '/product',  /*路径  开始页面*/
        name: 'Product', /*名字*/
        component: Product /*组件*/
      },
      {
        path: '/productType',  /*路径  开始页面*/
        name: 'ProductType', /*名字*/
        component: ProductType /*组件*/
      }
    ]
  }
]

const router = new VueRouter({
  routes
})

export default router
