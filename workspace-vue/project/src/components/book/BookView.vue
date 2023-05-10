<template>
  <div>
    <table border="1">
    <tr>
      <td>ISBN : {{this.items.isbn}}</td>
      <td>제목 : {{this.items.title}}</td>
      <td>저자 : {{this.items.author}}</td>
      <td>가격 : {{this.items.price}}</td>
      <td>컨텐츠 : {{this.items.content}}</td>
    </tr>
    <button v-on:click="modifyBook">수정하기</button>
    <button v-on:click="deleteBook">삭제하기</button>
    </table>


    <router-view></router-view>
  </div>
</template>

<script>
import axios from "axios"

export default {
  data() {
      return {
        no:0,
        items:[]
      }
    },
    created(){
      console.dir(this.$route)
      this.no=this.$route.params.isbn;
      axios.get("http://192.168.214.40:9999/vuews/book/"+this.no)
            .then((resp)=>{
                this.items=resp.data;
            })
    },
    methods:{
      deleteBook(){
            axios.delete("http://192.168.214.40:9999/vuews/book/"+this.items.isbn)
            .then((resp)=>{
                alert(resp)
                this.items=resp.data;
                this.$emit("mom",this.items);
            })
        },
        modifyBook(){
            this.$router.push({
              name:"bookmodify",
              params:{isbn:this.items.isbn}
            })



        }
    }
}
</script>

<style>

</style>