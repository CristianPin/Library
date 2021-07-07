package Acceso;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioDAO {

    public String[] Login(UsuarioVO User) {
        try {
            String[] Nombre = new String[2];
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Conectando");
            Connection Conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/LIBRERIA", "root", "Cazador1");
            System.out.println("Conectado");
            System.out.println(User.getName());
            PreparedStatement Sentencia = Conexion.prepareStatement("SELECT Name, Pass FROM Users WHERE (Name = ?) AND (Pass = ?)");
            Sentencia.setString(1, User.getName());
            Sentencia.setString(2, User.getPass());

            ResultSet datos = Sentencia.executeQuery();

            while (datos.next()) {
                Nombre[0] = datos.getString("Name");
                Nombre[1] = datos.getString("Pass");
            }

            Conexion.close();
            return Nombre;
        } catch (Exception e) {
            System.out.println("Error en UsuarioDAO: " + e);
            return null;
        }
    }
}
