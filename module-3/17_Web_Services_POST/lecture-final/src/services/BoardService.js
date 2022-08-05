import axios from 'axios';

const http = axios.create({
  baseURL: "http://localhost:3000"
});

export default {

  getBoards() {
    return http.get('/boards');
  },

  getCards(boardID) {
    return http.get(`/boards/${boardID}`)
  },

  getCard(cardID) {
    return http.get(`/cards/${cardID}`)
  },

  addCard(card) {
    return http.post('/cards', card);

    // Invalud url will causes Client Exception I(404 Not Found)
    // return http.post('/cardsxxx', card);

    // using axios instead of http object means no baseUrl configured
    // we set a non-existant one which will cause ResourceAccessException type error
    // return axios.post('http://localhost:5000/cards', card);
  },

  updateCard(card) {
    return http.put(`/cards/${card.id}`, card);
  },

  deleteCard(cardID) {
    return http.delete(`/cards/${cardID}`);
  },
  addBoard(board) {
    return http.post('/boards', board);
  },
  deleteBoard(boardId) {
    return http.delete(`/boards/${boardId}`);
  }

}
