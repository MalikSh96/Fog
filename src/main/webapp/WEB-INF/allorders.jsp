<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alle Ordre</title>
 </head>
    <body>
    <center>
        <%@include file="../navigation/menu.jsp" %>
        <h1>Alle ordrer</h1>

        <%= con.getBf().allOrders(con.getBf().getAllOrderIds(), con.getBf().allOrderCustomerNames(con.getBf().getOrderCustomerIds()), con.getBf().allOrderCustomerLastnames(con.getBf().getOrderCustomerIds()), con.getBf().getAllOrderDates()).toString().replace("[", "").replace("]", "").replace(",", "") + "<br>"%>

    </center>
    <center>
        <a href="FrontController?command=adminpage">Tilbage</a><br><br>
    </center>
</body>
</html>
