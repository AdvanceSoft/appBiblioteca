/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appbiblioteca.c1_presentacion.form;

import appbiblioteca.c1_presentacion.util.Mensaje;
import appbiblioteca.c2_aplicacion.servicio.GestionarBibliotecarioServicio;
import appbiblioteca.c2_aplicacion.servicio.GestionarEjemplarServicio;
import appbiblioteca.c2_aplicacion.servicio.GestionarLectorServicio;
import appbiblioteca.c2_aplicacion.servicio.GestionarPrestamoServicio;
import appbiblioteca.c3_dominio.entidad.Bibliotecario;
import appbiblioteca.c3_dominio.entidad.Ejemplar;
import appbiblioteca.c3_dominio.entidad.Lector;
import appbiblioteca.c3_dominio.entidad.LineaPrestamo;
import appbiblioteca.c3_dominio.entidad.Prestamo;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import javax.swing.table.TableColumn;
import mastersoft.modelo.ModeloTabla;
import mastersoft.tabladatos.Columna;
import mastersoft.tabladatos.Fila;
import mastersoft.tabladatos.Tabla;

/**
 *
 * @author <AdvanceSoft - Osorio Perez Carlos Alfredo - advancesoft.trujillo@gmail.com>
 */
public class FormRegistrarPrestamo extends javax.swing.JDialog {

    
    Prestamo prestamo;
    /**
     * Creates new form FormRegistrarPrestamo
     * @param parent
     */
    public FormRegistrarPrestamo(java.awt.Frame parent) {
        super(parent, true);
        initComponents();
        crearTablas();
        prestamo = new Prestamo();
        textoFechaPrestamo.setText(prestamo.getFechaprestamo().toString());
        
    }
    private void crearTablas(){
        Tabla tabla = new Tabla();
        tabla.agregarColumna(new Columna("CODIGO", "java.lang.Integer"));
        tabla.agregarColumna(new Columna("TITULO", "java.lang.String"));
        tabla.agregarColumna(new Columna("NIVEL", "java.lang.String"));
        tabla.agregarColumna(new Columna("ESPECIALIDAD", "java.lang.String"));
        tabla.agregarColumna(new Columna("CANTIDAD", "java.lang.String"));
        ModeloTabla modeloTablaLector = new ModeloTabla(tabla);
        tablaLibro.setModel(modeloTablaLector);
        TableColumn columna0,columna1,columna2,columna3,columna4;
        //CODIGO
        columna0 = tablaLibro.getColumnModel().getColumn(0);
        tablaLibro.removeColumn(columna0);
        //TITULO
        columna1 = tablaLibro.getColumnModel().getColumn(0);
        columna1.setPreferredWidth(120);
        columna1.setMaxWidth(120);
        columna1.setMinWidth(120);
        //NIVEL
        columna2 = tablaLibro.getColumnModel().getColumn(1);
        columna2.setPreferredWidth(90);
        columna2.setMaxWidth(90);
        columna2.setMinWidth(90);
        //ESPECIALIDAD
        columna3 = tablaLibro.getColumnModel().getColumn(2);
        columna3.setPreferredWidth(100);
        columna3.setMaxWidth(100);
        columna3.setMinWidth(100);
        //CANTIDAD
        columna4 = tablaLibro.getColumnModel().getColumn(3);
        columna4.setPreferredWidth(100);
        columna4.setMaxWidth(100);
        columna4.setMinWidth(100);
        
        Tabla tabla_LineaPrestamo = new Tabla();
        tabla_LineaPrestamo.agregarColumna(new Columna("CODIGO", "java.lang.Integer"));
        tabla_LineaPrestamo.agregarColumna(new Columna("TITULO", "java.lang.String"));
        tabla_LineaPrestamo.agregarColumna(new Columna("NIVEL", "java.lang.String"));
        tabla_LineaPrestamo.agregarColumna(new Columna("ESPECIALIDAD", "java.lang.String"));
        tabla_LineaPrestamo.agregarColumna(new Columna("CANTIDAD", "java.lang.String"));
        ModeloTabla modeloTablaLineaPrestamo = new ModeloTabla(tabla_LineaPrestamo);
        tablaLineaLibro.setModel(modeloTablaLineaPrestamo);
        //CODIGO
        columna0 = tablaLineaLibro.getColumnModel().getColumn(0);
        tablaLineaLibro.removeColumn(columna0);
        //TITULO
        columna1 = tablaLineaLibro.getColumnModel().getColumn(0);
        columna1.setPreferredWidth(120);
        columna1.setMaxWidth(120);
        columna1.setMinWidth(120);
        //NIVEL
        columna2 = tablaLineaLibro.getColumnModel().getColumn(1);
        columna2.setPreferredWidth(90);
        columna2.setMaxWidth(90);
        columna2.setMinWidth(90);
        //ESPECIALIDAD
        columna3 = tablaLineaLibro.getColumnModel().getColumn(2);
        columna3.setPreferredWidth(100);
        columna3.setMaxWidth(100);
        columna3.setMinWidth(100);
        //CANTIDAD
        columna4 = tablaLineaLibro.getColumnModel().getColumn(3);
        columna4.setPreferredWidth(100);
        columna4.setMaxWidth(100);
        columna4.setMinWidth(100);
    }
    
