<%-- 
    Document   : updateInventory
    Created on : 07-05-2018, 10:46:33
    Author     : Joklin
--%>

<%@page import="presentationlayer.Inventory"%>
<%@page import="dbaccess.InventoryMapper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>OpdaterLager</title>
    </head>
    <body>
        <h1>Opdater Lager</h1>

<form action="FrontController" method="POST">
            <input type="hidden" name="command" value="updateinventory">
            <div class="height">
                <label> Navn</label><br><input type="text" name="name" placeholder="Navn"/><br>
            </div>            
            <div class="length">
                <label> Beskrivelse</label><br><input type="text" name="description" placeholder="Beskrivelse"/><br>
            </div>            
            <div class="width">
                <label> Længde</label><br><input type="number" name="length" placeholder="Længde"/><br>
            </div>            
            <div class="width">
                <label> Enhed</label><br><input type="text" name="unit" placeholder="Enhed"/><br>
            </div>                               
            <div class="width">
                <label> Status</label><br><input type="number" name="status" placeholder="status"/><br>
            </div>                 
             <input type="submit" value="Tilføj til Lageret"><br>
            </form>
        
        <br><br> <a href="FrontController?command=adminpage">Tilbage</a>

    </body>
</html>
