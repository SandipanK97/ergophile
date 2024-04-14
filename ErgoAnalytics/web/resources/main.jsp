<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.io.*,java.util.*, javax.servlet.*" %>
<jsp:include page="./Header.jsp" flush="true" />
<jsp:include page="./Navbar.jsp" flush="true" />
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


<jsp:include page="./Footer.jsp" flush="true" />