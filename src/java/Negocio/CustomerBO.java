/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Dao.CustomerDao;
import DaoImplementation.CustomerImpl;
import Modelo.Customer;
import java.util.ArrayList;

/**
 *
 * @author fernando
 */
public class CustomerBO{

    private CustomerDao customerDao;
    public CustomerBO()
    {
        customerDao= new CustomerImpl();
    }
    public void insert(Customer dto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Customer find(Object f) {
        return customerDao.find((Customer) f);
    }

    public ArrayList<Customer> filter() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void update(Customer dto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void delete(Object d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public boolean login(Customer c){
        String possiblePassword = c.getPassword();
        
        Customer user = customerDao.find(c);
        String realPassword = "";
        
        if(user != null){
            realPassword = user.getPassword();
        }
        
        if(realPassword.equals(possiblePassword)){
            return true;
        }
        return false;            
    }
    
}
