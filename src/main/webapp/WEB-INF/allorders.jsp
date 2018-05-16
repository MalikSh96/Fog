<%@page import="dbaccess.OrderMapper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>all Orders</title>
        <link href="stylesheetnavigation.css" rel="stylesheet" type="text/css"/>
        <link href="stylesheet.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
    <center>
        <%@include file="../navigation/menu.jsp" %>
        <h1>Alle ordrer</h1>
        
        <% OrderMapper om = new OrderMapper();%>
        
        <%=om.allOrders().toString().replace("[","").replace("]","").replace(",","")+"<br>"%><br>
    </center>
                <a href="FrontController?command=adminpage">Tilbage</a><br><br>
    </body>
</html>
