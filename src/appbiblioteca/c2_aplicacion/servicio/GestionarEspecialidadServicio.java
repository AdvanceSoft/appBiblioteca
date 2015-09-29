/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appbiblioteca.c2_aplicacion.servicio;

import appbiblioteca.c3_dominio.contrato.IEspecialidadDAO;
import appbiblioteca.c3_dominio.entidad.Especialidad;
import appbiblioteca.c4_persistencia.GestorJDBC;
import appbiblioteca.c4_persistencia.fabricaDAO.FabricaAbstractaDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author CarlosAlfredo
 */
public class GestionarEspecialidadServicio {
    GestorJDBC gestorJDBC;
    IEspecialidadDAO especialidadDAO;

    public GestionarEspecialidadServicio() {
        FabricaAbstractaDAO fabricaAbstractaDAO = FabricaAbstractaDAO.getInstancia();
        gestorJDBC = fabricaAbstractaDAO.crearGestorJDBC();
        especialidadDAO = fabricaAbstractaDAO.crearEspecialidadDAO(gestorJDBC);
    }
    
    public void crear(Especialidad especialidad) throws Exception{
        gestorJDBC.abrirConexion();
        try {
            especialidadDAO.crear(especialidad);
        } catch (Exception e) {
            gestorJDBC.cerrarConexion();
            throw e;
        }
        gestorJDBC.cerrarConexion();
    }
    
    public void modificar(Especialidad especialidad) throws Exception{
        gestorJDBC.abrirConexion();
        try {
            especialidadDAO.modificar(especialidad);
        } catch (Exception e) {
            gestorJDBC.cerrarConexion();
            throw e;
        }
        gestorJDBC.cerrarConexion();
    }
    
    public void eliminar(Especialidad especialidad) throws Exception{
        gestorJDBC.abrirConexion();
        try {
            especialidadDAO.elimiar(especialidad);
        } catch (Exception e) {
            gestorJDBC.cerrarConexion();
            throw e;
        }
        gestorJDBC.cerrarConexion();
    }
    
    public Especialidad buscar(int codigo) throws Exception{
        Especialidad especialidad = null;
        gestorJDBC.abrirConexion();
        try {
            especialidad = especialidadDAO.buscar(codigo);
        } catch (Exception e) {
            gestorJDBC.cerrarConexion();
            throw e;
        }
        gestorJDBC.cerrarConexion();
        return especialidad;
    }
    
    public List<Especialidad> buscar(String nombre) throws Exception{
        List<Especialidad> listaEspecialidad;
        gestorJDBC.abrirConexion();
        try {
            listaEspecialidad = especialidadDAO.buscar(nombre);
        } catch (Exception e) {
            gestorJDBC.cerrarConexion();
            throw e;
        }
        gestorJDBC.cerrarConexion();
        return listaEspecialidad;
    }
    
    public ArrayList<Especialidad> buscarPorNombre(String nombre) throws Exception {
        ArrayList<Especialidad> listaEspecialidad;
        gestorJDBC.abrirConexion();
        try {
            listaEspecialidad = especialidadDAO.buscarPorNombre(nombre);
        } catch (Exception e) {
            gestorJDBC.cerrarConexion();
            throw e;
        }        
        gestorJDBC.cerrarConexion();
        return listaEspecialidad;
    }
}
