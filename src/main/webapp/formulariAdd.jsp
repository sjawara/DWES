<%-- 
    Document   : formulariAdd
    Created on : 14 de nov. 2023, 17:03:29
    Author     : alumne_2n
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Añadir juego</h1>
        <h3>Este es un formulario para que puedas añadir un juego.</h3>
        <form action="ProductoServlet" method="POST">
            <label for="año">Año</label>
            <input id="año"/><br/>
            <label for="nombre">Nom</label>
            <input id="nombre"/><br/>
            <label for="empresa">Empresa</label>
            <input id="empresa"/><br/>
            <label for="precio">Precio</label>
            <input id="precio"/><br/>
            <input type="hidden" name="name" value="addform"/>
            <input type="submit" value="Enviar" name="add"/>
        </form>
    </body>
    
</html>
