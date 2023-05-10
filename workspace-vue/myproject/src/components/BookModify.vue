<template>
    <div>
        제목 <input type="text" v-model="title"/><br>
        저자 <input type="text" v-model="author"/><br>
        가격 <input type="number" v-model="price"/><br>
        내용 <input type="text" v-model="content"/><br>
        <button v-on:click="modifySucces">수정완료</button><br>
    </div>
</template>

<script>
import axios from "axios";

export default {
    components: {},
    props:{
        "modifyItem":Object
    },
    data() {
        return {
            title:this.modifyItem.title,
            author:this.modifyItem.author,
            price:this.modifyItem.price,
            content:this.modifyItem.price
        }
    },
    created() {},
    methods: {

        modifySucces(){
            let suin={
                title:this.title,
                author:this.author,
                content:this.content,
                price:this.price
            }
            axios.put("http://192.168.214.40:9999/vuews/book/"+this.modifyItem.isbn,suin)
            .then((resp)=>{
                alert(resp)
            })
        }
    },
};
</script>

<style scoped></style>