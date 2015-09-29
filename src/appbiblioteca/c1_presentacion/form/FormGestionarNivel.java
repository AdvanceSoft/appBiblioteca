/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appbiblioteca.c1_presentacion.form;

import appbiblioteca.c1_presentacion.util.Mensaje;
import appbiblioteca.c2_aplicacion.servicio.GestionarNivelServicio;
import appbiblioteca.c3_dominio.entidad.LineaEspecialidad;
import appbiblioteca.c3_dominio.entidad.Nivel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.TableColumn;
import mastersoft.modelo.ModeloTabla;
import mastersoft.tabladatos.Columna;
import mastersoft.tabladatos.Fila;
import mastersoft.tabladatos.Tabla;

/**
 *
 * @author CarlosAlfredo
 */
public class FormGestionarNivel extends javax.swing.JDialog {
    Nivel nivel;
    List<Nivel> listaNivel;
    /**
     * Creates new form FormGestionarNivel
     * @param parent
     */
    public FormGestionarNivel(java.awt.Frame parent) {
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
        tablaNivel.setModel(modeloTablaEspecialidad);
        TableColumn columna0,columna1,columna2;
        
        //CODIGO
        columna0 = tablaNivel.getColumnModel().getColumn(0);
        tablaNivel.removeColumn(columna0);
        
        //NOMBRE
        columna1 = tablaNivel.getColumnModel().getColumn(0);
        columna1.setPreferredWidth(216);
        columna1.setMaxWidth(216);
        columna1.setMinWidth(216);
        
        //DESCRIPCION
        columna2 = tablaNivel.getColumnModel().getColumn(1);
        columna2.setPreferredWidth(216);
        columna2.setMaxWidth(216);
        columna2.setMinWidth(216);
    }
    
    private void ponerFocoConSeleccionEnBuscar(){
        textoBuscar.selectAll();
        textoBuscar.requestFocus();
    }
    
    private void consultarNivel(){
        ModeloTabla modeloTablaNivel = (ModeloTabla) tablaNivel.getModel();
        modeloTablaNivel.eliminarTotalFilas();
        String nombre = textoBuscar.getText().trim().toUpperCase();
        try {
            GestionarNivelServicio gestionarNivelServicio = new GestionarNivelServicio();
            listaNivel = gestionarNivelServicio.buscarPorNombre(nombre);
            if(listaNivel!=null && listaNivel.size()>0){
                for(Nivel nivel : listaNivel){
                    Fila fila = new Fila();
                    fila.agregarValorCelda(nivel.getCodigo());
                    fila.agregarValorCelda(nivel.getNombre());
                    fila.agregarValorCelda(nivel.getDescripcion());
                    //fila.agregarValorCelda(nivel);
                    modeloTablaNivel.agregarFila(fila);
                }  
                tablaNivel.setModel(modeloTablaNivel);
            }else{
                Mensaje.Mostrar_MENSAJE_NOSEENCONTRONINGUNRESULTADO(this);
                ponerFocoConSeleccionEnBuscar();
            }             
        } catch(Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

//    private Nivel obtenerObjetoDeLaTabla(){
//        Nivel nivel = null;
//        int numFila = tablaNivel.getSelectedRow();
//        if(numFila >= 0){//verificamos si se selecciono alguna fila de la Tabla            
//            GestionarNivelServicio gestionarNivelServicio = new GestionarNivelServicio();
//            ModeloTabla modeloTabla = (ModeloTabla) tablaNivel.getModel();
//            int codigo = (int) modeloTabla.getValueAt(numFila, 0);
//            try{
//                nivel = gestionarNivelServicio.buscar(codigo);
//            }catch(Exception e){
//                Mensaje.mostrarErrorExcepcion(this,e.getMessage());
//            }
//        }else
//            Mensaje.Mostrar_MENSAJE_FILANOSELECCIONADO(this);
//        return nivel;
//    } 
    
     private Nivel obtenerObjetoDeLaTablaModificar(){
        Nivel nivel = null;
        int numFila = tablaNivel.getSelectedRow();
        if(numFila >= 0){//verificamos si se selecciono alguna fila de la Tabla            
            GestionarNivelServicio gestionarNivelServicio = new GestionarNivelServicio();
            ModeloTabla modeloTabla = (ModeloTabla) tablaNivel.getModel();
            int codigo = (int) modeloTabla.getValueAt(numFila, 0);
            try{
                nivel = gestionarNivelServicio.buscar(codigo);
            }catch(Exception e){
                Mensaje.mostrarErrorExcepcion(this,e.getMessage());
            }
        }else
            Mensaje.Mostrar_MENSAJE_FILANOSELECCIONADO(this);
        return nivel;
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
        botonModificar = new javax.swing.JButton();
        botonEliminar = new javax.swing.JButton();
        botonSalir = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        textoBuscar = new javax.swing.JTextField();
        botonBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaNivel = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestionar Nivel");

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

        botonModificar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        botonModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/appbiblioteca/c1_presentacion/iconos/modificarx32.png"))); // NOI18N
        botonModificar.setText("Modificar");
        botonModificar.setFocusable(false);
        botonModificar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonModificar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonModificarActionPerformed(evt);
            }
        });
        jToolBar1.add(botonModificar);

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
        jLabel1.setText("Nombre :");

