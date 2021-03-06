/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appbiblioteca.c4_persistencia.jdbcpostgre;

import appbiblioteca.c3_dominio.contrato.INivelDAO;
import appbiblioteca.c3_dominio.entidad.Especialidad;
import appbiblioteca.c3_dominio.entidad.LineaEspecialidad;
import appbiblioteca.c3_dominio.entidad.Nivel;
import appbiblioteca.c4_persistencia.GestorJDBC;
import appbiblioteca.c5_transversal.excepcion.ExcepcionSQL;
import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author CarlosAlfredo
 */
public class NivelDAOPostgre implements INivelDAO{
    GestorJDBC gestorJDBC;
    
    public NivelDAOPostgre(GestorJDBC gestorJDBC){
        this.gestorJDBC = gestorJDBC;
    }

    @Override
    public void crear(Nivel nivel) throws Exception {
        int ultimo_nivel = 0;
        PreparedStatement sentencia;
        ResultSet resultado;
        String consulta1 = "insert into nivel(nombrenivel,descripcionnivel) values(?,?)";
        String consulta2 = "select max(codigonivel)as ultimo_nivel from nivel";
        String consulta3 = "insert into lineaespecialidad(codigonivel,codigoespecialidad)values(?,?)";
        try{
            sentencia = gestorJDBC.prepararSentencia(consulta1);
            sentencia.setString(1,nivel.getNombre());
            sentencia.setString(2,nivel.getDescripcion());
            sentencia.executeUpdate();
            sentencia.close();
            sentencia = gestorJDBC.prepararSentencia(consulta2);
            resultado=sentencia.executeQuery();
            if(resultado.next())
                ultimo_nivel=resultado.getInt("ultimo_nivel");
            else{
            resultado.close();
            sentencia.close();
            }
            for(LineaEspecialidad lineaEspecialidad: nivel.getLineaEspecialidad()){
                sentencia=gestorJDBC.prepararSentencia(consulta3);
                sentencia.setInt(1,ultimo_nivel);
                sentencia.setInt(2,lineaEspecialidad.getEspecialidad().getCodigo());
                sentencia.executeUpdate();
                sentencia.close();
            }
        }catch (SQLException | HeadlessException e) {
           throw ExcepcionSQL.crearErrorInsertar();          
        }
    }

    @Override
    public void modificar(Nivel nivel) throws Exception {
        PreparedStatement sentencia;
        String consultaSQL1 = "DELETE FROM lineaespecialidad WHERE codigonivel=?";
        String consultaSQL2="UPDATE nivel   SET nombrenivel=?, descripcionnivel=? WHERE codigonivel=?";
        String consultaSQL3="insert into lineaespecialidad(codigonivel,codigoespecialidad)values(?,?)";
        try{
            sentencia = gestorJDBC.prepararSentencia(consultaSQL1);
            sentencia.setInt(1, nivel.getCodigo());
            sentencia.executeUpdate();
            sentencia.close();
            sentencia = gestorJDBC.prepararSentencia(consultaSQL2);
            sentencia.setString(1, nivel.getNombre());
            sentencia.setString(2, nivel.getDescripcion());
            sentencia.setInt(3, nivel.getCodigo());
            sentencia.executeUpdate();
            sentencia.close();
            for(LineaEspecialidad lineaEspecialidad: nivel.getLineaEspecialidad()){
                sentencia=gestorJDBC.prepararSentencia(consultaSQL3);
                sentencia.setInt(1,nivel.getCodigo());
                sentencia.setInt(2,lineaEspecialidad.getEspecialidad().getCodigo());
                sentencia.executeUpdate();
                sentencia.close();
            }
        } catch (Exception e){
            throw ExcepcionSQL.crearErrorModificar();
        }
    }

