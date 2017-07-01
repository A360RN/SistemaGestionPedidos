/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Modelo.Product;
import Negocio.ProductBO;
import Util.JsonConverter;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ASUS
 */
public class ProductController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
        String action = request.getParameter("action");
        if (action.equals("category")) {
            productByCategory(request, response);
        } else if (action.equals("most-wanted")) {
            mostWantedProducts(request, response);
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

    private void productByCategory(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idCategory = Integer.parseInt(request.getParameter("idCategory"));
        ProductBO productService = new ProductBO();
        ArrayList<Product> listProducts = productService.filterByCategory(idCategory);
        String json = JsonConverter.stringify(listProducts);
        response.getWriter().print(json);
    }

    private void mostWantedProducts(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ProductBO productService = new ProductBO();
        ArrayList<Product> listProducts = productService.filterBySales();
        String json = JsonConverter.stringify(listProducts);
        response.getWriter().print(json);
    }

}
