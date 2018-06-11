<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lager</title>
 </head>
    <body>
        <%@include file="../navigation/menu.jsp" %>
    <center>
        <h1>Lagerstatus</h1>

        <%= con.getBf().fullInventory(con.getBf().getAllItemIds(), con.getBf().getAllItemNames(), con.getBf().getAllItemDesc(), con.getBf().getAllItemLength(), con.getBf().getAllItemUnit(), con.getBf().getAllItemStatus(), con.getBf().getAllItemPrice()).toString().replace("[", "").replace("]", "").replace(",", "") + "<br>"%>

        <% if (user.isAdmin(con.getBf().getUserRole(user.getId())) || con.getBf().getUserRole(con.getBf().getUserId(user.getEmail())).equals("storagechief")) {%>

        <a href="FrontController?command=addtoinventorypage">Tilføj til Lagerdatabase</a><br><br>
        <%}%>

    </center>
    <center>
        <% if (user.isAdmin(con.getBf().getUserRole(user.getId()))) {%>
        <a href="FrontController?command=adminpage">Tilbage</a><br><br>
        <%}%>

        <% if (con.getBf().getUserRole(con.getBf().getUserId(user.getEmail())).equals("storagechief")) {%>
        <a href="FrontController?command=storagechiefpage">Tilbage</a><br><br>
        <%}%>

        <% if (con.getBf().getUserRole(con.getBf().getUserId(user.getEmail())).equals("storageworker")) {%>
        <a href="FrontController?command=storageworkerpage">Tilbage</a><br><br>
        <%}%>
    </center>

</body>
</html>
