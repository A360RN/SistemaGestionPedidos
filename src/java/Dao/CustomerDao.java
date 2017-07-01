/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Modelo.Customer;
import java.util.ArrayList;

/**
 *
 * @author fernando
 */
public interface CustomerDao {
    public void insert(Customer dto);
    public Customer find(Object f);
    public ArrayList<Customer> filter();
    public void update(Customer dto);
    public void delete(Object d);
}
