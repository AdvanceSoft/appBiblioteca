/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appbiblioteca.c2_aplicacion.servicio;

import appbiblioteca.c3_dominio.contrato.IUbicacionArmarioDAO;
import appbiblioteca.c3_dominio.contrato.IUbicacionFilaDAO;
import appbiblioteca.c3_dominio.entidad.UbicacionArmario;
import appbiblioteca.c3_dominio.entidad.UbicacionFila;
import appbiblioteca.c4_persistencia.GestorJDBC;
import appbiblioteca.c4_persistencia.fabricaDAO.FabricaAbstractaDAO;
import java.util.List;

/**
 *
 * @author
 * <AdvanceSoft - Garcia Infante Petter Jhunior - advancesoft.trujillo@gmail.com>
 */
public class GestionarUbicacionArmarioServicio {
    GestorJDBC gestorJDBC;
    IUbicacionArmarioDAO ubicacionArmarioDAO;
    IUbicacionFilaDAO ubicacionFilaDAO;
    
   public GestionarUbicacionArmarioServicio(){
       FabricaAbstractaDAO fabricaAbstractaDAO = FabricaAbstractaDAO.getInstancia();
       gestorJDBC = fabricaAbstractaDAO.crearGestorJDBC();
       ubicacionArmarioDAO = fabricaAbstractaDAO.crearUbicacionArmarioDAO(gestorJDBC);
       ubicacionFilaDAO = fabricaAbstractaDAO.crearUbicacionFilaDAO(gestorJDBC);
       
   }
   
   public void crear(UbicacionArmario ubicacionArmario) throws Exception {        
        gestorJDBC.abrirConexion();
        try {
            ubicacionArmarioDAO.crear(ubicacionArmario);
       } catch (Exception e) {
            gestorJDBC.cerrarConexion();
            throw e;
       }
        gestorJDBC.cerrarConexion();
    }
    
    public void modificar(UbicacionArmario ubicacionArmario) throws Exception {        
        gestorJDBC.abrirConexion();
        try {
            ubicacionArmarioDAO.modificar(ubicacionArmario);
       } catch (Exception e) {
            gestorJDBC.cerrarConexion();
            throw e;
       }
        gestorJDBC.cerrarConexion();
    }

    
    public void eliminar(UbicacionArmario ubicacionArmario) throws Exception {
        gestorJDBC.abrirConexion();
        try {
            ubicacionArmarioDAO.eliminar(ubicacionArmario);
        } catch (Exception e) {
            gestorJDBC.cerrarConexion();
            throw e;
        }
        gestorJDBC.cerrarConexion();
    }

    
    public UbicacionArmario buscar(int codigo) throws Exception {
        UbicacionArmario ubicacionArmario;
        gestorJDBC.abrirConexion();
        try {
            ubicacionArmario = ubicacionArmarioDAO.buscar(codigo);
        } catch (Exception e) {
            gestorJDBC.cerrarConexion();
            throw e;
        }
        gestorJDBC.cerrarConexion();
        return ubicacionArmario;
    }

    
    public List<UbicacionArmario> buscar(String nombre) throws Exception {
        List<UbicacionArmario> listaArmarios;
        gestorJDBC.abrirConexion();
        try {
            listaArmarios = ubicacionArmarioDAO.buscar(nombre);
        } catch (Exception e) {
            gestorJDBC.cerrarConexion();
            throw e;
        }
        gestorJDBC.cerrarConexion();
        return listaArmarios;
    }
    
    public UbicacionFila buscarUbicacionFila(int codigo) throws Exception{
        UbicacionFila ubicacionFila;
        gestorJDBC.abrirConexion();
        try {
            ubicacionFila = ubicacionFilaDAO.buscar(codigo);
        } catch (Exception e) {
            gestorJDBC.cerrarConexion();
            throw e;
        }
        gestorJDBC.cerrarConexion();
        return ubicacionFila;
    }
    public List<UbicacionFila> buscarUbicacionFila(String nombre) throws Exception{
        List<UbicacionFila> listaUbicacionFilas;
        gestorJDBC.abrirConexion();
        try {
            listaUbicacionFilas = ubicacionFilaDAO.buscar(nombre);
        } catch (Exception e) {
            gestorJDBC.cerrarConexion();
            throw e;
        }
        gestorJDBC.cerrarConexion();
        return listaUbicacionFilas;
    }
}
