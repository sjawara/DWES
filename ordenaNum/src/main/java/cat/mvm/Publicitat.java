/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package cat.mvm;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author alumne_2n
 */
@WebServlet(name = "Publicitat", urlPatterns = {"/Publicitat"}, initParams = {
    @WebInitParam(name = "url", value = "https://fp.institutmvm.cat/")})
public class Publicitat extends HttpServlet {

    private int visites; // guardarem el nombre de visites
private int num;    // guardarem el nombre de vegades que s’ha inicialitzat el servlet
private String urlPublicitat;  // guardarem l’adreça de la publicitat
private HashMap ip;  //guardarem les ip’s dels visitants

    
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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Publicitat</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Publicitat at " + request.getContextPath() + "</h1>");
            String requestIp = request.getRemoteAddr();
            
            if (this.ip.containsKey(requestIp)){
noEsLaPrimeraVegada(out);
} else{ 
esLaPrimeraVegada(requestIp, out);
}
out.println("<h5>S'han fet " + this.visites +" visites</h5>");
out.println("<h5>S'ha cridat el mètode init " + this.num +" vegades</h5>");

            out.println("</body>");
            out.println("</html>");
            this.visites++;
        }
    }
    @Override
public void init (ServletConfig config) throws ServletException {
	super.init(config);
	this.ip = new HashMap();
	this.num++;
	this.visites = 0;
	this.urlPublicitat = getServletConfig().getInitParameter("url");
}

private void noEsLaPrimeraVegada(PrintWriter out){
out.println("<h1>Gràcies per tornar a la pàgina web. Ja no veuràs el patrocinador.</h1>");
}
 
private void esLaPrimeraVegada(String requestIp, PrintWriter out){
this.ip.put(requestIp, "");
out.println("<h1>És la primera vegada que accedeixes a la pàgina. Benvingut.</h1>");
out.println("<p style='color:red;'>Accedeix al nostre patrocinador clicant al següent enllaç:</p>");
out.println("<a href='" + this.urlPublicitat + "'>Pàgina web del patrocinador</a>");
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
