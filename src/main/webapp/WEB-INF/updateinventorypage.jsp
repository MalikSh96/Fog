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
        <%  InventoryMapper im = new InventoryMapper();
            %>
    <center>
        <h1>Opdater Lager</h1>
        
        
      
<form action="FrontController" method="POST">
            <input type="hidden" name="command" value="updateinventory">
            <div>
                <label> Navn</label><br><input type="text" name="name" placeholder="Navn"/><br>
            </div>            
            <div>
                <label> Beskrivelse</label><br><input type="text" name="desc" placeholder="Beskrivelse"/><br>
            </div>            
            <div>
                <label> Længde</label><br><input type="number" name="length" placeholder="Længde"/><br>
            </div>            
            <div>
                <label> Enhed</label><br><input type="text" name="unit" placeholder="Enhed"/><br>
            </div>                               
            <div>
                <label> Status</label><br><input type="number" name="status" placeholder="Status"/><br>
            </div>                 
            <div>
                <label> Pris</label><br><input type="number" name="price" placeholder="Pris"/><br>
            </div>                 
            <br> <input type="submit" value="Opdater lagerbeholdning"><br>
            </form>
        </center>
        <br><br> <a href="FrontController?command=adminpage">Tilbage</a>

    </body>
</html>
