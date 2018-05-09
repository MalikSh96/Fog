<%-- 
    Document   : customorder
    Created on : 02-05-2018, 12:44:54
    Author     : Joklin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Custom Ordre</title>
        <link href="stylesheetnavigation.css" rel="stylesheet" type="text/css"/>
        <link href="stylesheet.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        
        
        <%@include file="../navigation/menu.jsp" %>
        <h1>Input order</h1>
Med et specialudviklet computerprogram kan vi lynhurtigt beregne prisen og udskrive en skitsetegning på
<br>en carport indenfor vores standardprogram, der tilpasses dine specifikke ønsker.
<br><br>
Tilbud  og skitsetegning fremsendes med post hurtigst muligt.<br>
Ved be  stilling medfølger standardbyggevejledning. <br><br>

Udfyld nedenstående omhyggeligt og klik på "Bestil tilbud"<br>
Felter markeret * SKAL udfyldes!<br><br>

        <form action="FrontController" method="POST">
            <input type="hidden" name="command" value="order">
            <div class="length">
                <label>Vælg Længde</label><br>
                <input type="number" name="length" max="999" required value="240" min="240"/>
            </div>            
            <div class="width">
                <label>Vælg Bredde</label><br>
                 <input type="number" name="width" max="999" required value="240" min="240"/>
            </div>            
            <div class="height">
                <label> Vælg Højde</label><br><input type="number" name="height" max="400" required value="160" min="160"/>
            </div>
                
                <input type="submit" value="Order">
            </form>
    </body>
</html>
