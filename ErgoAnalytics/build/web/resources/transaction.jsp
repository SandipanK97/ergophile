<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.io.*,java.util.*, javax.servlet.*" %>

<jsp:include page="./Header.jsp" flush="true" />
<jsp:include page="./Navbar.jsp" flush="true" />
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

<jsp:include page="./Footer.jsp" flush="true" />
