/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Modelo.Category;
import java.util.ArrayList;

/**
 *
 * @author fernando
 */
public interface CategoryDao {
    public void insert(Category dto);
    public Category find(Object f);
    public ArrayList<Category> filter();
    public void update(Category dto);
    public void delete(Object d);
}
