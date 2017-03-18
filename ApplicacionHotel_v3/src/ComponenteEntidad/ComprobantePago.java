/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ComponenteEntidad;

import java.util.Objects;

/**
 *
 * @author Rita
 */
public class ComprobantePago {
    private String idComprobantePago;
    private String Descripcion;
    private String Fecha;
    private Reserva reserva;

    public ComprobantePago() {
    }

    public ComprobantePago(String idComprobantePago, String Descripcion, String Fecha, Reserva reserva) {
        this.idComprobantePago = idComprobantePago;
        this.Descripcion = Descripcion;
        this.Fecha = Fecha;
        this.reserva = reserva;
    }

    public String getIdComprobantePago() {
        return idComprobantePago;
    }

    public void setIdComprobantePago(String idComprobantePago) {
        this.idComprobantePago = idComprobantePago;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    @Override
    public String toString() {
        return "ComprobantePago{" + "idComprobantePago=" + idComprobantePago + ", Descripcion=" + Descripcion + ", Fecha=" + Fecha + ", reserva=" + reserva + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.idComprobantePago);
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
        final ComprobantePago other = (ComprobantePago) obj;
        if (!Objects.equals(this.idComprobantePago, other.idComprobantePago)) {
            return false;
        }
        return true;
    }
    
    
    
    
}
