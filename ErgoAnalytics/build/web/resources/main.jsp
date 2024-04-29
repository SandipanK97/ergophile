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
            <th>Name</th>
            <td><html:text property="name" name="FormBean" styleId="name"></html:text></td>
            <th>Fname</th>
            <td><html:text property="fname" styleId="fname" name="FormBean"></html:text></td>
        </tr>
        <tr>
            <th>Mname</th>
            <td><html:text property="mname" styleId="mname" name="FormBean"></html:text></td>
            <th>Lname</th>
            <td><html:text property="lname" styleId="lname" name="FormBean"></html:text></td>
        </tr>
        <tr>
            <th>DOB</th>
            <td><html:text property="dob" styleId="dob" name="FormBean"></html:text></td>
            <th>Mobile no.</th>
            <td> <html:text property="mobileNo" styleId="mobileNo"  name="FormBean"></html:text></td>
        </tr>
        <tr>
            <th>Occupation</th>
            <td><html:text property="occupation" styleId="occupation" name="FormBean"></html:text></td>
            <th>City</th>
            <td><html:text property="city" styleId="city" name="FormBean"></html:text></td>
        </tr>
         <tr>
            <th>State</th>
            <td>
            
            <html:select property="state" styleId="state" name="FormBean">
							<html:option value="">Select State</html:option>
							<html:option value="Andhra Pradesh">Andhra Pradesh</html:option>
							<html:option value="Andaman and Nicobar Islands">Andaman and Nicobar Islands</html:option>
							<html:option value="Arunachal Pradesh">Arunachal Pradesh</html:option>
							<html:option value="Assam">Assam</html:option>
							<html:option value="Bihar">Bihar</html:option>
							<html:option value="Chandigarh">Chandigarh</html:option>
							<html:option value="Chhattisgarh">Chhattisgarh</html:option>
							<html:option value="Dadar and Nagar Haveli">Dadar and Nagar Haveli</html:option>
							<html:option value="Daman and Diu">Daman and Diu</html:option>
							<html:option value="Delhi">Delhi</html:option>
							<html:option value="Lakshadweep">Lakshadweep</html:option>
							<html:option value="Puducherry">Puducherry</html:option>
							<html:option value="Goa">Goa</html:option>
							<html:option value="Gujarat">Gujarat</html:option>
							<html:option value="Haryana">Haryana</html:option>
							<html:option value="Himachal Pradesh">Himachal Pradesh</html:option>
							<html:option value="Jammu and Kashmir">Jammu and Kashmir</html:option>
							<html:option value="Jharkhand">Jharkhand</html:option>
							<html:option value="Karnataka">Karnataka</html:option>
							<html:option value="Kerala">Kerala</html:option>
							<html:option value="Madhya Pradesh">Madhya Pradesh</html:option>
							<html:option value="Maharashtra">Maharashtra</html:option>
							<html:option value="Manipur">Manipur</html:option>
							<html:option value="Meghalaya">Meghalaya</html:option>
							<html:option value="Mizoram">Mizoram</html:option>
							<html:option value="Nagaland">Nagaland</html:option>
							<html:option value="Odisha">Odisha</html:option>
							<html:option value="Punjab">Punjab</html:option>
							<html:option value="Rajasthan">Rajasthan</html:option>
							<html:option value="Sikkim">Sikkim</html:option>
							<html:option value="Tamil Nadu">Tamil Nadu</html:option>
							<html:option value="Telangana">Telangana</html:option>
							<html:option value="Tripura">Tripura</html:option>
							<html:option value="Uttar Pradesh">Uttar Pradesh</html:option>
							<html:option value="Uttarakhand">Uttarakhand</html:option>
							<html:option value="West Bengal">West Bengal</html:option>
					</html:select>
            </td>
            <th>Address pin</th>
            <td><html:text property="addressPin" name="FormBean" styleId="addressPin"></html:text></td>
        </tr>
         <tr>
            <th>Aadhar No.</th>
            <td><html:text property="aadharNo" name="FormBean" styleId="aadharNo"></html:text></td>
            <th>PAN No.</th>
            <td><html:text property="panNo" name="FormBean" styleId="panNo"></html:text></td>
        </tr>
        <tr>
            <th>e-kyc status</th>
            <td>
              <html:select styleId="isEkycDone" property="isEkycDone" name="FormBean">
            	<html:option value="Y">Y</html:option>
            	<html:option  value="N">N</html:option>
       	     </html:select>
            </td>
            <th>Passport No.</th>
            <td><html:text property="passportNo" styleId="passportNo" name="FormBean"></html:text></td>
        </tr>
        
    </table>

    <br><br>
    
    <input type="button" class="btn" onclick="Submit();" value="Update"></input>
  
 </html:form>
 
<script type="text/javascript">
    
         $('#accountNo, #custId').change(function() {
            var id=document.getElementById('accountNo').value || document.getElementById('custId').value;
            var form = document.forms[0];
            form.action="custDtls.do?id="+id;
            form.submit();
            
        });
        
        function Submit(){
           var id= document.getElementById('custId').value;
            var form = document.forms[0];
            form.action="custDtls.do?updateById="+id;
            form.method='POST';
            form.submit();
        }
</script>
    
<jsp:include page="./Footer.jsp" flush="true" />