import React, { useState, useEffect } from "react";
import { useHistory, Link, useParams } from "react-router-dom";
import HeaderComponent from "./HeaderComponent";
import ParkingFloorService from "../services/ParkingFloorService";
import { ToastContainer, toast } from "react-toastify";
import UserHeader from "./UserHeader";

const CreateFloor2 = () => {
  const [parkingPremise, setParkingPremise] = useState({
    parkingPremiseId: "",
  });
  const his = useHistory();

  // const [parkingFloor,setparkingFloor] = useState({
  //     floorNumber :"",
  // 	numberOfSlots : "",
  // });

  const [floorNumber, setFloorNumber] = useState("");

  const [numberOfParkingSlots, setNumberOfParkingSlots] = useState("");

  const saveFloor = i => {
    i.preventDefault();
    const addFloor = { parkingPremise, floorNumber, numberOfParkingSlots };

    ParkingFloorService.saveFloor(addFloor)
      .then(response => {
        console.log(response.data);
        his.push("/parkingfloor");
        saveButton();
      })
      .catch(error => {
        console.log(error);
      });
  };
  const saveButton = () => {
    toast.success("The record is saved");
  };

  return (
    <div>
      <HeaderComponent />
      <div
        style={{
          background:
            "url(https://images.unsplash.com/photo-1573348722427-f1d6819fdf98?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1374&q=80)center",
          boxShadow:
            "0 12px 15px 0 rgba(0,0,0,.24),0 17px 50px 0 rgba(0,0,0,.19)",
          opanumber: "0.9",
        }}
      >
        <Link
          to="/parkingfloor"
          className="btn btn-outline-info"
          style={{
            marginLeft: "40px",
            textDecoration: "none",
            position: "absolute",
            marginTop: "100px",
          }}
        >
          {" "}
          View Parking Floor{" "}
        </Link>
        <div
          className="container"
          style={{ width: "500px", color: "aliceblue", height: "569px" }}
        >
          <h2 style={{ textAlign: "center" }}>Enter Floor Details</h2>
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
                  <label className="form-label">Parking Premise Id</label>
                  <input
                    type="text"
                    placeholder="Enter Premise Id"
                    name="Premise Id"
                    className="form-control"
                    value={parkingPremise.parkingPremiseId}
                    onChange={i =>
                      setParkingPremise({
                        ...parkingPremise,
                        parkingPremiseId: i.target.value,
                      })
                    }
                  ></input>
                </div>

                <h3>ENTER FLOOR Details</h3>
                <div className="form-group mb-2">
                  <label className="form-label">Floor Number</label>
                  <input
                    type="text"
                    placeholder="Enter Floor Number"
                    name="Floor Number"
                    className="form-control"
                    value={floorNumber}
                    onChange={i => setFloorNumber(i.target.value)}
                  ></input>
                </div>

                <div className="form-group mb-2">
                  <label className="form-label">Number Of Slots</label>
                  <input
                    type="text"
                    placeholder="Number Of Slots"
                    name="Number Of Slots"
                    className="form-control"
                    value={numberOfParkingSlots}
                    onChange={i => setNumberOfParkingSlots(i.target.value)}
                  ></input>
                </div>

                <button className="btn btn-primary" onClick={i => saveFloor(i)}>
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
export default CreateFloor2;
