
package Controlador;

import BD.Conexion;
import Modelo.Carrera;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author USRVI-LC2
 */
public class Registro {
    
    //Guardar datos carrera
    public boolean agregarCarrera(Carrera carrera)
    {
        try {
            
            Conexion con = new Conexion();
            Connection conx = con.obtenerConexion();
            
            String query = "INSERT INTO carrera(nombre) values(?)";
            PreparedStatement stmt = conx.prepareStatement(query);
            stmt.setString(1,carrera.getNombre());
            
            stmt.executeUpdate();
            stmt.close();
            conx.close();
            
            return true;
            
        } catch (SQLException e) {
            System.out.println("Error de SQL : " + e.getMessage());
            return false;
        }
        
    }
    
    
}
