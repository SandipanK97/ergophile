<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>ergoAnalytics</title>
        <link rel="stylesheet" href="styles.css">
        <script type="text/javascript">

        </script>
    </head>
    <body>
        <div class="container">
            <form action="main.do" method="POST">
                <h2>ergoAnalytics</h2>
                <div class="form-group">
                    <input type="text" id="username" name="username" placeholder="UserId" required>
                </div>
                <div class="form-group">
                    <input type="password" id="password" name="password" placeholder="Password" required>
                </div>
                <input type="submit" value="Login"  name="submit" />  
            </form>
        </div>
    </body>
</html>
