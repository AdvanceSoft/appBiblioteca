package appbiblioteca.c2_aplicacion.servicio;

import appbiblioteca.c3_dominio.contrato.IProveedorDAO;
import appbiblioteca.c3_dominio.entidad.Proveedor;
import appbiblioteca.c4_persistencia.GestorJDBC;
import appbiblioteca.c4_persistencia.fabricaDAO.FabricaAbstractaDAO;
import java.util.List;

/**
 * @author <AdvanceSoft - Osorio Perez Carlos Alfredo - advancesoft.trujillo@gmail.com>
 * @version 1.0
 * @created 25-jul-2015 06:07:59 p.m.
 */
public class GestionarProveedorServicio {
    
    GestorJDBC gestorJDBC;
    IProveedorDAO proveedorDAO;
    
    public GestionarProveedorServicio(){
        FabricaAbstractaDAO fabricaAbstractaDAO = FabricaAbstractaDAO.getInstancia();
        gestorJDBC = fabricaAbstractaDAO.crearGestorJDBC();
        proveedorDAO = fabricaAbstractaDAO.crearProveedorDAO(gestorJDBC);        
    }
    
    public void crear(Proveedor proveedor) throws Exception{
        gestorJDBC.abrirConexion();
        try{
            proveedorDAO.crear(proveedor);
        }catch(Exception e){
            gestorJDBC.cerrarConexion();
            throw e;
        }
        gestorJDBC.cerrarConexion();
    }
    
    public void modificar(Proveedor proveedor) throws Exception{
        gestorJDBC.abrirConexion();
        try{
            proveedorDAO.modificar(proveedor);
        }catch(Exception e){
            gestorJDBC.cerrarConexion();
            throw e;
        }
        gestorJDBC.cerrarConexion();
    }
    
    public void eliminar(Proveedor proveedor) throws Exception{
        gestorJDBC.abrirConexion();
        try{
            proveedorDAO.eliminar(proveedor);
        }catch(Exception e){
            gestorJDBC.cerrarConexion();
            throw e;
        }
        gestorJDBC.cerrarConexion();
    }
    
    public Proveedor buscar(int codigo) throws Exception{
        Proveedor proveedor = null;
        gestorJDBC.abrirConexion();
        try{
            proveedor = proveedorDAO.buscar(codigo);
        }catch(Exception e){
            gestorJDBC.cerrarConexion();
            throw e;
        }
        gestorJDBC.cerrarConexion();
        return proveedor;
    }
    
    public List<Proveedor> buscar(String nombre) throws Exception{
        List<Proveedor> listaproveedor;
        gestorJDBC.abrirConexion();
        try{
            listaproveedor = proveedorDAO.buscar(nombre);
        }catch(Exception e){
            gestorJDBC.cerrarConexion();
            throw e;
        }
        gestorJDBC.cerrarConexion();
        return listaproveedor;
    }
}