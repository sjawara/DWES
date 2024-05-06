<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList" %>
<%!
private int rand(int min, int max) {
return (int) (Math.random() * (max+1 - min) + min);
}


private ArrayList cercarBuides(int[] taules){
ArrayList buides = new ArrayList();
for (int i = 0; i < taules.length; i++) {
if(taules[i] == 0){
buides.add(i);
}
}
return buides;
}

%>
<!DOCTYPE html>
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> <title>...</title></head>
    <body>
        <%
        //inicialització de les taules amb els comensals
        int[] taules = new int[10];
        for (int i = 0; i < 10; i++) {
        taules[i] = rand(0, 5);
        }
        %>


        <h1>Gestió de taules d'un restaurant</h1>
        <ul>
            <%
            //llistat de les taules
            for(int i = 0; i < 10; i++)
            {
            switch(taules[i]){
            case 0:  %>
            <li>La taula <%=i %> està buida</li>
                <%		break;
case 5: %>
            <li>La taula <%=i %> està plena.</li>
                <%		break;
default: %>
            <li>La taula <%=i %> té <%=taules[i]%> comensals</li>
                <%		}
                }
                %>
            
           
        </ul>
    <%
//cerquem les taules buides
ArrayList taulesBuides = cercarBuides(taules);
%>
<h1>Les següents taules estan buides:</h1>
<ul>
<%
//llistat de les taules buides
if(taulesBuides.isEmpty()){
out.println("No hi han taules buides.");
}
for (Object taula: taulesBuides){
out.println("<li>La taula " + taula + " està buida.</li>");
}
%>
</ul>

    
    
    </body></html>
