/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appbiblioteca.c1_presentacion.form;

import appbiblioteca.c1_presentacion.util.Mensaje;
import appbiblioteca.c2_aplicacion.servicio.GestionarNivelServicio;
import appbiblioteca.c3_dominio.entidad.Especialidad;
import appbiblioteca.c3_dominio.entidad.LineaEspecialidad;
import appbiblioteca.c3_dominio.entidad.Nivel;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.table.TableColumn;
import mastersoft.modelo.ModeloTabla;
import mastersoft.tabladatos.Columna;
import mastersoft.tabladatos.Fila;
import mastersoft.tabladatos.Tabla;

/**
 *
 * @author CarlosAlfredo
 */
public class FormRegistrarNivel extends javax.swing.JDialog {
    Nivel nivel;
    LineaEspecialidad lineaEspecialidad;
    List<LineaEspecialidad> ListalineaEspecialidades;
    /**
     * Creates new form FormRegistrarNivel
     * @param parent
     */
    public FormRegistrarNivel(JDialog parent) {
        super(parent, true);
        initComponents();
        crearTablaEspecialidad();
        crearTablaListaEspecialidad();
        this.nivel = new Nivel();
        
    }
    
    public  FormRegistrarNivel(JDialog parent, Nivel nivel){
        super(parent, true);
        initComponents();
        crearTablaEspecialidad();
        crearTablaListaEspecialidad();
//        obtenerObjetoDeGestionar(lineaEspecialidades);
    }
    
//    private void obtenerObjetoDeGestionar(List<LineaEspecialidad> lineaEspecialidades){
//        ModeloTabla modeloTablaEspecialidad = (ModeloTabla)tablaEspecialidad.getModel();
//        modeloTablaEspecialidad.eliminarTotalFilas();
//        ModeloTabla modeloTablaListaEspecialidad = (ModeloTabla)tablaListaEspecialidad.getModel();
//        modeloTablaListaEspecialidad.eliminarTotalFilas();
//        this.ListalineaEspecialidades= lineaEspecialidades;
//        try {
//            if(ListalineaEspecialidades!=null && ListalineaEspecialidades.size()>0){
//                for (LineaEspecialidad lineaEspecialidad : lineaEspecialidades){
//                    textoNombre.setText(lineaEspecialidad.getNivel().getNombre());
//                    textoDescripcion.setText(lineaEspecialidad.getNivel().getDescripcion());
//                    Fila fila = new Fila();
//                    fila.agregarValorCelda(lineaEspecialidad.getEspecialidad().getCodigo());
//                    fila.agregarValorCelda(lineaEspecialidad.getEspecialidad().getNombre());
//                    fila.agregarValorCelda(lineaEspecialidad.getEspecialidad().getDescripcion());
//                    modeloTablaListaEspecialidad.agregarFila(fila);
//           }
//         }
//        } catch (Exception e) {
//        }
//    }
    
    
    private boolean verificarCamposLlenos(){
        boolean verificar = false;
        if(!textoNombre.getText().trim().isEmpty())
           verificar = true;
        else if(!textoDescripcion.getText().trim().isEmpty())
            verificar = true;
        return verificar;     
    }
    
    private boolean verificarCamposVacios(){
        boolean verificar = true;
        if(textoNombre.getText().trim().isEmpty()){
           Mensaje.Mostrar_MENSAJE_LLENARCAMPOSOBLIGATORIOS(this);
           textoNombre.requestFocus();
           verificar = false;
        }else if(textoDescripcion.getText().trim().isEmpty()){
            Mensaje.Mostrar_MENSAJE_LLENARCAMPOSOBLIGATORIOS(this);
            textoDescripcion.requestFocus();
            verificar = false;
        }
        return verificar;
    }
    
