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
public class Recepcionista {
    private String idRecepcionista;
    private String Nombres;
    private String Apellidos;
    private String Direccion;
    private String DNI;
    private String telefono;
    private String Correo;
    
    public Recepcionista(){
        
    }

    public Recepcionista(String idRecepcionista, String Nombres, String Apellidos, String Direccion, String DNI, String telefono, String Correo) {
        this.idRecepcionista = idRecepcionista;
        this.Nombres = Nombres;
        this.Apellidos = Apellidos;
        this.Direccion = Direccion;
        this.DNI = DNI;
        this.telefono = telefono;
        this.Correo = Correo;
    }

    public String getIdRecepcionista() {
        return idRecepcionista;
    }

    public void setIdRecepcionista(String idRecepcionista) {
        this.idRecepcionista = idRecepcionista;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    @Override
    public String toString() {
        return "Recepcionista{" + "idRecepcionista=" + idRecepcionista + ", Nombres=" + Nombres + ", Apellidos=" + Apellidos + ", Direccion=" + Direccion + ", DNI=" + DNI + ", telefono=" + telefono + ", Correo=" + Correo + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.idRecepcionista);
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
        final Recepcionista other = (Recepcionista) obj;
        if (!Objects.equals(this.idRecepcionista, other.idRecepcionista)) {
            return false;
        }
        return true;
    }
    
}
