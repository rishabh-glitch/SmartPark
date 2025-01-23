import React, { useState, useEffect } from "react";
import { Link } from "react-router-dom";
import HeaderComponent from "./HeaderComponent";

import { ToastContainer, toast } from "react-toastify";
import PremiseService from "../services/PremiseService";

const SavedPremise = () => {
  const [premise, setPremise] = useState([]);
  useEffect(() => {
    getAllPremise();
  }, []);

  const getAllPremise = () => {
    PremiseService.getAllPremise()
      .then(response => {
        setPremise(response.data);
        console.log(response.data);
      })
      .catch(error => {
        console.log(error);
      });
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
        PREMISES
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
          <th style={{ padding: "20px" }}> PREMISE ID</th>
          <th style={{ padding: "20px" }}> Premise City </th>
          <th style={{ padding: "20px" }}> Premise Name </th>
          <th style={{ padding: "20px" }}> Premise State </th>
          <th style={{ padding: "20px" }}> Premise Pin </th>
          <th style={{ padding: "20px" }}> Premise Floors</th>
        </thead>
        <tbody style={{ textAlign: "center", background: "" }}>
          {premise.map(addpremise => (
            <tr key={addpremise.id}>
              <td>{addpremise.parkingPremiseId}</td>
              <td>{addpremise.premiseAddress.city}</td>
              <td>{addpremise.parkingPremiseName}</td>
              <td>{addpremise.premiseAddress.state}</td>
              <td>{addpremise.premiseAddress.pin}</td>
              <td>{addpremise.numberOfParkingFloors}</td>
            </tr>
          ))}
        </tbody>
      </table>
      <div></div>
    </div>
  );
};
export default SavedPremise;
