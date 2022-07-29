<template>
  <div>
        <!-- this should display all products -->
        <div class="product-container" id="product-row" v-for="(curProduct, index) in filteredProducts" v-bind:key="index">
            <!-- add the ProductImage component, set its id to img-panel, and pass the product's product_image_url to it -->
            <product-image id="img-panel" v-bind:imgUrl="curProduct.product_image_url"/>
            
            <!-- add the ProductDetail component, set is id to text-panel, and pass the current product to it --> 
            <product-detail id="text=panel" v-bind:product="curProduct"/>
        </div>
    </div>
</template>

<script>
import ProductDetail from './ProductDetail.vue';
import ProductImage from './ProductImage.vue';
export default {
    name: 'products-panel',
    components: {
        ProductImage,
        ProductDetail
    },
    computed: {
 
            /* create a property called filteredProducts to filter the products by search 
            once search is implemented. make sure it actually
            filters the products on the page */
        filteredProducts() {
            const searchTerm= this.$store.state.search.toLowerCase();
            return this.$store.state.products.filter( prod => searchTerm === '' ||
                prod.product_name.toLowerCase().includes(searchTerm));
        }
    }

}
</script>

<style>
    .product-container {
        display: grid;
        grid-template-columns: 1fr 9fr;
        grid-template-areas: "img-panel text-panel";
        border: 2px solid black;
        margin-right: 20px;

    }

    #img-panel {
        grid-area: img-panel;
    }

    #text-panel {
        grid-area: text-panel;
        background-color: #f2f2f2;
        padding-left: 20px;
    }

    .attribution {
        font-size: 10px;
    }

    .cat-filter {
        width: 50%;
        padding-bottom: 10px;
    }
</style>