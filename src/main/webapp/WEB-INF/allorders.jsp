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
        
        <%=om.getAllOrderIds().toString().replace("[","").replace("]","").replace(",","").replace(" ", "<br>")+"<br>"%><br>
        
                        <form action="FrontController" method="POST">
            <input type="hidden" name="command" value="specificOrder">
        <br><input type="number" name="chosenid" placeholder="Order ID"/>
        <input type="submit" value="Se ordre" /><br>
                </form>
    </center>
                <a href="FrontController?command=adminpage">Tilbage</a><br><br>
    </body>
</html>
