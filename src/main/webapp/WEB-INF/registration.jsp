<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="stylesheetnavigation.css" rel="stylesheet" type="text/css"/>
        <link href="stylesheet.css" rel="stylesheet" type="text/css"/>
        <link href="stylesheetfooter.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous"><link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
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

        <form class="Restrationform" name="register" action="FrontController" method="POST">
            <input type="hidden" name="command" value="register">
            
            <div class="registrationimagefuglpersketiv">
                <img src="Image/fuglpersketiv.png" />
                
            </div>
            <div class="registrationimagesidepersketiv">
                <img src="Image/sidepersketiv.png" />
                
            </div>
            <table class="Regstrationmiddle">
                <tr>
                    <td colspan="2">
           
                        <h1>
                            Opret bruger
                        </h1>
                    </td>
                </tr>
                <tr>
                    <td class="Regstrationtext">
                        
                        Navn<br>
                        <input type="text" name="name" value="" placeholder="Navn" required>
                        <br>
                        Efternavn<br>
                        <input type="text" name="lastname" value="" placeholder="Efternavn" required>
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

                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="Opret Bruger" class="btn btn-primary" style="margin-top: 10px;">
                    </td>

                </tr>

            </table>
        </form>
    </center>
        <%@include file="../footer/footer.jsp" %>
    </body>
</html>