        textoBuscar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        botonBuscar.setBackground(new java.awt.Color(255, 255, 255));
        botonBuscar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        botonBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/appbiblioteca/c1_presentacion/iconos/buscarx20.png"))); // NOI18N
        botonBuscar.setText("Buscar");
        botonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarActionPerformed(evt);
            }
        });

        tablaNivel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaNivel);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(textoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(botonBuscar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(textoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botonCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCrearActionPerformed
        // TODO add your handling code here:
       FormRegistrarNivel formRegistrarNivel = new FormRegistrarNivel(this);
       formRegistrarNivel.setVisible(true);
       consultarNivel();
    }//GEN-LAST:event_botonCrearActionPerformed

    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_botonSalirActionPerformed

    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed
        // TODO add your handling code here:        
            consultarNivel();
            ponerFocoConSeleccionEnBuscar();
    }//GEN-LAST:event_botonBuscarActionPerformed

    private void botonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonModificarActionPerformed
        // TODO add your handling code here:
        Nivel nivel = obtenerObjetoDeLaTablaModificar();
        if(nivel != null){
            FormRegistrarNivel formRegistrarNivel = new FormRegistrarNivel(this,nivel);
            formRegistrarNivel.setVisible(true);
            consultarNivel();
        } 
    }//GEN-LAST:event_botonModificarActionPerformed

    private void botonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarActionPerformed
        // TODO add your handling code here:
//        GestionarNivelServicio gestionarNivelServicio = new GestionarNivelServicio();
//        if(obtenerObjetoDeLaTabla() !=null){
//            if(!Mensaje.Mostrar_MENSAJE_PREGUNTADEELIMINACION(this))
//                return;
//            try {
//                   gestionarNivelServicio.eliminar(obtenerObjetoDeLaTabla());
//                   Mensaje.Mostrar_MENSAJE_ELIMINACIONEXITOSA(this);
//                   consultarNivel();
//                   ponerFocoConSeleccionEnBuscar();
//            } catch (Exception e) {
//                Mensaje.Mostrar_MENSAJE_ELIMINACIONERRONEA(this);
//                consultarNivel();
//                ponerFocoConSeleccionEnBuscar();
//            }            
//        }
    }//GEN-LAST:event_botonEliminarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonBuscar;
    private javax.swing.JButton botonCrear;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JButton botonModificar;
    private javax.swing.JButton botonSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTable tablaNivel;
    private javax.swing.JTextField textoBuscar;
    // End of variables declaration//GEN-END:variables
}
