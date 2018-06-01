<%@page import="businesslayer.BusinessFacade"%>
<%@page import="businesslayer.Constants"%> 

<%@page import="businesslayer.User"%>
<%User user = (User) session.getAttribute("user");
    Constants con = new Constants();
    BusinessFacade bf = con.getBf();%>

<header class="container-resposize-header">
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="navwrapper">
            <div class="nav">
                <div class="logo">
                    <img src="Image/logo.png" class="img-responsive">

                </div>

                <div class="bar navbar">
                    <div class="container">
                        <div class="row">
                            <div>
                                <ul class="navbar-nav">
                                    <li class="topsviews" ><a href="index.jsp">Forside</a>
                                    </li>
                                    <li class="topsviews" ><a href="FrontController?command=customorder">Bygselv Carport</a>
                                    </li>
                                    <% if (user != null && user.isAdmin(bf.getUserRole(user.getId()))) { %>
                                    <li class="topsviews"><a href="FrontController?command=adminpage">Admin</a>
                                    </li>
                                    <% }%> 
                                    <% if (user != null && bf.getUserRole(bf.getUserId(user.getEmail())).equals("storagechief")) { %>
                                    <li class="topsviews"><a href="FrontController?command=storagechiefpage">Storage chief</a>
                                    </li>
                                    <% }%>
                                    <% if (user != null && bf.getUserRole(bf.getUserId(user.getEmail())).equals("storageworker")) { %>
                                    <li class="topsviews"><a href="FrontController?command=storageworkerpage">Storage worker</a>
                                    </li>
                                    <% }%>
                                    <% if (user != null && bf.getUserRole(bf.getUserId(user.getEmail())).equals("seller")) { %>
                                    <li class="topsviews"><a href="FrontController?command=sellerpage">Seller</a>
                                    </li>
                                    <% }%>
                                    <% if (user != null && !user.isAdmin(bf.getUserRole(user.getId())) && !bf.getUserRole(bf.getUserId(user.getEmail())).equals("seller") && !bf.getUserRole(bf.getUserId(user.getEmail())).equals("storageworker") && !bf.getUserRole(bf.getUserId(user.getEmail())).equals("storagechief")) { %>
                                    <li class="topsviews"><a href="FrontController?command=customerpage">Min Side</a>
                                    </li>
                                    <% }%>                                        
                                    <% if (user == null) { %>
                                    <li class="topsviews" ><a href="FrontController?command=loginpage">Login</a>
                                    </li>
                                    <% }  %>
                                    <li class="topsviews" > <a href="FrontController?command=kontakt">Kontakt</a>
                                    </li>

                                    <% if (user != null) { %>
                                    <li class="topsviews" > <a href="FrontController?command=logout">Logout</a>
                                    </li>
                                    <% }%>
                                </ul> 

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </nav>
</header>