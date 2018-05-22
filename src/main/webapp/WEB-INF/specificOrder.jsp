<%@page import="dbaccess.ItemlistMapper"%>
<%@page import="dbaccess.OrderMapper"%>
<%@page import="dbaccess.UserMapper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Specific Order</title>
        <link href="stylesheetnavigation.css" rel="stylesheet" type="text/css"/>
        <link href="stylesheet.css" rel="stylesheet" type="text/css"/>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <link href="stylesheetfooter.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous"><link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    </head>
    <body>
    <%@include file="../navigation/menu.jsp" %>
    <center>
    <h1>Order nr: </h1>


    <%
        int id = (int) session.getAttribute("orderid");
        session.setAttribute("ordernumber", id);
        UserMapper um = new UserMapper();
        OrderMapper om = new OrderMapper();
        ItemlistMapper ilm = new ItemlistMapper();
        User us = (User) session.getAttribute("user");
    %>


    <%=om.getOrder(id).toString().replace("[", "").replace("]", "").replace(",", "<br>") + "<br>"%><br>
    
    <%if(!us.isAdmin(um.getUserRole(us.getId())) && om.getOrder(id).isOrderConfirmed()|| us.isAdmin(um.getUserRole(us.getId()))) {
    out.println(ilm.getFullItemlist(id).toString().replace("[", "").replace("]", "").replace(",", "<br>") + "<br>"); }%><br>

    <% if (us.isAdmin(um.getUserRole(us.getId())) && !om.getOrder(id).isOrderConfirmed()) {%>
    <form action="FrontController" method="POST">
        <input type="hidden" name="command" value="sendorder">
        <input type="submit" name="ordernumber" value="Send ordre" />
    </form>
    <%}%>
    </center>
    <% if(us.isAdmin(um.getUserRole(us.getId()))) { %>
            <a href="FrontController?command=adminpage">Tilbage</a><br><br>
            <% }%>
</body>
</html>
