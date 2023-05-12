<template>
    <div>
        <h4>Naver Shopping</h4>
        <input type="text" v-model="keyword" @keyup.enter="search"/>
        <table>
            <th>
                <td>이미지</td>
                <td>상품명</td>
                <td>가격</td>
                <td>사러가기</td>
            </th>
            <tr v-for="item in shopList" :key="item.productid">
                <td>{{item.title}}</td>
                <td>{{item.lprice}}</td>
                <td>{{item.link}}</td>
                <td>{{item.image}}</td>
            </tr>
        </table> 
    </div>
</template>

<script>
import { mapState,mapActions }from "vuex"
export default {
    data(){
        return {
            keyword:'',
            
        }
    },
    methods:{
        search(){
            //this.$store.dispatch('searchNaverShop',this.keyword);
            this.searchNaverShop(this.keyword);
        },
        ...mapActions(["searchNaverShop"]),
    },
    computed:{
        // shopItems(){
        //     return this.$store.state.shopList;
        // }
        ...mapState(['shopList','newsList','blogList']),
    }
};
</script>

<style scoped></style>