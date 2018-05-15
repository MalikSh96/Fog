
<%@page import="dbaccess.OrderMapper"%>
<%@page import="functionlayer.User"%>
<%@page import="dbaccess.UserMapper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>specific user</title>
        <link href="stylesheetnavigation.css" rel="stylesheet" type="text/css"/>
        <link href="stylesheet.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%@include file="../navigation/menu.jsp" %>


        <%
            int id = (int) session.getAttribute("id");
            UserMapper um = new UserMapper();
            OrderMapper om = new OrderMapper();
            User us = um.getUser(id);
            
        %>

    <center>
        Kunde nr: <%= id%><br>
        Navn: <%= us.getName()%><br>
        Adresse:  <%= us.getAddress()%><br>
        Post nr: <%= us.getPostalcode()%><br>
        Telefon nr: <%= us.getPhone()%><br>
        Email: <%= us.getEmail()%><br><br> 
        
        Kundens ordrer:<br><br>
        
        <%=om.allCustomerOrders(id).toString().replace("[","").replace("]","").replace(",","").replace("Orderhistory","<br>Orderhistory")+"<br>"%><br>
  
        
    </center>
    </body>
</html>
