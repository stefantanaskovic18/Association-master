<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pocetna</title>
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
                        <li class="active"><a href="#">Pocetna - Login</a></li>
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
                    <form action="Login" method="post">
                        <div class="form-group">
                            <label for="usr">Korisnicko ime:</label>
                            <input type="text" class="form-control" id="usr" name="username">
                        </div>
                        <div class="form-group">
                            <label for="pwd">Sifra:</label>
                            <input type="password" class="form-control" id="pwd" name="password">
                        </div>
                        <div class="form-group">
                            <input type="submit" value="Uloguj se">
                        </div>
                        <div class="form-group">
                            <h3>${(poruka!=null) ? poruka : ""} </h3><br/><br/>
                        </div>
                    </form>
                    <br/><br/>
                    <form action="PromenaSifre" method="post">
                        <label>Korisnicko ime</label>
                        <input class="form-control" type="text" name="korisnickoIme">
                        <label>Stara sifra</label>
                        <input class="form-control" type="password" name="staraSifra">
                        <label>Nova sifra</label>
                        <input class="form-control" type="password" name="novaSifra"><br/>
                        <button type="submit">Promeni sifru</button><br/>
                        <h3>${(porukaPromene!=null) ? porukaPromene : ""} </h3>
                    </form>
                </div>
                <div class="col-sm-2 sidenav">

                </div>
            </div>
        </div><!-- /.container -->

    </body>
</html>
