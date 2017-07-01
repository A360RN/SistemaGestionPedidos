/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Connection.Conexion;
import Modelo.Sale;
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
public class SaleImpl {

    Connection cn = null;
    ResultSet rs = null;
    String query = null;
    Statement stm = null;
    PreparedStatement ps = null;

    public void insert(Sale dto) {
        try {
            cn = Conexion.ini();
            query = "insert into Sale(saleDate,total,totalDiscount,state,idCustomer) values(current_timestamp(),?,?,?,?)";
            ps = cn.prepareStatement(query);
            ps.setDouble(1, dto.getTotal());
            ps.setDouble(2, dto.getTotalDiscount());
            ps.setString(3, dto.getState());
            ps.setInt(4, dto.getIdCustomer());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    public Sale find(Object f) {
        Sale dto = null;
        try {
            cn = Conexion.ini();
            query = "SELECT * FROM Sale WHERE idSale='" + (int) f+"'";
            stm = cn.createStatement();
            rs = stm.executeQuery(query);
            if (rs.next()) {
                dto = new Sale();
                dto.setIdSale(rs.getInt(1));
                dto.setDateSale(rs.getString(2));
                dto.setTotal(rs.getDouble(3));
                dto.setTotalDiscount(rs.getInt(4));
                dto.setState(rs.getString(5));
                dto.setIdCustomer(rs.getInt(6));
            }
            rs.close();
            stm.close();

        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return dto;
    }

    public ArrayList<Sale> filter(Object f) {
        ArrayList<Sale> dtoList = null;
        try {
            dtoList = new ArrayList<>();
            cn = Conexion.ini();
            query = "SELECT * FROM Sale WHERE idCustomer='" + (int) f+"'";
            stm = cn.createStatement();
            rs = stm.executeQuery(query);
            while (rs.next()) {
                Sale dto = new Sale();
                dto.setIdSale(rs.getInt(1));
                dto.setDateSale(rs.getString(2));
                dto.setTotal(rs.getDouble(3));
                dto.setTotalDiscount(rs.getInt(4));
                dto.setState(rs.getString(5));
                dto.setIdCustomer(rs.getInt(6));
                dtoList.add(dto);
            }
            rs.close();
            stm.close();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return dtoList;
    }

    public void update(Sale dto) {
        try {
            cn = Conexion.ini();
            query = "UPDATE Sale SET saleDate=current_timestamp(),state=?,total=?,totalDiscount=? WHERE idSale=?";
            ps = cn.prepareStatement(query);
            ps.setString(1, dto.getState());
            ps.setDouble(2, dto.getTotal());
            ps.setDouble(3, dto.getTotalDiscount());
            ps.setInt(4, dto.getIdSale());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally {
        }
    }

    public void delete(Object d) {
        try {
            cn = Conexion.ini();
            query = "DELETE FROM Sale WHERE idSale='" + (int) d+"'";
            ps = cn.prepareStatement(query);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally {
        }
    }

}
