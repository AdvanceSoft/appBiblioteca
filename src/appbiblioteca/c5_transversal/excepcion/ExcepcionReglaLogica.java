/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appbiblioteca.c5_transversal.excepcion;

/**
 *
 * @author
 * <AdvanceSoft - Mendoza Torres Valentin - advancesoft.trujillo@gmail.com>
 */
public class ExcepcionReglaLogica extends Exception{
    private static final String MENSAJE_ERROR_APELLIDO="El apellido ingresado no es valido.";
    private static final String MENSAJE_ERROR_NOMBRE = "El nombre ingresado no es valido.";
    private static final String MENSAJE_ERROR_CORREO= "El correo ingresado no es valido.";
    private static final String MENSAJE_ERROR_RUC= "El ruc ingresado no es valido.";
    private static final String MENSAJE_ERROR_DNI= "El dni ingresado no es valido."; 
    
    public ExcepcionReglaLogica(String string) {
        super(string);
    }
    
    public static ExcepcionReglaLogica crearErrorMENSAJE_APELLIDO(){
        return new ExcepcionReglaLogica(MENSAJE_ERROR_APELLIDO);
    }
    
    public static ExcepcionReglaLogica crearErrorMENSAJE_NOMBRE(){
        return new ExcepcionReglaLogica(MENSAJE_ERROR_NOMBRE);
    }
    
    public static ExcepcionReglaLogica crearErrorMENSAJE_CORREO(){
        return new ExcepcionReglaLogica(MENSAJE_ERROR_CORREO);
    }
    
    public static ExcepcionReglaLogica crearErrorMENSAJE_RUC(){
        return new ExcepcionReglaLogica(MENSAJE_ERROR_RUC);
    }
    
    public static ExcepcionReglaLogica crearErrorMENSAJE_DNI(){
        return new ExcepcionReglaLogica(MENSAJE_ERROR_DNI);
    }
    
}
