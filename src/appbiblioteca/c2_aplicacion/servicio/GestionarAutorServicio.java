package appbiblioteca.c2_aplicacion.servicio;

import appbiblioteca.c3_dominio.contrato.IAutorDAO;
import appbiblioteca.c3_dominio.entidad.Autor;
import appbiblioteca.c4_persistencia.GestorJDBC;
import appbiblioteca.c4_persistencia.fabricaDAO.FabricaAbstractaDAO;
import java.util.List;

/**
 *
 * @author
 * <AdvanceSoft - Leyva Borjas Henderzon Alejandro - advancesoft.trujillo@gmail.com>
 */
public class GestionarAutorServicio {
    GestorJDBC gestorJDBC;
    IAutorDAO autorDAO;
    
    public GestionarAutorServicio(){
        FabricaAbstractaDAO fabricaAbstractaDAO = FabricaAbstractaDAO.getInstancia();
        gestorJDBC = fabricaAbstractaDAO.crearGestorJDBC();
        autorDAO = fabricaAbstractaDAO.crearAutorDAO(gestorJDBC);
    }
    
    public void crear(Autor autor) throws Exception{
        gestorJDBC.abrirConexion();
        try{
            autorDAO.crear(autor);
        }catch(Exception e){
            gestorJDBC.cerrarConexion();
            throw e;
        }
        gestorJDBC.cerrarConexion();
    }
    
    public void modificar(Autor autor) throws Exception{
        gestorJDBC.abrirConexion();
        try{
            autorDAO.modificar(autor);
        }catch(Exception e){
            gestorJDBC.cerrarConexion();
            throw e;
        }
        gestorJDBC.cerrarConexion();
    }
    
    public void eliminar(Autor autor) throws Exception{
        gestorJDBC.abrirConexion();
        try{
            autorDAO.eliminar(autor);
        }catch(Exception e){
            gestorJDBC.cerrarConexion();
            throw e;
        }
        gestorJDBC.cerrarConexion();
    }
    
    public Autor buscar(int codigo) throws Exception{
        Autor autor = null;
        gestorJDBC.abrirConexion();
        try{
            autor = autorDAO.buscar(codigo);
        }catch(Exception e){
            gestorJDBC.cerrarConexion();
            throw e;
        }
        gestorJDBC.cerrarConexion();
        return autor;
    }
    
    public List<Autor> buscar(String nombre) throws Exception{
        List<Autor> listaautor;
        gestorJDBC.abrirConexion();
        try{
            listaautor = autorDAO.buscar(nombre);
        }catch(Exception e){
            gestorJDBC.cerrarConexion();
            throw e;
        }
        gestorJDBC.cerrarConexion();
        return listaautor;
    }
}
