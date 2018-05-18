<%@page import="presentationlayer.Inventory"%>
<%@page import="dbaccess.InventoryMapper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Opdater Lager</title>
        <link href="stylesheetnavigation.css" rel="stylesheet" type="text/css"/>
        <link href="stylesheet.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%@include file="../navigation/menu.jsp" %>
            
    <center>
        <h1>Opdater Lager</h1>

<form action="FrontController" method="POST">
            <input type="hidden" name="command" value="updateinventory">
            <div>
                <label> Navn</label><br><input type="text" name="name" placeholder="Navn" required/><br>
            </div>            
            <div>
                <label> Beskrivelse</label><br><input type="text" name="description" placeholder="Beskrivelse" required/><br>
            </div>            
            <div>
                <label> Længde</label><br><input type="number" name="length" placeholder="Længde" required/><br>
            </div>            
            <div>
                <label> Enhed</label><br><input type="text" name="unit" placeholder="Enhed" required/><br>
            </div>                               
            <div>
                <label> Status</label><br><input type="number" name="status" placeholder="status" required/><br>
            </div>                 
            <br> <input type="submit" value="Tilføj til Lageret"><br>
            </form>
        </center>
        <br><br> <a href="FrontController?command=adminpage">Tilbage</a>

    </body>
</html>