    private void ponerFocoConSeleccionEnBuscar(){
        textoAlumno.selectAll();
        textoAlumno.requestFocus();
    }  
    
//    public int fechaDelSistema(){
//        Calendar fecha = Calendar.getInstance();
//        int dia = fecha.get(Calendar.DAY_OF_WEEK);
//        int mes = fecha.get(Calendar.MONTH);
//        int anio = fecha.get(Calendar.YEAR);
//    }
    
    public void calcularFechaDevolucion(){
        
    }
    
    private Lector buscarLector(){
        Lector lector = null;
        try {
            GestionarLectorServicio gestionarLectorServicio = new GestionarLectorServicio(); 
            lector = gestionarLectorServicio.buscarPorDNI(textoAlumno.getText().trim());
            if(lector!=null){                
                etiquetaAlumno.setText(lector.getApellido()+", "+lector.getNombre());
                textoLibro.setEnabled(true);
                botonBuscarLibro.setEnabled(true);
            }else 
                Mensaje.Mostrar_MENSAJE_NOSEENCONTRONINGUNRESULTADO(this);
                ponerFocoConSeleccionEnBuscar();
        } catch (Exception e) {
            Mensaje.mostrarErrorExcepcion(this,e.getMessage());
        }
        return lector;
    }
    private Bibliotecario buscarBibliotecario(){
        Bibliotecario bibliotecario = null;
        try {
            GestionarBibliotecarioServicio gestionarBibliotecarioServicio = new GestionarBibliotecarioServicio(); 
            bibliotecario = gestionarBibliotecarioServicio.buscar(WIDTH);
        } catch (Exception e) {
            Mensaje.mostrarErrorExcepcion(this,e.getMessage());
        }
        return bibliotecario;
    }
    private void buscarLibro(){
        ModeloTabla modeloTablaProveedor = (ModeloTabla) tablaLibro.getModel();
        modeloTablaProveedor.eliminarTotalFilas();
        try{
            GestionarEjemplarServicio gestionarEjemplarServicio = new GestionarEjemplarServicio();        
            List<Ejemplar> listaEjemplares = gestionarEjemplarServicio.buscar(textoLibro.getText().trim().toUpperCase());
            if(listaEjemplares!=null && listaEjemplares.size() > 0){
                for (Ejemplar ejemplar : listaEjemplares) {
                    Fila fila = new Fila();
                    fila.agregarValorCelda(ejemplar.getCodigo());
                    fila.agregarValorCelda(ejemplar.getLibro().getNombre());
                    fila.agregarValorCelda(ejemplar.getLibro().getNivel().getNombre());
                    fila.agregarValorCelda(ejemplar.getLibro().getEspecialidad().getNombre());
                    fila.agregarValorCelda(ejemplar.getCantidad());
                    modeloTablaProveedor.agregarFila(fila);
                }
                modeloTablaProveedor.refrescarDatos();
                textoObservacion.setEnabled(true);
                textoCantidad.setEnabled(true);
                botonAgregar.setEnabled(true);
                checkCasa.setEnabled(true);
                checkSala.setEnabled(true);
            }else{
                Mensaje.Mostrar_MENSAJE_NOSEENCONTRONINGUNRESULTADO(this);
                ponerFocoConSeleccionEnBuscar();
            }
        }catch(Exception e){
            Mensaje.mostrarErrorExcepcion(this, e.getMessage());
            ponerFocoConSeleccionEnBuscar();
        }
    }
    
