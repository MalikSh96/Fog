<%@page import="dbaccess.UserMapper"%>
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
        <%
        int id = (int)session.getAttribute("id");
        UserMapper um = new UserMapper();
        User us = um.getUser(id);
        %>
    <center>
        <br> <br><h3>Logget ind som: <%= us.getName()%> </h3>
        <a href="FrontController?command=userprofile">Min Profil</a><br><br>
    <a href="FrontController?command=customorder">Skræddersy Ordre</a><br><br>
    <a href="FrontController?command=myorders">Ordrehistorik</a><br><br>
    </center>
</body>
</html>
