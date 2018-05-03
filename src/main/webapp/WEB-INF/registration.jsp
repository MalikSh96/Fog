<%-- 
    Document   : registration
    Created on : 02-05-2018, 12:16:42
    Author     : Joklin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Registration</h1>       
        
        <table>
        <tr><td>Register</td>
                <td>
                    <form name="register" action="FrontController" method="POST">
                        <input type="hidden" name="command" value="register">
                        Navn:<br>
                        <input type="text" name="name" value="name">
                        <br>
                        Addresse:<br>
                        <input type="text" name="address" value="address">
                        <br>
                        Postnr.:<br>
                        <input type="number" name="postalcode" value="1234">
                        <br>
                        Telefon nr.:<br>
                        <input type="number" name="phonenumber" value="12345678">
                        <br>
                        Email:<br>
                        <input type="text" name="email" value="someone@nowhere.com">
                        <br>
                        Password:<br>
                        <input type="password" name="password1" value="sesam">
                        <br>
                        Retype Password:<br>
                        <input type="password" name="password2" value="sesam">
                        <br>
                        <input type="submit" value="Submit">
                    </form>
                </td>
        </tr>
        </table>
    </body>
</html>
