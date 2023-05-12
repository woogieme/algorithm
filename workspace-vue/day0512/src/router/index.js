import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/HomeView.vue'
import BookView from '../views/BookView.vue'
import NaverView from '../views/NaverView.vue'
import NaverBlogView from '../views/naver/NaverBlogView'
import NaverNewsView from '../views/naver/NaverNewsView'
import NaverShopView from '../views/naver/NaverShopView'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'HomeView',
    component: HomeView
  },
  {
    path: '/naver',
    name: 'NaverView',
    component: NaverView,
    children: [
      {
        path: 'news',
        name: 'NaverNews',
        component:NaverNewsView
      },
      {
        path: 'blog',
        name: 'NaverBlog',
        component:NaverBlogView
      },
      {
        path: 'shop',
        name: 'NaverShop',
        component:NaverShopView
      }
    ]
  },
  {
    path: '/book',
    name: 'BookView',
    component: BookView
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
