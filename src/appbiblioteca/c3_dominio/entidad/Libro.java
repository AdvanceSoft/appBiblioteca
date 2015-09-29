package appbiblioteca.c3_dominio.entidad;

import appbiblioteca.c5_transversal.excepcion.ExcepcionReglaNegocio;
import java.util.ArrayList;
import java.util.List;

/**
 * @author <AdvanceSoft - Osorio Perez Carlos Alfredo - advancesoft.trujillo@gmail.com>
 * @version 1.0
 * @created 25-jul-2015 06:07:59 p.m.
 */
public class Libro {
    private int codigo;
    private String sticker;
    private String nombre;
    private String isbn;
    private String descripcion;
    private boolean activo;
    private Nivel nivel;
    private Especialidad especialidad;
    private List<LineaAutor> listaAutores;

    public Libro() {
        this.codigo = 0;
        this.activo= true; 
        this.listaAutores = new ArrayList();
    }
   
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigolibro) {
        this.codigo = codigolibro;
    }

    public String getSticker() {
        return sticker;
    }

    public void setSticker(String sticker) {
        this.sticker = sticker;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Nivel getNivel() {
        return nivel;
    }

    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    public List<LineaAutor> getLineaAutor() {
        return listaAutores;
    }
   
    public void agregarAutor(LineaAutor lineaAutor) throws Exception{
        validarExistenciaAutor(lineaAutor);
        this.listaAutores.add(lineaAutor);
    }
    
    public void validarExistenciaAutor(LineaAutor lineaAutor)throws Exception{
        for(LineaAutor lineaAutorExistente : listaAutores){
            if(lineaAutorExistente.getAutor().getCodigo() == lineaAutor.getAutor().getCodigo())
                throw ExcepcionReglaNegocio.crearErrorExistenciaAutor();
        }
    }
    
    public void quitarLineaAutor(int autorid){
        for(LineaAutor lineaAutor : listaAutores){
            if(lineaAutor.getAutor().getCodigo() == autorid){
                listaAutores.remove(lineaAutor);
                break;
            }
        }
    }
    
    public int cantidadDeAutores(){
        return listaAutores.size();
    }
    
}