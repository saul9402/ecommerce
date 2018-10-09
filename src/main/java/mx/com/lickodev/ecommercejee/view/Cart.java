package mx.com.lickodev.ecommercejee.view;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mx.com.lickodev.ecommercejee.cad.ProductoCad;
import mx.com.lickodev.ecommercejee.javabeans.Item;
import mx.com.lickodev.ecommercejee.javabeans.Producto;

/**
 *
 * @author Santa Cecilia
 */
public class Cart extends HttpServlet {

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
        if (request.getParameter("action") != null) {
            String a = request.getParameter("action");
            int webid = Integer.parseInt(request.getParameter("id"));
            Producto producto;
            HttpSession httpSession = request.getSession();
            if (a.equals("order")) {
                if (httpSession.getAttribute("cart") == null) {
                    ArrayList<Item> cart = new ArrayList<>();
                    producto = ProductoCad.consultarProducto(httpSession.getAttribute("moneda").toString(), webid);
                    cart.add(new Item(producto, 1));
                    httpSession.setAttribute("cart", cart);
                } else {
                    ArrayList<Item> cart = (ArrayList<Item>) httpSession.getAttribute("cart");
                    int indice = yaExisteElProducto(webid, cart);
                    if (indice == -1) {
                        producto = ProductoCad.consultarProducto(httpSession.getAttribute("moneda").toString(), webid);
                        cart.add(new Item(producto, 1));
                    } else {
                        int cantidad = cart.get(indice).getCantidad() + 1;
                        cart.get(indice).setCantidad(cantidad);
                    }
                    httpSession.setAttribute("cart", cart);
                }
            } else if (a.equals("delete")) {
                ArrayList<Item> cart = (ArrayList<Item>) httpSession.getAttribute("cart");
                int indice = yaExisteElProducto(webid, cart);
                cart.remove(indice);
                httpSession.setAttribute("cart", cart);
            }
        }
        response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher("WEB-INF/cart.jsp").forward(request, response);

    }

    private int yaExisteElProducto(int webid, ArrayList<Item> cart) {

        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).getProducto().getWebid() == webid) {
                return i;
            }
        }
        return -1;
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
