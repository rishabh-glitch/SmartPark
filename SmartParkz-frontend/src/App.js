import "./App.css";
import "bootstrap/dist/css/bootstrap.min.css";
import { BrowserRouter, Route, Switch } from "react-router-dom";
import HeaderComponent from "./components/HeaderComponent";
import BookParkingSlotComponent from "./components/BookParkingSlotComponent";
import BookedParkingSlot from "./components/BookedParkingSlot";
import CheckAvailabilityComponent from "./components/CheckAvailabilityComponent";
import AddVehicleComponent from "./components/AddVehicleComponent";
import AuthenticatedRoute from "./services/AuthenticatedRoute";
// import Home from './components/Home';
import SavedPremise from "./components/SavedPremise";
import Login from "./components/Login";
import UserHeader from "./components/UserHeader";
import SignUp from "./components/SignUp";
import CreatePremiseComponent from "./components/CreatePremiseComponent";
import ParkedVehicle from "./components/ParkedVehicle";
import CreateFloor2 from "./components/CreateFloor2";
import UpdateFloorDetails from "./components/UpdatedFloorDetails";
import UserHome from "./components/UserHome";
import AdminHome from "./components/AdminHome";
import { useState } from "react";
import Header from "./components/Header";
import AuthenticationService from "./services/AuthenticationService";
import RegisteredVehicle from "./components/RegisteredVehicle";
function App() {
  const [role, setRole] = useState("");
  const handleLogin = userRole => {
    setRole(userRole);
  };
  return (
    <div>
      <BrowserRouter>
        <div>
          {/* {role === "" ? (
            <Login onLogin={handleLogin} />      this part is for choosing header between two for now i am commenting
          ) : (
            <div>
              <Header role={role} />
            </div>
          )} */}
          <Switch>
            <Route exact path="/" component={SignUp}></Route>
            <Route path="/login" component={Login}></Route>
            <AuthenticatedRoute
              path="/userhome"
              component={UserHome}
            ></AuthenticatedRoute>
            <AuthenticatedRoute
              path="/adminhome"
              component={AdminHome}
            ></AuthenticatedRoute>
            <Route
              path="/createpremisecomponent"
              component={CreatePremiseComponent}
            ></Route>
            <AuthenticatedRoute
              path="/parkedvehicle"
              component={ParkedVehicle}
            ></AuthenticatedRoute>
            <AuthenticatedRoute
              path="/parkingpremise"
              component={SavedPremise}
            ></AuthenticatedRoute>
            <AuthenticatedRoute
              path="/createfloor"
              component={CreateFloor2}
            ></AuthenticatedRoute>
            <AuthenticatedRoute
              path="/parkingfloor"
              component={UpdateFloorDetails}
            ></AuthenticatedRoute>
            <AuthenticatedRoute
              path="/home"
              component={HeaderComponent}
            ></AuthenticatedRoute>
            <AuthenticatedRoute
              path="/bookparkingslot"
              component={BookParkingSlotComponent}
            ></AuthenticatedRoute>
            <AuthenticatedRoute
              path="/bookedparkingslot"
              component={BookedParkingSlot}
            ></AuthenticatedRoute>
            <AuthenticatedRoute
              path="/checkavailability"
              component={CheckAvailabilityComponent}
            ></AuthenticatedRoute>
            <AuthenticatedRoute
              path="/registeredvehicles"
              component={RegisteredVehicle}
            ></AuthenticatedRoute>
            <AuthenticatedRoute
              path="/createvehicle"
              component={AddVehicleComponent}
            ></AuthenticatedRoute>
          </Switch>
        </div>
      </BrowserRouter>
    </div>
  );
}

export default App;
