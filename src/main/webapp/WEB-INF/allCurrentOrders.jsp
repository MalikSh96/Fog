<%-- 
    Document   : allCurrentOrders
    Created on : 07-05-2018, 10:45:50
    Author     : Joklin
--%>

<%@page import="dbaccess.OrderMapper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>nuværende ordre</title>
        <link href="stylesheetnavigation.css" rel="stylesheet" type="text/css"/>
        <link href="stylesheet.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%@include file="../navigation/menu.jsp" %>
    <center>
        <h1>Alle nuværende ordrer</h1>
        
                <form action="FrontController" method="POST">
            <input type="hidden" name="command" value="sendorder">
        <label>Ordre id</label><br><input type="number" name="id" placeholder="Order ID" required value="1"/>
                <input type="submit" value="Send ordre" />
                </form>
        
        <% OrderMapper om = new OrderMapper();%>
        
        <%=om.pendingOrders().toString().replace("[","").replace("]","").replace(",","")+"<br>"%><br>
   
    </center>
        <a href="FrontController?command=adminpage">Tilbage</a><br><br>
    </body>
</html>
