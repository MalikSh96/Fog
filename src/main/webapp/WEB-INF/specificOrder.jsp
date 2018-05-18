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
    </head>

    <%@include file="../navigation/menu.jsp" %>
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

</html>
