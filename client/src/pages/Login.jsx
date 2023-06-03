        import React, { useState }  from 'react';
        import "./styles.css";
        import { ToastContainer, toast } from 'react-toastify';
        import 'react-toastify/dist/ReactToastify.css';
        import axios from "axios";
        import Navbar from '../components/navbar.js';
       

        export default function Login(props) {


          var err = false;  
          const [afterLogin, setLoginFlag] = useState(false);   
          const [formData, setFormData] = useState({
            email: '',
            password: ''
          });
          const [userStatus, setStatus] = useState("");
          const [boxColor, setColor] = useState();
         
          const handleChange = (e) => {
            const { name, value } = e.target;
            setFormData((prevFormData) => ({
              ...prevFormData,
              [name]: value
            }));
          };







          const handleSubmit = async (e) => {
            e.preventDefault();
            
            const { email, password} = formData;

            if (email === '' || email ===null || password === '' || password ===null) {
              toast.error("Enter the credentials", {
                position: toast.POSITION.TOP_CENTER,
              });
              err = true;
              return false;
            }
          
          const baseURL = "http://localhost:8080/loginProcessing/"+email;
          try {
          const response = await axios.get(baseURL);
          const data = response.data;

          if(data.length ===0) {
            err = true;
            toast.error("No record found", {
              position: toast.POSITION.TOP_CENTER,
            });
            return false;
          }
          
          const passDb = data[0].user_password;

          if(data[0].user_status ==='A') {setColor(true); setStatus('Accepted');}
          else if(data[0].user_status ==='R') {setColor(false); setStatus('Rejected');}
          

          

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
          return true;
        };






        const handlePassword = async (e) => {
          e.preventDefault();
          if (email === '' || email ===null ) {
            toast.error("Enter the registered email", {
              position: toast.POSITION.TOP_CENTER,
            });
            return false;
          }

          const baseURL = "http://localhost:8080/mailProcessing/"+email;
          try {
          const response = await axios.get(baseURL);
          const data = response.data;

          if(data.length ===0) {
            toast.error("No record found", {
              position: toast.POSITION.TOP_CENTER,
            });
            return false;
          }
        
        toast.success("Password has been sent to registered email", {
        position: toast.POSITION.TOP_CENTER,
        });

        }catch (error) {
          console.error(error);
        }

        }




        
          const {email, password} = formData;

          return (
            afterLogin ? 
            <div className="Login">
          <body>
          <Navbar status='Logout'/>
                    <br></br><br></br><br></br><br></br><br></br>
                    <center  style={{ color: 'white' }}>
                     <h1>Welcome user</h1>
                     <br></br>
                     <p>Your Application Status</p>
                     {boxColor?
                     <input type='text' value={userStatus} 
                     style={{color : 'black',textAlign:'center',fontWeight:'bolder',backgroundColor:'#b7f5a6'}} placeholder='Pending' readOnly/> :
                     <input type='text' value={userStatus} 
                     style={{color : 'black',textAlign:'center',fontWeight:'bolder',backgroundColor:'#f5aca6'}} placeholder='Pending' readOnly/>}
                    <br></br><br></br>
                    <p>Kindly check for the status later if showing 'Pending'</p>
                    
                    </center>
                    
            </body>
            </div> :
          <div className="Login">
          <body>
         <Navbar status='Login'/>
                    <br></br><br></br><br></br><br></br><br></br>
                    <br></br><br></br><br></br><br></br><br></br>
            <form onSubmit={handleSubmit}>
            <div id="login-btn"><label>Login</label></div>

            <div className="form-control">
              <input
                  type="email"
                  name="email"
                  value={email}
                  onChange={handleChange}
                  placeholder='Email or username'
                />
            </div>
            <div className="form-control">
              <input
                  type="password"
                  name="password"
                  value={password}
                  onChange={handleChange}
                  placeholder='Password'
                />
            </div>
            <div className="form-control"
            style={{fontSize:'15px',display:'flex-inline',
            textAlign:'center',fontWeight:'bold',color:'white',backgroundColor:'#3366ff',
            cursor:'pointer',fontFamily:"'Montserrat', sans-serif"}}
            >
            <p onClick={handleSubmit}>SIGN IN</p>
            </div>
            <div id='forgot-btn'><span onClick={handlePassword}>Forgot password?</span></div>
              <ToastContainer />
            </form>
            
           </body>
        </div>
          );
        }

