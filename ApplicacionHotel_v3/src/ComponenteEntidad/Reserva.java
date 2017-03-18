/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ComponenteEntidad;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
/**
 *
 * @author Rita
 */
public class Reserva {
    private String idReserva;
    private Date fecha;
    private double costoTotal;
    private Cliente cliente;
    private Recepcionista recepcionista;
    private List<Habitacion> habitaciones; 

    public Reserva() {
        habitaciones = new ArrayList<>();
    }

    public Reserva(String idReserva, Date fecha, double costoTotal, Cliente cliente, Recepcionista recepcionista) {
        this.idReserva = idReserva;
        this.fecha = fecha;
        this.costoTotal = costoTotal;
        this.cliente = cliente;
        this.recepcionista = recepcionista;
        this.habitaciones = new ArrayList<>();
    }

    public String getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(String idReserva) {
        this.idReserva = idReserva;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(double costoTotal) {
        this.costoTotal = costoTotal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Recepcionista getRecepcionista() {
        return recepcionista;
    }

    public void setRecepcionista(Recepcionista recepcionista) {
        this.recepcionista = recepcionista;
    }

    public List<Habitacion> getHabitaciones() {
        return habitaciones;
    }
    
    public void agregarHabitacion(Habitacion habitacion){
        habitaciones.add(habitacion);
    }
    public double CalcularCosto()
    {
        double montoTotal = 0.0;
        for(Habitacion habitacion: habitaciones){
            montoTotal += habitacion.getCosto();
        }
        return montoTotal;
    }
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.idReserva);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Reserva other = (Reserva) obj;
        if (!Objects.equals(this.idReserva, other.idReserva)) {
            return false;
        }
        return true;
    }
    
    
}
