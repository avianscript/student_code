import axios from 'axios';

const http = axios.create({
  baseURL: "http://localhost:3000"
});

export default {

  list() {
    return http.get('/topics');
  },

  get(id) {
    return http.get(`/topics/${id}`);
  },

  create(topic) {
    return http.post(`/topics`, topic)
  },

  update(topicId, topic) {
    return http.put(`/topics/${topicId}`, topic)
  },

  delete(id) {
    return http.delete(`/topics/${id}`)
  }

}
