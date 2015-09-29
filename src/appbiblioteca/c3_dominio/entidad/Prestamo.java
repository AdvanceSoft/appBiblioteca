package appbiblioteca.c3_dominio.entidad;

import appbiblioteca.c5_transversal.excepcion.ExcepcionReglaNegocio;
import java.sql.Date;
import java.text.DateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author <AdvanceSoft - Osorio Perez Carlos Alfredo - advancesoft.trujillo@gmail.com>
 * @version 1.0
 * @created 25-jul-2015 06:08:00 p.m.
 */
public class Prestamo {
    private int codigo;
    private Date fechaprestamo;
    private Date fechadevolucion;
    private Date fechadevolver;
    private String lugar;    
    private Lector lector;
    private Bibliotecario bibliotecario;
    private List<LineaPrestamo> lineaPrestamos;
    
    public Prestamo(){
        this.codigo = 0;
        lineaPrestamos = new ArrayList<>();
        this.fechaprestamo = Date.valueOf(LocalDate.now());
    }

    public Prestamo(int codigo, Date fechaprestamo, Date fechadevolucion, Date fechadevolver, String lugar, Lector lector, Bibliotecario bibliotecario, List<LineaPrestamo> lineaPrestamos) {
        this.codigo = codigo;
        this.fechaprestamo = fechaprestamo;
        this.fechadevolucion = fechadevolucion;
        this.fechadevolver = fechadevolver;
        this.lugar = lugar;
        this.lector = lector;
        this.bibliotecario = bibliotecario;
        this.lineaPrestamos = lineaPrestamos;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Date getFechaprestamo() {
        return fechaprestamo;
    }

    public void setFechaprestamo(Date fechaprestamo) {
        this.fechaprestamo = fechaprestamo;
    }

    public Date getFechadevolucion() {
        return fechadevolucion;
    }

    public void setFechadevolucion(Date fechadevolucion) {
        this.fechadevolucion = fechadevolucion;
    }

    public Date getFechadevolver() {
        return fechadevolver;
    }

    public void setFechadevolver(Date fechadevolver) {
        this.fechadevolver = fechadevolver;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public Lector getLector() {
        return lector;
    }

    public void setLector(Lector lector) {
        this.lector = lector;
    }

    public Bibliotecario getBibliotecario() {
        return bibliotecario;
    }

    public void setBibliotecario(Bibliotecario bibliotecario) {
        this.bibliotecario = bibliotecario;
    }

    public List<LineaPrestamo> getLineaPrestamo() {
        return lineaPrestamos;
    }

    public void setLineaPrestamo(List<LineaPrestamo> lineaPrestamos) {
        this.lineaPrestamos = lineaPrestamos;
    }
    
    public void verificarExistencia(LineaPrestamo lineaPrestamo)throws Exception{
        for(LineaPrestamo lineaPrestamoVerificar : lineaPrestamos){
            if(lineaPrestamoVerificar.getEjemplar().getCodigo()==lineaPrestamo.getEjemplar().getCodigo())
                throw ExcepcionReglaNegocio.crearErrorMENSAJE_EJEMPLAR_YA_EXISTE();
        }
    }
    
    public void agregarLineaPrestamo(LineaPrestamo lineaPrestamo)throws Exception{
        verificarExistencia(lineaPrestamo);
        lineaPrestamo.validarCantidad();
        lineaPrestamos.add(lineaPrestamo);
    }
}