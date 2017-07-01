/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DaoImplementation;

import Connection.Conexion;
import Dao.CategoryDao;
import Modelo.Category;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author fernando
 */
public class CategoryImpl implements CategoryDao{

    Connection cn = null;
    ResultSet rs = null;
    String query = null;
    Statement stm = null;
    PreparedStatement ps = null;

    @Override
    public void insert(Category dto) {
        try {
            cn = Conexion.ini();
            query = "INSERT INTO Category  VALUES(?,?,?)";
            ps = cn.prepareStatement(query);
            ps.setInt(1, dto.getIdCategory());
            ps.setString(2, dto.getName());
            ps.setString(3, dto.getDescription());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    @Override
    public Category find(Object f) {
        Category dto = null;
        try {
            cn = Conexion.ini();
            query = "SELECT * FROM Category WHERE name='" + (String) f+"'";
            stm = cn.createStatement();
            rs = stm.executeQuery(query);
            if (rs.next()) {
                dto = new Category();
                dto.setIdCategory(rs.getInt(1));
                dto.setName(rs.getString(2));
                dto.setDescription(rs.getString(3));
            }
            rs.close();
            stm.close();

        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return dto;
    }

    @Override
    public ArrayList<Category> filter() {
        ArrayList<Category> dtoList = null;
        try {
            dtoList = new ArrayList<>();
            cn = Conexion.ini();
            query = "SELECT * FROM Category";
            stm = cn.createStatement();
            rs = stm.executeQuery(query);
            while (rs.next()) {
                Category dto = new Category();
                dto.setIdCategory(rs.getInt(1));
                dto.setName(rs.getString(2));
                dto.setDescription(rs.getString(3));
                dtoList.add(dto);
            }
            rs.close();
            stm.close();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return dtoList;
    }

    @Override
   public void update(Category dto) {
        try {
            cn = Conexion.ini();
            query = "UPDATE Category SET description=?" + " WHERE idCategory=?";
            ps = cn.prepareStatement(query);
            ps.setString(1, dto.getDescription());
            ps.setInt(2, dto.getIdCategory());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally {
        }
    }

    @Override
    public void delete(Object d) {
        try {
            cn = Conexion.ini();
            query = "DELETE FROM Category WHERE idCategory='" + (int) d + "'";
            ps = cn.prepareStatement(query);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally {
        }
    }

}
