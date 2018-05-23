
<%@page import="dbaccess.OrderMapper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Opdater Info</title>
        <link href="stylesheetnavigation.css" rel="stylesheet" type="text/css"/>
        <link href="stylesheet.css" rel="stylesheet" type="text/css"/>
        <link href="stylesheetfooter.css" rel="stylesheet" type="text/css"/>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous"><link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

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

        <%
            int id = (int) session.getAttribute("id");
            UserMapper um = new UserMapper();
            User us = um.getUser(id);
        %>

        <%@include file="../navigation/menu.jsp" %>
        <form action="FrontController" method="POST">
            <input type="hidden" name="command" value="updateinfo">
            <div class="information-text-center-site">   

                <h3>information</h3>
                Navn: <%= us.getName() + " " + us.getLastname()%><br>
                Adresse:  <%= us.getAddress()%><br>
                Post nr: <%= us.getPostalcode()%><br>
                Telefon nr: <%= us.getPhone()%><br>
                Email: <%= us.getEmail()%><br><br> 
            </div> 

            <table class="updateinfopagetable">
                <tr>
                    <td colspan="2">
                        <h1>Update User Info</h1>
                    </td>
                </tr>
                <tr>
                    <td> 

                        <label> Navn</label><br><input type="text" name="name" placeholder="Navn"/>
                    </td>
                    <td>

                        <label> Telefon nummer</label><br><input type="number" name="phone" max="99999999" min="11111111" placeholder="Telefonnr."/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label> Efternavn</label><br><input type="text" name="lastname" placeholder="Efternavn"/>

                    </td>
                    <td>
                        <label> Email</label><br><input type="text" name="email" placeholder="Email"/>

                    </td>
                </tr>
                <tr>
                    <td>

                        <label> Password</label><br><input type="text" name="password" placeholder="Password"/><br>
                    </td>
                    <td>
                        <label> Adresse</label><br><input type="text" name="address" placeholder="Adresse"/>
                        <br/>
                    </td>
                <tr/>
                <tr>

                    <td colspan="2" style="width: 150px; text-align: center;" > 
                        <label> Postnummer</label><br><input type="number" name="postal" max="9999" min="1111" placeholder="Postnr."/>
                    </td>            
                </tr>
                <tr>
                    
                        <td  style="width: 150px; text-align: center; padding-top: 10px;">
                        <input type="submit" value="Gem Ændringer" class="btn btn-primary" >
                        </td>
                        <td style="width: 150px; text-align: center; padding-top: 10px;">
                            <a href="FrontController?command=customerpage" class="btn btn-primary" role="button">Gå Tilbage</a>
                        </td>
                    
                </tr>
            </table>
        </form>

        <%@include file="../footer/footer.jsp" %>
    </body>
</html>
