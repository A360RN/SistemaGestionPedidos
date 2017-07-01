/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Modelo.Sale;
import java.util.ArrayList;

/**
 *
 * @author fernando
 */
public interface SaleDao {
    
    public void insert(Sale dto);
    public Sale find(Object f);
    public ArrayList<Sale> filter(Object f);
    public void update(Sale dto);
    public void delete(Object d);
}
