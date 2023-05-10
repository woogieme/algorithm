<template>
  <div>
    <router-link :to="{name: 'main'}">HOME</router-link>
    |
    <router-link :to="{name: 'book'}">게시판</router-link>
    |
    <router-link :to="{name: 'aboutview'}">QnA</router-link>
    
    <img src="@/assets/ssafy_logo.png" width="300" height="300">
    <router-view />
  </div>
</template>

<script>
export default {
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

#nav {
  padding: 30px;
}

#nav a {
  font-weight: bold;
  color: #2c3e50;
}

#nav a.router-link-exact-active {
  color: #42b983;
}

a {
  text-decoration: none;
  color: #787878;
}

.underline {
  display: inline-block;
  background: linear-gradient(180deg, rgba(255, 255, 255, 0) 70%, cyan 30%);
}

button,
.btn {
  background-color: #d0d3d0;
  color: rgb(80, 82, 79);
  padding: 14px 20px;
  margin: 8px 0;
  border: 1px solid #787878;
  border-radius: 4px;
  font-size: large;
  cursor: pointer;
}
</style>