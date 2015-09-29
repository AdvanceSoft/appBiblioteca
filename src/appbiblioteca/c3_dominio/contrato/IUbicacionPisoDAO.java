/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appbiblioteca.c3_dominio.contrato;

import appbiblioteca.c3_dominio.entidad.UbicacionPiso;
import java.util.List;

/**
 *
 * @author
 * <AdvanceSoft - Garcia Infante Petter Jhunior - advancesoft.trujillo@gmail.com>
 */
public interface IUbicacionPisoDAO {
    public void crear(UbicacionPiso ubicacionPiso) throws Exception;
    public void modificar(UbicacionPiso ubicacionPiso) throws Exception;
    public void eliminar(UbicacionPiso ubicacionPiso) throws Exception;
    public UbicacionPiso buscar(int codigo) throws Exception;
    public List<UbicacionPiso> buscar(String nombre) throws Exception;
}
