import axios from "axios";
const VEHICLE_BASE_REST_API_URL = "http://localhost:8080/vehicles";

class VehicleService {
  saveVehicle(vehicle) {
    return axios.post(VEHICLE_BASE_REST_API_URL + "/add", vehicle);
  }
  getAllVehicle() {
    return axios.get(VEHICLE_BASE_REST_API_URL + "/getAllVehicles");
    // let username = "user";
    // let password = "password";
    // let basicAuthHeader = "Basic " + window.btoa(username + ":" + password);
    // return axios.get(VEHICLE_BASE_REST_API_URL + "/users", {
    //   headers: {
    //     authorization: basicAuthHeader,
    //   },
    // });
  }
  deleteVehicle(vehicleId) {
    return axios.delete(VEHICLE_BASE_REST_API_URL + "/users/" + vehicleId);
  }
}
export default new VehicleService();
