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

  getCard(boardID, cardID) {
    /*
    think about this is as... by default http.get returns a response when the promise resolves. 
    this will be what the code that is waiting on the promise from the service receives back
    this will be what is you could think of this
    
      return http.get(`/boards/${boardID}`).then((response) => { return response }

      what we have here is just an implementation that returns a specific piece of data rather
      than the whole response
    */
    return http.get(`/boards/${boardID}`).then((response) => {
      const cards = response.data.cards;
      return cards.find(card => card.id == cardID);
    })
  }

}
