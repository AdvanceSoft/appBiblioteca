package appbiblioteca.c5_transversal.excepcion;

/**
 * @author <AdvanceSoft - Osorio Perez Carlos Alfredo - advancesoft.trujillo@gmail.com>
 * @version 1.0
 * @created 25-jul-2015 06:07:59 p.m.
 */
public class ExcepcionReglaNegocio extends Exception{
    private final static String ERROR_EJEMPLAR_YA_EXISTE = "El ejemplar ya fue agregado";
    private final static String ERROR_CANTIDAD="La cantidad ingresada es incorrecta.";
    private final static String ERROR_CANTIDAD_PERMITIDA="La cantidad exede lo permitido.";
    private final static String ERROR_EXISTENCIA_ADQUISICION="Ya existe esta linea de adquisición.";
    private final static String ERROR_EXISTENCIA_ESPECIALIDAD="Ya existe esta linea de Especialidad.";
    private final static String ERROR_ADQUISICION="Al menos ingrese una linea de adquisición para poder guardar.";
    private final static String ERROR_EXISTENCIA_AUTOR ="El Autor seleccionado ya existe en la lista.";
    private final static String ERROR_ASIGNACION_ESPECIALIDADNIVEL ="Al menos debe agregar una especialidad";
    
    public ExcepcionReglaNegocio(String string) {
        super(string);
    }
    
    public static ExcepcionReglaNegocio crearErrorMENSAJE_EJEMPLAR_YA_EXISTE()throws Exception{
        throw  new ExcepcionReglaNegocio(ERROR_EJEMPLAR_YA_EXISTE);
    }
    
    public static ExcepcionReglaNegocio crearErrorCantidad()throws Exception{
        throw new ExcepcionReglaNegocio(ERROR_CANTIDAD);
    }
    
    public static ExcepcionReglaNegocio crearErrorExistenciaAdquisicion()throws Exception{
        throw new ExcepcionReglaNegocio(ERROR_EXISTENCIA_ADQUISICION);
    }
    
    public static ExcepcionReglaNegocio crearErrorExistenciaEspecialidad()throws Exception{
        throw new ExcepcionReglaNegocio(ERROR_EXISTENCIA_ESPECIALIDAD);
    }
    
    public static ExcepcionReglaNegocio crearErrorAdquisicion()throws Exception{
        throw new ExcepcionReglaNegocio(ERROR_ADQUISICION);
    }
   
    public static ExcepcionReglaNegocio crearErrorExistenciaAutor()throws Exception{
       throw new ExcepcionReglaNegocio(ERROR_EXISTENCIA_AUTOR);
    }
    
    public static ExcepcionReglaNegocio crearErroroCantidadPermitida()throws Exception{
        throw  new ExcepcionReglaNegocio(ERROR_CANTIDAD_PERMITIDA);
    }
    
    public static ExcepcionReglaNegocio crearERROR_ASIGNACION_ESPECIALIDADNIVEL()throws Exception{
        throw  new ExcepcionReglaNegocio(ERROR_ASIGNACION_ESPECIALIDADNIVEL);
    }
    
}