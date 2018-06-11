<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sælger side</title>
 </head>
    <body>
    <center>
        <%@include file="../navigation/menu.jsp" %>
            <%
                User usrrs = (User) session.getAttribute("user");
            %>
            <%if (!con.getBf().getUserRole(con.getBf().getUserId(usrrs.getEmail())).equals("seller")) {
                response.sendRedirect("index.jsp");
            }%>
        <h1> Sælger side </h1>

        <form name="employeepage" action="FrontController" method="POST">

            <a href="FrontController?command=userlist">Bruger liste</a><br><br>


        </form>

        <br>

    </center>
</body>
</html>
