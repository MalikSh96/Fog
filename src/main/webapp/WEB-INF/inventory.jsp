<%-- 
    Document   : inventory
    Created on : 07-05-2018, 10:46:01
    Author     : Joklin --
--%>

<%@page import="dbaccess.InventoryMapper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inventory</title>
        <link href="stylesheetnavigation.css" rel="stylesheet" type="text/css"/>
        <link href="stylesheet.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%@include file="../navigation/menu.jsp" %>
        <h1>Lagerstatus</h1>
        
        <% InventoryMapper im = new InventoryMapper();%>
        
        
<<<<<<< HEAD
        <%=im.completeInventory().toString().replace("[","").replace("]","").replace(",","")+"<br>"%><br>
   
                    <a href="FrontController?command=updateinventorypage">Tilføj til Lagerdatabase</a><br><br>
                    <a href="FrontController?command=adminpage">Tilbage</a><br><br>
=======
        <%=im.completeInventory().toString().replace("[","").replace("]","").replace(",","")+"<br>"%><br>  
>>>>>>> adminPage
        
    </body>
</html>
