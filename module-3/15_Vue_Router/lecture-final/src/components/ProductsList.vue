<template>
  <table>
    <thead>
      <tr>
        <th>ID</th>
        <th>Name</th>
        <th># Reviews</th>
      </tr>
    </thead>
    <tbody>
      <tr v-for="product in $store.state.products" v-bind:key="product.id">
        <td>{{ product.id }}</td>
        <router-link
          v-bind:to="{
            name: 'product-details',
            params: { productId: product.id }
          }"
        >
          <td>{{ product.name }}</td>
        </router-link>

        <!-- <router-link
          v-bind:to="{
            name: 'product-details',
            params: { productId: product.id },
            query: { nameVal: 'Yoav' + product.id },
          }"
        >
          <td>{{ product.name }}</td>
        </router-link> -->

        <td>{{ product.reviews.length }}</td>
      </tr>
    </tbody>
  </table>
</template>

<script>
export default {
  name: "products-list",
};
</script>

<style style="scoped">
th,
td {
  text-align: left;
}
td {
  padding-right: 10px;
  vertical-align: top;
}
tr:nth-child(even) {
  background-color: rgb(238, 238, 238);
}
</style>
