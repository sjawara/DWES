package cat.ioc.m7.formservlets;
    
import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;

@WebServlet(name = "PostServlet2", urlPatterns = {"/PostServlet2"})
public class PostServlet2 extends HttpServlet {

    @Resource
    Validator validator;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NamingException {

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletValidation2</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<hr>");

            //String missatge = request.getParameter("missatgePost");
            String nomCognom = request.getParameter("nomCognom");
            String mail = request.getParameter("mail");
            String edat = request.getParameter("edat");
            String telefon = request.getParameter("telefon");
            String adress = request.getParameter("adress");
            //String codiP = request.getParameter("codiP");
            String poblacio = request.getParameter("poblacio");

            PostBean2Local bean = (PostBean2Local) new InitialContext().lookup("java:global/primeraAppEJB/PostBean2");
            out.println("<p> FUNCIONA </p>");

            //bean.setMessage(missatge);
            bean.setEmail(mail);

            bean.setEdat(edat);
            bean.setAdress(adress);
           // bean.setCodiP(codiP);
            bean.setNomCognom(nomCognom);
            bean.setTelefon(telefon);
            bean.setPoblacio(poblacio);


            out.println("<h1>Dades rebudes del formulari</h1>");
            //out.println("<p>Missatge: " + bean.getMessage() + "</p>");
            out.println("<p>Edat: " + bean.getEdat() + "</p>");
            out.println("<p>Email: " + bean.getEmail() + "</p>");
                       out.println("<p>Nom y cognom: " + bean.getNomCognom() + "</p>");
            out.println("<p>Adreça: " + bean.getAdress() + "</p>");
           // out.println("<p>Codi postal: " + bean.getCodiP() + "</p>");
            out.println("<p>Poblacio: " + bean.getPoblacio() + "</p>");
            out.println("<p>Telefon: " + bean.getTelefon() + "</p>");
            
            

            
            


            out.println("<h1>Llistat de validacions:</h1>");

      try {
    for (Iterator<ConstraintViolation<PostBean2Local>> it = validator.validate(bean).iterator(); it.hasNext();) {
        ConstraintViolation<PostBean2Local> c = it.next();
        out.println("<p>" + c.getMessage() + "</p>");
    }
} catch (Exception ex) {
    ex.printStackTrace(); // Esto imprimirá la traza de la excepción en la consola
    // También puedes imprimir el mensaje de la excepción en la página para obtener más detalles
    out.println("<p>Error al validar: " + ex.getMessage() + "</p>");

}


            out.println("</body>");
            out.println("</html>");
        } catch (NamingException ex) {
            Logger.getLogger(PostServlet2.class.getName()).log(Level.SEVERE, null, ex);
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
        try {
            processRequest(request, response);
        } catch (NamingException ex) {
            Logger.getLogger(PostServlet2.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (NamingException ex) {
            Logger.getLogger(PostServlet2.class.getName()).log(Level.SEVERE, null, ex);
        }
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
