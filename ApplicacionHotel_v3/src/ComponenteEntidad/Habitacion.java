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
public class Habitacion {
    private String idHabitacion;
    private int Numero;
    private String Estado;
    private double Costo;
    private String Descripcion;
    private Categoria categoria;
    public static final String ESTADO_OCUPADO = "OCUPADO";
    public static final String ESTADO_LIBRE = "LIBRE";
    
    public Habitacion(){
    
    }

    public Habitacion(String idHabitacion, int Numero, String Estado, double Costo, String Descripcion, Categoria categoria) {
        this.idHabitacion = idHabitacion;
        this.Numero = Numero;
        this.Estado = Estado;
        this.Costo = Costo;
        this.Descripcion = Descripcion;
        this.categoria = categoria;
    }

    public String getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(String idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public int getNumero() {
        return Numero;
    }

    public void setNumero(int Numero) {
        this.Numero = Numero;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public double getCosto() {
        return Costo;
    }

    public void setCosto(double Costo) {
        this.Costo = Costo;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.idHabitacion);
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
        final Habitacion other = (Habitacion) obj;
        if (!Objects.equals(this.idHabitacion, other.idHabitacion)) {
            return false;
        }
        return true;
    }
    
    
    
    
}
