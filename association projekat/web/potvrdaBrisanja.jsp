<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Potvrda</title>
    </head>
    <body>
        <h3>${(porukaZaBrisanje!=null) ? porukaZaBrisanje : ""} </h3>
        <h3>${(porukaIzmena!=null) ? porukaIzmena : ""} </h3>
        <h3>${(porukaIzmeneKontakta!=null) ? porukaIzmeneKontakta : ""} </h3>
        <h3>${(porukaBrisanjaDogadjaja!=null) ? porukaBrisanjaDogadjaja : ""} </h3>
        <h3>${(porukaIzmeneDogadjaja!=null) ? porukaIzmeneDogadjaja : ""} </h3>
        <h3>${(porukaBrisanjaKorisnika!=null) ? porukaBrisanjaKorisnika : ""} </h3>
        <h3>${(porukaDodavanjaKorisnika!=null) ? porukaDodavanjaKorisnika : ""} </h3>
        <a href="IzlistajSveVesti">Nazad na vesti</a><br/>
        <a href="IzlistajSveDogadjaje">Nazad na dogadjaje</a><br/>
        <a href="IzlistajNeaktivne">Nazad na neakticne clanove</a><br/>
        <a href="admin.jsp">Nazad na pocetnu</a>
    </body>
</html>
