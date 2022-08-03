<template>
  <div>
    <div class="loading" v-if="isLoading">
      <img src="../assets/ping_pong_loader.gif" />
    </div>
    <!-- you can include a v-else on the VERY NEXT element after an element that has a v-if but ONLY the next -->
    <div v-else>
      <router-link
        :to="{ name: 'Board', params: { id: $route.params.boardID } }"
      >
        Back to Board
      </router-link>

      <h1>{{ card.title }}</h1>
      <p>{{ card.description }}</p>
      <comments-list :comments="card.comments" />

      <!-- if you want to control an element that isn't the very next one you can use an opposite
        v-if -->

      <!-- <comments-list :comments="card.comments" v-if="!isLoading"/> -->
    </div>
  </div>
</template>

<script>
import boardService from "@/services/BoardService";
import CommentsList from "./CommentsList.vue";

export default {
  components: { CommentsList },
  name: "card-detail",
  data() {
    return {
      card: {
        title: "",
        description: "",
        status: "",
        comments: [],
      },
      isLoading: true,
    };
  },
  created() {
    boardService
      .getCard(this.$route.params.boardID, this.$route.params.cardID)
      .then((cardData) => {
        this.card = cardData;
        this.isLoading = false;
      });
  },
};
</script>
