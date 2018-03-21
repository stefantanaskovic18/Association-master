<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dodavanje korisnika</title>
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
                    <div class="col-xs-6">
                        <form action="DodavanjeKorisnika" method="post"> 
                            <input type="text" class="form-control" name="username" placeholder="Korisnicko ime"><br/>
                            <input type="text" class="form-control" name="password" placeholder="Sifra"><br/>
                            <input type="text" class="form-control" name="ime" placeholder="Ime"><br/>
                            <input type="text" class="form-control" name="prezime" placeholder="Prezime"><br/>
                            <input type="text" class="form-control" name="mestoRodjenja" placeholder="Mesto rodjenja"><br/>
                            <input type="text" class="form-control" name="drzavaRodjenja" placeholder="Drzava rodjenja"><br/>
                            <input type="text" class="form-control" name="jmbg" placeholder="JMBG"><br/>
                            <input type="text" class="form-control" name="brojTelefona" placeholder="Broj telefona"><br/>
                            <label>Pol: </label>
                            <input type="radio" value="m" name="pol" id="muskiPol"><label for id="muskiPol">Muski</label>
                            <input type="radio" value="z" name="pol" id="zenskiPol"><label for id="zenskiPol">Zenski</label>
                            <input type="text" class="form-control" name="email" placeholder="Email"><br/>
                            <input type="number" class="form-control" name="godinaUpisa" placeholder="Godina upisa"><br/>
                            <input type="number" class="form-control" name="godinaZavrsetka" placeholder="Godina zavrsetka"><br/>
                            <input type="text" class="form-control" name="odsek" placeholder="Odsek"><br/>
                            <!--<input type="text" class="form-control" name="zaposlenje" placeholder="Zaposlenje"><br/>
                            <textarea rows="4" cols="50" class="form-control" name="vestine" placeholder="Vestine"></textarea><br/>
                            <textarea rows="4" cols="50" class="form-control" name="biografija" placeholder="Biografija"></textarea><br/>
                            <textarea rows="4" cols="50" class="form-control" name="nagrade" placeholder="Nagrade"></textarea><br/>
                            <textarea rows="4" cols="50" class="form-control" name="sertifikati" placeholder="Sertifikati"></textarea><br/>
                            <label>Jezici koje govori clan</label><br/>
                            <select multiple>
                                <option value="3">Engleski</option>
                                <option value="4">Francuski</option>
                                <option value="5">Italijanski</option>
                                <option value="6">Spanski</option>
                                <option value="7">Nemacki</option>
                                <option value="8">Ruski</option>
                                <option value="8">Portugalski</option>
                            </select><br/><br/>
                            <textarea rows="4" cols="50" class="form-control" name="volonterskiRad" placeholder="Volonterski rad"></textarea><br/>-->

                            <button class="btn" type="submit">Dodaj korisnika</button>
                        </form>
                    </div>
                </div>
                <div class="col-sm-2 sidenav">
                </div>
            </div>
        </div>
    </body>
</html>
