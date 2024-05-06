<%-- 
    Document   : contar
    Created on : 10 d’oct. 2023, 17:03:22
    Author     : alumne_2n
--%>
<%@page import="java.util.HashMap"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%!
    String cadenaContar = " ";
    HashMap <String, Integer> letrasContadas = new HashMap<String,Integer>();
        char caracter;
        String clave;
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form action="contar.jsp" method="POST">
                Texto:<input type="text" name="texto"> 
                <input type="submit" value="enviar"/>
            </form>
        <%
            //String numero1 = request.getParameter("texto");
            
       // HashMap <String, Integer> letrasContadas = new HashMap<String,Integer>();
        //char caracter;
        //String clave;
          if(request.getParameter("texto")==null){
            cadenaContar="";
            }else{
            cadenaContar=request.getParameter("texto");
            }
            cadenaContar=cadenaContar.toLowerCase();
        //convertir cadenaContar a minusculas
        for (int i=0; i<cadenaContar.length(); i++){
            caracter = cadenaContar.charAt(i);
            if(cadenaContar.charAt(i)!=' '){
            clave = String.valueOf(caracter);
            //comprobar que no sea un espacio en blanco
            Integer numero = letrasContadas.get(clave);
            if (numero ==null){
                numero = 1;
            } else {
                numero++;
            }
            letrasContadas.put(clave,numero);
            }
        }
        out.println();
        out.println(letrasContadas);
        %>
    </body>
</html>
