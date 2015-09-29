/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appbiblioteca.c1_presentacion.form;

import appbiblioteca.c1_presentacion.util.Mensaje;
import appbiblioteca.c2_aplicacion.servicio.GestionarEspecialidadServicio;
import appbiblioteca.c2_aplicacion.servicio.GestionarLibroServicio;
import appbiblioteca.c2_aplicacion.servicio.GestionarNivelServicio;
import appbiblioteca.c3_dominio.entidad.Autor;
import appbiblioteca.c3_dominio.entidad.Especialidad;
import appbiblioteca.c3_dominio.entidad.Libro;
import appbiblioteca.c3_dominio.entidad.LineaAutor;
import appbiblioteca.c3_dominio.entidad.Nivel;
import java.util.ArrayList;
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
public class FormRegistrarLibro extends javax.swing.JDialog {
    private final int ACCION_CREAR = 1;
    private final int ACCION_MODIFICAR = 2;
    private int tipo_accion = 0;
    Libro libro;
    LineaAutor lineaAutor;
    ArrayList<Especialidad> listaEspecialidad;
    List<Nivel> listaNivel;
    /**
     * Creates new form FormRegistrarLibro
     * @param parent
     */
    public FormRegistrarLibro(JDialog parent) {
        super(parent, true);
        initComponents();
        crearTablaAutor();
        crearTablaListaAutor();
        this.libro = new Libro();
        LlenarComboEspecialidad();
        LlenarComboNivel();
    }
    
    public FormRegistrarLibro(JDialog parent,Libro libro) {
        super(parent, true);
        initComponents();   
        LlenarComboEspecialidad();
        LlenarComboNivel();
        crearTablaAutor();
        crearTablaListaAutor();
        tipo_accion = ACCION_MODIFICAR;
        obtenerObjetoDeGestionar(libro);
    }
    
    public void obtenerObjetoDeGestionar(Libro libro){
        
    }
    private boolean verificarCamposLlenos(){
        boolean verificar = false;
        if(!textoSticker.getText().trim().isEmpty())
            verificar = true;
        else if(!textoNombre.getText().trim().isEmpty())
            verificar = true;
        else if(comboListaEspecialidad.getSelectedIndex() != -1)
            verificar = true;
        else if(comboListaNivel.getSelectedIndex() != -1)
            verificar = true;
        else if(checkActivo.isEnabled())
            verificar = true;
        else if(textoDescripcion.getText().trim().isEmpty())
            verificar = true;
        return verificar;
    }
    
    private boolean verificarCamposVacios(){
        boolean verificar = true;
        if(textoSticker.getText().trim().isEmpty()){
            Mensaje.Mostrar_MENSAJE_LLENARCAMPOSOBLIGATORIOS(this);
            textoSticker.requestFocus();
            verificar = false;
        }
        else if(textoNombre.getText().trim().isEmpty()){
            Mensaje.Mostrar_MENSAJE_LLENARCAMPOSOBLIGATORIOS(this);
            textoNombre.requestFocus();
            verificar = false;
        }/*            
        else if(comboEspecialidad.getSelectedIndex() == -1){
            Mensaje.Mostrar_MENSAJE_LLENARCAMPOSOBLIGATORIOS(this);
            //comboEspecialidad.
            verificar = false;
        }
        else if(comboNivel.getSelectedIndex() == -1){
            Mensaje.Mostrar_MENSAJE_LLENARCAMPOSOBLIGATORIOS(this);
            //comboNivel.
            verificar = false;
        }
        else if(!checkActivo.isEnabled()){
            Mensaje.Mostrar_MENSAJE_LLENARCAMPOSOBLIGATORIOS(this);
            checkActivo.re
            verificar = false;
        }*/
        return verificar;
    }
    
    private void crearTablaAutor(){
        Tabla tabla = new Tabla();
        tabla.agregarColumna(new Columna("CODIGO", "java.lang.Integer"));
        tabla.agregarColumna(new Columna("NOMBRE", "java.lang.String"));
        tabla.agregarColumna(new Columna("APELLIDO", "java.lang.String"));
        ModeloTabla modeloTablaAutor = new ModeloTabla(tabla);
        tablaAutor.setModel(modeloTablaAutor); 
        TableColumn columna0,columna1,columna2;
        columna0 = tablaAutor.getColumnModel().getColumn(0);
        tablaAutor.removeColumn(columna0);      
        columna1 = tablaAutor.getColumnModel().getColumn(0);
        columna1.setPreferredWidth(200);
        columna1.setMaxWidth(200);
        columna1.setMinWidth(200);
        columna2 = tablaAutor.getColumnModel().getColumn(0);
        columna2.setPreferredWidth(200);
        columna2.setMaxWidth(200);
        columna2.setMinWidth(200);
    }
    
    private void LlenarComboNivel(){
        try{
            GestionarNivelServicio gestionarNivelServicio = new GestionarNivelServicio();
            listaNivel = gestionarNivelServicio.buscar(null);
            comboListaNivel.removeAllItems();
            for (Nivel nivel : listaNivel) {
                comboListaNivel.addItem(nivel.getNombre());
            }
        }catch(Exception ex){
            
        }
    }
    
