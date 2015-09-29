package appbiblioteca.c5_transversal.excepcion;

/**
 * @author <AdvanceSoft - Osorio Perez Carlos Alfredo - advancesoft.trujillo@gmail.com>
 * @version 1.0
 * @created 25-jul-2015 06:07:59 p.m.
 */
public class ExcepcionRegla extends Exception{
    private static final String MENSAJE_ERROR_UBICACIOFILA = "La Fila ya existe.";
    private static final String MENSAJE_ERROR_AUTOR = "La Fila ya existe.";
    private static final String MENSAJE_VALIDAR_UBICACIONARMARIO= "Este Armario debe tener al menos 3 Filas.";
     

    private ExcepcionRegla(String message) {
        super(message);
    }
    
    public static ExcepcionRegla crearErrorMENSAJE_UBICACIONFILA(){
        return new ExcepcionRegla(MENSAJE_ERROR_UBICACIOFILA);
    }
    public static ExcepcionRegla crearErrorMENSAJE_ERROR_AUTOR(){
        return new ExcepcionRegla(MENSAJE_ERROR_AUTOR);
    }
    
     public static ExcepcionRegla crearErrorMENSAJE_VALIDARUBICACIONARMARIO(){
        return new ExcepcionRegla(MENSAJE_VALIDAR_UBICACIONARMARIO);
    }
}