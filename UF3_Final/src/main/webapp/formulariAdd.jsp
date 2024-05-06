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
            <input name="year" id="year"/><br/>
            <label for="nombre">Nombre</label>
            <input name="nombre" id="nombre"/><br/>
            <label for="empresa">Empresa</label>
            <input name="empresa" id="empresa"/><br/>
            <label for="precio">Precio</label>
            <input name="precio" id="precio"/><br/>
            <input type="hidden" name="name" value="addform"/>
            <input type="submit" value="Enviar" name="add"/>
        </form>
                <div><a href="ProductoServlet">Go Back</a></div>

    </body>
    
</html>
