/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package views;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFormattedTextField;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import models.Contrato;
import models.Garante;
import models.Inmueble;
import models.Inquilino;
import servicios.ContratoServicio;
import servicios.GaranteServicio;
import static servicios.Globales.activarBuscarConEnterBtn;
import servicios.InmuebleServicio;
import servicios.InquilinoServicio;
import static servicios.Globales.comportamientoTextField;
import static servicios.Globales.vaciarFocus;

/**
 *
 * @author Nelkha
 */
public class ContratoForm extends javax.swing.JPanel {

    InmuebleServicio inmServ = new InmuebleServicio();
    InquilinoServicio inqServ = new InquilinoServicio();
    GaranteServicio garanteServ = new GaranteServicio();
    List<Inmueble> inmuebles = inmServ.consultaTodos();

    public ContratoForm() throws ParseException {
        initComponents();
        llenarComboBox();
        comportamientoTextField(txtCuit, "CUIT");
        comportamientoTextField(txtNombre, "NOMBRE");
        comportamientoTextField(txtApellido, "APELLIDO");
        comportamientoTextField(txtCuitGarante, "CUIT");
        comportamientoTextField(txtNombreGarante, "NOMBRE");
        comportamientoTextField(txtApellidoGarante, "APELLIDO");
        comportamientoTextField(txtDireccionGarante, "DIRECCION");
        comportamientoTextField(txtTelefonoGarante, "APELLIDO");
        comportamientoTextField(txtCantMese, "MESES INDEXACION");
        comportamientoTextField(txtFFin, "AAAA-MM-DD");
        comportamientoTextField(txtFInicio, "AAAA-MM-DD");
        comportamientoTextField(txtTelefono, "TELEFONO");
        comportamientoTextField(txtMontoInicial, "VALOR INICIAL");
        activarBuscarConEnterBtn(txtCantMese,btnGuardar);
        vaciarFocus(txtCuit,"CUIT");
        vaciarFocus(txtNombre,"NOMBRE");
        vaciarFocus(txtApellido,"APELLIDO");
        vaciarFocus(txtTelefono,"TELEFONO");
        vaciarFocus(txtCantMese,"MESES INDEXACION");
         vaciarFocus(txtCuitGarante,"CUIT");
        vaciarFocus(txtNombreGarante,"NOMBRE");
        vaciarFocus(txtApellidoGarante,"APELLIDO");
        vaciarFocus(txtTelefonoGarante,"TELEFONO");
        vaciarFocus(txtDireccionGarante,"TELEFONO");
        vaciarFocus(txtMontoInicial,"VALOR INICIAL");
        MaskFormatter mask = new MaskFormatter("##/##/####");
        mask.setPlaceholderCharacter('0'); // Carácter que se mostrará en lugar de los guiones
        DefaultFormatterFactory formatterFactory = new DefaultFormatterFactory(mask);
        txtFInicio.setFormatterFactory(formatterFactory);
        txtFInicio.setColumns(10);
        txtFFin.setFormatterFactory(formatterFactory);
        txtFFin.setColumns(10);

    }

