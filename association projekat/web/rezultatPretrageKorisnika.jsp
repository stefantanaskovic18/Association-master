<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nadjeni clanovi</title>
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
                            <th>Ime</th>
                            <th>Prezime</th>
                            <th>Email</th>
                            <th>Godina upisa</th>
                            <th>odsek</th>
                            <th>Kompanija</th>
                        </tr>
                        <c:forEach items="${nadjeni}" var="korisnik">
                            <tr>
                                <td>${korisnik.ime}</td>
                                <td>${korisnik.prezime}</td>
                                <td>${korisnik.email}</td>
                                <td>${korisnik.godinaUpisa}</td>
                                <td>${korisnik.odsek}</td>
                                <td>${korisnik.zaposlenje}</td>
                                <td><a href="PrikaziDetaljeKorisnika?id=${korisnik.idKorisnika}">Detalji</a></td>
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
