/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Dao.CategoryDao;
import DaoImplementation.CategoryImpl;
import Modelo.Category;
import java.util.ArrayList;

/**
 *
 * @author fernando
 */
public class CategoryBO{

    private CategoryDao categoryDao;
    
    public CategoryBO()
    {
        categoryDao=new CategoryImpl();
    }

    public void insert(Category dto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Category find(Object f) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ArrayList<Category> filter() {
        return categoryDao.filter();
    }

    public void update(Category dto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void delete(Object d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
