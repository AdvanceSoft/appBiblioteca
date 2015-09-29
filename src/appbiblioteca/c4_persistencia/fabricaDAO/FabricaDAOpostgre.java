package appbiblioteca.c4_persistencia.fabricaDAO;

import appbiblioteca.c3_dominio.contrato.IAdquisicionDAO;
import appbiblioteca.c3_dominio.contrato.IAutorDAO;
import appbiblioteca.c3_dominio.contrato.IBibliotecarioDAO;
import appbiblioteca.c3_dominio.contrato.ILectorDAO;
import appbiblioteca.c3_dominio.contrato.IEjemplarDAO;
import appbiblioteca.c3_dominio.contrato.IEspecialidadDAO;
import appbiblioteca.c3_dominio.contrato.ILibroDAO;
import appbiblioteca.c3_dominio.contrato.INivelDAO;
import appbiblioteca.c3_dominio.contrato.IPrestamoDAO;
import appbiblioteca.c3_dominio.contrato.IProveedorDAO;
import appbiblioteca.c3_dominio.contrato.IUbicacionArmarioDAO;
import appbiblioteca.c3_dominio.contrato.IUbicacionFilaDAO;
import appbiblioteca.c3_dominio.contrato.IUbicacionPisoDAO;
import appbiblioteca.c4_persistencia.jdbcpostgre.ProveedorDAOPostgre;
import appbiblioteca.c4_persistencia.GestorJDBC;
import appbiblioteca.c4_persistencia.jdbcpostgre.AdquisicionDAOPostgre;
import appbiblioteca.c4_persistencia.jdbcpostgre.AutorDAOPostgre;
import appbiblioteca.c4_persistencia.jdbcpostgre.BibliotecarioDAOPostgre;
import appbiblioteca.c4_persistencia.jdbcpostgre.ConexionJDBCPostgre;
import appbiblioteca.c4_persistencia.jdbcpostgre.LectorDAOPostgre;

import appbiblioteca.c4_persistencia.jdbcpostgre.UbicacionArmarioDAOPostgre;
import appbiblioteca.c4_persistencia.jdbcpostgre.UbicacionFilaDAOPostgre;
import appbiblioteca.c4_persistencia.jdbcpostgre.UbicacionPisoDAOPostgre;

import appbiblioteca.c4_persistencia.jdbcpostgre.EjemplarDAOPostgre;
import appbiblioteca.c4_persistencia.jdbcpostgre.EspecialidadDAOPostgre;
import appbiblioteca.c4_persistencia.jdbcpostgre.LibroDAOPostgre;
import appbiblioteca.c4_persistencia.jdbcpostgre.NivelDAOPostgre;
import appbiblioteca.c4_persistencia.jdbcpostgre.PrestamoDAOPostgre;


/**
 * @author <AdvanceSoft - Osorio Perez Carlos Alfredo - advancesoft.trujillo@gmail.com>
 * @version 1.0
 * @created 25-jul-2015 06:07:59 p.m.
 */
public class FabricaDAOpostgre extends FabricaAbstractaDAO {

    @Override
    public GestorJDBC crearGestorJDBC() {
        return new ConexionJDBCPostgre();
    }

    @Override
    public IProveedorDAO crearProveedorDAO(GestorJDBC gestorJDBC) {
        return new ProveedorDAOPostgre(gestorJDBC);
    }
    
    @Override
    public IAutorDAO crearAutorDAO(GestorJDBC gestorJDBC) {
        return new AutorDAOPostgre(gestorJDBC);
    }

    @Override
    public ILectorDAO crearLectorDAO(GestorJDBC gestorJDBC) {
        return new LectorDAOPostgre(gestorJDBC);
    }

    @Override
    public IBibliotecarioDAO crearBibliotecarioDAO(GestorJDBC gestorJDBC) {
        return new BibliotecarioDAOPostgre(gestorJDBC);
    }
    @Override
    public IUbicacionFilaDAO crearUbicacionFilaDAO(GestorJDBC gestorJDBC) {
        return new UbicacionFilaDAOPostgre(gestorJDBC);
    }

    @Override
    public IUbicacionArmarioDAO crearUbicacionArmarioDAO(GestorJDBC gestorJDBC) {
        return new UbicacionArmarioDAOPostgre(gestorJDBC);
    }

    @Override
    public IUbicacionPisoDAO crearUbicacionPisoDAO(GestorJDBC gestorJDBC) {
        return new UbicacionPisoDAOPostgre(gestorJDBC);
    }
    @Override
    public IEjemplarDAO crearEjemplarDAO(GestorJDBC gestorJDBC) {
        return new EjemplarDAOPostgre(gestorJDBC);
    }

    @Override
    public IAdquisicionDAO crearAdquisicionDAO(GestorJDBC gestorJDBC) {
        return new AdquisicionDAOPostgre(gestorJDBC);

    }

    @Override
    public ILibroDAO crearLibroDAO(GestorJDBC gestorJDBC) {
        return new LibroDAOPostgre(gestorJDBC);
    }

    @Override
    public INivelDAO crearNivelDAO(GestorJDBC gestorJDBC) {
        return new NivelDAOPostgre(gestorJDBC);
    }

    @Override
    public IEspecialidadDAO crearEspecialidadDAO(GestorJDBC gestorJDBC) {
        return new EspecialidadDAOPostgre(gestorJDBC);
    }

    @Override
    public IPrestamoDAO crearPrestamoDAO(GestorJDBC gestorJDBC) {
        return new PrestamoDAOPostgre(gestorJDBC);
    }

}
