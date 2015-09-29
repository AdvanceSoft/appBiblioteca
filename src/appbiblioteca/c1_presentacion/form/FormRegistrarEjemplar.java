/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appbiblioteca.c1_presentacion.form;

import appbiblioteca.c1_presentacion.util.Mensaje;
import appbiblioteca.c2_aplicacion.servicio.GestionarEjemplarServicio;
import appbiblioteca.c2_aplicacion.servicio.GestionarLibroServicio;
import appbiblioteca.c2_aplicacion.servicio.GestionarUbicacionArmarioServicio;
import appbiblioteca.c2_aplicacion.servicio.GestionarUbicacionFilaServicio;
import appbiblioteca.c2_aplicacion.servicio.GestionarUbicacionPisoServicio;
import appbiblioteca.c3_dominio.entidad.Ejemplar;
import appbiblioteca.c3_dominio.entidad.Libro;
import appbiblioteca.c3_dominio.entidad.UbicacionArmario;
import appbiblioteca.c3_dominio.entidad.UbicacionFila;
import appbiblioteca.c3_dominio.entidad.UbicacionPiso;
import java.util.List;
import javax.swing.JDialog;

/**
 *
 * @author
 * <AdvanceSoft - Osorio Perez Carlos Alfredo - advancesoft.trujillo@gmail.com>
 */
public class FormRegistrarEjemplar extends javax.swing.JDialog {

    Ejemplar ejemplar;
    Libro libro;
    List<UbicacionPiso> ubicacionPisos;
    List<UbicacionArmario> ubicacionArmarios;
    List<UbicacionFila> ubicacionFilas;   
    
    /**
     * Creates new form FormRegistrarEjemplar
     * @param parent
     */
    public FormRegistrarEjemplar(JDialog parent) {
        super(parent, true);
        initComponents();
        llenarComboPiso();
        llenarComboArmario();
        llenarComboFila();        
        iniciarCombos();        
        this.ejemplar = new Ejemplar();
    }

    public FormRegistrarEjemplar(JDialog parent, Ejemplar ejemplar){
        super(parent, true);
        initComponents();
        obtenerObjetosDeGestionar(ejemplar);
    }
    
    private void obtenerObjetosDeGestionar(Ejemplar ejemplar){
        this.ejemplar = ejemplar;
        textoNombre.setText(ejemplar.getLibro().getNombre());
        textoNivel.setText(ejemplar.getLibro().getNivel().getNombre());
        textoEspecialidad.setText(ejemplar.getLibro().getEspecialidad().getNombre());
        checkActivo.setSelected(ejemplar.getLibro().isActivo());        
    }
    
    private void iniciarCombos(){
        comboFila.setSelectedIndex(-1);
        comboPiso.setSelectedIndex(-1);
        comboArmario.setSelectedIndex(-1);
        comboTipo.setSelectedIndex(-1);
    }
    
    private void llenarComboPiso(){
        try{
            GestionarUbicacionPisoServicio gestionarUbicacionPisoServicio = new GestionarUbicacionPisoServicio();
            ubicacionPisos = gestionarUbicacionPisoServicio.buscar("");
            comboPiso.removeAllItems();
            for (UbicacionPiso ubicacionPiso : ubicacionPisos) {
                comboPiso.addItem(ubicacionPiso.getNombre());
            }
        }catch(Exception e){
            
        }
    }
    
    private void llenarComboArmario(){
        try{
            GestionarUbicacionArmarioServicio gestionarUbicacionArmarioServicio = new GestionarUbicacionArmarioServicio();
            ubicacionArmarios = gestionarUbicacionArmarioServicio.buscar("");
            comboArmario.removeAllItems();
            for (UbicacionArmario ubicacionArmario : ubicacionArmarios) {
                comboArmario.addItem(ubicacionArmario.getNombre());
            }
        }catch(Exception e){
            
        }
    }
    
    private void llenarComboFila(){
        try{
            GestionarUbicacionFilaServicio gestionarUbicacionFilaServicio = new GestionarUbicacionFilaServicio();
            ubicacionFilas = gestionarUbicacionFilaServicio.buscar("");
            comboFila.removeAllItems();
            for (UbicacionFila ubicacionFila : ubicacionFilas) {
                comboFila.addItem(ubicacionFila.getNombre());
            }
        }catch(Exception e){
            
        }
    }
    
    private void buscarLibro(){
        try{
            String stikerLibro = textoStikerLibro.getText().trim().toUpperCase();
            GestionarLibroServicio gestionarLibroServicio = new GestionarLibroServicio();
            libro = gestionarLibroServicio.buscarPorSticker(stikerLibro);
            textoNombre.setText(libro.getNombre());
            textoNivel.setText(libro.getNivel().getNombre());
            textoEspecialidad.setText(libro.getEspecialidad().getNombre());
            checkActivo.setSelected(libro.isActivo());
        }catch(Exception e){
            
        }        
    }
    
    private void limpiar(){
        textoNombre.setText("");
        textoNivel.setText("");
        textoEspecialidad.setText("");
        checkActivo.setSelected(false);
    }
    
