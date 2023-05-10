<template>
  <div>
    <input type="text" v-model="isbn">
    <input type="text" v-model="title">
    <input type="text" v-model="author">
    <input type="text" v-model="price">
    <input type="text" v-model="content">
    <button v-on:click="goModify">수정하기</button>
  </div>
</template>

<script>
import axios from "axios"
export default {
  data(){
    return{
      isbn:"",
      title:"",
      author:"",
      price:"",
      content:""
    }
  },
  created(){
      axios.get("http://192.168.214.40:9999/vuews/book/"+this.$route.params.isbn)
        .then((resp)=>{
        alert(resp)
        this.isbn=resp.data.isbn
        this.title=resp.data.title
        this.author=resp.data.author
        this.price=resp.data.price
        this.content=resp.data.content
      })
  },
  methods:{
  goModify(){
    let suin={
      isbn:this.isbn,
      title:this.title,
      author:this.author,
      price:this.price,
      content:this.content,
    }
    axios.put("http://192.168.214.40:9999/vuews/book/"+this.isbn,suin)
    .then((resp)=>{
      alert(resp)
    })

    this.$router.push(
      "/book/list"
    )
  }
  }
}
</script>

<style>

</style>