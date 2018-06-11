<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>nuværende ordre</title>
 </head>
    <body>
        <%@include file="../navigation/menu.jsp" %>
    <center>
        <h1>Alle nuværende ordrer</h1>
        <%
            User userr = (User) session.getAttribute("user");
        %>


        <br><%= con.getBf().allCurrentOrders(con.getBf().getNonSentOrderId(),
                con.getBf().allCurrentOrderCustomerNames(con.getBf().getNonSentOrderCustomerIds()),
                con.getBf().allCurrentOrderCustomerLastnames(con.getBf().getNonSentOrderCustomerIds()),
                con.getBf().getNonSentOrderDates()).toString().replace("[", "").replace("]", "").replace(",", "") + "<br>"%>
    </center>
    <center>
        <% if (userr.isAdmin(con.getBf().getUserRole(userr.getId()))) {%>
        <a href="FrontController?command=adminpage">Tilbage</a><br><br>
        <%}%>

        <% if (con.getBf().getUserRole(con.getBf().getUserId(userr.getEmail())).equals("storagechief")) {%>
        <a href="FrontController?command=storagechiefpage">Tilbage</a><br><br>
        <%}%>

        <% if (con.getBf().getUserRole(con.getBf().getUserId(userr.getEmail())).equals("storageworker")) {%>
        <a href="FrontController?command=storageworkerpage">Tilbage</a><br><br>
        <%}%>
    </center>
</body>
</html>
