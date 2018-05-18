<%@page import="dbaccess.ItemlistMapper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Stykliste</h1>
        
          <%
           int id = (int)session.getAttribute("orderid");
            ItemlistMapper ilm = new ItemlistMapper();
            %>
        
        
            <%=ilm.getFullItemlist(id).toString().replace("[","").replace("]","").replace(",","<br>")+"<br>"%><br>

        
    </body>
</html>
