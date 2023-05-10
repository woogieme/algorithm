import Vue from 'vue'
import VueRouter from 'vue-router'
import AboutViewVue from "../views/AboutView.vue";
import BookViewVue from "../views/BookView.vue";
import HomeViewVue from "../views/HomeView.vue";
import BookListVue from "../components/book/BookList.vue";
import BookCreateVue from "../components/book/BookCreate.vue";
import BookViewVue2 from "../components/book/BookView.vue";
import BookModifyVue from "../components/book/BookModify.vue";
Vue.use(VueRouter)

const router = new VueRouter({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'main',
      component:HomeViewVue,
    },
    {
      path: '/book',
      name: 'book',
      component: BookViewVue,
      redirect: '/book/list',
      children: [
        {
          path: 'list',
          name: 'boardlist',
          component:BookListVue,
        },
        {
          path: 'create/:isbn',
          name: 'bookcreate',
          component:BookCreateVue,
        },
        {
          path: 'modify/:isbn',
          name: 'bookmodify',
          component:BookModifyVue,
        },
        {
          path: 'view/:isbn',
          name: 'bookview',
          component:BookViewVue2,
        },
      ]
    },
    {
      path: '/about',
      name: 'aboutview',
      component:AboutViewVue
    }
  ]
})

export default router;