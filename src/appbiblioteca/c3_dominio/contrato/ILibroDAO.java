/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appbiblioteca.c3_dominio.contrato;

import appbiblioteca.c3_dominio.entidad.Libro;
import java.util.List;

/**
 *
 * @author CarlosAlfredo
 */
public interface ILibroDAO {
    public void crear (Libro libro) throws Exception;
    public void modificar (Libro libro) throws Exception;
    public void eliminar (Libro libro) throws Exception;
    public Libro buscar(int codigolibro) throws Exception;
    public List<Libro> buscar (String nombre) throws Exception;

}
