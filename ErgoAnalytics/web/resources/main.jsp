<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.io.*,java.util.*, javax.servlet.*" %>
<%@ page import="com.audit.customer.FormBean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<jsp:include page="./Header.jsp" flush="true" />
<jsp:include page="./Navbar.jsp" flush="true" />

<html:form action="custDtls.do" method="POST">
    <table>
        <tr>
            <th>Name</th>
            <td><html:text property="name" name="FormBean"  disabled="true"></html:text></td>
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
            <td> <input type="tel" name="mobileNo" id="mobileNo" pattern="[0-9]{10}" title="Please enter a 10-digit mobile number." ></td>
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
            <td><input type="number" name="addressPin" id="addressPin" pattern="[0-9]{1,6}" title="Please enter a number with a maximum of 6 digits." ></td>
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
   
    <input type="submit" class="btn" onclick="return checkValidationSubmit();" value="Update"></input>
  
</html:form>
 
<script type="text/javascript">
    
         $('#accountNo, #custId').change(function() {
            var id=document.getElementById('accountNo').value || document.getElementById('custId').value;
            var form = document.forms[0];
            form.action="custDtls.do?fetchById="+id;
            form.submit();
            
        });
        
        function checkValidationSubmit(){
           
           var element = document.getElementById('passportNo');
           if(element && element.value.trim() !== ''){
               return true;
           }
           alert('Please provide Passport number');
           return false;
            
        }
</script>
    
<jsp:include page="./Footer.jsp" flush="true" />