import React from "react";
import Container from "react-bootstrap/Container";
import Nav from "react-bootstrap/Nav";
import Navbar from "react-bootstrap/Navbar";
import { Link } from "react-router-dom";
import NavDropdown from "react-bootstrap/NavDropdown";
import AuthenticationService from "../services/AuthenticationService";
import { NavbarBrand } from "react-bootstrap";

const HeaderComponent = () => {
  return (
    <Navbar style={{ backgroundColor: "white" }} expand="lg">
      <Container style={{ maxWidth: "1300px" }}>
        <Navbar.Brand href="#home" style={{ color: "#037bfc" }}></Navbar.Brand>
        <Navbar.Toggle aria-controls="basic-navbar-nav" />
        <Navbar.Collapse id="basic-navbar-nav">
          <Nav className="me-auto">
            <Link
              to="/adminhome"
              className="nav-link active"
              style={{ color: "#037bfc" }}
            >
              Home
            </Link>
            {/* <Link to="/bookparkingslot" className='nav-link active' style = {{color:"aliceblue"}}>BookSlots</Link> */}
            <Link
              to="/createpremisecomponent"
              className="nav-link active"
              style={{ color: "#037bfc" }}
            >
              Create Premise
            </Link>
            <Link
              to="/createfloor"
              className="nav-link active"
              style={{ color: "#037bfc" }}
            >
              Create Floor
            </Link>
            <Link
              to="/bookedparkingslot"
              className="nav-link active"
              style={{ color: "#037bfc" }}
            >
              Booked Slots
            </Link>
            <Link
              to="/parkedvehicle"
              className="nav-link active"
              style={{ color: "#037bfc" }}
            >
              Registered Vehicles
            </Link>
            <Link
              className="btn btn-danger"
              to="/"
              style={{ marginLeft: "540px" }}
              onClick={AuthenticationService.logout}
            >
              Logout
            </Link>
          </Nav>
        </Navbar.Collapse>
      </Container>
    </Navbar>
  );
};

export default HeaderComponent;
