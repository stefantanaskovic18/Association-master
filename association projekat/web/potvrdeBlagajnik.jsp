<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Potvrda</title>
    </head>
    <body>
        <h3>${(porukaAktiviranja!=null) ? porukaAktiviranja : ""} </h3>
        <h3>${(porukaDeaktiviranja!=null) ? porukaDeaktiviranja : ""} </h3>
        <a href="blagajnik.jsp">Pocetna</a><br/>
        <a href="IzlistajKorisnike">Aktiviraj / Deaktiviraj korisnike</a>
    </body>
</html>
