<template>
  <div id="app">
    <header class="site-header">
      Glamazon Electronics
    </header>
    <div class="main-page">
      <!-- add the search component here
        it should allow you to filter as you type and should an
        case-insensitive like title search.

        Make sure you assign the component an id of "search"
       -->
      <shopping-cart id="cart"/>
      <products-panel id="products"/>
    </div> 
  </div>
</template>

<script>
import ProductsPanel from './components/ProductsPanel.vue'
import ShoppingCart from './components/ShoppingCart.vue'

export default {
  name: 'App',
  components: {
    ProductsPanel,
    ShoppingCart
  }
}
</script>

<style>
@import url('https://fonts.googleapis.com/css2?family=Rock+Salt&display=swap');


#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}

.main-page {
  display: grid;
  grid-template-columns: 30% 70%;
  grid-template-areas: 
    ". search"
    "cart products";
  gap: 20px;
}

#cart {
  border: 2px solid black;
  margin-left: 20px;
  grid-area: cart;
}

#products {
  grid-area: products;
}

#search {
  grid-area: search;
  justify-self: start;
}

.site-header {
  font-family: 'Rock Salt', Helvetica, Arial, sans-serif;
  font-size: 60px;
  color: darkred;
  width: 100vw;
}

</style>
