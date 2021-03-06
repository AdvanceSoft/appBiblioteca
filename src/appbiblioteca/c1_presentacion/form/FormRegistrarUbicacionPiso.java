/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appbiblioteca.c1_presentacion.form;

import appbiblioteca.c1_presentacion.util.Mensaje;
import appbiblioteca.c2_aplicacion.servicio.GestionarUbicacionPisoServicio;
import appbiblioteca.c3_dominio.entidad.UbicacionArmario;
import appbiblioteca.c3_dominio.entidad.UbicacionPiso;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JTable;
import javax.swing.table.TableColumn;
import mastersoft.modelo.ModeloTabla;
import mastersoft.tabladatos.Columna;
import mastersoft.tabladatos.Fila;
import mastersoft.tabladatos.Tabla;

/**
 *
 * @author
 * <AdvanceSoft - Garcia Infante Petter Jhunior - advancesoft.trujillo@gmail.com>
 */
public class FormRegistrarUbicacionPiso extends javax.swing.JDialog {
    
    UbicacionPiso ubicacionPiso;
    /**
     * Creates new form FormRegistrarUbicacionPiso
     * @param dialog
     */
    public FormRegistrarUbicacionPiso(JDialog dialog) {
        super(dialog, true);
        initComponents();
        this.ubicacionPiso = new UbicacionPiso();
    }
    
    public FormRegistrarUbicacionPiso(JDialog dialog, UbicacionPiso ubicacionPiso) {
        super(dialog, true);
        initComponents();
        obtenerObjetoDeGestionar(ubicacionPiso);
    }

    private void obtenerObjetoDeGestionar(UbicacionPiso ubicacionPiso){
        this.ubicacionPiso = ubicacionPiso;
        textoNombrePiso.setText(ubicacionPiso.getNombre());
        String nombre = ubicacionPiso.getNombre();      
    }
    
    public boolean verificarCamposLlenos(){
        boolean verificar = false;
        if(!textoNombrePiso.getText().trim().isEmpty())
           verificar = true;
        return verificar;
    }
    
    public boolean verificarCamposVacios(){
        boolean verificar = true;
        if(textoNombrePiso.getText().trim().isEmpty()){
           Mensaje.Mostrar_MENSAJE_LLENARCAMPOSOBLIGATORIOS(this);
           textoNombrePiso.requestFocus();
           verificar = false;
        }
        return verificar;       
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botonGuardar = new javax.swing.JButton();
        botonSalir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        textoNombrePiso = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registrar Ubicacion Piso");
        setResizable(false);

        botonGuardar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        botonGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/appbiblioteca/c1_presentacion/iconos/guardarx32.png"))); // NOI18N
        botonGuardar.setText("Guardar");
        botonGuardar.setMaximumSize(new java.awt.Dimension(117, 41));
        botonGuardar.setMinimumSize(new java.awt.Dimension(117, 41));
        botonGuardar.setPreferredSize(new java.awt.Dimension(117, 41));
        botonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarActionPerformed(evt);
            }
        });

        botonSalir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        botonSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/appbiblioteca/c1_presentacion/iconos/salirx32.png"))); // NOI18N
        botonSalir.setText("Salir");
        botonSalir.setMaximumSize(new java.awt.Dimension(117, 41));
        botonSalir.setMinimumSize(new java.awt.Dimension(117, 41));
        botonSalir.setPreferredSize(new java.awt.Dimension(117, 41));
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Piso:");

        textoNombrePiso.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(botonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(4, 4, 4)
                        .addComponent(textoNombrePiso, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(textoNombrePiso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarActionPerformed
        // TODO add your handling code here:
        if (verificarCamposVacios()) {
           ubicacionPiso.setNombre(textoNombrePiso.getText().trim().toUpperCase());
           GestionarUbicacionPisoServicio gestionarUbicacionPisoServicio = new GestionarUbicacionPisoServicio();
        try {
            if(ubicacionPiso.getCodigo()==0){
                gestionarUbicacionPisoServicio.crear(ubicacionPiso);
                Mensaje.Mostrar_MENSAJE_GUARDADOEXITOSO(this);
                this.dispose();
            }else{
                gestionarUbicacionPisoServicio.modificar(ubicacionPiso);
                Mensaje.Mostrar_MENSAJE_MODIFICADOEXITOSO(this);
                this.dispose();
            }
        } catch (Exception e) {
            Mensaje.mostrarErrorExcepcion(this,e.getMessage());
        }
        }
    }//GEN-LAST:event_botonGuardarActionPerformed

    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirActionPerformed
        // TODO add your handling code here:
         if(verificarCamposLlenos()){
            if (Mensaje.Mostrar_MENSAJE_SALIRSINGUARDAR(this))
                this.dispose();
        }else
            this.dispose();
    }//GEN-LAST:event_botonSalirActionPerformed

    /**
     * @param args the command line arguments
     */
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonGuardar;
    private javax.swing.JButton botonSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField textoNombrePiso;
    // End of variables declaration//GEN-END:variables
}
