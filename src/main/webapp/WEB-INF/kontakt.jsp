<%-- 
    Document   : Kontakt
    Created on : 25-05-2018, 15:03:23
    Author     : Jollys
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Kontakt</title>
        <link href="stylesheetnavigation.css" rel="stylesheet" type="text/css"/>
        <link href="stylesheet.css" rel="stylesheet" type="text/css"/>
        <link href="stylesheetfooter.css" rel="stylesheet" type="text/css"/>
        <link href="stylesheetjavascript.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous"><link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <link href="stylesheetfooter.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%@include file="../navigation/menu.jsp" %>
        <div class="container">
            <div class="row">
                <div class="col-md-2">
                </div>

                <div class="col-md-5">
                    <br/>
                    <h3>Du kan maile til info@johannesfog.dk.</h3>
                    <p>
                        Hvis du har konkrete spørgsmål omkring produkter eller andre henvendelser. Så videresendes din henvendelse til en relevant person til besvarelse og det overvåges, at der bliver besvaret.
                        Henvendelser besvares på hverdage og kan forventes besvaret inden for 3 hverdage.
                    </p>
                </div>
                <div class="col-md-1">
                </div>

                <div class="col-md-4">
                    <br/>
                    <h4>

                        Fog Værebro Trælast & Byggecenter
                    </h4>
                    <p><br/>
                        Lyshøjvej 14
                        <br/>
                        3650 Ølstykke
                    </p>
                    <p>    
                        <a href="tel:47179944">Tlf: 47 17 99 44</a><br/>
                        Fax: 47 17 58 06<br/>
                        <a href="mailto:info@johannesfog.dk?Subject=hej" target="_top">Mail: info@johannesfog.dk</a>
                    </p>
                </div>

            </div>
            <a href="https://www.google.com/maps/place/Lysh%C3%B8jvej+14,+3650+%C3%98lstykke,+Danmark/@55.7668585,12.1401728,942m/data=!3m1!1e3!4m5!3m4!1s0x46525d5b2d9ba981:0xaa9b36333d0fa720!8m2!3d55.767287!4d12.1425546?hl=da" target="_blank">
                <div class="kontaktdivphoto">
                    <img src="Image/FogMap.png" class="kontaktphoto"/>
                    <br/>
                    <br/>
                    <br/>
                </div>
            </a>
        </div>


        <%@include file="../footer/footer.jsp" %>
    </body>
</html>
