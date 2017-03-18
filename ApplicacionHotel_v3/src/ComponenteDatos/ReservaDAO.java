/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ComponenteDatos;

import ComponenteEntidad.Cliente;
import ComponenteEntidad.Habitacion;
import ComponenteEntidad.Recepcionista;
import ComponenteEntidad.Reserva;
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
public class ReservaDAO {
    Connection conexion = null;
    private static ReservaDAO instancia;
    public static ReservaDAO getInstancia(){
        if(instancia == null)
            instancia = new ReservaDAO();
        return instancia;
    }
     public void insertar(Reserva reserva) throws SQLException {
        conexion = Conexion.getInstancia().miConexion();
        int registros_afectados;
         PreparedStatement ps = null;
         String senteciaSQL = "insert into reserva(idReserva,fechaEntrada,costoTotal,"
                 + "idRecepcionista,idCliente) values(?,?,?,?,?)";
        try {
            ps = conexion.prepareStatement(senteciaSQL);
            ps.setString(1, reserva.getIdReserva());
            ps.setDate(2, reserva.getFecha());
            ps.setDouble(3, reserva.getCostoTotal());
            ps.setString(4, reserva.getRecepcionista().getIdRecepcionista());
            ps.setString(5, reserva.getCliente().getIdCliente());
            ps.executeUpdate();
            
            String senteciaSQL_detalle = "insert into Reserva_has_Habitacion (idreserva,idhabitacion)"
                    + " values(?,?)";
            for(Habitacion habitacion : reserva.getHabitaciones()){
                PreparedStatement sentencia = conexion.prepareStatement(senteciaSQL_detalle);
                sentencia.setString(1, reserva.getIdReserva());
                sentencia.setString(2, habitacion.getIdHabitacion());
                registros_afectados = sentencia.executeUpdate();
                if(registros_afectados == 1){
                    HabitacionDAO.getInstancia().actualizarEstado(habitacion);
                }
            }
        } catch (SQLException ex) {
            throw ex;
        } finally {
            conexion.close();
            ps.close();
        }
    }
    public List<Reserva> listado() throws SQLException {
        conexion = Conexion.getInstancia().miConexion();
        List<Reserva> reservas = new ArrayList<>();
        Reserva reserva = null;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        String sentenciaSQL = "select * from Reserva as re"
                + " join Reserva_has_Habitacion as Rh on re.idReserva = rh.idReserva "
                + "join Habitacion as c on Rh.idHabitacion = c.idHabitacion";
        try {
            sentencia = conexion.prepareStatement(sentenciaSQL);
            resultado = sentencia.executeQuery();
            while(resultado.next()){
                reserva = new Reserva();
                reserva.setIdReserva(resultado.getString("idReserva"));
                reserva.setFecha(resultado.getDate("fechaEntrada"));
                String idCliente = resultado.getString("idCliente");
                Cliente cliente = ClienteDAO.getInstancia().buscarPorCodigo(idCliente);
                reserva.setCliente(cliente);
                String idRecepcionista = resultado.getString("idRecepcionista");
                Recepcionista recepcionista = RecepcionistaDAO.getInstancia().buscarPorCodigo(idRecepcionista);
                reserva.setRecepcionista(recepcionista);
                Habitacion habitacion = new Habitacion();
                habitacion.setCosto(resultado.getDouble("Costo"));
                reserva.agregarHabitacion(habitacion);
                reservas.add(reserva);
            }
        } catch (Exception e) {
            throw e;
        }finally{
            conexion.close();
            sentencia.close();
            resultado.close();
        }
        return reservas;
    }
    
