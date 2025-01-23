import axios from "axios";
const PARKING_FLOOR_BASE_REST_API_URL = "http://localhost:8080";

class ParkingFloorService {
  getAllFloors() {
    return axios.get(PARKING_FLOOR_BASE_REST_API_URL + "/getAllFloors");
  }
  saveFloor(parkingfloor) {
    return axios.post(
      PARKING_FLOOR_BASE_REST_API_URL + "/saveFloor",
      parkingfloor
    );
  }
  deleteFloor(parkingPremiseId) {
    return axios.delete(
      PARKING_FLOOR_BASE_REST_API_URL + "/deleteFloor/" + parkingPremiseId
    );
  }
}
export default new ParkingFloorService();
