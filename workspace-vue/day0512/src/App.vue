<template>
  <div id="app">
    <header-nav></header-nav>
    <router-view/>
  </div>
</template>
<script>
import HeaderNav from "./components/HeaderNav.vue"

export default ({
  components:{HeaderNav},
  setup() {
    
  },
})
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

nav {
  padding: 30px;
}

nav a {
  font-weight: bold;
  color: #2c3e50;
}

nav a.router-link-exact-active {
  color: #42b983;
}
</style>
