package appbiblioteca.c4_persistencia.jdbcsqlserver;

import appbiblioteca.c3_dominio.contrato.IProveedorDAO;
import appbiblioteca.c3_dominio.entidad.Proveedor;
import appbiblioteca.c4_persistencia.GestorJDBC;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


/**
 * @author <AdvanceSoft - Osorio Perez Carlos Alfredo - advancesoft.trujillo@gmail.com>
 * @version 1.0
 * @created 25-jul-2015 06:08:00 p.m.
 */
public class ProveedorDAOsqlserver implements IProveedorDAO{
    GestorJDBC gestorJDBC;   
    
    public ProveedorDAOsqlserver(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }

    @Override
    public void crear(Proveedor proveedor) throws Exception{
        String consulta = "insert into proveedor(nombreproveedor,direccionproveedor) values(?,?)";
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(consulta);
        sentencia.setString(1, proveedor.getNombre());
        sentencia.setString(2, proveedor.getDireccion());
        sentencia.executeUpdate();
    }

    @Override
    public void modificar(Proveedor proveedor) throws Exception{
        String consulta = "update proveedor set nombreproveedor = ?, direccionproveedor = ? where codigoproveedor = ?";
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(consulta);
        sentencia.setString(1, proveedor.getNombre());
        sentencia.setString(2, proveedor.getDireccion());
        sentencia.setInt(3, proveedor.getCodigo());
        sentencia.executeUpdate();
    }

    @Override
    public void eliminar(Proveedor proveedor) throws Exception{
        String consulta = "delete from proveedor where codigoproveedor = ?";
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(consulta);
        sentencia.setInt(1, proveedor.getCodigo());
        sentencia.executeUpdate();
    }

    @Override
    public Proveedor buscar(int codigo) throws Exception{        
        String consulta = "select codigoproveedor,nombreproveedor,direccionproveedor from proveedor where codigoproveedor = " + codigo;
        ResultSet resultado = gestorJDBC.ejecutarConsulta(consulta);
        Proveedor proveedor = null;
        if(resultado.next()){
            proveedor = new Proveedor();
            proveedor.setCodigo(resultado.getInt(1));
            proveedor.setNombre(resultado.getString(2));
            proveedor.setDireccion(resultado.getString(3));
        }
        return proveedor;
    }

    @Override
    public List<Proveedor> buscar(String nombre) throws Exception{
        String consulta = "select codigoproveedor,nombreproveedor,direccionproveedor from proveedor where nombreproveedor like '%"+nombre+"%' ";
        ResultSet resultado = gestorJDBC.ejecutarConsulta(consulta);
        Proveedor proveedor;
        ArrayList<Proveedor> listaproveedor = new ArrayList<>();
        while(resultado.next()){
            proveedor = new Proveedor();
            proveedor.setCodigo(resultado.getInt(1));
            proveedor.setNombre(resultado.getString(2));
            proveedor.setDireccion(resultado.getString(3));
            listaproveedor.add(proveedor);
        }
        return listaproveedor;
    }

}