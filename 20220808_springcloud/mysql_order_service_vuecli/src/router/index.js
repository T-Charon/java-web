import Vue from 'vue'
import VueRouter from 'vue-router'

import Index from "@/views/Index";
import OrderIndex from "@/views/OrderIndex";
import Product from "@/views/Product";
import Login from "@/views/Login";
import PromotionAd from "@/views/PromotionAd";
import PromotionSpace from "@/views/PromotionSpace";

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Login',
    component: function () {
      return import('../views/Login.vue')
    },
  },
  {
    path: '/index',
    name: 'index',
    component: Index,
    children: [
      {
        path: '/order',
        name: 'OrderIndex',
        component: function () {
          return import('../views/OrderIndex.vue')
        }
      },
      {
        path: '/product',
        name: 'Product',
        component: function () {
          return import('../views/Product.vue')
        }
      },
      {
        path: '/promotionad',
        name: 'PromotionAd',
        component: function () {
          return import('../views/PromotionAd.vue')
        }
      },
      {
        path: '/promotionspace',
        name: 'PromotionSpace',
        component: function () {
          return import('../views/PromotionSpace.vue')
        }
      },

    ],
  },
  {
    path: '/about',
    name: 'about',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.

  }
]

const router = new VueRouter({
  routes
})

export default router
