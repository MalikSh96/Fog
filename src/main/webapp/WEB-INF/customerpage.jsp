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
        <h3>Hello <%= request.getParameter("name")%> </h3>

        <a href="FrontController?command=customorder">Skræddersy Ordre</a><br><br>
        <a href="FrontController?command=myorders">Ordrehistorik</a><br><br>
        <a href="FrontController?command=updateinfopage">Opdater personlige informationer</a>
    </body>
</html>
