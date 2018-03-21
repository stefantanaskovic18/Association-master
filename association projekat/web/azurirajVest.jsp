<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style/bootstrap-3.3.7-dist/css/bootstrap.css"/>
        <title>Azuriranje vesti</title>
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
                            <th>Naslov</th>
                            <th>Sadrzaj</th>
                            <th>Datum postavljanja</th>
                            <th>Slika</th>
                        </tr>
                        <c:forEach items="${listaVesti}" var="vest">
                            <tr>
                                <td>${vest.naslov}</td>
                                <td>${vest.sadrzaj}</td>
                                <td>${vest.datumPostavljanja}</td>
                                <td>${vest.slika}</td>
                                <td><a href="IzmeniVest?id=${vest.id_vesti}">Izmeni</a></td>
                                <td><a href="ObrisiVest?id=${vest.id_vesti}">Obrisi</a></td>
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
