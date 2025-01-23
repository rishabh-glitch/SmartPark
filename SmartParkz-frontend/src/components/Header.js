import React from "react";
import HeaderComponent from "./HeaderComponent";
import UserHeader from "./UserHeader";

const Header = ({ role }) => {
  return <div>{role === "admin" ? <HeaderComponent /> : <UserHeader />}</div>;
};

export default Header;
