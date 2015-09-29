package appbiblioteca.c3_dominio.entidad;


/**
 * @author <AdvanceSoft - Medrano Parado Sandra Zoraida - advancesoft.trujillo@gmail.com>
 * @version 1.0
 * @created 02-ago-2015
 */
public class Lector extends Persona {

    public Lector(int codigo, String nombre, String apellido, String dni, String genero, java.sql.Date fechanacimiento, String telefono, String correo) {
        super(codigo, nombre, apellido, dni, genero, fechanacimiento, telefono, correo);
    }
    public Lector(){
    }
}