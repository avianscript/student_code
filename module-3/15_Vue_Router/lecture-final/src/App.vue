<template>
  <div>
    <!-- <nav> -->
      <!-- this would be on ALL pages, only the content of router-view changes based on routes -->
    <!-- </nav> -->
    <h1>PRODUCT DEMO!!!!</h1>
    <router-view />
  </div>
</template>

<script>
export default {
  name: 'app'
};
</script>

<style>
#app {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  max-width: 800px;
  margin: 60px auto 0 auto;
}
</style>
