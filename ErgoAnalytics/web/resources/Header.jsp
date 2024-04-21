<%@ page language="java" %>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ page import = "java.io.*,java.util.*, javax.servlet.*" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Core Banking</title>
    <link rel="stylesheet" href="main.css">
   
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
      
    <script type="text/javascript">
       
        function showSessionExpiryAlert() {
            alert("Your session has expired. Please log in again.");
            window.location.href = "<%= request.getContextPath() %>";
        }

      
        function startSessionExpiryTimer() {
            <%--<%= session.getMaxInactiveInterval() %>  1800--%>
            setTimeout(showSessionExpiryAlert, 600000);
        }
        
       
        window.onload = function() {
            startSessionExpiryTimer();
        };
       
     </script>
</head>
<body>

   <% Date date = new Date(); %>
    <div class="customer-info">
    
    <h1>&nbsp <font color="#cc0066">Er</font>goph<font color="#cc0066">i</font>le</h1>
    <marquee scrolldelay="170"><span style="font-size: 12px; color: #cc0052; font-family: 'Arial Black', sans-serif;">
    Welcome to Ergophile Official Portal for Online Core Banking Solutions. Ergophile Reserves the Copyright of this site. Kindly email us for support issues at support@ergophile.com
    </span></marquee>  
    <p id="heading">&nbsp &nbsp Universal Banking Solution <span id ="span" style="margin-left:45%;">welcome &nbsp;<i><%=session.getAttribute("user")%></i>  | <% out.print(date.toLocaleString());%></span>&nbsp;&nbsp;<button class="btn" onclick="window.location.href = '<%= request.getContextPath() %>'">logout</button></p>
       
       
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
       
      <br><br>
      <jsp:include page="./ErrorDisplay.jsp" flush="true" />
      <br><br>
