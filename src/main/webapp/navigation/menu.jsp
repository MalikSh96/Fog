<header class="bannershow hidden-print">
    <nav>
        <div class="container-resposize-header">

<%@page import="businesslayer.BusinessFacade"%>
<%@page import="businesslayer.Constants"%>
<nav>
    <div class="container-resposize-header">
        <header>
            <%@page import="businesslayer.User"%>
            <%User user = (User) session.getAttribute("user");
            Constants con = new Constants();
            BusinessFacade bf = con.getBf();%>
            <div class="navwrapper">

                <div class="logo">
                    <img src="Image/logo.png" class="img-responsive">

                </div> 
                <div class="nav_rapper">
                    <div class="nav">

                        <div class="topnavgation">
                            <div class="container">
                                <div class="row">
                                    <div class="col-xs-12">
                                        <ul class="logintitems">
                                            <li class="topviews"><a href="index.jsp">Forside</a></li>
                                            <li class="topviews"><a href="FrontController?command=customorder">Bygselv Carport</a></li>


                                        </ul> 
                                    </div>

                                </div>
                            </div>
                        </div>
                        <div class="mainnavigation  ng-scope">
                            <div class="container">
                                <div class="row">
                                    <ul class="navigation">
                        <ul>
                            <% if (user != null && user.isAdmin(bf.getUserRole(user.getId()))) { %>
                            <li><a href="FrontController?command=adminpage">admin</a></li>
                                <% }%>
                            <% if (user != null && !user.isAdmin(bf.getUserRole(user.getId()))) { %>
                            <li><a href="FrontController?command=customerpage">Min Side</a></li>
                                <% }%>
                                <% if (user == null) { %>
                            <li>        <a href="FrontController?command=loginpage">Login</a></li>
                                <% } else { %>
                            <li> <a href="FrontController?command=logout">Logout</a></li>
                                <% }%>
                        </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </nav>
</header>
