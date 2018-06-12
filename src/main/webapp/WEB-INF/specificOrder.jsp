<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Specifik Ordre sixe</title>
 </head>
    <body>
        <%@include file="../navigation/menu.jsp" %>
        
        <div class="container">
            <div class="row justify-content-center">


                <div class="col-xs-4 col-centered">
                    <h1>Order nr: </h1>
                    <%
                        int id = (int) session.getAttribute("orderid");
                        session.setAttribute("ordernumber", id);
                    %>

                    <%if (user.isAdmin(con.getBf().getUserRole(user.getId()))) {%>
                    <%=con.getBf().getAllUserInfo(con.getBf().getUserIdFromOrderId(id)).toString().replace("[", "").replace("]", "").replace(",", "<br>") + "<br>"%><br>
                    <%}%>

                    <%=con.getBf().getOrder(id).toString().replace("[", "").replace("]", "").replace(",", "<br>") + "<br>"%><br>


                    <%if (!user.isAdmin(con.getBf().getUserRole(user.getId())) && con.getBf().getOrder(id).isOrderConfirmed() || user.isAdmin(con.getBf().getUserRole(user.getId())) || con.getBf().getUserRole(con.getBf().getUserId(user.getEmail())).equals("storageworker")
                                || con.getBf().getUserRole(con.getBf().getUserId(user.getEmail())).equals("storagechief") || con.getBf().getUserRole(con.getBf().getUserId(user.getEmail())).equals("seller")) {
                            out.println(con.getBf().getFullItemlist(id).toString().replace("[", "").replace("]", "").replace(",", "<br>") + "<br>");
                        }%><br>


                    <%out.println("Pris: " + con.getBf().getOrderPrice(id));%>
                </div>
            </div>
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-xs-4 col-centered">
                        <% if (user.isAdmin(con.getBf().getUserRole(user.getId())) && !con.getBf().getOrder(id).isOrderConfirmed() || con.getBf().getUserRole(con.getBf().getUserId(user.getEmail())).equals("storagechief") && !con.getBf().getOrder(id).isOrderConfirmed()) {%>
                        <form action="FrontController" method="POST">
                            <input type="hidden" name="command" value="sendorder">
                            <input type="submit" name="ordernumber" value="Send ordre" />
                        </form>
                    </div>
                    <div class="col-xs-4 col-centered">
                        <form action="FrontController" method="POST">
                            <input type="hidden" name="command" value="deleteorder">
                            <input type="submit" name="ordernumber" value="Delete" />
                        </form>
                <%}%>
                    </div>
                </div>
            </div> 
            <div class="center-text">
                <br/>
                <% if (user.isAdmin(con.getBf().getUserRole(user.getId()))) {%>
                <a href="FrontController?command=adminpage">Tilbage</a><br><br>
                <%}%>

                <% if (con.getBf().getUserRole(con.getBf().getUserId(user.getEmail())).equals("storagechief")) {%>
                <a href="FrontController?command=storagechiefpage">Tilbage</a><br><br>
                <%}%>

                <% if (con.getBf().getUserRole(con.getBf().getUserId(user.getEmail())).equals("storageworker")) {%>
                <a href="FrontController?command=storageworkerpage">Tilbage</a><br><br>
                <%}%>

                <% if (con.getBf().getUserRole(con.getBf().getUserId(user.getEmail())).equals("seller")) {%>
                <a href="FrontController?command=sellerpage">Tilbage</a><br><br>
                <%}%>
            </div>

    </body>
</html>
