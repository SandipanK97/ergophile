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
            <th>Mode of transaction</th>
            <td>
            <select id="modeOfTransaction" name="modeOfTransaction">
            <option value="">select</option>
            <option value="cash">Cash</option>
            <option value="cheque">Cheque</option>
            <option value="credit_card">Credit Card</option>
            <option value="debit_card">Debit Card</option>
            <option value="UPI">UPI</option>
        	</select>
            </td>
            <th>Amt.</th>
            <td><input type="text" name="amtOfTransaction" id="amtOfTransaction" placeholder="INR"></td>
        </tr>
        <tr>
        	<th>Transaction type</th>
           
             <td>
            	<select id="transactionType" name="transactionType">
            	<option value="">select</option>
            	<option value="CREDIT">deposit</option>
            	<option value="DEBIT">withdrawal</option>
            	</select>
            </td>
             
            
            <th>DOT</th>
            <td><input type="date" name="dot" id="dot"></td>
        </tr>
        <tr></tr>
        </table>
        <br>
        
        
        
        <table id="transactionTable">
        <thead>
        <tr>
        	<th>Transaction no.</th>
        	<th>A/c.no</th>
        	<th>Date</th>
        	<th>Mode of Trans.</th>
        	<th>Credit/Debit</th>
        	<th>Amount(INR)</th>
        	<th>Balance(INR)</th>
        </tr>
        </thead>
         <tbody>
            <!-- Table Data to be populated through AJAX call -->
        </tbody>
    </table>
    <input type="hidden" id="balance" name="balance"/>
    <br>
		<br> &nbsp &nbsp
		<button class="btn" id="statement">Statement</button>
		&nbsp &nbsp
		<button class="btn" id="read">View</button>
		&nbsp &nbsp
		<button class="btn" id="create">Update</button>
		&nbsp &nbsp <span class="btn" id="message"></span> <br>
		<br> <br>
		<br>
		<br>
		<br> <br>
		<br>
		<footer>Developed and Maintained by Ergophile © 2023</footer>
    </div>
     <script type="text/javascript">
        $(document).ready(function () {
        	
        	 $("#logout").click(function() {
        		 window.location.href = "../AuditManagement/main.do?type=LOGOUT";
        	 });
        	 
        	 $('#accountNo').on('change', function() {
                 $('#custId').val('');
               });
               $('#custId').on('change', function() {
                   $('#accountNo').val('');
                 });
               
               $("#statement").click(function() {
            	   $.ajax({url: "../AuditManagement/transaction.do?type=STATEMENT", success: function(result){}});
               });
               $("#create").click(function() {
            	
               	let accountNo = $("#accountNo").val();
               	let modeOfTransaction   = $("#modeOfTransaction").val();
               	let amtOfTransaction  = $("#amtOfTransaction").val();
               	let transactionType  = $("#transactionType").val();
            	
               	let balance =  $("#balance").val();
               	if(transactionType =="CREDIT"){
               		balance = Number(balance)+Number(amtOfTransaction);
               	}
               	else {
               		balance = Number(balance)-Number(amtOfTransaction);
               	}
               	let dot =  new Date(document.getElementById('dot').value).toLocaleDateString('en-GB');
           		let custId = $("#custId").val();
           		
           		var transactionNo = "ERGI" + Math.floor(100000 + Math.random() * 900000);

               	
               	let uri = "../AuditManagement/transaction.do?type=POST"
               		 +"&modeOfTransaction="+modeOfTransaction      
               	     +"&amtOfTransaction="+amtOfTransaction       
               	     +"&transactionType="+transactionType      
               	     +"&dot="+dot      
               	     +"&transactionNo="+transactionNo    
               	     +"&balance="+balance       
               	     +"&accountNo="+accountNo; 
               	$.ajax({
                       url: uri,
                       type: "POST",
                       contentType: "application/json",
                       success: function() {
                    	   $("#modeOfTransaction").val('');
                           $("#amtOfTransaction").val('');
                           $("#transactionType").val('');
                          
                           $("#message").css('color', 'red').html("transaction successful!").fadeIn().delay(5000).fadeOut();
                       },
                       error: function(error) {
                       	$("#message").css('color', 'red').html(error);
                       }
                   });
               });

               
               $("#read").click(function() {
            	   
            	  /*  let transactionObject = {
               			modeOfTransaction: modeOfTransaction,
               			amtOfTransaction: amtOfTransaction,
               			transactionType: transactionType,
               			dot: dot,
               			transactionNo: transactionNo,
               			balance: balance,
               			accountNo: accountNo,
               	   }; */
            	   
               	let id = $("#custId").val() || $("#accountNo").val();
                   $.ajax({
                       url: "../AuditManagement/transaction.do?type=GET&id="+id,
                       type: "GET",
                       contentType: "application/json",
                       success: function(response) {
                       var transactionObject = response;
                       	if(transactionObject == null || transactionObject.length === 0){
                       		$("#message").css('color', 'red').html("not found!").fadeIn().delay(5000).fadeOut();
                       		$("#accountNo").val('');
                       		$("#custId").val('');
                              
                       	}
                   		else{
                   			$("#transactionTable tbody").empty();
                            for (var i = 0; i < transactionObject.length; i++) {
                                var transaction = transactionObject[i];
                                
                                	  var newRow = $("<tr>");
                                      newRow.append("<td>" + transaction.transactionNo + "</td>");
                                      newRow.append("<td>" + transaction.accountNo + "</td>");
                                      
                                      var formattedDate = new Date(transaction.dot).toLocaleDateString("en-GB");
                                      
                                      newRow.append("<td>" + formattedDate + "</td>");
                                      newRow.append("<td>" + transaction.modeOfTransaction + "</td>");
                                      newRow.append("<td>" + transaction.transactionType + "</td>");
                                      newRow.append("<td>" + transaction.amtOfTransaction + "</td>");
                                      newRow.append("<td>" + transaction.balance + "</td>");
                                      newRow.append("</tr>");
                                      
                                      $("#transactionTable tbody").append(newRow);
                                if(i== transactionObject.length-1 ) $("#balance").val(transaction.balance);
                              
                            }
                          
                           $("#message").css('color', 'red').html("found successfully!").fadeIn().delay(5000).fadeOut();
                   		}
                       },
                       error: function(error) {
                       	console.error("Error:", error);
                       	$("#message").css('color', 'red').html(error);
                       }
                   });
               });
          
        });
    </script>
</body>
</html>
