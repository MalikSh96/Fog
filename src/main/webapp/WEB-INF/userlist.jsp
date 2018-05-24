<%@page import="businesslayer.User"%>
<%@page import="java.util.List"%>
<%@page import="datalayer.UserMapper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Brugere</title>
        <link href="stylesheetnavigation.css" rel="stylesheet" type="text/css"/>
        <link href="stylesheet.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
    <center>
        <%@include file="../navigation/menu.jsp" %>

        <h1>Bruger liste</h1>

        <% UserMapper um = new UserMapper();%>

        <%=um.getAllUserIds().toString().replace("[", "").replace("]", "").replace(",", "").replace(" ", "<br>") + "</a><br><br>"%><br>




        <form action="FrontController" method="POST">
            <input type="hidden" name="command" value="specificuser">
            <br><input type="number" name="chosenuserid" placeholder="Bruger ID"/>
            <input type="submit" value="Se bruger" /><br>
        </form>

    </center>
    <a href="FrontController?command=adminpage">Tilbage</a><br><br>
</body>
</html>
