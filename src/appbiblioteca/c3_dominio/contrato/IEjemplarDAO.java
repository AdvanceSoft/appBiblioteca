/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appbiblioteca.c3_dominio.contrato;

import appbiblioteca.c3_dominio.entidad.Ejemplar;
import appbiblioteca.c3_dominio.entidad.Libro;
import java.util.List;

/**
 *
 * @author
 * <AdvanceSoft - Mendoza Torres Valentin - advancesoft.trujillo@gmail.com>
 */
public interface IEjemplarDAO {
    public void crear(Ejemplar ejemplar)throws Exception;
    public void modificar(Ejemplar ejemplar)throws Exception;
    public void eliminar (Ejemplar ejemplar)throws Exception;
    public Ejemplar buscar(int codigo)throws Exception;
    public List<Ejemplar> buscar(String nombre)throws Exception;
    public Ejemplar buscarLibro(String nombre) throws Exception;
}
