/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Modelo.SaleDetail;
import java.util.ArrayList;

/**
 *
 * @author fernando
 */
public interface SaleDetailDao {

    public void insert(SaleDetail dto);
    public SaleDetail find(Object fp,Object fs);
    public ArrayList<SaleDetail> filter(Object f);
    public void update(SaleDetail dto);
    public void delete(Object dp,Object ds);

}
