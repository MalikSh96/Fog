<%-- 
    Document   : customerpage
    Created on : Aug 22, 2017, 2:33:37 PM
    Author     : kasper
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer home page</title>
        <link href="stylesheetnavigation.css" rel="stylesheet" type="text/css"/>
        <link href="stylesheet.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        
        <%@include file="../navigation/menu.jsp" %>
        
        <% User us = (User)session.getAttribute("user");
        %>
        <h3>Hello <%= us.getName() %> </h3>

    <center> Dine informationer: <br><br>
        <%= us.getName()%><br>
        <%= us.getAddress()%><br>
        <%= us.getPostalcode()%><br>
        <%= us.getPhone()%><br>
        <%= us.getEmail()%><br>        
    </center>

    <a href="FrontController?command=customorder">Skræddersy Ordre</a><br><br>
    <a href="FrontController?command=myorders">Ordrehistorik</a><br><br>
    <a href="FrontController?command=updateinfopage">Opdater personlige informationer</a>
</body>
</html>
