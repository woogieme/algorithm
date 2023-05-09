<template>
    <div>
        <h1>책추가하기</h1>
        ISBN<input type="text" v-model="isbn"><br>
        책이름<input type="text" v-model="title"><br>
        저자<input type="text" v-model="author"><br>
        가격<input type="number" v-model="price"><br>
        설명<input type="text" v-model="content"><br>
        <button v-on:click="addBook">책추가하기</button>
    </div>
</template>

<script>
import axios from "axios"
export default {
    components: {},
    data() {
        return {
            isbn:"",
            title: "",
            author: "",
            price: 0,
            content: ""
        };
    },
    created() {},
    methods: {
        addBook(){
            let suin={
                isbn:this.isbn,
                title: this.title,
                author: this.author,
                price: this.price,
                content: this.content
            }
            axios.post("http://192.168.214.40:9999/vuews/book",suin).then((resp) => {
                console.log(resp);
                alert("등록이 완료되었습니다.,")
                });
        }
    },
};
</script>

<style scoped></style>