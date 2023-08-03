/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package views;

import models.Inmueble;
import servicios.InmuebleServicio;

/**
 *
 * @author Nelkha
 */
public class InmForm extends javax.swing.JPanel {

    /**
     * Creates new form CrudForm2
     */
    public InmForm() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contentIF = new javax.swing.JPanel();
        jSeparator10 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        lblMensaje = new javax.swing.JLabel();
        txtCalle = new javax.swing.JTextField();
        txtAltura = new javax.swing.JTextField();
        limpiarBtn1 = new javax.swing.JButton();
        guardarBoton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        contentIF.setBackground(new java.awt.Color(255, 255, 255));

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(490, 480));
        setPreferredSize(new java.awt.Dimension(490, 480));
        setRequestFocusEnabled(false);
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator10.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator10.setForeground(new java.awt.Color(0, 0, 0));
        add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, 130, 10));

        jSeparator8.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator8.setForeground(new java.awt.Color(0, 0, 0));
        add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, 130, 20));

        lblMensaje.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        lblMensaje.setForeground(new java.awt.Color(255, 0, 0));
        lblMensaje.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        add(lblMensaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 440, 20));

        txtCalle.setBackground(new java.awt.Color(255, 255, 255));
        txtCalle.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtCalle.setForeground(new java.awt.Color(102, 102, 102));
        txtCalle.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtCalle.setText("CALLE DEL INMUEBLE");
        txtCalle.setBorder(null);
        txtCalle.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCalleFocusLost(evt);
            }
        });
        txtCalle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtCalleMouseClicked(evt);
            }
        });
        txtCalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCalleActionPerformed(evt);
            }
        });
        add(txtCalle, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 220, 30));

        txtAltura.setBackground(new java.awt.Color(255, 255, 255));
        txtAltura.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtAltura.setForeground(new java.awt.Color(102, 102, 102));
        txtAltura.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtAltura.setText("ALTURA");
        txtAltura.setBorder(null);
        txtAltura.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtAlturaFocusLost(evt);
            }
        });
        txtAltura.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtAlturaMouseClicked(evt);
            }
        });
        txtAltura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAlturaActionPerformed(evt);
            }
        });
        add(txtAltura, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, 220, 30));

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
        add(limpiarBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 230, 130, 40));

        guardarBoton.setBackground(new java.awt.Color(0, 51, 153));
        guardarBoton.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        guardarBoton.setForeground(new java.awt.Color(255, 255, 255));
        guardarBoton.setText("GUARDAR");
        guardarBoton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        guardarBoton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        guardarBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarBotonActionPerformed(evt);
            }
        });
        add(guardarBoton, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 230, 130, 40));

        jLabel5.setForeground(new java.awt.Color(255, 0, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("ADVERTENCIA: TODOS LOS CAMPOS SON REQUERIDOS");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 470, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void txtCalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCalleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCalleActionPerformed

    private void txtAlturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAlturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAlturaActionPerformed

    private void limpiarBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarBtn1ActionPerformed
        txtCalle.setText("CALLE DEL INMUEBLE");
        txtAltura.setText("ALTURA");
    }//GEN-LAST:event_limpiarBtn1ActionPerformed

    private void guardarBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarBotonActionPerformed
        InmuebleServicio inmServ = new InmuebleServicio();
        String mensajeFinal;
        String calle = txtCalle.getText().trim();
        String alturaStr = txtAltura.getText().trim();

        if (calle.isEmpty() || calle.equals("CALLE DEL INMUEBLE") || alturaStr.isEmpty() || alturaStr.equals("ALTURA")) {
            lblMensaje.setText("Los campos Calle y Altura son requeridos.");
        } else {

            try {
                int altura = Integer.parseInt(alturaStr);

                String direccion = (calle + " " + altura).toUpperCase();
                Inmueble inm = new Inmueble(direccion, true);
                mensajeFinal = inmServ.guardar(inm);
                lblMensaje.setText(mensajeFinal);
            } catch (NumberFormatException e) {
                lblMensaje.setText("La altura debe ser un número válido.");
            }
        }
    }//GEN-LAST:event_guardarBotonActionPerformed

    private void txtCalleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCalleMouseClicked
        if (txtCalle.getText().equals("CALLE DEL INMUEBLE")) {
            txtCalle.setText("");
        }
    }//GEN-LAST:event_txtCalleMouseClicked

    private void txtCalleFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCalleFocusLost
        if (txtCalle.getText().isEmpty()) {
            txtCalle.setText("CALLE DEL INMUEBLE");
        }
    }//GEN-LAST:event_txtCalleFocusLost

    private void txtAlturaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtAlturaMouseClicked
        if (txtAltura.getText().equals("ALTURA")) {
            txtAltura.setText("");
        }
    }//GEN-LAST:event_txtAlturaMouseClicked

    private void txtAlturaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtAlturaFocusLost
        if (txtAltura.getText().isEmpty()) {
            txtAltura.setText("ALTURA");
        }
    }//GEN-LAST:event_txtAlturaFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel contentIF;
    private javax.swing.JButton guardarBoton;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JLabel lblMensaje;
    private javax.swing.JButton limpiarBtn1;
    private javax.swing.JTextField txtAltura;
    private javax.swing.JTextField txtCalle;
    // End of variables declaration//GEN-END:variables
}
