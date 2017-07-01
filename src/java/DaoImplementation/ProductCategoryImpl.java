/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DaoImplementation;

import Connection.Conexion;
import Dao.ProductCategoryDao;
import Modelo.ProductCategory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author fernando
 */
public class ProductCategoryImpl implements ProductCategoryDao {
    
    Connection cn = null;
    ResultSet rs = null;
    String query = null;
    Statement stm = null;
    PreparedStatement ps = null;

    @Override
    public void insert(ProductCategory dto) {
        try {
            cn = Conexion.ini();
            query = "INSERT INTO ProductCategory values(?,?)";
            ps = cn.prepareStatement(query);
            ps.setDouble(1, dto.getIdCategory());
            ps.setDouble(2, dto.getIdProduct());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
}
