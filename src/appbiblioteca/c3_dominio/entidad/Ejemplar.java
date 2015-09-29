package appbiblioteca.c3_dominio.entidad;

import appbiblioteca.c5_transversal.excepcion.ExcepcionReglaNegocio;

/**
 * @author <AdvanceSoft - Osorio Perez Carlos Alfredo - advancesoft.trujillo@gmail.com>
 * @version 1.0
 * @created 25-jul-2015 06:07:59 p.m.
 */
public class Ejemplar {
    private int codigo;
    private int cantidad;
    private static String tipo;
    private Libro libro;
    private UbicacionPiso ubicacionPiso;
    private UbicacionArmario ubicacionArmario;
    private UbicacionFila ubicacionFila;
    
    public static final String TIPO_ORIGINAL="ORIGINAL"; 
    public static final String TIPO_COPIA="COPIA";
    
    public Ejemplar(){
        this.codigo=0; 
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public static String getTipo() {
        return tipo;
    }

    public static void setTipo(String tipo) {
        Ejemplar.tipo = tipo;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public UbicacionPiso getUbicacionPiso() {
        return ubicacionPiso;
    }

    public void setUbicacionPiso(UbicacionPiso ubicacionPiso) {
        this.ubicacionPiso = ubicacionPiso;
    }

    public UbicacionArmario getUbicacionArmario() {
        return ubicacionArmario;
    }

    public void setUbicacionArmario(UbicacionArmario ubicacionArmario) {
        this.ubicacionArmario = ubicacionArmario;
    }

    public UbicacionFila getUbicacionFila() {
        return ubicacionFila;
    }

    public void setUbicacionFila(UbicacionFila ubicacionFila) {
        this.ubicacionFila = ubicacionFila;
    }
    
    private void validarCantidad()throws Exception{
        if(this.cantidad<=0 || this.cantidad>1000)
            throw ExcepcionReglaNegocio.crearErrorCantidad();
    }
    
    public void agregarEjemplar(Libro libro)throws Exception{
        validarCantidad();
    }
    
    public void validarExistenciaLibro(Libro libro)throws Exception{
            Libro libroVerificar = null;
            if(libroVerificar.getCodigo()==libro.getCodigo()){
                throw ExcepcionReglaNegocio.crearErrorAdquisicion();
            }
        
    }
}