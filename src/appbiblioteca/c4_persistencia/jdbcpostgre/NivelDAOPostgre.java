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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Nivel nivel) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LineaEspecialidad buscar(int codigonivel) throws Exception {
        String consulta = "select n.codigonivel, n.nombrenivel, n.descripcionnivel, e.codigoespecialidad, e.nombreespecialidad, e.descripcionespecialidad, le.codigonivel, le.codigoespecialidad from nivel n inner join lineaespecialidad le on n.codigonivel=le.codigonivel inner join especialidad e on le.codigoespecialidad = e.codigoespecialidad where n.codigonivel =" + codigonivel;
        ResultSet resultado = gestorJDBC.ejecutarConsulta(consulta);
        Nivel nivel;
        Especialidad especialidad;
        LineaEspecialidad lineaEspecialidad = null;
        if(resultado.next()){
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
            lineaEspecialidad.setNivel(nivel);
        }
        return lineaEspecialidad;
    }

    @Override
    public ArrayList<Nivel> buscarPorNombre(String nombre) throws Exception {
        if(nombre == null){
            nombre = "";
        }
        Nivel nivel;
        ArrayList<Nivel> listaNivel = new ArrayList<>();
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
    public List<Nivel> buscar(String nombre) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
            lineaEspecialidad.setNivel(nivel);
            lineaEspecialidades.add(lineaEspecialidad);
        }
        return lineaEspecialidades;
    }
}
