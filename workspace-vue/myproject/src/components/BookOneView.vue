<template>
        <tr>
            <td>ISBN : {{clickedItem.isbn}}</td><br>
            <td>TITLE : {{clickedItem.title}}</td><br>
            <td>Author : {{clickedItem.author}}</td><br>
            <td>Price : {{clickedItem.price}}</td><br>
            <td>Content : {{clickedItem.content}}</td>
            <button v-on:click="modify">수정하기</button>
            <book-modify-vue v-bind:modify-item="item"></book-modify-vue>
        </tr>
</template>

<script>
import axios from "axios"
import BookModifyVue from "./BookModify.vue";
export default {
    components:{
        BookModifyVue
    },
    props:{
        'clickedItem': Object,
    },
    created() {
    },
    data() {
        return {
            item:{}
        }
    },
    methods: {
        modify(){
            axios.get("http://192.168.214.40:9999/vuews/book/"+this.clickedItem.isbn)
            .then((resp)=>{
                this.item=resp.data;
                alert(this.item.title)
            })
        }
    },
};
</script>

<style scoped></style>