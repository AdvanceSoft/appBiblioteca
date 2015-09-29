package appbiblioteca.c3_dominio.entidad;

import appbiblioteca.c5_transversal.excepcion.ExcepcionReglaNegocio;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * @author <AdvanceSoft - Osorio Perez Carlos Alfredo - advancesoft.trujillo@gmail.com>
 * @version 1.0
 * @created 25-jul-2015 06:07:58 p.m.
 */
public class Adquisicion {
    private int codigo;
    private Date fechaadquisicion;
    private Bibliotecario bibliotecario;
    private Proveedor proveedor;
    private List<LineaAdquisicion> listaDeAdquisicion;
    
    public Adquisicion(){
        this.codigo=0; 
        this.listaDeAdquisicion=new ArrayList();
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Date getFechaadquisicion() {
        return fechaadquisicion;
    }

    public void setFechaadquisicion(Date fechaadquisicion) {
        this.fechaadquisicion = fechaadquisicion;
    }

    public Bibliotecario getBibliotecario() {
        return bibliotecario;
    }

    public void setBibliotecario(Bibliotecario bibliotecario) {
        this.bibliotecario = bibliotecario;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public List<LineaAdquisicion> getLineaAdquisicion() {
        return listaDeAdquisicion;
    }
    
    public void agregarLineaAdquisicion(LineaAdquisicion lineaAdquisicion)throws Exception{
        verificarExistenciaLineaAdquisicion(lineaAdquisicion);
        listaDeAdquisicion.add(lineaAdquisicion);
    }
    
    public void verificarExistenciaLineaAdquisicion(LineaAdquisicion lineaAdquisicion)throws Exception{
        for(LineaAdquisicion lineaAdquisicionverificar : listaDeAdquisicion){
            
        }
    }
    
    public void validarAdquisicion()throws Exception{
        if(listaDeAdquisicion.size()<=0)
            throw ExcepcionReglaNegocio.crearErrorAdquisicion();
    }
}