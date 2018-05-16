
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
        <%@include file="../navigation/menu.jsp" %>
        <table class="middle">
            <tr>
                <td>
                    <h1>Update User Info</h1>

                </td>
            </tr>
            <tr>
                <td>
                    <form action="FrontController" method="POST">
                        <input type="hidden" name="command" value="updateinfo">
                        <div class="name">
                            <label> Navn</label><br><input  type="text" name="name" placeholder="Navn"/>
                        </div>            
                        <div class="adresse">
                            <label> Adresse</label><br><input  type="text" name="address" placeholder="Adresse"/>
                        </div>            
                        <div class="postalnummer">
                            <label> Postnummer</label><br><input value="" type="number" name="postal" max="9999" min="1111" placeholder="Post nr."/>
                        </div>            
                        <div class="phone">
                            <label> Telefon nummer</label><br><input  type="number" name="phone" max="99999999" min="11111111" placeholder="Telefon"/>
                        </div>                               
                        <div class="Email">
                            <label> Email</label><br><input  type="text" name="email" placeholder="Email"/>
                        </div>                 
                        <div class="password">
                            <label> Password</label><br><input  type="text" name="password" placeholder="Password"/><br>
                        </div>
                        <br><input type="submit" value="Gem Ændringer">
                    </form>

                </td>                
            </tr>
        </table>
        <%@include file="../footer/footer.jsp" %>
    </body>
</html>
