/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DaoImplementation;

import Connection.Conexion;
import Dao.SaleDetailDao;
import Modelo.SaleDetail;
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
public class SaleDetailImpl implements SaleDetailDao {

    Connection cn = null;
    ResultSet rs = null;
    String query = null;
    Statement stm = null;
    PreparedStatement ps = null;

    @Override
    public void insert(SaleDetail dto) {
        try {
            cn = Conexion.ini();
            query = "INSERT INTO SaleDetail VALUES(?,?,?,?,?)";
            ps = cn.prepareStatement(query);
            ps.setInt(1, dto.getIdProduct());
            ps.setInt(2, dto.getIdSale());
            ps.setInt(3, dto.getQuantity());
            ps.setDouble(4, dto.getDiscount());
            ps.setDouble(5, dto.getSubtotal());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    @Override
    public SaleDetail find(Object fp, Object fs) {
        SaleDetail dto = null;
        try {
            cn = Conexion.ini();
            query = "SELECT * FROM SaleDetail where idProduct='" + (int) fp + "' AND idSale='" + (int) fs + "'";
            stm = cn.createStatement();
            rs = stm.executeQuery(query);
            if (rs.next()) {
                dto = new SaleDetail();
                dto.setIdProduct(rs.getInt(1));
                dto.setIdSale(rs.getInt(2));
                dto.setQuantity(rs.getInt(3));
                dto.setDiscount(rs.getDouble(4));
                dto.setSubtotal(rs.getDouble(5));
            }
            rs.close();
            stm.close();

        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return dto;
    }

    @Override
    public ArrayList<SaleDetail> findBySale(Object f) {
        ArrayList<SaleDetail> dtoList = null;
        try {
            dtoList = new ArrayList<>();
            cn = Conexion.ini();
            query = "SELECT * FROM SaleDetail WHERE idSale='" + (int) f + "'";
            stm = cn.createStatement();
            rs = stm.executeQuery(query);
            while (rs.next()) {
                SaleDetail dto = new SaleDetail();
                dto.setIdProduct(rs.getInt(1));
                dto.setIdSale(rs.getInt(2));
                dto.setQuantity(rs.getInt(3));
                dto.setDiscount(rs.getDouble(4));
                dto.setSubtotal(rs.getDouble(5));
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
    public void update(SaleDetail dto) {
        try {
            cn = Conexion.ini();
            query = "UPDATE SaleDetail set quantity=?,discount=?,subtotal=? where idProduct=? AND idSale=?";
            ps = cn.prepareStatement(query);
            ps.setInt(1, dto.getQuantity());
            ps.setDouble(2, dto.getDiscount());
            ps.setDouble(3, dto.getSubtotal());
            ps.setInt(4, dto.getIdProduct());
            ps.setInt(5, dto.getIdSale());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally {
        }
    }

    @Override
    public void delete(Object dp, Object ds) {
        try {
            cn = Conexion.ini();
            query = "DELETE FROM SaleDetail WHERE idProduct='" + (int) dp + "' AND idSale='" + (int) ds + "'";
            ps = cn.prepareStatement(query);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally {
        }
    }

    @Override
    public void deleteBySale(int idSale) {
        try {
            cn = Conexion.ini();
            query = "DELETE FROM SaleDetail WHERE idSale = ?";
            ps = cn.prepareStatement(query);
            ps.setInt(1, idSale);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
