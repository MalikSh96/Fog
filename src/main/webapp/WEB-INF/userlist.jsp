<%@page import="functionlayer.User"%>
<%@page import="java.util.List"%>
<%@page import="dbaccess.UserMapper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Brugere</title>
        <link href="stylesheetnavigation.css" rel="stylesheet" type="text/css"/>
        <link href="stylesheet.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
    <center>
        <%@include file="../navigation/menu.jsp" %>
        <h1>Bruger liste</h1>
        
        <% UserMapper um = new UserMapper();%>
        
        <%=um.getAllUsers().toString().replace("[","").replace("]","").replace(",","")+"<br>"%><br>
                        
                        
                        User ids:<br><br>
                        
                        <%for(int i = 0; i < um.getAllUserIds().size(); i++) {
                            //session.setAttribute("id", um.getAllUserIds().get(i));
                            out.println("<a href=\"FrontController?command=specificuser\">"+
                                    um.getAllUserIds().get(i).toString().replace("[","").replace("]","").replace(",","")+"</a><br><br>");
                        }%>
    </center>
                        <a href="FrontController?command=adminpage">Tilbage</a><br><br>
    </body>
</html>
