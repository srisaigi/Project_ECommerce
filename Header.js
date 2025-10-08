import React from "react";
import { Link } from "react-router-dom";

function Header() {
  return (
    <nav className="navbar navbar-expand-lg navbar-dark bg-dark px-4">
      <Link className="navbar-brand" to="/">E-Commerce</Link>
      <div className="collapse navbar-collapse">
        <ul className="navbar-nav ms-auto">
          <li className="nav-item"><Link className="nav-link" to="/">Home</Link></li>
          <li className="nav-item"><Link className="nav-link" to="/cart">Cart</Link></li>
          <li className="nav-item"><Link className="nav-link" to="/login">Login</Link></li>
        </ul>
      </div>
    </nav>
  );
}

export default Header;
