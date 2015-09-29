/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appbiblioteca.c3_dominio.contrato;

import appbiblioteca.c3_dominio.entidad.UbicacionFila;
import java.util.List;

/**
 *
 * @author
 * <AdvanceSoft - Garcia Infante Petter Jhunior - advancesoft.trujillo@gmail.com>
 */
public interface IUbicacionFilaDAO {
    public void crear(UbicacionFila ubicacionFila) throws Exception;
    public void modificar(UbicacionFila ubicacionFila) throws Exception;
    public void eliminar(UbicacionFila ubicacionFila) throws Exception;
    public UbicacionFila buscar(int codigo) throws Exception;
    public List<UbicacionFila> buscar(String nombre) throws Exception;
}
