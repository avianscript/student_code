<template>
  <div class="img-div">
    <!-- src property should be set based on image being displayed -->
    <img v-bind:src="imgUrl" />
  </div>
</template>

<script>
export default {
  name: "product-image",
  /* this component should receive the url to use via an imgUrl attribute*/
  props: ["imgUrl"],
};
</script>

<style scoped>
.img-div {
  width: 200px;
  height: 200px;
  border-right: 2px solid black;
  padding: 5px;
}

img {
  max-width: 100%;
  max-height: 100%;
}
</style>