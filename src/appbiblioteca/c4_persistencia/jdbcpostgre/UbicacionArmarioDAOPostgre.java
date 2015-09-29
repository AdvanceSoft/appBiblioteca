/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appbiblioteca.c4_persistencia.jdbcpostgre;

import appbiblioteca.c3_dominio.contrato.IUbicacionArmarioDAO;
import appbiblioteca.c3_dominio.entidad.UbicacionArmario;
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
 * <AdvanceSoft - Garcia Infante Petter Jhunior - advancesoft.trujillo@gmail.com>
 */
public class UbicacionArmarioDAOPostgre implements IUbicacionArmarioDAO{
    
    GestorJDBC gestorJDBC;
    
    public UbicacionArmarioDAOPostgre(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }
    @Override
    public void crear(UbicacionArmario ubicacionArmario) throws Exception {      
        PreparedStatement sentencia;
        String sentenciaSQL1 = "insert into ubicacionarmario(nombreubicacionarmario) values(?)";
        try {
            sentencia = gestorJDBC.prepararSentencia(sentenciaSQL1);
            sentencia.setString(1, ubicacionArmario.getNombre());
            sentencia.executeUpdate();
            sentencia.close();             
        } catch (SQLException  e) {
           throw ExcepcionSQL.crearErrorInsertar();
        }
    }

    @Override
    public void modificar(UbicacionArmario ubicacionArmario) throws Exception {
        String consulta = "update ubicacionarmario set nombreubicacionarmario = ? where codigoubicacionarmario = ?";
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(consulta);
        sentencia.setString(1, ubicacionArmario.getNombre());
        sentencia.setInt(2, ubicacionArmario.getCodigo());
        sentencia.executeUpdate();
    }

    @Override
    public void eliminar(UbicacionArmario ubicacionArmario) throws Exception {
        PreparedStatement sentencia;
        String sentenciaSQL1 ="delete from ubicacionarmario where codigoubicacionarmario = ?";
        try {
            sentencia=gestorJDBC.prepararSentencia(sentenciaSQL1); 
            sentencia.setInt(1, ubicacionArmario.getCodigo());
            sentencia.executeUpdate();
            sentencia.close();           
        } catch (Exception e) {
            throw ExcepcionSQL.crearErrorEliminar();
        }
    }

    @Override
    public UbicacionArmario buscar(int codigo) throws Exception {
       UbicacionArmario ubicacionArmario = null;      
        ResultSet resultado;
        String sentenciaSQL = "select codigoubicacionarmario,nombreubicacionarmario from ubicacionarmario where codigoubicacionarmario="+codigo;
        try {
            resultado=gestorJDBC.ejecutarConsulta(sentenciaSQL); 
            if(resultado.next()){
                ubicacionArmario = new UbicacionArmario();
                ubicacionArmario.setCodigo(resultado.getInt(1));
                ubicacionArmario.setNombre(resultado.getString(2));
            }
            resultado.close();            
        } catch (Exception e) {
            throw ExcepcionSQL.crearErrorConsultar();
        }
        return ubicacionArmario;
    }

    @Override
    public List<UbicacionArmario> buscar(String nombre) throws Exception {
        List<UbicacionArmario> ubicacionArmarios = new ArrayList();
        UbicacionArmario ubicacionArmario;      
        ResultSet resultado;
        if(nombre==null)
           nombre=""; 
        String sentenciaSQL1="select codigoubicacionarmario,nombreubicacionarmario from ubicacionarmario where nombreubicacionarmario like '%"+nombre+"%' order by codigoubicacionarmario desc";    
        try {
            resultado=gestorJDBC.ejecutarConsulta(sentenciaSQL1);
            while(resultado.next()){
                ubicacionArmario = new UbicacionArmario();
                ubicacionArmario.setCodigo(resultado.getInt(1));
                ubicacionArmario.setNombre(resultado.getString(2));
                ubicacionArmarios.add(ubicacionArmario);
            }
            resultado.close();
            return ubicacionArmarios;             
        } catch (Exception e) {
            throw ExcepcionSQL.crearErrorConsultar();
        }         
    }    
   
}
