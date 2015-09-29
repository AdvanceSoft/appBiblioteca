/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appbiblioteca.c5_transversal.propiedades;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author <AdvanceSoft - Osorio Perez Carlos Alfredo - advancesoft.trujillo@gmail.com>
 * @version 1.0
 * @created 25-jul-2015 06:07:59 p.m.
 */
public class LectorPropiedades {
    String ruta_archivo;

    public LectorPropiedades(String ruta_archivo) {
        this.ruta_archivo = ruta_archivo;
    }
    
    public String getValorParametro(String parametro){
        String valorParametro;
        InputStream input;
        Properties p = new Properties();
        try {
            input = ClassLoader.getSystemResourceAsStream(ruta_archivo);
            p.load(input);
            valorParametro = p.getProperty(parametro);
            return valorParametro;
        } catch (IOException e) {
            return null;
        }
    }    
}
