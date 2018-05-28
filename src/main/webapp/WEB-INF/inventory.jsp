<%@page import="datalayer.InventoryMapper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inventory</title>
        <link href="stylesheetnavigation.css" rel="stylesheet" type="text/css"/>
        <link href="stylesheet.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous"><link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    </head>
    <body>
        <%@include file="../navigation/menu.jsp" %>
    <center>
        <h1>Lagerstatus</h1>
        
            <%
        User usr = (User) session.getAttribute("user");
    %>

        <%=bf.completeInventory().toString().replace("[", "").replace("]", "").replace(",", "") + "<br>"%><br>

         <% if (usr.isAdmin(bf.getUserRole(usr.getId())) || bf.getUserRole(usr.getId()) == "storagechief") {%>
    
        <form action="FrontController" method="POST">
            <input type="hidden" name="command" value="updateinventorypage">
            <br><input type="number" name="choseninventoryid" placeholder="Vare id" required/>
            <br><br><input type="submit" value="Opdater lagerbeholdning" /><br>
        </form>
         

        <br><br> <a href="FrontController?command=addtoinventorypage">Tilføj til Lagerdatabase</a><br><br>
    <%}%>

    </center>

    <% if (usr.isAdmin(bf.getUserRole(usr.getId()))) {%>
     <a href="FrontController?command=adminpage">Tilbage</a><br><br>
    <%}%>

    <% if (bf.getUserRole(bf.getUserId(usr.getEmail())) == "storagechief") {%>
     <a href="FrontController?command=storagechiefpage">Tilbage</a><br><br>
    <%}%>

    <% if (bf.getUserRole(usr.getId()) == "storageworker") {%>
     <a href="FrontController?command=storageworkerpage">Tilbage</a><br><br>
    <%}%>


</body>
</html>