    private void LlenarComboEspecialidad(){
        try{
            GestionarEspecialidadServicio gestionarEspecialidadServicio = new GestionarEspecialidadServicio();
            listaEspecialidad = gestionarEspecialidadServicio.buscarPorNombre(null);
            comboListaEspecialidad.removeAllItems();
            for (Especialidad especialidad : listaEspecialidad) {
                comboListaEspecialidad.addItem(especialidad.getNombre());
            }
        }catch(Exception ex){
            
        }
    }
    
    private void crearTablaListaAutor(){
        Tabla tabla = new Tabla();
        tabla.agregarColumna(new Columna("Codigo", "java.lang.Integer"));
        tabla.agregarColumna(new Columna("NOMBRE", "java.lang.String"));
        tabla.agregarColumna(new Columna("APELLIDO", "java.lang.String"));
        ModeloTabla modeloTablaListaAutor = new ModeloTabla(tabla);
        tablaListaAutor.setModel(modeloTablaListaAutor);  
        TableColumn columna0,columna1,columna2;
        columna0 = tablaListaAutor.getColumnModel().getColumn(0);
        tablaListaAutor.removeColumn(columna0);      
        columna1 = tablaListaAutor.getColumnModel().getColumn(0);
        columna1.setPreferredWidth(200);
        columna1.setMaxWidth(200);
        columna1.setMinWidth(200);  
        columna2 = tablaListaAutor.getColumnModel().getColumn(0);
        columna2.setPreferredWidth(200);
        columna2.setMaxWidth(200);
        columna2.setMinWidth(200);
    }
    