    public Ejemplar obtenerEjemplar(){
        Ejemplar ejemplar = null;
        int fila = tablaLibro.getSelectedRow();
        GestionarPrestamoServicio gestionarPrestamoServicio = new GestionarPrestamoServicio();
        if(fila>=0){
            ModeloTabla modeloTablaLibros = (ModeloTabla)tablaLibro.getModel();
            int codigoEjemplar = (Integer)modeloTablaLibros.getValueAt(fila, 0);
            try {
                ejemplar = gestionarPrestamoServicio.buscarLibro(codigoEjemplar);
            } catch (Exception e) {
                Mensaje.Mostrar_MENSAJE_FILANOEXISTE(this);
            }
        }else
            Mensaje.Mostrar_MENSAJE_FILANOSELECCIONADO(this);
        return ejemplar;
    }
    
    private LineaPrestamo crearLineaPrestamo(){
        Ejemplar ejemplar = obtenerEjemplar();
        LineaPrestamo lineaPrestamo = new LineaPrestamo();
        if(!textoCantidad.getText().trim().isEmpty() && !textoObservacion.getText().trim().isEmpty()){
            lineaPrestamo.setCantidad(Integer.parseInt(textoCantidad.getText().trim()));
            lineaPrestamo.setObservacion(String.valueOf(textoObservacion.getText().trim()));
            lineaPrestamo.setEjemplar(ejemplar); 
        }           
        return lineaPrestamo; 
    }
    
    private void agregarLineaPrestamo(){           
        LineaPrestamo lineaPrestamo = crearLineaPrestamo(); 
        ModeloTabla modeloTablaDetalleVenta = (ModeloTabla)tablaLineaLibro.getModel();
        try {
            prestamo.agregarLineaPrestamo(lineaPrestamo);
            modeloTablaDetalleVenta.eliminarTotalFilas();
            for(LineaPrestamo lineaPrestamos : prestamo.getLineaPrestamo()){
                Fila fila = new Fila();
                fila.agregarValorCelda(lineaPrestamos.getEjemplar().getCodigo());
                fila.agregarValorCelda(lineaPrestamos.getEjemplar().getLibro().getNombre());
                fila.agregarValorCelda(lineaPrestamos.getEjemplar().getLibro().getNivel().getNombre());
                fila.agregarValorCelda(lineaPrestamos.getEjemplar().getLibro().getEspecialidad().getNombre());
                fila.agregarValorCelda(lineaPrestamos.getEjemplar().getCantidad());                     
                modeloTablaDetalleVenta.agregarFila(fila);
                fila.obtenerCelda(3).setEditable(true);
            }
            modeloTablaDetalleVenta.refrescarDatos();           
        } catch (Exception e) {
            Mensaje.Mostrar_MENSAJE_LLENARCAMPOSOBLIGATORIOS(this);
        }        
    }
    
     private void limpiarDatosPrestamo(){
        prestamo = new Prestamo();
        textoAlumno.setText("");
        textoLibro.setText("");
        textoCantidad.setText("");
        textoObservacion.setText("");
        ((ModeloTabla)tablaLibro.getModel()).eliminarTotalFilas();
        ((ModeloTabla)tablaLineaLibro.getModel()).eliminarTotalFilas();
        textoAlumno.requestFocus();
    }
    
