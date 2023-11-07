<%-- 
    Document   : producto.jsp
    Created on : 11 nov 2022, 0:21:15
    Author     : manuc
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8"%>
 
<%@ page import="dwes.proyecto1.model.Producto" %>
<%@ page import="dwes.proyecto1.model.ProductoServicio" %>
<%@ page import="java.text.DecimalFormat" %>
<%@ page import="java.util.List" %>
 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
 
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MVC Sample</title>
    </head>
    <body>
        <%
        if (request.getAttribute("single_product") != null) {
            Producto product = (Producto)request.getAttribute("single_product");
        %>
 
        <h1>Product Details</h1>
        <div>ID: <%= product.getId()%></div>
        <div>Name: <%= product.getName()%></div>
        <div>Price: $ <%= new DecimalFormat("#0.00").format(product.getPrice()) %></div>
        <div><a href="ProductoServlet">Go Back</a></div>
 
        <% } else { %>
 
        <h1>Product List</h1>
        <table>
            <tr>
                    <td><b>Name</b></td>
                    <td><b>Options</b></td>
            </tr>
 
            <% for (Producto product : (List<Producto>)request.getAttribute("product_list")) {%>
 
            <tr>
                <td><%= product.getName()%></td>
                <td><a href="ProductoServlet?id=<%= product.getId()%>">Details...</a></td>
            </tr>
            <% }
          }%>
 
        </table>
    </body>
</html>