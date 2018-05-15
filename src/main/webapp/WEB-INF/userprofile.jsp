<%-- 
    Document   : userprofile
    Created on : 15-05-2018, 10:08:52
    Author     : Joklin
--%>

<%@page import="functionlayer.User"%>
<%@page import="dbaccess.UserMapper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profile Page</title>
        <link href="stylesheetnavigation.css" rel="stylesheet" type="text/css"/>
        <link href="stylesheet.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>

        <%@include file="../navigation/menu.jsp" %>
        <%
            int id = (int) session.getAttribute("id");
            UserMapper um = new UserMapper();
            User us = um.getUser(id);
        %>
    <center>
        <br><h1>Dine informationer:</h1><br><br>       

        Kunde nr: <%= us.getId()%><br>
        Navn: <%= us.getName()%><br>
        Adresse:  <%= us.getAddress()%><br>
        Post nr: <%= us.getPostalcode()%><br>
        Telefon nr: <%= us.getPhone()%><br>
        Email: <%= us.getEmail()%><br><br>   

        <a href="FrontController?command=updateinfopage">Opdater personlige informationer</a>

    </center>


</body>
</html>