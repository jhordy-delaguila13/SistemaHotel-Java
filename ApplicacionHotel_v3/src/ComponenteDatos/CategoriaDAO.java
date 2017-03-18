/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ComponenteDatos;

import ComponenteEntidad.Categoria;
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
public class CategoriaDAO {
    
    Connection conexion = null;
    private static CategoriaDAO instancia;
    public static CategoriaDAO getInstancia(){
        if(instancia == null)
            instancia = new CategoriaDAO();
        return instancia;
    }
    public int insertar(Categoria categoria) throws SQLException {
        conexion = Conexion.getInstancia().miConexion();
        PreparedStatement ps=null;
        try {
            ps = conexion.prepareStatement("INSERT INTO Categoria " +
                    "(idCategoria" +
                    ",Descripcion" +
                    ",nombre)" +
                    "VALUES (?,?,?)");
            ps.setString(1, categoria.getIdCategoria());
            ps.setString(2, categoria.getDescripcion());
            ps.setString(3, categoria.getNombre());
            return ps.executeUpdate();
        } catch (SQLException ex) {
            throw ex;
        } finally {
            conexion.close();
            ps.close();
        }
    }
    public int eliminar(Categoria categoria) throws SQLException {
         conexion = Conexion.getInstancia().miConexion();
        PreparedStatement sentencia = null;
        String sentenciaSQL = "delete from Categoria where idCategoria = ?";
        try {
            sentencia = conexion.prepareStatement(sentenciaSQL);
            sentencia.setString(1, categoria.getIdCategoria());
            return sentencia.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            conexion.close();
            sentencia.close();
        }
    }
     public Categoria buscarPorCodigo(String idCategoria) throws SQLException {
        conexion = Conexion.getInstancia().miConexion();
        Categoria categoria = null;
        PreparedStatement sentencia = null;
         ResultSet resultado = null;
        String sentenciaSQL = "select idCategoria,Descripcion,nombre"
                +" from Categoria"
                + " where idCategoria = '" + idCategoria + "'";
        try {
            sentencia = conexion.prepareStatement(sentenciaSQL);
            resultado = sentencia.executeQuery();
            if(resultado.next()){
                categoria = new Categoria();
                categoria.setIdCategoria(resultado.getString("idCategoria"));
                categoria.setDescripcion(resultado.getString("Descripcion"));
                categoria.setNombre(resultado.getString("nombre"));
            }
        } catch (Exception e) {
            throw e;
        }finally{
            conexion.close();
            sentencia.close();
            resultado.close();
        }
        return categoria;
    }
     public Categoria buscarPorTipo(String nombre) throws SQLException {
        conexion = Conexion.getInstancia().miConexion();
        Categoria categoria = null;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        String sentenciaSQL = "select idCategoria,Descripcion,nombre"
                + " from Categoria where nombre = '" + nombre +"'";
        try {
            sentencia = conexion.prepareStatement(sentenciaSQL);
            resultado = sentencia.executeQuery();
            if(resultado.next()){
                categoria = new Categoria();
                categoria.setIdCategoria(resultado.getString("idCategoria"));
                categoria.setDescripcion(resultado.getString("Descripcion"));
                categoria.setNombre(resultado.getString("nombre"));
            }
        } catch (Exception e) {
            throw e;
        }finally{
            conexion.close();
            sentencia.close();
            resultado.close();
        }
        return categoria;
    }
    
     public List<Categoria> listado() throws SQLException {
        conexion = Conexion.getInstancia().miConexion();
        List<Categoria> ciudades = new ArrayList<>();
        Categoria categoria = null;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        String sentenciaSQL = "select idCategoria,Descripcion,nombre"
                + " from Categoria ";
        try {
            sentencia = conexion.prepareStatement(sentenciaSQL);
            resultado = sentencia.executeQuery();
            while(resultado.next()){
                categoria = new Categoria();
                categoria.setIdCategoria(resultado.getString("idCategoria"));
                categoria.setDescripcion(resultado.getString("Descripcion"));
                categoria.setNombre(resultado.getString("nombre"));
                ciudades.add(categoria);
            }
        } catch (Exception e) {
            throw e;
        }finally{
            conexion.close();
            sentencia.close();
            resultado.close();
        }
        return ciudades;
    }
    
}
