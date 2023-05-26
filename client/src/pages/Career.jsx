import React, { useState } from "react";
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import axios from "axios";
import "./styles.css";

export default function Career(props) {
  
  
  const [afterSubmit,setAfterSubmit] = useState(false);
  const [formData, setFormData] = useState({
    name: '',
    email: '',
    password: '',
    language:'',
    workExpYr:'',
    role:'',
    resume:''
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData((prevFormData) => ({
      ...prevFormData,
      [name]: value
    }));
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    
    const { name, email, password ,language,workExpYr,role} = formData;

    if (name === '' || name ===null || password === '' || password ===null||
    email === '' || email ===null || language === '' || language ===null||
    workExpYr === '' || workExpYr ===null || role === '' || role ===null) {
      toast.error("Enter all the fields before submit", {
        position: toast.POSITION.TOP_CENTER,
      });
      
      return false;
    }
  
  const baseURL = "http://localhost:8080/saveuser";
  const customConfig = {
    headers: {
    'Content-Type': 'application/json'
    }
};
  axios.post(baseURL, JSON.stringify(formData),customConfig);
  setAfterSubmit(true);
  return true;
  };

  const { name, email, password,language ,workExpYr,role,resume} = formData;

  return (
    afterSubmit ?
    <div className="Career">
  <body>
  <nav>
            <div class="menu">
                <div class="logo">
                <a href="/">Portfolio</a>
                </div>
                <ul>
                <li><a href="/">Home</a></li>
                <li><a href="/career">Career</a></li>
                <li><a href="/contact">Contact</a></li>
                <li><a href="/login">Login</a></li>
                </ul>
            </div>
            </nav>
            <br></br><br></br><br></br><br></br><br></br>
            <center >
            <h1 style={{ color: 'white' }}>Submitted Successfully !</h1>
            <h4 style={{ color: 'white' }}>try login</h4>
            </center>
            </body>
            </div> :
  <div className="Career">
  <body>
  <nav>
            <div class="menu">
                <div class="logo">
                <a href="/">Portfolio</a>
                </div>
                <ul>
                <li><a href="/">Home</a></li>
                <li><a href="/career">Career</a></li>
                <li><a href="/contact">Contact</a></li>
                <li><a href="/login">Login</a></li>
                </ul>
            </div>
            </nav>
            <br></br><br></br><br></br><br></br><br></br>
    <form onSubmit={handleSubmit}>
     <div className="form-control">
	 
        <input
          type="text"
          name="name"
          value={name}
          onChange={handleChange}
          placeholder="Name"
        />
    </div>
    <div className="form-control">
      
        <input
          type="email"
          name="email"
          value={email}
          onChange={handleChange}
          placeholder="Email"
        />
     </div>
     <div className="form-control">
      
        <input
          type="password"
          name="password"
          value={password}
          onChange={handleChange}
          placeholder="Password"
        />
    </div>
    <div className="form-control">
   
        <select value={language} onChange={handleChange} name="language" style={{ width: '290px' }}>
          <option value="">Select Language</option>
          <option value="Javascript">Javascript</option>
          <option value="Python">Python</option>
          <option value="Java">Java</option>
		      <option value="Kotlin">Kotlin</option>
		      <option value="TypeScript">TypeScript</option>
		      <option value="PHP">PHP</option>
		      <option value="R">R</option>
		      <option value="C#">C#</option>
		      <option value="Ruby">Ruby</option>
          <option value="SQL">PL/SQL</option>
        </select>
  </div>
  <div className="form-control">
    
        <input
          type="number"
          min="0"
          max="60"
          name="workExpYr"
          value={workExpYr}
          onChange={handleChange}
          placeholder="Years Of Work Experience"
        />
    </div>
    <div className="form-control">
      
        <input
          type="text"
          name="role"
          value={role}
          onChange={handleChange}
          placeholder="Current role and tech stack working on"
        />
     </div>
     <div className="form-control">
      <label>Upload Resume in pdf/doc/docx format</label>
        <input
          type="file"
          name="resume"
          value={resume}
          onChange={handleChange}
          accept=".doc,.docx,.pdf"
        />
     </div>
    <br></br>
    <div id="btn">
      <input type="submit" value="Submit"></input>
    </div>
    <ToastContainer />
    </form>
  </body>
</div>
  );
}    
  
