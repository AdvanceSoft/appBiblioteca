package appbiblioteca.c3_dominio.entidad;

import appbiblioteca.c5_transversal.excepcion.ExcepcionRegla;
import java.util.ArrayList;
import java.util.List;

/**
 * @author <AdvanceSoft - Osorio Perez Carlos Alfredo - advancesoft.trujillo@gmail.com>
 * @version 1.0
 * @created 25-jul-2015 06:08:00 p.m.
 */
public class UbicacionPiso {
    private int codigo;
    private String nombre;
    private List<UbicacionArmario> ubicacionArmarios;
    
    public UbicacionPiso(){
        this.codigo = 0;
        this.ubicacionArmarios = new ArrayList<>();
    }

    public UbicacionPiso(int codigo, String nombre, List<UbicacionArmario> ubicacionArmario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.ubicacionArmarios = ubicacionArmario;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<UbicacionArmario> getUbicacionArmario() {
        return ubicacionArmarios;
    }

    public void setUbicacionPiso(List<UbicacionArmario> ubicacionArmario) {
        this.ubicacionArmarios = ubicacionArmario;
    }
    
    public void agregarUbicacionArmario(UbicacionArmario ubicacionArmario)throws Exception{
        validarExistencia(ubicacionArmario);
        ubicacionArmarios.add(ubicacionArmario);
    }
    
    private void validarExistencia(UbicacionArmario ubicacionArmario)throws Exception{
        for(UbicacionArmario ubicacionArmarioVerificar : ubicacionArmarios){
            if(ubicacionArmarioVerificar.getCodigo()==ubicacionArmario.getCodigo())
                throw ExcepcionRegla.crearErrorMENSAJE_UBICACIONFILA();          
        }       
    }
    
    public void quitarUbicacionArmario(int codigo){
        for(UbicacionArmario ubicacionArmario : ubicacionArmarios){
            if(ubicacionArmario.getCodigo()==codigo){
                ubicacionArmarios.remove(ubicacionArmario);
                break;
            }
        }
    }
    
    public void validarPiso()throws Exception{
        if(ubicacionArmarios.size()<3)
            throw ExcepcionRegla.crearErrorMENSAJE_VALIDARUBICACIONARMARIO();
    }
    
    public int cantidadUbicacionArmario(){
        return ubicacionArmarios.size();
    }
}