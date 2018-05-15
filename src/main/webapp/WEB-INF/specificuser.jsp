
<%@page import="functionlayer.User"%>
<%@page import="dbaccess.UserMapper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>specificuser</title>
    </head>
    <body>
        <h1>Specific User</h1>


        <%
            int id = (int) session.getAttribute("id");
            UserMapper um = new UserMapper();
            User us = um.getUser(id);
        %>

    <center>
        Kunde nr: <%= id%><br>
        Navn: <%= us.getName()%><br>
        Adresse:  <%= us.getAddress()%><br>
        Post nr: <%= us.getPostalcode()%><br>
        Telefon nr: <%= us.getPhone()%><br>
        Email: <%= us.getEmail()%><br><br> 
    </center>
    </body>
</html>
