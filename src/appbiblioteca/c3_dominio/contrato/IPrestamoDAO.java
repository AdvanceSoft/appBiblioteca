/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appbiblioteca.c3_dominio.contrato;

import appbiblioteca.c3_dominio.entidad.Prestamo;

/**
 *
 * @author <AdvanceSoft - Osorio Perez Carlos Alfredo - advancesoft.trujillo@gmail.com>
 */
public interface IPrestamoDAO {
    public void crear(Prestamo prestamo) throws Exception;
    public Prestamo buscar(int codigo) throws Exception;
}
