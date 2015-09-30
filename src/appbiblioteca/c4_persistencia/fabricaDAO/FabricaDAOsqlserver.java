package appbiblioteca.c4_persistencia.fabricaDAO;

import appbiblioteca.c3_dominio.contrato.IAdquisicionDAO;
import appbiblioteca.c3_dominio.contrato.IAutorDAO;
import appbiblioteca.c3_dominio.contrato.IBibliotecarioDAO;
import appbiblioteca.c3_dominio.contrato.IEjemplarDAO;
import appbiblioteca.c3_dominio.contrato.IEspecialidadDAO;
import appbiblioteca.c3_dominio.contrato.ILectorDAO;
import appbiblioteca.c3_dominio.contrato.ILibroDAO;
import appbiblioteca.c3_dominio.contrato.INivelDAO;
import appbiblioteca.c3_dominio.contrato.IPrestamoDAO;
import appbiblioteca.c3_dominio.contrato.IProveedorDAO;
import appbiblioteca.c3_dominio.contrato.IUbicacionArmarioDAO;
import appbiblioteca.c3_dominio.contrato.IUbicacionFilaDAO;
import appbiblioteca.c3_dominio.contrato.IUbicacionPisoDAO;
import appbiblioteca.c4_persistencia.GestorJDBC;
import appbiblioteca.c4_persistencia.jdbcsqlserver.ConexionJDBCSQLServer;
import appbiblioteca.c4_persistencia.jdbcsqlserver.ProveedorDAOsqlserver;

/**
 * @author <AdvanceSoft - Osorio Perez Carlos Alfredo - advancesoft.trujillo@gmail.com>
 * @version 1.0
 * @created 25-jul-2015 06:07:59 p.m.
 */
public class FabricaDAOsqlserver extends FabricaAbstractaDAO {

    @Override
    public GestorJDBC crearGestorJDBC() {
        return new ConexionJDBCSQLServer();
    }

    @Override
    public IProveedorDAO crearProveedorDAO(GestorJDBC gestorJDBC) {
        return new ProveedorDAOsqlserver(gestorJDBC);
    }

    @Override
    public IAutorDAO crearAutorDAO(GestorJDBC gestorJDBC) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ILectorDAO crearLectorDAO(GestorJDBC gestorJDBC) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IBibliotecarioDAO crearBibliotecarioDAO(GestorJDBC gestorJDBC) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    @Override
    public IUbicacionFilaDAO crearUbicacionFilaDAO(GestorJDBC gestorJDBC) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IUbicacionArmarioDAO crearUbicacionArmarioDAO(GestorJDBC gestorJDBC) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IUbicacionPisoDAO crearUbicacionPisoDAO(GestorJDBC gestorJDBC) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public IEjemplarDAO crearEjemplarDAO(GestorJDBC gestorJDBC) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IAdquisicionDAO crearAdquisicionDAO(GestorJDBC gestorJDBC) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ILibroDAO crearLibroDAO(GestorJDBC gestorJDBC) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public INivelDAO crearNivelDAO(GestorJDBC gestorJDBC) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IEspecialidadDAO crearEspecialidadDAO(GestorJDBC gestorJDBC) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IPrestamoDAO crearPrestamoDAO(GestorJDBC gestorJDBC) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
