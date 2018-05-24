<%@page import="datalayer.OrderMapper"%>
<%@page import="businesslayer.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mine Ordre</title>
        <link href="stylesheetnavigation.css" rel="stylesheet" type="text/css"/>
        <link href="stylesheet.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
                <%@include file="../navigation/menu.jsp" %>
    <center>
        <h1>Dine Ordrer</h1>            
        
            <br><%=bf.allCustomerOrdersId(user.getId()).toString().replace("[","").replace("]","").replace(",","").replace(" ", "<br>")+"<br>"%><br>

                <form action="FrontController" method="POST">
            <input type="hidden" name="command" value="specificOrder">
        <br><input type="number" name="chosenid" placeholder="Order ID"/>
        <input type="submit" value="Se ordre" /><br>
                </form>
        
                 
    </center>
    </body>
</html>
