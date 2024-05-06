<%-- 
    Document   : game
    Created on : 27 de febr. 2024, 16:51:27
    Author     : alumne_2n
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
        <title>Game</title>
    </head>
    <body>
        <section>
            <div class="jumbotron">
                <div class="container">
                    <h1>Game</h1>
                </div>
            </div>
        </section>
        <section class="container">
            <div class="row">
                <div class="col-md-5">
                    <h3>${game.nom}</h3>
                    <p>${game.empresa}</p>
                    <p>
                        <strong>Codi : </strong>${game.id}
                    </p>
                    
                    <p>
                        <strong>Plataforma</strong> : ${game.plataforma}
                    </p>
                    <p>
                        <strong>Preu</strong> : ${game.preu}
                    </p>
                    
                </div>
                        <a href="<spring:url value="/games/all" />" class="btn btn-default">
                        <span class="glyphicon-hand-left glyphicon"></span> tornar
                    </a>
            </div>
        </section>
    </body>
</html>
