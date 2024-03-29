/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;
import models.Contrato;

import servicios.BajaServicio;
import servicios.ContratoServicio;
import servicios.Globales;
import servicios.NTPTimeService;

public class Principal extends javax.swing.JFrame {

    ContratoServicio contServ = new ContratoServicio();
    List<Contrato> contratosPorVencer = new ArrayList<>();
    List<Contrato> contratosParaBaja = new ArrayList<>();
    List<Contrato> contratosParaAct = new ArrayList<>();
    LocalDate fechaActualizacionSuperada = null;
    BajaServicio bajaServ = new BajaServicio();
    String ntpServer = "time.google.com";
    Map<Contrato, LocalDate> fechasActualizacionContrato = new HashMap<>();

    NTPTimeService timeService = new NTPTimeService(ntpServer);

    LocalDate fechaSincronizada = timeService.obtenerFechaSincronizada();

    public Principal() {
        initComponents();
        Globales.comportamientoTextField(txtBusquedaCuit, "CUIT INQUILINO");
        Globales.comportamientoTextField(txtDireccionInmueble, "DIRECCION INMUEBLE");
        Globales.activarBuscarConEnterBtn(txtBusquedaCuit, btnBusquedaCuit);
        Globales.activarBuscarConEnterBtn(txtDireccionInmueble, btnBusquedaDireccion);
        CrudForm crud = new CrudForm(fechaSincronizada);
        crud.setSize(490, 480);
        crud.setLocation(0, 0);

        contentP.removeAll();
        contentP.add(crud, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        contentP.revalidate();
        contentP.repaint();

        lblFecha.setText("Fecha: " + fechaSincronizada);

        Timer timer;
        timer = new Timer(30000, new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                LocalDate fechaSincronizada = timeService.obtenerFechaSincronizada();
                List<Contrato> contratosVigentes = contServ.buscarVigentes(fechaSincronizada);
                contratosPorVencer.clear();
                contratosParaAct.clear();
                contratosParaBaja = contServ.buscarVencidos(fechaSincronizada);
                lblFecha.setText("Fecha: " + fechaSincronizada);

                for (Contrato cont : contratosParaBaja) {
                    cont.setAlta(false);

                    try {
                        contServ.editarContrato(cont);
                        bajaServ.guardar(cont, fechaSincronizada);

                    } catch (Exception ex) {
                        Logger.getLogger(ContBajas.class.getName()).log(Level.SEVERE, null, ex);
                        ex.printStackTrace();

                    }
                }
                for (Contrato contrato : contratosVigentes) {
                    long mesesContrato = contrato.getFechaFin().toEpochDay() - contrato.getFechaInicio().toEpochDay();
                    long actDisponiblesTotales = (mesesContrato / contrato.getIndexacionMeses()) - 1;
                    int indiceFechaActualizacion = contrato.getImportesAlquiler().size() - 1;
                    boolean notificarContrato = false;
                    LocalDate[] fechasActualizaciones = new LocalDate[(int) actDisponiblesTotales];
                    LocalDate fecha = contrato.getFechaInicio();
                    for (int i = 0; i < fechasActualizaciones.length; i++) {
                        fecha = fecha.plusMonths(contrato.getIndexacionMeses());
                        fechasActualizaciones[i] = fecha;
                    }

                    if (fechasActualizaciones[indiceFechaActualizacion].isBefore(fechaSincronizada)) {
                        notificarContrato = true;
                        fechaActualizacionSuperada = fechasActualizaciones[indiceFechaActualizacion];
                    } else if (fechasActualizaciones[indiceFechaActualizacion].isAfter(fechaSincronizada)
                            && fechasActualizaciones[indiceFechaActualizacion].toEpochDay() - fechaSincronizada.toEpochDay() <= 30) {
                        notificarContrato = true;
                        fechaActualizacionSuperada = fechasActualizaciones[indiceFechaActualizacion];
                    }

                    
                    if (notificarContrato && !contratosParaAct.contains(contrato)) {
                        contratosParaAct.add(contrato);
                        fechasActualizacionContrato.put(contrato, fechaActualizacionSuperada);
                    }
                    
                                    long diferenciaEnDias = contrato.getFechaFin().toEpochDay() - fechaSincronizada.toEpochDay();
                if (diferenciaEnDias <=30) {
                    contratosPorVencer.add(contrato);
                }

                }
  
                if (contratosPorVencer.isEmpty() && contratosParaAct.isEmpty()) {
                    lblNoti.setVisible(false);
                    lblNoNoti.setVisible(true);
                } else {
                    lblNoti.setVisible(true);
                    lblNoNoti.setVisible(false);
                }

              
            }
        });
        timer.getActionListeners()[0].actionPerformed(null);
        timer.start();

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
        jPanel2 = new javax.swing.JPanel();
        btnBusquedaDireccion = new javax.swing.JButton();
        btnBusquedaCuit = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        txtBusquedaCuit = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtDireccionInmueble = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnListInm = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        lblFecha = new javax.swing.JLabel();
        lblNoti = new javax.swing.JLabel();
        lblNoNoti = new javax.swing.JLabel();
        contentP = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 102, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 102, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnBusquedaDireccion.setBackground(new java.awt.Color(0, 102, 255));
        btnBusquedaDireccion.setForeground(new java.awt.Color(255, 255, 255));
        btnBusquedaDireccion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/search.png"))); // NOI18N
        btnBusquedaDireccion.setBorder(null);
        btnBusquedaDireccion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBusquedaDireccion.setFocusPainted(false);
        btnBusquedaDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBusquedaDireccionActionPerformed(evt);
            }
        });
        jPanel2.add(btnBusquedaDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 170, 30, 30));

        btnBusquedaCuit.setBackground(new java.awt.Color(0, 102, 255));
        btnBusquedaCuit.setForeground(new java.awt.Color(255, 255, 255));
        btnBusquedaCuit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/search.png"))); // NOI18N
        btnBusquedaCuit.setBorder(null);
        btnBusquedaCuit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBusquedaCuit.setFocusPainted(false);
        btnBusquedaCuit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBusquedaCuitActionPerformed(evt);
            }
        });
        jPanel2.add(btnBusquedaCuit, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 120, 30, 30));

        jSeparator3.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator3.setPreferredSize(new java.awt.Dimension(100, 10));
        jPanel2.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, 200, -1));

        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator2.setPreferredSize(new java.awt.Dimension(100, 10));
        jPanel2.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, 200, -1));

        txtBusquedaCuit.setBackground(new java.awt.Color(0, 102, 255));
        txtBusquedaCuit.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtBusquedaCuit.setForeground(new java.awt.Color(255, 255, 255));
        txtBusquedaCuit.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtBusquedaCuit.setText("CUIT INQUILINO");
        txtBusquedaCuit.setBorder(null);
        txtBusquedaCuit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBusquedaCuitActionPerformed(evt);
            }
        });
        jPanel2.add(txtBusquedaCuit, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, 180, 20));

        jLabel1.setBackground(new java.awt.Color(0, 102, 255));
        jLabel1.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("GESTION DE CONTRATOS 1.0");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 360, 50));

        txtDireccionInmueble.setBackground(new java.awt.Color(0, 102, 255));
        txtDireccionInmueble.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtDireccionInmueble.setForeground(new java.awt.Color(255, 255, 255));
        txtDireccionInmueble.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtDireccionInmueble.setText("DIRECCION INMUEBLE");
        txtDireccionInmueble.setBorder(null);
        txtDireccionInmueble.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionInmuebleActionPerformed(evt);
            }
        });
        jPanel2.add(txtDireccionInmueble, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, 180, 20));

        jLabel2.setBackground(new java.awt.Color(0, 153, 204));
        jLabel2.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("LISTAR:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 360, 20));

        btnListInm.setBackground(new java.awt.Color(0, 51, 153));
        btnListInm.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        btnListInm.setForeground(new java.awt.Color(255, 255, 255));
        btnListInm.setText("LISTAR TODOS LOS INMUEBLES");
        btnListInm.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnListInm.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnListInm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListInmActionPerformed(evt);
            }
        });
        jPanel2.add(btnListInm, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 410, 220, 40));

        jButton3.setBackground(new java.awt.Color(0, 51, 153));
        jButton3.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("LISTAR TODOS LOS INQUILINOS");
        jButton3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 360, 220, 40));

        jLabel3.setBackground(new java.awt.Color(0, 102, 255));
        jLabel3.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("BUSCAR CONTRATOS POR:");
        jLabel3.setOpaque(true);
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 360, 20));

        jButton4.setBackground(new java.awt.Color(102, 204, 0));
        jButton4.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("ALTAS,BAJAS,MODIFICACIONES");
        jButton4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, 220, 40));

        jButton5.setBackground(new java.awt.Color(0, 51, 153));
        jButton5.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("LISTAR TODOS LOS CONTRATOS");
        jButton5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 310, 220, 40));

        jButton2.setBackground(new java.awt.Color(255, 0, 51));
        jButton2.setFont(new java.awt.Font("Dialog", 0, 8)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("X");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 40, 30));

        lblFecha.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        lblFecha.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(lblFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 0, 130, 30));

        lblNoti.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/notification.png"))); // NOI18N
        lblNoti.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblNotiMouseClicked(evt);
            }
        });
        jPanel2.add(lblNoti, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, -1, -1));

        lblNoNoti.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/bell.png"))); // NOI18N
        jPanel2.add(lblNoNoti, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 360, 480));

        contentP.setBackground(new java.awt.Color(255, 255, 255));
        contentP.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(contentP, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 0, 470, 480));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        InqList inqList = new InqList();
        inqList.setSize(490, 480);
        inqList.setLocation(0, 0);

        contentP.removeAll();
        contentP.add(inqList, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        contentP.revalidate();
        contentP.repaint();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnListInmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListInmActionPerformed
        InmList inmList = new InmList();
        inmList.setSize(490, 480);
        inmList.setLocation(0, 0);

        contentP.removeAll();
        contentP.add(inmList, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        contentP.revalidate();
        contentP.repaint();
    }//GEN-LAST:event_btnListInmActionPerformed

    private void txtDireccionInmuebleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionInmuebleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionInmuebleActionPerformed

    private void txtBusquedaCuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBusquedaCuitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBusquedaCuitActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        CrudForm crud = new CrudForm(fechaSincronizada);
        crud.setSize(490, 480);
        crud.setLocation(0, 0);

        contentP.removeAll();
        contentP.add(crud, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        contentP.revalidate();
        contentP.repaint();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        ContrList contrList = new ContrList();
        contrList.setSize(490, 480);
        contrList.setLocation(0, 0);

        contentP.removeAll();
        contentP.add(contrList, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        contentP.revalidate();
        contentP.repaint();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void btnBusquedaDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBusquedaDireccionActionPerformed
        String direccion = txtDireccionInmueble.getText().trim();
        InmPage inmPage = new InmPage(direccion);
        inmPage.setSize(490, 480);
        inmPage.setLocation(0, 0);

        contentP.removeAll();
        contentP.add(inmPage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        contentP.revalidate();
        contentP.repaint();
    }//GEN-LAST:event_btnBusquedaDireccionActionPerformed

    private void btnBusquedaCuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBusquedaCuitActionPerformed
        String cuit = txtBusquedaCuit.getText().trim();
        InqPage inqPage = new InqPage(cuit);
        inqPage.setSize(490, 480);
        inqPage.setLocation(0, 0);

        contentP.removeAll();
        contentP.add(inqPage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        contentP.revalidate();
        contentP.repaint();
    }//GEN-LAST:event_btnBusquedaCuitActionPerformed

    private void lblNotiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNotiMouseClicked
        if (contratosPorVencer != null) {
            NotiPage notiPage = new NotiPage(contratosPorVencer, contratosParaAct, fechaSincronizada, fechasActualizacionContrato);
            notiPage.setSize(490, 480);
            notiPage.setLocation(0, 0);

            contentP.removeAll();
            contentP.add(notiPage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
            contentP.revalidate();
            contentP.repaint();
        }
    }//GEN-LAST:event_lblNotiMouseClicked

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBusquedaCuit;
    private javax.swing.JButton btnBusquedaDireccion;
    private javax.swing.JButton btnListInm;
    private javax.swing.JPanel contentP;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblNoNoti;
    private javax.swing.JLabel lblNoti;
    private javax.swing.JTextField txtBusquedaCuit;
    private javax.swing.JTextField txtDireccionInmueble;
    // End of variables declaration//GEN-END:variables
}
