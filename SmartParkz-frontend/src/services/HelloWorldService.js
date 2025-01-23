import React from "react";
import axios from "axios";
const HELLO_WORLD_URL = "http://localhost:8080";

class HelloWorldService {
  helloWorld() {
    let username = "user";
    let password = "password";
    let basicAuthHeader = "Basic " + window.btoa(username + ":" + password);
    return axios.get(HELLO_WORLD_URL + "/hello-world", {
      headers: {
        authorization: basicAuthHeader,
      },
    });
  }
}

export default new HelloWorldService();
