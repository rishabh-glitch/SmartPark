import UserHeader from "./UserHeader";
import React, { useState, useEffect } from "react";
import { ToastContainer } from "react-toastify";
import VehicleService from "../services/VehicleService";
const RegisteredVehicle = () => {
  const [vehicles, setVehicles] = useState([]);

  useEffect(() => {
    getAllVehicles();
  }, []);

  const getAllVehicles = () => {
    VehicleService.getAllVehicle()
      .then(response => {
        setVehicles(response.data);
        console.log(response.data);
      })
      .catch(error => {
        console.log(error);
      });
  };
  return (
    <div>
      <div style={{ backgroundColor: "#d4d3eb", height: "650px" }}>
        <ToastContainer />
        <UserHeader />
        <br></br>
        <br></br>
        {/* <Link to="/bookparkingslot" className='btn btn-primary' style={{float:"right",marginRight:"50px",textDecoration:"none"}}> + BOOK SLOT </Link> */}
        <h2
          className="text-center"
          style={{ fontFamily: "auto", textDecoration: "auto" }}
        >
          Registered Vehicles
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
            <th style={{ padding: "20px" }}> Vehicle Company</th>
            <th style={{ padding: "20px" }}> Vehicle Model </th>
            <th style={{ padding: "20px" }}> Vehicle Number </th>
            <th style={{ padding: "20px" }}> Vehicle Type </th>
          </thead>
          <tbody style={{ textAlign: "center", background: "" }}>
            {vehicles.map(vehicle => (
              <tr key={vehicle.id}>
                <td>{vehicle.vehicleCompany}</td>
                <td>{vehicle.vehicleModel}</td>
                <td>{vehicle.vehicleNumber}</td>
                <td>{vehicle.vehicleType}</td>

                {/* <td><Link className='btn btn-info' to={`/edit-insurance/${insurance.id}`}>Update</Link></td> */}
              </tr>
            ))}
          </tbody>
        </table>
        <div></div>
      </div>
    </div>
  );
};
export default RegisteredVehicle;
