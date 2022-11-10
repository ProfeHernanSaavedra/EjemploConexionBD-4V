
package Controlador;

import BD.Conexion;
import Modelo.Carrera;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

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
    
    
    public boolean eliminarCarrera(String nombre)
    {
        try {
            
            Conexion con = new Conexion();
            Connection conx = con.obtenerConexion();
            
            String query = "DELETE FROM carrera WHERE nombre = ?";
            PreparedStatement stmt = conx.prepareStatement(query);
            stmt.setString(1,nombre);
            
            stmt.executeUpdate();
            stmt.close();
            conx.close();
            
            return true;
            
        } catch (SQLException e) {
            System.out.println("Error de SQL de Borrar datos tabla: " + e.getMessage());
            return false;
        }
        
    }
    
    public boolean actualizarCarrera(String nombreBuscar,String nombreNew)
    {
        try {
            
            Conexion con = new Conexion();
            Connection conx = con.obtenerConexion();
            
            String query = "UPDATE carrera set nombre = ? where nombre= ?";
            PreparedStatement stmt = conx.prepareStatement(query);
            stmt.setString(1,nombreNew);
            stmt.setString(2, nombreBuscar);
            
            stmt.executeUpdate();
            stmt.close();
            conx.close();
            
            return true;
            
        } catch (SQLException e) {
            System.out.println("Error de SQL de Actualizar datos tabla: " + e.getMessage());
            return false;
        }
        
    }
    
        
    public List<Carrera> buscarCarreras()
    {
        
        List<Carrera> lista = new ArrayList<>();
        
        try {
            
            Conexion con = new Conexion();
            Connection conx = con.obtenerConexion();
            
            String query = "SELECT * FROM carrera order by idCarrera";
            PreparedStatement stmt = conx.prepareStatement(query);
            
            ResultSet rs = stmt.executeQuery();
            
            
            while (rs.next()) {
                Carrera car = new Carrera();
                car.setIdCarrera(rs.getInt("idCarrera"));
                car.setNombre(rs.getString("nombre"));
                
                lista.add(car);
            }
            
            rs.close();
            stmt.close();
            conx.close();
            
        } catch (SQLException e) {
            System.out.println("Error de SQL de Consultar datos tabla: " + e.getMessage());
            
        }
        return lista;
        
    }
    
    public Carrera buscarCarreraPorNombre(String nombre)
    {
        
        Carrera car = new Carrera();
        
        try {
            
            Conexion con = new Conexion();
            Connection conx = con.obtenerConexion();
            
            String query = "SELECT * FROM carrera where nombre = ?";
            PreparedStatement stmt = conx.prepareStatement(query);
            stmt.setString(1, nombre);
            ResultSet rs = stmt.executeQuery();
            
            
            if (rs.next()) {
                
                car.setIdCarrera(rs.getInt("idCarrera"));
                car.setNombre(rs.getString("nombre"));
                
            }
            
            rs.close();
            stmt.close();
            conx.close();
            
        } catch (SQLException e) {
            System.out.println("Error de SQL de Consultar datos tabla carrera por nombre : " + e.getMessage());
            
        }
        return car;
        
    }
    
}
