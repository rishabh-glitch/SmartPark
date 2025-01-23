import axios from "axios";
const PREMISE_BASE_REST_API_URL = "http://localhost:8080";

class PremiseService {
  savePremise(premise) {
    return axios.post(PREMISE_BASE_REST_API_URL + "/savePremise", premise);
  }
  getAllPremise() {
    return axios.get(PREMISE_BASE_REST_API_URL + "/getAllPremise");
  }
  getNoOfPremises() {
    return axios.get(PREMISE_BASE_REST_API_URL + "/totalPremises");
  }
}
export default new PremiseService();
