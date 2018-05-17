
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Opdater Info</title>
        <link href="stylesheetnavigation.css" rel="stylesheet" type="text/css"/>
        <link href="stylesheet.css" rel="stylesheet" type="text/css"/>
        <link href="stylesheetfooter.css" rel="stylesheet" type="text/css"/>

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
        <form action="FrontController" method="POST">
            <input type="hidden" name="command" value="updateinfo">
            <table class="updateinfopagetable">
                <tr>
                    <td colspan="2">
                        <h1>Update User Info</h1>
                    </td>
                </tr>
                <tr>
                    <td> 

                        <label> Navn</label><br><input type="text" name="name" placeholder="Navn"/>
                        <br/>


                        <label> Efternavn</label><br><input type="text" name="lastname" placeholder="Efternavn"/>
                        <br/>

                        <label> Adresse</label><br><input type="text" name="address" placeholder="Adresse"/>
                        <br/>

                        <label> Postnummer</label><br><input type="number" name="postal" max="9999" min="1111" placeholder="Postnummer"/>
                    </td>            
                    <td>
                        <label> Telefon nummer</label><br><input type="number" name="phone" max="99999999" min="11111111" placeholder="Telefon nr."/>
                        <br/>
                        
                        <label> Email</label><br><input type="text" name="email" placeholder="Email"/>
                        <br/>
                        
                        <label> Password</label><br><input type="text" name="password" placeholder="Password"/><br>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <br><input type="submit" value="Gem Ændringer">
                    </td>
                </tr>
            </table>
        </form>

        <%@include file="../footer/footer.jsp" %>
    </body>
</html>
