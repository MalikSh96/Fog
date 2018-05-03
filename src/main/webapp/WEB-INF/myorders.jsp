<%-- 
    Document   : myorders
    Created on : 02-05-2018, 13:01:24
    Author     : Joklin
--%>

<%@page import="dbaccess.OrderMapper"%>
<%@page import="functionlayer.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>orderlist</title>
        <link href="stylesheetnavigation.css" rel="stylesheet" type="text/css"/>
        <link href="stylesheet.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
                <%@include file="../navigation/menu.jsp" %>
        <h1>Kunde Ordre Liste</h1>
        
                        <%
           
            OrderMapper om = new OrderMapper();
            %>
        
 <%=om.allCustomerOrders(user.getId()).toString().replace("[","").replace("]","").replace(",","").replace("Orderhistory","<br>Orderhistory")+"<br>"%><br>
                
        
    </body>
</html>
