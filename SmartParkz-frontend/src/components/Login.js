import React, { useState } from "react";
import { useHistory } from "react-router-dom";

import { ToastContainer, toast } from "react-toastify";
import AuthenticationService from "../services/AuthenticationService";
const Login = () => {
  const [email, setEmail] = useState("");
  const [password, setPass] = useState("");
  const history = useHistory();

  const saveOrUpdateUser = e => {
    e.preventDefault();
    AuthenticationService.executeJwtAuthenticationService(email, password)
      .then(response => {
        AuthenticationService.registerSuccesfulLoginForJwt(
          email,
          response.data.token
        );
        if (email === "admin@123") {
          history.push("/adminhome");
        } else {
          history.push("/userhome");
        }
        successfullLogin();
      })
      .catch(error => {
        console.log(error);
        // setLoginFailed(true);
        failedLogin();
        // setShowSuccessMessage(false);
      });
    // AuthenticationService.executeBasicAuthenticationService(email, password)
    //   .then(() => {
    //     AuthenticationService.registerSuccesfulLogin(email, password);
    //     history.push(`/userhome/${email}`);
    //   })
    //   .catch(error => {
    //     console.log(error);
    //   });

    /* const user = { email, password };

    UserServices.loginUser(user)
      .then(response => {
        if (response.data === "logged in") {
          loginButton();
          history.push("/userhome");
        } else if (response.data === "logged in as a admin") {
          history.push("/home");
        } else {
          history.push("/login");
          alert("incorrect credentials");
        }
        console.log(response.data);
      })
      .catch(error => {
        console.log(error);
      }); */
  };
  const successfullLogin = () => {
    toast.success("Login Successful");
  };

  const title = () => {
    return <h2 className="text-center">Login</h2>;
  };
  // const success=()=>{
  //     // return alert("successfull login")
  // }
  const failedLogin = () => {
    toast.error("Invalid Credentials", {
      position: "top-center",
      autoClose: 3000,
      hideProgressBar: false,
      closeOnClick: true,
      pauseOnHover: true,
      draggable: true,
      progress: undefined,
      theme: "dark",
    });
  };
  return (
    <div>
      <ToastContainer />
      <div style={{ backgroundColor: "#037bfc", padding: "153px" }}>
        {/* <h1 style={{fontFamily:"revert",textAlign:"center",color:"darkblue",textShadow:"4px 4px 2px azure",paddingTop:"50px"}}>Parking Slot Management System</h1> */}
        {/* <br />
        <br /> */}
        <div className="container" style={{ paddingTop: "20px" }}>
          <div className="row">
            <div
              className="card col-md-4 offset-md-4 offset-md-4"
              style={{
                backgroundColor: "white",
              }}
            >
              {title()}
              <div
                className="card-body"
                style={{
                  backgroundColor: "white",
                }}
              >
                <form>
                  <div className="form-group mb-2">
                    <label className="form-label"> Email :</label>
                    <input
                      type="email"
                      placeholder="Enter email"
                      name="lastName"
                      className="form-control"
                      value={email}
                      onChange={e => setEmail(e.target.value)}
                    ></input>
                  </div>
                  <div className="form-group mb-2">
                    <label className="form-label"> Password :</label>
                    <input
                      type="password"
                      placeholder="Enter password"
                      name="emailId"
                      className="form-control"
                      value={password}
                      onChange={e => setPass(e.target.value)}
                    ></input>
                  </div>
                  <button
                    style={{ width: "100%" }}
                    className="btn btn-primary"
                    onClick={e => saveOrUpdateUser(e)}
                  >
                    Login{" "}
                  </button>
                </form>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Login;
