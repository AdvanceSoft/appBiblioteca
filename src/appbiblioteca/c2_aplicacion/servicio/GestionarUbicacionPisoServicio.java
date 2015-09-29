/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appbiblioteca.c2_aplicacion.servicio;

import appbiblioteca.c3_dominio.contrato.IUbicacionArmarioDAO;
import appbiblioteca.c3_dominio.contrato.IUbicacionPisoDAO;
import appbiblioteca.c3_dominio.entidad.UbicacionArmario;
import appbiblioteca.c3_dominio.entidad.UbicacionPiso;
import appbiblioteca.c4_persistencia.GestorJDBC;
import appbiblioteca.c4_persistencia.fabricaDAO.FabricaAbstractaDAO;
import java.util.List;

/**
 *
 * @author
 * <AdvanceSoft - Garcia Infante Petter Jhunior - advancesoft.trujillo@gmail.com>
 */
public class GestionarUbicacionPisoServicio {
    GestorJDBC gestorJDBC;
    IUbicacionPisoDAO ubicacionPisoDAO;
    IUbicacionArmarioDAO ubicacionArmarioDAO;
    
    public GestionarUbicacionPisoServicio(){
        FabricaAbstractaDAO fabricaAbstractaDAO = FabricaAbstractaDAO.getInstancia();
        gestorJDBC = fabricaAbstractaDAO.crearGestorJDBC();
        ubicacionPisoDAO = fabricaAbstractaDAO.crearUbicacionPisoDAO(gestorJDBC);
        ubicacionArmarioDAO = fabricaAbstractaDAO.crearUbicacionArmarioDAO(gestorJDBC);
    }
     public void crear(UbicacionPiso ubicacionPiso) throws Exception {
        gestorJDBC.abrirConexion();
         try {
             ubicacionPisoDAO.crear(ubicacionPiso);
         } catch (Exception e) {
             gestorJDBC.cerrarConexion();
             throw e;
         }
         gestorJDBC.cerrarConexion();
    }

    
    public void modificar(UbicacionPiso ubicacionPiso) throws Exception {
        gestorJDBC.abrirConexion();
        try {
            ubicacionPisoDAO.modificar(ubicacionPiso);
        } catch (Exception e) {
            gestorJDBC.cerrarConexion();
            throw e;
        }
        gestorJDBC.cerrarConexion();
    }
    
    public void eliminar(UbicacionPiso ubicacionPiso) throws Exception {
        gestorJDBC.abrirConexion();
        try {
            ubicacionPisoDAO.eliminar(ubicacionPiso);
        } catch (Exception e) {
            gestorJDBC.cerrarConexion();
            throw e;
        }
        gestorJDBC.cerrarConexion();        
    }
    
    public UbicacionPiso buscar(int codigo) throws Exception {
        UbicacionPiso ubicacionPiso;
        gestorJDBC.abrirConexion();
        try {
            ubicacionPiso = ubicacionPisoDAO.buscar(codigo);
        } catch (Exception e) {
            gestorJDBC.cerrarConexion();
            throw e;
        }
        gestorJDBC.cerrarConexion();
        return ubicacionPiso;
    }
    
    public List<UbicacionPiso> buscar(String nombre) throws Exception {
       List<UbicacionPiso> listaUbicacionPisos;
       gestorJDBC.abrirConexion();
        try {
            listaUbicacionPisos = ubicacionPisoDAO.buscar(nombre);
        } catch (Exception e) {
            gestorJDBC.cerrarConexion();
            throw e;
        }
        gestorJDBC.cerrarConexion();
        return listaUbicacionPisos;
    }
    public UbicacionArmario buscarUbicacionArmario(int codigo) throws Exception{
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
    public List<UbicacionArmario> buscarUbicacionArmario(String nombre) throws Exception{
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
}
