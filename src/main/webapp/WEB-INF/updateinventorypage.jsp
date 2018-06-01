<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lageropdatering</title>
        <link href="stylesheetnavigation.css" rel="stylesheet" type="text/css"/>
        <link href="stylesheet.css" rel="stylesheet" type="text/css"/>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous"><link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    </head>
    <body>
        <%@include file="../navigation/menu.jsp" %>
    <center>
        <h1>Opdater Lager</h1>

        <%
            User brugere = (User) session.getAttribute("user");
            int itemid = (int) session.getAttribute("inventoryid");
        %> <%if(bf.getUserRole(bf.getUserId(brugere.getEmail())).equals("storageworker")) {
            response.sendRedirect("index.jsp"); }%>
        <%=bf.getSpecificItem(itemid)%><br><br>
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
    <% if (brugere.isAdmin(bf.getUserRole(brugere.getId()))) {%>
    <a href="FrontController?command=adminpage">Tilbage</a><br><br>
    <%}%>

    <% if (bf.getUserRole(bf.getUserId(brugere.getEmail())).equals("storagechief")) {%>
    <a href="FrontController?command=storagechiefpage">Tilbage</a><br><br>
    <%}%>
</body>
</html>
