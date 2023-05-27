            import React,{ useState } from 'react';
            
            import axios from "axios";
            import "./styles.css";


            export default function Home(props) {

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
                    <div className="Home">
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
                    <br></br><br></br><br></br>
                    <table>
                        <tr>
                        <th><h3>Welcome user !</h3></th>
                        <th>
                        <div id="imgW"><img src={imageURL} alt="temp"/></div>
                        <div className="sub_title" id="desc" >{weatherDescription}</div>
                        <div className="sub_title" id="temp" >{temp}</div>
                        </th>
                        </tr>

                        <tr>
                        <td><h3>Hi, I am Sandipan Kundu </h3></td>
                        <td></td>
                        </tr>

                        <tr>
                        <td><h3>WORK EXPERIENCE</h3></td>
                        <td><h3>SKILLS</h3></td>
                        </tr>
                        <tr>
                        <td><h4>TATA CONSULTANCY SERVICES</h4></td>
                        <td><ul>
                            <li>Java</li>
                            <li>SQL</li>
                            <li>HTML</li>
                            <li>CSS</li>
                            <li>ES6</li>
                            <li>ReactJs</li>
                        </ul></td>
                        </tr>

                    </table>
                 </body>
                 </div>       
          );
        }