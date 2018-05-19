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
        <link href="stylesheetfooter.css" rel="stylesheet" type="text/css"/>
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

        Kunde nr: <%= um.getUserId(user.getEmail())%><br>
        Navn: <%= us.getName() + " " + us.getLastname()%><br>
        Adresse:  <%= us.getAddress()%><br>
        Post nr: <%= us.getPostalcode()%><br>
        Telefon nr: <%= us.getPhone()%><br>
        Email: <%= us.getEmail()%><br><br>   

        <a href="FrontController?command=updateinfopage">Opdater personlige informationer</a>

    </center>
    <%@include file="../footer/footer.jsp" %>

</body>
</html>
