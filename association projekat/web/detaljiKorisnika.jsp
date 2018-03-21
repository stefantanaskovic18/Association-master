<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Detalji korisnika</title>
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
                    <a class="navbar-brand" href="#">ALUMNI CLAN</a>
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
                    <p><a href="alumni.jsp">Pocetna</a></p>
                    <p><a href="urediProfil.jsp">Uredjivanje profila</a></p>
                    <p><a href="pretragaClanova.jsp">Pretraga clanova</a></p>
                    <p><a href="uplatnica.jsp">Uplata</a></p>
                    <p><a href="PregledUplata">Pregled mojih uplata</a></p>

                </div>
                <div class="col-sm-8 text-left"> 
                    <table class="table table-bordered">
                        <tr>
                            <td>Ime</td>
                            <td>${izabraniKorisnik.ime}</td>
                        </tr>
                        <tr>
                            <td>Prezime</td>
                            <td>${izabraniKorisnik.prezime}</td>
                        </tr>
                        <tr>
                            <td>Pol</td>
                            <td>${izabraniKorisnik.pol}</td>
                        </tr>
                        <tr>
                            <td>Mesto rodjenja</td>
                            <td>${izabraniKorisnik.mestoRodjenja}</td>
                        </tr>
                        <tr>
                            <td>Drzava rodjenja</td>
                            <td>${izabraniKorisnik.drzavaRodjenja}</td>
                        </tr>
                        <tr>
                            <td>JMBG</td>
                            <td>${izabraniKorisnik.jmbg}</td>
                        </tr>
                        <tr>
                            <td>Broj telefona</td>
                            <td>${izabraniKorisnik.brojTelefona}</td>
                        </tr>
                        <tr>
                            <td>Email</td>
                            <td>${izabraniKorisnik.email}</td>
                        </tr>
                        <tr>
                            <td>Godina upisa</td>
                            <td>${izabraniKorisnik.godinaUpisa}</td>
                        </tr>
                        <tr>
                            <td>Godina zavrsetka</td>
                            <td>${izabraniKorisnik.godinaZavrsetka}</td>
                        </tr>
                        <tr>
                            <td>Odsek</td>
                            <td>${izabraniKorisnik.odsek}</td>
                        </tr>
                        <tr>
                            <td>Biografija</td>
                            <td>${izabraniKorisnik.biografija}</td>
                        </tr>
                        <tr>
                            <td>Zaposlenje</td>
                            <td>${izabraniKorisnik.zaposlenje}</td>
                        </tr>
                        <tr>
                            <td>Vestine</td>
                            <td>${izabraniKorisnik.vestina}</td>
                        </tr>
                        <tr>
                            <td>Nagrade</td>
                            <td>${izabraniKorisnik.nagrade}</td>
                        </tr>
                        <tr>
                            <td>Volonterski rad</td>
                            <td>${izabraniKorisnik.volonterskiRad}</td>
                        </tr>
                        <tr>
                            <td>Sertifikati</td>
                            <td>${izabraniKorisnik.sertifikati}</td>
                        </tr>
                        <tr>
                            <td>Strani jezici</td>
                            <td>
                                <c:forEach items="${jezici}" var="jezik">
                                    <p>${jezik.imeJezika}</p>
                                </c:forEach>
                            </td>
                        </tr>
                    </table>
                </div>
                <div class="col-sm-2 sidenav">
                </div>
            </div>
        </div>
    </body>
</html>
