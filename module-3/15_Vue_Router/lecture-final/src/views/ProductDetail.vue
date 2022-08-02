<template>
  <div id="app" class="main">
    
    <h1>{{ product.name }}</h1>
    <p class="description">{{ product.description }}</p>
    <div class="actions">
      <router-link v-bind:to="{ name: 'products' }"> Back to Products </router-link>
      &nbsp; | &nbsp;
      <router-link v-bind:to="{ name: 'add-review', params: { id: product.id } }">
        Add Review
      </router-link>
    </div>
    <div class="well-display">
      <average-summary />
      <star-summary rating="1" />
      <star-summary rating="2" />
      <star-summary rating="3" />
      <star-summary rating="4" />
      <star-summary rating="5" />
    </div>
    <review-list />
    <!-- <div>My name is {{ myName }}</div> -->
  </div>
</template>
 
 
<script>
import AverageSummary from '@/components/AverageSummary';
import StarSummary from '@/components/StarSummary';
import ReviewList from '@/components/ReviewList.vue';
export default {
    name: 'product-detail',
    components: {
        AverageSummary,
        StarSummary,
        ReviewList
    },
    created() {
        const productId = this.$route.params.productId;
        // params are always Strings. we need this to be a number in the store so use parseIntt
        this.$store.commit('SET_ACTIVE_PRODUCT', parseInt(productId))

    },
    computed: {
        product() {
            return this.$store.state.products.find( 
                curProduct => curProduct.id === this.$store.state.activeProduct)
        },
        myName() {
            return this.$route.query.nameVal;
        }
    }
}
</script>
 
<style>
 .route-link-active {
     color: green;
 }
</style>