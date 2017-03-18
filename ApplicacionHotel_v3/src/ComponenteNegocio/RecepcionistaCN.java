/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ComponenteNegocio;

import ComponenteDatos.RecepcionistaDAO;
import ComponenteEntidad.Recepcionista;
import java.util.List;

/**
 *
 * @author Jhordy
 */
public class RecepcionistaCN {
    
    private static RecepcionistaCN instancia;
    public static RecepcionistaCN getInstancia(){
        if(instancia == null)
            instancia = new RecepcionistaCN();
        return instancia;
    }
    
    public void crearRecepcionista(Recepcionista recepcionista) throws Exception{
        RecepcionistaDAO.getInstancia().insertar(recepcionista);
    }
    
    public void modificarRecepcionista(Recepcionista recepcionista) throws Exception{
        RecepcionistaDAO.getInstancia().modificar(recepcionista);
    }
    
    public void eliminarRecepcionista(Recepcionista recepcionista) throws Exception{
        RecepcionistaDAO.getInstancia().eliminar(recepcionista);
    }
    
    public Recepcionista buscarRecepcionista(String id) throws Exception{
        Recepcionista recepcionista = RecepcionistaDAO.getInstancia().buscarPorCodigo(id);
        return recepcionista;
    }
    
    public List<Recepcionista> listadoRecepcionistas(String nombre) throws Exception{
        List<Recepcionista> recepcionistas = RecepcionistaDAO.getInstancia().buscar(nombre);
        return recepcionistas;
    }
    
}
