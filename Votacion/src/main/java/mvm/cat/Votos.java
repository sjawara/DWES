/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package mvm.cat;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author alumne_2n
 */
@WebServlet(name = "Votos", urlPatterns = {"/Votos"})
public class Votos extends HttpServlet {
private int vegades;
HashMap <String,Integer> contJugadores= new HashMap<String,Integer>();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String recogido=request.getParameter("jugador");
        this.vegades++;
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Votos</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Has votado a "+ recogido+"</h1>");
            out.println("<p> Total: "+ vegades+"</p>");
            String clave=request.getParameter("jugador");
            Integer num= contJugadores.get(clave);
            if (num ==null){
                num = 1;
            } else {
                num++;
            }
            contJugadores.put(clave, num);
            out.println("<ul>");
            //La funcion de este for es separar el contenido del hasmap en clave y contenido para asi poder mostrarlo
            for(Map.Entry<String, Integer> entry:contJugadores.entrySet()){
               out.println("<li>"+entry.getKey()+ " "+entry.getValue()+"</li>");
            }
                        out.println("</ul>");
                        out.print("<p><a href='index.html'> RETORNAR</p>");

            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
