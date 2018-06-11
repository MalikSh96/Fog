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
            <div class="row">
                <div class="col-md-4">

                </div>

                <div class="center-text">
                    <h1>Order nr: </h1>
                    <%
                        int id = (int) session.getAttribute("orderid");
                        session.setAttribute("ordernumber", id);
                        User us = (User) session.getAttribute("user");
                    %>

                    <%if (us.isAdmin(con.getBf().getUserRole(us.getId()))) {%>
                    <%=con.getBf().getAllUserInfo(con.getBf().getUserIdFromOrderId(id)).toString().replace("[", "").replace("]", "").replace(",", "<br>") + "<br>"%><br>
                    <%}%>

                    <%=con.getBf().getOrder(id).toString().replace("[", "").replace("]", "").replace(",", "<br>") + "<br>"%><br>


                    <%if (!us.isAdmin(con.getBf().getUserRole(us.getId())) && con.getBf().getOrder(id).isOrderConfirmed() || us.isAdmin(con.getBf().getUserRole(us.getId())) || con.getBf().getUserRole(con.getBf().getUserId(us.getEmail())).equals("storageworker") || con.getBf().getUserRole(con.getBf().getUserId(us.getEmail())).equals("storagechief") || con.getBf().getUserRole(con.getBf().getUserId(us.getEmail())).equals("seller")) {
                            out.println(con.getBf().getFullItemlist(id).toString().replace("[", "").replace("]", "").replace(",", "<br>") + "<br>");
                        }%><br>

                    <%out.println("Pris: " + con.getBf().getOrderPrice(id));%>

                    <% if (us.isAdmin(con.getBf().getUserRole(us.getId())) && !con.getBf().getOrder(id).isOrderConfirmed() || con.getBf().getUserRole(con.getBf().getUserId(us.getEmail())).equals("storagechief") && !con.getBf().getOrder(id).isOrderConfirmed()) {%>
                    <form action="FrontController" method="POST">
                        <input type="hidden" name="command" value="sendorder">
                        <input type="submit" name="ordernumber" value="Send ordre" />
                    </form>
                    <%}%>
                    <br><br>

                    <% if (us.isAdmin(con.getBf().getUserRole(us.getId()))) {%>
                    <a href="FrontController?command=adminpage">Tilbage</a><br><br>
                    <%}%>

                    <% if (con.getBf().getUserRole(con.getBf().getUserId(us.getEmail())).equals("storagechief")) {%>
                    <a href="FrontController?command=storagechiefpage">Tilbage</a><br><br>
                    <%}%>

                    <% if (con.getBf().getUserRole(con.getBf().getUserId(us.getEmail())).equals("storageworker")) {%>
                    <a href="FrontController?command=storageworkerpage">Tilbage</a><br><br>
                    <%}%>

                    <% if (con.getBf().getUserRole(con.getBf().getUserId(us.getEmail())).equals("seller")) {%>
                    <a href="FrontController?command=sellerpage">Tilbage</a><br><br>
                    <%}%>
                </div>
            </div>
        </div>
    </body>
</html>
