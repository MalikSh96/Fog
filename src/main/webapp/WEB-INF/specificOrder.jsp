<%@page import="dbaccess.ItemlistMapper"%>
<%@page import="dbaccess.OrderMapper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Specific Order</title>
        <link href="stylesheetnavigation.css" rel="stylesheet" type="text/css"/>
        <link href="stylesheet.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%@include file="../navigation/menu.jsp" %>
        <h1>Order nr: </h1>
        
        
                  <%
           int id = (int)session.getAttribute("orderid");
            OrderMapper om = new OrderMapper();
            ItemlistMapper ilm = new ItemlistMapper();
            %>
        
        
            <%=om.getOrder(id).toString().replace("[","").replace("]","").replace(",","<br>")+"<br>"%><br>
            <%=ilm.getFullItemlist(id).toString().replace("[","").replace("]","").replace(",","<br>")+"<br>"%><br>
        
    </body>
</html>
