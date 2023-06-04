import React from 'react';
import "./styles.css";
import Navbar from '../components/navbar.js';

//import axios from "axios";


export default function Contact(props) {
    

    return (
        <div className="Home">
        <body>
        <Navbar status='Login'/>
        <br></br><br></br><br></br>
        <br></br><br></br><br></br>
        <center>
        <img src="../images/picgif.gif" alt="Profile" className="profile-photo"/>
        <br></br>
        
        <h3><strong style={{color:'white'}}>feel free to contact</strong></h3><br></br>
        <a href='https://www.linkedin.com/in/sandipan-kundu-268a6b202/'
        target="_blank" rel="noopener noreferrer">
        <i  className="fa fa-linkedin-square" style={{fontSize:'36px',cursor: 'pointer',color:'white'}}></i>
        </a>
        <br></br><br></br>
        <a href='https://drive.google.com/file/d/1IbKYlp14-xeuhLM_v26-tO7kLn5tb4NV/view?usp=sharing' 
        target="_blank" rel="noopener noreferrer">
        <button style={{color:'black'}}>
        <strong>View Resume</strong>
        </button>
        </a>
       </center>
        
        </body></div>
    );

}
