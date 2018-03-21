<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Uredjivanje profila</title>
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
                    <div class="col-xs-6">
                        <form action="PristupiIzmenamaProfila" method="post">
                            <label>Biografija: </label>
                            <textarea name="biografija" class="form-control" rows="5" cols="50">${korisnik.biografija}</textarea><br/>
                            <label>Trenutno zaposlenje</label>
                            <textarea name="zaposlenje" class="form-control" rows="5" cols="50">${korisnik.zaposlenje}</textarea><br/>
                            <label>Vestine: </label>
                            <textarea name="vestine" class="form-control" rows="5" cols="50">${korisnik.vestina}</textarea><br/>
                            <label>Strani jezici: </label><br/>
                            <select name="jezici" multiple>
                                <option value="3">Engleski</option>
                                <option value="4">Francuski</option>
                                <option value="5">Italijanski</option>
                                <option value="6">Spanski</option>
                                <option value="7">Nemacki</option>
                                <option value="8">Ruski</option>
                                <option value="9">Portugalski</option>
                            </select><br/>
                            <label>Nagrade: </label>
                            <textarea name="nagrade" class="form-control" rows="5" cols="50">${korisnik.nagrade}</textarea><br/>
                            <label>Sertifikati: </label>
                            <textarea name="sertifikati" class="form-control" rows="5" cols="50">${korisnik.sertifikati}</textarea><br/>
                            <label>Volonterski rad: </label>
                            <textarea name="volonterskiRad" class="form-control" rows="5" cols="50">${korisnik.volonterskiRad}</textarea><br/>
                            <label>Vidljivost profila: </label><br/>
                            <select name="vidljivost">
                                <option selected value="0">Javan</option>
                                <option value="1">Privatan</option>
                            </select>
                            <button type="submit">Izmeni profil</button><br/>
                        </form>
                    </div>
                </div>
                <div class="col-sm-2 sidenav">
                </div>
            </div>
        </div>
    </body>
</html>
