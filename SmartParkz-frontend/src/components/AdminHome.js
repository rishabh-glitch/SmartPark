import React, { useEffect, useState } from "react";
import HeaderComponent from "./HeaderComponent";
import PremiseService from "../services/PremiseService";

const AdminHome = () => {
  const [premises, setPremises] = useState("");
  useEffect(() => {
    getNoOfPremises();
  }, []);

  const getNoOfPremises = () => {
    PremiseService.getNoOfPremises()
      .then(response => {
        setPremises(response.data);
        console.log(response.data);
      })
      .catch(error => {
        console.log(error);
      });
  };

  return (
    //  <div className="container-fluid p-0 m-0">
    <div style={{ backgroundColor: "white" }}>
      <HeaderComponent />

      <div class="content-wrapper">
        <div
          className="image-container"
          style={{ position: "relative", height: "600px" }}
        >
          <img
            src="https://media.istockphoto.com/id/168621310/photo/new-and-used-cars.jpg?s=612x612&w=0&k=20&c=c1Aoauh0mCNb5h8cbpO-kZ8RFlrEHZHgOfSpRx7C6PQ="
            width="100%"
            height="auto"
            alt=" image"
          />
          <div class="container-fluid" style={{}}>
            <div
              class="row"
              style={{ width: "100%", position: "absolute", top: "20px" }}
            >
              {/* <!-- Icon Cards--> */}
              <div
                class="col-lg-4 col-md-4 col-sm-6 col-12 mb-2 mt-4"
                style={{
                  borderRight: "6px solid black",
                  borderLeft: "6px solid black",
                  borderBottom: "6px solid black",
                  padding: "20px",
                  fontFamily: "monospace",
                }}
              >
                <div class="inforide">
                  <div class="row">
                    <div class="col-lg-3 col-md-4 col-sm-4 col-4 rideone">
                      {/* <img src="https://vignette.wikia.nocookie.net/nationstates/images/2/29/WS_Logo.png/revision/latest?cb=20080507063620"> */}
                    </div>
                    <div class="col-lg-9 col-md-8 col-sm-8 col-8 fontsty">
                      <h4>Parking Premises</h4>
                      <h2>{premises}</h2>
                    </div>
                  </div>
                </div>
              </div>

              <div
                class="col-lg-4 col-md-4 col-sm-6 col-12 mb-2 mt-4"
                style={{
                  borderRight: "6px solid black",
                  borderBottom: "6px solid black",
                  padding: "20px",

                  fontFamily: "monospace",
                }}
              >
                <div class="inforide">
                  <div class="row">
                    <div class="col-lg-3 col-md-4 col-sm-4 col-4 ridetwo">
                      {/* <img src="https://vignette.wikia.nocookie.net/nationstates/images/2/29/WS_Logo.png/revision/latest?cb=20080507063620"> */}
                    </div>
                    <div class="col-lg-9 col-md-8 col-sm-8 col-8 fontsty">
                      <h4>Available Slots</h4>
                      <h2>120</h2>
                    </div>
                  </div>
                </div>
              </div>

              <div
                class="col-lg-4 col-md-4 col-sm-6 col-12 mb-2 mt-4"
                style={{
                  borderRight: "6px solid black",
                  borderBottom: "6px solid black",
                  padding: "20px",

                  fontFamily: "monospace",
                }}
              >
                <div class="inforide">
                  <div class="row">
                    <div class="col-lg-3 col-md-4 col-sm-4 col-4 ridethree">
                      {/* <img src="https://vignette.wikia.nocookie.net/nationstates/images/2/29/WS_Logo.png/revision/latest?cb=20080507063620"> */}
                    </div>
                    <div class="col-lg-9 col-md-8 col-sm-8 col-8 fontsty">
                      <h4>Booked Slots</h4>
                      <h2>50</h2>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default AdminHome;
