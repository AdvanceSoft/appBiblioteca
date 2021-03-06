/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appbiblioteca.c1_presentacion.form;

import appbiblioteca.c1_presentacion.util.Mensaje;
import appbiblioteca.c2_aplicacion.servicio.GestionarEspecialidadServicio;
import appbiblioteca.c3_dominio.entidad.Especialidad;
import java.util.List;
import javax.swing.table.TableColumn;
import mastersoft.modelo.ModeloTabla;
import mastersoft.tabladatos.Columna;
import mastersoft.tabladatos.Fila;
import mastersoft.tabladatos.Tabla;

/**
 *
 * @author CarlosAlfredo
 */
public class FormGestionarEspecialidad extends javax.swing.JDialog {

    /**
     * Creates new form FormGestionarEspecialidad
     * @param parent
     */
    public FormGestionarEspecialidad(java.awt.Frame parent) {
        super(parent, true);
        initComponents();
        crearTabla();
    }
    
    private void crearTabla(){
        Tabla tabla = new Tabla();
        tabla.agregarColumna(new Columna("CODIGO", "java.lang.Integer"));
        tabla.agregarColumna(new Columna("NOMBRE", "java.lang.String"));
        tabla.agregarColumna(new Columna("DESCRIPCION", "java.lang.String"));
        ModeloTabla modeloTablaEspecialidad = new ModeloTabla(tabla);
        tablaEspecialidad.setModel(modeloTablaEspecialidad);
        TableColumn columna0,columna1,columna2;
        
        //CODIGO
        columna0 = tablaEspecialidad.getColumnModel().getColumn(0);
        tablaEspecialidad.removeColumn(columna0);
        
        //NOMBRE
        columna1 = tablaEspecialidad.getColumnModel().getColumn(0);
        columna1.setPreferredWidth(216);
        columna1.setMaxWidth(216);
        columna1.setMinWidth(216);
        
        //DESCRIPCION
        columna2 = tablaEspecialidad.getColumnModel().getColumn(1);
        columna2.setPreferredWidth(216);
        columna2.setMaxWidth(216);
        columna2.setMinWidth(216);
    }
    
    private void ponerFocoConSeleccionEnBuscar(){
        textoBuscar.selectAll();
        textoBuscar.requestFocus();
    }
    
    private void buscarEspecialidad(){
        ModeloTabla modeloTablaEspecialidad = (ModeloTabla) tablaEspecialidad.getModel();
        modeloTablaEspecialidad.eliminarTotalFilas();
        try {
            GestionarEspecialidadServicio gestionarEspecialidadServicio = new GestionarEspecialidadServicio();
            List<Especialidad> listaEspecialidad = gestionarEspecialidadServicio.buscar(textoBuscar.getText().trim().toUpperCase());
            if(listaEspecialidad != null && listaEspecialidad.size() > 0){
                for(Especialidad especialidad : listaEspecialidad){
                    Fila fila = new Fila();
                    fila.agregarValorCelda(especialidad.getCodigo());
                    fila.agregarValorCelda(especialidad.getNombre());
                    fila.agregarValorCelda(especialidad.getDescripcion());
                    modeloTablaEspecialidad.agregarFila(fila);
                }
                modeloTablaEspecialidad.refrescarDatos();
                ponerFocoConSeleccionEnBuscar();
            }else{
                Mensaje.Mostrar_MENSAJE_NOSEENCONTRONINGUNRESULTADO(this);
                ponerFocoConSeleccionEnBuscar();
            }
        } catch (Exception e) {
            Mensaje.mostrarErrorExcepcion(this, e.getMessage());
            ponerFocoConSeleccionEnBuscar();
        }
    }
    
