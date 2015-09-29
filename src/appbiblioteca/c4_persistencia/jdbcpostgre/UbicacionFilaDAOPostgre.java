/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appbiblioteca.c4_persistencia.jdbcpostgre;

import appbiblioteca.c3_dominio.contrato.IUbicacionFilaDAO;
import appbiblioteca.c3_dominio.entidad.UbicacionFila;
import appbiblioteca.c4_persistencia.GestorJDBC;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author
 * <AdvanceSoft - Garcia Infante Petter Jhunior - advancesoft.trujillo@gmail.com>
 */
public class UbicacionFilaDAOPostgre implements IUbicacionFilaDAO{
    GestorJDBC gestorJDBC;

    public UbicacionFilaDAOPostgre(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }
    
    @Override
    public void crear(UbicacionFila ubicacionFila) throws Exception {
        String consulta = "insert into UbicacionFila(nombreubicacionfila) values(?)";
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(consulta);
        sentencia.setString(1, ubicacionFila.getNombre());
        sentencia.executeUpdate();
    }

    @Override
    public void modificar(UbicacionFila ubicacionFila) throws Exception {
        String consulta = "update ubicacionFila set nombreubicacionfila = ? where codigoubicacionfila = ?";
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(consulta);
        sentencia.setString(1, ubicacionFila.getNombre());
        sentencia.setInt(2, ubicacionFila.getCodigo());
        sentencia.executeUpdate();
    }

    @Override
    public void eliminar(UbicacionFila ubicacionFila) throws Exception {
        String consulta = "delete from ubicacionfila where codigoubicacionfila = ?";
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(consulta);
        sentencia.setInt(1, ubicacionFila.getCodigo());
        sentencia.executeUpdate();
    }

    @Override
    public UbicacionFila buscar(int codigo) throws Exception {
        String consulta = "select codigoubicacionfila,nombreubicacionfila from ubicacionfila where codigoubicacionfila =" + codigo;        
        ResultSet resultado = gestorJDBC.ejecutarConsulta(consulta);
        UbicacionFila ubicacionFila = null;
        if(resultado.next()){
            ubicacionFila = new UbicacionFila();
            ubicacionFila.setCodigo(resultado.getInt(1));
            ubicacionFila.setNombre(resultado.getString(2));
        }
        return ubicacionFila;
    }

    @Override
    public List<UbicacionFila> buscar(String nombre) throws Exception {
        String consulta = "select codigoubicacionfila,nombreubicacionfila from ubicacionfila where nombreubicacionfila like '%"+nombre+"%' order by codigoubicacionfila desc;";
        ResultSet resultado = gestorJDBC.ejecutarConsulta(consulta);
        UbicacionFila ubicacionFila;
        ArrayList<UbicacionFila> listaproveedor = new ArrayList<>();
        while(resultado.next()){
            ubicacionFila = new UbicacionFila();
            ubicacionFila.setCodigo(resultado.getInt(1));
            ubicacionFila.setNombre(resultado.getString(2));
            listaproveedor.add(ubicacionFila);
        }
        return listaproveedor; 
    }
}
