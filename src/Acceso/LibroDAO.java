package Acceso;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class LibroDAO {
    
    public ArrayList<LibroVO> ConsultarLibros(){
        try {
            ArrayList<LibroVO> Libros = new ArrayList();
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection Conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/LIBRERIA", "root", "Cazador1");
            PreparedStatement Sentencia = Conexion.prepareStatement("SELECT * FROM BOOK");
            ResultSet datos = Sentencia.executeQuery();
            
            while (datos.next()) {
                LibroVO Libro = new LibroVO();
                Libro.setID_Book(datos.getInt("ID_Book"));
                Libro.setNombre(datos.getString("Nombre"));
                Libro.setCantidad(datos.getInt("Cant"));
                Libro.setCant_Rev(datos.getInt("Cant_Rev"));
                Libro.setPrice(datos.getInt("Price"));
                Libros.add(Libro);
            }
            Conexion.close();
            return Libros;
        } catch (Exception ex) {
            System.out.println(""+ex);
            return null;
        }
    }
    
    public int ModificarLibro(LibroVO LVO){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection Conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/LIBRERIA", "root", "Cazador1");
            PreparedStatement Sentencia = Conexion.prepareStatement("UPDATE Book SET Nombre=?, Price=?,Cant=?, Cant_Rev=?  WHERE  ID_Book = ?");
            Sentencia.setString(1, LVO.getNombre());
            Sentencia.setInt(2, LVO.getPrice());
            Sentencia.setInt(3, LVO.getCantidad());
            Sentencia.setInt(4,LVO.getCant_Rev());
            Sentencia.setInt(5, LVO.getID_Book());
            int datos = Sentencia.executeUpdate();
            Sentencia.close();
            return datos;
            
        } catch (Exception ex) {
            System.out.println(""+ex);
            return 0;
        }
    }
    
    public void CrearLibro(LibroVO LVO){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection Conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/LIBRERIA", "root", "Cazador1");
            PreparedStatement Sentencia = Conexion.prepareStatement("INSERT INTO Book (Nombre, Cant,Cant_Rev, Price) VALUES (?,?,?,?)");
            Sentencia.setString(1, LVO.getNombre());
            Sentencia.setInt(2, LVO.getCantidad());
            Sentencia.setInt(3, LVO.getCant_Rev());
            Sentencia.setInt(4, LVO.getPrice());
            Sentencia.executeUpdate();
            Sentencia.close();
            
        } catch (Exception ex) {
            System.out.println(""+ex);
        }
        
    }
    
}
