/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ComponenteDatos;

import ComponenteEntidad.Categoria;
import ComponenteEntidad.Habitacion;
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
public class HabitacionDAO {
    Connection conexion = null;
    private static HabitacionDAO instancia;
    public static HabitacionDAO getInstancia(){
        if(instancia == null)
            instancia = new HabitacionDAO();
        return instancia;
    }
    public void insertar(Habitacion habitacion) throws SQLException {
        conexion = Conexion.getInstancia().miConexion();
        PreparedStatement ps=null;
        try {
            ps = conexion.prepareStatement("INSERT INTO Habitacion " +
                    "(idHabitacion" +
                    ",Numero" +
                    ",Estado" +
                    ",Costo" +
                    ",Descripcion" +
                    ",Tipo_idTipo)"+
                    "VALUES (?,?,?,?,?,?)");
            ps.setString(1, habitacion.getIdHabitacion());
            ps.setInt(2, habitacion.getNumero());
            ps.setString(3, habitacion.getEstado());
            ps.setDouble(4, habitacion.getCosto());
            ps.setString(5, habitacion.getDescripcion());
            ps.setString(6, habitacion.getCategoria().getIdCategoria());
            ps.executeUpdate();
        } catch (SQLException ex) {
            throw ex;
        } finally {
            conexion.close();
            ps.close();
        }
    }
    public void modificar(Habitacion habitacion) throws SQLException {
        conexion = Conexion.getInstancia().miConexion();
        PreparedStatement ps = null;
        try {
            ps = conexion.prepareStatement("UPDATE Habitacion set " +
                    " Numero = ?" +
                    ",Estado = ?" +
                    ",Costo = ?" +
                    ",Descripcion = ?" +
                    ",Tipo_idTipo = ?"+
                    " where idHabitacion = ?");
            ps.setString(1, habitacion.getIdHabitacion());
            ps.setInt(2, habitacion.getNumero());
            ps.setString(3, habitacion.getEstado());
            ps.setDouble(4, habitacion.getCosto());
            ps.setString(5, habitacion.getDescripcion());
            ps.setString(6, habitacion.getCategoria().getNombre());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            conexion.close();
            ps.close();
        }
    }
    
    public void actualizarEstado(Habitacion habitacion) throws SQLException {
        conexion = Conexion.getInstancia().miConexion();
        PreparedStatement ps = null;
        String sentenciaSQL = "UPDATE Habitacion set Estado = ?" +
                    " where idHabitacion = ?";
        try {
            ps = conexion.prepareStatement(sentenciaSQL);
            ps.setString(2, habitacion.getIdHabitacion());
            ps.setString(1, habitacion.getEstado());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            conexion.close();
            ps.close();
        }
    }
    public void eliminar(Habitacion habitacion) throws SQLException {
         conexion = Conexion.getInstancia().miConexion();
        PreparedStatement sentencia = null;
        String sentenciaSQL = "delete from Habitacion where idHabitacion = ?";
        try {
            sentencia = conexion.prepareStatement(sentenciaSQL);
            sentencia.setString(1, habitacion.getIdHabitacion());
            sentencia.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            conexion.close();
            sentencia.close();
        }
    }
    public List<Habitacion> buscarPorEstado(String estado) throws SQLException {
        conexion = Conexion.getInstancia().miConexion();
        List<Habitacion> habitaciones = new ArrayList<>();
        Habitacion habitacion;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        String sentenciaSQL = "select idHabitacion,Numero,Estado,"
                + " Costo,Descripcion, Tipo_idTipo "
                + " from Habitacion where estado = '" + estado +"'";
        try {
            sentencia = conexion.prepareStatement(sentenciaSQL);
            resultado = sentencia.executeQuery();
            while(resultado.next()){
                habitacion = new Habitacion();
                habitacion.setIdHabitacion(resultado.getString("idHabitacion"));
                habitacion.setNumero(resultado.getInt("Numero"));
                habitacion.setEstado(resultado.getString("Estado"));
                habitacion.setCosto(resultado.getDouble("Costo"));
                habitacion.setDescripcion(resultado.getString("Descripcion"));
                String idCategoria = resultado.getString("Tipo_idTipo");
                Categoria categoria = CategoriaDAO.getInstancia().buscarPorCodigo(idCategoria);
                habitacion.setCategoria(categoria);
                habitaciones.add(habitacion);
            }
        } catch (Exception e) {
            throw e;
        }finally{
            conexion.close();
            sentencia.close();
            resultado.close();
        }
        return habitaciones;
    }
     public Habitacion buscarPorCodigo(String idHabitacion) throws SQLException {
        conexion = Conexion.getInstancia().miConexion();
        Habitacion habitacion = null;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        String sentenciaSQL = "select idHabitacion,Numero,Estado,"
                + " Costo,Descripcion"
                + " from Habitacion "
                + " where idHabitacion = '" + idHabitacion + "'";
        try {
            sentencia = conexion.prepareStatement(sentenciaSQL);
            resultado = sentencia.executeQuery();
            if(resultado.next()){
                habitacion = new Habitacion();
                habitacion.setIdHabitacion(resultado.getString("idHabitacion"));
                habitacion.setNumero(resultado.getInt("Numero"));
                habitacion.setEstado(resultado.getString("Estado"));
                habitacion.setCosto(resultado.getDouble("Costo"));
                habitacion.setDescripcion(resultado.getString("Descripcion"));
            }
        } catch (Exception e) {
            throw e;
        }finally{
            conexion.close();
            sentencia.close();
            resultado.close();
        }
        return habitacion;
    }
    
}