    @Override
    public void eliminar(Nivel nivel) throws Exception {
        PreparedStatement sentencia;
        String consultaSQL1 = "DELETE FROM lineaespecialidad WHERE codigonivel=?";
        String consultaSQL2="DELETE FROM nivel WHERE codigonivel=?";
        try{
            sentencia = gestorJDBC.prepararSentencia(consultaSQL1);
            sentencia.setInt(1, nivel.getCodigo());
            sentencia.executeUpdate();
            sentencia.close();
            sentencia = gestorJDBC.prepararSentencia(consultaSQL2);
            sentencia.setInt(1, nivel.getCodigo());
            sentencia.executeUpdate();
            sentencia.close();            
        } catch (Exception e){
            throw ExcepcionSQL.crearErrorEliminar();
        }
    }

    @Override
    public Nivel buscar(int codigonivel) throws Exception {
        String consulta = "select n.codigonivel, n.nombrenivel, n.descripcionnivel, e.codigoespecialidad, e.nombreespecialidad, e.descripcionespecialidad from nivel n inner join lineaespecialidad le on n.codigonivel=le.codigonivel inner join especialidad e on le.codigoespecialidad = e.codigoespecialidad where n.codigonivel =" + codigonivel;
        ResultSet resultado = gestorJDBC.ejecutarConsulta(consulta);
        System.out.println(resultado.toString());
        Nivel nivel = new Nivel();
        Especialidad especialidad;
        LineaEspecialidad lineaEspecialidad;
        while(resultado.next()){
            nivel.setCodigo(resultado.getInt(1));
            nivel.setNombre(resultado.getString(2));
            nivel.setDescripcion(resultado.getString(3));
            especialidad = new Especialidad();
            especialidad.setCodigo(resultado.getInt(4));
            especialidad.setNombre(resultado.getString(5));
            especialidad.setDescripcion(resultado.getString(6));   
            lineaEspecialidad = new LineaEspecialidad();
            lineaEspecialidad.setEspecialidad(especialidad);
            nivel.agregarEspecialidad(lineaEspecialidad);
        }
        return nivel;
    }
    
    @Override
    public List<Nivel> buscar(String nombre) throws Exception {
         if(nombre == null){
            nombre = "";
        }
        Nivel nivel;
        List<Nivel> listaNivel = new ArrayList<>();
        String consulta = "select codigonivel,nombrenivel,descripcionnivel from nivel where nombrenivel like '%"+nombre+"%' order by codigonivel desc";
        ResultSet resultado = gestorJDBC.ejecutarConsulta(consulta);
        while(resultado.next()){
            nivel = new Nivel();
            nivel.setCodigo(resultado.getInt(1));
            nivel.setNombre(resultado.getString(2));
            nivel.setDescripcion(resultado.getString(3));
            listaNivel.add(nivel);
        }
        return listaNivel;
    }

    @Override
    public List<LineaEspecialidad> buscarLineaEspecialidad(int codigonivel) throws Exception {
        String consulta = "select n.codigonivel, n.nombrenivel, n.descripcionnivel, e.codigoespecialidad, e.nombreespecialidad, e.descripcionespecialidad, le.codigonivel, le.codigoespecialidad from nivel n inner join lineaespecialidad le on n.codigonivel=le.codigonivel inner join especialidad e on le.codigoespecialidad = e.codigoespecialidad where n.codigonivel =" + codigonivel;
        ResultSet resultado = gestorJDBC.ejecutarConsulta(consulta);
        Nivel nivel;
        Especialidad especialidad;
        LineaEspecialidad lineaEspecialidad = null;
        ArrayList<LineaEspecialidad> lineaEspecialidades = new ArrayList<>();
        while(resultado.next()){
            nivel = new Nivel();
            nivel.setCodigo(resultado.getInt(1));
            nivel.setNombre(resultado.getString(2));
            nivel.setDescripcion(resultado.getString(3));
            especialidad = new Especialidad();
            especialidad.setCodigo(resultado.getInt(4));
            especialidad.setNombre(resultado.getString(5));
            especialidad.setDescripcion(resultado.getString(6));
            lineaEspecialidad = new LineaEspecialidad();
            lineaEspecialidad.setEspecialidad(especialidad);
            lineaEspecialidades.add(lineaEspecialidad);
        }
        return lineaEspecialidades;
    }
}
