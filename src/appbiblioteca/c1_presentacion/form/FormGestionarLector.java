/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appbiblioteca.c1_presentacion.form;

import appbiblioteca.c1_presentacion.util.Mensaje;
import appbiblioteca.c2_aplicacion.servicio.GestionarLectorServicio;
import appbiblioteca.c3_dominio.entidad.Lector;
import java.util.List;
import javax.swing.table.TableColumn;
import mastersoft.modelo.ModeloTabla;
import mastersoft.tabladatos.Columna;
import mastersoft.tabladatos.Fila;
import mastersoft.tabladatos.Tabla;

/**
 *
 * @author
 * <AdvanceSoft - Medrano Parado Sandra Zoraida - advancesoft.trujillo@gmail.com>
 * @version 1.0
 */
public class FormGestionarLector extends javax.swing.JDialog {

    /**
     * Creates new form FormGestionarLector
     * @param parent
     */
    public FormGestionarLector(java.awt.Frame parent) {
        super(parent, true);
        initComponents();
        crearTabla();
    }
    private void crearTabla(){
        Tabla tabla = new Tabla();
        tabla.agregarColumna(new Columna("CODIGO", "java.lang.Integer"));
        tabla.agregarColumna(new Columna("NOMBRE", "java.lang.String"));
        tabla.agregarColumna(new Columna("APELLIDOS", "java.lang.String"));
        tabla.agregarColumna(new Columna("DNI", "java.lang.String"));
        tabla.agregarColumna(new Columna("GENERO", "java.lang.String"));
        tabla.agregarColumna(new Columna("FECHA DE NACIMIENTO", "java.sql.Date"));
        ModeloTabla modeloTablaLector = new ModeloTabla(tabla);
        tablaLector.setModel(modeloTablaLector);
        TableColumn columna0,columna1,columna2,columna3,columna4,columna5;
        //CODIGO
        columna0 = tablaLector.getColumnModel().getColumn(0);
        tablaLector.removeColumn(columna0);
        //NOMBRE
        columna1 = tablaLector.getColumnModel().getColumn(0);
        columna1.setPreferredWidth(150);
        columna1.setMaxWidth(150);
        columna1.setMinWidth(150);
        //APELLIDOS
        columna2 = tablaLector.getColumnModel().getColumn(1);
        columna2.setPreferredWidth(180);
        columna2.setMaxWidth(180);
        columna2.setMinWidth(180);
        //DNI
        columna3 = tablaLector.getColumnModel().getColumn(2);
        columna3.setPreferredWidth(70);
        columna3.setMaxWidth(70);
        columna3.setMinWidth(70);
        //GENERO
        columna4 = tablaLector.getColumnModel().getColumn(3);
        columna4.setPreferredWidth(100);
        columna4.setMaxWidth(100);
        columna4.setMinWidth(100);
        //FECHA DE NACIMIENTO
        columna5 = tablaLector.getColumnModel().getColumn(4);
        columna5.setPreferredWidth(150);
        columna5.setMaxWidth(150);
        columna5.setMinWidth(150);
    }
    
    private void ponerFocoConSeleccionEnBuscar(){
        textoBuscar.selectAll();
        textoBuscar.requestFocus();
    }
    
    private void buscarLector(){
        ModeloTabla modeloTablaLector = (ModeloTabla) tablaLector.getModel();
        modeloTablaLector.eliminarTotalFilas();
        try{
            GestionarLectorServicio gestionarLectorServicio = new GestionarLectorServicio();        
            List<Lector> listalector = gestionarLectorServicio.buscar(textoBuscar.getText().trim().toUpperCase());
            if(listalector!=null && listalector.size() > 0){
                for (Lector lector : listalector) {
                    Fila fila = new Fila();
                    fila.agregarValorCelda(lector.getCodigo());
                    fila.agregarValorCelda(lector.getNombre());
                    fila.agregarValorCelda(lector.getApellido());
                    fila.agregarValorCelda(lector.getDni());
                    fila.agregarValorCelda(lector.getGenero());
                    fila.agregarValorCelda(lector.getFechanacimiento());
                    modeloTablaLector.agregarFila(fila);
                }
                modeloTablaLector.refrescarDatos();
                ponerFocoConSeleccionEnBuscar();                
            }else{
                Mensaje.Mostrar_MENSAJE_NOSEENCONTRONINGUNRESULTADO(this);
                ponerFocoConSeleccionEnBuscar();
            }
        }catch(Exception e){
            Mensaje.mostrarErrorExcepcion(this, e.getMessage());
            ponerFocoConSeleccionEnBuscar();
        }
    }

