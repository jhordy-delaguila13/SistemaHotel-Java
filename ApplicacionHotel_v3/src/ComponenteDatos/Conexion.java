/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ComponenteDatos;
import java.sql.*;
/**
 *
 * @author PRACTICAS-TESIS
 */
public class Conexion {
    public static Conexion instancia;
    public static Conexion getInstancia()
    {
        if(instancia==null)
            instancia= new Conexion();
        return instancia;
    }

    private Conexion() {
    }

    public Connection miConexion() {

        Connection cn =null;

        try {
            Class.forName("com.mysql.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            System.out.println("Error no se puede cargar el driver:" + e.getMessage());
        }

        try {
            String url = "jdbc:mysql://localhost:3306/basehotel";
            String user = "root";
            String password = "";
            cn= DriverManager.getConnection(url, user, password);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return cn;
    }
}