    private Especialidad obtenerObjetoDeLaTabla(){
        Especialidad especialidad = null;
        int numFila = tablaEspecialidad.getSelectedRow();
        if (numFila >= 0){
            GestionarEspecialidadServicio gestionarEspecialidadServicio = new GestionarEspecialidadServicio();
            ModeloTabla modeloTabla = (ModeloTabla) tablaEspecialidad.getModel();
            int codigo = (int) modeloTabla.getValueAt(numFila, 0);
            try {
                especialidad = gestionarEspecialidadServicio.buscar(codigo);
            } catch (Exception e) {
                Mensaje.mostrarErrorExcepcion(this, e.getMessage());
            }
        }else {
            Mensaje.Mostrar_MENSAJE_FILANOSELECCIONADO(this);
        }
        return especialidad;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        barraOpciones = new javax.swing.JToolBar();
        botonCrear = new javax.swing.JButton();
        botonModicar = new javax.swing.JButton();
        botonEliminar = new javax.swing.JButton();
        botonSalir = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        textoBuscar = new javax.swing.JTextField();
        botonBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaEspecialidad = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestionar Especialidad");

        barraOpciones.setFloatable(false);
        barraOpciones.setRollover(true);

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
        barraOpciones.add(botonCrear);

        botonModicar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        botonModicar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/appbiblioteca/c1_presentacion/iconos/modificarx32.png"))); // NOI18N
        botonModicar.setText("Modificar");
        botonModicar.setFocusable(false);
        botonModicar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonModicar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonModicar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonModicarActionPerformed(evt);
            }
        });
        barraOpciones.add(botonModicar);

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
        barraOpciones.add(botonEliminar);

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
        barraOpciones.add(botonSalir);

        getContentPane().add(barraOpciones, java.awt.BorderLayout.PAGE_START);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Nombre:");

        textoBuscar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        botonBuscar.setBackground(new java.awt.Color(255, 255, 255));
        botonBuscar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        botonBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/appbiblioteca/c1_presentacion/iconos/buscarx20.png"))); // NOI18N
        botonBuscar.setText("Buscar");
        botonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarActionPerformed(evt);
            }
        });

        tablaEspecialidad.setAutoCreateRowSorter(true);
        tablaEspecialidad.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tablaEspecialidad);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonBuscar)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(textoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_botonSalirActionPerformed

    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed
        // TODO add your handling code here:
        buscarEspecialidad();
        ponerFocoConSeleccionEnBuscar();
    }//GEN-LAST:event_botonBuscarActionPerformed

    private void botonCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCrearActionPerformed
        // TODO add your handling code here:
        FormRegistrarEspecialidad formRegistrarEspecialidad = new FormRegistrarEspecialidad(this);
        formRegistrarEspecialidad.setVisible(true);
        buscarEspecialidad();
    }//GEN-LAST:event_botonCrearActionPerformed

    private void botonModicarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonModicarActionPerformed
        // TODO add your handling code here:
        Especialidad especialidad = obtenerObjetoDeLaTabla();
        if(especialidad != null){
            FormRegistrarEspecialidad formRegistrarEspecialidad = new FormRegistrarEspecialidad(this, especialidad);
            formRegistrarEspecialidad.setVisible(true);
            buscarEspecialidad();
        }
    }//GEN-LAST:event_botonModicarActionPerformed

    private void botonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarActionPerformed
        // TODO add your handling code here:
        GestionarEspecialidadServicio gestionarEspecialidadServicio = new GestionarEspecialidadServicio();
        if(obtenerObjetoDeLaTabla() != null){
            if(!Mensaje.Mostrar_MENSAJE_PREGUNTADEELIMINACION(this))
                return;
            try {
                gestionarEspecialidadServicio.eliminar(obtenerObjetoDeLaTabla());
                Mensaje.Mostrar_MENSAJE_ELIMINACIONEXITOSA(this);
                buscarEspecialidad();
                ponerFocoConSeleccionEnBuscar();
            } catch (Exception e) {
                Mensaje.Mostrar_MENSAJE_ELIMINACIONERRONEA(this);
                buscarEspecialidad();
                ponerFocoConSeleccionEnBuscar();
            }
        }
    }//GEN-LAST:event_botonEliminarActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(FormGestionarEspecialidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(FormGestionarEspecialidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(FormGestionarEspecialidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(FormGestionarEspecialidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                FormGestionarEspecialidad dialog = new FormGestionarEspecialidad(new javax.swing.JFrame(), true);
//                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//                    @Override
//                    public void windowClosing(java.awt.event.WindowEvent e) {
//                        System.exit(0);
//                    }
//                });
//                dialog.setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToolBar barraOpciones;
    private javax.swing.JButton botonBuscar;
    private javax.swing.JButton botonCrear;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JButton botonModicar;
    private javax.swing.JButton botonSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaEspecialidad;
    private javax.swing.JTextField textoBuscar;
    // End of variables declaration//GEN-END:variables
}
