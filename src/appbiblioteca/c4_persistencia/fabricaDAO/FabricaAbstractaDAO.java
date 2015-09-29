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
import appbiblioteca.c4_persistencia.GestorJDBC;
import appbiblioteca.c5_transversal.propiedades.LectorPropiedades;

/**
 * @author <AdvanceSoft - Osorio Perez Carlos Alfredo - advancesoft.trujillo@gmail.com>
 * @version 1.0
 * @created 25-jul-2015 06:07:59 p.m.
 */
public abstract class FabricaAbstractaDAO {
    public static FabricaAbstractaDAO getInstancia(){
        String claseFabricaDAO;
        FabricaAbstractaDAO FabricaDAO;
        try {
            LectorPropiedades parametro = new LectorPropiedades("appbiblioteca/c5_transversal/propiedades/Parametros.properties");
            claseFabricaDAO = parametro.getValorParametro("claseFabricaDAO");
            FabricaDAO = (FabricaAbstractaDAO)Class.forName(claseFabricaDAO).newInstance();
            return FabricaDAO;
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            return null;
        }
    }
    
    public abstract GestorJDBC crearGestorJDBC();
    
    //todo contrato que se genere tendran que agregar su metodo abstracto aquí, guiense del siguiente ejemplo.
    public abstract IProveedorDAO crearProveedorDAO(GestorJDBC gestorJDBC);
    public abstract IAutorDAO crearAutorDAO(GestorJDBC gestorJDBC);
    public abstract ILectorDAO crearLectorDAO(GestorJDBC gestorJDBC);
    public abstract IBibliotecarioDAO crearBibliotecarioDAO(GestorJDBC gestorJDBC);
    public abstract IUbicacionFilaDAO crearUbicacionFilaDAO(GestorJDBC gestorJDBC);
    public abstract IUbicacionArmarioDAO crearUbicacionArmarioDAO(GestorJDBC gestorJDBC);
    public abstract IUbicacionPisoDAO crearUbicacionPisoDAO(GestorJDBC gestorJDBC);
    public abstract IEjemplarDAO crearEjemplarDAO(GestorJDBC gestorJDBC); 
    public abstract IAdquisicionDAO crearAdquisicionDAO(GestorJDBC gestorJDBC); 
    public abstract ILibroDAO crearLibroDAO(GestorJDBC gestorJDBC); 
    public abstract INivelDAO crearNivelDAO(GestorJDBC gestorJDBC);
    public abstract IEspecialidadDAO crearEspecialidadDAO(GestorJDBC gestorJDBC);
    public abstract IPrestamoDAO crearPrestamoDAO(GestorJDBC gestorJDBC);
}
