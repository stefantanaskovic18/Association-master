<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Izmena dogadjaja</title>
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
                    <form action="PristupiIzmenamaDogadjaja" method="post">
                        <label for id="id">ID: </label>
                        <input class="form-control" type="text" name="idDogadjaja" id="id" value="${dogadjaj.id_dogadjaja}" readonly="true">
                        
                        <label for id="naslov">Naslov: </label>
                        <input class="form-control" type="text" name="novNaslov" id="naslov" value="${dogadjaj.naslov}">
                        
                        <label for id="sadrzaj">Sadrzaj: </label>
                        <textarea class="form-control" cols="40" rows="5" id="sadrzaj" name="novSadrzaj">${dogadjaj.sadrzaj}</textarea>
                        
                        <label for id="datumOdrzavanja">Vreme odrzavanja</label>
                        <input name="novDatum" type="date" class="form-control" id="datumOdrzavanja" value="${dogadjaj.datumOdrzavanja}">
                        
                        <label for id="mesto">Mesto</label>
                        <input type="text" name="novoMesto" class="form-control" value="${dogadjaj.mesto}">
                        
                        <br/>
                        <button type="submit" class="btn">Izmeni dogadjaj</button>
                    </form>
                </div>
                <div class="col-sm-2 sidenav">
                </div>
            </div>
        </div>
    </body>
</html>
