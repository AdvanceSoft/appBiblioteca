/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appbiblioteca.c1_presentacion.form;

import appbiblioteca.c3_dominio.entidad.Proveedor;
import appbiblioteca.c1_presentacion.util.Mensaje;
import appbiblioteca.c2_aplicacion.servicio.GestionarProveedorServicio;
import javax.swing.JDialog;

/**
 *
 * @author
 * <AdvanceSoft - Osorio Perez Carlos Alfredo - advancesoft.trujillo@gmail.com>
 */
public class FormRegistrarProveedor extends javax.swing.JDialog {

    Proveedor proveedor;
    /**
     * Creates new form FormRegistrarProveedor
     * @param parent
     */
    public FormRegistrarProveedor(JDialog parent) {
        super(parent, true);
        initComponents();
        this.proveedor = new Proveedor();
    }
    
    public FormRegistrarProveedor(JDialog parent,Proveedor proveedor) {
        super(parent, true);
        initComponents();        
        obtenerObjetoDeGestionar(proveedor);
    }
    
    private void obtenerObjetoDeGestionar(Proveedor proveedor){
        this.proveedor = proveedor;
        textoNombre.setText(proveedor.getNombre());
        textoDireccion.setText(proveedor.getDireccion());
    }
    
    
    private boolean verificarCamposLlenos(){
        boolean verificar = false;
        if(!textoNombre.getText().trim().isEmpty())
           verificar = true;
        else if(!textoDireccion.getText().trim().isEmpty())
            verificar = true;
        return verificar;     
    }
    
    private boolean verificarCamposVacios(){
        boolean verificar = true;
        if(textoNombre.getText().trim().isEmpty()){
           Mensaje.Mostrar_MENSAJE_LLENARCAMPOSOBLIGATORIOS(this);
           textoNombre.requestFocus();
           verificar = false;
        }else if(textoDireccion.getText().trim().isEmpty()){
            Mensaje.Mostrar_MENSAJE_LLENARCAMPOSOBLIGATORIOS(this);
            textoDireccion.requestFocus();
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        textoNombre = new javax.swing.JTextField();
        textoDireccion = new javax.swing.JTextField();
        botonGuardar = new javax.swing.JButton();
        botonSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registrar Proveedor");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Nombre:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Dirección:");

        textoNombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        textoDireccion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        textoDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textoDireccionActionPerformed(evt);
            }
        });

        botonGuardar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botonGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/appbiblioteca/c1_presentacion/iconos/guardarx32.png"))); // NOI18N
        botonGuardar.setText("Guardar");
        botonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarActionPerformed(evt);
            }
        });

        botonSalir.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botonSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/appbiblioteca/c1_presentacion/iconos/salirx32.png"))); // NOI18N
        botonSalir.setText("Salir");
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(textoDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                    .addComponent(textoNombre))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(botonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(textoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(textoDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(botonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirActionPerformed
        // TODO add your handling code here:
        if(verificarCamposLlenos()){
            if (Mensaje.Mostrar_MENSAJE_SALIRSINGUARDAR(this))
                this.dispose();
        }else
            this.dispose();
    }//GEN-LAST:event_botonSalirActionPerformed

    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarActionPerformed
        // TODO add your handling code here:
        if (verificarCamposVacios()) {
            proveedor.setNombre(textoNombre.getText().trim().toUpperCase());
            proveedor.setDireccion(textoDireccion.getText().trim().toUpperCase());
            GestionarProveedorServicio gestionarProveedorServicio = new GestionarProveedorServicio();
            try{
                if(proveedor.getCodigo()==0){
                    gestionarProveedorServicio.crear(proveedor);
                    Mensaje.Mostrar_MENSAJE_GUARDADOEXITOSO(this);
                    this.dispose();
                }else{
                    gestionarProveedorServicio.modificar(proveedor);
                    Mensaje.Mostrar_MENSAJE_MODIFICADOEXITOSO(this);
                    this.dispose();
                }
            }catch(Exception e){
                Mensaje.mostrarErrorExcepcion(this, e.getMessage());
            }
        }
               
    }//GEN-LAST:event_botonGuardarActionPerformed

    private void textoDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textoDireccionActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonGuardar;
    private javax.swing.JButton botonSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField textoDireccion;
    private javax.swing.JTextField textoNombre;
    // End of variables declaration//GEN-END:variables
}