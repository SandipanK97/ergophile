<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<title>Ergophile</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Montserrat&display=swap" rel="stylesheet">
<style>
.container {
	border: 2px solid #f51b6b;
	margin-left: auto;
	margin-right: auto;
	margin-top:auto;
	margin-bottom:auto;
	padding: 20px;
	float:centre;
	font-family: 'Montserrat', sans-serif;
	font-weight:bold;

}
#secondImg,#ThirdImg{
 border: 1px solid #f51b6b;
  border-radius: 8px;
width: 200px;
}
#myForm tr td input {
	font-family: 'Montserrat', sans-serif;
	font-weight: bold;
	border-radius:none;
}

button {
	font-family: 'Montserrat', sans-serif;
	font-weight: bold;
}
#api{

   font-family: 'Montserrat', sans-serif;
   float:right;
  
}
#my{
background: linear-gradient(110deg, #fdcd3b 60%, #ffed4b 60%);
font-size: 12px;
}
</style>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js" crossorigin></script>
</head>
<body id="my" >

	<div class="container" align="center">
	<div style="background-color: #f51b6b; text-align: center;color:black;font-weight:normal;border-radius:10px;">
		<h1 style="text-align: left;">Ergophile</h1>
		<h3>Job  Application  Portal</h3>
	</div>
		<table id="api">
			<tr>
				<td><p id="demoT" style = "font-size: 200%;"></p></td>
				<td><img id ="firstImg" src="https://openweathermap.org/img/wn/04n@2x.png" /></td>
			</tr>
			<tr><td><p id="demoW"></p></td><td><span id="time"></span></td></tr>
	</table>

		<script type="text/javascript">
			function check() {
				var cond = document.getElementById("condition");
				if (cond.checked)
					alert("Your personal data will be stored for your login purpose");
			}
			function validations() {
				var dob = document.getElementById("dob");
				var currDate = new Date();
				if (dob > currDate)
					alert("Date of Birth cannot be future date");
			}
			function EnableDisableTextBox() {
				var chkNo = document.getElementById("chkNo");
				var expBox = document.getElementById("expBox");
				var expYears = document.getElementById("expYears");
				expBox.disabled = chkNo.checked ? false : true;
				expYears.disabled = chkNo.checked ? false : true;
				expBox.value = "";
				if (!expBox.disabled) {
					expBox.focus();
					expYears.focus();
				}
			}
			function preview() {
				frame.src = URL.createObjectURL(event.target.files[0]);
			}
			
		</script>
		<script type="text/javascript">
		$(document).ready(function(){
			   document.getElementById("year").innerHTML = "Ergophile © "+ new Date().getFullYear();
				navigator.geolocation.getCurrentPosition((position)=> {
			    const p=position.coords;
				const latitude = p.latitude;
				const longitude =p.longitude;
				
			  
				$.ajax({
					   url: "https://api.openweathermap.org/data/2.5/onecall?lat="+latitude+"&lon="+longitude+"&units=metric&exclude=hourly,daily,minutely&appid=9a1c24bc57e0a112e9c6de16daf9f833",
		                type: "POST",
		                dataType: "JSON",
		            
		                success: function(data) {
		            		const temp= Math.round(data.current.temp);
		                    const weatherDescription=data.current.weather[0].description;
		                    const icon= data.current.weather[0].icon;
		                    const imageURL= "https://openweathermap.org/img/wn/"+icon+"@2x.png";
		                    $("#demoW").html(weatherDescription);
		                    $("#demoT").html(temp+"°C");
		                    $("#firstImg").attr("src",imageURL)
		               },
		                error: function(data, textStatus, errorThrown) {
		                   
		                    console.log(textStatus);
		                }
		            });
				 
				 $.ajax({
					   url: "https://newsapi.org/v2/top-headlines?country=in&category=general&apiKey=8c06d46915704ee288b68f96cbc645fd&language=en",
		                type: "GET",
		                dataType: "JSON",
		            
		                success: function(data) {
		            		const title= data.articles[0].title;
		            		console.log(title);
		            		const description= data.articles[0].description;
		            		const content= data.articles[0].content;
		                    const imageURL= data.articles[0].urlToImage;
		                    $("#secondImg").attr("src",imageURL);
		                    $("#title").html(title);
		                    $("#content").html(description);
		                    
		                    const title2= data.articles[1].title;
		                    const description2= data.articles[1].description;
		            		const content2= data.articles[1].content;
		                    const imageURL2= data.articles[1].urlToImage;
		                    $("#ThirdImg").attr("src",imageURL2);
		                    $("#title2").html(title2);
		                    $("#content2").html(description2);
		               },
		                error: function(data, textStatus, errorThrown) {
		                   
		                    console.log(textStatus);
		                }
		            });
				});
		});
		 `use strict`
		var datetime = new Date();
		console.log(datetime);
		document.getElementById("time").textContent = datetime.toDateString();
        </script>
		<form id="myForm" action="RegisterServlet" method=POST>
			<table>
				<tr>
					<td>Name :</td>
					<td><input type="text" name="user_name"
						placeholder="Enter your name" required /></td>
					<td><img id="frame" src="" width="100" height="120"
						style="border: 2px solid #f51b6b;" /></td>
				</tr>
				<tr>
					<td>Select profile image:</td>
					<td><input type="file" accept="image/*" name="user_img"
						onchange="preview()" required></td>
				</tr>
				<tr>
					<td>Date of Birth :</td>
					<td><input type="date" name="user_dateOfBirth"  id= "dob" required /></td>
				</tr>
				<tr>
					<td>Gender :</td>
					<td><input type="radio" name="user_gender" value="Male"
						required>Male &nbsp;&nbsp;<input type="radio"
						name="user_gender" value="female" required>Female</td>
						<td></td><td><h3>News Feed</h3></td>
				</tr>
				<tr>
					<td>Email id :</td>
					<td><input type="email" name="user_email"
						placeholder="Enter your email" required /></td><td></td>
					<td><img id ="secondImg" src="https://openweathermap.org/img" /><br><p id="title" > news title </p></td>
						
				</tr>
				<tr>
					<td>Mobile no :</td>
					<td><input type="number" name="user_phone" min="999999999"
						max="9999999999" placeholder="Enter mobile no." required /></td><td></td>
					<td><p id="content" > content </p></td>
				</tr>
				<tr>
					<td>City :</td>
					<td><input type="text" name="user_city"
						placeholder="Enter your city" required /></td>
				</tr>
				<tr>
					<td>State :</td>
					<td><select name="user_state" required>
							<option>Select State</option>
							<option value="Andhra Pradesh">Andhra Pradesh</option>
							<option value="Andaman and Nicobar Islands">Andaman and
								Nicobar Islands</option>
							<option value="Arunachal Pradesh">Arunachal Pradesh</option>
							<option value="Assam">Assam</option>
							<option value="Bihar">Bihar</option>
							<option value="Chandigarh">Chandigarh</option>
							<option value="Chhattisgarh">Chhattisgarh</option>
							<option value="Dadar and Nagar Haveli">Dadar and Nagar
								Haveli</option>
							<option value="Daman and Diu">Daman and Diu</option>
							<option value="Delhi">Delhi</option>
							<option value="Lakshadweep">Lakshadweep</option>
							<option value="Puducherry">Puducherry</option>
							<option value="Goa">Goa</option>
							<option value="Gujarat">Gujarat</option>
							<option value="Haryana">Haryana</option>
							<option value="Himachal Pradesh">Himachal Pradesh</option>
							<option value="Jammu and Kashmir">Jammu and Kashmir</option>
							<option value="Jharkhand">Jharkhand</option>
							<option value="Karnataka">Karnataka</option>
							<option value="Kerala">Kerala</option>
							<option value="Madhya Pradesh">Madhya Pradesh</option>
							<option value="Maharashtra">Maharashtra</option>
							<option value="Manipur">Manipur</option>
							<option value="Meghalaya">Meghalaya</option>
							<option value="Mizoram">Mizoram</option>
							<option value="Nagaland">Nagaland</option>
							<option value="Odisha">Odisha</option>
							<option value="Punjab">Punjab</option>
							<option value="Rajasthan">Rajasthan</option>
							<option value="Sikkim">Sikkim</option>
							<option value="Tamil Nadu">Tamil Nadu</option>
							<option value="Telangana">Telangana</option>
							<option value="Tripura">Tripura</option>
							<option value="Uttar Pradesh">Uttar Pradesh</option>
							<option value="Uttarakhand">Uttarakhand</option>
							<option value="West Bengal">West Bengal</option>
					</select></td>
					
				</tr>
				<tr>
					<td>
						<h4><strong>Education details :</strong></h4>
					</td><td></td><td></td>
						<td><img id ="ThirdImg" src="https://openweathermap.org/img" /><br><p id="title2" > news title </p></td>
				</tr>
				<tr>
					<td>College/Training Institute name:</td>
					<td><input type="text" name="user_college"
						placeholder="Enter your Institute" required /></td><td></td>
					<td><p id="content2" > content </p></td>
				</tr>
				<tr>
					<td>Graduation/Diploma :</td>
					<td><input type="text" name="user_degree"
						placeholder="Example  B.Sc , DMLT etc" required /></td>
						</tr>
						<tr>
					<td>Marks obtained :</td>
					<td><input type="number" step="0.01" min="0" max="100" 
						name="user_degree_marks" placeholder=" in  %"
						required /></td>
				</tr>
				<tr>
					<td>Passout Year :</td>
					<td><input type="month" name="user_GradPassoutYear"
						value='2001-06' required /></td>
				</tr>
				<tr></tr>
				<tr></tr>
				<tr></tr>
				<tr></tr>
				<tr>
					<td>High School name :</td>
					<td><input type="text" name="user_school"
						placeholder="Enter your Institute" required /></td>
				</tr>
				<tr>
					<td>Major :</td>
					<td><select name="user_major" required>
							<option>Select</option>
							<option value="Science">Science</option>
							<option value="Arts">Arts</option>
							<option value="Commerce">Commerce</option>
					</select></td>
					</tr>
					<tr>
					<td>Marks obtained :</td>
					<td><input type="number" step="0.01" min="0" max="100"
						name="user_HS_marks" placeholder="in  %" required /></td>
				</tr>
				<tr>
					<td>Passout Year :</td>
					<td><input type="month" name="user_HSpassoutYear"
						value='2001-06' required /></td>
				</tr>
				<tr>
					<td>Mention your skills :</td>
					<td><input type="text" name="user_skills"
						placeholder="separating by commas" required /></td>
				</tr>
				<tr>
					<td>Do you have work experience? if yes mention below:</td>
					<td><label for="chkNo"><input type="checkbox"
							name="user_expCheck" id="chkNo" onclick="EnableDisableTextBox()" />Yes
					</label></td>
				</tr>
				<tr>
					<td><textarea name="user_workExp" id="expBox"
							style="font-family: 'Montserrat', sans-serif;font-weight: bold;"
							disabled="disabled">Enter here...</textarea></td>
				</tr>
				<tr>
					<td>How many years of experience do you have ?</td>
					<td><input type="number" step="0.1" id="expYears"
						name="user_ExpYears" min="0" max="100" disabled="disabled" /></td>
				</tr>
				<tr>
					<td>Languages known :</td>
					<td><input type="text" name="user_language"
						placeholder="English,Hindi,Tamil..etc" required /></td>
				</tr>



				<tr>
					<td style="text-align: right;"><input type="checkbox"
						id="condition" onclick="check();" name="condition" value="checked" />
					</td>
					<td>Agree terms and conditions</td>
				</tr>
				<tr>
					<td></td>
					<td>
					 <button type="submit" onclick="validations();"  >Register</button>
						<button type="reset" >Reset form</button>
					</td>
				</tr>
			</table>
		</form>
		<h4 id ="year" style="background-color: #f51b6b; text-align: center;color:black;font-weight:normal;font-family: 'Montserrat', sans-serif;border-radius:10px;"></h4>
	</div>

</body>
</html>