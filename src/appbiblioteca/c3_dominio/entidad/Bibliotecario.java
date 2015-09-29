package appbiblioteca.c3_dominio.entidad;

import java.sql.Date;


/**
 * @author <AdvanceSoft - Medrano Parado Sandra Zoraida - advancesoft.trujillo@gmail.com>
 * @version 1.0
 * @created 02-ago-2015 01:20:59 p.m.
 */
public class Bibliotecario extends Persona {

    public Bibliotecario(int codigo, String nombre, String apellido, String dni, String genero, Date fechanacimiento, String telefono, String correo) {
        super(codigo, nombre, apellido, dni, genero, fechanacimiento, telefono, correo);
    }

    public Bibliotecario() {
    }
    
}