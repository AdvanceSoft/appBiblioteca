package appbiblioteca.c3_dominio.entidad;

import appbiblioteca.c5_transversal.excepcion.ExcepcionRegla;
import java.util.ArrayList;
import java.util.List;

/**
 * @author <AdvanceSoft - Osorio Perez Carlos Alfredo - advancesoft.trujillo@gmail.com>
 * @version 1.0
 * @created 25-jul-2015 06:08:00 p.m.
 */
public class UbicacionArmario {
    private int codigo;
    private String nombre;
    private List<UbicacionFila> ubicacionFilas;
    
    public UbicacionArmario (){
        this.codigo = 0;
        this.ubicacionFilas = new ArrayList();
    }

    public UbicacionArmario(int codigo, String nombre, List<UbicacionFila> ubicacionFila) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.ubicacionFilas = ubicacionFila;
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

    public List<UbicacionFila> getUbicacionFila() {
        return ubicacionFilas;
    }
}