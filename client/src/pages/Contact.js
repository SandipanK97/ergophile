import React,{ useState } from 'react';
import styled from "styled-components";
import axios from "axios";


export default function Contact(props) {
    

    const Wrapper = styled.div`
        @import url('https://fonts.googleapis.com/css2?family=Montserrat:wght@300&display=swap');

        *{
        margin: 0;
        padding: 0;
        box-sizing: border-box;
        font-family: 'Montserrat', sans-serif;
        font-weight: normal;
        }
        ::selection{
        color: #000;
        background: #fff;
        }
        nav{
        position: fixed;
        background:whitesmoke ;
        width: 100%;
        padding: 10px 0;
        z-index: 12;
        }
        nav .menu{
        max-width: 1250px;
        margin: auto;
        display: flex;
        align-items: center;
        justify-content: space-around center;
        padding: 0 40px;
        }
        .menu .logo a{
        text-decoration: none;
        color: #000048;
        font-size: 35px;
        font-weight: 900;
        }
        .menu ul{
        display: inline-flex;
        }
        .menu ul li{
        list-style: none;
        margin-left: 7px;
        }
        .menu ul li:first-child{
        margin-left: 0px;
        }
        .menu ul li a{
        text-decoration: none;
        color: #000048;
        font-size: 18px;
        font-weight: 900;
        padding: 12px 15px;
        border-radius: 5px;
        transition: all 0.5s ease;
        }
        .menu ul li a:hover{
        background: #000048;
        color: whitesmoke;
        }
        .img{
        background: url('bodyImg.jpg')no-repeat;
        width: 100%;
        height: 100vh;
        background-size: cover;
        background-position: center;
        position: relative;
        }
        .img::before{
        content: '';
        position: absolute;
        height: 100%;
        width: 100%;
        background: rgba(0, 0, 0, 0.4);
        }
        .center{
        position: absolute;
        top: 40%;
        left: 30%;
        transform: translate(-50%, -50%);
        width: 100%;
        padding: 0 20px;
        text-align: center;
        
        }
        #imgW{
        position: absolute;
        top: -20%;
        left: 100%;
        margin:auto;
        padding:10px;
        }
        #temp{
        position: absolute;
        top: 25%;
        left: 100%;
        font-size: 50px;
        margin:auto;
        padding:10px;
        }
        #desc{
        position: absolute;
        top: 10%;
        left: 100%;
        margin:auto;
        padding:10px;
       }
        

        #footer{
        position: absolute;
        top: 90%;
        left: 50%;
        }

        .center .title{
        color: #fff;
        font-size: 45px;
        font-weight: 500;
        
        }
        .center .sub_title{
        color: #fff;
        font-size: 22px;
        font-weight: 400;
        }
        .center .btns{
        margin-top: 20px;
        }
        .center .btns button{
        height: 55px;
        width: 170px;
        border-radius: 5px;
        border: none;
        margin: 0 10px;
        border: 2px solid white;
        font-size: 20px;
        font-weight: 500;
        padding: 0 10px;
        cursor: pointer;
        outline: none;
        transition: all 0.3s ease;
        }
        .center .btns button:first-child{
        color: #fff;
        background: none;
        }
        .btns button:first-child:hover{
        background: white;
        color: black;
        }
        .center .btns button:last-child{
        background: white;
        color: black;
        }
    `;

//const [message, setMessage] = useState("");
const [temp, setTemp] = useState("");
const [weatherDescription, setWeatherDescription] = useState("");
const [icon, setIcon] = useState("");
const [imageURL, setImageURL] = useState("");
//const year= 'Ergophile © ';

//   useEffect(() => {
//     fetch("http://localhost:8000/message")
//       .then((res) => res.json())
//       .then((data) => setMessage(data.message));
//   }, []);

navigator.geolocation.getCurrentPosition((position)=> {
    const p=position.coords;
    const latitude = p.latitude;
    const longitude =p.longitude;

    const baseURL = "https://api.openweathermap.org/data/2.5/onecall?lat="+latitude+"&lon="+longitude+"&units=metric&exclude=hourly,daily,minutely&appid=9a1c24bc57e0a112e9c6de16daf9f833";
    axios.get(baseURL).then((res) => {
        
        setTemp(Math.round(res.data.current.temp)+"°C");
        setWeatherDescription(res.data.current.weather[0].description);
        setIcon(res.data.current.weather[0].icon);
        setImageURL("https://openweathermap.org/img/wn/"+icon+"@2x.png");
    });

});

    return (
        <Wrapper>
        <nav>
        <div class="menu">
            <div class="logo">
            <a href="/">Portfolio</a>
            </div>
            <ul>
            <li><a href="/">Home</a></li>
            <li><a href="/blogs">Blogs</a></li>
            <li><a href="/contact">Contact</a></li>
            </ul>
        </div>
        </nav>
        <div><img src='./images/bodyImg.png' alt='bodyImg'/></div>
    <div class="center">

    <div class="title">Feel free to write</div>

    <br></br><br></br>
    <ol>
    <li><div class="sub_title">Name</div></li>
    <li><div class="sub_title">Email</div></li>
    <li><div class="sub_title">Contact number</div></li>
    </ol>
    
    <div class="btns">
    <button>Submit</button>
    <button>Subscribe</button>
    </div>
    <ul>
    <li><div id="imgW"><img src={imageURL} alt="temp"/></div></li>
    <li><div class="sub_title" id="temp">{temp}</div><div class="sub_title" id="desc">{weatherDescription}</div></li>
    </ul>
   
</div>

    </Wrapper>
    );

}
