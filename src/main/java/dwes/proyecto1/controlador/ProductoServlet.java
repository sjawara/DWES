/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package dwes.proyecto1.controlador;

import dwes.proyecto1.model.ProductoServicio;
import java.io.IOException;
//import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author seku
 */
@WebServlet(name = "ProductoServlet", urlPatterns = {"/ProductoServlet"})

public class ProductoServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
            ProductoServicio service = new ProductoServicio();
            int contador=1;
        protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
            
            
                  //String value = request.getParameter("id");  
        String value = request.getParameter("name");
        if ("detall".equals(value)) {

            int id = Integer.parseInt(request.getParameter("id"));
            request.setAttribute("single_product", service.getProducto(id));
       } else if("borrar".equals(value)) {
            String juego=request.getParameter("id");
            int juegoo=Integer.parseInt(juego);
           service.eliminarProducto(juegoo);
            request.setAttribute("product_list", service.getProductos());
       }else if("add".equals(value)){
             getServletConfig().getServletContext().getRequestDispatcher("/formulariAdd.jsp").forward(request,response);
       }else{
                 request.setAttribute("product_list", service.getProductos());
                }
        getServletConfig().getServletContext().getRequestDispatcher("/producto.jsp").forward(request,response);
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