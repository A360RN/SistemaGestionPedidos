/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Modelo.Category;
import Modelo.Customer;
import Modelo.Product;
import Modelo.Sale;
import Negocio.CategoryService;
import Negocio.CustomerService;
import Negocio.ProductService;
import Negocio.SaleService;
import Util.SessionManager;
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
    private SaleService saleService;

    public UserController() {
        customerService = new CustomerService();
        categoryService = new CategoryService();
        productService = new ProductService();
        saleService = new SaleService();
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
        HttpSession session = request.getSession();
        if (SessionManager.isLoggedIn(session) && action.equals("logout")) {
            System.out.println(action);
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
        } else if (action.equals("update")) {
            update(request, response);
        } else if (action.equals("register")) {
            register(request, response);
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
            initProducts(session);
            c = customerService.find(c);
            c.setPassword(""); // seguridad e.e
            session.setAttribute("user", c);
            checkForCart(request, response);
            request.getRequestDispatcher("products.jsp").forward(request, response);
        } else {
            request.setAttribute("message", "Usuario o contraseña incorrectos");
            request.getRequestDispatcher("index.jsp").forward(request, response);

        }
    }

    public void initProducts(HttpSession session) {
        ArrayList<Product> listProducts = productService.filter();
        ArrayList<Category> listCategory = categoryService.filter();
        session.setAttribute("listProducts", listProducts);
        session.setAttribute("categories", listCategory);
    }

    private void checkForCart(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = request.getSession();
        Customer user = (Customer) session.getAttribute("user");
        Sale cart = saleService.findSaleByStatus(user.getIdCustomer(), "BUYING");
        if (cart != null) {
            session.setAttribute("cart", cart);
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Customer dto = (Customer) session.getAttribute("user");
        dto.setPhoneNumber(request.getParameter("phone"));
        dto.setAddress(request.getParameter("address").trim());
        dto.setEmail(request.getParameter("email"));
        customerService.update(dto);
        dto = customerService.find(dto);
        session.setAttribute("user", dto);
        response.sendRedirect("profile.jsp");
    }

    private void register(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Customer newUser = new Customer();

        String username = request.getParameter("username");
        newUser.setUserName(username);
        if (!customerService.userExists(newUser)) {
            String password = request.getParameter("password");
            String firstName = request.getParameter("firstname").toUpperCase();
            String middleName = request.getParameter("middlename").toUpperCase();
            String lastname = request.getParameter("lastname").toUpperCase();
            String lastname2 = request.getParameter("lastname2").toUpperCase();
            String dni = request.getParameter("dni");
            String ruc = request.getParameter("ruc");
            String phone = request.getParameter("phone");
            String address = request.getParameter("address");
            String email = request.getParameter("email").toUpperCase();

            newUser.setPassword(password);
            newUser.setFirstName(firstName);
            newUser.setMiddleName(middleName);
            newUser.setLastName(lastname);
            newUser.setLastName2(lastname2);
            newUser.setRuc(ruc);
            newUser.setDni(dni);
            newUser.setPhoneNumber(phone);
            newUser.setAddress(address);
            newUser.setEmail(email);

            customerService.insert(newUser);
            newUser = customerService.find(newUser);
            newUser.setPassword("");
            HttpSession session = request.getSession(true);
            session.setAttribute("user", newUser);
            initProducts(session);
            response.sendRedirect("products.jsp");
        } else {
            response.sendRedirect("register.jsp");
        }

    }
}
