/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appbiblioteca.c1_presentacion.form;

import appbiblioteca.c1_presentacion.util.Mensaje;
import appbiblioteca.c2_aplicacion.servicio.GestionarBibliotecarioServicio;
import appbiblioteca.c3_dominio.entidad.Bibliotecario;
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
public class FormGestionarBibliotecario extends javax.swing.JDialog {

    /**
     * Creates new form FormGestionarBibliotecario
     * @param parent
     */
    public FormGestionarBibliotecario(java.awt.Frame parent) {
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
        tabla.agregarColumna(new Columna("TELEFONO", "java.lang.String"));
        tabla.agregarColumna(new Columna("CORREO", "java.lang.String"));
        ModeloTabla modeloTablaBibliotecario = new ModeloTabla(tabla);
        tablaBibliotecario.setModel(modeloTablaBibliotecario);
        TableColumn columna0,columna1,columna2,columna3,columna4,columna5,columna6,columna7;
        //CODIGO
        columna0 = tablaBibliotecario.getColumnModel().getColumn(0);
        tablaBibliotecario.removeColumn(columna0);
        //NOMBRE
        columna1 = tablaBibliotecario.getColumnModel().getColumn(0);
        columna1.setPreferredWidth(216);
        columna1.setMaxWidth(216);
        columna1.setMinWidth(216);
        //APELLIDOS
        columna2 = tablaBibliotecario.getColumnModel().getColumn(1);
        columna2.setPreferredWidth(216);
        columna2.setMaxWidth(216);
        columna2.setMinWidth(216);
        //DNI
        columna3 = tablaBibliotecario.getColumnModel().getColumn(2);
        columna3.setPreferredWidth(70);
        columna3.setMaxWidth(70);
        columna3.setMinWidth(70);
        //GENERO
        columna4 = tablaBibliotecario.getColumnModel().getColumn(3);
        columna4.setPreferredWidth(100);
        columna4.setMaxWidth(100);
        columna4.setMinWidth(100);
        //FECHA DE NACIMIENTO
        columna5 = tablaBibliotecario.getColumnModel().getColumn(4);
        columna5.setPreferredWidth(150);
        columna5.setMaxWidth(150);
        columna5.setMinWidth(150);
        //TELEFONO
        columna6 = tablaBibliotecario.getColumnModel().getColumn(5);
        columna6.setPreferredWidth(180);
        columna6.setMaxWidth(180);
        columna6.setMinWidth(180);
        //CORREO
        columna7 = tablaBibliotecario.getColumnModel().getColumn(6);
        columna7.setPreferredWidth(200);
        columna7.setMaxWidth(200);
        columna7.setMinWidth(200);
    }
    
    private void ponerFocoConSeleccionEnBuscar(){
        textoBuscar.selectAll();
        textoBuscar.requestFocus();
    }
    
    private void buscarBibliotecario(){
        ModeloTabla modeloTablaBibliotecario = (ModeloTabla) tablaBibliotecario.getModel();
        modeloTablaBibliotecario.eliminarTotalFilas();
        try{
            GestionarBibliotecarioServicio gestionarBibliotecarioServicio = new GestionarBibliotecarioServicio();        
            List<Bibliotecario> listabibliotecario = gestionarBibliotecarioServicio.buscar(textoBuscar.getText().trim().toUpperCase());
            if(listabibliotecario!=null && listabibliotecario.size() > 0){
                for (Bibliotecario bibliotecario : listabibliotecario) {
                    Fila fila = new Fila();
                    fila.agregarValorCelda(bibliotecario.getCodigo());
                    fila.agregarValorCelda(bibliotecario.getNombre());
                    fila.agregarValorCelda(bibliotecario.getApellido());
                    fila.agregarValorCelda(bibliotecario.getDni());
                    fila.agregarValorCelda(bibliotecario.getGenero());
                    fila.agregarValorCelda(bibliotecario.getFechanacimiento());
                    fila.agregarValorCelda(bibliotecario.getTelefono());
                    fila.agregarValorCelda(bibliotecario.getCorreo());
                    modeloTablaBibliotecario.agregarFila(fila);
                }
                modeloTablaBibliotecario.refrescarDatos();
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

    private Bibliotecario obtenerObjetoDeLaTabla(){
        Bibliotecario bibliotecario = null;
        int numFila = tablaBibliotecario.getSelectedRow();
        if(numFila >= 0){//verificamos si se selecciono alguna fila de la Tabla            
            GestionarBibliotecarioServicio gestionarBibliotecarioServicio = new GestionarBibliotecarioServicio();
            ModeloTabla modeloTabla = (ModeloTabla) tablaBibliotecario.getModel();
            int codigo = (int) modeloTabla.getValueAt(numFila, 0);
            try{
                bibliotecario = gestionarBibliotecarioServicio.buscar(codigo);
            }catch(Exception e){
                Mensaje.mostrarErrorExcepcion(this,e.getMessage());
            }
        }else
            Mensaje.Mostrar_MENSAJE_FILANOSELECCIONADO(this);
        return bibliotecario;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        textoBuscar = new javax.swing.JTextField();
        botonbuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaBibliotecario = new javax.swing.JTable();
        jToolBar1 = new javax.swing.JToolBar();
        botonCrear = new javax.swing.JButton();
        botomModificar = new javax.swing.JButton();
        botonEliminar = new javax.swing.JButton();
        botonSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestionar Bibliotecario");

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

        tablaBibliotecario.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablaBibliotecario);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

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

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botonbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonbuscarActionPerformed
        // TODO add your handling code here:
        buscarBibliotecario();
        ponerFocoConSeleccionEnBuscar();
    }//GEN-LAST:event_botonbuscarActionPerformed

    private void botonCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCrearActionPerformed
        // TODO add your handling code here:
        FormRegistrarBibliotecario formRegistrarBibliotecario = new FormRegistrarBibliotecario(this);
        formRegistrarBibliotecario.setVisible(true);
        buscarBibliotecario();
    }//GEN-LAST:event_botonCrearActionPerformed

    private void botomModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botomModificarActionPerformed
        // TODO add your handling code here:
        Bibliotecario bibliotecario = obtenerObjetoDeLaTabla();
        if(bibliotecario != null){
            FormRegistrarBibliotecario formRegistrarBibliotecario = new FormRegistrarBibliotecario(this,bibliotecario);
            formRegistrarBibliotecario.setVisible(true);
            buscarBibliotecario();
        }
    }//GEN-LAST:event_botomModificarActionPerformed

    private void botonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarActionPerformed
        // TODO add your handling code here:
        GestionarBibliotecarioServicio gestionarBibliotecarioServicio = new GestionarBibliotecarioServicio();
        if(obtenerObjetoDeLaTabla() != null){
            if(!Mensaje.Mostrar_MENSAJE_PREGUNTADEELIMINACION(this))
            return;
            try{
                gestionarBibliotecarioServicio.eliminar(obtenerObjetoDeLaTabla());
                Mensaje.Mostrar_MENSAJE_ELIMINACIONEXITOSA(this);
                buscarBibliotecario();
                ponerFocoConSeleccionEnBuscar();
            }catch(Exception e){
                Mensaje.Mostrar_MENSAJE_ELIMINACIONERRONEA(this);
                buscarBibliotecario();
                ponerFocoConSeleccionEnBuscar();
            }
        }
    }//GEN-LAST:event_botonEliminarActionPerformed

    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_botonSalirActionPerformed

  
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
    private javax.swing.JTable tablaBibliotecario;
    private javax.swing.JTextField textoBuscar;
    // End of variables declaration//GEN-END:variables
}
