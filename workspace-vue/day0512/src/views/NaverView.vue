<template>
    <div>
        <h2>여기는 네이버 검색 화면 View</h2>
        <select v-model="category">
            <option value="blog">블로그 </option>
            <option value="shop">쇼핑 </option>
            <option value="news">뉴스 </option>
        </select>

        <router-link :to="`/naver/${category}`">선택 검색</router-link>
        <router-link to="/naver/blog">블로그 검색</router-link>
        <router-link to="/naver/shop">쇼핑 검색</router-link>
        <router-link to="/naver/news">뉴스 검색</router-link>
        <br>
        전체 라우터뷰 말고 네이버검색 View 하위에 있는 라우터뷰
        <router-view></router-view>
        </div>
    
</template>

<script>
export default {

    components: {},
    data() {
        return {
            category: '',
        };
    },
    created() {},
    methods: {},
};
</script>

<style scoped></style>