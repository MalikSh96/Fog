<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mine Ordre</title>
 </head>
    <body>
        <%@include file="../navigation/menu.jsp" %>
    <center>
        <h1>Dine Ordrer</h1>
        <br/>
        <%= con.getBf().combineUserOrderDatesWithId(con.getBf().getAllUserOrderDates(user.getId()),
                con.getBf().allCustomerOrdersId(user.getId())).toString().replace("[", "").replace("]", "").replace(",", "") + "<br>"%>


    </center>
</body>
</html>
