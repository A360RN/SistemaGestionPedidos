/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Dao.ProductDao;
import Dao.SaleDao;
import Dao.SaleDetailDao;
import DaoImplementation.ProductImpl;
import DaoImplementation.SaleDetailImpl;
import DaoImplementation.SaleImpl;
import Modelo.Product;
import Modelo.Sale;
import Modelo.SaleDetail;
import java.util.ArrayList;

/**
 *
 * @author fernando
 */
public class SaleService {

    private SaleDao saleDao;
    private SaleDetailDao saleDetailDao;
    private ProductDao productDao;

    public SaleService() {
        saleDao = new SaleImpl();
        saleDetailDao = new SaleDetailImpl();
        productDao = new ProductImpl();
    }

    public void addSale(Sale sale) {
        saleDao.insert(sale);
    }

    public Sale findSaleByStatus(int idCustomer, String status) {
        Sale oldCart = saleDao.findByState(idCustomer, status);
        if (oldCart != null) {
            Sale newCart = getSaleTotal(oldCart);
            System.out.println(newCart);
            return newCart;
        }
        return oldCart;
    }

    public void confirmSale(Sale cart) {
        cart.setState("CONFIRMED");
        Sale updatedCart = getSaleTotal(cart);
        cart.setTotal(updatedCart.getTotal());
        cart.setTotalDiscount(updatedCart.getTotalDiscount());
        saleDao.update(cart);
    }

    public Sale getSaleTotal(Sale cart) {
        Sale updatedCart = cart;
        ArrayList<SaleDetail> saleDetails = saleDetailDao.findBySale(updatedCart.getIdSale());
        double total = 0;
        double totalDiscount = 0;
        for (SaleDetail detail : saleDetails) {
            total += detail.getSubtotal();
            totalDiscount += detail.getDiscount();
        }
        updatedCart.setTotal(total);
        updatedCart.setTotalDiscount(totalDiscount);
        return updatedCart;
    }

    public void deleteCart(Sale cart) {
        saleDetailDao.deleteBySale(cart.getIdSale());
        saleDao.delete(cart.getIdSale());
    }

    public ArrayList<Sale> findLastSales(int idCustomer) {
        ArrayList<Sale> lastSales = saleDao.findLastSales(idCustomer);

        for (Sale s : lastSales) {
            ArrayList<SaleDetail> saleDetails = saleDetailDao.findBySale(s.getIdSale());

            for (SaleDetail detail : saleDetails) {
                Product p = productDao.find(detail.getIdProduct());
                detail.setProduct(p);
            }
            s.setSaleDetails(saleDetails);
        }

        return lastSales;
    }

}
