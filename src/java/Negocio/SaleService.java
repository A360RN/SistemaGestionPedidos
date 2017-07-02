/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Dao.SaleDao;
import DaoImplementation.SaleImpl;
import Modelo.Sale;

/**
 *
 * @author fernando
 */
public class SaleService {

    private SaleDao saleDao;
    
    public SaleService() {
        saleDao = new SaleImpl();
    }
    
    public void addSale(Sale sale){
        saleDao.insert(sale);
    }
    
    public Sale findSaleByStatus(int idCustomer, String status){
        return saleDao.findByState(idCustomer, status);
    }

    public void confirmSale(Sale cart) {
        cart.setState("CONFIRMED");
        saleDao.update(cart);
    }
    
}
