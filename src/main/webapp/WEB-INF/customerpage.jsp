<%@page import="dbaccess.UserMapper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer home page</title>
        <link href="stylesheetnavigation.css" rel="stylesheet" type="text/css"/>
        <link href="stylesheet.css" rel="stylesheet" type="text/css"/>
        <link href="stylesheetfooter.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>

        <%@include file="../navigation/menu.jsp" %>
        <%
            int id = (int) session.getAttribute("id");
            UserMapper um = new UserMapper();
            User us = um.getUser(id);
        %>


        <br/>
        <div class="customerpage">
            <div class="customerpageoverskrift">
                
                    <h3>
                        Logget ind som: <%= us.getName()%> 
                    </h3>
                
            </div>
            <div class="customerpageinfomationer"> 
                <h3>Dine informationer:</h3> <br/>
                <div class="cusomerpagetextinformationer">
                    <%= us.getName()%><br/>
                    <%= us.getAddress()%><br/>
                    <%= us.getPostalcode()%><br/>
                    <%= us.getPhone()%><br/>
                    <%= us.getEmail()%><br/>   
                    </div>
            </div>
            <div class="customerpagepicture">
                <img src="Image/flattag.png" class="customerpagesrc"/>             
            </div>
            <div class="customerpageahref">
                <a href="FrontController?command=customorder">Skræddersy Ordre</a><br><br>
                <a href="FrontController?command=myorders">Ordrehistorik</a><br><br>
                <a href="FrontController?command=updateinfopage">Opdater personlige informationer</a>
            </div>
        </div>
                    <%@include file="../footer/footer.jsp" %>
    </body>
</html>
