<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style/bootstrap-3.3.7-dist/css/bootstrap.css"/>
        <title>Aktivni alumni</title>
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
                    <table class="table table-bordered">
                        <tr>
                            <th>Korisnicko ime</th>
                            <th>Ime</th>
                            <th>Prezime</th>
                            <th>Pol</th>
                            <th>Mesto rodjenja</th>
                            <th>Drzava rodjenja</th>
                            <th>JMBG</th>
                            <th>Broj telefona</th>
                            <th>Email</th>
                            <th>Godina upisa</th>
                            <th>Godina zavrsetka</th>
                            <th>Aktivan</th>
                        </tr>
                        <c:forEach items="${listaAktivnih}" var="korisnik">
                            <tr>
                                <td>${korisnik.username}</td>
                                <td>${korisnik.ime}</td>
                                <td>${korisnik.prezime}</td>
                                <td>${korisnik.pol}</td>
                                <td>${korisnik.mestoRodjenja}</td>
                                <td>${korisnik.drzavaRodjenja}</td>
                                <td>${korisnik.jmbg}</td>
                                <td>${korisnik.brojTelefona}</td>
                                <td>${korisnik.email}</td>
                                <td>${korisnik.godinaUpisa}</td>
                                <td>${korisnik.godinaZavrsetka}</td>
                                <td>${(korisnik.active == 1) ?  'da':'ne'}</td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
                <div class="col-sm-2 sidenav">
                </div>
            </div>
        </div>
    </body>
</html>