    private void buscarAutorLibro(){
        String nombre = textoBuscar.getText().trim().toUpperCase();
        ModeloTabla modeloTablaUbicacionFila = (ModeloTabla) tablaAutor.getModel();
        modeloTablaUbicacionFila.eliminarTotalFilas();
        try{
            GestionarLibroServicio gestionarLibroServicio = new GestionarLibroServicio(); 
            List<Autor> listaAutor = gestionarLibroServicio.buscarAutor(nombre);
            if(listaAutor!=null && listaAutor.size() > 0){
                for (Autor autor : listaAutor) {
                    Fila fila = new Fila();
                    fila.agregarValorCelda(autor.getCodigo());
                    fila.agregarValorCelda(autor.getNombre());
                    fila.agregarValorCelda(autor.getApellido());
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
   
    private Autor seleccionarAutor(){
        int codigo;
        Autor autor = null;
        int fila = tablaAutor.getSelectedRow();
        GestionarLibroServicio gestionarLibroServicio = new GestionarLibroServicio();
        if(fila >= 0 ){
            ModeloTabla modeloTabla = (ModeloTabla)tablaAutor.getModel();
            codigo = (Integer)modeloTabla.getValueAt(fila, 0);           
            try{
                  autor=gestionarLibroServicio.buscarAutor(codigo);
            }
            catch(Exception e){
                Mensaje.mostrarErrorExcepcion(this,e.getMessage());
            }
        }
        else{
            Mensaje.Mostrar_MENSAJE_FILANOSELECCIONADO(this);
        }
        return autor;
    }
    
    private void agregarAutor(){
        ModeloTabla modeloTablaListaAutor = (ModeloTabla)tablaListaAutor.getModel();
        lineaAutor = new LineaAutor();
        try{            
            lineaAutor.setAutor(seleccionarAutor());
            libro.agregarAutor(lineaAutor);
            Fila fila = new Fila();        
            fila.agregarValorCelda(lineaAutor.getAutor().getCodigo());
            fila.agregarValorCelda(lineaAutor.getAutor().getNombre());
            fila.agregarValorCelda(lineaAutor.getAutor().getApellido());
            modeloTablaListaAutor.agregarFila(fila);
        }catch(Exception ex){
            Mensaje.mostrarErrorExcepcion(this, ex.getMessage());            
        }
    }
    
    private void ponerFocoConSeleccionEnBuscar() {
        textoBuscar.selectAll();
        textoBuscar.requestFocus();
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
        textoSticker = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        textoNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        textoBuscar = new javax.swing.JTextField();
        botonBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaAutor = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaListaAutor = new javax.swing.JTable();
        botonAgregar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        botonEliminar = new javax.swing.JButton();
        comboListaEspecialidad = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        textoDescripcion = new javax.swing.JTextArea();
        botonGuardar = new javax.swing.JButton();
        botonSalir = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        checkActivo = new java.awt.Checkbox();
        textoIsbn = new javax.swing.JTextField();
        comboListaNivel = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registrar Libro");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Sticker:");

        textoSticker.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Nombre:");

        textoNombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Nivel:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("ISBN:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Especialidad:");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Autor", 0, 0, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Nombre :");

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

        tablaAutor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaAutorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaAutor);

        jScrollPane2.setViewportView(tablaListaAutor);

        botonAgregar.setBackground(new java.awt.Color(255, 255, 255));
        botonAgregar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        botonAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/appbiblioteca/c1_presentacion/iconos/agregarx20.png"))); // NOI18N
        botonAgregar.setText("Agregar");
        botonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Lista Seleccionados");

        botonEliminar.setBackground(new java.awt.Color(255, 255, 255));
        botonEliminar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        botonEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/appbiblioteca/c1_presentacion/iconos/eliminarlistax20.png"))); // NOI18N
        botonEliminar.setText("Eliminar");
        botonEliminar.setPreferredSize(new java.awt.Dimension(79, 34));
        botonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(botonBuscar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addGap(127, 127, 127))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(botonEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(botonAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(textoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(botonBuscar))
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(botonAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        comboListaEspecialidad.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Descripción :");

        textoDescripcion.setColumns(20);
        textoDescripcion.setRows(5);
        jScrollPane3.setViewportView(textoDescripcion);

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

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Activo:");

        textoIsbn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        comboListaNivel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/appbiblioteca/c1_presentacion/iconos/adquisicionx20.png"))); // NOI18N
        jButton1.setText("Crear");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/appbiblioteca/c1_presentacion/iconos/adquisicionx20.png"))); // NOI18N
        jButton2.setText("Crear");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(botonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(313, 313, 313))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel1)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(10, 10, 10)
                                    .addComponent(jLabel3)))
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(comboListaEspecialidad, 0, 231, Short.MAX_VALUE)
                                    .addComponent(comboListaNivel, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton1)
                                    .addComponent(jButton2)))
                            .addComponent(textoSticker))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textoNombre)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(checkActivo, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(textoIsbn)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 824, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(textoSticker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(textoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(textoIsbn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboListaNivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(comboListaEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9)
                        .addComponent(jButton2))
                    .addComponent(checkActivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarActionPerformed
        // TODO add your handling code here:
        if (verificarCamposLlenos()) {
            libro.setSticker(textoSticker.getText().trim().toUpperCase());
            libro.setNombre(textoNombre.getText().trim().toUpperCase());
            libro.setDescripcion(textoDescripcion.getText().trim().toUpperCase());
            libro.setIsbn(textoIsbn.getText().trim().toUpperCase());
            Especialidad especialidad;
            especialidad = listaEspecialidad.get(comboListaEspecialidad.getSelectedIndex());
            Nivel nivel;
            nivel = listaNivel.get(comboListaNivel.getSelectedIndex());
            libro.setEspecialidad(especialidad);
            libro.setNivel(nivel);
            GestionarLibroServicio gestionarLibroServicio = new GestionarLibroServicio();
            try{
                if(libro.getCodigo()==0){
                    gestionarLibroServicio.crear(libro);
                    Mensaje.Mostrar_MENSAJE_GUARDADOEXITOSO(this);
                    this.dispose();
                }else{
                    gestionarLibroServicio.modificar(libro);
                    Mensaje.Mostrar_MENSAJE_MODIFICADOEXITOSO(this);
                    this.dispose();
                }
            }catch (Exception e){
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

    private void tablaAutorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaAutorMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tablaAutorMouseClicked

    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed
        // TODO add your handling code here:
        buscarAutorLibro();
        ponerFocoConSeleccionEnBuscar();
    }//GEN-LAST:event_botonBuscarActionPerformed

    private void botonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarActionPerformed
        // TODO add your handling code here:
        agregarAutor();
    }//GEN-LAST:event_botonAgregarActionPerformed

    private void botonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarActionPerformed
        // TODO add your handling code here:
        int fila = tablaListaAutor.getSelectedRow();
        if(fila!=-1){
            if(!Mensaje.Mostrar_MENSAJE_PREGUNTADEELIMINACION(this))
                return;            
            ModeloTabla modeloTabla = (ModeloTabla)tablaListaAutor.getModel();
            int autorid= (Integer)modeloTabla.getValueAt(fila, 0);
            modeloTabla.eliminarFila(fila);
            libro.quitarLineaAutor(autorid);
        }
        else
           Mensaje.Mostrar_MENSAJE_FILANOSELECCIONADO(this); 
    }//GEN-LAST:event_botonEliminarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        FormRegistrarNivel formRegistrarNivel = new FormRegistrarNivel(this);
        formRegistrarNivel.setVisible(true);
        LlenarComboNivel();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        FormRegistrarEspecialidad formRegistrarEspecialidad = new FormRegistrarEspecialidad(this);
        formRegistrarEspecialidad.setVisible(true);
        LlenarComboEspecialidad();
    }//GEN-LAST:event_jButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAgregar;
    private javax.swing.JButton botonBuscar;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JButton botonGuardar;
    private javax.swing.JButton botonSalir;
    private java.awt.Checkbox checkActivo;
    private javax.swing.JComboBox comboListaEspecialidad;
    private javax.swing.JComboBox comboListaNivel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tablaAutor;
    private javax.swing.JTable tablaListaAutor;
    private javax.swing.JTextField textoBuscar;
    private javax.swing.JTextArea textoDescripcion;
    private javax.swing.JTextField textoIsbn;
    private javax.swing.JTextField textoNombre;
    private javax.swing.JTextField textoSticker;
    // End of variables declaration//GEN-END:variables
}
