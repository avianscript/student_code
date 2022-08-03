<template>
    <div id="addBook">
        <new-book-form />
    </div>
</template>

<script>
import NewBookForm from '../components/NewBookForm.vue';

    export default {
        name: 'addBook',
        components: {
                NewBookForm
        }
    }

              
</script>