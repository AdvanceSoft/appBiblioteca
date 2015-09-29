/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appbiblioteca.c2_aplicacion.servicio;

import appbiblioteca.c3_dominio.contrato.ILectorDAO;
import appbiblioteca.c3_dominio.entidad.Lector;
import appbiblioteca.c3_dominio.entidad.Telefono;
import appbiblioteca.c4_persistencia.GestorJDBC;
import appbiblioteca.c4_persistencia.fabricaDAO.FabricaAbstractaDAO;
import java.util.List;

/**
 *
 * @author
 * <AdvanceSoft - Medrano Parado Sandra Zoraida - advancesoft.trujillo@gmail.com>
 * @version 1.0 
 */
public class GestionarLectorServicio{

    GestorJDBC gestorJDBC;
    ILectorDAO lectorDAO;

    public GestionarLectorServicio() {
        FabricaAbstractaDAO fabricaAbstractaDAO = FabricaAbstractaDAO.getInstancia();
        gestorJDBC = fabricaAbstractaDAO.crearGestorJDBC();
        lectorDAO = fabricaAbstractaDAO.crearLectorDAO(gestorJDBC);
    }
    
    public void crear(Lector lector) throws Exception {
        gestorJDBC.abrirConexion();
        try {
            lectorDAO.crear(lector);
        } catch (Exception e) {
            gestorJDBC.cerrarConexion();
            throw e;
        }
        gestorJDBC.cerrarConexion();
    }
    
    public void modificar(Lector lector) throws Exception {
        gestorJDBC.abrirConexion();
        try {
            lectorDAO.modificar(lector);
        } catch (Exception e) {
            gestorJDBC.cerrarConexion();
            throw e;
        }
        gestorJDBC.cerrarConexion();
    }

    public void eliminar(Lector lector) throws Exception {
        gestorJDBC.abrirConexion();
        try {
            lectorDAO.eliminar(lector);
        } catch (Exception e) {
            gestorJDBC.cerrarConexion();
            throw e;
        }
        gestorJDBC.cerrarConexion();
    }
    
    public Lector buscar(int codigo) throws Exception {
        Lector lector;
        gestorJDBC.abrirConexion();
        try {
            lector = lectorDAO.buscar(codigo);
        } catch (Exception e) {
            gestorJDBC.cerrarConexion();
            throw e;
        }
        gestorJDBC.cerrarConexion();
        return lector;
    }
    
    public Lector buscarPorDNI(String dni) throws Exception {
        Lector lector;
        gestorJDBC.abrirConexion();
        try {
            lector = lectorDAO.buscarPorDNI(dni);
        } catch (Exception e) {
            gestorJDBC.cerrarConexion();
            throw e;
        }
        gestorJDBC.cerrarConexion();
        return lector;
    }
    
    public List<Lector> buscar(String nombre) throws Exception {
        List<Lector> listalectores;
        gestorJDBC.abrirConexion();
        try {
            listalectores = lectorDAO.buscar(nombre);
        } catch (Exception e) {
            gestorJDBC.cerrarConexion();
            throw e;
        }
        gestorJDBC.cerrarConexion();
        return listalectores;
    }
}
