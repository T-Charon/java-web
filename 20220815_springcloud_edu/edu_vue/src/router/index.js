import Vue from 'vue'
import VueRouter from 'vue-router'
import Index from "@/views/Index";
import Setting from "@/views/Setting";
import Course from "@/views/Course";

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Index',
    component: Index,
    meta: {
      title: '首页'
    }
  },
  {
    path: '/setting',
    name: 'Setting',
    component: Setting,
    meta: {
      title: '个人设置'
    }
  },
  {
    path: '/course',
    name: 'Course',
    component: Course,
    meta: {
      title: '课程详情'
    }
  },

]

const router = new VueRouter({
  routes
})

export default router
