<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tilføj til Lager</title>
</head>
    <body>      
        <%@include file="../navigation/menu.jsp" %>
            
    <center>
        <h1>Tilføj til lager</h1>
      <%
        User brugeren = (User) session.getAttribute("user");
    %>
<form action="FrontController" method="POST">
            <input type="hidden" name="command" value="addtoinventory">
            <div>
                <label> Navn</label><br><input type="text" name="name" placeholder="Navn" required/><br>
            </div>            
            <div>
                <label> Beskrivelse</label><br><input type="text" name="description" placeholder="Beskrivelse" required/><br>
            </div>            
            <div>
                <label> Længde</label><br><input type="number" name="length" placeholder="Længde" required/><br>
            </div>            
            <div>
                <label> Enhed</label><br><input type="text" name="unit" placeholder="Enhed" required/><br>
            </div>                               
            <div>
                <label> Status</label><br><input type="number" name="status" placeholder="Status" required/><br>
            </div>                 
            <div>
                <label> Pris</label><br><input type="number" name="price" placeholder="Pris" required/><br>
            </div>                 
            <br> <input type="submit" value="Tilføj til Lageret"><br>
            </form>
        </center>
    
    <% if (brugeren.isAdmin(con.getBf().getUserRole(brugeren.getId()))) {%>
     <a href="FrontController?command=adminpage">Tilbage</a><br><br>
    <%}%>

    <% if (con.getBf().getUserRole(con.getBf().getUserId(brugeren.getEmail())).equals("storagechief")) {%>
     <a href="FrontController?command=storagechiefpage">Tilbage</a><br><br>
    <%}%>

    </body>
</html>
