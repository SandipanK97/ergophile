<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.io.*,java.util.*, javax.servlet.*" %>
<%@ page import="com.audit.customer.FormBean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@page import="java.util.Date"%>
<jsp:include page="./Header.jsp" flush="true" />
<jsp:include page="./Navbar.jsp" flush="true" />
<html:form  method="POST">
    
    <%Date currentDate = new Date();
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    String formattedDate = dateFormat.format(currentDate);
    %>
<table>
    <tr>
        <th>Mode of transaction</th>
        <td>
            <html:select styleId="modeOfTransaction" property="modeOfTransaction" name="FormBean">
                <html:option value="">select</html:option>
                <html:option value="cash">Cash</html:option>
                <html:option value="cheque">Cheque</html:option>
                <html:option value="credit_card">Credit Card</html:option>
                <html:option value="debit_card">Debit Card</html:option>
                <html:option value="UPI">UPI</html:option>
            </html:select>
        </td>
        <th>Amount (INR)</th>
        <td><html:text property="amtOfTransaction" name="FormBean" styleId="amtOfTransaction" ></html:text></td>
    </tr>
    <tr>
        <th>Transaction type</th>

        <td>
            <html:select styleId="transactionType" property="transactionType" name="FormBean">
                <html:option value="">select</html:option>
                <html:option value="CREDIT">deposit</html:option>
                <html:option value="DEBIT">withdrawal</html:option>
            </html:select>
        </td>


        <th>Transaction Date</th>
        <td><html:text  property="dot" styleId="dot"  name="FormBean" value="<%=formattedDate%>" readonly="true"></html:text></td>
    </tr>
    <tr></tr>
</table>
<br><br>
<input type="button" class="btn" onclick="Submit();" value="Update"></input>
<br><br>

<table>
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
    <tbody style="text-align: left;">
   <logic:present name="FormBean" property="list">   
   <logic:iterate id="item" name="FormBean" property="list" >
    <tr>
        <td><bean:write name="item" property="transNo"/></td>
        <td><bean:write name="item" property="accountNo"/></td>
        <td><bean:write name="item" property="transDate"/></td>
        <td><bean:write name="item" property="mot"/></td>
        <td><bean:write name="item" property="crdbt"/></td>
        <td><bean:write name="item" property="amt"/></td>
        <td><bean:write name="item" property="balance"/></td>
    </tr>
    </logic:iterate>
   </logic:present>
   </tbody>
</table>

</html:form>
<script type="text/javascript">
    
         $('#accountNo, #custId').change(function() {
            var id=document.getElementById('accountNo').value || document.getElementById('custId').value;
            var form = document.forms[0];
            form.action="transaction.do?id="+id;
            form.submit();
            
        });
        
        function Submit(){
           var id= document.getElementById('custId').value;
           var acc=document.getElementById('accountNo').value
            var form = document.forms[0];
            form.action="transaction.do?updateById="+id+"&acc="+acc;
            form.method='POST';
            form.submit();
        }
</script>

<jsp:include page="./Footer.jsp" flush="true" />
