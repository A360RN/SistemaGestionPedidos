/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;


/**
 *
 * @author FERNANDO
 */
import com.mysql.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static Connection connection;
    
    private Conexion(){}    

    public static Connection ini(){
        if(connection==null)
        {
            try {
            DriverManager.registerDriver(new Driver());
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/Ventas","root","Mysql@Z");
            
        } catch (SQLException e) {
            System.out.println(
                    "Error al registrar el controlador"
                    + e.getMessage());
        }
        }
        
        return connection;
    }
}
