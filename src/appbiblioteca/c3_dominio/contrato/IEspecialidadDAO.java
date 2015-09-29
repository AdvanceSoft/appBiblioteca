package appbiblioteca.c3_dominio.contrato;
import appbiblioteca.c3_dominio.entidad.Especialidad;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author CarlosAlfredo
 */
public interface IEspecialidadDAO {
    public void crear(Especialidad especialidad) throws Exception;
    public void modificar(Especialidad especialidad) throws Exception;
    public void elimiar(Especialidad especialidad) throws Exception;
    public Especialidad buscar(int codigo) throws Exception;
    public List<Especialidad> buscar(String nombre) throws Exception;
    public ArrayList<Especialidad> buscarPorNombre(String nombre)throws Exception; 
}
