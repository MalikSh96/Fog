<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>login</title>
</head>
    <body>
        <%@include file="../navigation/menu.jsp" %>

        <div class="loginpageimg">

            <img src="Image/login.jpg" class="loginpagesrc" />              
        </div>
        <table class="loginpagecenter">
            <tr>
                <td class="loginheading">
                    <h1>Login</h1>
                </td>
            </tr>

            <form name="login" action="FrontController" method="POST">
                <tr>
                    <td class="loginpagebulder">
                        <input type="hidden" name="command" value="login">
                        <%if (request.getAttribute("from") != null) {%>
                        <input type="hidden" name="from" value="<%=request.getAttribute("from")%>">                        
                        <p style="color: red;">Du mangler login eller opret dig som bruger.</p>
                        <% }%>
                </tr>
                <tr>
                    <td class="loginpagebulder">
                        Email:
                    </td>
                </tr>
                <tr>
                    <td class="loginbar">
                        <input type="text" name="email" value="" placeholder="Email" required>
                    </td>
                </tr>
                <tr>
                    <td class="loginpagebulder">
                        Password:<br>
                    </td>
                </tr>
                <tr>
                    <td class="loginbar">
                        <input type="password" name="password" value="" placeholder="Password" required>
                    </td>
                </tr>
                <tr>
                    <td class="loginheading">
                        <input type="submit" value="LOG IND">
                    </td>                
                </tr>
            </form>
            <tr>
                <td class="loginheading">
                    <br>

                    <a href="FrontController?command=registration">Opret bruger</a>

                </td>
            </tr>
            <tr>
                <td class="loginpagebulder">
                    <% String error = (String) request.getAttribute("error");
                        if (error != null) {%>
                    <H2>Fejl!!</h2>
                    <p><%= error%>
                        <% }
                        %>  
                </td>

            </tr>
        </table>





        <%@include file="../footer/footer.jsp" %>
    </body>
</html>
