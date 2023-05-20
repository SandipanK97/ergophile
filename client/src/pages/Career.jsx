import React, { useState } from "react";

import "./styles.css";
export default function Career(props) {
  const [formData, setFormData] = useState({
    name: '',
    email: '',
    password: '',
    language:'',
    workExpYr:''
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
    const { name, email, password ,language,workExpYr} = formData;
    // Do something with the form values...
  };

  const { name, email, password,language ,workExpYr} = formData;

  return (
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
	 <label>
        Name</label>
        <input
          type="text"
          name="name"
          value={name}
          onChange={handleChange}
        />
    </div>
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
    <div className="form-control">
    <label>
        Language</label>
        <select value={language} onChange={handleChange} name="language" style={{ width: '290px' }}>
          <option value="">-- Select --</option>
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
      <label>
        Years Of Work Experience</label>
        <input
          type="number"
          min="0"
          max="60"
          name="workExpYr"
          value={workExpYr}
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
  
