import Vue from 'vue'
import VueRouter from 'vue-router'


import index from "@/views/index";
import goods from "@/views/goods";
Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'goods',
    component: goods
  },


]

const router = new VueRouter({
  routes
})

export default router
