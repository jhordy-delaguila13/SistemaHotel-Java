/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ComponenteNegocio;

import ComponenteDatos.CategoriaDAO;
import ComponenteDatos.HabitacionDAO;
import ComponenteEntidad.Categoria;
import ComponenteEntidad.Habitacion;
import java.util.List;

/**
 *
 * @author Jhordy
 */
public class HabitacionCN {
    
    private static HabitacionCN instancia;
    public static HabitacionCN getInstancia(){
        if(instancia == null)
            instancia = new HabitacionCN();
        return instancia;
    }
    
    public void crearHabitacion(Habitacion habitacion) throws Exception{
        HabitacionDAO.getInstancia().insertar(habitacion);
    }
    
    public void modificarHabitacion(Habitacion habitacion) throws Exception{
        HabitacionDAO.getInstancia().modificar(habitacion);
    }
    
    public void eliminarHabitacion(Habitacion habitacion) throws Exception{
        HabitacionDAO.getInstancia().eliminar(habitacion);
    }
    
    public Habitacion buscarHabitacion(String id) throws Exception{
        Habitacion habitacion = HabitacionDAO.getInstancia().buscarPorCodigo(id);
        return habitacion;
    }
    
    public List<Habitacion> listadoHabitaciones(String nombre) throws Exception{
        List<Habitacion> habitaciones = HabitacionDAO.getInstancia().buscarPorEstado(nombre);
        return habitaciones;
    }
    public  Categoria buscarCategoria(String nombre) throws Exception{
        Categoria categoria = CategoriaDAO.getInstancia().buscarPorTipo(nombre);
        return categoria;
    }
}
