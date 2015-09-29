/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appbiblioteca.c2_aplicacion.servicio;

import appbiblioteca.c3_dominio.contrato.IUbicacionFilaDAO;
import appbiblioteca.c3_dominio.entidad.UbicacionFila;
import appbiblioteca.c4_persistencia.GestorJDBC;
import appbiblioteca.c4_persistencia.fabricaDAO.FabricaAbstractaDAO;
import java.util.List;

/**
 *
 * @author
 * <AdvanceSoft - Garcia Infante Petter Jhunior - advancesoft.trujillo@gmail.com>
 */
public class GestionarUbicacionFilaServicio{
    GestorJDBC gestorJDBC;
    IUbicacionFilaDAO ubicacionFilaDAO;

    public GestionarUbicacionFilaServicio() {
        FabricaAbstractaDAO fabricaAbstractaDAO = FabricaAbstractaDAO.getInstancia(); 
        this.gestorJDBC = fabricaAbstractaDAO.crearGestorJDBC();
        this.ubicacionFilaDAO = fabricaAbstractaDAO.crearUbicacionFilaDAO(gestorJDBC);
    }  
    
    public void crear(UbicacionFila ubicacionFila) throws Exception {
        this.gestorJDBC.abrirConexion();
        try {
            ubicacionFilaDAO.crear(ubicacionFila);
        } catch (Exception e) {
            gestorJDBC.cerrarConexion();
            throw e;
        }
        gestorJDBC.cerrarConexion();
    }
    
    public void modificar(UbicacionFila ubicacionFila) throws Exception {
        this.gestorJDBC.abrirConexion();
        try {
            ubicacionFilaDAO.modificar(ubicacionFila);
        } catch (Exception e) {
            gestorJDBC.cerrarConexion();
            throw e;
        }
        gestorJDBC.cerrarConexion();
    }
    
    public void eliminar(UbicacionFila ubicacionFila) throws Exception {
        this.gestorJDBC.abrirConexion();
        try {
            ubicacionFilaDAO.eliminar(ubicacionFila);
        } catch (Exception e) {
            gestorJDBC.cerrarConexion();
            throw e;
        }
        gestorJDBC.cerrarConexion();
    }
    
    public UbicacionFila buscar(int codigo) throws Exception {
        UbicacionFila ubicacionFila = null;
        gestorJDBC.abrirConexion();
        try{
            ubicacionFila = ubicacionFilaDAO.buscar(codigo);
        }catch(Exception e){
            gestorJDBC.cerrarConexion();
            throw e;
        }
        gestorJDBC.cerrarConexion();
        return ubicacionFila;
    }
    
    public List<UbicacionFila> buscar(String nombre) throws Exception {
        List<UbicacionFila> listUbicacionFilas;
        gestorJDBC.abrirConexion();
        try {
            listUbicacionFilas = ubicacionFilaDAO.buscar(nombre);
        } catch (Exception e) {
            gestorJDBC.cerrarConexion();
            throw e;
        }
        gestorJDBC.cerrarConexion();
        return listUbicacionFilas;
    }
}
