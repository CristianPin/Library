package Acceso;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioDAO {

    public String Login(UsuarioVO User) {
        try {
            String Nombre = "";
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Conectando");
            Connection Conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/LIBRERIA","root","Cazador1");
            System.out.println("Conectado");
            PreparedStatement Sentencia = Conexion.prepareStatement("SELECT Name FROM Users WHERE Name = ?");
            Sentencia.setString(1, User.getName());
            
            ResultSet datos = Sentencia.executeQuery();
            
            while (datos.next()) {
                 Nombre = datos.getString("Name");
            }
            Conexion.close();
            return Nombre;
        } catch (Exception e) {
            System.out.println("Error en UsuarioDAO: " + e);
            return null;
        }
    }
}
