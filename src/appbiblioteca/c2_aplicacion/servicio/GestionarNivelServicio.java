/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appbiblioteca.c2_aplicacion.servicio;

import appbiblioteca.c3_dominio.contrato.IEspecialidadDAO;
import appbiblioteca.c3_dominio.contrato.INivelDAO;
import appbiblioteca.c3_dominio.entidad.Especialidad;
import appbiblioteca.c3_dominio.entidad.LineaEspecialidad;
import appbiblioteca.c3_dominio.entidad.Nivel;
import appbiblioteca.c4_persistencia.GestorJDBC;
import appbiblioteca.c4_persistencia.fabricaDAO.FabricaAbstractaDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author CarlosAlfredo
 */
public class GestionarNivelServicio {
    GestorJDBC gestorJDBC;
    INivelDAO nivelDAO;
    IEspecialidadDAO especialidadDAO;
    
    public GestionarNivelServicio(){
        FabricaAbstractaDAO fabricaAbstractaDAO = FabricaAbstractaDAO.getInstancia();
        gestorJDBC = fabricaAbstractaDAO.crearGestorJDBC();
        nivelDAO = fabricaAbstractaDAO.crearNivelDAO(gestorJDBC);
        especialidadDAO = fabricaAbstractaDAO.crearEspecialidadDAO(gestorJDBC);
    }
    
    public void crear(Nivel nivel) throws Exception{
        gestorJDBC.abrirConexion();
        try{
            nivelDAO.crear(nivel);
        }catch(Exception e){
            gestorJDBC.cerrarConexion();
            throw e;
        }
        gestorJDBC.cerrarConexion();
    }
    
    public void modificar(Nivel nivel) throws Exception{
        gestorJDBC.abrirConexion();
        try{
            nivelDAO.modificar(nivel);
        }catch(Exception e){
            gestorJDBC.cerrarConexion();
            throw e;
        }
        gestorJDBC.cerrarConexion();
    }
    
    public void eliminar(Nivel nivel) throws Exception{
        gestorJDBC.abrirConexion();
        try{
            nivelDAO.eliminar(nivel);
        }catch(Exception e){
            gestorJDBC.cerrarConexion();
            throw e;
        }
        gestorJDBC.cerrarConexion();
    }
    
    public Nivel buscar(int codigonivel) throws Exception{
        Nivel nivel ;
        gestorJDBC.abrirConexion();
        try{
            nivel = nivelDAO.buscar(codigonivel);
        }catch(Exception e){
            gestorJDBC.cerrarConexion();
            throw e;
        }
        gestorJDBC.cerrarConexion();
        return nivel;
    }
    
    public List<Nivel> buscar(String nombre) throws Exception{
        List<Nivel> listanivel;
        gestorJDBC.abrirConexion();
        try{
            listanivel = nivelDAO.buscar(nombre);
        }catch(Exception e){
            gestorJDBC.cerrarConexion();
            throw e;
        }
        gestorJDBC.cerrarConexion();
        return listanivel;
    }
    
    public Especialidad buscarEspecialidad(int codigo) throws Exception{
        Especialidad especialidad;
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
    
    public List<Especialidad> buscarEspecialidad(String nombre) throws Exception{
        List<Especialidad> lineaEspecialidad;
        gestorJDBC.abrirConexion();
        try {
            lineaEspecialidad = especialidadDAO.buscar(nombre);
        } catch (Exception e) {
            gestorJDBC.cerrarConexion();
            throw e;
        }
        gestorJDBC.cerrarConexion();
        return lineaEspecialidad;
    }
    public List<Nivel> buscarPorNombre(String nombre) throws Exception {
        List<Nivel> listaNivel = null;
        gestorJDBC.abrirConexion();        
        try {            
            listaNivel = nivelDAO.buscar(nombre);
        
        } catch (Exception e) {
            gestorJDBC.cerrarConexion();
            throw e;
        }
        gestorJDBC.cerrarConexion();
        return listaNivel;
    }
    
    public List<LineaEspecialidad> buscarLineaEspecialidad(int codigonivel)throws Exception{
        List<LineaEspecialidad> lineaEspecialidades;
        gestorJDBC.abrirConexion();
        try {
            lineaEspecialidades = nivelDAO.buscarLineaEspecialidad(codigonivel);
        } catch (Exception e) {
            gestorJDBC.cerrarConexion();
            throw e;
        }
        gestorJDBC.cerrarConexion();
        return lineaEspecialidades;
            
        
    }
}
