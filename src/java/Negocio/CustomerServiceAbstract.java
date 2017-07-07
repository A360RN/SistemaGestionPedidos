/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Modelo.Customer;
import java.util.ArrayList;

/**
 *
 * @author fernando
 */
public abstract class CustomerServiceAbstract {

    public abstract void insert(Customer dto);

    public abstract Customer find(Object f);

    public abstract ArrayList<Customer> filter();

    public abstract void update(Customer dto);
    
    public abstract void delete(Object d);
    
    public abstract boolean login(Customer c);
    
    public abstract boolean userExists(Customer newUser);
    
    public final Customer findAndUpdate(Customer dto)
    {
        update(dto);
        dto = find(dto);
        return dto;
    }
    
    
}
