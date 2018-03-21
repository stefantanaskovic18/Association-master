<%-- 
    Document   : dodajVest
    Created on : Aug 24, 2017, 1:45:48 PM
    Author     : djordje
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dodaj vest</title>
        <link rel="stylesheet" href="style/bootstrap-3.3.7-dist/css/bootstrap.css"/>
    </head>
    <body>
        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>                        
                    </button>
                    <a class="navbar-brand" href="#">ADMINISTRATOR</a>
                </div>
                <div class="collapse navbar-collapse" id="myNavbar">
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="Logout"><span class="glyphicon glyphicon-log-in"></span>Odjavi se</a></li>
                    </ul>
                </div>
            </div>
        </nav>

        <div class="container-fluid text-center">
            <div class="row-content">
                <div class="col-sm-2 sidenav">
                    <p><a href="admin.jsp">Pocetna</a></p>
                    <p><a href="dodajVest.jsp">Dodaj vest</a></p>
                    <p><a href="IzlistajSveVesti">Azuriraj vest</a></p>
                    <p><a href="IzmeniKontakt">Izmeni kontakt stranicu</a></p>
                    <p><a href="dodavanjeDogadjaja.jsp">Dodaj dogadjaj</a></p>
                    <p><a href="IzlistajSveDogadjaje">Azuriraj dogadjaj</a></p>
                    <p><a href="IzlistajAktivne">Aktivni alumni clanovi</a></p>
                    <p><a href="IzlistajNeaktivne">Neaktivni alumni clanovi</a></p>
                    <p><a href="dodajKorisnika.jsp">Dodaj novog korisnika</a></p>
                </div>
                <div class="col-sm-8 text-left"> 
                    <form action="DodavanjeVesti" method="post">
                        <div class="col-xs-4">
                            <label for="naslov">Naslov vesti:</label>
                            <input type="text" class="form-control" id="naslov" name="naslovVesti">
                            
                            <label for="sadrzajVesti">Sadrzaj vesti:</label>
                            <textarea cols="40" rows="5" id="sadrzajVesti" name="sadrzaj"></textarea>
                            <button type="submit" class="btn">Dodaj novu vest</button><br/>
                            <h3>${(porukaZaVest!=null) ? porukaZaVest : ""} </h3><br/>
                        </div>
                       
                    </form>
                </div>
                <div class="col-sm-2 sidenav">
                </div>
            </div>
        </div>
    </body>
</html>