    private void llenarComboBox() {

        cmbInmuebles.removeAllItems();
        for (Inmueble inmueble : inmuebles) {
            if(inmueble.isAlta()){
            cmbInmuebles.addItem(inmueble.getDireccion());
            }
            
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator4 = new javax.swing.JSeparator();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        contentPI = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        lblMensaje = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCuit = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        cmbInmuebles = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtMontoInicial = new javax.swing.JTextField();
        txtCantMese = new javax.swing.JTextField();
        limpiarBtn1 = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtFInicio = new javax.swing.JFormattedTextField();
        txtFFin = new javax.swing.JFormattedTextField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jLabel10 = new javax.swing.JLabel();
        txtCuitGarante = new javax.swing.JTextField();
        jSeparator10 = new javax.swing.JSeparator();
        txtNombreGarante = new javax.swing.JTextField();
        jSeparator11 = new javax.swing.JSeparator();
        txtApellidoGarante = new javax.swing.JTextField();
        jSeparator12 = new javax.swing.JSeparator();
        txtTelefonoGarante = new javax.swing.JTextField();
        jSeparator13 = new javax.swing.JSeparator();
        txtDireccionGarante = new javax.swing.JTextField();
        jSeparator14 = new javax.swing.JSeparator();

        jSeparator4.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator4.setForeground(new java.awt.Color(0, 0, 0));

        setBackground(new java.awt.Color(0, 0, 0));
        setMinimumSize(new java.awt.Dimension(490, 480));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(490, 480));
        setRequestFocusEnabled(false);
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        contentPI.setBackground(new java.awt.Color(255, 255, 255));
        contentPI.setForeground(new java.awt.Color(0, 0, 0));
        contentPI.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator1.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        contentPI.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 110, 10));

        jSeparator2.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        contentPI.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 110, 10));

        jSeparator3.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));
        contentPI.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 110, 10));

        jSeparator5.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator5.setForeground(new java.awt.Color(0, 0, 0));
        contentPI.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 110, 10));

        jSeparator6.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator6.setForeground(new java.awt.Color(0, 0, 0));
        contentPI.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 110, 10));

        jSeparator7.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator7.setForeground(new java.awt.Color(0, 0, 0));
        contentPI.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 110, 10));

        jSeparator8.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator8.setForeground(new java.awt.Color(0, 0, 0));
        contentPI.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 320, 110, 10));

        jSeparator9.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator9.setForeground(new java.awt.Color(0, 0, 0));
        contentPI.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 110, 10));

        lblMensaje.setFont(new java.awt.Font("Roboto", 0, 10)); // NOI18N
        lblMensaje.setForeground(new java.awt.Color(204, 0, 0));
        lblMensaje.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        contentPI.add(lblMensaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 440, 460, -1));

        jLabel4.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Datos del inquilino");
        contentPI.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        txtCuit.setBackground(new java.awt.Color(255, 255, 255));
        txtCuit.setFont(new java.awt.Font("Roboto", 0, 10)); // NOI18N
        txtCuit.setForeground(new java.awt.Color(102, 102, 102));
        txtCuit.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtCuit.setText("CUIT");
        txtCuit.setBorder(null);
        txtCuit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCuitActionPerformed(evt);
            }
        });
        contentPI.add(txtCuit, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 120, 20));

        txtNombre.setBackground(new java.awt.Color(255, 255, 255));
        txtNombre.setFont(new java.awt.Font("Roboto", 0, 10)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(102, 102, 102));
        txtNombre.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtNombre.setText("NOMBRE");
        txtNombre.setBorder(null);
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        contentPI.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 120, 20));

        txtApellido.setBackground(new java.awt.Color(255, 255, 255));
        txtApellido.setFont(new java.awt.Font("Roboto", 0, 10)); // NOI18N
        txtApellido.setForeground(new java.awt.Color(102, 102, 102));
        txtApellido.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtApellido.setText("APELLIDO");
        txtApellido.setBorder(null);
        txtApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidoActionPerformed(evt);
            }
        });
        contentPI.add(txtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 110, 20));

        txtTelefono.setBackground(new java.awt.Color(255, 255, 255));
        txtTelefono.setFont(new java.awt.Font("Roboto", 0, 10)); // NOI18N
        txtTelefono.setForeground(new java.awt.Color(102, 102, 102));
        txtTelefono.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtTelefono.setText("TELEFONO");
        txtTelefono.setBorder(null);
        txtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoActionPerformed(evt);
            }
        });
        contentPI.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 110, 20));

        cmbInmuebles.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        contentPI.add(cmbInmuebles, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 170, -1));

        jLabel6.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Caracteriticas del contrato");
        contentPI.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, -1));

        jLabel7.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Inmueble");
        contentPI.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));

        jLabel8.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Fecha de inicio");
        contentPI.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, -1, -1));

        jLabel9.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Fecha de fin");
        contentPI.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 280, -1, -1));

        txtMontoInicial.setBackground(new java.awt.Color(255, 255, 255));
        txtMontoInicial.setFont(new java.awt.Font("Roboto", 0, 10)); // NOI18N
        txtMontoInicial.setForeground(new java.awt.Color(102, 102, 102));
        txtMontoInicial.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtMontoInicial.setText("VALOR INICIAL");
        txtMontoInicial.setBorder(null);
        txtMontoInicial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMontoInicialActionPerformed(evt);
            }
        });
        contentPI.add(txtMontoInicial, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 120, 20));

        txtCantMese.setBackground(new java.awt.Color(255, 255, 255));
        txtCantMese.setFont(new java.awt.Font("Roboto", 0, 10)); // NOI18N
        txtCantMese.setForeground(new java.awt.Color(102, 102, 102));
        txtCantMese.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtCantMese.setText("MESES INDEXACION");
        txtCantMese.setBorder(null);
        txtCantMese.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantMeseActionPerformed(evt);
            }
        });
        contentPI.add(txtCantMese, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 120, 20));

        limpiarBtn1.setBackground(new java.awt.Color(0, 51, 153));
        limpiarBtn1.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        limpiarBtn1.setForeground(new java.awt.Color(255, 255, 255));
        limpiarBtn1.setText("LIMPIAR");
        limpiarBtn1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        limpiarBtn1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        limpiarBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarBtn1ActionPerformed(evt);
            }
        });
        contentPI.add(limpiarBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 390, 130, 40));

        btnGuardar.setBackground(new java.awt.Color(0, 51, 153));
        btnGuardar.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setText("GUARDAR");
        btnGuardar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        contentPI.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 390, 130, 40));

        jLabel5.setFont(new java.awt.Font("Roboto", 0, 10)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 0, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("ADVERTENCIA TODOS LOS CAMPOS SON REQUERIDOS");
        contentPI.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 460, -1));

        txtFInicio.setBackground(new java.awt.Color(255, 255, 255));
        txtFInicio.setBorder(null);
        txtFInicio.setForeground(new java.awt.Color(102, 102, 102));
        txtFInicio.setText("AAAA-MM-DD");
        contentPI.add(txtFInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, -1, -1));

        txtFFin.setBackground(new java.awt.Color(255, 255, 255));
        txtFFin.setBorder(null);
        txtFFin.setForeground(new java.awt.Color(102, 102, 102));
        txtFFin.setText("AAAA-MM-DD");
        contentPI.add(txtFFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 300, -1, -1));

        jCheckBox1.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(jCheckBox1);
        jCheckBox1.setText("SRA.");
        contentPI.add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 60, 20));

        jCheckBox2.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(jCheckBox2);
        jCheckBox2.setText("SR.");
        contentPI.add(jCheckBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 50, 20));

        jCheckBox3.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup2.add(jCheckBox3);
        jCheckBox3.setText("SRA.");
        contentPI.add(jCheckBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 50, 60, 20));

        jCheckBox4.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup2.add(jCheckBox4);
        jCheckBox4.setText("SR.");
        contentPI.add(jCheckBox4, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, 50, 20));

        jLabel10.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Datos del Garante");
        contentPI.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 30, -1, -1));

        txtCuitGarante.setBackground(new java.awt.Color(255, 255, 255));
        txtCuitGarante.setFont(new java.awt.Font("Roboto", 0, 10)); // NOI18N
        txtCuitGarante.setForeground(new java.awt.Color(102, 102, 102));
        txtCuitGarante.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtCuitGarante.setText("CUIT");
        txtCuitGarante.setBorder(null);
        txtCuitGarante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCuitGaranteActionPerformed(evt);
            }
        });
        contentPI.add(txtCuitGarante, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 70, 120, 20));

        jSeparator10.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator10.setForeground(new java.awt.Color(0, 0, 0));
        contentPI.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 90, 110, 10));

        txtNombreGarante.setBackground(new java.awt.Color(255, 255, 255));
        txtNombreGarante.setFont(new java.awt.Font("Roboto", 0, 10)); // NOI18N
        txtNombreGarante.setForeground(new java.awt.Color(102, 102, 102));
        txtNombreGarante.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtNombreGarante.setText("NOMBRE");
        txtNombreGarante.setBorder(null);
        txtNombreGarante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreGaranteActionPerformed(evt);
            }
        });
        contentPI.add(txtNombreGarante, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 100, 120, 20));

        jSeparator11.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator11.setForeground(new java.awt.Color(0, 0, 0));
        contentPI.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 120, 110, 10));

        txtApellidoGarante.setBackground(new java.awt.Color(255, 255, 255));
        txtApellidoGarante.setFont(new java.awt.Font("Roboto", 0, 10)); // NOI18N
        txtApellidoGarante.setForeground(new java.awt.Color(102, 102, 102));
        txtApellidoGarante.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtApellidoGarante.setText("APELLIDO");
        txtApellidoGarante.setBorder(null);
        txtApellidoGarante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidoGaranteActionPerformed(evt);
            }
        });
        contentPI.add(txtApellidoGarante, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 130, 110, 20));

        jSeparator12.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator12.setForeground(new java.awt.Color(0, 0, 0));
        contentPI.add(jSeparator12, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 150, 110, 10));

        txtTelefonoGarante.setBackground(new java.awt.Color(255, 255, 255));
        txtTelefonoGarante.setFont(new java.awt.Font("Roboto", 0, 10)); // NOI18N
        txtTelefonoGarante.setForeground(new java.awt.Color(102, 102, 102));
        txtTelefonoGarante.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtTelefonoGarante.setText("TELEFONO");
        txtTelefonoGarante.setBorder(null);
        txtTelefonoGarante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoGaranteActionPerformed(evt);
            }
        });
        contentPI.add(txtTelefonoGarante, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 160, 110, 20));

        jSeparator13.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator13.setForeground(new java.awt.Color(0, 0, 0));
        contentPI.add(jSeparator13, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 180, 110, 10));

        txtDireccionGarante.setBackground(new java.awt.Color(255, 255, 255));
        txtDireccionGarante.setFont(new java.awt.Font("Roboto", 0, 10)); // NOI18N
        txtDireccionGarante.setForeground(new java.awt.Color(102, 102, 102));
        txtDireccionGarante.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtDireccionGarante.setText("DIRECCION");
        txtDireccionGarante.setBorder(null);
        txtDireccionGarante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionGaranteActionPerformed(evt);
            }
        });
        contentPI.add(txtDireccionGarante, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 160, 110, 20));

        jSeparator14.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator14.setForeground(new java.awt.Color(0, 0, 0));
        contentPI.add(jSeparator14, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 180, 110, 10));

        add(contentPI, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 460, 460));
    }// </editor-fold>//GEN-END:initComponents

    private void txtApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidoActionPerformed

    private void txtCuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCuitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCuitActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoActionPerformed

    private void txtCantMeseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantMeseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantMeseActionPerformed

    private void limpiarBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarBtn1ActionPerformed

    }//GEN-LAST:event_limpiarBtn1ActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        try {
            String cuit, nombre, apellido, telefono, direccion,cuitGarante, nombreGarante, apellidoGarante, telefonoGarante, direccionGarante;
            LocalDate fechaInicio, fechaFin;
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            // Validar campos obligatorios no estén vacíos
            
            cuit = txtCuit.getText().trim();
            nombre = txtNombre.getText().trim().toUpperCase();
            apellido = txtApellido.getText().trim().toUpperCase();
            telefono = txtTelefono.getText().trim();
            cuitGarante = txtCuitGarante.getText().trim();
            nombreGarante = txtNombreGarante.getText().trim().toUpperCase();
            apellidoGarante = txtApellidoGarante.getText().trim().toUpperCase();
            telefonoGarante = txtTelefonoGarante.getText().trim();
            direccionGarante=txtDireccionGarante.getText().trim();
            fechaInicio = LocalDate.parse(txtFInicio.getText().trim(), formato);
            fechaFin = LocalDate.parse(txtFFin.getText().trim(), formato);
            direccion = (String) cmbInmuebles.getSelectedItem();
            
            int cantidadMeses = Integer.parseInt(txtCantMese.getText().trim());
            double valorInicial = Double.parseDouble(txtMontoInicial.getText().trim());

            // Validar longitud del CUIT
            if (cuit.length() != 11) {
                lblMensaje.setText("El CUIT debe tener 11 caracteres.");
                return;
            }

            // Validar fechas
            LocalDate fechaActual = LocalDate.now();
            if (fechaInicio.isAfter(fechaActual)) {
                lblMensaje.setText("La fecha de inicio no puede ser posterior a la fecha actual.");
                return;
            }
            if (fechaFin.isBefore(fechaInicio)) {
                lblMensaje.setText("La fecha de fin no puede ser anterior a la fecha de inicio.");
                return;
            }

            Inmueble inmueble = null;
            for (Inmueble inm : inmuebles) {
                if (inm.getDireccion().equals(direccion)) {
                    inmueble = inm;
                    break;
                }
            }

            
            Inquilino inquilinoTemp = new Inquilino(cuit, nombre, apellido, telefono);
            Inquilino inquilino = inqServ.guardar(inquilinoTemp);
            Garante garanteTemp=new Garante(cuitGarante, nombreGarante, apellidoGarante, telefonoGarante, direccionGarante);
            Garante garante=garanteServ.guardar(garanteTemp);
            List<Double> importesContrato = new ArrayList<>();
            importesContrato.add(valorInicial);
            Contrato contrato = new Contrato(inquilino, inmueble,garante, fechaInicio, fechaFin, valorInicial, cantidadMeses, true, importesContrato);

            ContratoServicio contratoServ = new ContratoServicio();
            boolean contratoGuardado = contratoServ.guardar(contrato);

            if (contratoGuardado) {
                inqServ.agregarContrato(inquilino, contrato);
                inmServ.agregarContrato(inmueble, contrato);
                lblMensaje.setText("Contrato guardado exitosamente");
                comportamientoTextField(txtCuit, "CUIT");
                txtNombre.setText("NOMBRE");
                txtApellido.setText("APELLIDO");
                txtCantMese.setText("MESE INDEXACION");
                txtCuit.setText("CUIT");
                txtTelefono.setText("TELEFONO");
                txtMontoInicial.setText("VALOR INICIAL");

            } else {
                lblMensaje.setText("El Contrato no se ha guardado, intentelo nuevamente");
            }
        } catch (DateTimeParseException e) {
            lblMensaje.setText("Debe ingresar una fecha valida");
        } catch (NumberFormatException e) {
            lblMensaje.setText("Debe ingresar un numero valido");
        } catch (Exception e) {
            lblMensaje.setText("Ocurrió un error inesperado. Verifique los datos e intente nuevamente");
            e.printStackTrace();
        }


    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtMontoInicialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMontoInicialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMontoInicialActionPerformed

    private void txtCuitGaranteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCuitGaranteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCuitGaranteActionPerformed

    private void txtNombreGaranteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreGaranteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreGaranteActionPerformed

    private void txtApellidoGaranteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidoGaranteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidoGaranteActionPerformed

    private void txtTelefonoGaranteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoGaranteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoGaranteActionPerformed

    private void txtDireccionGaranteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionGaranteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionGaranteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cmbInmuebles;
    private javax.swing.JPanel contentPI;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JLabel lblMensaje;
    private javax.swing.JButton limpiarBtn1;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtApellidoGarante;
    private javax.swing.JTextField txtCantMese;
    private javax.swing.JTextField txtCuit;
    private javax.swing.JTextField txtCuitGarante;
    private javax.swing.JTextField txtDireccionGarante;
    private javax.swing.JFormattedTextField txtFFin;
    private javax.swing.JFormattedTextField txtFInicio;
    private javax.swing.JTextField txtMontoInicial;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombreGarante;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtTelefonoGarante;
    // End of variables declaration//GEN-END:variables
}
