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
        <title>Filtre per any</title>
    </head>
    <body>
        
        <section class="container">
            <form:form  class="form-horizontal">
                <fieldset>
                    
                    <div class="form-group">
                        <label class="control-label col-lg-2 col-lg-2" for="medicamentId">Minim Year</label>
                        <div class="col-lg-10">
                            <form:input id="minYear" path="minYear" type="text" class="form:input-large"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-lg-2 col-lg-2" for="name">Max year</label>
                        <div class="col-lg-10">
                            <form:input id="maxYear" path="maxYear" type="text" class="form:input-large"/>
                        </div>
                    </div>
                    
                    
                    <div class="form-group">
                        <div class="col-lg-offset-2 col-lg-10">
                            <input type="submit" id="btnAdd" class="btn btn-primary"
                                   value ="Filtrar"/>
                        </div>
                    </div>
                </fieldset>
            </form:form>
        </section>
    </body>
</html>
