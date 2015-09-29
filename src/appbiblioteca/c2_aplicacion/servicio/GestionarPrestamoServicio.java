/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appbiblioteca.c2_aplicacion.servicio;

import appbiblioteca.c3_dominio.contrato.IBibliotecarioDAO;
import appbiblioteca.c3_dominio.contrato.IEjemplarDAO;
import appbiblioteca.c3_dominio.contrato.ILectorDAO;
import appbiblioteca.c3_dominio.contrato.IPrestamoDAO;
import appbiblioteca.c3_dominio.entidad.Ejemplar;
import appbiblioteca.c3_dominio.entidad.Prestamo;
import appbiblioteca.c4_persistencia.GestorJDBC;
import appbiblioteca.c4_persistencia.fabricaDAO.FabricaAbstractaDAO;

/**
 *
 * @author
 * <AdvanceSoft - Garcia Infante Petter Jhunior - advancesoft.trujillo@gmail.com>
 */
public class GestionarPrestamoServicio {
    GestorJDBC gestorJDBC;
    IPrestamoDAO prestamoDAO;
    IBibliotecarioDAO bibliotecarioDAO;
    ILectorDAO lectorDAO;
    IEjemplarDAO ejemplarDAO;
    
    public GestionarPrestamoServicio(){
        FabricaAbstractaDAO fabricaAbstractaDAO = FabricaAbstractaDAO.getInstancia();
        gestorJDBC = fabricaAbstractaDAO.crearGestorJDBC();
        prestamoDAO = fabricaAbstractaDAO.crearPrestamoDAO(gestorJDBC);
        bibliotecarioDAO = fabricaAbstractaDAO.crearBibliotecarioDAO(gestorJDBC);
        lectorDAO = fabricaAbstractaDAO.crearLectorDAO(gestorJDBC);
        ejemplarDAO = fabricaAbstractaDAO.crearEjemplarDAO(gestorJDBC);
    }
    public void crear(Prestamo prestamo) throws Exception {
        gestorJDBC.abrirConexion();
        gestorJDBC.iniciarTransaccion();
        try{
            prestamoDAO.crear(prestamo);
        }catch(Exception e){
            gestorJDBC.cancelarTransaccion();
            throw e;
        }
        gestorJDBC.cancelarTransaccion();
    }  
    
    public Prestamo buscar(int codigo) throws Exception {
      Prestamo prestamo;
      gestorJDBC.iniciarTransaccion();
        try {
            prestamo = prestamoDAO.buscar(codigo);
        } catch (Exception e) {
            gestorJDBC.cancelarTransaccion();
            throw e;
        }
        gestorJDBC.cancelarTransaccion();
        return prestamo;
    }
    
    public Ejemplar buscarLibro(int codigo)throws Exception{
        Ejemplar ejemplar;
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
}