    public List<Reserva> buscarReservaPorCliente(String idCliente) throws SQLException {
        conexion = Conexion.getInstancia().miConexion();
        List<Reserva> reservas = new ArrayList<>();
        Reserva reserva;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        String sentenciaSQL = "select * from Reserva as re"
                + " join Reserva_has_Habitacion as Rh on re.idReserva = rh.idReserva "
                + " join Habitacion as c on Rh.idHabitacion = c.idHabitacion "
                + " join Cliente as l on re.idCliente = l.idCliente "
                + "where l.idCliente = '" + idCliente + "'";
        try {
            sentencia = conexion.prepareStatement(sentenciaSQL);
            resultado = sentencia.executeQuery();
            while(resultado.next()){
                reserva = new Reserva();
                reserva.setIdReserva(resultado.getString("idReserva"));
                reserva.setFecha(resultado.getDate("fechaEntrada"));
                String idClientes = resultado.getString("idCliente");
                Cliente cliente = ClienteDAO.getInstancia().buscarPorCodigo(idClientes);
                reserva.setCliente(cliente);
                String idRecepcionista = resultado.getString("idRecepcionista");
                Recepcionista recepcionista = RecepcionistaDAO.getInstancia().buscarPorCodigo(idRecepcionista);
                reserva.setRecepcionista(recepcionista);
                Habitacion habitacion = new Habitacion();
                habitacion.setCosto(resultado.getDouble("Costo"));
                reserva.agregarHabitacion(habitacion);
                reservas.add(reserva);
            }
        } catch (Exception e) {
            throw e;
        }finally{
            conexion.close();
            sentencia.close();
            resultado.close();
        }
        return reservas;
    }
     public List<Reserva> buscarReservaPorRecepcionista(String idRecepcionista) throws SQLException {
        conexion = Conexion.getInstancia().miConexion();
        List<Reserva> reservas = new ArrayList<>();
        Reserva reserva;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        String sentenciaSQL = "select * from Reserva as re"
                + " join Reserva_has_Habitacion as Rh on re.idReserva = rh.idReserva "
                + " join Habitacion as c on Rh.idHabitacion = c.idHabitacion "
                + " join Recepcionista as rec on re.idRecepcionista = rec.idRecepcionista "
                + "where rec.idRecepcionista = '" + idRecepcionista + "'";
        try {
            sentencia = conexion.prepareStatement(sentenciaSQL);
            resultado = sentencia.executeQuery();
            while(resultado.next()){
                reserva = new Reserva();
                reserva.setIdReserva(resultado.getString("idReserva"));
                reserva.setFecha(resultado.getDate("fechaEntrada"));
                String idClientes = resultado.getString("idCliente");
                Cliente cliente = ClienteDAO.getInstancia().buscarPorCodigo(idClientes);
                reserva.setCliente(cliente);
                String idRecepcionistas = resultado.getString("idRecepcionista");
                Recepcionista recepcionista = RecepcionistaDAO.getInstancia().buscarPorCodigo(idRecepcionistas);
                reserva.setRecepcionista(recepcionista);
                Habitacion habitacion = new Habitacion();
                habitacion.setCosto(resultado.getDouble("Costo"));
                reserva.agregarHabitacion(habitacion);
                reservas.add(reserva);
            }
        } catch (Exception e) {
            throw e;
        }finally{
            conexion.close();
            sentencia.close();
            resultado.close();
        }
        return reservas;
     }
     
     public List<Reserva> buscarReserva() throws SQLException {
        conexion = Conexion.getInstancia().miConexion();
        List<Reserva> reservas = new ArrayList<>();
        Reserva reserva = null;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        String sentenciaSQL = "select * from Reserva as re"
                + " join Reserva_has_Habitacion as rh on re.idReserva = rh.idReserva "
                + " join Habitacion as habi on rh.idHabitacion = habi.idHabitacion "
                + " join Categoria as cat on habi.idCategoria = cat.idCategoria "
                + " join Recepcionista as rec on re.idRecepcionista = rec.idRecepcionista "
                + " join Cliente as cli on re.idcliente = cli.idcliente";
        try {
            sentencia = conexion.prepareStatement(sentenciaSQL);
            resultado = sentencia.executeQuery();
            if(resultado.next()){
                reserva = new Reserva();
                reserva.setIdReserva(resultado.getString("idReserva"));
                reserva.setFecha(resultado.getDate("fechaEntrada"));
                String idRecepcionistas = resultado.getString("idRecepcionista");
                Recepcionista recepcionista = RecepcionistaDAO.getInstancia().buscarPorCodigo(idRecepcionistas);
                reserva.setRecepcionista(recepcionista);
////                String idClientes = resultado.getString("idCliente");
////                Cliente cliente = ClienteDAO.getInstancia().buscarPorCodigo(idClientes);
////                reserva.setCliente(cliente);
//
//                Habitacion habitacion = new Habitacion();
//                habitacion.setCosto(resultado.getDouble("Costo"));
//                reserva.agregarHabitacion(habitacion);
                reservas.add(reserva);
                
            }
        } catch (Exception e) {
            throw e;
        }finally{
            conexion.close();
            sentencia.close();
            resultado.close();
        }
        return reservas;
     }
     
}
