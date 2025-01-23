import axios from "axios";
const USER_BASE_REST_API_URL = "http://localhost:8080";

class UserServices {
  loginUser(user) {
    return axios.post(USER_BASE_REST_API_URL + "/login", user);
  }
  createUser(user) {
    return axios.post(USER_BASE_REST_API_URL + "/create-user", user);
  }
}
export default new UserServices();
