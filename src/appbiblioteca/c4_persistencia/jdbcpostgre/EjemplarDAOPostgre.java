/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appbiblioteca.c4_persistencia.jdbcpostgre;

import appbiblioteca.c3_dominio.contrato.IEjemplarDAO;
import appbiblioteca.c3_dominio.entidad.Ejemplar;
import appbiblioteca.c3_dominio.entidad.Especialidad;
import appbiblioteca.c3_dominio.entidad.Libro;
import appbiblioteca.c3_dominio.entidad.Nivel;
import appbiblioteca.c3_dominio.entidad.UbicacionArmario;
import appbiblioteca.c3_dominio.entidad.UbicacionFila;
import appbiblioteca.c3_dominio.entidad.UbicacionPiso;
import appbiblioteca.c4_persistencia.GestorJDBC;
import appbiblioteca.c5_transversal.excepcion.ExcepcionSQL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author
 * <AdvanceSoft - Mendoza Torres Valentin - advancesoft.trujillo@gmail.com>
 */
public class EjemplarDAOPostgre implements  IEjemplarDAO{
    GestorJDBC gestorJDBC; 

    public EjemplarDAOPostgre(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }

    @Override
    public void crear(Ejemplar ejemplar) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificar(Ejemplar ejemplar) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Ejemplar ejemplar) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Ejemplar buscar(int codigo) throws Exception {
       Ejemplar ejemplar = null;
       ResultSet resultado;
       String sentenciaSQL = "select e.codigoejemplar,e.cantidadejemplar, l.codigolibro,l.nombrelibro, n.codigonivel, n.nombrenivel, es.codigoespecialidad, es.nombreespecialidad from libro l inner join ejemplar e on l.codigolibro=e.codigolibro inner join nivel n on l.codigonivel=n.codigonivel inner join especialidad es on l.codigoespecialidad=es.codigoespecialidad where e.codigoejemplar="+codigo;
        try {
            resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
            if(resultado.next()){
                ejemplar = obtenerObjetoEjemplar(resultado);                
            }
            resultado.close();
        } catch (Exception e) {
            throw ExcepcionSQL.crearErrorConsultar();
        }
        return ejemplar;
    }

    @Override
    public List<Ejemplar> buscar(String nombre) throws Exception {
       String consulta = "select e.codigoejemplar,e.cantidadejemplar, l.codigolibro,l.nombrelibro, n.codigonivel, n.nombrenivel, es.codigoespecialidad, es.nombreespecialidad from libro l inner join ejemplar e on l.codigolibro=e.codigolibro inner join nivel n on l.codigonivel=n.codigonivel inner join especialidad es on l.codigoespecialidad=es.codigoespecialidad where l.nombrelibro like '%"+nombre+"%'";
       ResultSet resultado = gestorJDBC.ejecutarConsulta(consulta);
       Ejemplar ejemplar;
       ArrayList<Ejemplar> listaEjemplares = new ArrayList<>();
       while(resultado.next()){
            ejemplar = new Ejemplar();
            ejemplar.setCodigo(resultado.getInt(1));
            ejemplar.setCantidad(resultado.getInt(2));
            Libro libro;
            libro = new Libro();
            libro.setCodigo(resultado.getInt(3));
            libro.setNombre(resultado.getString(4));
            Nivel nivel;
            nivel = new Nivel();
            nivel.setCodigo(resultado.getInt(5));
            nivel.setNombre(resultado.getString(6));
            Especialidad especialidad;
            especialidad = new Especialidad();
            especialidad.setCodigo(resultado.getInt(7));
            especialidad.setNombre(resultado.getString(8));
            libro.setNivel(nivel);
            libro.setEspecialidad(especialidad);
            ejemplar.setLibro(libro);
            listaEjemplares.add(ejemplar);
        }
        return listaEjemplares;
    }

    @Override
    public Ejemplar buscarLibro(String nombre) throws Exception {
        ResultSet resultado;
        Ejemplar ejemplar = null;
        String sql= "select e.codigoejemplar,e.cantidadejemplar, l.codigolibro,l.nombrelibro, n.codigonivel, n.nombrenivel, es.codigoespecialidad, es.nombreespecialidad from libro l inner join ejemplar e on l.codigolibro=e.codigolibro inner join nivel n on l.codigonivel=n.codigonivel inner join especialidad es on l.codigoespecialidad=es.codigoespecialidad where l.nombrelibro like '%"+nombre+"%'";
        try {
            resultado = gestorJDBC.ejecutarConsulta(sql);
            if(resultado.next()){
                ejemplar = obtenerObjetoEjemplar(resultado);                
            }
            resultado.close();
        } catch (Exception e) {
            throw ExcepcionSQL.crearErrorConsultar();
        }
        return ejemplar;
    }
    
    private Ejemplar obtenerObjetoEjemplar(ResultSet resultado) throws SQLException {
        Ejemplar ejemplar;
        ejemplar = new Ejemplar();
        ejemplar.setCodigo(resultado.getInt(1));
        ejemplar.setCantidad(resultado.getInt(2));
        Libro libro;
        libro = new Libro();
        libro.setCodigo(resultado.getInt(3));
        libro.setNombre(resultado.getString(4));
        Nivel nivel;
        nivel = new Nivel();
        nivel.setCodigo(resultado.getInt(5));
        nivel.setNombre(resultado.getString(6));
        Especialidad especialidad;
        especialidad = new Especialidad();
        especialidad.setCodigo(resultado.getInt(7));
        especialidad.setNombre(resultado.getString(8));
        libro.setNivel(nivel);
        libro.setEspecialidad(especialidad);
        ejemplar.setLibro(libro);
        return ejemplar;
    }
    
}
