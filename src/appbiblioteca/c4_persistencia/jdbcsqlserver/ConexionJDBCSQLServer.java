/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appbiblioteca.c4_persistencia.jdbcsqlserver;

import appbiblioteca.c4_persistencia.GestorJDBC;
import java.sql.DriverManager;

/**
 *
 * @author
 * <AdvanceSoft - Osorio Perez Carlos Alfredo - advancesoft.trujillo@gmail.com>
 */
public class ConexionJDBCSQLServer extends GestorJDBC{

    @Override
    public void abrirConexion() throws Exception {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) { }
        String url = "";
        conexion = DriverManager.getConnection("jdbc:sqlserver://t0utyiq57d.database.windows.net:1433;database=biblioteca;user=advancesoft@t0utyiq57d;password=Password*123;encrypt=true;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");            
    }
    
}
