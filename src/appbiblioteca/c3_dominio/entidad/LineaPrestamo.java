package appbiblioteca.c3_dominio.entidad;

import appbiblioteca.c5_transversal.excepcion.ExcepcionReglaNegocio;

/**
 * @author <AdvanceSoft - Osorio Perez Carlos Alfredo - advancesoft.trujillo@gmail.com>
 * @version 1.0
 * @created 25-jul-2015 06:08:00 p.m.
 */
public class LineaPrestamo {
    private int cantidad;
    private String observacion;
    private Ejemplar ejemplar;
    
    public LineaPrestamo(){
        
    }

    public LineaPrestamo(int cantidad, String observacion, Ejemplar ejemplar) {
        this.cantidad = cantidad;
        this.observacion = observacion;
        this.ejemplar = ejemplar;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Ejemplar getEjemplar() {
        return ejemplar;
    }

    public void setEjemplar(Ejemplar ejemplar) {
        this.ejemplar = ejemplar;
    }
    
    public void validarCantidad()throws Exception{
        if(this.cantidad > 2){
            throw ExcepcionReglaNegocio.crearErroroCantidadPermitida();
        }
    }
}