    private void guardarPrestamo(){
        Lector lector = buscarLector();
        Bibliotecario bibliotecario = buscarBibliotecario();
        Date fechaDevolucion;
        //Date fechPrestamo = fechaDelSistema();
        String lugar;
        if(checkCasa.isEnabled())
            lugar = "CASA";
        else
            lugar = "SALA";
        prestamo.setBibliotecario(bibliotecario);
        prestamo.setLector(lector);
        prestamo.setLugar(lugar);
        //prestamo.setFechaprestamo(fechPrestamo);
//        prestamo.setFechadevolucion(fechaDevolucion);
        try {
             GestionarPrestamoServicio gestionarPrestamoServicio = new GestionarPrestamoServicio();
             gestionarPrestamoServicio.crear(prestamo);
             Mensaje.Mostrar_MENSAJE_GUARDADOEXITOSO(this);
             limpiarDatosPrestamo();
        } catch (Exception e) {
            Mensaje.mostrarErrorExcepcion(this,e.getMessage());
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

        grupoRadioLugar = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        textoAlumno = new javax.swing.JTextField();
        textoLibro = new javax.swing.JTextField();
        botonBuscarAlumno = new javax.swing.JButton();
        botonBuscarLibro = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaLibro = new javax.swing.JTable();
        etiquetaAlumno = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        textoObservacion = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        textoCantidad = new javax.swing.JTextField();
        botonAgregar = new javax.swing.JButton();
        botonGuardar = new javax.swing.JButton();
        botonSalir = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaLineaLibro = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        textoFechaPrestamo = new javax.swing.JTextField();
        textoFechaDevolucion = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        checkCasa = new javax.swing.JRadioButton();
        checkSala = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registrar Prestamo");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Lector:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Libro:");

        textoAlumno.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        textoLibro.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        textoLibro.setEnabled(false);

        botonBuscarAlumno.setBackground(new java.awt.Color(255, 255, 255));
        botonBuscarAlumno.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        botonBuscarAlumno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/appbiblioteca/c1_presentacion/iconos/buscarx20.png"))); // NOI18N
        botonBuscarAlumno.setText("Buscar");
        botonBuscarAlumno.setOpaque(false);
        botonBuscarAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarAlumnoActionPerformed(evt);
            }
        });

        botonBuscarLibro.setBackground(new java.awt.Color(255, 255, 255));
        botonBuscarLibro.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        botonBuscarLibro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/appbiblioteca/c1_presentacion/iconos/buscarx20.png"))); // NOI18N
        botonBuscarLibro.setText("Buscar");
        botonBuscarLibro.setEnabled(false);
        botonBuscarLibro.setOpaque(false);
        botonBuscarLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarLibroActionPerformed(evt);
            }
        });

        tablaLibro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaLibro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tablaLibroKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tablaLibro);

        etiquetaAlumno.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        etiquetaAlumno.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiquetaAlumno.setText("OSORIO PÉREZ, CARLOS ALFREDO");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Observación:");

        textoObservacion.setColumns(20);
        textoObservacion.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        textoObservacion.setRows(5);
        textoObservacion.setEnabled(false);
        jScrollPane3.setViewportView(textoObservacion);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Cantidad:");

        textoCantidad.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        textoCantidad.setEnabled(false);

        botonAgregar.setBackground(new java.awt.Color(255, 255, 255));
        botonAgregar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        botonAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/appbiblioteca/c1_presentacion/iconos/agregarx20.png"))); // NOI18N
        botonAgregar.setText("Agregar");
        botonAgregar.setEnabled(false);
        botonAgregar.setOpaque(false);
        botonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarActionPerformed(evt);
            }
        });

        botonGuardar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        botonGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/appbiblioteca/c1_presentacion/iconos/guardarx32.png"))); // NOI18N
        botonGuardar.setText("Guardar");
        botonGuardar.setEnabled(false);
        botonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarActionPerformed(evt);
            }
        });

        botonSalir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        botonSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/appbiblioteca/c1_presentacion/iconos/salirx32.png"))); // NOI18N
        botonSalir.setText("Salir");
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalle del Prestamo"));

        tablaLineaLibro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaLineaLibro.setEnabled(false);
        tablaLineaLibro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tablaLineaLibroKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tablaLineaLibro);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Fecha de Prestamo:");

        textoFechaPrestamo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        textoFechaPrestamo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textoFechaPrestamo.setText("08/09/2015");
        textoFechaPrestamo.setEnabled(false);

        textoFechaDevolucion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        textoFechaDevolucion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textoFechaDevolucion.setText("11/08/2015");
        textoFechaDevolucion.setEnabled(false);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Fecha de Devolución:");

        grupoRadioLugar.add(checkCasa);
        checkCasa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        checkCasa.setText("Casa");
        checkCasa.setEnabled(false);

        grupoRadioLugar.add(checkSala);
        checkSala.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        checkSala.setSelected(true);
        checkSala.setText("Sala");
        checkSala.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Lugar:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textoFechaPrestamo)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(checkCasa)
                                .addGap(31, 31, 31)
                                .addComponent(checkSala)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(textoFechaDevolucion)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(textoFechaPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(textoFechaDevolucion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkCasa)
                    .addComponent(checkSala)
                    .addComponent(jLabel3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textoCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(textoLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(botonBuscarLibro))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(textoAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(botonBuscarAlumno))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(85, 85, 85)
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(301, 301, 301)
                                        .addComponent(botonAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(etiquetaAlumno, javax.swing.GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 839, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(259, 259, 259)
                        .addComponent(botonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76)
                        .addComponent(botonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(etiquetaAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonBuscarAlumno)
                    .addComponent(textoAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(9, 9, 9)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(botonBuscarLibro)
                            .addComponent(textoLibro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(botonAgregar)
                            .addComponent(textoCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_botonSalirActionPerformed

    private void botonBuscarAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarAlumnoActionPerformed
        // TODO add your handling code here:
        buscarLector();    
    }//GEN-LAST:event_botonBuscarAlumnoActionPerformed

    private void botonBuscarLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarLibroActionPerformed
        // TODO add your handling code here:
        buscarLibro();        
    }//GEN-LAST:event_botonBuscarLibroActionPerformed

    private void botonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarActionPerformed
        // TODO add your handling code here:
        agregarLineaPrestamo();
        botonGuardar.setEnabled(true);
    }//GEN-LAST:event_botonAgregarActionPerformed

    private void tablaLineaLibroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablaLineaLibroKeyReleased
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER||
          (evt.getKeyCode()==KeyEvent.VK_TAB)||
          (evt.getKeyCode()==KeyEvent.VK_UP)||
          (evt.getKeyCode()==KeyEvent.VK_DOWN)){
            
        }
    }//GEN-LAST:event_tablaLineaLibroKeyReleased

    private void tablaLibroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablaLibroKeyReleased
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER||
          (evt.getKeyCode()==KeyEvent.VK_TAB)||
          (evt.getKeyCode()==KeyEvent.VK_UP)||
          (evt.getKeyCode()==KeyEvent.VK_DOWN)){
            
        }
    }//GEN-LAST:event_tablaLibroKeyReleased

    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarActionPerformed
        // TODO add your handling code here:
        guardarPrestamo();
    }//GEN-LAST:event_botonGuardarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAgregar;
    private javax.swing.JButton botonBuscarAlumno;
    private javax.swing.JButton botonBuscarLibro;
    private javax.swing.JButton botonGuardar;
    private javax.swing.JButton botonSalir;
    private javax.swing.JRadioButton checkCasa;
    private javax.swing.JRadioButton checkSala;
    private javax.swing.JLabel etiquetaAlumno;
    private javax.swing.ButtonGroup grupoRadioLugar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tablaLibro;
    private javax.swing.JTable tablaLineaLibro;
    private javax.swing.JTextField textoAlumno;
    private javax.swing.JTextField textoCantidad;
    private javax.swing.JTextField textoFechaDevolucion;
    private javax.swing.JTextField textoFechaPrestamo;
    private javax.swing.JTextField textoLibro;
    private javax.swing.JTextArea textoObservacion;
    // End of variables declaration//GEN-END:variables
}
