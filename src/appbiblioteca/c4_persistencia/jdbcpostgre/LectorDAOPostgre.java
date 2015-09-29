/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appbiblioteca.c4_persistencia.jdbcpostgre;

import appbiblioteca.c3_dominio.contrato.ILectorDAO;
import appbiblioteca.c3_dominio.entidad.Lector;
import appbiblioteca.c4_persistencia.GestorJDBC;
import appbiblioteca.c5_transversal.excepcion.ExcepcionSQL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author
 * <AdvanceSoft - Medrano Parado Sandra Zoraida - advancesoft.trujillo@gmail.com>
 * @version 1.0 
 * @created 02-agost-2015 01:46:00 p.m.
 */
public class LectorDAOPostgre implements ILectorDAO{
    GestorJDBC gestorJDBC;

    public LectorDAOPostgre(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }
    
    @Override
    public void crear(Lector lector) throws Exception {
       
        PreparedStatement sentencia;
        String sql = "insert into lector(nombrelector,apellidolector,dnilector,generolector,fechanacimientolector,telefonolector,correolector) values(?,?,?,?,?,?,?)";
        try {
            sentencia = gestorJDBC.prepararSentencia(sql);
            sentencia.setString(1, lector.getNombre());
            sentencia.setString(2, lector.getApellido());
            sentencia.setString(3, lector.getDni());
            sentencia.setString(4, lector.getGenero());
            sentencia.setDate(5, lector.getFechanacimiento());
            sentencia.setString(6, lector.getTelefono());
            sentencia.setString(7, lector.getCorreo());
            sentencia.executeUpdate();
        } catch (Exception e) {
            throw ExcepcionSQL.crearErrorInsertar();
        }
    }

    @Override
    public void modificar(Lector lector) throws Exception {
        PreparedStatement sentencia;
        String sql = "update lector set nombrelector=?,apellidolector=?,dnilector=?,generolector=?,fechanacimientolector=?,telefonolector=?,correolector=? where codigolector=?";
        try{
        sentencia = gestorJDBC.prepararSentencia(sql);
        sentencia.setString(1, lector.getNombre());
        sentencia.setString(2, lector.getApellido());
        sentencia.setString(3, lector.getDni());
        sentencia.setString(4, lector.getGenero());
        sentencia.setDate(5, lector.getFechanacimiento());
        sentencia.setString(6, lector.getTelefono());
        sentencia.setString(7, lector.getCorreo());
        sentencia.setInt(8, lector.getCodigo());
        sentencia.executeUpdate();
        } catch (Exception e){
            throw ExcepcionSQL.crearErrorModificar();
        }
        
    }
    @Override
    public void eliminar(Lector lector) throws Exception {
        PreparedStatement sentencia;
        String sql ="delete from lector where codigolector=?";
        try{
            sentencia = gestorJDBC.prepararSentencia(sql);
            sentencia.setInt(1, lector.getCodigo());
            sentencia.executeUpdate();
        }
        catch(Exception e){
            throw ExcepcionSQL.crearErrorEliminar();
        }
    }

    @Override
    public Lector buscar(int codigo) throws Exception {
        Lector lector = null;
        ResultSet resultado;
        String sql = "select codigolector,nombrelector,apellidolector,dnilector,generolector,fechanacimientolector,telefonolector,correolector from lector where codigolector="+codigo;
        try {
            resultado = gestorJDBC.ejecutarConsulta(sql);
            if(resultado.next()){
                lector =  new Lector();
                lector.setCodigo(resultado.getInt(1));
                lector.setNombre(resultado.getString(2));
                lector.setApellido(resultado.getString(3));
                lector.setDni(resultado.getString(4));
                lector.setGenero(resultado.getString(5));
                lector.setFechanacimiento(resultado.getDate(6));
                lector.setTelefono(resultado.getString(7));
                lector.setCorreo(resultado.getString(8));
            }
            resultado.close();
        } catch (Exception e) {
            throw ExcepcionSQL.crearErrorConsultar();
        }
    return lector;
    }

    @Override
    public List<Lector> buscar(String nombre) throws Exception {
        Lector lector;
        ResultSet resultado;
        List<Lector> listalector = new ArrayList<>();
        String sql= "select codigolector,nombrelector,apellidolector,dnilector,generolector,fechanacimientolector,telefonolector,correolector from lector where nombrelector like '%"+nombre+"%'";
        try {
            resultado = gestorJDBC.ejecutarConsulta(sql);
            while(resultado.next()){
                lector = new Lector();
                lector.setCodigo(resultado.getInt(1));
                lector.setNombre(resultado.getString(2));
                lector.setApellido(resultado.getString(3));
                lector.setDni(resultado.getString(4));
                lector.setGenero(resultado.getString(5));
                lector.setFechanacimiento(resultado.getDate(6));
                lector.setTelefono(resultado.getString(7));
                lector.setCorreo(resultado.getString(8));
                listalector.add(lector);
            }
        } catch (Exception e) {
            throw ExcepcionSQL.crearErrorConsultar();
        }
        return listalector;
    }

    @Override
    public Lector buscarPorDNI(String dni) throws Exception {
        Lector lector=null; 
        ResultSet resultado; 
        String sentenciaSQL="select codigolector, apellidolector, nombrelector, dnilector from lector where dnilector = '"+dni+"'"; 
        try {            
            resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
            if(resultado.next()){
                lector = obtenerObjetoLector(lector, resultado);
            }
                  
        } catch (Exception e) {
            throw ExcepcionSQL.crearErrorConsultar();
        }    
        resultado.close();
        return lector;
    }
    
    private Lector obtenerObjetoLector(Lector lector, ResultSet resultado) throws SQLException {
        lector = new Lector();
        lector.setCodigo(resultado.getInt(1));
        lector.setApellido(resultado.getString(2));
        lector.setNombre(resultado.getString(3));
        lector.setDni(resultado.getString(4));
        return lector;
    }
}
