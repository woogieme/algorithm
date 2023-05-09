<template>
        <tr>
            <td>{{ ii.isbn }}</td>
            <td v-on:click="legend">{{ii.title}}</td>
            <td>{{ii.price}}</td>
            <td>{{ii.content}}</td>
            <td>{{ii.author}}</td>
            <button v-on:click="deleteBye">삭제하기</button>            
        </tr>
</template>

<script>
import axios from "axios";
export default {
    data(){
        return{
            items:[],
            book: {
                "isbn": "",
                title: "",
                price: 0,
                content: "",
                author: "",
            }
        }
    },
    props:{
        ii:Object,
    },
    // created() {
    //     this.book = this.ii;
    // },
    methods: {
        legend(){
            axios.get("http://192.168.214.40:9999/vuews/book/"+this.ii.isbn)
            .then((resp)=>{
                alert(resp)
                this.items=resp.data;
                this.$emit("mom",this.items);
            })
        },
        deleteBye(){
            axios.delete("http://192.168.214.40:9999/vuews/book/"+this.ii.isbn)
            .then((resp)=>{
                alert(resp)
                this.items=resp.data;
                this.$emit("mom",this.items);
            })
        }
    },
};
</script>

<style scoped></style>