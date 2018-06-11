<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Brugerside</title>
</head>
    <body>

        <%@include file="../navigation/menu.jsp" %>
        <%
            int id = (int) session.getAttribute("id");
        %>



        <div class="center-text">
            <div class="customerpageoverskrift">
                <h1>
                    Velkommen <%= user.getName()%>. 
                </h1>
            </div>
        </div>
        <div class="container">
            <div class="row">
               
                <div class="col-sm-4">
                    <p>Tryk på ”Min Profil” og se dine personlige informationer.</p>
                    <p>Under ”Ordrehistorik” kan du se din ordre samt tidligere ordre.</p>

                </div>

                <div class="col-sm-4">
                    <ul class="list-group">
                        <li class="list-group-item">
                            <a href="FrontController?command=userprofile">Min Profil</a>
                        </li>
                        <li class="list-group-item">
                            <a href="FrontController?command=myorders">Ordrehistorik</a>
                        </li>
                    </ul>
                </div>

                <div  class="customerpagepicture">
                    <img src="Image/flattag.png"/>
                </div>
            </div>
        </div>
                
                        
                   
        <%@include file="../footer/footer.jsp" %>
    </body>
</html>


