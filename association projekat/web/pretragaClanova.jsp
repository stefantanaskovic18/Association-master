<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pretraga clanova</title>
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
                        <form action="PretraziClanove" method="post">
                            <h3>Unseite kriterijume pretrage</h3>
                            <input class="form-control" type="text" name="ime" placeholder="Ime"><br/>
                            <input class="form-control" type="text" name="prezime" placeholder="Prezime"><br/>
                            <input class="form-control" type="text" name="godinaUpisa" placeholder="Godina upisa"><br/>
                            <input class="form-control" type="text" name="odsek" placeholder="Odsek"><br/>
                            <input class="form-control" type="text" name="kompanija" placeholder="Kompanija"><br/>
                            
                            <button type="submit">Pretrazil</button><br/>
                        </form>
                    </div>
                </div>
                <div class="col-sm-2 sidenav">
                </div>
            </div>
        </div>
    </body>
</html>
