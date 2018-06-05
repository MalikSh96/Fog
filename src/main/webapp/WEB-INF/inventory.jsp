<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lager</title>
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
        <%= bf.fullInventory(bf.getAllItemIds(), bf.getAllItemNames(), bf.getAllItemDesc(), 
                bf.getAllItemLength(), bf.getAllItemUnit(), bf.getAllItemStatus(), bf.getAllItemPrice()).toString().replace("[", "").replace("]", "").replace(",", "") + "<br>"%>

        <% if (usr.isAdmin(bf.getUserRole(usr.getId())) || bf.getUserRole(bf.getUserId(usr.getEmail())).equals("storagechief")) {%>

        <a href="FrontController?command=addtoinventorypage">Tilføj til Lagerdatabase</a><br><br>
        <%}%>

    </center>
    <center>
        <% if (usr.isAdmin(bf.getUserRole(usr.getId()))) {%>
        <a href="FrontController?command=adminpage">Tilbage</a><br><br>
        <%}%>

        <% if (bf.getUserRole(bf.getUserId(usr.getEmail())).equals("storagechief")) {%>
        <a href="FrontController?command=storagechiefpage">Tilbage</a><br><br>
        <%}%>

        <% if (bf.getUserRole(bf.getUserId(usr.getEmail())).equals("storageworker")) {%>
        <a href="FrontController?command=storageworkerpage">Tilbage</a><br><br>
        <%}%>
    </center>

</body>
</html>
