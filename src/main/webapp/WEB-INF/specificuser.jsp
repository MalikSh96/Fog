<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Specifik bruger side</title>
  </head>
    <body>
        <%@include file="../navigation/menu.jsp" %>
    <center>
        <%
            int id = (int) session.getAttribute("specificUserid");
            User bruger = con.getBf().getUser(id);
            User currentuser = (User) session.getAttribute("user");
            session.setAttribute("brugerID", id);
        %> 
        <h1>Brugerside for: <%= bruger.getName() + " " + bruger.getLastname()%></h1>

        Kunde nr: <%= con.getBf().getUserId(bruger.getEmail())%><br>
        Adresse:  <%= bruger.getAddress()%><br>
        Post nr: <%= bruger.getPostalcode()%><br>
        Telefon nr: <%= bruger.getPhone()%><br>
        Email: <%= bruger.getEmail()%><br><br>

        Brugerens ordrer:

        <br><%=con.getBf().allCustomerOrderIds(id).toString().replace("[", "").replace("]", "").replace(",", "") + "<br>"%><br>
    </center>
    <center>
        <% if (currentuser.isAdmin(con.getBf().getUserRole(currentuser.getId()))) {%>
        <a href="FrontController?command=adminpage">Tilbage</a><br><br>
        <%}%>

        <% if (con.getBf().getUserRole(con.getBf().getUserId(currentuser.getEmail())).equals("seller")) {%>
        <a href="FrontController?command=sellerpage">Tilbage</a><br><br>
        <%}%>
    </center>
</body>
</html>
