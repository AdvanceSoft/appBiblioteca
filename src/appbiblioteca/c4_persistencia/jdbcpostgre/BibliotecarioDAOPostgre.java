/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appbiblioteca.c4_persistencia.jdbcpostgre;

import appbiblioteca.c3_dominio.contrato.IBibliotecarioDAO;
import appbiblioteca.c3_dominio.entidad.Bibliotecario;
import appbiblioteca.c4_persistencia.GestorJDBC;
import appbiblioteca.c5_transversal.excepcion.ExcepcionSQL;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author
 * <AdvanceSoft - Medrano Parado Sandra Zoraida - advancesoft.trujillo@gmail.com>
 * @version 1.0 
 * @created 04-ago-2015 07:40:00 p.m.
 */
public class BibliotecarioDAOPostgre implements IBibliotecarioDAO{
    GestorJDBC gestorJDBC;

    public BibliotecarioDAOPostgre(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }

    @Override
    public void crear(Bibliotecario bibliotecario) throws Exception {
        PreparedStatement sentencia;
        String sql = "insert into bibliotecario(nombrebibliotecario,apellidobibliotecario,dnibibliotecario,generobibliotecario,fechanacimientobibliotecario,telefonobibliotecario,correobibliotecario) values(?,?,?,?,?,?,?)";
        try {
            sentencia = gestorJDBC.prepararSentencia(sql);
            sentencia.setString(1, bibliotecario.getNombre());
            sentencia.setString(2, bibliotecario.getApellido());
            sentencia.setString(3, bibliotecario.getDni());
            sentencia.setString(4, bibliotecario.getGenero());
            sentencia.setDate(5, bibliotecario.getFechanacimiento());
            sentencia.setString(6, bibliotecario.getTelefono());
            sentencia.setString(7, bibliotecario.getCorreo());
            sentencia.executeUpdate();
        } catch (Exception e) {
            throw ExcepcionSQL.crearErrorInsertar();
        }
    }

    @Override
    public void modificar(Bibliotecario bibliotecario) throws Exception {
        PreparedStatement sentencia;
        String sql = "update bibliotecario set nombrebibliotecario=?,apellidobibliotecario=?,dnibibliotecario=?,generobibliotecario=?,\n"
                    + "fechanacimientobibliotecario=?,telefonobibliotecario=?,correobibliotecario=? where codigobibliotecario=?";
        try{
        sentencia = gestorJDBC.prepararSentencia(sql);
        sentencia.setString(1, bibliotecario.getNombre());
        sentencia.setString(2, bibliotecario.getApellido());
        sentencia.setString(3, bibliotecario.getDni());
        sentencia.setString(4, bibliotecario.getGenero());
        sentencia.setDate(5, bibliotecario.getFechanacimiento());
        sentencia.setString(6, bibliotecario.getTelefono());
        sentencia.setString(7, bibliotecario.getCorreo());
        sentencia.setInt(8, bibliotecario.getCodigo());
        sentencia.executeUpdate();
        }catch (Exception e){
            throw ExcepcionSQL.crearErrorModificar();
        }
        
    }

    @Override
    public void eliminar(Bibliotecario bibliotecario) throws Exception {
        PreparedStatement sentencia;
        String sql ="delete from bibliotecario where codigobibliotecario=?";
        try{
            sentencia = gestorJDBC.prepararSentencia(sql);
            sentencia.setInt(1, bibliotecario.getCodigo());
            sentencia.executeUpdate();
            sentencia.close();
        }
        catch(Exception e){
            throw ExcepcionSQL.crearErrorEliminar();
        } 
    }

    @Override
    public Bibliotecario buscar(int codigo) throws Exception {
        Bibliotecario bibliotecario = null;
        ResultSet resultado;
        String sql1 = "select codigobibliotecario,nombrebibliotecario,apellidobibliotecario,dnibibliotecario,generobibliotecario,fechanacimientobibliotecario,telefonobibliotecario,correobibliotecario from bibliotecario where codigobibliotecario="+codigo;
        try {
            resultado = gestorJDBC.ejecutarConsulta(sql1);
            if(resultado.next()){
                bibliotecario = new Bibliotecario();
                bibliotecario.setCodigo(resultado.getInt(1));
                bibliotecario.setNombre(resultado.getString(2));
                bibliotecario.setApellido(resultado.getString(3));
                bibliotecario.setDni(resultado.getString(4));
                bibliotecario.setGenero(resultado.getString(5));
                bibliotecario.setFechanacimiento(resultado.getDate(6));
                bibliotecario.setTelefono(resultado.getString(7));
                bibliotecario.setCorreo(resultado.getString(8));
            }
            resultado.close();
        } catch (Exception e) {
            throw ExcepcionSQL.crearErrorConsultar();
        }
    return bibliotecario;
    }

    @Override
    public List<Bibliotecario> buscar(String nombre) throws Exception {
        ResultSet resultado;
        List<Bibliotecario> listabibliotecario = new ArrayList<>();
        String sql= "select codigobibliotecario,nombrebibliotecario,apellidobibliotecario,dnibibliotecario,generobibliotecario,fechanacimientobibliotecario,\n"
                    + " telefonobibliotecario,correobibliotecario from bibliotecario where nombrebibliotecario like '%"+nombre+"%'";
        try {
            resultado = gestorJDBC.ejecutarConsulta(sql);
            while(resultado.next()){
                Bibliotecario bibliotecario = new Bibliotecario();
                bibliotecario.setCodigo(resultado.getInt(1));
                bibliotecario.setNombre(resultado.getString(2));
                bibliotecario.setApellido(resultado.getString(3));
                bibliotecario.setDni(resultado.getString(4));
                bibliotecario.setGenero(resultado.getString(5));
                bibliotecario.setFechanacimiento(resultado.getDate(6));
                bibliotecario.setTelefono(resultado.getString(7));
                bibliotecario.setCorreo(resultado.getString(8));
                listabibliotecario.add(bibliotecario);
            }
            resultado.close();
        } catch (Exception e) {
            throw ExcepcionSQL.crearErrorConsultar();
        }
        return listabibliotecario;
    }
    
}
