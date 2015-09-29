/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appbiblioteca.c3_dominio.contrato;

import appbiblioteca.c3_dominio.entidad.Adquisicion;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author
 * <AdvanceSoft - Mendoza Torres Valentin - advancesoft.trujillo@gmail.com>
 */
public interface IAdquisicionDAO {
    public void crear(Adquisicion adquisicion)throws Exception; 
    public void eliminar(Adquisicion adquisicion)throws Exception;
    public Adquisicion buscar(int codigo)throws Exception; 
    public List<Adquisicion> buscar(Date fecha)throws Exception;
    
}
