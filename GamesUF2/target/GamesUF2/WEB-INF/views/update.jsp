    <%-- 
        Document   : update
        Created on : 4 de març 2024, 15:45:02
        Author     : alumne_2n
    --%>

    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    <%@page contentType="text/html" pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
            <link
                rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
            <title>Joc</title>
        </head>
        <body>
            <section>
                <div class="jumbotron">
                    <div class="container">
                        <h1>Joc</h1>
                        <p>Afegir joc</p>
                    </div>
                </div>
            </section>
            <section class="container">
                <form:form modelAttribute="updateGame" class="form-horizontal">
                    <fieldset>
                        <legend>Afegir joc</legend>
                        <div class="form-group" style="display: none">
                            <label class="control-label col-lg-2 col-lg-2" for="id">Codi</label>
                            
                                <form:input id="id" path="id" type="text" class="form:input-large" placeholder= "${updateGame.id}" />
                            
                        </div>
                        <div class="form-group">
                            <label class="control-label col-lg-2 col-lg-2" for="name">Nom</label>
                            <div class="col-lg-10">
                                <form:input id="nom" path="nom" type="text" class="form:input-large" placeholder= "${updateGame.nom}" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-lg-2 col-lg-2" for="price">Empresa</label>
                            <div class="col-lg-10">
                                <form:input id="empresa" path="empresa" type="text" class="form:input-large" placeholder= "${updateGame.empresa}" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-lg-2 col-lg-2" for="producer">Preu</label>
                            <div class="col-lg-10">
                                <form:input id="preu" path="preu" type="text" class="form:input-large" placeholder= "${updateGame.preu}" />
                            </div>
                        </div>   
                        <div class="form-group">
                            <label class="control-label col-lg-2 col-lg-2" for="category">Year</label>
                            <div class="col-lg-10">
                                <form:input id="year" path="year" type="text" class="form:input-large" placeholder= "${updateGame.year}" />
                            </div>
                        </div> 
                        <div class="form-group">
                            <label class="control-label col-lg-2 col-lg-2" for="stockQuantity">Unitats descargas</label>
                            <div class="col-lg-10">
                                <form:input id="limitDownload" path="limitDownload" type="text" class="form:input-large" placeholder= "${updateGame.limitDownload}" />
                            </div>
                        </div>                     
                        <div class="form-group">
                            <label class="control-label col-lg-2 col-lg-2" for="stockInOrder">Categoria</label>
                            <div class="col-lg-10">
                                <form:input id="categoria" path="categoria" type="text" class="form:input-large" placeholder= "${updateGame.categoria}" />
                            </div>
                        </div>
                            
                            <div class="form-group">
                            <label class="control-label col-lg-2 col-lg-2" for="plataforma">Plataforma</label>
                            <div class="col-lg-10">
                                <form:input id="plataforma" path="plataforma" type="text" class="form:input-large" placeholder= "${updateGame.plataforma}" />
                            </div>
                        </div>   

                        <div class="form-group">
                            <div class="col-lg-offset-2 col-lg-10">
                                <input type="submit" id="btnAdd" class="btn btn-primary"
                                       value ="Crear"/>
                            </div>
                        </div>
                    </fieldset>
                </form:form>
            </section>
        </body>
    </html>




