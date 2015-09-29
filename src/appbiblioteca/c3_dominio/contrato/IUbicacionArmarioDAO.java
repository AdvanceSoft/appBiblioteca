/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appbiblioteca.c3_dominio.contrato;

import appbiblioteca.c3_dominio.entidad.UbicacionArmario;
import java.util.List;

/**
 *
 * @author
 * <AdvanceSoft - Garcia Infante Petter Jhunior - advancesoft.trujillo@gmail.com>
 */
public interface IUbicacionArmarioDAO {
    public void crear(UbicacionArmario ubicacionArmario) throws Exception;
    public void modificar(UbicacionArmario ubicacionArmario) throws Exception;
    public void eliminar(UbicacionArmario ubicacionArmario) throws Exception;
    public UbicacionArmario buscar(int codigo) throws Exception;
    public List<UbicacionArmario> buscar(String nombre) throws Exception;
}
