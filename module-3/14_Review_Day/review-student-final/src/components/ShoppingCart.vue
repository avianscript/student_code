<template>
    <div>
        <div class="container">
            <header>
                <h1>Items in cart:</h1>
            </header>

            <main>
                <div class="items">
                        <!-- display all the items in the cart -->
                        <div class="item" v-for="(item, index) in cartItems" :key="index" >
                            <!-- this should remove the item from the cart (put the event on the span)-->
                            <span class="remove" v-on:click="removeFromCart(item)"><i class="fas fa-trash-alt"></i></span>
                            <!-- add the product name -->
                            <span class="product-name">{{ item.product_name }}</span>
                            
                            <!-- add the product price -->
                            <span class="product-price">$ {{ item.product_price }}</span>
                        </div>
                        <cart-total class="total"/>
                </div>
            </main>
        </div>
    </div>
</template>

<script>
import CartTotal from './CartTotal.vue';
export default {
  components: { CartTotal },
    name: 'shopping-cart',
    computed: {
        cartItems() {
            const cart = this.$store.state.cart;
            return this.$store.state.products.filter( product => {
                return cart.includes(product.product_id);
            });
        }
    },
    methods: {
        removeFromCart(productToRemove) {
            this.$store.commit('REMOVE_FROM_CART', productToRemove);
        } 
    }
}
</script>

<style scoped>
    .container {
        height: 100vh;
        text-align: left;
        padding: 0px 20px;
    }

    
    .item {
        padding-bottom: 10px;
        font-weight: bold;
        display: grid;
        grid-template-columns: 10% 1fr 20%;
        grid-template-areas: 
            "remove product-name product-price"
            "total total total";
        column-gap: 10px;
    }

    .product-name {
        font-size: 12px;
        grid-area: product-name;
    }

    .remove:hover {
        color: green;
    }

    .product-price {
        grid-area: product-price;
    }

    .total {
        grid-area: total;
    }
    
</style>