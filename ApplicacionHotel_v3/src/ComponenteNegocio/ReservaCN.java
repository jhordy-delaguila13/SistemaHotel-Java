/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ComponenteNegocio;

import ComponenteDatos.ClienteDAO;
import ComponenteDatos.HabitacionDAO;
import ComponenteDatos.RecepcionistaDAO;
import ComponenteDatos.ReservaDAO;
import ComponenteEntidad.Cliente;
import ComponenteEntidad.Habitacion;
import ComponenteEntidad.Recepcionista;
import ComponenteEntidad.Reserva;
import java.util.List;

/**
 *
 * @author Jhordy
 */
public class ReservaCN {
    
    private static ReservaCN instancia;
    public static ReservaCN getInstancia(){
        if(instancia == null)
            instancia = new ReservaCN();
        return instancia;
    }
    
    public void crearReserva(Reserva reserva) throws Exception{
        //for(Habitacion habitacion : reserva.getHabitaciones())
            //habitacion.setEstado(Habitacion.ESTADO_OCUPADO);
        ReservaDAO.getInstancia().insertar(reserva);
    }
    
    public Cliente buscarCliente(String dni) throws Exception{
        Cliente cliente = ClienteDAO.getInstancia().buscarPorDni(dni);
        return cliente;
    }
    
    public Recepcionista buscarRecepcionista(String dni) throws Exception{
        Recepcionista recepcionista = RecepcionistaDAO.getInstancia().buscarPorDni(dni);
        return recepcionista;
    }
    
    public List<Habitacion> buscarHabitaciones(String estado) throws Exception{
        List<Habitacion> habitaciones = HabitacionDAO.getInstancia().buscarPorEstado(estado);
        return habitaciones;
    }
    public List<Reserva> ListadoReservas()  throws Exception{
        List<Reserva> reserva = ReservaDAO.getInstancia().listado();
        return reserva;
    }
    public List<Reserva> ListadoReservasPorCliente(String idCliente)  throws Exception{
        List<Reserva> reserva = ReservaDAO.getInstancia().buscarReservaPorCliente(idCliente);
        return reserva;
    }
    public List<Reserva> ListadoReservasPorRecepcionista(String idRecepcionista)  throws Exception{
        List<Reserva> reserva = ReservaDAO.getInstancia().buscarReservaPorRecepcionista(idRecepcionista);
        return reserva;
    }
    
    public List<Reserva> buscar()  throws Exception{
        List<Reserva> reservas = ReservaDAO.getInstancia().buscarReserva();
        return reservas;
    }
}
