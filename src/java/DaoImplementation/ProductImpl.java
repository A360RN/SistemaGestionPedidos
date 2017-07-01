/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DaoImplementation;

import Connection.Conexion;
import Dao.ProductDao;
import Modelo.Product;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author fernando
 */
public class ProductImpl implements ProductDao{

    Connection cn = null;
    ResultSet rs = null;
    String query = null;
    Statement stm = null;
    PreparedStatement ps = null;

    @Override
     public void insert(Product dto) {
        try {
            cn = Conexion.ini();
            query = "INSERT INTO Product VALUES(?,?,?,?,?,?)";
            ps = cn.prepareStatement(query);
            ps.setInt(1, dto.getIdProduct());
            ps.setString(2, dto.getName());
            ps.setString(3, dto.getDescription());
            ps.setDouble(4, dto.getPrice());
            ps.setInt(5, dto.getStock());
            ps.setString(6, dto.getImage());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
     
    @Override
    public Product find(Object f) {
        Product dto = null;
        try {
            cn = Conexion.ini();
            query = "SELECT * FROM Product WHERE idProduct='" + (int) f + "'";
            stm = cn.createStatement();
            rs = stm.executeQuery(query);
            if (rs.next()) {
                dto = new Product();
                dto.setIdProduct(rs.getInt(1));
                dto.setName(rs.getString(2));
                dto.setDescription(rs.getString(3));
                dto.setPrice(rs.getDouble(4));
                dto.setStock(rs.getInt(5));
                dto.setImage(rs.getString(6));
            }
            rs.close();
            stm.close();

        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return dto;
    }

    @Override
    public ArrayList<Product> filter() {
        ArrayList<Product> dtoList = null;
        try {
            dtoList = new ArrayList<>();
            cn = Conexion.ini();
            query = "SELECT * FROM Product ORDER BY name ASC";
            stm = cn.createStatement();
            rs = stm.executeQuery(query);
            while (rs.next()) {
                Product dto = new Product();
                dto.setIdProduct(rs.getInt(1));
                dto.setName(rs.getString(2));
                dto.setDescription(rs.getString(4));
                dto.setPrice(rs.getDouble(4));
                dto.setStock(rs.getInt(5));
                dto.setImage(rs.getString(6));
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
    public ArrayList<Product> filterByCategory(Object f) {
        ArrayList<Product> dtoList = null;
        try {
            dtoList = new ArrayList<>();
            cn = Conexion.ini();
            query = "select p.idProduct,p.name,p.description,p.price,p.stock,p.image from"
                    + " Product p,ProductCategory pc where pc.idCategory='"+(int) f+"' AND p.idProduct=pc.idProduct";
            stm = cn.createStatement();
            rs = stm.executeQuery(query);
            while (rs.next()) {
                Product dto = new Product();
                dto.setIdProduct(rs.getInt(1));
                dto.setName(rs.getString(2));
                dto.setDescription(rs.getString(3));
                dto.setPrice(rs.getDouble(4));
                dto.setStock(rs.getInt(5));
                dto.setImage(rs.getString(6));
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
    public ArrayList<Product> filterBySales() {
        ArrayList<Product> dtoList = null;
        try {
            dtoList = new ArrayList<>();
            cn = Conexion.ini();
            query = "SELECT *,IFNULL((Select SUM(sd.quantity) FROM SaleDetail sd "
                    + "WHERE idProduct=p.idProduct GROUP BY idProduct),0) AS saleTotal "
                    + "FROM Product p ORDER BY saleTotal DESC";
            stm = cn.createStatement();
            rs = stm.executeQuery(query);
            while (rs.next()) {
                Product dto = new Product();
                dto.setIdProduct(rs.getInt(1));
                dto.setName(rs.getString(2));
                dto.setDescription(rs.getString(3));
                dto.setPrice(rs.getDouble(4));
                dto.setStock(rs.getInt(5));
                dto.setImage(rs.getString(6));
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
    public void update(Product dto) {
        try {
            cn = Conexion.ini();
            query = "UPDATE Product SET stock=?" + " WHERE idProduct=?";
            ps = cn.prepareStatement(query);
            ps.setInt(1, dto.getStock());
            ps.setInt(2, dto.getIdProduct());
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
            query = "DELETE FROM Product WHERE idProduct='" + (int) d + "'";
            ps = cn.prepareStatement(query);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally {
        }
    }
}
