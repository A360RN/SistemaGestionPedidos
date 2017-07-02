/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Modelo.Product;
import java.util.ArrayList;

/**
 *
 * @author fernando
 */
public interface ProductDao {
    
    public void insert(Product dto);
    public Product find(Object f);
    public ArrayList<Product> filter();
    public ArrayList<Product> filterByCategory(Object f);
    public ArrayList<Product> filterByOrder(int idSale);
    public ArrayList<Product> filterBySales();
    public void update(Product dto);
    public void delete(Object d);
}
