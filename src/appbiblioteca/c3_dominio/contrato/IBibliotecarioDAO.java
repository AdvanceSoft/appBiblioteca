/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appbiblioteca.c3_dominio.contrato;

import appbiblioteca.c3_dominio.entidad.Bibliotecario;
import java.util.List;

/**
 *
 * @author
 * <AdvanceSoft - Medrano Parado Sandra Zoraida - advancesoft.trujillo@gmail.com>
 * @version 1.0 
 * @created 02-agost-2015 01:30:00 p.m.
 */
public interface IBibliotecarioDAO {
    public void crear(Bibliotecario bibliotecario)throws Exception;
    public void modificar(Bibliotecario bibliotecario) throws Exception;
    public void eliminar(Bibliotecario bibliotecario) throws Exception;
    public Bibliotecario buscar(int codigo)throws Exception;
    public List<Bibliotecario> buscar(String nombre) throws Exception;
}
