import Vue from 'vue'
import Vuex from 'vuex'
import http from '../util/http-common.js'
Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    shopList: [],
    newsList: [],
    blogList: [],
  },
  getters: {
  },
  mutations: {
    SEARCH_NAVER_SHOP(state, payload) {
        state.shopList = payload; //action이 저장해달라고 보낸 데이터 저장해주기

    },
  },
  actions: {
    searchNaverShop({ commit }, payload) {
      http.get("/naver/shop/" + payload).then((data) => {
        console.log('백엔드한테서 받은 데이터', data);
        
        commit("SEARCH_NAVER_SHOP",data.items);
      })
    }
  },
  modules: {
  }
})
