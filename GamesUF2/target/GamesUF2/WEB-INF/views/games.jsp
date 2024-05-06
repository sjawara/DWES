<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<!DOCTYPE html>
<html lang="ca">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
        <title>Games</title>
    </head>
    <body>
        <section>
            <div class="jumbotron">
                <div class="container">
                    <h1>Games</h1>
                    <p>Llista de games en magatzem</p>
                </div>
            </div>
        </section>
        <section class="container">
            <div class="row">

                <c:forEach items="${games}" var="game">
                    <div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
                        <div class="thumbnail">
                            <div class="caption">
                                <h3>${game.nom}</h3>
                                <p>${game.year}</p>
                                <p>${game.preu}</p>
                                <p>${game.limitDownload}</p>
                                <p>${game.plataforma}</p>
                                <p>${game.categoria}</p>
                            </div>
                            <p>
                                <a href=" <spring:url value= "/games/game?codi=${game.id}" /> " class="btn btn-primary">
                                    <span class="glyphicon-info-sign glyphicon"/></span> Detall
                                </a>
                                <a href=" <spring:url value= "/games/update?codi=${game.id}" /> " class="btn btn-primary" style="background-color: green">
                                    <span class="glyphicon-info-sign glyphicon"/></span> Actualitzar
                                </a>
                            </p>
                            <p>
                               <a href=" <spring:url value= "/games/delete?codi=${game.id}" /> " class="btn btn-primary" style="background-color: red">
                                    <span class="glyphicon-info-sign glyphicon"/></span> Borrar
                                </a> 
                            </p>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </section>
    </body>
</html>
