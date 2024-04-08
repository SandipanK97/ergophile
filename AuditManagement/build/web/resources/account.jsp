<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*, javax.servlet.*"%>
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

		<h1>
			&nbsp <font color="#cc0066">Er</font>goph<font color="#cc0066">i</font>le
		</h1>
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
		<br>
		<br>
		<br>
		<br>
		 <div id="navbar">
       	  <a href="main.do">Customer</a>
  		  <a href="account.do">Account</a>
  		  <a href="transaction.do">Transaction</a>
  		  <a href="audit.do">Audit</a>
  		</div>
		<br>
		<table>
			<tr>
				<th>A/c.no</th>
				<td><input type="text" name="accountNo" id="accountNo2"disabled></td>
				<th>IFSC code</th>
				<td><input type="text" name="ifscCd" id="ifscCd"></td>
			</tr>
			<tr>
				<th>Branch</th>
				<td><input type="text" name="branch" id="branch"></td>
				<th>Location</th>
				<td><input type="text" name="location" id="location"></td>
			</tr>
			<tr>
				<th>Type of A/c.</th>
				<td><select id="accountType" name="accountType">
						<option value="Savings">SB</option>
						<option value="Current">CA</option>
						<option value="Fixed_deposit">FD</option>
						<option value="Recurring_deposit">RD</option>
				</select></td>
				<th>Status</th>
				<td><input type="text" name="status" id="status"></td>
			</tr>
			<tr>
				<th>AOD</th>
				<td><input type="date" name="aod" id="aod"></td>
				<th>Opening Balance</th>
				<td><input type="text" name="openingBalance"
					id="openingBalance"></td>
			</tr>
			<tr>
				<th>Loan A/c.no</th>
				<td><input type="text" name="loanAccountNo" id="loanAccountNo"></td>
				<th>Loan Amt.</th>
				<td><input type="number" name="loanAmt" id="loanAmt"
					placeholder="INR"></td>
			</tr>
			<tr>
				<th>ROI</th>
				<td><input type="number" name="roi" id="roi" ></td>
				<th>Tenure</th>
				<td><input type="number" name="tenure" id="tenure" ></td>
			</tr>

		</table>
		</table>
		<br>
		<br> &nbsp &nbsp
		<button class="btn" id="create">Add</button>
		&nbsp &nbsp
		<button class="btn" id="read">View</button>
		&nbsp &nbsp
		<button class="btn" id="update">Update</button>
		&nbsp &nbsp
		<button class="btn" id="delete">Delete</button>
		&nbsp &nbsp <span class="btn" id="message"></span> <br>
		<br> <br>
		<br>
		<br>
		<br> <br>
		<br>
		<footer>Developed and Maintained by Ergophile © 2023</footer>
	</div>

	<script type="text/javascript">
    $(document).ready(function() {
    	 $("#logout").click(function() {
    		 window.location.href = "../AuditManagement/main.do?type=LOGOUT";
    	 });
         
         let accountObject = {
        			accountNo: accountNo,
        		    ifscCd: ifscCd,
        		    branch: branch,
        		    location: location,
        		    accountType: accountType,
        		    status: status,
        		    aod: aod,
        		    openingBalance: openingBalance,
        		    loanAccountNo: loanAccountNo,
        		    loanAmt: loanAmt,
        		    roi: roi,
        		    tenure: tenure,
        		    custId: custId
         };
         
         $('#accountNo').on('change', function() {
           $('#custId').val('');
         });
         $('#custId').on('change', function() {
             $('#accountNo').val('');
           });
        
        $("#create").click(function() {
        	let accountNo = $("#accountNo").val();
        	let ifscCd   = $("#ifscCd").val();
        	let branch  = $("#branch").val();
        	let location  = $("#location").val();
        	let accountType  = $("#accountType").val();
        	let status  = $("#status").val();
        	let aod =  new Date(document.getElementById('aod').value).toLocaleDateString('en-GB');
    		let openingBalance = $("#openingBalance").val();
        	let loanAccountNo = $("#loanAccountNo").val();
        	let loanAmt = $("#loanAmt").val();
        	let roi  = $("#roi").val();
        	let tenure = $("#tenure").val();
        	let custId = $("#custId").val();
        	
        	
        	let uri = "../AuditManagement/account.do?type=POST"
        		 +"&accountNo="+accountNo      
        	     +"&ifscCd="+ifscCd       
        	     +"&branch="+branch      
        	     +"&location="+location      
        	     +"&accountType="+accountType      
        	     +"&status="+status        
        	     +"&aod="+aod   
        	     +"&openingBalance="+openingBalance 
        	     +"&loanAccountNo="+loanAccountNo       
        	     +"&loanAmt="+loanAmt      
        	     +"&roi="+roi 
        	     +"&tenure="+tenure   
        	     +"&custId="+custId; 
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
                url: "../AuditManagement/account.do?type=GET&id="+id,
                type: "GET",
                contentType: "application/json",
                success: function(response) {
                	accountObject = response;
                	if(accountObject.custId==null){
                		$("#message").css('color', 'red').html("not found!").fadeIn().delay(5000).fadeOut();
                		$("#accountNo").val('');
                		$("#accountNo2").val('');
                        $("#ifscCd").val('');
                        $("#branch").val('');
                        $("#location").val('');
                        var formattedDate = new Date(accountObject.aod).toLocaleDateString('en-CA');
                        $("#aod").val('');
                        $("#accountType").val('');
                        $("#status").val('');
                        $("#openingBalance").val('');
                        $("#loanAccountNo").val('');
                        $("#loanAmt").val('');
                        $("#roi").val('');
                        $("#tenure").val('');
                        $("#custId").val('');
                       
                	}
            		else{
            			$("#accountNo").val(accountObject.accountNo);
            			$("#accountNo2").val(accountObject.accountNo);
                        $("#ifscCd").val(accountObject.ifscCd);
                        $("#branch").val(accountObject.branch);
                        $("#location").val(accountObject.location);
                        var formattedDate = new Date(accountObject.aod).toLocaleDateString('en-CA');
                        $("#aod").val(formattedDate);
                        $("#accountType").val(accountObject.accountType);
                        $("#status").val(accountObject.status);
                        $("#openingBalance").val(accountObject.openingBalance);
                        $("#loanAccountNo").val(accountObject.loanAccountNo);
                        $("#loanAmt").val(accountObject.loanAmt);
                        $("#roi").val(accountObject.roi);
                        $("#tenure").val(accountObject.tenure);
                        $("#custId").val(accountObject.custId);
                    
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
        let accountNo = $("#accountNo").val();
    	let ifscCd   = $("#ifscCd").val();
    	let branch  = $("#branch").val();
    	let location  = $("#location").val();
    	let accountType  = $("#accountType").val();
    	let status  = $("#status").val();
    	let aod =  new Date(document.getElementById('aod').value).toLocaleDateString('en-GB');
		let openingBalance = $("#openingBalance").val();
    	let loanAccountNo = $("#loanAccountNo").val();
    	let loanAmt = $("#loanAmt").val();
    	let roi  = $("#roi").val();
    	let tenure = $("#tenure").val();
    	let custId = $("#custId").val();
    	
    	let uri = "../AuditManagement/account.do?type=PUT"
    		 +"&id="+id
    		 +"&accountNo="+accountNo      
    	     +"&ifscCd="+ifscCd       
    	     +"&branch="+branch      
    	     +"&location="+location      
    	     +"&accountType="+accountType      
    	     +"&status="+status        
    	     +"&aod="+aod   
    	     +"&openingBalance="+openingBalance 
    	     +"&loanAccountNo="+loanAccountNo       
    	     +"&loanAmt="+loanAmt      
    	     +"&roi="+roi 
    	     +"&tenure="+tenure   
    	     +"&custId="+custId;
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
                url: "../AuditManagement/account.do?type=DELETE&id="+id,
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
