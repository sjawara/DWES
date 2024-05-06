<%-- 
    Document   : Parametres
    Created on : 19 de set. 2023, 17:31:14
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
        <h1>Hello World!</h1>
        <%
        String datoUno = request.getParameter("dato1");
        String datoDos = request.getParameter("dato2");
        String datoTres = request.getParameter("dato3");

        out.println(datoUno);
        out.println(datoDos);
        out.println(datoTres);

        %>
    </body>
</html>
