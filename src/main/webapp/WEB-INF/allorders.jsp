<%-- 
    Document   : allOrders
    Created on : 07-05-2018, 10:45:20
    Author     : Joklin
--%>

<%@page import="dbaccess.OrderMapper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Alle ordrer</h1>
        
        <% OrderMapper om = new OrderMapper();%>
        
        <%=om.allOrders().toString().replace("[","").replace("]","").replace(",","")+"<br>"%><br>
    </body>
</html>
