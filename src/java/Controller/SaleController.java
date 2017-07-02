/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Modelo.Customer;
import Modelo.Sale;
import Modelo.SaleDetail;
import Negocio.SaleService;
import Negocio.SaleDetailService;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ASUS
 */
public class SaleController extends HttpServlet {

    private SaleService saleService;
    private SaleDetailService saleDetailService;

    public SaleController() {
        saleService = new SaleService();
        saleDetailService = new SaleDetailService();
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
        if (action.equals("cart")) {
            showCart(request, response);
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
        if (action.equals("addSale")) {
            addSale(request, response);
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

    private void addSale(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        int idProduct = Integer.parseInt(request.getParameter("idProduct"));
        Customer user = (Customer) session.getAttribute("user");
        boolean doesCartExists = cartExists(session);

        if (!doesCartExists) {
            createSale(session, user.getIdCustomer(), "BUYING");
        }
        Sale sale = (Sale) session.getAttribute("cart");
        int idSale = sale.getIdSale();
        String customerType = user.getCustomerType();
        SaleDetail saleDetail = new SaleDetail();
        saleDetail.setIdProduct(idProduct);
        saleDetail.setIdSale(idSale);
        saleDetail.setQuantity(quantity);
        saleDetailService.addSaleDetail(customerType, saleDetail);
    }

    private boolean cartExists(HttpSession session) {
        return session.getAttribute("cart") != null;
    }

    private void createSale(HttpSession session, int idCustomer, String buying) {
        Sale sale = new Sale();
        sale.setIdCustomer(idCustomer);
        sale.setState(buying);
        sale.setTotal(0);
        sale.setTotalDiscount(0);

        saleService.addSale(sale);
        sale = saleService.findSaleByStatus(idCustomer, "BUYING");
        session.setAttribute("cart", sale);
    }

    private void showCart(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();

        if (session.getAttribute("cart") != null) {
            Sale shoppingCart = (Sale)session.getAttribute("cart");
            int idSale = shoppingCart.getIdSale();
            
            ArrayList<SaleDetail> saleDetails = saleDetailService.getAllSaleDetails(idSale);
            session.setAttribute("cartDetails", saleDetails);
            request.getRequestDispatcher("cart.jsp");
        }
        response.sendRedirect("cart.jsp");

    }

}
