import axios from "axios";
const USER_NAME_SESSION_ATTRIBUTE = "authenticatedUser";
class AuthenticationService {
  executeBasicAuthenticationService(username, password) {
    return axios.get("http://localhost:8080/basicauth", {
      headers: { authorization: this.createBasicAuthToken(username, password) },
    });
  }
  executeJwtAuthenticationService(username, password) {
    return axios.post("http://localhost:8080/authenticate", {
      username,
      password,
    });
  }
  createBasicAuthToken(username, password) {
    return "Basic " + window.btoa(username + ":" + password);
  }
  registerSuccesfulLogin(username, password) {
    sessionStorage.setItem(USER_NAME_SESSION_ATTRIBUTE, username);
    this.setupAxiosInterceptors(this.createBasicAuthToken(username, password));
  }
  registerSuccesfulLoginForJwt(username, token) {
    sessionStorage.setItem(USER_NAME_SESSION_ATTRIBUTE, username);
    this.setupAxiosInterceptors(this.createJWTToken(token));
  }
  createJWTToken(token) {
    return "Bearer " + token;
  }
  logout() {
    sessionStorage.removeItem(USER_NAME_SESSION_ATTRIBUTE);
  }
  isUserLoggedIn() {
    let user = sessionStorage.getItem(USER_NAME_SESSION_ATTRIBUTE);
    if (user === null) return false;
    return true;
  }
  setupAxiosInterceptors(token) {
    axios.interceptors.request.use(config => {
      if (this.isUserLoggedIn()) {
        config.headers.authorization = token;
      }
      return config;
    });
  }
}
export default new AuthenticationService();
