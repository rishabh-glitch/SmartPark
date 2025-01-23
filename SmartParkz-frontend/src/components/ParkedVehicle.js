import React, { useState, useEffect } from "react";
import { Link } from "react-router-dom";
import HeaderComponent from "./HeaderComponent";
import VehicleService from "../services/VehicleService";
import { ToastContainer, toast } from "react-toastify";
import HelloWorldService from "../services/HelloWorldService";

const ParkedVehicle = () => {
  const [vehicles, setVehicles] = useState([]);
  useEffect(() => {
    getAllVehicle();
  }, []);

  const getAllVehicle = () => {
    VehicleService.getAllVehicle()
      .then(response => {
        setVehicles(response.data);
        console.log(response.data);
      })
      .catch(error => {
        console.log(error);
      });
  };
  const deleteVehicle = userId => {
    VehicleService.deleteVehicle(userId)
      .then(response => {
        getAllVehicle(userId);
        deleteButton();
      })
      .catch(error => {
        console.log(error);
      });
  };
  //   just a testing code not related to project
  // const getGreet = () => {
  //   HelloWorldService.helloWorld()
  //     .then(response => console.log(response))
  //     .catch(error => {
  //       console.log(error);
  //     });
  // };
  const deleteButton = () => {
    toast.success("The record has been deleted");
  };
  return (
    <div style={{ backgroundColor: "#d4d3eb", height: "650px" }}>
      <ToastContainer />
      <HeaderComponent />
      <br></br>
      <br></br>
      {/*<Link to="/createvehicle" className='btn btn-primary' style={{float:"right",marginRight:"50px",textDecoration:"none"}}> + PARKED VEHICLE</Link>*/}
      <h2
        className="text-center"
        style={{ fontFamily: "auto", textDecoration: "auto" }}
      >
        VEHICLES
      </h2>
      <table
        className="table container table-bordered table-striped table-hover"
        style={{
          backgroundColor: "aliceblue",
          marginTop: "40px",
          borderRadius: "25px",
        }}
      >
        <thead style={{ padding: "20px", textAlign: "center" }}>
          <th style={{ padding: "20px" }}> VEHICLE ID</th>
          <th style={{ padding: "20px" }}> Vehicle Number </th>
          <th style={{ padding: "20px" }}> Vehicle Type </th>
          <th style={{ padding: "20px" }}> Vehicle Company </th>
          <th style={{ padding: "20px" }}> Vehicle Model</th>
          <th style={{ padding: "20px" }}> Owner name </th>
        </thead>
        <tbody style={{ textAlign: "center", background: "" }}>
          {vehicles.map(addvehicle => (
            <tr key={addvehicle.id}>
              <td>{addvehicle.vehicleId}</td>
              <td>{addvehicle.vehicleNumber}</td>
              <td>{addvehicle.vehicleType}</td>
              <td>{addvehicle.vehicleCompany}</td>
              <td>{addvehicle.vehicleModel}</td>
              <td>{addvehicle.user.firstName}</td>

              <td>
                <button
                  className="btn btn-danger"
                  onClick={() => deleteVehicle(addvehicle.vehicleId)}
                >
                  Delete
                </button>
              </td>
              {/* <td><Link className='btn btn-info' to={`/edit-insurance/${insurance.id}`}>Update</Link></td> */}
            </tr>
          ))}
        </tbody>
      </table>
      {/* <div>
        <button className="btn btn-danger" onClick={getGreet}>
          Get welcome
        </button>
      </div> */}
    </div>
  );
};
export default ParkedVehicle;
