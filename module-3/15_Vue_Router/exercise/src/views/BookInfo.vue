<template>
    <div>
        <book-details :book="bookInfo"/>
    </div>
</template>

<script>
import BookDetails from '../components/BookDetails.vue'
export default {
    components: { BookDetails },
    name: 'book-info',
    computed: {
        bookInfo() {
            return this.$store.state.books.find(currentBook =>
            currentBook.isbn === this.$route.params.isbn);
        }
    } 

}


</script>
