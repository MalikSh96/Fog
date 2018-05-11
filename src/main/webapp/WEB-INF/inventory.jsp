<%-- 
    Document   : inventory
    Created on : 07-05-2018, 10:46:01
    Author     : Joklin
--%>

<%@page import="dbaccess.InventoryMapper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inventory</title>
    </head>
    <body>
        <h1>Lagerstatus</h1>
        
        <% InventoryMapper im = new InventoryMapper();%>
        
        
        <%=im.completeInventory().toString().replace("[","").replace("]","").replace(",","")+"<br>"%><br>  
        
    </body>
</html>
