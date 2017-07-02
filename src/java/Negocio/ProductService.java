/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Dao.ProductDao;
import DaoImplementation.ProductImpl;
import Modelo.Product;
import java.util.ArrayList;

/**
 *
 * @author fernando
 */
public class ProductService{
    private  ProductDao productDao;
    
    public ProductService()
    {
        productDao=new ProductImpl();
    }

    public void insert(Product dto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Product find(Object f) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ArrayList<Product> filter() {
        return productDao.filter();
    }

    public ArrayList<Product> filterByCategory(Object f) {
        return productDao.filterByCategory(f);
    }

    public ArrayList<Product> filterBySales() {
        return productDao.filterBySales();
    }

    public void update(Product dto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void delete(Object d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
