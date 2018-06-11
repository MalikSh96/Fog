<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin side</title>
</head>
    <body>
    <center>
        
        <%@include file="../navigation/menu.jsp" %>     
        <%if (!user.isAdmin(con.getBf().getUserRole(user.getId()))) {
            response.sendRedirect("index.jsp");
        }%>
        <h1> Admin side </h1>

        <form name="employeepage" action="FrontController" method="POST">

            <br><br><a href="FrontController?command=allcurrentorders">Alle nuværende ordre</a><br><br>
            <a href="FrontController?command=allorders">Alle ordrer</a><br><br>
            <a href="FrontController?command=inventory">Lagerstatus</a><br><br>
            <a href="FrontController?command=userlist">Bruger liste</a><br><br>


        </form>

        <br>

    </center>
</body>
</html>
