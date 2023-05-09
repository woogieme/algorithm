<template>
  <tr>
    <td>
      <img :src="ii.image" alt="" />
    </td>
    <td v-html="ii.title"></td>
    <td>{{ ii.lprice }}</td>
    <td><a :href="ii.link">[바로가기]</a></td>
  </tr>
</template>

<script>
export default {
  props: {
    //나는 상품 하나를 보여주는 컴포넌트
    ii: Object,
  },
};
</script>

<style>
img {
  width: 50px;
  height: 80px;
}
</style>
