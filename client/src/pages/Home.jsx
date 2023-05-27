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
                        <th style={{width: '70%'}}><h3>Welcome</h3>
                        </th>
                        <th style={{width: '30%'}}>
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
                        <td><h3 style={{textDecorationLine: 'underline'}}>WORK EXPERIENCE</h3></td>
                        <td><h3 style={{textDecorationLine: 'underline'}}>SKILLS</h3></td>
                        </tr>

                        <tr>
                        <td><strong>TATA CONSULTANCY SERVICES</strong> <i>(12/2021 - Present)</i></td>
                        <td></td>
                        </tr>

                        <tr>
                        <td>
                            <ul>
                                <li>Owning and successfully delivering end to end deliverables</li>
                                <li>Involved in the entire lifecycle of the project including Design,Development, Testing,Deployment and Support.</li>
                                <li>PPT,flowchart made for portal feature release for client and made different reference documents for internal process to make day to day work easier.</li>
                                <li>Organized knowledge transfer sessions to new associates to increase domain and core technical knowledge in them.</li>
                            </ul>
                        </td>
                        <td>
                        <ul>
                             <li>Java</li>
                             <li>SQL</li>
                             <li>HTML</li>
                             <li>CSS</li>
                             <li>ES6</li>
                             <li>ReactJs</li>
                             <li>NodeJs</li>
                             <li>ExpressJs</li>
                             <li>jQuery</li>
                             <li>GIT</li>
                            </ul>
                        </td>
                        </tr>

                        <tr>
                        <td><h3 style={{textDecorationLine: 'underline'}}>PROJECTS</h3></td>
                        </tr>

                        <tr>
                        <td>
                            <ul>
                                <h4><strong>API Development</strong></h4>
                                <h5>Llyods Banking Group <i>(01/2022 - 06/2022)</i></h5>
                                <li>Developed several REST APIs in Java Spring Boot & Microservices </li>
                                <h4><strong>Java Web Development</strong></h4>
                                <h5>CMC - National Insurance Company <i>(07/2022 - Present)</i></h5>
                                <li>Developed a portal to update multiple form information in bulk which 
                                made customer to update the information at one click. SMS work has been done 
                                with the same transaction.Instead of single form submit , customer experiences
                                multiple submission at one click which reduces client’s time 1/n, where n is 
                                the no. of transaction using Struts,JSP,Javascript,JDBC, JQuery,SQL,Java sms library,
                                </li>
                                <li>done automation in email containing excel sheet to trigger at a particular day in month
                                 using Java mail API, JXL APIfor excel sheet generation,JDBC,sql,cronjob or quartz .These 
                                 generated excels are sent to different offices mail ids at one process,
                                 </li>
                                <li>verification of existing policy number from portal,matching with database and 
                                created different cases based on business logic using switch case, XOR instead of 
                                lot of if else block for validation checking and allowing user to proceed based on the result,
                                </li>
                                <li>verification of e-kyc from portal using HttpURLConnection class.Setting all method and 
                                property of GET/POST request to third party api and process the response using BufferedReader,
                                InputStreamReader and displaying the status of verification in portal in one go.
                                </li>
                            </ul>
                        </td>
                        <td></td>
                        </tr>

                        <tr>
                        <td><h3 style={{textDecorationLine: 'underline'}}>HONOR AWARDS</h3></td>
                        <td></td>
                        </tr>
                        
                        <tr>
                        <td>
                        <h4>  Star Team Award </h4>
                        <em>Issued by Tata Consultancy Services. October,2022</em>
                        </td>
                        </tr>
                    </table>
                    <br></br><br></br><br></br><br></br><br></br>

                    <center><footer style={{backgroundColor:'white',color:'#000048'}}>Developed & Maintain  by  Ergophile © 2023</footer></center>
                  
                  </body>
                 </div>       
          );
        }