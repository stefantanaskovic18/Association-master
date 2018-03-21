<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registracija</title>
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
                    <a class="navbar-brand" href="#">Logo</a>
                </div>
                <div class="collapse navbar-collapse" id="myNavbar">
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="index.jsp">Pocetna - Login</a></li>
                        <li><a href="PrikaziVesti">Vesti</a></li>
                        <li><a href="PrikaziSveDogadjaje">Dogadjaji</a></li>
                        <li><a href="PrikaziClanovePocetna">Clanovi udruzenja</a></li>
                        <li><a href="PrikaziKontakt">Kontakt</a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="registracija.jsp"><span class="glyphicon glyphicon-log-in"></span>Registracija</a></li>
                    </ul>
                </div>
            </div>
        </nav>

        <div class="container-fluid text-center">
            <div class="row-content">
                <div class="col-sm-2 sidenav">

                </div>
                <div class="col-sm-8 text-left"> 
                    <form name="formRegistracija" action="Registracija" method="post" id="regForm">
                         <h3>${(porukaRegistracije!=null) ? porukaRegistracije : ""} </h3>
                        <input type="text" class="form-control" id="korisnicko" name="username" placeholder="Korisnicko ime"><br/>
                        <input type="text" class="form-control" id="sifra" name="password" placeholder="Sifra"><br/>
                        <input type="text" class="form-control" id="ime" name="ime" placeholder="Ime"><br/>
                        <input type="text" class="form-control" id="prezime" name="prezime" placeholder="Prezime"><br/>
                        <input type="text" class="form-control" id="mesto" name="mestoRodjenja" placeholder="Mesto rodjenja"><br/>
                        <input type="text" class="form-control" id="drzava" name="drzavaRodjenja" placeholder="Drzava rodjenja"><br/>
                        <input type="text" class="form-control" id="jmbg" name="jmbg" placeholder="JMBG"><br/>
                        <input type="text" class="form-control" id="broj" name="brojTelefona" placeholder="Broj telefona"><br/>
                        <label>Pol: </label>
                        <input type="radio" value="m" name="pol" id="muskiPol"><label for id="muskiPol">Muski</label>
                        <input type="radio" value="z" name="pol" id="zenskiPol"><label for id="zenskiPol">Zenski</label>
                        <input type="text" class="form-control" id="email" name="email" placeholder="Email"><br/>
                        <input type="number" class="form-control" id="godinaUpisa" name="godinaUpisa" placeholder="Godina upisa"><br/>
                        <input type="number" class="form-control" id="godinaZavrsetka" name="godinaZavrsetka" placeholder="Godina zavrsetka"><br/>
                        <input type="text" class="form-control" id="odsek" name="odsek" placeholder="Odsek"><br/>
                        <label>Registrujete se kao: </label>
                        <select name="tip">
                            <option value="2">Alumni clan</option>
                            <option value="3">Blagajnik</option>
                        </select><br/>
                       
                    </form>
                        <button onclick="registracija()" class="btn">Registruj se</button><br/>
                </div>
                <div class="col-sm-2 sidenav">

                </div>
            </div>
        </div>
    </body>
</html>
