<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.io.*,java.util.*, javax.servlet.*" %>
<jsp:include page="./Header.jsp" flush="true" />
<jsp:include page="./Navbar.jsp" flush="true" />
       <form action="audit.do" method="get">
         <h3>Business Data for Current Quarter(Q4)</h3>
        <table>
        <tr>
           <td>Sales data of bancassurance</td>
           <td><input type="submit" value="view" name="bancassurance"/></td>
           <td>Account Openings</td>
           <td><input type="submit" value="view" name="account"/></td>
          </tr>
          <tr>
           <td>NPA recovery</td>
           <td><input type="submit" value="view" name="npa"/></td>
           <td>Cluster profit figures</td>
           <td><input type="submit" value="view" name="profit"/></td>
          </tr>
        </table>
       </form>
    
<jsp:include page="./Footer.jsp" flush="true" />
