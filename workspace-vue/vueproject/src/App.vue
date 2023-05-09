<template>
  <div id="app">
    <naver-header v-on:mom="yes"></naver-header>
    <naver-search-view v-bind:naverKeyword="momkeyword"></naver-search-view>
  </div>
</template>

<script>
import NaverHeader from "./components/NaverHeader.vue";
import NaverSearchView from "./components/NaverSearchView.vue";

export default {
  name: "app",
  components: {
    NaverHeader,
    NaverSearchView,
  },
  data() {
    return {
      momkeyword: "",
    };
  },
  methods: {
    yes(keyword) {
      this.momkeyword = keyword;
      alert(this.momkeyword);
      console.log(this.momkeyword);
    },
  },
};
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
