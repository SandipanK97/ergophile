import React, { useState }  from 'react';
import "./styles.css";
export default function Login(props) {
  
        
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

  const handleSubmit = (e) => {
    e.preventDefault();
    // Access the form values from the formData object
    const { email, password} = formData;
    // Do something with the form values...
  };

  const {email, password} = formData;

  return (
  <div className="Login">
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

    </form>
  </body>
</div>
  );
}

