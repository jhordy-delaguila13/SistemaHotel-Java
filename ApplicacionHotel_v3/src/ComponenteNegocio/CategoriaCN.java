/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ComponenteNegocio;

import ComponenteDatos.CategoriaDAO;
import ComponenteEntidad.Categoria;
import java.util.List;

/**
 *
 * @author Rita
 */
public class CategoriaCN {
     private static CategoriaCN instancia;
    public static CategoriaCN getInstancia(){
        if(instancia == null)
            instancia = new CategoriaCN();
        return instancia;
    }
    
    public void crearCategoria(Categoria categoria) throws Exception{
             CategoriaDAO.getInstancia().insertar(categoria);
    }
    public void eliminarCategoria(Categoria categoria) throws Exception{
       CategoriaDAO.getInstancia().eliminar(categoria);
    }
    public Categoria  BuscarCategoria(String idCodigo)throws Exception{
       Categoria categoria = CategoriaDAO.getInstancia().buscarPorCodigo(idCodigo);
       return categoria;
    }
//    public List<Categoria> listaCategoria(String id) throws Exception{
//        List<Categoria>  categorias = CategoriaDAO.getInstancia().buscarPorTipo(id);
//        return categorias;
//    }
    
    public List<Categoria> lista() throws Exception{
        List<Categoria>  categorias = CategoriaDAO.getInstancia().listado();
        return categorias;
    }
}
