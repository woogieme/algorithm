<template>
  <b-container class="bv-example-row mt-3 text-center">
    <h3 class="underline-green"><b-icon icon="truck"></b-icon> Trip Service</h3>
    <b-row>
      <b-col>
        <h1>Enjoy Your Trip!!!!!!</h1>
      </b-col>
    </b-row>
    <router-view></router-view>
  </b-container>
</template>
<script>
export default {
  name: "HouseView",
};
</script>
<style scoped>
.underline-green {
  display: inline-block;
  background: linear-gradient(180deg, rgba(255, 255, 255, 0) 70%, rgba(27, 231, 75, 0.3) 30%);
}
</style>
