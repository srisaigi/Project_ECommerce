import React, { useState } from "react";
import userService from "../services/userService";

function RegisterPage() {
  const [user, setUser] = useState({ name: "", email: "", password: "" });

  const handleSubmit = async (e) => {
    e.preventDefault();
    await userService.register(user);
    alert("User registered successfully!");
  };

  return (
    <div className="col-md-4 offset-md-4 mt-5">
      <h2>Register</h2>
      <form onSubmit={handleSubmit}>
        <input type="text" placeholder="Name" className="form-control mb-2" onChange={(e) => setUser({ ...user, name: e.target.value })} />
        <input type="email" placeholder="Email" className="form-control mb-2" onChange={(e) => setUser({ ...user, email: e.target.value })} />
        <input type="password" placeholder="Password" className="form-control mb-2" onChange={(e) => setUser({ ...user, password: e.target.value })} />
        <button className="btn btn-success w-100">Register</button>
      </form>
    </div>
  );
}

export default RegisterPage;
