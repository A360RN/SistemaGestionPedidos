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
import Util.SessionManager;
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
        } else if (action.equals("last-sales")) {
            findLastSales(request, response);
            response.sendRedirect("profile.jsp");
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
        System.out.println(action);
        switch (action) {
            case "addSale":
                addSale(request, response);
                break;
            case "save-cart":
                confirmCart(request, response);
                break;
            case "delete-cart":
                deleteCart(request, response);
                break;
            case "delete-detail":
                deleteDetail(request, response);
                break;
            default:
                break;
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
        if (SessionManager.isLoggedIn(session)) {
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
            Sale shoppingCart = (Sale) session.getAttribute("cart");
            int idSale = shoppingCart.getIdSale();

            ArrayList<SaleDetail> cartDetails = saleDetailService.getCartDetails(idSale);
            if(!cartDetails.isEmpty()){
                session.setAttribute("cartDetails", cartDetails);
            }
            
        }
        response.sendRedirect("cart.jsp");
    }

    private void findCart(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        Customer user = (Customer) session.getAttribute("user");
        int idCustomer = user.getIdCustomer();
        Sale cart = saleService.findSaleByStatus(idCustomer, "BUYING");
        ArrayList<SaleDetail> cartDetails = saleDetailService.getCartDetails(cart.getIdSale());
        session.setAttribute("cartDetails", cartDetails);
        if(cartDetails.isEmpty()){
            session.removeAttribute("cartDetails");
        }
    }

    private void confirmCart(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Sale cart = (Sale) session.getAttribute("cart");
        saleService.confirmSale(cart);
        session.removeAttribute("cart");
        session.removeAttribute("cartDetails");
        session.setAttribute("message", "Compra guardada!");
    }

    private void deleteCart(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Sale cart = (Sale) session.getAttribute("cart");
        saleService.deleteCart(cart);
        session.removeAttribute("cart");
        session.removeAttribute("cartDetails");
    }

    private void findLastSales(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Customer user = (Customer) session.getAttribute("user");
        int idCustomer = user.getIdCustomer();
        ArrayList<Sale> lastSales = saleService.findLastSales(idCustomer);
        session.setAttribute("lastSales", lastSales);
    }

    private void deleteDetail(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Sale cart = (Sale) session.getAttribute("cart");
        int idSale = cart.getIdSale();
        int idProduct = Integer.parseInt(request.getParameter("idProduct"));
        saleDetailService.deleteSaleDetail(idProduct, idSale);
        findCart(request, response);
    }
}
