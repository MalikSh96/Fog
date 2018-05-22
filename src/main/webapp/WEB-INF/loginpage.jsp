<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>login</title>
        <link href="stylesheetnavigation.css" rel="stylesheet" type="text/css"/>
        <link href="stylesheet.css" rel="stylesheet" type="text/css"/>
        <link href="stylesheetfooter.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous"><link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    </head>
    <body>
        <%@include file="../navigation/menu.jsp" %>
        <table class="loginpagecenter">
            <tr>
                <td>
                    <h1>Login</h1>
                </td>
            </tr>

            <tr>
                <td>
                    <form name="login" action="FrontController" method="POST">
                        <input type="hidden" name="command" value="login">
                        Email:<br>
                        <input type="text" name="email" value="" placeholder="Email">
                        <br>
                        Password:<br>
                        <input type="password" name="password" value="" placeholder="Password">
                        <br>
                        <br>  <input type="submit" value="LOG IND">
                    </form>
                </td>                
            </tr>
            <tr>
                <td>
                    <br>

                    <a href="FrontController?command=registration">Opret bruger</a>
                    
                </td>
            </tr>
            <tr>
                <td>
                    <% String error = (String) request.getAttribute("error");
                if (error != null) {%>
                    <H2>Fejl!!</h2>
                    <p><%= error%>
                        <% }
                        %>  
                </td>

            </tr>
        </table>
                <div class="loginpageimg">
                   
                    <img src="Image/login.jpg" class="loginpagesrc" />              
                </div>
                
                
                <%@include file="../footer/footer.jsp" %>
    </body>
</html>
