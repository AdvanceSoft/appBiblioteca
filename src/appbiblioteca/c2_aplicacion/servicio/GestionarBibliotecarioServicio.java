/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appbiblioteca.c2_aplicacion.servicio;

import appbiblioteca.c3_dominio.contrato.IBibliotecarioDAO;
import appbiblioteca.c3_dominio.entidad.Bibliotecario;
import appbiblioteca.c4_persistencia.GestorJDBC;
import appbiblioteca.c4_persistencia.fabricaDAO.FabricaAbstractaDAO;
import java.util.List;

/**
 *
 * @author
 * <AdvanceSoft - Medrano Parado Sandra Zoraida - advancesoft.trujillo@gmail.com>
 * @version 1.0
 */
public class GestionarBibliotecarioServicio{

    GestorJDBC gestorJDBC;
    IBibliotecarioDAO bibliotecarioDAO;

    public GestionarBibliotecarioServicio() {
        FabricaAbstractaDAO fabricaAbstractaDAO = FabricaAbstractaDAO.getInstancia();
        gestorJDBC = fabricaAbstractaDAO.crearGestorJDBC();
        bibliotecarioDAO = fabricaAbstractaDAO.crearBibliotecarioDAO(gestorJDBC);
    }
   
    public void crear(Bibliotecario bibliotecario) throws Exception {
        gestorJDBC.abrirConexion();
        try {
            bibliotecarioDAO.crear(bibliotecario);
        } catch (Exception e) {
            gestorJDBC.cerrarConexion();
            throw e;
        }
        gestorJDBC.cerrarConexion();
    }

    public void modificar(Bibliotecario bibliotecario) throws Exception {
        gestorJDBC.abrirConexion();
        try {
            bibliotecarioDAO.modificar(bibliotecario);
        } catch (Exception e) {
            gestorJDBC.cerrarConexion();
            throw e;
        }
        gestorJDBC.cerrarConexion();
    }

    public void eliminar(Bibliotecario bibliotecario) throws Exception {
        gestorJDBC.abrirConexion();
        try {
            bibliotecarioDAO.eliminar(bibliotecario);
        } catch (Exception e) {
            gestorJDBC.cerrarConexion();
            throw e;
        }
        gestorJDBC.cerrarConexion();
    }

    public Bibliotecario buscar(int codigo) throws Exception {
        Bibliotecario bibliotecario;
        gestorJDBC.abrirConexion();
        try {
            bibliotecario = bibliotecarioDAO.buscar(codigo);
        } catch (Exception e) {
            gestorJDBC.cerrarConexion();
            throw e;
        }
        gestorJDBC.cerrarConexion();
        return bibliotecario;
    }

    public List<Bibliotecario> buscar(String nombre) throws Exception {
        List<Bibliotecario> listabibliotecario;
        gestorJDBC.abrirConexion();
        try {
            listabibliotecario = bibliotecarioDAO.buscar(nombre);
        } catch (Exception e) {
            gestorJDBC.cerrarConexion();
            throw e;
        }
        gestorJDBC.cerrarConexion();
        return listabibliotecario;
    }
    
}
