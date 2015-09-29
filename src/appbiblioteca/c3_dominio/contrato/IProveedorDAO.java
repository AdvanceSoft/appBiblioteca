package appbiblioteca.c3_dominio.contrato;
import appbiblioteca.c3_dominio.entidad.Proveedor;
import java.util.List;

/**
 * @author <AdvanceSoft - Osorio Perez Carlos Alfredo - advancesoft.trujillo@gmail.com>
 * @version 1.0
 * @created 25-jul-2015 06:07:59 p.m.
 */
public interface IProveedorDAO {
    public void crear(Proveedor proveedor) throws Exception;
    public void modificar(Proveedor proveedor) throws Exception;
    public void eliminar(Proveedor proveedor) throws Exception;
    public Proveedor buscar(int codigo) throws Exception;
    public List<Proveedor> buscar(String nombre) throws Exception;
}