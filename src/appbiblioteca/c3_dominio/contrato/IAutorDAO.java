package appbiblioteca.c3_dominio.contrato;
import appbiblioteca.c3_dominio.entidad.Autor;
import java.util.List;

/**
 *
 * @author
 * <AdvanceSoft - Leyva Borjas Henderzon Alejandro - advancesoft.trujillo@gmail.com>
 */
public interface IAutorDAO {
    public void crear(Autor autor) throws Exception;
    public void modificar(Autor autor) throws Exception;
    public void eliminar(Autor autor) throws Exception;
    public Autor buscar(int codigo) throws Exception;
    public List<Autor> buscar(String nombre) throws Exception;
}
