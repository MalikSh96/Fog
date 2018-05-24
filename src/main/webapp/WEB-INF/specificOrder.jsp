<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Specific Order</title>
        <link href="stylesheetnavigation.css" rel="stylesheet" type="text/css"/>
        <link href="stylesheet.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
    <%@include file="../navigation/menu.jsp" %>
    <center>
    <h1>Order nr: </h1>


    <%
        int id = (int) session.getAttribute("orderid");
        session.setAttribute("ordernumber", id);
        User us = (User) session.getAttribute("user");
    %>


    <%=bf.getOrder(id).toString().replace("[", "").replace("]", "").replace(",", "<br>") + "<br>"%><br>
    
    
    <%if(!us.isAdmin(bf.getUserRole(us.getId())) && bf.getOrder(id).isOrderConfirmed()|| us.isAdmin(bf.getUserRole(us.getId()))) {
    out.println(bf.getFullItemlist(id).toString().replace("[", "").replace("]", "").replace(",", "<br>") + "<br>"); }%><br>
    
    <%out.println("Pris: " + bf.getOrderPrice(id));%>

    <% if (us.isAdmin(bf.getUserRole(us.getId())) && !bf.getOrder(id).isOrderConfirmed()) {%>
    <form action="FrontController" method="POST">
        <input type="hidden" name="command" value="sendorder">
        <input type="submit" name="ordernumber" value="Send ordre" />
    </form>
    <%}%>
    </center>
    <% if(us.isAdmin(bf.getUserRole(us.getId()))) { %>
            <a href="FrontController?command=adminpage">Tilbage</a><br><br>
            <% }%>
</body>
</html>
