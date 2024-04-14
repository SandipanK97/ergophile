<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*, javax.servlet.*"%>

<jsp:include page="./Header.jsp" flush="true" />
<jsp:include page="./Navbar.jsp" flush="true" />
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

<jsp:include page="./Footer.jsp" flush="true" />
