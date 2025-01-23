import React, { useState, useEffect } from "react";
import { useHistory, Link, useParams } from "react-router-dom";
import HeaderComponent from "./HeaderComponent";
import VehicleService from "../services/VehicleService";
import UserHeader from "./UserHeader";
import { ToastContainer, toast } from "react-toastify";

const AddVehicleComponent = () => {
  const [vehicleNumber, setVehicleNumber] = useState("");
  const [vehicleType, setVehicleType] = useState("");
  const [vehicleCompany, setVehicleCompany] = useState("");
  const [vehicleModel, setVehicleModel] = useState("");
  const [user, setUser] = useState({ userId: "" });
  const his = useHistory();

  const saveVehicle = i => {
    i.preventDefault();
    const addvehicle = {
      vehicleType,
      vehicleNumber,
      vehicleCompany,
      vehicleModel,
      user,
    };

    VehicleService.saveVehicle(addvehicle)
      .then(response => {
        addedVehicle();
        console.log(response.data);
      })
      .catch(error => {
        console.log("Came in error");
        console.log(error);
      });
  };
  const addedVehicle = () => {
    toast.success("Your vehicle is added");
  };

  return (
    <div>
      <UserHeader />
      <ToastContainer />
      <div
        style={{
          background:
            "url(https://images.unsplash.com/photo-1573348722427-f1d6819fdf98?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1374&q=80)center",
          boxShadow:
            "0 12px 15px 0 rgba(0,0,0,.24),0 17px 50px 0 rgba(0,0,0,.19)",
          opacity: "0.9",
        }}
      >
        <div
          className="container"
          style={{ width: "500px", color: "aliceblue", height: "569px" }}
        >
          <h2 style={{ textAlign: "center" }}>Enter Vehicle Details</h2>
          <div
            className="row"
            style={{ color: "floralwhite", fontFamily: "monospace" }}
          >
            <div
              className="card-body"
              style={{
                background: "black",
                padding: "23px",
                color: "white",
                borderRadius: "40px",
              }}
            >
              <form>
                <div className="form-group mb-2">
                  <label className="form-label">Vehicle Number</label>
                  <input
                    type="text"
                    placeholder="Enter Vehicle Number"
                    name="VehicleNumber"
                    className="form-control"
                    value={vehicleNumber}
                    onChange={i => setVehicleNumber(i.target.value)}
                  ></input>
                </div>
                <div className="form-group mb-2">
                  <label className="form-label">Vehicle Type</label>

                  <input
                    type="text"
                    placeholder="Enter Vehicle Type"
                    name="VehicleType"
                    className="form-control"
                    value={vehicleType}
                    onChange={i => setVehicleType(i.target.value)}
                  ></input>
                </div>
                <div className="form-group mb-2">
                  <label className="form-label">Vehicle Company</label>
                  <input
                    type="text"
                    placeholder="Enter Vehicle Company"
                    name="VehicleCompany"
                    className="form-control"
                    value={vehicleCompany}
                    onChange={i => setVehicleCompany(i.target.value)}
                  ></input>
                </div>
                <div className="form-group mb-2">
                  <label className="form-label">Vehicle Model</label>
                  <input
                    type="text"
                    placeholder="Enter Vehicle Model"
                    name="VehicleModel"
                    className="form-control"
                    value={vehicleModel}
                    onChange={i => setVehicleModel(i.target.value)}
                  ></input>
                </div>
                <div className="form-group mb-2">
                  <label className="form-label">User ID</label>
                  <input
                    type="text"
                    placeholder="Enter Vehicle Model"
                    name="VehicleModel"
                    className="form-control"
                    value={user.userId}
                    onChange={i => setUser({ ...user, userId: i.target.value })}
                  ></input>
                </div>
                <button
                  className="btn btn-primary"
                  onClick={i => saveVehicle(i)}
                >
                  Submit
                </button>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};
export default AddVehicleComponent;
