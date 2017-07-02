/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Modelo.Category;
import Modelo.Customer;
import Modelo.Product;
import Negocio.CategoryService;
import Negocio.CustomerService;
import Negocio.ProductService;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "UserController", urlPatterns = {"/UserController"})
public class UserController extends HttpServlet {

    private CustomerService customerService;
    private CategoryService categoryService;
    private ProductService productService;

    public UserController() {
        customerService = new CustomerService();
        categoryService = new CategoryService();
        productService = new ProductService();
    }

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
        if (action.equals("logout")) {
            HttpSession session = request.getSession();
            session.invalidate();
            response.sendRedirect("index.jsp");
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
        String action = request.getParameter("action");
        if (action.equals("login")) {
            login(request, response);
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

    private void login(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Customer c = new Customer();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        c.setUserName(username);
        c.setPassword(password);
        boolean isCorrect = customerService.login(c);
        if (isCorrect) {
            HttpSession session = request.getSession(true);
            session.setMaxInactiveInterval(8 * 60);
            ArrayList<Product> listProducts = productService.filter();
            ArrayList<Category> listCategory = categoryService.filter();
            c = customerService.find(c);
            session.setAttribute("user", c);
            session.setAttribute("listProducts", listProducts);
            session.setAttribute("categories", listCategory);
            request.getRequestDispatcher("products.jsp").forward(request, response);
        } else {
            request.setAttribute("message", "Error");
            request.getRequestDispatcher("index.jsp").forward(request, response);

        }
    }

}
