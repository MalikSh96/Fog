<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="stylesheetnavigation.css" rel="stylesheet" type="text/css"/>
        <link href="stylesheet.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
                <%@include file="../navigation/menu.jsp" %>
    <center>
        <%
            int id = (int) session.getAttribute("specificUserid");
            User bruger = bf.getUser(id);
            session.setAttribute("brugerID", id);
        %>
        <h1>Brugerside for: <%= bruger.getName() + " " + bruger.getLastname()%></h1>

        Kunde nr: <%= bf.getUserId(bruger.getEmail())%><br>
        Adresse:  <%= bruger.getAddress()%><br>
        Post nr: <%= bruger.getPostalcode()%><br>
        Telefon nr: <%= bruger.getPhone()%><br>
        Email: <%= bruger.getEmail()%><br><br>

        Brugerens ordrer:

        <br><%=bf.allCustomerOrdersId(id).toString().replace("[", "").replace("]", "").replace(",", "").replace(" ", "<br>") + "<br>"%><br>

          <form action="FrontController" method="POST">
            <input type="hidden" name="command" value="specificOrder">
        <br><input type="number" name="chosenid" placeholder="Order ID"/>
        <input type="submit" value="Se ordre" /><br>
                </form>
    </center>
            <a href="FrontController?command=adminpage">Tilbage</a><br><br>
    </body>
</html>
