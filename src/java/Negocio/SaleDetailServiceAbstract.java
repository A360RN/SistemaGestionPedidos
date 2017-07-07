/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Modelo.SaleDetail;
import java.util.ArrayList;

/**
 *
 * @author fernando
 */
public abstract class SaleDetailServiceAbstract {

    abstract boolean addSaleDetail(String customerType, SaleDetail newSaleDetail);

    abstract void deleteSaleDetail(int idProduct, int idSale);

    abstract ArrayList<SaleDetail> getCartDetails(int idSale);

    abstract SaleDetail modifySaleDetail(String customerType, SaleDetail newSaleDetail);
    
    public final boolean addToCart(String customerType, SaleDetail newSaleDetail)
    {
        SaleDetail tempSaleDetail=modifySaleDetail(customerType,newSaleDetail);
        boolean bandera= addSaleDetail(customerType,newSaleDetail);
        return bandera;
    }
    
}
