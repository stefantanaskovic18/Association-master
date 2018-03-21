<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style/bootstrap-3.3.7-dist/css/bootstrap.css"/>
        <title>Pocetna - Alumni</title>
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
                    <c:choose>
                        <c:when test="${korisnik.active == 0}">
                            <h2 style="color:red">Vas nalog je deaktiviran. Molimo vas uplatite clanarinu.</h2>
                        </c:when>
                        <c:otherwise>
                            
                        </c:otherwise>
                    </c:choose>
                    <h1>Hello, vasi podaci:</h1>
                    <p>Ime: ${korisnik.ime}</p>
                    <p>Prezime: ${korisnik.prezime}</p>
                    <p>Pol: ${korisnik.pol}</p>
                    <p>Mesto rodjenja: ${korisnik.mestoRodjenja}</p>
                    <p>Drzava rodjenja: ${korisnik.drzavaRodjenja}</p>
                    <p>JMBG: ${korisnik.jmbg}</p>
                    <p>Broj telefona: ${korisnik.brojTelefona}</p>
                    <p>Email: ${korisnik.email}</p>
                    <p>Biografija: ${korisnik.biografija}</p>
                    <p>Vidljivost: ${korisnik.privatanNalog}</p>
                </div>
                <div class="col-sm-2 sidenav">
                </div>
            </div>
        </div>

    </body>
</html>
