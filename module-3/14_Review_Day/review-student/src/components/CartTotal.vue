<template>
    <div class="total">
        <!-- add the total cost here -->
        Total: ${{ totalCost }}
    </div>

</template>

<script>
export default {
    name: 'cart-total',
    computed: {
        totalCost() {
            /* transform the cartItems (use the computed property below) to an array of their product_prices*/


            /* sum all the prices and return tne sum
            *
            * you will need to use parseFloat to convert the prices to decimal numbers
            * 
            * you will also need to use toFixed(2) on the sum to format the result correctly
            */
           

            /* placeholder - this will change*/
            return 0;
        },
        cartItems() {
            const cart = this.$store.state.cart;
            return this.$store.state.products.filter( product => {
                return cart.includes(product.product_id);
            });
        }
    }

}
</script>

<style>

    .total {
        text-align: right;
        color: blue;
    }

</style>