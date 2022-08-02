<template>
  <div>
      <!-- create a search field with the id search-term -->
      <!-- the field should be update the searchTerm and
       call the code to update the search filter as you type -->
      <label for="search-term">Search: </label>
      <input type="text" id="search-term" v-model="searchTerm" v-on:keyup="updateSearchFilter"/>
  </div>
</template>

<script>
export default {
    name: 'product-search',
    data() {
        return {
            searchTerm: ''
        }
    },
    methods: {
        updateSearchFilter() {
            // update the $store with the search term
            this.$store.commit('UPDATE_SEARCH', this.searchTerm);
        }
    }
    

}
</script>

<style scoped>
    label {
        display: inline;
    }

    #serch-term {
        width: 70%;
    }
</style>