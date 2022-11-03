package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author USRVI-LC2
 */
public class Conexion {
    
    public Connection obtenerConexion()
    {
        Connection con = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/duoc2","root","");
            System.out.println("Conexion exitosa!!");
            
            
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error de conexion: " + e.getMessage());
        }
        return con;
    }
    
    
}
