/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appbiblioteca.c3_dominio.contrato;

import appbiblioteca.c3_dominio.entidad.Lector;
import java.util.List;

/**
 *
 * @author
 * <AdvanceSoft - Medrano Parado Sandra Zoraida - advancesoft.trujillo@gmail.com>
 * @version 1.0 
 * @created 02-agost-2015 01:31:00 p.m.
 */
public interface ILectorDAO {
    public void crear(Lector lector) throws Exception;
    public void modificar(Lector lector) throws Exception;
    public void eliminar(Lector lector) throws Exception;
    public Lector buscar(int codigo) throws Exception;
    public Lector buscarPorDNI(String dni) throws Exception;
    public List<Lector> buscar(String nombre) throws Exception;
}
