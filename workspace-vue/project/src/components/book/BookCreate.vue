<template>
  <div>
    ISBN : <input type=text v-model="isbn"><br>
    TITLE : <input type=text v-model="title"><br>
    AUTHOR : <input type=text v-model="author"><br>
    PRICE : <input type=number v-model="price"><br>
    CONTENT : <input type=text v-model="content"><br>
    <button v-on:click="iCreate">생성</button>
    
  </div>
</template>

<script>
import axios from "axios"
export default {
  data() {
    return {
      isbn:"",
      title:"",
      author:"",
      price:0,
      content:""
    }
  },
  methods:{
    iCreate(){
      let suin={
        isbn:this.isbn,
        title:this.title,
        author:this.author,
        price:this.price,
        content:this.content
    }
    console.log(suin)
      axios.post("http://192.168.214.40:9999/vuews/book/",suin)
      alert("생성완료")
      this.$router.push(
      "/book/list"
    )
    }

      
    }
  }
</script>

<style>

</style>