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

        <%
            User usr = (User) session.getAttribute("user");
        %>
        <%= con.getBf().fullInventory(con.getBf().getAllItemIds(), con.getBf().getAllItemNames(), con.getBf().getAllItemDesc(), con.getBf().getAllItemLength(), con.getBf().getAllItemUnit(), con.getBf().getAllItemStatus(), con.getBf().getAllItemPrice()).toString().replace("[", "").replace("]", "").replace(",", "") + "<br>"%>

        <% if (usr.isAdmin(con.getBf().getUserRole(usr.getId())) || con.getBf().getUserRole(con.getBf().getUserId(usr.getEmail())).equals("storagechief")) {%>

        <a href="FrontController?command=addtoinventorypage">Tilføj til Lagerdatabase</a><br><br>
        <%}%>

    </center>
    <center>
        <% if (usr.isAdmin(con.getBf().getUserRole(usr.getId()))) {%>
        <a href="FrontController?command=adminpage">Tilbage</a><br><br>
        <%}%>

        <% if (con.getBf().getUserRole(con.getBf().getUserId(usr.getEmail())).equals("storagechief")) {%>
        <a href="FrontController?command=storagechiefpage">Tilbage</a><br><br>
        <%}%>

        <% if (con.getBf().getUserRole(con.getBf().getUserId(usr.getEmail())).equals("storageworker")) {%>
        <a href="FrontController?command=storageworkerpage">Tilbage</a><br><br>
        <%}%>
    </center>

</body>
</html>
