package mx.com.lickodev.ecommercejee.control;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Santa Cecilia
 */
public class CambiarMoneda extends HttpServlet {

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
        HttpSession session = request.getSession();
        if (request.getParameter("moneda") != null) {
            switch (request.getParameter("moneda")) {
                case "COP":
                    session.setAttribute("moneda", request.getParameter("moneda"));
                    session.setAttribute("nom_moneda", "$ Pesos Colombianos");
                    break;
                case "USD":
                    session.setAttribute("moneda", request.getParameter("moneda"));
                    session.setAttribute("nom_moneda", "$ Dólar (USA)");
                    break;
                case "PEN":
                    session.setAttribute("moneda", request.getParameter("moneda"));
                    session.setAttribute("nom_moneda", "$ Sol Peruano");
                    break;
                default:
                    session.setAttribute("moneda", "MXN");
                    session.setAttribute("nom_moneda", "$ Pesos Mexicanos");
                    break;
                
            }
        }
        response.sendRedirect("Inicio");
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
