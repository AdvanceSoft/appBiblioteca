/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appbiblioteca.c2_aplicacion.servicio;

import appbiblioteca.c3_dominio.contrato.IEjemplarDAO;
import appbiblioteca.c3_dominio.contrato.ILibroDAO;
import appbiblioteca.c3_dominio.contrato.IUbicacionArmarioDAO;
import appbiblioteca.c3_dominio.contrato.IUbicacionFilaDAO;
import appbiblioteca.c3_dominio.contrato.IUbicacionPisoDAO;
import appbiblioteca.c3_dominio.entidad.Ejemplar;
import appbiblioteca.c4_persistencia.GestorJDBC;
import appbiblioteca.c4_persistencia.fabricaDAO.FabricaAbstractaDAO;
import java.util.List;

/**
 *
 * @author
 * <AdvanceSoft - Mendoza Torres Valentin - advancesoft.trujillo@gmail.com>
 */
public class GestionarEjemplarServicio {
    GestorJDBC gestorJDBC;
    IEjemplarDAO ejemplarDAO;
    IUbicacionArmarioDAO ubicacionArmarioDAO;
    IUbicacionFilaDAO ubicacionFilaDAO;
    IUbicacionPisoDAO ubicacionPisoDAO;
    ILibroDAO libroDAO;
    
    public GestionarEjemplarServicio(){
        FabricaAbstractaDAO fabricaAbstractaDAO = FabricaAbstractaDAO.getInstancia();
        gestorJDBC = fabricaAbstractaDAO.crearGestorJDBC();
        ejemplarDAO = fabricaAbstractaDAO.crearEjemplarDAO(gestorJDBC);
        ubicacionArmarioDAO = fabricaAbstractaDAO.crearUbicacionArmarioDAO(gestorJDBC);
        ubicacionFilaDAO = fabricaAbstractaDAO.crearUbicacionFilaDAO(gestorJDBC);
        ubicacionPisoDAO = fabricaAbstractaDAO.crearUbicacionPisoDAO(gestorJDBC);
        libroDAO = fabricaAbstractaDAO.crearLibroDAO(gestorJDBC);
        
    }
    
    public void crear(Ejemplar ejemplar) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public void modificar(Ejemplar ejemplar) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public void eliminar(Ejemplar ejemplar) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public Ejemplar buscar(int codigo) throws Exception {
        Ejemplar ejemplar = null;
        gestorJDBC.abrirConexion();
        try {
            ejemplar = ejemplarDAO.buscar(codigo);
        } catch (Exception e) {
            gestorJDBC.cerrarConexion();
            throw e;
        }
        gestorJDBC.cerrarConexion();
        return ejemplar;
    }

    public List<Ejemplar> buscar(String nombre) throws Exception {
        List<Ejemplar> listaEjemplar = null;
        gestorJDBC.abrirConexion();
        try {
            listaEjemplar = ejemplarDAO.buscar(nombre);
        } catch (Exception e) {
            gestorJDBC.cerrarConexion();
            throw e;
        }
        gestorJDBC.cerrarConexion();
        return listaEjemplar;
    }
    
    public Ejemplar buscarLibro(String nombre) throws Exception {
        Ejemplar ejemplar =new Ejemplar();
        gestorJDBC.abrirConexion();
        try {
            ejemplar = ejemplarDAO.buscarLibro(nombre);
        } catch (Exception e) {
            gestorJDBC.cerrarConexion();
            throw e;
        }
        gestorJDBC.cerrarConexion();
        return ejemplar;
    }
}
