/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appbiblioteca.c4_persistencia.jdbcpostgre;

import appbiblioteca.c3_dominio.contrato.IPrestamoDAO;
import appbiblioteca.c3_dominio.entidad.LineaPrestamo;
import appbiblioteca.c3_dominio.entidad.Prestamo;
import appbiblioteca.c4_persistencia.GestorJDBC;
import appbiblioteca.c5_transversal.excepcion.ExcepcionSQL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author
 * <AdvanceSoft - Osorio Perez Carlos Alfredo - advancesoft.trujillo@gmail.com>
 */
public class PrestamoDAOPostgre implements IPrestamoDAO{
    GestorJDBC gestorJDBC;

    public PrestamoDAOPostgre(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }

    @Override
    public void crear(Prestamo prestamo) throws Exception {
        int ultimoPrestamo;
        PreparedStatement sentencia;
        ResultSet resultado;
        String sentenciaSQL1="INSERT INTO prestamo(codigobibliotecario, codigolector, fechadevolucion, fechadevolver, fechaprestamo, lugarprestamo) VALUES (?, ?, ?, ?, ?, ?)";
        String sentenciaSQL2="SELECT MAX(codigoPrestamo) as ultimo_prestamo FROM prestamo";
        String sentenciaSQL3="INSERT INTO lineaprestamo(cantidadlineaprestamo, codigoejemplar, codigoprestamo, observacionlineaprestamo) VALUES (?, ?, ?, ?)";
        try {
            sentencia = gestorJDBC.prepararSentencia(sentenciaSQL1);
            sentencia.setInt(1, prestamo.getBibliotecario().getCodigo());
            sentencia.setInt(2, prestamo.getLector().getCodigo());
            sentencia.setDate(3, prestamo.getFechadevolucion());
            sentencia.setDate(4, prestamo.getFechadevolver());
            sentencia.setDate(5, prestamo.getFechaprestamo());
            sentencia.setString(6, prestamo.getLugar());
            sentencia.executeUpdate();
            sentencia.close();
            sentencia = gestorJDBC.prepararSentencia(sentenciaSQL2);
            resultado = sentencia.executeQuery();
            if(resultado.next())
                ultimoPrestamo = resultado.getInt(1);
            else
                throw ExcepcionSQL.crearErrorInsertar();
            resultado.close();
            sentencia.close();
            for(LineaPrestamo lineaPrestamo : prestamo.getLineaPrestamo()){
                sentencia = gestorJDBC.prepararSentencia(sentenciaSQL3);
                sentencia.setInt(1, lineaPrestamo.getCantidad());
                sentencia.setInt(2, lineaPrestamo.getEjemplar().getCodigo());
                sentencia.setInt(3, ultimoPrestamo);
                sentencia.setString(4, lineaPrestamo.getObservacion());
                sentencia.executeUpdate();
                sentencia.close();
            }
        } catch (Exception e) {
             throw ExcepcionSQL.crearErrorInsertar();
        }
    }

    @Override
    public Prestamo buscar(int codigo) throws Exception {
        return null;
    }
    
    
    
}
