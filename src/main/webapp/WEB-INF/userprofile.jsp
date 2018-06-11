<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Profile</title>
 </head>
    <body>

        <%@include file="../navigation/menu.jsp" %>
        <%
            int id = (int) session.getAttribute("id");
        %>
    <center>
        <br><h1>Dine informationer:</h1><br><br>       

        Kunde nr: <%= con.getBf().getUserId(user.getEmail())%><br>
        Navn: <%= user.getName() + " " + user.getLastname()%><br>
        Adresse:  <%= user.getAddress()%><br>
        Post nr: <%= user.getPostalcode()%><br>
        Telefon nr: <%= user.getPhone()%><br>
        Email: <%= user.getEmail()%><br><br>   
        <%if (!user.isAdmin(con.getBf().getUserRole(id))) {%>
        <a href="FrontController?command=updateinfopage">Opdater personlige informationer</a>
        <%}%>
    </center>

    <%if (user.isAdmin(con.getBf().getUserRole(id))) {%>
    <a href="FrontController?command=adminpage">Tilbage</a><br><br>
    <%}%>

    <%@include file="../footer/footer.jsp" %>

</body>
</html>
