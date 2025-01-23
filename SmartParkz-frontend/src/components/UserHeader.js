import React from "react";
import Container from "react-bootstrap/Container";
import Nav from "react-bootstrap/Nav";
import Navbar from "react-bootstrap/Navbar";
import { Link } from "react-router-dom";
import AuthenticationService from "../services/AuthenticationService";

const UserHeader = () => {
  return (
    <Navbar
      style={{ background: "radial-gradient(rgb(0 0 0), rgba(72, 67, 67, 0))" }}
      expand="lg"
    >
      <Container style={{ maxWidth: "1300px" }}>
        <Navbar.Brand href="#home" style={{ color: "aliceblue" }}>
          Parking System
        </Navbar.Brand>
        <Navbar.Toggle aria-controls="basic-navbar-nav" />
        <Navbar.Collapse id="basic-navbar-nav">
          <Nav className="me-auto">
            <Link
              to="/userhome"
              className="nav-link active"
              style={{ color: "aliceblue" }}
            >
              Home
            </Link>
            <Link
              to="/bookparkingslot"
              className="nav-link active"
              style={{ color: "aliceblue" }}
            >
              BookSlots
            </Link>

            <Link
              to="/createvehicle"
              className="nav-link active"
              style={{ color: "aliceblue" }}
            >
              Register Vehicle
            </Link>
            <Link
              to="/registeredvehicles"
              className="nav-link active"
              style={{ color: "aliceblue" }}
            >
              My Vehicles
            </Link>
            <Link
              className="btn btn-danger"
              to="/"
              style={{ marginLeft: "750px" }}
              onClick={AuthenticationService.logout}
            >
              Logout
            </Link>
            {/* <NavDropdown title="Dropdown" id="basic-nav-dropdown">
              <NavDropdown.Item href="#action/3.1">Action</NavDropdown.Item>
              <NavDropdown.Item href="#action/3.2">
                Another action
              </NavDropdown.Item>
              <NavDropdown.Item href="#action/3.3">Something</NavDropdown.Item>
              <NavDropdown.Divider />
              <NavDropdown.Item href="#action/3.4">
                Separated link
              </NavDropdown.Item>
            </NavDropdown> */}
          </Nav>
        </Navbar.Collapse>
      </Container>
    </Navbar>
  );
};

export default UserHeader;