    private Lector obtenerObjetoDeLaTabla(){
        Lector lector = null;
        int numFila = tablaLector.getSelectedRow();
        if(numFila >= 0){//verificamos si se selecciono alguna fila de la Tabla            
            GestionarLectorServicio gestionarLectorServicio = new GestionarLectorServicio();
            ModeloTabla modeloTabla = (ModeloTabla) tablaLector.getModel();
            int codigo = (int) modeloTabla.getValueAt(numFila, 0);
            try{
                lector = gestionarLectorServicio.buscar(codigo);
            }catch(Exception e){
                Mensaje.mostrarErrorExcepcion(this,e.getMessage());
            }
        }else
            Mensaje.Mostrar_MENSAJE_FILANOSELECCIONADO(this);
        return lector;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        botonCrear = new javax.swing.JButton();
        botomModificar = new javax.swing.JButton();
        botonEliminar = new javax.swing.JButton();
        botonSalir = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        textoBuscar = new javax.swing.JTextField();
        botonbuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaLector = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestionar Lector");

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        botonCrear.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        botonCrear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/appbiblioteca/c1_presentacion/iconos/crearx32.png"))); // NOI18N
        botonCrear.setText("Crear");
        botonCrear.setFocusable(false);
        botonCrear.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonCrear.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCrearActionPerformed(evt);
            }
        });
        jToolBar1.add(botonCrear);

        botomModificar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        botomModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/appbiblioteca/c1_presentacion/iconos/modificarx32.png"))); // NOI18N
        botomModificar.setText("Modificar");
        botomModificar.setFocusable(false);
        botomModificar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botomModificar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botomModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botomModificarActionPerformed(evt);
            }
        });
        jToolBar1.add(botomModificar);

        botonEliminar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        botonEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/appbiblioteca/c1_presentacion/iconos/eliminarx32.png"))); // NOI18N
        botonEliminar.setText("Eliminar");
        botonEliminar.setFocusable(false);
        botonEliminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonEliminar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarActionPerformed(evt);
            }
        });
        jToolBar1.add(botonEliminar);

        botonSalir.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        botonSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/appbiblioteca/c1_presentacion/iconos/salirx32.png"))); // NOI18N
        botonSalir.setText("Salir");
        botonSalir.setFocusable(false);
        botonSalir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonSalir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirActionPerformed(evt);
            }
        });
        jToolBar1.add(botonSalir);

        getContentPane().add(jToolBar1, java.awt.BorderLayout.PAGE_START);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Nombre:");

        textoBuscar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        botonbuscar.setBackground(new java.awt.Color(255, 255, 255));
        botonbuscar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        botonbuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/appbiblioteca/c1_presentacion/iconos/buscarx20.png"))); // NOI18N
        botonbuscar.setText("Buscar");
        botonbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonbuscarActionPerformed(evt);
            }
        });

        tablaLector.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaLector);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 228, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textoBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                            .addComponent(botonbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1))
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botonCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCrearActionPerformed
        // TODO add your handling code here:
        FormRegistrarLector formRegistrarLector = new FormRegistrarLector(this);
        formRegistrarLector.setVisible(true);
        buscarLector();
    }//GEN-LAST:event_botonCrearActionPerformed

    private void botomModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botomModificarActionPerformed
        // TODO add your handling code here:
        Lector lector = obtenerObjetoDeLaTabla();
        if(lector != null){
            FormRegistrarLector formRegistrarLector = new FormRegistrarLector(this,lector);
            formRegistrarLector.setVisible(true);
            buscarLector();
        }
    }//GEN-LAST:event_botomModificarActionPerformed

    private void botonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarActionPerformed
        // TODO add your handling code here:
        GestionarLectorServicio gestionarLectorServicio = new GestionarLectorServicio();
        if(obtenerObjetoDeLaTabla() != null){
            if(!Mensaje.Mostrar_MENSAJE_PREGUNTADEELIMINACION(this))
                return;
            try{
                gestionarLectorServicio.eliminar(obtenerObjetoDeLaTabla());
                Mensaje.Mostrar_MENSAJE_ELIMINACIONEXITOSA(this);
                buscarLector();
                ponerFocoConSeleccionEnBuscar();
            }catch(Exception e){
                Mensaje.Mostrar_MENSAJE_ELIMINACIONERRONEA(this);
                buscarLector();
                ponerFocoConSeleccionEnBuscar();
            }
        }
    }//GEN-LAST:event_botonEliminarActionPerformed

    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_botonSalirActionPerformed

    private void botonbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonbuscarActionPerformed
        // TODO add your handling code here:
        buscarLector();
        ponerFocoConSeleccionEnBuscar();
    }//GEN-LAST:event_botonbuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botomModificar;
    private javax.swing.JButton botonCrear;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JButton botonSalir;
    private javax.swing.JButton botonbuscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTable tablaLector;
    private javax.swing.JTextField textoBuscar;
    // End of variables declaration//GEN-END:variables
}
