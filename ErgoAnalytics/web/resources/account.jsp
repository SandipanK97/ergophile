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
        <th>A/c.no</th>
        <td><html:text property="accountNo" name="FormBean"  disabled="true"></html:text></td>
        <th>IFSC code</th>
        <td><html:text property="ifscCd" name="FormBean" styleId="ifscCd"></html:text></td>
    </tr>
    <tr>
        <th>Branch</th>
        <td><html:text property="branch" name="FormBean" styleId="branch"></html:text></td>
        <th>Location</th>
        <td><html:text property="location" name="FormBean" styleId="location"></html:text></td>
    </tr>
    <tr>
        <th>Type of A/c.</th>
        <td><html:select styleId="accountType" property="accountType" name="FormBean">
                <html:option value="Savings">SB</html:option>
                <html:option value="Current">CA</html:option>
                <html:option value="Fixed_deposit">FD</html:option>
                <html:option value="Recurring_deposit">RD</html:option>
            </html:select></td>
        <th>Status</th>
        <td><html:text property="status" name="FormBean" styleId="status" disabled="true"></html:text></td>
    </tr>
    <tr>
        <th>AOD</th>
        <td><html:text property="aod" name="FormBean" styleId="aod"></html:text></td>
        <th>Opening Balance</th>
        <td><html:text property="openingBalance" name="FormBean" styleId="openingBalance"></html:text></td>
    </tr>
    <tr>
        <th>Loan A/c.no</th>
        <td><html:text property="loanAccountNo" name="FormBean" styleId="loanAccountNo"></html:text></td>
        <th>Loan Amt.</th>
        <td><html:text property="loanAmt" name="FormBean" styleId="loanAmt"></html:text></td>
    </tr>
    <tr>
        <th>ROI</th>
        <td><html:text property="roi" name="FormBean" styleId="roi" ></html:text></td>
        <th>Tenure</th>
        <td><html:text property="tenure" name="FormBean" styleId="tenure" ></html:text></td>
    </tr>

</table>

    <br><br>
    
    <input type="button" class="btn" onclick="Submit();" value="Update"></input>
</html:form>
 
<script type="text/javascript">
    
         $('#accountNo, #custId').change(function() {
            var id=document.getElementById('accountNo').value || document.getElementById('custId').value;
            var form = document.forms[0];
            form.action="account.do?id="+id;
            form.submit();
            
        });
        
        function Submit(){
           var id= document.getElementById('custId').value;
            var form = document.forms[0];
            form.action="account.do?updateById="+id;
            form.method='POST';
            form.submit();
        }
</script>

<jsp:include page="./Footer.jsp" flush="true" />
