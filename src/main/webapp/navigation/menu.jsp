<%@page import="businesslayer.Constants"%> 
<%@page import="businesslayer.User"%>
<%User user = (User) session.getAttribute("user");
    Constants con = new Constants();%>
        <link href="stylesheetnavigation.css" rel="stylesheet" type="text/css"/>
        <link href="stylesheet.css" rel="stylesheet" type="text/css"/>
        <link href="stylesheetfooter.css" rel="stylesheet" type="text/css"/>
        <link href="stylesheetjavascript.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous"><link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <link href="stylesheetfooter.css" rel="stylesheet" type="text/css"/>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

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
                                    <% if (user != null && user.isAdmin(con.getBf().getUserRole(user.getId()))) { %>
                                    <li class="topsviews"><a href="FrontController?command=adminpage">Admin</a>
                                    </li>
                                    <% }%> 
                                    <% if (user != null && con.getBf().getUserRole(con.getBf().getUserId(user.getEmail())).equals("storagechief")) { %>
                                    <li class="topsviews"><a href="FrontController?command=storagechiefpage">Storage chief</a>
                                    </li>
                                    <% }%>
                                    <% if (user != null && con.getBf().getUserRole(con.getBf().getUserId(user.getEmail())).equals("storageworker")) { %>
                                    <li class="topsviews"><a href="FrontController?command=storageworkerpage">Storage worker</a>
                                    </li>
                                    <% }%>
                                    <% if (user != null && con.getBf().getUserRole(con.getBf().getUserId(user.getEmail())).equals("seller")) { %>
                                    <li class="topsviews"><a href="FrontController?command=sellerpage">Seller</a>
                                    </li>
                                    <% }%>
                                    <% if (user != null && !user.isAdmin(con.getBf().getUserRole(user.getId())) && !con.getBf().getUserRole(con.getBf().getUserId(user.getEmail())).equals("seller") && !con.getBf().getUserRole(con.getBf().getUserId(user.getEmail())).equals("storageworker") && !con.getBf().getUserRole(con.getBf().getUserId(user.getEmail())).equals("storagechief")) { %>
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