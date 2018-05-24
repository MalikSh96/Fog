<%@page import="businesslayer.BusinessFacade"%>
<%@page import="businesslayer.Constants"%>
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
           Constants con = new Constants();
           BusinessFacade bf = con.getBf();
            %>
        
        
            <%=bf.getFullItemlist(id).toString().replace("[","").replace("]","").replace(",","<br>")+"<br>"%><br>

        
    </body>
</html>
