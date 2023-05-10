<template>
    <div >
        <table border="1">
            <tr>
                <td>isbn</td>
                <td>제목</td>
                <td>가격</td>
                <td>설명</td>
                <td>저자</td>
                
            </tr>
            <book-detail-list-vue v-for="item in items" 
            v-bind:ii="item" v-bind:key="item.isbn"></book-detail-list-vue>
            
        </table>
        <button v-on:click="createBook">게시글생성</button>
        
    </div>
</template>

<script>
import axios from "axios"
import BookDetailListVue from "./BookDetailList.vue";
export default {
    components: {
        BookDetailListVue
    },
    data() {
        return {
            items:[],
        };
    },
    created() {
        axios.get("http://192.168.214.40:9999/vuews/book").then((resp)=>{
            console.log(resp);
            this.items=resp.data
        })
    },
    updated(){
        axios.get("http://192.168.214.40:9999/vuews/book").then((resp)=>{
            console.log(resp);
            this.items=resp.data
        })
    },
    methods: {
        yes(item){
            this.$emit('mom',item);
        },
        createBook(){

      this.$router.push({
      name:"bookcreate",
    })
  }
    },
    
};
</script>
<style>
</style>