<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lagerarbejderside</title>
</head>
    <center>
        <body>       
        <%@include file="../navigation/menu.jsp" %>
            <%
                User usrrs = (User) session.getAttribute("user");
            %>
            <%if (!con.getBf().getUserRole(con.getBf().getUserId(usrrs.getEmail())).equals("storageworker")) {
                response.sendRedirect("index.jsp");
            }%>

            <h1> Lagerarbejder side </h1>

            <form name="employeepage" action="FrontController" method="POST">

                <br><br><a href="FrontController?command=allcurrentorders">Alle nuværende ordre</a><br><br>
                <a href="FrontController?command=inventory">Lagerstatus</a><br><br>


            </form>

            <br>

    </center>
</body>
</html>
