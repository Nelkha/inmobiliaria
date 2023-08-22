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
import models.Inmueble;
import models.Inquilino;
import servicios.ContratoServicio;
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
    List<Inmueble> inmuebles = inmServ.consultaTodos();

    public ContratoForm() throws ParseException {
        initComponents();
        llenarComboBox();
        comportamientoTextField(txtCuit, "CUIT");
        comportamientoTextField(txtNombre, "NOMBRE");
        comportamientoTextField(txtApellido, "APELLIDO");
        comportamientoTextField(txtCantMese, "MESES INDEXACION");
        comportamientoTextField(txtFFin, "AAAA-MM-DD");
        comportamientoTextField(txtFInicio, "AAAA-MM-DD");
        comportamientoTextField(txtTelefono, "TELEFONO");
        comportamientoTextField(txtMontoInicial, "VALOR INICIAL");
        activarBuscarConEnterBtn(txtCantMese,btnGuardar);
        vaciarFocus(txtCuit);
        vaciarFocus(txtNombre);
        vaciarFocus(txtApellido);
        vaciarFocus(txtCantMese);
        vaciarFocus(txtFFin);
        vaciarFocus(txtFInicio);
        vaciarFocus(txtTelefono);
        vaciarFocus(txtMontoInicial);
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
            cmbInmuebles.addItem(inmueble.getDireccion());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator4 = new javax.swing.JSeparator();
        contentPI = new javax.swing.JPanel();
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
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();

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
        contentPI.add(txtCuit, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 220, 20));

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
        contentPI.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 120, 20));

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
        contentPI.add(txtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, 220, 20));

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
        contentPI.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 220, 20));

        cmbInmuebles.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        contentPI.add(cmbInmuebles, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 170, -1));

        jLabel6.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Caracteriticas del contrato");
        contentPI.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        jLabel7.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Inmueble");
        contentPI.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        jLabel8.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Fecha de inicio");
        contentPI.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, -1, -1));

        jLabel9.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Fecha de fin");
        contentPI.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 260, -1, -1));

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
        contentPI.add(txtMontoInicial, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 120, 20));

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
        contentPI.add(txtCantMese, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 120, 20));

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
        contentPI.add(txtFInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, -1, -1));

        txtFFin.setBackground(new java.awt.Color(255, 255, 255));
        txtFFin.setBorder(null);
        txtFFin.setForeground(new java.awt.Color(102, 102, 102));
        txtFFin.setText("AAAA-MM-DD");
        contentPI.add(txtFFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 280, -1, -1));

        add(contentPI, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 460, 460));

        jSeparator1.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 110, 10));

        jSeparator2.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 110, 10));

        jSeparator3.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));
        add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 110, 10));

        jSeparator5.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator5.setForeground(new java.awt.Color(0, 0, 0));
        add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 110, 10));

        jSeparator6.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator6.setForeground(new java.awt.Color(0, 0, 0));
        add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, 110, 10));

        jSeparator7.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator7.setForeground(new java.awt.Color(0, 0, 0));
        add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 110, 10));

        jSeparator8.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator8.setForeground(new java.awt.Color(0, 0, 0));
        add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 300, 110, 10));

        jSeparator9.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator9.setForeground(new java.awt.Color(0, 0, 0));
        add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 110, 10));
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
            String cuit, nombre, apellido, telefono, direccion;
            LocalDate fechaInicio, fechaFin;
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            // Validar campos obligatorios no estén vacíos
            cuit = txtCuit.getText().trim();
            nombre = txtNombre.getText().trim().toUpperCase();
            apellido = txtApellido.getText().trim().toUpperCase();
            telefono = txtTelefono.getText();
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
            List<Double> importesContrato = new ArrayList<>();
            importesContrato.add(valorInicial);
            Contrato contrato = new Contrato(inquilino, inmueble, fechaInicio, fechaFin, valorInicial, cantidadMeses, true, importesContrato);

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> cmbInmuebles;
    private javax.swing.JPanel contentPI;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
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
    private javax.swing.JTextField txtCantMese;
    private javax.swing.JTextField txtCuit;
    private javax.swing.JFormattedTextField txtFFin;
    private javax.swing.JFormattedTextField txtFInicio;
    private javax.swing.JTextField txtMontoInicial;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
