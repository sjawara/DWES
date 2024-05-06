<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%!
private static final int NUM_PLANTES = 5;
private static final int NUM_HAB = 10;
private static final int MAX_CLIENTS = 5;
private int rand(int min,int max ) {
return (int) (Math.random() * (max + 1 - min) + min);
}
 int [][] ocupantes = new int [NUM_PLANTES][NUM_HAB];
    
private int [][] asignarClientes(int num1,int num2){
 int [][] ocupantes = new int [NUM_PLANTES][NUM_HAB];
    for(int i=0; i<num1;i++){
        for(int j=0;j<num2;j++){
        ocupantes[i][j]=rand(0,5);
}
}
return ocupantes;
}

private int[] ocupacio(int[][] hotel){
int [] ocupades = new int[NUM_PLANTES];
for(int i=0;i<NUM_PLANTES;i++){
int x =0;
for(int j=0;j<NUM_HAB;j++){
if(hotel[i][j]>0){
x++;

}
ocupades[i]=x;
}


}
return ocupades;
}

private boolean habBuides(int[][] hotel) {
boolean trobat = false;
int i=0;
while(trobat==false&&i<NUM_PLANTES){
int j = 0;
while(trobat==false&&j<NUM_HAB){
if(hotel[i][j]==0){
trobat = true;
}else{
j++;
}}
i++;
}
return trobat;
}


%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <ul>
                <%
        ocupantes= asignarClientes(NUM_PLANTES,NUM_HAB);
        for(int i=0; i<NUM_PLANTES;i++){
        for(int j=0;j<NUM_HAB;j++){
        out.println("<li>" +"La habitacion "+j+" de la planta "+i+ " hay " +ocupantes[i][j]+" ocupantes."+"</li>");
        }
        }
                    %>
        </ul>
        <p></p>
        <p></p><p></p>
        <ul>
            <% 
                int [] ocupades = new int[NUM_PLANTES];
                ocupades=ocupacio(ocupantes);
                for(int i=0;i<NUM_PLANTES;i++){
                int num ;
                num=ocupades[i];
                 out.println("<li>"+"la planta "+i+" tiene "+ num  + " habiotaciones"+ "</li>");                }
                %>
                
        </ul>
                <ul>
                    <% 
                        boolean trobat;
                        trobat= habBuides(ocupantes);
                        if(trobat==true){
                        out.println("<li>"+"hay habvitaciones vacias"+ "</li>");
                        
                        }else{
                        out.println("<li>"+"no hay habvitaciones vacias"+ "</li>");
                        }
                        %>
                        
                </ul>
        
    </body>
</html>
