<%-- 
    Document   : modificar
    Created on : 20 de nov. 2023, 16:50:52
    Author     : alumne_2n
--%>

<%@page import="java.util.List"%>
<%@page import="dwes.proyecto1.model.Producto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <%
            
            Producto productoSeleccionado=new Producto();
        int id= Integer.parseInt(request.getParameter("id"));
        for (Producto product : (List<Producto>)request.getAttribute("product_list")) { 
            if(id==product.getId()){
            productoSeleccionado=product;
            }
            }      
        %>
       <h1>Modificar juego</h1>
        <h3>Este es un formulario para que puedas modificar un juego.</h3>
        <form action="ProductoServlet" method="POST">
            <label for="año">Año</label>
            <input name="year" id="year" value=<%=productoSeleccionado.getAny() %> /><br/>
            <label for="nombre">Nombre</label>
            <input name="nombre" id="nombre" value=<%=productoSeleccionado.getNom() %> /><br/>
            <label for="empresa">Empresa</label>
            <input name="empresa" id="empresa" value=<%=productoSeleccionado.getEmpresa()%> /><br/>
            <label for="precio">Precio</label>
            <input name="precio" id="precio" value=<%=productoSeleccionado.getPreu() %> /><br/>
            <input type="hidden" name="id" value=<%=request.getParameter("id")%> />
            <input type="hidden" name="name" value="modificarPush"/>
            <input type="submit" value="Enviar" name="modificar"/>
        </form>
                    <div><a href="ProductoServlet">Go Back</a></div>

    </body>
</html>