    private boolean verificarCamposVacios(){
        boolean verificar = true;
        if(textoStikerLibro.getText().trim().isEmpty()){
            Mensaje.Mostrar_MENSAJE_LLENARCAMPOSOBLIGATORIOS(this);
           textoStikerLibro.requestFocus();
           verificar = false;
        }else if(textoNombre.getText().trim().isEmpty()){
           Mensaje.Mostrar_MENSAJE_LLENARCAMPOSOBLIGATORIOS(this);
           textoNombre.requestFocus();
           verificar = false;
        }else if(textoCantidad.getText().trim().isEmpty()){
            Mensaje.Mostrar_MENSAJE_LLENARCAMPOSOBLIGATORIOS(this);
            textoCantidad.requestFocus();
            verificar = false;
        }else if(comboTipo.getSelectedIndex() == -1){
            Mensaje.Mostrar_MENSAJE_LLENARCAMPOBUSCAR(this);
            comboTipo.requestFocus();
            comboTipo.setPopupVisible(true);
            verificar = false;
        }else if(comboPiso.getSelectedIndex() == -1){
            Mensaje.Mostrar_MENSAJE_LLENARCAMPOBUSCAR(this);
            comboPiso.requestFocus();
            comboPiso.setPopupVisible(true);
            verificar = false;
        }else if(comboArmario.getSelectedIndex() == -1){
            Mensaje.Mostrar_MENSAJE_LLENARCAMPOBUSCAR(this);
            comboArmario.requestFocus();
            comboArmario.setPopupVisible(true);
            verificar = false;
        }else if(comboFila.getSelectedIndex() == -1){
            Mensaje.Mostrar_MENSAJE_LLENARCAMPOBUSCAR(this);
            comboFila.requestFocus();
            comboFila.setPopupVisible(true);
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
        textoStikerLibro = new javax.swing.JTextField();
        botonBuscar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        textoNombre = new javax.swing.JTextField();
        textoNivel = new javax.swing.JTextField();
        textoEspecialidad = new javax.swing.JTextField();
        checkActivo = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        textoCantidad = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        comboPiso = new javax.swing.JComboBox();
        comboArmario = new javax.swing.JComboBox();
        comboFila = new javax.swing.JComboBox();
        comboTipo = new javax.swing.JComboBox();
        botonGuardar = new javax.swing.JButton();
        botonSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registrar Ejemplar");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Sticker Libro:");

        textoStikerLibro.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        botonBuscar.setBackground(new java.awt.Color(255, 255, 255));
        botonBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/appbiblioteca/c1_presentacion/iconos/buscarx20.png"))); // NOI18N
        botonBuscar.setText("Buscar");
        botonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalle del Libro"));

        jLabel2.setText("Nombre:");

        jLabel3.setText("Nivel:");

        jLabel4.setText("Especialidad:");

        jLabel5.setText("Activo:");

        textoNombre.setEnabled(false);

        textoNivel.setEnabled(false);

        textoEspecialidad.setEnabled(false);

        checkActivo.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(textoNivel, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textoEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(textoNombre)
                    .addComponent(checkActivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(textoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(textoNivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textoEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(checkActivo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalle del Ejemplar"));

        jLabel6.setText("Cantidad:");

        jLabel7.setText("Tipo:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Ubicaciòn");

        jLabel9.setText("Piso:");

        jLabel10.setText("Armario:");

        jLabel11.setText("Fila:");

        comboTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Original ", "Copia" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(comboArmario, 0, 254, Short.MAX_VALUE)
                            .addComponent(comboFila, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboPiso, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textoCantidad)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addGap(12, 12, 12)
                        .addComponent(comboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(textoCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(comboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(comboPiso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(comboArmario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(comboFila, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textoStikerLibro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonBuscar))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(textoStikerLibro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(botonBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_botonSalirActionPerformed

    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed
        // TODO add your handling code here:
        limpiar();
        buscarLibro();
    }//GEN-LAST:event_botonBuscarActionPerformed

    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarActionPerformed
        // TODO add your handling code here:
        if(verificarCamposVacios()){
            ejemplar.setCantidad(Integer.parseInt(textoCantidad.getText().trim()));
            UbicacionPiso ubicacionPiso;
            ubicacionPiso = ubicacionPisos.get(comboPiso.getSelectedIndex());
            ejemplar.setUbicacionPiso(ubicacionPiso);
            UbicacionArmario ubicacionArmario;
            ubicacionArmario = ubicacionArmarios.get(comboArmario.getSelectedIndex());
            ejemplar.setUbicacionArmario(ubicacionArmario);
            UbicacionFila ubicacionFila;
            ubicacionFila = ubicacionFilas.get(comboFila.getSelectedIndex());
            ejemplar.setUbicacionFila(ubicacionFila);
            GestionarEjemplarServicio gestionarEjemplarServicio = new GestionarEjemplarServicio();
            ejemplar.setLibro(libro);
            try{
                if(ejemplar.getCodigo() == 0){
                    gestionarEjemplarServicio.crear(ejemplar);
                    Mensaje.Mostrar_MENSAJE_GUARDADOEXITOSO(this);
                    this.dispose();
                }else{
                    gestionarEjemplarServicio.modificar(ejemplar);
                    Mensaje.Mostrar_MENSAJE_MODIFICADOEXITOSO(this);
                    this.dispose();
                }
            }catch(Exception e){
                Mensaje.mostrarErrorExcepcion(this, e.getMessage());
            }
        }
        
        /*
        
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
        
        */
    }//GEN-LAST:event_botonGuardarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonBuscar;
    private javax.swing.JButton botonGuardar;
    private javax.swing.JButton botonSalir;
    private javax.swing.JCheckBox checkActivo;
    private javax.swing.JComboBox comboArmario;
    private javax.swing.JComboBox comboFila;
    private javax.swing.JComboBox comboPiso;
    private javax.swing.JComboBox comboTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField textoCantidad;
    private javax.swing.JTextField textoEspecialidad;
    private javax.swing.JTextField textoNivel;
    private javax.swing.JTextField textoNombre;
    private javax.swing.JTextField textoStikerLibro;
    // End of variables declaration//GEN-END:variables
}
