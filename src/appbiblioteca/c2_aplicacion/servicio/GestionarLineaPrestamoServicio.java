/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appbiblioteca.c2_aplicacion.servicio;

import appbiblioteca.c3_dominio.contrato.IEjemplarDAO;
import appbiblioteca.c3_dominio.contrato.ILineaPrestamo;
import appbiblioteca.c3_dominio.entidad.Ejemplar;
import appbiblioteca.c4_persistencia.GestorJDBC;
import appbiblioteca.c4_persistencia.fabricaDAO.FabricaAbstractaDAO;

/**
 *
 * @author
 * <AdvanceSoft - Garcia Infante Petter Jhunior - advancesoft.trujillo@gmail.com>
 */
public class GestionarLineaPrestamoServicio {

    GestorJDBC gestorJDBC;
    IEjemplarDAO ejemplarDAO;
    
    public GestionarLineaPrestamoServicio(){
        FabricaAbstractaDAO fabricaAbstractaDAO = FabricaAbstractaDAO.getInstancia();
        gestorJDBC = fabricaAbstractaDAO.crearGestorJDBC();
        ejemplarDAO = fabricaAbstractaDAO.crearEjemplarDAO(gestorJDBC);
    }
    public Ejemplar buscarLibro(int codigo) throws Exception {
       Ejemplar ejemplar;
       gestorJDBC.abrirConexion();
        try {
            ejemplar = ejemplarDAO.buscar(codigo);
        } catch (Exception e) {
            gestorJDBC.cerrarConexion();
            throw e;
        }
        gestorJDBC.cerrarConexion();
        return ejemplar;
    }
    
}
