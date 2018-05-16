<%-- 
    Document   : updateinfo
    Created on : 02-05-2018, 13:06:48
    Author     : Joklin
--%>

<%@page import="dbaccess.UserMapper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>OpdaterInfo</title>
        <link href="stylesheetnavigation.css" rel="stylesheet" type="text/css"/>
        <link href="stylesheet.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
                        <%@include file="../navigation/menu.jsp" %>
        <h1>Update User Info</h1>
       <%
            int id = (int) session.getAttribute("id");
            UserMapper um = new UserMapper();
            User us = um.getUser(id);
        %>
       <form action="FrontController" method="POST">
            <input type="hidden" name="command" value="updateinfo">
            <div class="name">
                <label> Navn</label><br><input value="<% out.print(us.getName()); %>" type="text" name="name" placeholder="Navn"/>
            </div>            
            <div class="adresse">
                <label> Adresse</label><br><input value="<% out.print(us.getAddress()); %>" type="text" name="address" placeholder="Adresse"/>
            </div>            
            <div class="postalnummer">
                <label> Postnummer</label><br><input value="" type="number" name="postal" max="9999" min="1111" placeholder="<% out.print(us.getPostalcode());%>"/>
            </div>            
            <div class="phone">
                <label> Telefon nummer</label><br><input  type="number" name="phone" max="99999999" min="11111111" placeholder="<% out.print(us.getPhone()); %>"/>
            </div>                               
            <div class="Email">
                <label> Email</label><br><input value="<% out.print(us.getEmail()); %>" type="text" name="email" placeholder="Email"/>
            </div>                 
            <div class="password">
                <label> Password</label><br><input value="<% out.print(us.getPassword()); %>" type="text" name="password" placeholder="Password"/><br>
            </div>
                <input type="submit" value="Gem Ændringer">
            </form>
        
            <p> du mangler en felt </p>
        <% }%>
        
    </body>
</html>
