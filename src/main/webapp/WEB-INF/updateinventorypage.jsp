<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lageropdatering</title>
  </head>
    <body>
        <%@include file="../navigation/menu.jsp" %>
    <center>
        <h1>Opdater Lager</h1>

        <%
            int itemid = (int) session.getAttribute("inventoryid");
        %> <%if(con.getBf().getUserRole(con.getBf().getUserId(user.getEmail())).equals("storageworker")) {
            response.sendRedirect("index.jsp"); }%>
        <%=con.getBf().getSpecificItem(itemid)%><br><br>
        <form action="FrontController" method="POST">
            <input type="hidden" name="command" value="updateinventory">
            <div>
                <label> Navn</label><br><input type="text" name="name" placeholder="Navn"/><br>
            </div>            
            <div>
                <label> Beskrivelse</label><br><input type="text" name="desc" placeholder="Beskrivelse"/><br>
            </div>            
            <div>
                <label> Længde</label><br><input type="number" name="length" placeholder="Længde"/><br>
            </div>            
            <div>
                <label> Enhed</label><br><input type="text" name="unit" placeholder="Enhed"/><br>
            </div>                               
            <div>
                <label> Status</label><br><input type="number" name="status" placeholder="Status"/><br>
            </div>                 
            <div>
                <label> Pris</label><br><input type="number" name="price" placeholder="Pris"/><br>
            </div>                 
            <br> <input type="submit" value="Opdater lagerbeholdning"><br>
        </form>
    </center>    
    <% if (user.isAdmin(con.getBf().getUserRole(user.getId()))) {%>
    <a href="FrontController?command=adminpage">Tilbage</a><br><br>
    <%}%>

    <% if (con.getBf().getUserRole(con.getBf().getUserId(user.getEmail())).equals("storagechief")) {%>
    <a href="FrontController?command=storagechiefpage">Tilbage</a><br><br>
    <%}%>
</body>
</html>
