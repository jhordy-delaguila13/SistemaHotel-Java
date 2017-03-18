/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ComponenteDatos;

import ComponenteEntidad.Recepcionista;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rita
 */
public class RecepcionistaDAO {
    Connection conexion = null;
    private static RecepcionistaDAO instancia;
    public static RecepcionistaDAO getInstancia(){
        if(instancia == null)
            instancia = new RecepcionistaDAO();
        return instancia;
    }
    public void insertar(Recepcionista re) throws SQLException {
        conexion = Conexion.getInstancia().miConexion();
        PreparedStatement ps=null;
        try {
            ps = conexion.prepareStatement("INSERT INTO Recepcionista " +
                    "(idRecepcionista" +
                    ",Nombre" +
                    ",Apellidos" +
                    ",Direccion" +
                    ",DNI" +
                    ",Telefono"+
                    ",Correo)"+
                    "VALUES (?,?,?,?,?,?,?)");
            ps.setString(1, re.getIdRecepcionista());
            ps.setString(2, re.getNombres());
            ps.setString(3, re.getApellidos());
            ps.setString(4, re.getDireccion());
            ps.setString(5, re.getDNI());
            ps.setString(6, re.getTelefono());
            ps.setString(7, re.getCorreo());
            ps.executeUpdate();
        } catch (SQLException ex) {
            throw ex;
        } finally {
            conexion.close();
            ps.close();
        }
    }
    public void modificar(Recepcionista re) throws SQLException {
        conexion = Conexion.getInstancia().miConexion();
        PreparedStatement ps = null;
        try {
            ps = conexion.prepareStatement("UPDATE Recepcionista set " +
                    " Nombre = ?" +
                    ",Apellidos = ?" +
                    ",Direccion = ?" +
                    ",DNI = ?" +
                    ",Telefono = ?"+
                    ",Correo = ?"+
                    " where idRecepcionista = ?");
             ps.setString(7, re.getIdRecepcionista());
            ps.setString(1, re.getNombres());
            ps.setString(2, re.getApellidos());
            ps.setString(3, re.getDireccion());
            ps.setString(4, re.getDNI());
            ps.setString(5, re.getTelefono());
            ps.setString(6, re.getCorreo());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            conexion.close();
            ps.close();
        }
    }
    public void eliminar(Recepcionista re) throws SQLException {
         conexion = Conexion.getInstancia().miConexion();
        PreparedStatement sentencia = null;
        String sentenciaSQL = "delete from Recepcionista where idRecepcionista = ?";
        try {
            sentencia = conexion.prepareStatement(sentenciaSQL);
            sentencia.setString(1, re.getIdRecepcionista());
            sentencia.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            conexion.close();
            sentencia.close();
        }
    }
    public List<Recepcionista> buscar(String nombre) throws SQLException {
        conexion = Conexion.getInstancia().miConexion();
        List<Recepcionista> re = new ArrayList<>();
        Recepcionista rec;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        String sentenciaSQL = "select idRecepcionista,Nombre,Apellidos,"
                + " Direccion,DNI,Telefono,Correo from Recepcionista "
                + " where Nombre like '%" + nombre + "%'";
        try {
            sentencia = conexion.prepareStatement(sentenciaSQL);
            resultado = sentencia.executeQuery();
            while(resultado.next()){
                rec = new Recepcionista();
                rec.setIdRecepcionista(resultado.getString("idRecepcionista"));
                rec.setNombres(resultado.getString("Nombre"));
                rec.setApellidos(resultado.getString("Apellidos"));
                rec.setDireccion(resultado.getString("Direccion"));
                rec.setDNI(resultado.getString("DNI"));
                rec.setTelefono(resultado.getString("Telefono"));
                rec.setCorreo(resultado.getString("Correo"));
                re.add(rec);
            }
        } catch (Exception e) {
            throw e;
        }finally{
            conexion.close();
            sentencia.close();
            resultado.close();
        }
        return re;
    }
    public Recepcionista buscarPorCodigo(String idRecepcionista) throws SQLException {
        conexion = Conexion.getInstancia().miConexion();
        Recepcionista rec = null;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        String sentenciaSQL = "select idRecepcionista,Nombre,Apellidos,"
                + " Direccion,DNI,Telefono,Correo from Recepcionista "
                + " where idRecepcionista = '" + idRecepcionista + "'";
        try {
            sentencia = conexion.prepareStatement(sentenciaSQL);
            resultado = sentencia.executeQuery();
            if(resultado.next()){
                rec = new Recepcionista();
                rec.setIdRecepcionista(resultado.getString("idRecepcionista"));
                rec.setNombres(resultado.getString("Nombre"));
                rec.setApellidos(resultado.getString("Apellidos"));
                rec.setDireccion(resultado.getString("Direccion"));
                rec.setDNI(resultado.getString("DNI"));
                rec.setTelefono(resultado.getString("Telefono"));
                rec.setCorreo(resultado.getString("Correo"));
            }
        } catch (Exception e) {
            throw e;
        }finally{
            conexion.close();
            sentencia.close();
            resultado.close();
        }
        return rec;
    }
    public Recepcionista buscarPorDni(String dni) throws SQLException {
        conexion = Conexion.getInstancia().miConexion();
        Recepcionista rec = null;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        String sentenciaSQL = "select idRecepcionista,Nombre,Apellidos,"
                + " Direccion,DNI,Telefono,Correo "
                + " from Recepcionista "
                + " where DNI = '" + dni + "'";
        try {
            sentencia = conexion.prepareStatement(sentenciaSQL);
            resultado = sentencia.executeQuery();
            if(resultado.next()){
                rec = new Recepcionista();
                rec.setIdRecepcionista(resultado.getString("idRecepcionista"));
                rec.setNombres(resultado.getString("Nombre"));
                rec.setApellidos(resultado.getString("Apellidos"));
                rec.setDireccion(resultado.getString("Direccion"));
                rec.setDNI(resultado.getString("DNI"));
                rec.setTelefono(resultado.getString("Telefono"));
                rec.setCorreo(resultado.getString("Correo"));
            }
        } catch (Exception e) {
            throw e;
        }finally{
            conexion.close();
            sentencia.close();
            resultado.close();
        }
        return rec;
}
    
}
