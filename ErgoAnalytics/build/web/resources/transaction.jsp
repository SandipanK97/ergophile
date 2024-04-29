<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.io.*,java.util.*, javax.servlet.*" %>
<%@ page import="com.audit.customer.FormBean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<jsp:include page="./Header.jsp" flush="true" />
<jsp:include page="./Navbar.jsp" flush="true" />
<html:form  method="POST">
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
        <th>Amt.</th>
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


        <th>DOT</th>
        <td><html:text  property="dot" styleId="dot"  name="FormBean"></html:text></td>
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
    <tbody>
        <!-- Table Data to be populated through AJAX call -->
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
            var form = document.forms[0];
            form.action="transaction.do?updateById="+id;
            form.method='POST';
            form.submit();
        }
</script>

<jsp:include page="./Footer.jsp" flush="true" />
