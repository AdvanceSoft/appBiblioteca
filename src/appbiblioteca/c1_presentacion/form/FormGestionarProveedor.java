/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appbiblioteca.c1_presentacion.form;

import appbiblioteca.c2_aplicacion.servicio.GestionarProveedorServicio;
import appbiblioteca.c3_dominio.entidad.Proveedor;
import appbiblioteca.c1_presentacion.util.Mensaje;
import java.util.List;
import javax.swing.table.TableColumn;
import mastersoft.modelo.ModeloTabla;
import mastersoft.tabladatos.Columna;
import mastersoft.tabladatos.Fila;
import mastersoft.tabladatos.Tabla;

/**
 *
 * @author
 * <AdvanceSoft - Osorio Perez Carlos Alfredo - advancesoft.trujillo@gmail.com>
 */
public class FormGestionarProveedor extends javax.swing.JDialog {

    /**
     * Creates new form FormGestionarProveedor
     * @param parent
     */
    public FormGestionarProveedor(java.awt.Frame parent) {
        super(parent, true);
        initComponents();
        crearTabla();
    }
    
    private void crearTabla(){
        Tabla tabla = new Tabla();
        tabla.agregarColumna(new Columna("CODIGO", "java.lang.Integer"));
        tabla.agregarColumna(new Columna("NOMBRE", "java.lang.String"));
        tabla.agregarColumna(new Columna("DIRECCION", "java.lang.String"));
        ModeloTabla modeloTablaProveedor = new ModeloTabla(tabla);
        tablaProveedor.setModel(modeloTablaProveedor);
        TableColumn columna0,columna1,columna2;
        //CODIGO
        columna0 = tablaProveedor.getColumnModel().getColumn(0);
        tablaProveedor.removeColumn(columna0);
        //NOMBRE
        columna1 = tablaProveedor.getColumnModel().getColumn(0);
        columna1.setPreferredWidth(216);
        columna1.setMaxWidth(216);
        columna1.setMinWidth(216);
        //DIRECCION
        columna2 = tablaProveedor.getColumnModel().getColumn(1);
        columna2.setPreferredWidth(216);
        columna2.setMaxWidth(216);
        columna2.setMinWidth(216);        
    }
    
    private void ponerFocoConSeleccionEnBuscar(){
        textoBuscar.selectAll();
        textoBuscar.requestFocus(); 
    }
    
    private void buscarProveedor(){
        ModeloTabla modeloTablaProveedor = (ModeloTabla) tablaProveedor.getModel();
        modeloTablaProveedor.eliminarTotalFilas();
        try{
            GestionarProveedorServicio gestionarProveedorServicio = new GestionarProveedorServicio();        
            List<Proveedor> listaproveedor = gestionarProveedorServicio.buscar(textoBuscar.getText().trim().toUpperCase());
            if(listaproveedor!=null && listaproveedor.size() > 0){
                for (Proveedor proveedor : listaproveedor) {
                    Fila fila = new Fila();
                    fila.agregarValorCelda(proveedor.getCodigo());
                    fila.agregarValorCelda(proveedor.getNombre());
                    fila.agregarValorCelda(proveedor.getDireccion());
                    modeloTablaProveedor.agregarFila(fila);
                }
                modeloTablaProveedor.refrescarDatos();
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

    private Proveedor obtenerObjetoDeLaTabla(){
        Proveedor proveedor = null;
        int numFila = tablaProveedor.getSelectedRow();
        if(numFila >= 0){//verificamos si se selecciono alguna fila de la Tabla            
            GestionarProveedorServicio gestionarProveedorServicio = new GestionarProveedorServicio();
            ModeloTabla modeloTabla = (ModeloTabla) tablaProveedor.getModel();
            int codigo = (int) modeloTabla.getValueAt(numFila, 0);
            try{
                proveedor = gestionarProveedorServicio.buscar(codigo);
            }catch(Exception e){
                Mensaje.mostrarErrorExcepcion(this,e.getMessage());
            }
        }else
            Mensaje.Mostrar_MENSAJE_FILANOSELECCIONADO(this);
        return proveedor;
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
        botonModificar = new javax.swing.JButton();
        botonEliminar = new javax.swing.JButton();
        botonSalir = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        textoBuscar = new javax.swing.JTextField();
        botonBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProveedor = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestionar Proveedor");

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
        barraOpciones.add(botonModificar);

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

        tablaProveedor.setAutoCreateRowSorter(true);
        tablaProveedor.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablaProveedor);

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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(botonBuscar)
                    .addComponent(textoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        buscarProveedor();
        ponerFocoConSeleccionEnBuscar();
    }//GEN-LAST:event_botonBuscarActionPerformed

    private void botonCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCrearActionPerformed
        // TODO add your handling code here:
        FormRegistrarProveedor formRegistrarProveedor = new FormRegistrarProveedor(this);
        formRegistrarProveedor.setVisible(true);
        buscarProveedor();
    }//GEN-LAST:event_botonCrearActionPerformed

    private void botonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonModificarActionPerformed
        // TODO add your handling code here:
        Proveedor proveedor = obtenerObjetoDeLaTabla();
        if(proveedor != null){
            FormRegistrarProveedor formRegistrarProveedor = new FormRegistrarProveedor(this,proveedor);
            formRegistrarProveedor.setVisible(true);
            buscarProveedor();
        }  
    }//GEN-LAST:event_botonModificarActionPerformed

    private void botonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarActionPerformed
        // TODO add your handling code here:
        GestionarProveedorServicio gestionarProveedorServicio = new GestionarProveedorServicio();
        if(obtenerObjetoDeLaTabla() != null){
            if(!Mensaje.Mostrar_MENSAJE_PREGUNTADEELIMINACION(this))
                return;
            try{
                gestionarProveedorServicio.eliminar(obtenerObjetoDeLaTabla());
                Mensaje.Mostrar_MENSAJE_ELIMINACIONEXITOSA(this);
                buscarProveedor();
                ponerFocoConSeleccionEnBuscar();
            }catch(Exception e){
                Mensaje.Mostrar_MENSAJE_ELIMINACIONERRONEA(this);
                buscarProveedor();
                ponerFocoConSeleccionEnBuscar();
            }
        }        
    }//GEN-LAST:event_botonEliminarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToolBar barraOpciones;
    private javax.swing.JButton botonBuscar;
    private javax.swing.JButton botonCrear;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JButton botonModificar;
    private javax.swing.JButton botonSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaProveedor;
    private javax.swing.JTextField textoBuscar;
    // End of variables declaration//GEN-END:variables
}
