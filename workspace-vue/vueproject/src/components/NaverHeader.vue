<template>
  <div id="compApp">
    <h1>네이버 검색 화면</h1>
    <input type="text" v-model="keyword" @keydown.enter="search" />
  </div>
</template>

<script>
export default {
  name: "compApp",
  components: {},
  //   data:{}, new vue하던 시절의 인스턴스는 이렇게 써도 됐었지만 지금은 컴포넌트, 데이터는 함수형태
  data() {
    return {
      keyword: "",
    };
  },
  created() {},
  methods: {
    search() {
      this.$emit("mom", this.keyword);
    },
  },
};
</script>

<style scoped></style>
