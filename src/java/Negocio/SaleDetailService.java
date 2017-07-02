/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Dao.ProductDao;
import Dao.SaleDetailDao;
import DaoImplementation.ProductImpl;
import DaoImplementation.SaleDetailImpl;
import Modelo.Product;
import Modelo.SaleDetail;
import Util.StringHelpers;
import java.util.ArrayList;

/**
 *
 * @author fernando
 */
public class SaleDetailService {

    private SaleDetailDao saleDetailDao;
    private ProductDao productDao;
    
    public SaleDetailService() {
        saleDetailDao = new SaleDetailImpl();
        productDao = new ProductImpl();
    }

    public void modifySaleDetail(String customerType, SaleDetail newSaleDetail){
        int productId = newSaleDetail.getIdProduct();
        Product product = productDao.find(productId);
        double price = product.getPrice();
        double subtotal = price * newSaleDetail.getQuantity();
        double discount = 0.0;
        
        switch(customerType){
            case "AFFILIATED":
                discount = subtotal * StringHelpers.AFFILIATED_DSCT;
                break;
            case "FREQUENT":
                discount = subtotal * StringHelpers.FREQUENT_DSCT;
        }
        
        newSaleDetail.setDiscount(discount);
        newSaleDetail.setSubtotal(subtotal - discount);
        
    }
    
    public boolean addSaleDetail(String customerType, SaleDetail newSaleDetail) {
        modifySaleDetail(customerType, newSaleDetail);
        
        SaleDetail oldSaleDetail = saleDetailDao.find(newSaleDetail.getIdProduct(), newSaleDetail.getIdSale());

        if (oldSaleDetail != null) {
            int newQuantity = newSaleDetail.getQuantity();
            double newSubtotal = newSaleDetail.getSubtotal();
            double newDiscount = newSaleDetail.getDiscount();
            oldSaleDetail.setQuantity(oldSaleDetail.getQuantity() + newQuantity);
            oldSaleDetail.setSubtotal(oldSaleDetail.getSubtotal() + newSubtotal);
            oldSaleDetail.setDiscount(oldSaleDetail.getDiscount() + newDiscount);
            saleDetailDao.update(oldSaleDetail);
            return true;
        }
        saleDetailDao.insert(newSaleDetail);
        return true;
    }
    
    public ArrayList<SaleDetail> getCartDetails(int idSale){
        ArrayList<SaleDetail> cartDetails = saleDetailDao.findBySale(idSale);
        for(SaleDetail d: cartDetails){
            Product p = productDao.find(d.getIdProduct());
            d.setProduct(p);
        }
        
        return cartDetails;
    }
}
