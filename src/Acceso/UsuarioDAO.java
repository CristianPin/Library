package Acceso;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuarioDAO {

    public String[] ConsultaUserPass(UsuarioVO UVO) {
        try {
            String[] Nombre = new String[3];
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection Conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/LIBRERIA", "root", "Cazador1");
            PreparedStatement Sentencia = Conexion.prepareStatement("SELECT Name, Pass, UserType FROM Users WHERE (Name = ?) AND (Pass = ?)");
            Sentencia.setString(1, UVO.getName());
            Sentencia.setString(2, UVO.getPass());

            ResultSet datos = Sentencia.executeQuery();

            while (datos.next()) {
                Nombre[0] = datos.getString("Name");
                Nombre[1] = datos.getString("Pass");
                Nombre[2] = datos.getString("UserType");
            }

            Conexion.close();
            return Nombre;
        } catch (Exception e) {
            System.out.println("Error en UsuarioDAO: " + e);
            return null;
        }
    }

    public void RegistroUser(UsuarioVO UVO) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection Conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/LIBRERIA", "root", "Cazador1");
            PreparedStatement Sentencia = Conexion.prepareStatement("INSERT INTO Users (Name, Mail, Pass, UserType) VALUES (?,?,?,'Usuario');");
            Sentencia.setString(1, UVO.getName());
            Sentencia.setString(2, UVO.getMail());
            Sentencia.setString(3, UVO.getPass());
            Sentencia.executeUpdate();
            Sentencia.close();
        } catch (Exception e) {
            System.out.println("Error en RegistroUser" + e);
        }
    }
}
