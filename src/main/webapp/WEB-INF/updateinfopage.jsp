<%-- 
    Document   : updateinfo
    Created on : 02-05-2018, 13:06:48
    Author     : Joklin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>OpdaterInfo</title>
        <link href="stylesheetnavigation.css" rel="stylesheet" type="text/css"/>
        <link href="stylesheet.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
                        <%@include file="../navigation/menu.jsp" %>
        <h1>Update User Info</h1>
        
       <form action="FrontController" method="POST">
            <input type="hidden" name="command" value="updateinfo">
            <div class="height">
                <label> Navn</label><br><input type="text" name="name" placeholder="Navn"/>
            </div>            
            <div class="length">
                <label> Adresse</label><br><input type="text" name="address" placeholder="Adresse"/>
            </div>            
            <div class="width">
                <label> Postnummer</label><br><input type="number" name="postal" max="9999" min="1111" placeholder="Postnummer"/>
            </div>            
            <div class="width">
                <label> Telefon nummer</label><br><input type="number" name="phone" max="99999999" min="11111111" placeholder="Telefon nr."/>
            </div>                               
            <div class="width">
                <label> Email</label><br><input type="text" name="email" placeholder="Email"/>
            </div>                 
            <div class="width">
                <label> Password</label><br><input type="text" name="password" placeholder="Password"/><br>
            </div>
                <input type="submit" value="Gem Ændringer">
            </form>
        
        
    </body>
</html>
