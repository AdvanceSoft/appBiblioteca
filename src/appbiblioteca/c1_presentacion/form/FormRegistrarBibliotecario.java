/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appbiblioteca.c1_presentacion.form;

import appbiblioteca.c1_presentacion.util.Mensaje;
import appbiblioteca.c2_aplicacion.servicio.GestionarBibliotecarioServicio;
import appbiblioteca.c3_dominio.entidad.Bibliotecario;
import java.sql.Date;
import javax.swing.JDialog;

/**
 *
 * @author
 * <AdvanceSoft - Medrano Parado Sandra Zoraida - advancesoft.trujillo@gmail.com>
 * @version 1.0
 */
public class FormRegistrarBibliotecario extends javax.swing.JDialog {

    Bibliotecario bibliotecario;
    public FormRegistrarBibliotecario(JDialog parent) {
        super(parent, true);
        initComponents();
        this.bibliotecario = new Bibliotecario();
    }
    public FormRegistrarBibliotecario(JDialog parent,Bibliotecario bibliotecario) {
        super(parent, true);
        initComponents();        
        obtenerObjetoDeGestionar(bibliotecario);
    }

    private void obtenerObjetoDeGestionar(Bibliotecario bibliotecario){
        this.bibliotecario = bibliotecario;
        textoNombre.setText(bibliotecario.getNombre());
        textoApellido.setText(bibliotecario.getApellido());
        textoDNI.setText(bibliotecario.getDni());
        jDateFechaNacimiento.setDate(bibliotecario.getFechanacimiento());
        textoTelefono.setText(bibliotecario.getTelefono());
        textoEmail.setText(bibliotecario.getCorreo());
        if(bibliotecario.getGenero().equals("MASCULINO"))
        jRadioMasculino.setSelected(true);
        else
            jRadioFemenino.setSelected(true);
    }
    
    
    public boolean verificarCamposLlenos(){
        boolean verificar = false;
        if(!textoNombre.getText().trim().isEmpty())
           verificar = true;
        else if(!textoApellido.getText().trim().isEmpty())
            verificar = true;
        else if(!textoDNI.getText().trim().isEmpty())
            verificar = true;
        else if(!textoTelefono.getText().trim().isEmpty())
            verificar = true;
        else if(!textoEmail.getText().trim().isEmpty())
            verificar = true;
        else if(null!= jDateFechaNacimiento.getDate())
            verificar = true;
       /* else if(jRadioFemenino.isSelected() || jRadioMasculino.isSelected())
            verificar = true;
        else if(comboCompania.getSelectedIndex()>0)
            verificar = true;*/
        return verificar;     
    }
    
