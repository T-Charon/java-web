import Vue from 'vue'
import VueRouter from 'vue-router'


// import index from "@/views/index";
// import goods from "@/views/goods";
import Employess from "@/views/Employess";
Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Employess',
    component: Employess
  },


]

const router = new VueRouter({
  routes
})

export default router
