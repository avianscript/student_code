<template>
    <div id="main-container">
        <div id="panel">
            <div id="product-name">
                <!-- product name goes here -->
                {{  product.product_name }}
            </div>
           
            <div id="rating-price"> 
                <!-- modify this so it creates as many stars as intRating returns -->
                <!-- only show this if there is a rating. you can check that by
                    checking if the intRating is more than 0
                 -->
                <div v-for="starNum in intRating" :key="starNum">
                    <img class="rating-star" src="../assets/star-symbol.png" />

                </div>
                <div>
                    <!-- this will be shown if we need a half star the showHalfStar
                        property indicates this -->
                    <img class="rating-star" src="../assets/star-half-yellow.png" v-show="showHalfStar"/>
                </div>
                <!-- show this section if there is no rating. you can check this by checking
                    if intRating is 0
                -->
                <div id="no-rating" v-show="intRating === 0">
                    No rating available.
                </div>

                <!-- product price goes here -->
                <!-- only show this is if price available (product_price will be '' if there is no price) -->
                <div id="price" v-show="product.product_price != ''">

                    $ {{ product.product_price }}

                </div>

                <!-- show this section if there is no price is available (product_price will be '' if there is no price) -->
                <div id="no-price" v-show="product.product_price === ''">
                    No price information available.
                </div>
            </div>

            <!-- if item not in cart, show add to cart button -->
            <div class="add-to-cart" v-show="!inCart">
                <!-- clicking on button should add the item to the cart -->
                <!-- this button should be disabled if price is not available -->
                <button  class="blue-button" v-bind:disabled="product.product_price === ''" v-on:click="addToCart()">
                    <i class="fas fa-cart-plus"></i>
                </button>
            </div>
            <!-- if item already in cart show this message -->
            <div class="in-cart" v-show="inCart">
                Already in cart
            </div>
        </div>
  </div>
</template>

<script>
export default {
    name: 'product-detail',
    props: ['product'],
    computed: {
        intRating() {
            return parseInt(this.product.product_rating);
        },
        showHalfStar() {
            return (this.product.product_rating - this.intRating) >= .5;
        },
        inCart() {
            /* check if item is in cart. note that cart currently only
                stores product id */

            /* placeholder - should return correct value*/
            const theCart = this.$store.state.cart;

            if (theCart.includes(this.product.product_id)) {
                return true;
            }

            return false;
        }
    },
    methods: {
        addToCart() {
            this.$store.commit('ADD_TO_CART', this.product);
        }
    }
}
</script>

<style scoped>

    #panel {
        display: flex;
        flex-direction: column;
        justify-content: space-around;
        margin-top: 20px;
    }

    #product-name {
        font-family: Haettenschweiler, 'Arial Narrow Bold', sans-serif;
        font-weight: bold;
        font-size: 18px;
        text-align: left;
    }

    #price {
        font-family: Haettenschweiler, 'Arial Narrow Bold', sans-serif;
        font-size: 18px;
        text-align: left;
        margin-left: 20px;
        margin-top: auto;
        margin-bottom: auto;
    }

    #no-rating, #no-price{
        margin-top: auto;
        margin-bottom: auto;
        color: red;
    }

    #rating-price {
        margin-top: 20px;
        display: flex;
        font-weight: bold;
    }

    .rating-star {
        width: 30px;
        height: auto;
        align-self: top;
    }

    .add-to-cart, .in-cart {
        font-size: 28px;
        text-align: right;
        padding-top: 20px;

        padding-right: 40px;
        color: blue;
    }

    .in-cart {
        font-size: 20px;
        margin-top: 10px;
    }

    .blue-button {
        color: blue;
    }

</style>