<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.io.*,java.util.*, javax.servlet.*" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Core Banking</title>
    <link rel="stylesheet" href="main.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>

   <% Date date = new Date(); %>
    <div class="customer-info">
    
    <h1>&nbsp <font color="#cc0066">Er</font>goph<font color="#cc0066">i</font>le</h1>
    <marquee scrolldelay="170"><span style="font-size: 12px; color: #cc0052; font-family: 'Arial Black', sans-serif;">
    Welcome to Ergophile Official Portal for Online Core Banking Solutions. Ergophile Reserves the Copyright of this site. Kindly email us for support issues at support@ergophile.com
    </span></marquee>
    <p id="heading">&nbsp &nbsp Universal Banking Solution <span id ="span" style="margin-left:55%;"><% out.print("admin");%> | <% out.print(date.toLocaleString());%></span>&nbsp;&nbsp;<button class="btn" id="logout">logout</button></p>
       <table>
       <tr>
       <td></td>
         <td>A/c.ID<span><font color="red">*</font></span> &nbsp &nbsp<input type="text" name="accountNo" id="accountNo"/>
         <svg id="search" xmlns="http://www.w3.org/2000/svg" width="12" height="12" fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
  		 <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z"/>
		 </svg>
         </td>
         <td ></td>
         <td>Cust.Id<span><font color="red">*</font></span> &nbsp &nbsp<input type="text" name="custId" id="custId"/>
         <svg id="search" xmlns="http://www.w3.org/2000/svg" width="12" height="12" fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
  		 <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z"/>
		 </svg>
         </td>
         <td ></td>
       </tr>
       </table>
       <br><br><br><br>
       <div id="navbar">
       	  <a href="main.do">Customer</a>
  		  <a href="account.do">Account</a>
  		  <a href="transaction.do">Transaction</a>
  		  <a href="audit.do">Audit</a>
  		</div>
       <br>
       <table>
        <tr>
            <th>Name</th>
            <td><input type="text" name="name" id="name" disabled></td>
            <th>Fname</th>
            <td><input type="text" name="fname" id="fname"></td>
        </tr>
        <tr>
            <th>Mname</th>
            <td><input type="text" name="mname" id="mname"></td>
            <th>Lname</th>
            <td><input type="text" name="lname" id="lname"></td>
        </tr>
        <tr>
            <th>DOB</th>
            <td><input type="date" name="dob" id="dob"></td>
            <th>Mobile no.</th>
            <td> <input type="tel" name="mobileNo" id="mobileNo" pattern="[0-9]{10}" title="Please enter a 10-digit mobile number." required></td>
        </tr>
        <tr>
            <th>Occupation</th>
            <td><input type="text" name="occupation" id="occupation"></td>
            <th>City</th>
            <td><input type="text" name="city" id="city"></td>
        </tr>
         <tr>
            <th>State</th>
            <td>
            
            <select name="state" id="state" >
							<option value="">Select State</option>
							<option value="Andhra Pradesh">Andhra Pradesh</option>
							<option value="Andaman and Nicobar Islands">Andaman and Nicobar Islands</option>
							<option value="Arunachal Pradesh">Arunachal Pradesh</option>
							<option value="Assam">Assam</option>
							<option value="Bihar">Bihar</option>
							<option value="Chandigarh">Chandigarh</option>
							<option value="Chhattisgarh">Chhattisgarh</option>
							<option value="Dadar and Nagar Haveli">Dadar and Nagar Haveli</option>
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
					</select>
            </td>
            <th>Address pin</th>
            <td><input type="number" name="addressPin" id="addressPin" pattern="[0-9]{1,6}" title="Please enter a number with a maximum of 6 digits." required></td>
        </tr>
         <tr>
            <th>Aadhar No.</th>
            <td><input type="text" name="aadharNo" id="aadharNo"></td>
            <th>PAN No.</th>
            <td><input type="text" name="panNo" id="panNo"></td>
        </tr>
        <tr>
            <th>e-kyc status</th>
            <td>
              <select id="isEkycDone" name="isEkycDone">
            	<option value="Y">Y</option>
            	<option value="N">N</option>
       		  </select>
            </td>
            <th>Passport No.</th>
            <td><input type="text" name="passportNo" id="passportNo"></td>
        </tr>
        
    </table>
    <br><br>
    &nbsp &nbsp <button class="btn" id="create">Add</button>
    &nbsp &nbsp <button class="btn" id="read">View</button>
    &nbsp &nbsp <button class="btn" id="update">Update</button>
    &nbsp &nbsp <button class="btn" id="delete">Delete</button>
    &nbsp &nbsp <span class="btn" id="message"></span>
    <br><br>
    <br><br><br><br>
    <br><br>
    <footer>Developed and Maintained by Ergophile © 2023</footer>
    </div>
    
    
    
    <script type="text/javascript">
    $(document).ready(function() {
    	 $("#logout").click(function() {
    		 window.location.href = "../AuditManagement/main.do?type=LOGOUT";
    	 });
         
         let customerObject = {
             custId: custId    ,
             name: name      ,
             fname: fname     ,
             mname: mname     ,
             lname: lname     ,
             dob: dob       ,
             mobileNo: mobileNo  ,
             occupation: occupation,
             city: city      ,
             state: state     ,
             addressPin: addressPin,
             aadharNo: aadharNo  ,
             panNo: panNo     ,
             isEkycDone: isEkycDone,
             passportNo: passportNo
         };
         
         $('#accountNo').on('change', function() {
           $('#custId').val('');
         });
         $('#custId').on('change', function() {
             $('#accountNo').val('');
           });
        
        $("#create").click(function() {
        	let custId = $("#custId").val();
        	let name   = $("#name").val();
        	let fname  = $("#fname").val();
        	let mname  = $("#mname").val();
        	let lname  = $("#lname").val();
        	let dob =  new Date(document.getElementById('dob').value).toLocaleDateString('en-GB');
    		let mobileNo = $("#mobileNo").val();
        	let occupation = $("#occupation").val();
        	let city = $("#city").val();
        	let state  = $("#state").val();
        	let addressPin = $("#addressPin").val();
        	let aadharNo = $("#aadharNo").val();
        	let panNo = $("#panNo").val();
        	let isEkycDone = $("#isEkycDone").val();
        	let passportNo = $("#passportNo").val();
        	
        	let uri = "../AuditManagement/main.do?type=POST"
        		 +"&custId="+custId      
        	     +"&name="+name       
        	     +"&fname="+fname      
        	     +"&mname="+mname      
        	     +"&lname="+lname      
        	     +"&dob="+dob        
        	     +"&mobileNo="+mobileNo   
        	     +"&occupation="+occupation 
        	     +"&city="+city       
        	     +"&state="+state      
        	     +"&addressPin="+addressPin 
        	     +"&aadharNo="+aadharNo   
        	     +"&panNo="+panNo      
        	     +"&isEkycDone="+isEkycDone 
        	     +"&passportNo="+passportNo+""; 
        	$.ajax({
                url: uri,
                type: "POST",
                contentType: "application/json",
                success: function() {
                    $("#message").css('color', 'red').html("successfully created!").fadeIn().delay(5000).fadeOut();
                },
                error: function(error) {
                	$("#message").css('color', 'red').html(error);
                }
            });
        });

        $("#read").click(function() {
        	let id = $("#custId").val() || $("#accountNo").val();
            $.ajax({
                url: "../AuditManagement/main.do?type=GET&id="+id,
                type: "GET",
                contentType: "application/json",
                success: function(response) {
                	customerObject = response;
                	if(customerObject.custId==null){
                		$("#message").css('color', 'red').html("not found!").fadeIn().delay(5000).fadeOut();
                		$("#name").val('');
                        $("#fname").val('');
                        $("#mname").val('');
                        $("#lname").val('');
                        var formattedDate = new Date(customerObject.dob).toLocaleDateString('en-CA');
                        $("#dob").val('');
                        $("#mobileNo").val('');
                        $("#occupation").val('');
                        $("#city").val('');
                        $("#state").val('');
                        $("#addressPin").val('');
                        $("#aadharNo").val('');
                        $("#panNo").val('');
                        $("#isEkycDone").val('');
                        $("#passportNo").val('');
                        $("#accountNo").val('');
                	}
            		else{
                	$("#custId").val(customerObject.custId);
                    $("#name").val(customerObject.name);
                    $("#fname").val(customerObject.fname);
                    $("#mname").val(customerObject.mname);
                    $("#lname").val(customerObject.lname);
                    var formattedDate = new Date(customerObject.dob).toLocaleDateString('en-CA');
                    $("#dob").val(formattedDate);
                    $("#mobileNo").val(customerObject.mobileNo);
                    $("#occupation").val(customerObject.occupation);
                    $("#city").val(customerObject.city);
                    $("#state").val(customerObject.state);
                    $("#addressPin").val(customerObject.addressPin);
                    $("#aadharNo").val(customerObject.aadharNo);
                    $("#panNo").val(customerObject.panNo);
                    $("#isEkycDone").val(customerObject.isEkycDone);
                    $("#passportNo").val(customerObject.passportNo);
                    $("#accountNo").val(customerObject.accountNo);
                    
                    $("#message").css('color', 'red').html("found successfully!").fadeIn().delay(5000).fadeOut();
            		}
                },
                error: function(error) {
                	console.error("Error:", error);
                	$("#message").css('color', 'red').html(error);
                }
            });
        });

        $("#update").click(function() {
        let id = $("#custId").val() || $("#accountNo").val();
       	let custId = $("#custId").val();
    	let name   = $("#name").val();
    	let fname  = $("#fname").val();
    	let mname  = $("#mname").val();
    	let lname  = $("#lname").val();
    	let dob =  new Date(document.getElementById('dob').value).toLocaleDateString('en-GB');
		let mobileNo = $("#mobileNo").val();
    	let occupation = $("#occupation").val();
    	let city = $("#city").val();
    	let state  = $("#state").val();
    	let addressPin = $("#addressPin").val();
    	let aadharNo = $("#aadharNo").val();
    	let panNo = $("#panNo").val();
    	let isEkycDone = $("#isEkycDone").val();
    	let passportNo = $("#passportNo").val();
    	
    	let uri = "../AuditManagement/main.do?type=PUT"
    		 +"&id="+id
    		 +"&custId="+custId      
    	     +"&name="+name       
    	     +"&fname="+fname      
    	     +"&mname="+mname      
    	     +"&lname="+lname      
    	     +"&dob="+dob        
    	     +"&mobileNo="+mobileNo   
    	     +"&occupation="+occupation 
    	     +"&city="+city       
    	     +"&state="+state      
    	     +"&addressPin="+addressPin 
    	     +"&aadharNo="+aadharNo   
    	     +"&panNo="+panNo      
    	     +"&isEkycDone="+isEkycDone 
    	     +"&passportNo="+passportNo+""; 
           $.ajax({
                url: uri,
                type: "POST",
                contentType: "application/json",
                success: function() {
                	$("#message").css('color', 'red').html("successfully updated!").fadeIn().delay(5000).fadeOut();
                },
                error: function(error) {
                	$("#message").css('color', 'red').html(error);
                }
            });
        });

        $("#delete").click(function() {
        	let id = $("#custId").val() || $("#accountNo").val();
            $.ajax({
                url: "../AuditManagement/main.do?type=DELETE&id="+id,
                type: "GET",
                success: function() {
                	$("#message").css('color', 'red').html("successfully deleted!").fadeIn().delay(5000).fadeOut();
                },
                error: function(error) {
                	$("#message").css('color', 'red').html(error);
                }
            });
        });
    });
    
    </script>
</body>
</html>
