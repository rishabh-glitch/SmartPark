import React, { useState, useEffect } from "react";
import { useHistory, Link, useParams } from "react-router-dom";
import HeaderComponent from "./HeaderComponent";
import PremiseService from "../services/PremiseService";
import { ToastContainer, toast } from "react-toastify";
import UserHeader from "./UserHeader";

const CreatePremiseComponent = () => {
  const [parkingPremiseName, setParkingPremiseName] = useState("");

  const [premiseAddress, setPremiseAddress] = useState({
    city: "",
    state: "",
    pin: "",
  });
  const [numberOfParkingFloors, setNumberOfParkingFloors] = useState("");
  const his = useHistory();

  const savePremise = i => {
    i.preventDefault();
    const addPremise = {
      parkingPremiseName,
      premiseAddress,
      numberOfParkingFloors,
    };

    PremiseService.savePremise(addPremise)
      .then(response => {
        console.log(response.data);
        his.push("/parkingpremise");
        saveButton();
      })
      .catch(error => {
        console.log(error);
      });
  };
  const saveButton = () => {
    toast.success("The details has been saved");
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
          opacity: "0.9",
        }}
      >
        <Link
          to="/parkingpremise"
          className="btn btn-outline-info"
          style={{
            marginLeft: "40px",
            textDecoration: "none",
            position: "absolute",
            marginTop: "100px",
          }}
        >
          {" "}
          View Parking Premise{" "}
        </Link>
        <div
          className="container"
          style={{ width: "500px", color: "aliceblue", height: "569px" }}
        >
          <h2 style={{ textAlign: "center" }}>Enter Premise Details</h2>
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
                  <label className="form-label">Parking Premise Name</label>
                  <input
                    type="text"
                    placeholder="Enter Premise Name"
                    name="Premise Name"
                    className="form-control"
                    value={parkingPremiseName}
                    onChange={i => setParkingPremiseName(i.target.value)}
                  ></input>
                </div>
                <h3>ENTER ADDRESS</h3>
                <div className="form-group mb-2">
                  <label className="form-label">Premise City</label>
                  <input
                    type="text"
                    placeholder="Enter Premise City"
                    name="Premise City"
                    className="form-control"
                    value={premiseAddress.city}
                    onChange={i =>
                      setPremiseAddress({
                        ...premiseAddress,
                        city: i.target.value,
                      })
                    }
                  ></input>
                </div>
                <div className="form-group mb-2">
                  <label className="form-label">Premise State</label>
                  <input
                    type="text"
                    placeholder="Enter Premise State"
                    name="Premise State"
                    className="form-control"
                    value={premiseAddress.state}
                    onChange={i =>
                      setPremiseAddress({
                        ...premiseAddress,
                        state: i.target.value,
                      })
                    }
                  ></input>
                </div>
                <div className="form-group mb-2">
                  <label className="form-label">Premise Pin</label>
                  <input
                    type="number"
                    placeholder="Enter Pin"
                    name="Pin"
                    className="form-control"
                    value={premiseAddress.pin}
                    onChange={i =>
                      setPremiseAddress({
                        ...premiseAddress,
                        pin: i.target.value,
                      })
                    }
                  ></input>
                </div>

                <div className="form-group mb-2">
                  <label className="form-label">Number Of Floors</label>
                  <input
                    type="text"
                    placeholder="Enter Total Floors"
                    name="Floors"
                    className="form-control"
                    value={numberOfParkingFloors}
                    onChange={i => setNumberOfParkingFloors(i.target.value)}
                  ></input>
                </div>
                <button
                  className="btn btn-primary"
                  onClick={i => savePremise(i)}
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
export default CreatePremiseComponent;
