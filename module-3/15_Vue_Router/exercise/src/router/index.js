import Vue from 'vue';
import VueRouter from 'vue-router';
import Home from '../views/Home.vue'
import MyBooks from '../views/MyBooks.vue'
import NewBook from '../views/NewBook.vue'
import BookInfo from '../views/BookInfo.vue'

Vue.use(VueRouter);

const routes = [
  {
    path: '/',
    name: 'home',
    component: Home
  },
  {
    path:'/myBooks',
    name: 'myBooks',
    component: MyBooks
  },
  {
    path:'/addBook',
    name: 'addBook',
    component: NewBook
  },
  {
    path:'/book/:isbn',
    name: 'book-details',
    component: BookInfo
  }
];

const router = new VueRouter({
  mode: 'history',
  routes
});

export default router;
