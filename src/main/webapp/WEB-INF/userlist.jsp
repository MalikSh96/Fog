<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Brugere</title>
 </head>
    <body>
        <%@include file="../navigation/menu.jsp" %>
    <center>

        <h1>Bruger liste</h1>
        <%
            User usrr = (User) session.getAttribute("user");
        %>  

        <%= con.getBf().allUsers(con.getBf().getAllUserIds(),
                con.getBf().getAllUserNames(),
                con.getBf().getAllUserLastnames()).toString().replace("[", "").replace("]", "").replace(",", "") + "<br>"%>


    </center> 
    <center>
        <% if (usrr.isAdmin(con.getBf().getUserRole(usrr.getId()))) {%>
        <a href="FrontController?command=adminpage">Tilbage</a><br><br>
        <%}%>

        <% if (con.getBf().getUserRole(con.getBf().getUserId(usrr.getEmail())).equals("seller")) {%>
        <a href="FrontController?command=sellerpage">Tilbage</a><br><br>
        <%}%>
    </center>
</body>
</html>
