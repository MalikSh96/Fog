<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="stylesheetnavigation.css" rel="stylesheet" type="text/css"/>
        <link href="stylesheet.css" rel="stylesheet" type="text/css"/>
        <link href="stylesheetfooter.css" rel="stylesheet" type="text/css"/>
        <title>Registration</title>
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


        <div class="body">
            <table class="Regstrationmiddle">
                <form name="register" action="FrontController" method="POST">
                    <tr>
                        <td colspan="2">
                            <h1>Registrering</h1>
                        </td>
                    </tr>
                    <tr>

                        <td class="Regstrationtext">

                            <input type="hidden" name="command" value="register">

                            Navn<br>
                            <input type="text" name="name" value="" placeholder="Navn" required>
                            <br>
                            Addresse<br>
                            <input type="text" name="address" value="" placeholder="Addresse" required>
                            <br>
                            Postnr.<br>
                            <input type="tel" name="postalcode" placeholder="Postnr." 
                                   size="20" minlength="4" maxlength="4" required>
                            <br>

                            By <br>
                            <input type="text" name="by" value="" placeholder="By" required>

                        </td>
                        <td class="Regstrationtext">
                            Telefon nr.<br>
                            <input type="tel" name="phonenumber" placeholder="Telefon nr."
                                   size="20"  minlength="8" maxlength="8"  required>
                            <br>

                            Email<br>
                            <input type="email" name="email" value="" placeholder="Email" required>
                            <br>
                            Password<br>
                            <input type="password" name="password1" value="" placeholder="Password" required>
                            <br>
                            Bekræft Password<br>
                            <input type="password" name="password2" value="" placeholder="Password" required>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <input type="submit" value="Opret Bruger">

                        </td>                  
                </form>
            </table>
            <%@include file="../footer/footer.jsp" %>

    </body>
</html>
