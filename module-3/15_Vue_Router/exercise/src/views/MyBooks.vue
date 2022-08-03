<template>
    <div id="myBooks">
        <reading-list />
        <router-link v-bind:to="{ name: 'addBook'}">Add a Book!</router-link>
    </div>
</template>

<script>
import ReadingList from '../components/ReadingList.vue';

    export default {
        name: 'myBooks',
        components: {
             ReadingList
        }
    }

              
</script>