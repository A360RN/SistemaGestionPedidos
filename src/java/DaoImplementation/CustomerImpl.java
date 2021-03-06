/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DaoImplementation;

import Connection.Conexion;
import Dao.CustomerDao;
import Modelo.Customer;
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
public class CustomerImpl implements CustomerDao {
    
    Connection cn = null;
    ResultSet rs = null;
    String query = null;
    Statement stm = null;
    PreparedStatement ps = null;
    
    @Override
    public void insert(Customer dto)
    {
        try{
        cn=Conexion.ini();
        query="INSERT INTO Customer(userName,password,dni,ruc,"
                + "firstName,middleName,lastName,lastName2,"
                + "address,email,phoneNumber,customerType)"
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        ps=cn.prepareStatement(query);
        ps.setString(1,dto.getUserName());
        ps.setString(2,dto.getPassword());
        ps.setString(3,dto.getDni());
        ps.setString(4,dto.getRuc());
        ps.setString(5,dto.getFirstName());
        ps.setString(6,dto.getMiddleName());
        ps.setString(7,dto.getLastName());
        ps.setString(8,dto.getLastName2());
        ps.setString(9,dto.getAddress());
        ps.setString(10,dto.getEmail());
        ps.setString(11,dto.getPhoneNumber());
        ps.setString(12,dto.getCustomerType());
        ps.executeUpdate();
        ps.close();
        }catch(SQLException e){
            System.out.println(e.toString());
        }
    }
    

    @Override
    public Customer find(Customer f) {
        Customer dto = null;
        try {
            cn = Conexion.ini();
            query = "SELECT * FROM Customer WHERE userName='" + f.getUserName() +"'";
            stm = cn.createStatement();
            rs = stm.executeQuery(query);
            if (rs.next()) {
                dto = new Customer();
                dto.setIdCustomer(rs.getInt("idCustomer"));
                dto.setUserName(rs.getString("userName"));
                dto.setPassword(rs.getString("password"));
                dto.setDni(rs.getString("dni"));
                dto.setRuc(rs.getString("ruc"));
                dto.setFirstName(rs.getString("firstName"));
                dto.setMiddleName(rs.getString("middleName"));
                dto.setLastName(rs.getString("lastName"));
                dto.setLastName2(rs.getString("lastName2"));
                dto.setAddress(rs.getString("address"));
                dto.setEmail(rs.getString("email"));
                dto.setPhoneNumber(rs.getString("phoneNumber"));
                dto.setCustomerType(rs.getString("customerType"));
            }
            rs.close();
            stm.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dto;
    }

    @Override
    public ArrayList<Customer> filter() {
        ArrayList<Customer> dtoList = null;
        try {
            dtoList = new ArrayList<>();
            cn = Conexion.ini();
            query = "SELECT userName FROM Customer";
            stm = cn.createStatement();
            rs = stm.executeQuery(query);
            while (rs.next()) {
                Customer dto = new Customer();
                dto.setUserName(rs.getString(1));
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
    public void update(Customer dto) {
        try {
            cn = Conexion.ini();
            query = "UPDATE Customer SET address=?,phoneNumber=?,email=? WHERE idCustomer=?";
            ps = cn.prepareStatement(query);
            ps.setString(1, dto.getAddress());
            ps.setString(2, dto.getPhoneNumber());
            ps.setString(3, dto.getEmail());
            ps.setInt(4, dto.getIdCustomer());
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
            query = "DELETE FROM Customer WHERE idCustomer='" + (int) d + "'";
            ps = cn.prepareStatement(query);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally {
        }
    }

}
