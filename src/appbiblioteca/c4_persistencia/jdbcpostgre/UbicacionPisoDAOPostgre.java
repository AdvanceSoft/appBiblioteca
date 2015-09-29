/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appbiblioteca.c4_persistencia.jdbcpostgre;

import appbiblioteca.c3_dominio.contrato.IUbicacionPisoDAO;
import appbiblioteca.c3_dominio.entidad.UbicacionArmario;
import appbiblioteca.c3_dominio.entidad.UbicacionPiso;
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
public class UbicacionPisoDAOPostgre implements IUbicacionPisoDAO{

    GestorJDBC gestorJDBC;
    
    public UbicacionPisoDAOPostgre(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }
    
    @Override
    public void crear(UbicacionPiso ubicacionPiso) throws Exception {
        PreparedStatement sentencia;
        String sentenciaSQL1 = "insert into ubicacionpiso(nombreubicacionpiso) values(?);";
        try {
            //Se realiza la operacion para la primera sentencia SQL1 
            sentencia = gestorJDBC.prepararSentencia(sentenciaSQL1);
            sentencia.setString(1, ubicacionPiso.getNombre());
            sentencia.executeUpdate();
            sentencia.close();                   
        } catch (SQLException e) {
           throw ExcepcionSQL.crearErrorInsertar();
        }
    }

    @Override
    public void modificar(UbicacionPiso ubicacionPiso) throws Exception {
        String consulta = "update ubicacionpiso set nombreubicacionpiso = ? where codigoubicacionpiso = ?";
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(consulta);
        sentencia.setString(1, ubicacionPiso.getNombre());
        sentencia.setInt(2, ubicacionPiso.getCodigo());
        sentencia.executeUpdate();
    }

    @Override
    public void eliminar(UbicacionPiso ubicacionPiso) throws Exception {
        PreparedStatement sentencia;
        String sentenciaSQL1 ="delete from ubicacionpiso where codigoubicacionpiso = ?";
        try {            
            sentencia=gestorJDBC.prepararSentencia(sentenciaSQL1); 
            sentencia.setInt(1, ubicacionPiso.getCodigo());
            sentencia.executeUpdate();
            sentencia.close();           
        } catch (Exception e) {
            throw ExcepcionSQL.crearErrorEliminar();
        }
    }

    @Override
    public UbicacionPiso buscar(int codigo) throws Exception {
        UbicacionPiso ubicacionPiso = null;      
        ResultSet resultado;
        String sentenciaSQL = "select codigoubicacionpiso,nombreubicacionpiso from ubicacionpiso where codigoubicacionpiso="+codigo;
        try {
            resultado=gestorJDBC.ejecutarConsulta(sentenciaSQL); 
            if(resultado.next()){
                ubicacionPiso = new UbicacionPiso();
                ubicacionPiso.setCodigo(resultado.getInt(1));
                ubicacionPiso.setNombre(resultado.getString(2));
            }
            resultado.close();
            return ubicacionPiso;
        } catch (Exception e) {
            throw ExcepcionSQL.crearErrorConsultar();
        }  
    }

    @Override
    public List<UbicacionPiso> buscar(String nombre) throws Exception {
        List<UbicacionPiso> ubicacionPisos = new ArrayList();
        UbicacionPiso ubicacionPiso;      
        ResultSet resultado;
        if(nombre==null)
           nombre=""; 
        String sentenciaSQL1="select codigoubicacionpiso,nombreubicacionpiso from ubicacionpiso where nombreubicacionpiso like '%"+nombre+"%' order by nombreubicacionpiso desc;";    
        try {
            resultado=gestorJDBC.ejecutarConsulta(sentenciaSQL1);
            while(resultado.next()){
                ubicacionPiso = new UbicacionPiso();
                ubicacionPiso.setCodigo(resultado.getInt(1));
                ubicacionPiso.setNombre(resultado.getString(2));
                ubicacionPisos.add(ubicacionPiso);
            }
            resultado.close();
            return ubicacionPisos;             
        } catch (Exception e) {
            throw ExcepcionSQL.crearErrorConsultar();
        }     
    }
}
