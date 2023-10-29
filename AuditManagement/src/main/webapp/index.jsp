<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Banking Login</title>
    <link rel="stylesheet" href="styles.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script>
        $(document).ready(function () {
            const openPopupLink = $("#openPopupLink");
            const submitButton = $("#submitButton");
            const mainField = $("#mainField");
            let popupData = {};

            openPopupLink.on("click", function (event) {
                event.preventDefault();

                // Reset popupData when opening the popup
                popupData = {};
				
                
                const popupWindow = window.open("", "PopupWindow", "width=400,height=250,top=300,left=600");
                const popupContent = `
                    <form id="popupForm" style="font-weight: bold;font-size:80%;">
                        <label for="Name">Enter user id : </label><br><br>
                        <input type="text" id="Name" name="Name"><br><br>
                        <label for="passwrd">Enter password : </label><br><br>
                        <input type="password" id="passwrd" name="passwrd"><br><br>
                        <label for="cnfpasswrd">Confirm password : </label><br><br>
                        <input type="password" id="cnfpasswrd" name="cnfpasswrd"><br><br>
                     
                        <input type="submit" id="closePopupButton"></input>
                    </form>
                `;
                popupWindow.document.body.innerHTML = popupContent;

                const popupForm = $(popupWindow.document).find("#popupForm");
                let Name = $(popupWindow.document).find("#Name");
                let passwrd = $(popupWindow.document).find("#passwrd");
                let cnfpasswrd = $(popupWindow.document).find("#cnfpasswrd");
                const closePopupButton = $(popupWindow.document).find("#closePopupButton");

                popupForm.on("submit", function (event) {
                    event.preventDefault();
                    let nameData = Name.val();
                    let passwrdData = passwrd.val();
                	popupData.nameData = nameData;
                    popupData.passwrdData = passwrdData;
                });

                closePopupButton.on("click", function () {
                	popupWindow.close();
                });
            });

            submitButton.on("click", function () {
                const mainFieldData = mainField.val();
                
                // Combine main page data with popup data
                const combinedData = {
                    mainFieldData,
                    ...popupData
                };
                
                // Now you can send 'combinedData' to your server or process it further
                console.log(combinedData);
                
            });
        });
    </script>
</head>
<body>
    <div class="container">
        <form id="login-form" action="main.do" method="post">
            <h2>Ergophile</h2>
            <div class="form-group">
                <input type="text" id="username" placeholder="UserId" required>
            </div>
            <div class="form-group">
                <input type="password" id="password" placeholder="Password" required>
            </div>
            <button type="submit" value="Y" id="submitButton">Login</button>
            <button id="openPopupLink">Register</button>
         </form>
    </div>

    <script>
    
    </script>
</body>
</html>