    private void crearTablaEspecialidad(){
        Tabla tabla = new Tabla();
        tabla.agregarColumna(new Columna("CODIGO", "java.lang.Integer"));
        tabla.agregarColumna(new Columna("NOMBRE", "java.lang.String"));
        tabla.agregarColumna(new Columna("DESCRIPCION", "java.lang.String"));
        ModeloTabla modeloTablaEspecialidad = new ModeloTabla(tabla);
        tablaEspecialidad.setModel(modeloTablaEspecialidad); 
        TableColumn columna0,columna1,columna2;
        columna0 = tablaEspecialidad.getColumnModel().getColumn(0);
        tablaEspecialidad.removeColumn(columna0);      
        columna1 = tablaEspecialidad.getColumnModel().getColumn(0);
        columna1.setPreferredWidth(350);
        columna1.setMaxWidth(350);
        columna1.setMinWidth(350);
        columna2 = tablaListaEspecialidad.getColumnModel().getColumn(0);
        columna2.setPreferredWidth(350);
        columna2.setMaxWidth(350);
        columna2.setMinWidth(350);
    }
    private void crearTablaListaEspecialidad(){
        Tabla tabla = new Tabla();
        tabla.agregarColumna(new Columna("Codigo", "java.lang.Integer"));
        tabla.agregarColumna(new Columna("NOMBRE", "java.lang.String"));
        ModeloTabla modeloTablaListaEspecialidad = new ModeloTabla(tabla);
        tablaListaEspecialidad.setModel(modeloTablaListaEspecialidad);  
        TableColumn columna0,columna1,columna2;
        columna0 = tablaListaEspecialidad.getColumnModel().getColumn(0);
        tablaListaEspecialidad.removeColumn(columna0);     
        columna1 = tablaListaEspecialidad.getColumnModel().getColumn(0);
        columna1.setPreferredWidth(350);
        columna1.setMaxWidth(350);
        columna1.setMinWidth(350);  
        columna2 = tablaListaEspecialidad.getColumnModel().getColumn(0);
        columna2.setPreferredWidth(350);
        columna2.setMaxWidth(350);
        columna2.setMinWidth(350);
    }
    private void buscarEspecialidad(){
        String nombre = textoBuscar.getText().trim().toUpperCase();
        ModeloTabla modeloTablaUbicacionFila = (ModeloTabla) tablaEspecialidad.getModel();
        modeloTablaUbicacionFila.eliminarTotalFilas();
        try{
            GestionarNivelServicio gestionarNivelServicio = new GestionarNivelServicio();
            List<Especialidad> listaEspecialidad = gestionarNivelServicio.buscarEspecialidad(nombre);
            if(listaEspecialidad!=null && listaEspecialidad.size() > 0){
                for (Especialidad especialidad : listaEspecialidad) {
                    Fila fila = new Fila();
                    fila.agregarValorCelda(especialidad.getCodigo());
                    fila.agregarValorCelda(especialidad.getNombre());
                    fila.agregarValorCelda(especialidad.getDescripcion());
                    modeloTablaUbicacionFila.agregarFila(fila);
                }
                modeloTablaUbicacionFila.refrescarDatos();                
            }else{
                Mensaje.Mostrar_MENSAJE_NOSEENCONTRONINGUNRESULTADO(this);
            }
        }catch(Exception e){
            Mensaje.mostrarErrorExcepcion(this, e.getMessage());
        }
    }
    
    private Especialidad seleccionarEspecialidad(){
        int codigo;
        Especialidad especialidad = null;
        int fila = tablaEspecialidad.getSelectedRow();
        GestionarNivelServicio gestionarNivelServicio = new GestionarNivelServicio();
        if(fila >= 0 ){
            ModeloTabla modeloTabla = (ModeloTabla)tablaEspecialidad.getModel();
            codigo = (Integer)modeloTabla.getValueAt(fila, 0);           
            try{
                  especialidad=gestionarNivelServicio.buscarEspecialidad(codigo);
            }
            catch(Exception e){
                Mensaje.mostrarErrorExcepcion(this,e.getMessage());
            }
        }
        else{
            Mensaje.Mostrar_MENSAJE_FILANOSELECCIONADO(this);
        }
        return especialidad;
    }
    
    private void agregarEspecialidadNivel(){
        ModeloTabla modeloTablaListaEspecialidad = (ModeloTabla)tablaListaEspecialidad.getModel();
        lineaEspecialidad = new LineaEspecialidad();
        try{            
            lineaEspecialidad.setEspecialidad(seleccionarEspecialidad());
            nivel.agregarEspecialidad(lineaEspecialidad);
            Fila fila = new Fila();
            fila.agregarValorCelda(lineaEspecialidad.getEspecialidad().getCodigo());
            fila.agregarValorCelda(lineaEspecialidad.getEspecialidad().getNombre());
            fila.agregarValorCelda(lineaEspecialidad.getEspecialidad().getDescripcion());
            modeloTablaListaEspecialidad.agregarFila(fila);
        }catch(Exception ex){
            Mensaje.mostrarErrorExcepcion(this, ex.getMessage());            
        }
        
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
        jScrollPane1 = new javax.swing.JScrollPane();
        textoDescripcion = new javax.swing.JTextArea();
        botonGuardar = new javax.swing.JButton();
        botonSalir = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaEspecialidad = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        textoBuscar = new javax.swing.JTextField();
        botonBuscar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaListaEspecialidad = new javax.swing.JTable();
        botonAgregar = new javax.swing.JButton();
        botonEliminar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registar Nivel");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Nombre:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Descripción:");

        textoNombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        textoDescripcion.setColumns(20);
        textoDescripcion.setRows(5);
        jScrollPane1.setViewportView(textoDescripcion);

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

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Especialidad", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

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
        jScrollPane2.setViewportView(tablaEspecialidad);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Nombre:");

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

        tablaListaEspecialidad.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(tablaListaEspecialidad);

        botonAgregar.setBackground(new java.awt.Color(255, 255, 255));
        botonAgregar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        botonAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/appbiblioteca/c1_presentacion/iconos/agregarx20.png"))); // NOI18N
        botonAgregar.setText("Agregar");
        botonAgregar.setOpaque(false);
        botonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarActionPerformed(evt);
            }
        });

        botonEliminar.setBackground(new java.awt.Color(255, 255, 255));
        botonEliminar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        botonEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/appbiblioteca/c1_presentacion/iconos/eliminarlistax20.png"))); // NOI18N
        botonEliminar.setText("Eliminar");
        botonEliminar.setOpaque(false);
        botonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Lista de Seleccionados");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonBuscar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(botonAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(botonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(80, 80, 80))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(textoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(botonBuscar))
                    .addComponent(jLabel4))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(botonAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(11, 11, 11))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(textoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(312, 312, 312)
                        .addComponent(botonGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(textoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonGuardar))
                .addGap(11, 11, 11))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarActionPerformed
        // TODO add your handling code here:
        if (verificarCamposVacios()) {                       
            GestionarNivelServicio gestionarNivelServicio = new GestionarNivelServicio();
            try{
                nivel.setNombre(textoNombre.getText().trim().toUpperCase());
                nivel.setDescripcion(textoDescripcion.getText().trim().toUpperCase()); 
                if(nivel.getCodigo()==0){
                    gestionarNivelServicio.crear(nivel);
                    Mensaje.Mostrar_MENSAJE_GUARDADOEXITOSO(this);
                    this.dispose();
                }else{
                    gestionarNivelServicio.modificar(nivel);
                    Mensaje.Mostrar_MENSAJE_MODIFICADOEXITOSO(this);
                    this.dispose();
                }
            }catch (Exception e){
                Mensaje.mostrarErrorExcepcion(this, e.getMessage());
            }
        }
    }//GEN-LAST:event_botonGuardarActionPerformed

    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed
        // TODO add your handling code here:
        buscarEspecialidad();
    }//GEN-LAST:event_botonBuscarActionPerformed

    private void botonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarActionPerformed
        // TODO add your handling code here:
        agregarEspecialidadNivel();
    }//GEN-LAST:event_botonAgregarActionPerformed

    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirActionPerformed
        // TODO add your handling code here:
        if(verificarCamposLlenos()){
            if (Mensaje.Mostrar_MENSAJE_SALIRSINGUARDAR(this))
                this.dispose();
        }else
            this.dispose();
    }//GEN-LAST:event_botonSalirActionPerformed

    private void botonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarActionPerformed
        // TODO add your handling code here:
        int fila = tablaListaEspecialidad.getSelectedRow();
        if(fila!=-1){
            if(!Mensaje.Mostrar_MENSAJE_PREGUNTADEELIMINACION(this))
                return;            
            ModeloTabla modeloTabla = (ModeloTabla)tablaListaEspecialidad.getModel();
            int especialidadid= (Integer)modeloTabla.getValueAt(fila, 0);
            modeloTabla.eliminarFila(fila);
            nivel.quitarLineaEspecialidad(especialidadid);
        }
        else
           Mensaje.Mostrar_MENSAJE_FILANOSELECCIONADO(this);        
    }//GEN-LAST:event_botonEliminarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAgregar;
    private javax.swing.JButton botonBuscar;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JButton botonGuardar;
    private javax.swing.JButton botonSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tablaEspecialidad;
    private javax.swing.JTable tablaListaEspecialidad;
    private javax.swing.JTextField textoBuscar;
    private javax.swing.JTextArea textoDescripcion;
    private javax.swing.JTextField textoNombre;
    // End of variables declaration//GEN-END:variables
}
