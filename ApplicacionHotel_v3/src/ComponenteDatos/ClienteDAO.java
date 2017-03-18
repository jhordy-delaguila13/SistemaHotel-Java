/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ComponenteDatos;

import ComponenteEntidad.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PRACTICAS-TESIS
 */
public class ClienteDAO {
     Connection conexion = null;
    private static ClienteDAO instancia;
    public static ClienteDAO getInstancia(){
        if(instancia == null)
            instancia = new ClienteDAO();
        return instancia;
    }
     public void insertar(Cliente clientes) throws SQLException {
        conexion = Conexion.getInstancia().miConexion();
        PreparedStatement ps=null;
        try {
            ps = conexion.prepareStatement("INSERT INTO Cliente " +
                    "(idCliente" +
                    ",Nombre" +
                    ",Apellidos" +
                    ",Direccion" +
                    ",telefono" +
                    ",Nacionalidad"+
                    ",DNI)"+
                    "VALUES (?,?,?,?,?,?,?)");
            ps.setString(1, clientes.getIdCliente());
            ps.setString(2, clientes.getNombre());
            ps.setString(3, clientes.getApellidos());
            ps.setString(4, clientes.getDireccion());
            ps.setString(5, clientes.getTelefono());
            ps.setString(6, clientes.getNacionalidad());
            ps.setString(7, clientes.getDNI());
            ps.executeUpdate();
        } catch (SQLException ex) {
            throw ex;
        } finally {
            conexion.close();
            ps.close();
        }
    }
    
    public void modificar(Cliente clientes) throws SQLException {
        conexion = Conexion.getInstancia().miConexion();
        PreparedStatement ps = null;
        try {
            ps = conexion.prepareStatement("UPDATE Cliente set " +
                    " Nombre = ? " +
                    ",Apellidos = ? " +
                    ",Direccion = ? " +
                    ",telefono = ? " +
                    ",Nacionalidad = ? "+
                    ",DNI = ? "+
                    " where idcliente = ? ");
            ps.setString(7, clientes.getIdCliente());
            ps.setString(1, clientes.getNombre());
            ps.setString(2, clientes.getApellidos());
            ps.setString(3, clientes.getDireccion());
            ps.setString(4, clientes.getTelefono());
            ps.setString(5, clientes.getNacionalidad());
            ps.setString(6, clientes.getDNI());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            conexion.close();
            ps.close();
        }
    }
    public int eliminar(Cliente clientes) throws SQLException {
         conexion = Conexion.getInstancia().miConexion();
        PreparedStatement sentencia = null;
        String sentenciaSQL = "delete from Cliente where idCliente = ?";
        try {
            sentencia = conexion.prepareStatement(sentenciaSQL);
            sentencia.setString(1, clientes.getIdCliente());
            return sentencia.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            conexion.close();
            sentencia.close();
        }
    }
    public List<Cliente> buscar(String nombre) throws SQLException {
        conexion = Conexion.getInstancia().miConexion();
        List<Cliente> cliente = new ArrayList<>();
        Cliente clientes;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        String sentenciaSQL = "select idCliente,Nombre,Apellidos,"
                + " Direccion,telefono,Nacionalidad,DNI from Cliente "
                + " where Nombre like '%" + nombre + "%'";
        try {
            sentencia = conexion.prepareStatement(sentenciaSQL);
            resultado = sentencia.executeQuery();
            while(resultado.next()){
                clientes = new Cliente();
                clientes.setIdCliente(resultado.getString("idCliente"));
                clientes.setNombre(resultado.getString("Nombre"));
                clientes.setApellidos(resultado.getString("Apellidos"));
                clientes.setDireccion(resultado.getString("Direccion"));
                clientes.setTelefono(resultado.getString("telefono"));
                clientes.setNacionalidad(resultado.getString("Nacionalidad"));
                clientes.setDNI(resultado.getString("DNI"));
                cliente.add(clientes);
            }
        } catch (Exception e) {
            throw e;
        }finally{
            conexion.close();
            sentencia.close();
            resultado.close();
        }
        return cliente;
    }
    public Cliente buscarPorCodigo(String idCliente) throws SQLException {
        conexion = Conexion.getInstancia().miConexion();
        Cliente clientes = null;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        String sentenciaSQL = "select idCliente,Nombre,Apellidos,"
                + " Direccion,telefono,Nacionalidad,DNI from Cliente "
                + " where idCliente = '" + idCliente + "'";
        try {
            sentencia = conexion.prepareStatement(sentenciaSQL);
            resultado = sentencia.executeQuery();
            if(resultado.next()){
                clientes = new Cliente();
                clientes.setIdCliente(resultado.getString("idCliente"));
                clientes.setNombre(resultado.getString("Nombre"));
                clientes.setApellidos(resultado.getString("Apellidos"));
                clientes.setDireccion(resultado.getString("Direccion"));
                clientes.setTelefono(resultado.getString("telefono"));
                clientes.setNacionalidad(resultado.getString("Nacionalidad"));
                clientes.setDNI(resultado.getString("DNI"));
            }
        } catch (Exception e) {
            throw e;
        }finally{
            conexion.close();
            sentencia.close();
            resultado.close();
        }
        return clientes;
    }
    public Cliente buscarPorDni(String dni) throws SQLException {
        conexion = Conexion.getInstancia().miConexion();
        Cliente cliente = null;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        String sentenciaSQL = "select idCliente,Nombre,Apellidos,"
                + " Direccion,telefono,Nacionalidad,DNI "
                + " from Cliente "
                + " where DNI = '" + dni + "'";
        try {
            sentencia = conexion.prepareStatement(sentenciaSQL);
            resultado = sentencia.executeQuery();
            if(resultado.next()){
                cliente = new Cliente();
                cliente.setIdCliente(resultado.getString("idCliente"));
                cliente.setNombre(resultado.getString("Nombre"));
                cliente.setApellidos(resultado.getString("Apellidos"));
                cliente.setDireccion(resultado.getString("Direccion"));
                cliente.setTelefono(resultado.getString("telefono"));
                cliente.setNacionalidad(resultado.getString("Nacionalidad"));
                cliente.setDNI(resultado.getString("DNI"));
            }
        } catch (Exception e) {
            throw e;
        }finally{
            conexion.close();
            sentencia.close();
            resultado.close();
        }
        return cliente;
}
}
