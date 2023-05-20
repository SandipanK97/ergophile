import React, { useState }  from 'react';
import "./styles.css";
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import axios from "axios";

export default function Login(props) {
  var err = false;  
  const [afterLogin, setLoginFlag] = useState(false);   
  const [formData, setFormData] = useState({
    email: '',
    password: ''
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData((prevFormData) => ({
      ...prevFormData,
      [name]: value
    }));
  };

  const handleSubmit =async  (e) => {
    e.preventDefault();
    // Access the form values from the formData object
    const { email, password} = formData;
   
    const baseURL = "http://localhost:8080/loginProcessing/"+email;
  try {
  const response = await axios.get(baseURL);
  const data = response.data;
  if (email === '' || email ===null) {
      toast.error("Email  not entered", {
         position: toast.POSITION.TOP_CENTER,
       });
      err = true;
     }
  else if (password === '' || password ===null) {
    toast.error("Password not entered", {
      position: toast.POSITION.TOP_CENTER,
    });
    err = true;
  }
  if(data.length ===0) {
    err = true;
    toast.error("No record found", {
      position: toast.POSITION.TOP_CENTER,
    });
  }
 // const emailDb = data[0].user_email;
  const passDb = data[0].user_password;

  // if (email !== emailDb) {
  //  toast.error("Email does not match", {
  //     position: toast.POSITION.TOP_CENTER,
  //   });
  //   err = true;
  // }
  if (password !== passDb) {
    toast.error("Password does not match", {
      position: toast.POSITION.TOP_CENTER,
    });
    err = true;
  }
} catch (error) {
  console.error(error);
}
if(err===false) setLoginFlag(true);
  };

  const {email, password} = formData;

  return (
    afterLogin ? 
    <div className="Login">
  <body>
  <nav>
            <div className="menu">
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
            <h1 style={{ color: 'white' }}>Welcome user</h1>
    </body>
    </div> :
  <div className="Login">
  <body>
  <nav>
            <div className="menu">
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
            <br></br><br></br><br></br><br></br><br></br>
     <form onSubmit={handleSubmit}>
     <div className="form-control"><label>Login Form</label></div>
    <div className="form-control">
      <label>
        Email</label>
        <input
          type="email"
          name="email"
          value={email}
          onChange={handleChange}
        />
     </div>
     <div className="form-control">
      <label>
        Password</label>
        <input
          type="password"
          name="password"
          value={password}
          onChange={handleChange}
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

