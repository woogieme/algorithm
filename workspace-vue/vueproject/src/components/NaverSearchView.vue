<template>
  <div>
    내가 부모한테 받은 naverKeyword {{ naverKeyword }}
    <table>
      <tr>
        <td>상품 이미지</td>
        <td>상품명</td>
        <td>최저가</td>
        <td>이미지</td>
      </tr>

      <naver-search-view-item v-for="(item, idx) in items" :ii="item" :key="idx">
      </naver-search-view-item>
    </table>
  </div>
</template>

<script>
import axios from "axios"; //npm i axios 해서 다운받아놨음
import NaverSearchViewItem from "./NaverSearchViewItem.vue";
export default {
  components: { NaverSearchViewItem },
  data() {
    return {
      items: [],
    };
  },
  comments: {
    NaverSearchViewItem,
  },
  props: {
    //부모의 data중 momkeyword가 변경되면 받아오는 이쪽도 자동 반영
    naverKeyword: String,
    
  },
  watch: {
    //지켜보다가 데이터 변경되면 백엔드한테 검색 결과 달라고
    naverKeyword() {
      // alert(this.naverKeyword + "로 변경됨");

      //사용법 axios.get('url').then((res)=>{do something})
      axios.get("http://192.168.214.40:7777/bookcafe/naver/" + this.naverKeyword).then((resp) => {
        console.log(resp);
        this.items = resp.data.items;
        console.log(this.items);
      });
    },
  },
};
</script>

<style scoped></style>
