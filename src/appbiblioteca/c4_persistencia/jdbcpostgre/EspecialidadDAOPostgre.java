package appbiblioteca.c4_persistencia.jdbcpostgre;

import appbiblioteca.c3_dominio.contrato.IEspecialidadDAO;
import appbiblioteca.c3_dominio.entidad.Especialidad;
import appbiblioteca.c4_persistencia.GestorJDBC;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author CarlosAlfredo
 */
public class EspecialidadDAOPostgre implements IEspecialidadDAO{
    GestorJDBC gestorJDBC;

    public EspecialidadDAOPostgre(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }    
    
    @Override
    public void crear(Especialidad especialidad) throws Exception {
        String consulta = "insert into especialidad(nombreespecialidad,descripcionespecialidad) values(?,?)";
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(consulta);
        sentencia.setString(1, especialidad.getNombre());
        sentencia.setString(2, especialidad.getDescripcion());
        sentencia.executeUpdate();
    }

    @Override
    public void modificar(Especialidad especialidad) throws Exception {
        String consulta = "update especialidad set nombreespecialidad = ?, descripcionespecialidad = ? where codigoespecialidad = ?";
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(consulta);
        sentencia.setString(1, especialidad.getNombre());
        sentencia.setString(2, especialidad.getDescripcion());
        sentencia.setInt(3, especialidad.getCodigo());
        sentencia.executeUpdate();
    }

    @Override
    public void elimiar(Especialidad especialidad) throws Exception {
        String consulta = "delete from especialidad where codigoespecialidad = ?";
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(consulta);
        sentencia.setInt(1, especialidad.getCodigo());
        sentencia.executeUpdate();
    }

    @Override
    public Especialidad buscar(int codigo) throws Exception {
        String consulta = "select codigoespecialidad,nombreespecialidad,descripcionespecialidad from especialidad where codigoespecialidad = "+codigo;
        ResultSet resultado = gestorJDBC.ejecutarConsulta(consulta);
        Especialidad especialidad = null;
        if(resultado.next()){
            especialidad = new Especialidad();
            especialidad.setCodigo(resultado.getInt(1));
            especialidad.setNombre(resultado.getString(2));
            especialidad.setDescripcion(resultado.getString(3));
        }
        return especialidad;
    }

    @Override
    public List<Especialidad> buscar(String nombre) throws Exception {
        String consulta = "select codigoespecialidad,nombreespecialidad,descripcionespecialidad from especialidad where nombreespecialidad like '%"+nombre+"%' ";
        ResultSet resultado = gestorJDBC.ejecutarConsulta(consulta);
        Especialidad especialidad;
        ArrayList<Especialidad> listaespecialidad = new ArrayList<>();
        while(resultado.next()){
            especialidad = new Especialidad();
            especialidad.setCodigo(resultado.getInt(1));
            especialidad.setNombre(resultado.getString(2));
            especialidad.setDescripcion(resultado.getString(3));
            listaespecialidad.add(especialidad);
        }
        return listaespecialidad;
    }

    @Override
    public ArrayList<Especialidad> buscarPorNombre(String nombre) throws Exception {
        if(nombre == null){
            nombre = "";
        }
        Especialidad especialidad;
        ArrayList<Especialidad> listaTipoProducto = new ArrayList<>();
        String consulta = "select codigoespecialidad,nombreespecialidad,descripcionespecialidad from especialidad where nombreespecialidad like '%"+nombre+"%' order by codigoespecialidad desc";
        ResultSet resultado = gestorJDBC.ejecutarConsulta(consulta);
        while(resultado.next()){
            especialidad = new Especialidad();
            especialidad.setCodigo(resultado.getInt(1));
            especialidad.setNombre(resultado.getString(2));
            especialidad.setDescripcion(resultado.getString(3));
            listaTipoProducto.add(especialidad);
        }
        return listaTipoProducto;
    }    
}
