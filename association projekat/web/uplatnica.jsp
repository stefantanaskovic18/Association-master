<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Uplata</title>
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
                        <h3 style="color:red">${(porukaUplate!=null) ? porukaUplate : ""} </h3>
                         <h4>Trenutno stanje na vasem racunu: ${korisnik.racun}</h4>
                        <form action="Uplata" method="post">
                            <label>Uplatilac</label>
                            <textarea class="form-control" name="idKorisnika" cols="50" rows="5" readonly="true">${korisnik.ime},${korisnik.prezime}</textarea>
                            <label>Svrha uplate*</label>
                            <textarea class="form-control" name="svrha" cols="50" rows="5" placeholder="Svrha uplate*"></textarea>
                            <label>Primalac</label>
                            <textarea class="form-control" cols="50" rows="5" readonly="true">Udruzenje</textarea>
                            <label>Sifra placanja</label>
                            <input class="form-control" type="text" size="20">
                            <label>Valuta</label>
                            <input class="form-control" readonly="true" type="text" size="20" value="RSD">
                            <label>Iznos</label>
                            <input class="form-control" type="number" name="iznosUplate">
                            <label>Racun primaoca</label>
                            <input class="form-control" type="text">
                            <label>Broj modela</label>
                            <input class="form-control" type="number" value="05" readonly="true">
                            <label>Poziv na broj</label>
                            <input class="form-control" type="number" readonly="true" value="710103"><br/>
                            
                            <button type="submit" class="btn">Uplati</button>
                        </form>
                    </div>
                </div>
                <div class="col-sm-2 sidenav">
                </div>
            </div>
        </div>
    </body>
</html>