    public boolean verificarCamposVacios(){
        boolean verificar = true;
        if(textoNombre.getText().trim().isEmpty()){
           Mensaje.Mostrar_MENSAJE_LLENARCAMPOSOBLIGATORIOS(this);
           textoNombre.requestFocus();
           verificar = false;
        }else if(textoApellido.getText().trim().isEmpty()){
            Mensaje.Mostrar_MENSAJE_LLENARCAMPOSOBLIGATORIOS(this);
            textoApellido.requestFocus();
            verificar = false;
        }else if(textoDNI.getText().trim().isEmpty()){
            Mensaje.Mostrar_MENSAJE_LLENARCAMPOSOBLIGATORIOS(this);
            textoDNI.requestFocus();
            verificar = false;
        }else if(textoTelefono.getText().trim().isEmpty()){
            Mensaje.Mostrar_MENSAJE_LLENARCAMPOSOBLIGATORIOS(this);
            textoTelefono.requestFocus();
            verificar = false;
        }else if(textoEmail.getText().trim().isEmpty()){
            Mensaje.Mostrar_MENSAJE_LLENARCAMPOSOBLIGATORIOS(this);
            textoEmail.requestFocus();
            verificar = false;
        }else if(jDateFechaNacimiento.getDate()==null){
            Mensaje.Mostrar_MENSAJE_LLENARCAMPOSOBLIGATORIOS(this);
            jDateFechaNacimiento.requestFocus();
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

        grupobotonGenero = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        textoNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        textoApellido = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        textoDNI = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jRadioFemenino = new javax.swing.JRadioButton();
        jRadioMasculino = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        jDateFechaNacimiento = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        textoTelefono = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        textoEmail = new javax.swing.JTextField();
        botonGuardar = new javax.swing.JButton();
        botonSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registrar Bibliotecario");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Nombre:");

        textoNombre.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Apellidos:");

        textoApellido.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("DNI:");

        textoDNI.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Género:");

        grupobotonGenero.add(jRadioFemenino);
        jRadioFemenino.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jRadioFemenino.setText("Femenino");

        grupobotonGenero.add(jRadioMasculino);
        jRadioMasculino.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jRadioMasculino.setText("Masculino");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Fecha de Nacimiento:");

        jDateFechaNacimiento.setBackground(new java.awt.Color(255, 255, 255));
        jDateFechaNacimiento.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Teléfono:");

        textoTelefono.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Email:");

        textoEmail.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(botonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel6)
                        .addComponent(jLabel5)
                        .addComponent(jLabel4)
                        .addComponent(jLabel3)
                        .addComponent(jLabel2)
                        .addComponent(jLabel1)
                        .addComponent(jLabel8)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jRadioFemenino)
                                .addGap(18, 18, 18)
                                .addComponent(jRadioMasculino)
                                .addContainerGap(39, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textoEmail)
                                    .addComponent(textoDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textoApellido)
                                    .addComponent(textoNombre)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jDateFechaNacimiento, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                                        .addComponent(textoTelefono, javax.swing.GroupLayout.Alignment.LEADING)))
                                .addGap(10, 10, 10))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(botonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
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
                    .addComponent(textoApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(textoDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jRadioFemenino)
                    .addComponent(jRadioMasculino))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jDateFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(textoTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(textoEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonGuardar)
                    .addComponent(botonSalir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarActionPerformed
        // TODO add your handling code here:
        if (verificarCamposVacios()) {
            bibliotecario.setNombre(textoNombre.getText().trim().toUpperCase());
            bibliotecario.setApellido(textoApellido.getText().trim().toUpperCase());
            bibliotecario.setDni(textoDNI.getText().trim().toUpperCase());
            if(jRadioFemenino.isSelected())
                bibliotecario.setGenero("FEMENINO");
            else
                bibliotecario.setGenero("MASCULINO");
            bibliotecario.setFechanacimiento(Date.valueOf(String.format("%1$tY-%1$tm-%1$te",jDateFechaNacimiento.getDate())));            
            bibliotecario.setTelefono(textoTelefono.getText().trim().toUpperCase());
            bibliotecario.setCorreo(textoEmail.getText().trim().toUpperCase());
            GestionarBibliotecarioServicio gestionarBibliotecarioServicio = new GestionarBibliotecarioServicio();
            try{
                if(bibliotecario.getCodigo()==0){
                    gestionarBibliotecarioServicio.crear(bibliotecario);
                    Mensaje.Mostrar_MENSAJE_GUARDADOEXITOSO(this);
                    this.dispose();
                }else{
                    gestionarBibliotecarioServicio.modificar(bibliotecario);
                    Mensaje.Mostrar_MENSAJE_MODIFICADOEXITOSO(this);
                    this.dispose();
                }
            }catch(Exception e){
                Mensaje.mostrarErrorExcepcion(this, e.getMessage());
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonGuardar;
    private javax.swing.JButton botonSalir;
    private javax.swing.ButtonGroup grupobotonGenero;
    private com.toedter.calendar.JDateChooser jDateFechaNacimiento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JRadioButton jRadioFemenino;
    private javax.swing.JRadioButton jRadioMasculino;
    private javax.swing.JTextField textoApellido;
    private javax.swing.JTextField textoDNI;
    private javax.swing.JTextField textoEmail;
    private javax.swing.JTextField textoNombre;
    private javax.swing.JTextField textoTelefono;
    // End of variables declaration//GEN-END:variables
}
