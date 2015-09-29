/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appbiblioteca.c2_aplicacion.servicio;

import appbiblioteca.c3_dominio.contrato.IAutorDAO;
import appbiblioteca.c3_dominio.contrato.ILibroDAO;
import appbiblioteca.c3_dominio.entidad.Autor;
import appbiblioteca.c3_dominio.entidad.Libro;
import appbiblioteca.c4_persistencia.GestorJDBC;
import appbiblioteca.c4_persistencia.fabricaDAO.FabricaAbstractaDAO;
import java.util.List;

/**
 *
 * @author CarlosAlfredo
 */
public class GestionarLibroServicio {
    GestorJDBC gestorJDBC;
    ILibroDAO libroDAO;
    IAutorDAO autorDAO;
    
    public GestionarLibroServicio(){
        FabricaAbstractaDAO fabricaAbstractaDAO = FabricaAbstractaDAO.getInstancia();
        gestorJDBC = fabricaAbstractaDAO.crearGestorJDBC();
        libroDAO = fabricaAbstractaDAO.crearLibroDAO(gestorJDBC);
        autorDAO = fabricaAbstractaDAO.crearAutorDAO(gestorJDBC);
    }
    
        public void crear(Libro libro) throws Exception{
        gestorJDBC.abrirConexion();
        try{
            libroDAO.crear(libro);
        }catch(Exception e){
            gestorJDBC.cerrarConexion();
            throw e;
        }
        gestorJDBC.cerrarConexion();
    }
    
    public void modificar(Libro libro) throws Exception{
        gestorJDBC.abrirConexion();
        try{
            libroDAO.modificar(libro);
        }catch(Exception e){
            gestorJDBC.cerrarConexion();
            throw e;
        }
        gestorJDBC.cerrarConexion();
    }
    
    public void eliminar(Libro libro) throws Exception{
        gestorJDBC.abrirConexion();
        try{
            libroDAO.eliminar(libro);
        }catch(Exception e){
            gestorJDBC.cerrarConexion();
            throw e;
        }
        gestorJDBC.cerrarConexion();
    }
    
    public Libro buscar(int codigolibro) throws Exception{
        Libro libro ;
        gestorJDBC.abrirConexion();
        try{
            libro = libroDAO.buscar(codigolibro);
        }catch(Exception e){
            gestorJDBC.cerrarConexion();
            throw e;
        }
        gestorJDBC.cerrarConexion();
        return libro;
    }
    
    public List<Libro> buscar(String nombre) throws Exception{
        List<Libro> listalibro;
        gestorJDBC.abrirConexion();
        try{
            listalibro = libroDAO.buscar(nombre);
        }catch(Exception e){
            gestorJDBC.cerrarConexion();
            throw e;
        }
        gestorJDBC.cerrarConexion();
        return listalibro;
    }
    
    public Autor buscarAutor(int codigo) throws Exception{
        Autor autor;
        gestorJDBC.abrirConexion();
        try {
            autor = autorDAO.buscar(codigo);
        } catch (Exception e) {
            gestorJDBC.cerrarConexion();
            throw e;
        }
        gestorJDBC.cerrarConexion();
        return autor;
    }
    
    public List<Autor> buscarAutor(String nombre) throws Exception{
        List<Autor> lineaAutor;
        gestorJDBC.abrirConexion();
        try {
            lineaAutor = autorDAO.buscar(nombre);
        } catch (Exception e) {
            gestorJDBC.cerrarConexion();
            throw e;
        }
        gestorJDBC.cerrarConexion();
        return lineaAutor;
    }
}

