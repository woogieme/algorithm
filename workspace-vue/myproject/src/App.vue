<template>
  <div id="app">
    <book-header></book-header>
    <book-list v-on:mom="yes"></book-list>
    <book-add></book-add>
    <book-one-view-vue v-bind:clicked-item="item"></book-one-view-vue>
  </div>
</template>

<script>
import BookHeader from "./components/BookHeader.vue";
import BookList from "./components/BookList.vue";
import BookAdd from "./components/BookAdd.vue";
import BookOneViewVue from "./components/BookOneView.vue";

export default {
  name: 'App',
  components: {
    BookHeader,
    BookList,
    BookAdd,
    BookOneViewVue
  },
  data() {
    return {
      momkeyword:{},
      item:{}, // clicked item
    }
  },
  methods:{
    yes(item){
      this.item=item;
    }
  }
}
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
