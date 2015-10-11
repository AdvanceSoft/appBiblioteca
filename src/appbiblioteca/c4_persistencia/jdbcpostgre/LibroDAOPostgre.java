/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appbiblioteca.c4_persistencia.jdbcpostgre;

import appbiblioteca.c3_dominio.contrato.ILibroDAO;
import appbiblioteca.c3_dominio.entidad.Autor;
import appbiblioteca.c3_dominio.entidad.Especialidad;
import appbiblioteca.c3_dominio.entidad.Libro;
import appbiblioteca.c3_dominio.entidad.LineaAutor;
import appbiblioteca.c3_dominio.entidad.Nivel;
import appbiblioteca.c4_persistencia.GestorJDBC;
import appbiblioteca.c5_transversal.excepcion.ExcepcionSQL;
import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author 
 * <AdvanceSoft - Osorio Perez Carlos Alfredo - advancesoft.trujillo@gmail.com>
 */
public class LibroDAOPostgre implements ILibroDAO{
        GestorJDBC gestorJDBC;
    
    public LibroDAOPostgre (GestorJDBC gestorJDBC){
        this.gestorJDBC = gestorJDBC;
    }

    @Override
    public void crear(Libro libro) throws Exception {
        int ultimo_libro = 0; 
        PreparedStatement sentencia;
        ResultSet resultado;
        String consulta1="insert into libro(stickerlibro,nombrelibro,isbnlibro,descripcionlibro,activolibro,codigonivel,codigoespecialidad) values(?,?,?,?,?,?,?)";
        String consulta2="select max(codigolibro)as ultimo_libro from libro";
        String consulta3="INSERT INTO lineautor(codigoautor, codigolibro) VALUES (?, ?);";
        try {
            sentencia=gestorJDBC.prepararSentencia(consulta1);
            sentencia.setString(1,libro.getSticker());
            sentencia.setString(2,libro.getNombre());
            sentencia.setString(3,libro.getIsbn());
            sentencia.setString(4,libro.getDescripcion());
            sentencia.setBoolean(5, libro.isActivo());
            sentencia.setInt(6,libro.getNivel().getCodigo());
            sentencia.setInt(7,libro.getEspecialidad().getCodigo());
            sentencia.executeUpdate();
            sentencia.close();
            sentencia=gestorJDBC.prepararSentencia(consulta2);
            resultado=sentencia.executeQuery();
            if(resultado.next())
                ultimo_libro=resultado.getInt("ultimo_libro");
            else 
                JOptionPane.showInputDialog(null,"ERROR Resultado Ultimo Libro LibroDAOPostgre");
            resultado.close();
            sentencia.close();
            for(LineaAutor lineaAutor: libro.getLineaAutor()){
                sentencia=gestorJDBC.prepararSentencia(consulta3);
                sentencia.setInt(1,lineaAutor.getAutor().getCodigo());
                sentencia.setInt(2,ultimo_libro);                
                sentencia.executeUpdate();
                sentencia.close();
            }
        } catch (SQLException | HeadlessException e) {
           throw ExcepcionSQL.crearErrorInsertar();
        } 

    }

    @Override
    public void modificar(Libro libro) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Libro libro) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Libro buscar(int codigolibro) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Libro> buscar(String nombre) throws Exception {
        Libro libro;
        Nivel nivel;
        Especialidad especialidad;
        ResultSet resultado;
        List<Libro> listalibro = new ArrayList<>();
        String sql= "select l.codigolibro, e.codigoespecialidad, n.codigonivel, l.stickerlibro, l.nombrelibro, l.isbnlibro, l.descripcionlibro, l.activolibro FROM libro l inner join especialidad e on l.codigoespecialidad=e.codigoespecialidad inner join nivel n on l.codigonivel=n.codigonivel where l.nombrelibro like '%"+nombre+"%'";
        try {
            resultado = gestorJDBC.ejecutarConsulta(sql);
            while(resultado.next()){
                libro = new Libro();
                libro.setCodigo(resultado.getInt(1));
                especialidad= new Especialidad();
                especialidad.setCodigo(resultado.getInt(2));
                libro.setEspecialidad(especialidad);
                nivel = new Nivel();
                nivel.setCodigo(resultado.getInt(3));
                libro.setNivel(nivel);
                libro.setSticker(resultado.getString(4));
                libro.setNombre(resultado.getString(5));               
                libro.setIsbn(resultado.getString(6));
                libro.setDescripcion(resultado.getString(7));
                libro.setActivo(resultado.getBoolean(8));
                listalibro.add(libro);
            }
        } catch (Exception e) {
            throw ExcepcionSQL.crearErrorConsultar();
        }
        return listalibro;
    }

    @Override
    public Libro buscaPorSticker(String sticker) throws Exception {
        Libro libro = new Libro();
        Nivel nivel;
        Especialidad especialidad;
        Autor autor;
        LineaAutor lineaAutor;
        ResultSet resultado;
        String sql= "select " +
                    "l.codigolibro,l.stickerlibro,l.nombrelibro,l.isbnlibro,l.descripcionlibro,l.activolibro, " +
                    "e.codigoespecialidad,e.nombreespecialidad,e.descripcionespecialidad, " +
                    "n.codigonivel,n.nombrenivel,n.descripcionnivel, " +
                    "a.codigoautor,a.nombreautor,a.apellidoautor " +
                    "from libro as l " +
                    "join nivel as n on l.codigonivel = n.codigonivel " +
                    "join especialidad as e on l.codigoespecialidad = e.codigoespecialidad " +
                    "join lineautor la on l.codigolibro = la.codigolibro " +
                    "join autor a on la.codigoautor=a.codigoautor " +
                    "where l.stickerlibro = '"+sticker+"'";
        try {
            resultado = gestorJDBC.ejecutarConsulta(sql);
            while(resultado.next()){
                libro.setCodigo(resultado.getInt(1));
                libro.setSticker(resultado.getString(2));
                libro.setNombre(resultado.getString(3));
                libro.setIsbn(resultado.getString(4));
                libro.setDescripcion(resultado.getString(5));
                libro.setActivo(resultado.getBoolean(6));
                especialidad = new Especialidad();
                especialidad.setCodigo(resultado.getInt(7));
                especialidad.setNombre(resultado.getString(8));
                especialidad.setDescripcion(resultado.getString(9));
                libro.setEspecialidad(especialidad);
                nivel = new Nivel();
                nivel.setCodigo(resultado.getInt(10));
                nivel.setNombre(resultado.getString(11));
                nivel.setDescripcion(resultado.getString(12));
                libro.setNivel(nivel);
                autor = new Autor();
                autor.setCodigo(resultado.getInt(13));
                autor.setNombre(resultado.getString(14));
                autor.setApellido(resultado.getString(15));
                lineaAutor = new LineaAutor();
                lineaAutor.setAutor(autor);
                libro.agregarAutor(lineaAutor);
            }
        } catch (Exception e) {
            throw ExcepcionSQL.crearErrorConsultar();
        }
        return libro;
    }
    
    
        
}
