package appbiblioteca.c4_persistencia.jdbcpostgre;

import appbiblioteca.c3_dominio.contrato.IAutorDAO;
import appbiblioteca.c3_dominio.entidad.Autor;
import appbiblioteca.c4_persistencia.GestorJDBC;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author
 * <AdvanceSoft - Leyva Borjas Henderzon Alejandro - advancesoft.trujillo@gmail.com>
 */
public class AutorDAOPostgre implements IAutorDAO{
    GestorJDBC gestorJDBC;

    public AutorDAOPostgre(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }
    
    @Override
    public void crear(Autor autor) throws Exception{
        String consulta = "insert into autor(nombreautor,apellidoautor) values(?,?)";
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(consulta);
        sentencia.setString(1, autor.getNombre());
        sentencia.setString(2, autor.getApellido());
        sentencia.executeUpdate();
    }
    
    @Override
    public void modificar(Autor autor) throws Exception{
        String consulta = "update autor set nombreautor = ?, apellidoautor = ? where codigoautor = ?";
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(consulta);
        sentencia.setString(1, autor.getNombre());
        sentencia.setString(2, autor.getApellido());
        sentencia.setInt(3, autor.getCodigo());
        sentencia.executeUpdate();
    }
    
    @Override
    public void eliminar(Autor autor) throws Exception{
        String consulta = "delete from autor where codigoautor = ?";
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(consulta);
        sentencia.setInt(1, autor.getCodigo());
        sentencia.executeUpdate();
    }
    
    @Override
    public Autor buscar(int codigo) throws Exception{
        String consulta = "select codigoautor,nombreautor,apellidoautor from autor where codigoautor = " + codigo;
        ResultSet resultado = gestorJDBC.ejecutarConsulta(consulta);
        Autor autor = null;
        if(resultado.next()){
            autor = new Autor();
            autor.setCodigo(resultado.getInt(1));
            autor.setNombre(resultado.getString(2));
            autor.setApellido(resultado.getString(3));
        }
        return autor;
    }
    
    @Override
    public List<Autor> buscar(String nombre) throws Exception{
        String consulta = "select codigoautor,nombreautor,apellidoautor from autor where nombreautor like '%"+nombre+"%' ";
        ResultSet resultado = gestorJDBC.ejecutarConsulta(consulta);
        Autor autor;
        ArrayList<Autor> listaautor = new ArrayList<>();
        while(resultado.next()){
            autor = new Autor();
            autor.setCodigo(resultado.getInt(1));
            autor.setNombre(resultado.getString(2));
            autor.setApellido(resultado.getString(3));
            listaautor.add(autor);
        }
        return listaautor;
    }
}

