<template>
  <div class="book-container">
    <book-card v-for="(curBook, index) in books" :key="index"
      v-bind:book="curBook"/>
    
  </div>
</template>

<script>
import BookCard from './BookCard.vue'

export default {
  components: { BookCard},
    name: 'reading-list',
    computed: {
      books() {
        return this.$store.state.books;
      }
    }
}
</script>

<style>
.book-container {
    display:flex;
    justify-content: space-evenly;
    flex-wrap: wrap;
}
</style>