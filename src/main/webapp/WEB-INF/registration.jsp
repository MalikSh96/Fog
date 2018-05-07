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
        <link href="stylesheetnavigation.css" rel="stylesheet" type="text/css"/>
        <link href="stylesheet.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        
        <style>
            input[type=number]::-webkit-inner-spin-button, 
            input[type=number]::-webkit-outer-spin-button { 
                -webkit-appearance: none;
                margin: 0;
            }
            input[type=number] {
                -moz-appearance: textfield;
            }


        </style>
        <%@include file="../navigation/menu.jsp" %>
        <h1>Registration</h1>       

        <table>
            <tr>
                <td>
                    <form name="register" action="FrontController" method="POST">
                        <input type="hidden" name="command" value="register">
                        Navn<br>
                        <input type="text" name="name" value="" placeholder="Navn">
                        <br>
                        Addresse<br>
                        <input type="text" name="address" value="" placeholder="Addresse">
                        <br>
                        Postnr.<br>
                        <input type="tel" name="postalcode" placeholder="Postnr." 
                               size="20" minlength="4" maxlength="4">
                        <br>
                        By <br>
                        <input type="text" name="by" value="" placeholder="By">
                        <br>
                        Telefon nr.<br>
                        <input type="tel" name="phonenumber" placeholder="Telefon nr."
                              size="20"  minlength="8" maxlength="8"  >
                        <br>
                        Email<br>
                        <input type="email" name="email" value="" placeholder="Email">
                        <br>
                        Password<br>
                        <input type="password" name="password1" value="" placeholder="Password">
                        <br>
                        Bekræft Password<br>
                        <input type="password" name="password2" value="" placeholder="Password">
                        <br>
                        <input type="submit" value="Opret Bruger">
                    </form>
                </td>
            </tr>
        </table>
    </body>
</html>
