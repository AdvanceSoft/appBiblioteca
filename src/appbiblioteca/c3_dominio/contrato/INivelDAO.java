/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appbiblioteca.c3_dominio.contrato;

import appbiblioteca.c3_dominio.entidad.LineaEspecialidad;
import appbiblioteca.c3_dominio.entidad.Nivel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author CarlosAlfredo
 */
public interface INivelDAO {
    public void crear (Nivel nivel) throws Exception;
    public void modificar (Nivel nivel) throws Exception;
    public void eliminar (Nivel nivel) throws Exception;
    public Nivel buscar(int codigonivel) throws Exception;
    public List<Nivel> buscar (String nombre) throws Exception;
    public List<LineaEspecialidad> buscarLineaEspecialidad(int codigonivel)throws Exception;
}
