import React, { useState, useEffect } from "react";
import { useHistory, Link, useParams } from "react-router-dom";
import HeaderComponent from "./HeaderComponent";
import ParkingSlotService from "../services/ParkingSlotService";
import { ToastContainer, toast } from "react-toastify";
import UserServices from "../services/UserServices";
import UserHeader from "./UserHeader";

const BookParkingSlotComponent = () => {
  const [parkingFloor, setParkingFloor] = useState({ parkingFloorId: "" });
  const [vehicle, setVehicle] = useState({ vehicleId: "" });
  const [parkingDate, setParkingDate] = useState("");
  const [parkingDuration, setParkingDuration] = useState("");

  const [payment, setPayment] = useState({
    type: "",
    amountPaid: "",
    status: "",
  });
  const [slot_no, setSlotNo] = useState("");
  const [parkingTime, setParkingTime] = useState("");

  const his = useHistory();

  const saveSlot = i => {
    i.preventDefault();
    const parkingslot = {
      parkingFloor,
      vehicle,
      parkingDate,
      parkingTime,
      slot_no,
      parkingDuration,
      payment,
    };
    ParkingSlotService.saveParkingSlot(parkingslot)
      .then(response => {
        console.log(response.data);
        // his.push('/bookedparkingslot');
        saveButton();
      })
      .catch(error => {
        const a = error.response.data;
        document.getElementById("text").innerHTML = a;
        console.log(error.response.data);
      });
  };

  const saveButton = () => {
    toast.success("The details has been saved");
  };

  return (
    <div>
      <ToastContainer />
      <UserHeader />
      <div
        style={{
          background:
            "url(https://images.unsplash.com/photo-1573348722427-f1d6819fdf98?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1374&q=80)center",
          boxShadow:
            "0 12px 15px 0 rgba(0,0,0,.24),0 17px 50px 0 rgba(0,0,0,.19)",
          opacity: "0.9",
        }}
      >
        {/* <Link to="/bookedparkingslot" className='btn btn-outline-info' style={{ marginLeft: "40px", textDecoration: "none", position: 'absolute', marginTop: '100px' }}> View Parking Slots </Link> */}
        <Link
          to="/checkavailability"
          className="btn btn-outline-info"
          style={{
            marginLeft: "40px",
            textDecoration: "none",
            position: "absolute",
            marginTop: "150px",
          }}
        >
          {" "}
          Check Availability{" "}
        </Link>

        <div
          className="container"
          style={{ width: "500px", color: "aliceblue", height: "890px" }}
        >
          <h2 style={{ textAlign: "center" }}>Enter Slot Details</h2>
          <div
            className="row"
            style={{ color: "floralwhite", fontFamily: "monospace" }}
          >
            {/* <div className='card col-md-6 offset-md-3 offset-md-3' style={{ marginTop: "10px", backgroundColor: "gray" }}>
                        {
                            title()
                        } */}
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
                  <label className="form-label">Parking Floor</label>
                  <input
                    type="number"
                    required="required"
                    placeholder="Enter Parking Floor"
                    name="parkingFloorId"
                    className="form-control"
                    value={parkingFloor.parkingFloorId}
                    onChange={i =>
                      setParkingFloor({
                        ...parkingFloor,
                        parkingFloorId: i.target.value,
                      })
                    }
                  ></input>
                </div>
                <div className="form-group mb-2">
                  <label className="form-label">Vehicle</label>
                  <input
                    type="number"
                    required="required"
                    placeholder="Enter Vehicle Id"
                    name="vehicleId"
                    className="form-control"
                    value={vehicle.vehicleId}
                    onChange={i =>
                      setVehicle({ ...vehicle, vehicleId: i.target.value })
                    }
                  ></input>
                </div>
                <div className="form-group mb-2">
                  <label className="form-label">Parking Date</label>
                  <input
                    type="date"
                    required="required"
                    placeholder="Enter Parking Date"
                    name="parkingDate"
                    className="form-control"
                    value={parkingDate}
                    onChange={i => setParkingDate(i.target.value)}
                  ></input>
                </div>
                <div className="form-group mb-2">
                  <label className="form-label">Parking Duration</label>
                  <input
                    type="number"
                    required="required"
                    placeholder="Enter Parking Duration"
                    name="parkingDuration"
                    className="form-control"
                    value={parkingDuration}
                    onChange={i => setParkingDuration(i.target.value)}
                  ></input>
                </div>
                <div className="form-group mb-2">
                  <label className="form-label">Parking Time</label>
                  <input
                    type="text"
                    required="required"
                    placeholder="Enter Parking Time"
                    name="parkingTime"
                    pattern="((1[0-2]|0?[1-9]):([0-5][0-9]) ?([AaPp][Mm]))"
                    className="form-control"
                    value={parkingTime}
                    onChange={i => setParkingTime(i.target.value)}
                  ></input>
                </div>
                <div className="form-group mb-2">
                  <label className="form-label">Parking Slot No</label>
                  <input
                    type="number"
                    required="required"
                    placeholder="Enter Parking Slot No"
                    name="slot_no"
                    className="form-control"
                    value={slot_no}
                    onChange={i => setSlotNo(i.target.value)}
                  ></input>
                </div>
                <h3>ENTER PAYMENT DETAILS</h3>
                <div className="form-group mb-2">
                  <label className="form-label">Payment Type</label>
                  <input
                    type="text"
                    required="required"
                    placeholder="Enter Payment Type"
                    name="type"
                    className="form-control"
                    value={payment.type}
                    onChange={i =>
                      setPayment({ ...payment, type: i.target.value })
                    }
                  ></input>
                </div>
                <div className="form-group mb-2">
                  <label className="form-label">Amount Paid</label>
                  <input
                    type="text"
                    required="required"
                    placeholder="Enter Amount Paid"
                    name="amountPaid"
                    className="form-control"
                    value={payment.amountPaid}
                    onChange={i =>
                      setPayment({ ...payment, amountPaid: i.target.value })
                    }
                  ></input>
                </div>
                <div className="form-group mb-2">
                  <label className="form-label">Status</label>
                  <input
                    type="text"
                    required="required"
                    placeholder="Enter status"
                    name="status"
                    className="form-control"
                    value={payment.status}
                    onChange={i =>
                      setPayment({ ...payment, status: i.target.value })
                    }
                  ></input>
                </div>
                <p
                  id="text"
                  style={{
                    background: "black",
                    display: "inline",
                    padding: "5px",
                    color: "white",
                    borderRadius: "20px",
                  }}
                ></p>
                <button className="btn btn-primary" onClick={i => saveSlot(i)}>
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

export default BookParkingSlotComponent;
