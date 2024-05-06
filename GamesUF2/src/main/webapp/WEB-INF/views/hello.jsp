<%-- 
    Document   : hello.jsp
    Created on : 23 de gen. 2024, 17:03:02
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
        <h1>${titulo}</h1>
        <p>${mensaje}</p>
        <!--
        <script>
            function cambiar(){
            var enlace1 = document.getElementById('enlace1');
            var enlace2 = document.getElementById('enlace2');

            var urlActual = window.location.href;

            // Realizar un switch case basado en la URL
            switch (urlActual) {
                case 'http://localhost:8080/GamesUF2/bonanit':
                    enlace1.href = "http://localhost:8080/GamesUF2/bondia";
                    enlace1.innerHTML = "Bon Dia!";
                    enlace1.href = "http://localhost:8080/GamesUF2";
                    enlace1.innerHTML = "Dia!";
                    break;

                case 'http://localhost:8080/GamesUF2/bonDia':
                    enlace1.href = "http://localhost:8080/GamesUF2/bonanit";
                    enlace1.innerHTML = "Bona Nit!";
                    enlace1.href = "http://localhost:8080/GamesUF2";
                    enlace1.innerHTML = "Dia!";
                    break;
               

                default:
                    enlace1.href = "http://localhost:8080/GamesUF2/bonanit";
                    enlace1.innerHTML = "Bona Nit!";
                    enlace1.href = "http://localhost:8080/GamesUF2/bondia";
                    enlace1.innerHTML = "Bon Dia!";
            }
        }
        </script>
       


    </script>
         
    <a id="enlace1" href="http://localhost:8080/GamesUF2/bonanit"> <button onclick="cambiar()">Bona nit</button></a>
    <a id="enlace2" href="http://localhost:8080/GamesUF2/bondia"> <button onclick="cambiar()>Bon dia</button></a>
        -->
</body>

</html>
