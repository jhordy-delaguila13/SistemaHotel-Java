/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ComponenteNegocio;

import ComponenteDatos.ClienteDAO;
import ComponenteEntidad.Cliente;
import java.util.List;

/**
 *
 * @author Jhordy
 */
public class ClienteCN {
    
    private static ClienteCN instancia;
    public static ClienteCN getInstancia(){
        if(instancia == null)
            instancia = new ClienteCN();
        return instancia;
    }
    
    public void crearCliente(Cliente cliente) throws Exception{
        ClienteDAO.getInstancia().insertar(cliente);
    }
    
    public void modificarCliente(Cliente cliente) throws Exception{
        ClienteDAO.getInstancia().modificar(cliente);
    }
    
    public void eliminarCliente(Cliente cliente) throws Exception{
        ClienteDAO.getInstancia().eliminar(cliente);
    }
    
    public Cliente buscarCliente(String idcliente) throws Exception{
        Cliente cliente = ClienteDAO.getInstancia().buscarPorCodigo(idcliente);
        return cliente;
    }
    
    public List<Cliente> listadoClientes(String nombre) throws Exception{
        List<Cliente> clientes = ClienteDAO.getInstancia().buscar(nombre);
        return clientes;
    }
    
}
