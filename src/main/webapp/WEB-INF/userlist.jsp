<%-- 
    Document   : userlist
    Created on : 08-05-2018, 10:51:47
    Author     : Joklin
--%>

<%@page import="functionlayer.User"%>
<%@page import="java.util.List"%>
<%@page import="dbaccess.UserMapper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Brugerliste</title>
        <link href="stylesheetnavigation.css" rel="stylesheet" type="text/css"/>
        <link href="stylesheet.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%@include file="../navigation/menu.jsp" %>
        <h1>Bruger liste</h1>
        
        <% UserMapper um = new UserMapper();%>
        
        <%=um.getAllUsers().toString().replace("[","").replace("]","").replace(",","")+"<br>"%><br>
        
                <a href="FrontController?command=adminpage">Tilbage</a><br><br>
    </body>
</html>
