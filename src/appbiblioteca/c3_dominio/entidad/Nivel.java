package appbiblioteca.c3_dominio.entidad;

import appbiblioteca.c5_transversal.excepcion.ExcepcionReglaNegocio;
import java.util.ArrayList;
import java.util.List;

/**
 * @author <AdvanceSoft - Osorio Perez Carlos Alfredo - advancesoft.trujillo@gmail.com>
 * @version 1.0
 * @created 25-jul-2015 06:08:00 p.m.
 */
public class Nivel {
    private int codigo;
    private String nombre;
    private String descripcion;
    private List<LineaEspecialidad> lineaEspecialidades;

    public Nivel() {
        this.codigo = 0;
        this.lineaEspecialidades = new ArrayList<>();
    }

    public Nivel(int codigo, String nombre, String descripcion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.lineaEspecialidades = new ArrayList<>();
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigonivel) {
        this.codigo = codigonivel;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<LineaEspecialidad> getLineaEspecialidad() {
        return lineaEspecialidades;
    }

    public void agregarEspecialidad(LineaEspecialidad lineaEspecialidad) throws Exception{
        verificarExistenciaEspecialidad(lineaEspecialidad);
        this.lineaEspecialidades.add(lineaEspecialidad);
    }
    
    public void verificarExistenciaEspecialidad(LineaEspecialidad lineaEspecialidad)throws Exception{
        for(LineaEspecialidad lineaEspecialidad1 : lineaEspecialidades){
            if(lineaEspecialidad1.getEspecialidad().getCodigo() == lineaEspecialidad.getEspecialidad().getCodigo())
                throw ExcepcionReglaNegocio.crearErrorExistenciaEspecialidad();
        }
    }
    
    public void quitarLineaEspecialidad(int especialidadid){
        for(LineaEspecialidad lineaEspecialidad : lineaEspecialidades){
            if(lineaEspecialidad.getEspecialidad().getCodigo() == especialidadid){
                lineaEspecialidades.remove(lineaEspecialidad);
                break;
            }
        }
    }
    
    public void validarNivel()throws Exception
    {
        if(lineaEspecialidades.size()<=0)
            throw ExcepcionReglaNegocio.crearERROR_ASIGNACION_ESPECIALIDADNIVEL();
    }
}