<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style/bootstrap-3.3.7-dist/css/bootstrap.css"/>
        <title>Lista korisnika</title>
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
                    <a class="navbar-brand" href="#">BLAGAJNIK</a>
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
                    <p><a href="blagajnik.jsp">Pocetna</a></p>
                    <p><a href="PregledUplataBlagajnik">Pregledaj sve uplate</a></p>
                    <p><a href="IzlistajKorisnike">Aktiviraj / Deaktiviraj korisnika</a></p>
                </div>
                <div class="col-sm-8 text-left"> 
                    <table class="table table-bordered">
                        <tr>
                            <th>Ime</th>
                            <th>Prezime</th>
                            <th>Korisnicko ime</th>
                            <th>Opcija</th>
                        </tr>
                        <c:forEach items="${listaKorisnikaBlagajnik}" var="korisnik">
                            <tr>
                                <td>${korisnik.ime}</td>
                                <td>${korisnik.prezime}</td>
                                <td>${korisnik.username}</td>

                                <c:choose>
                                    <c:when test="${korisnik.active == 0}">
                                        <td><a href="AktivirajKorisnika?id=${korisnik.idKorisnika}">AKTIVIRAJ</a></td>
                                    </c:when>
                                    <c:otherwise>
                                        <td><a href="DeaktivirajKorisnika?id=${korisnik.idKorisnika}">DEAKTIVIRAJ</a></td>
                                    </c:otherwise>
                                </c:choose>

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
