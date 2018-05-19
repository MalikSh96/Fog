<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee home page</title>
        <link href="stylesheetnavigation.css" rel="stylesheet" type="text/css"/>
        <link href="stylesheet.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
<%//check admin role redirect to index%>
    <center>
        <%@include file="../navigation/menu.jsp" %>

        <h1> Admin page </h1>

        <form name="employeepage" action="FrontController" method="POST">

            <br><br><a href="FrontController?command=allcurrentorders">Alle nuværende ordre</a><br><br>
            <a href="FrontController?command=allorders">Alle ordrer</a><br><br>
            <a href="FrontController?command=inventory">Lagerstatus</a><br><br>
            <a href="FrontController?command=userlist">Bruger liste</a><br><br>


        </form>

        <br>

    </center>
</body>
</html>
