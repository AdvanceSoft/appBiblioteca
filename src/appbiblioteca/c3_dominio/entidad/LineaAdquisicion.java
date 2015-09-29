package appbiblioteca.c3_dominio.entidad;

import appbiblioteca.c5_transversal.excepcion.ExcepcionReglaNegocio;

/**
 * @author <AdvanceSoft - Osorio Perez Carlos Alfredo - advancesoft.trujillo@gmail.com>
 * @version 1.0
 * @created 25-jul-2015 06:07:59 p.m.
 */
public class LineaAdquisicion {
    private int cantidad;
    private String tipo;
    private Libro libro;

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }
    public void validarCantidad()throws Exception{
        if(this.cantidad<=0||this.cantidad>1000)
            throw ExcepcionReglaNegocio.crearErrorCantidad();
    }   
}