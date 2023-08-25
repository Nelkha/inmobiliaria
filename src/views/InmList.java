/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package views;

import java.util.List;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import models.Inmueble;
import servicios.InmuebleServicio;

/**
 *
 * @author Nelkha
 */
public class InmList extends javax.swing.JPanel {

    InmuebleServicio inmServ = new InmuebleServicio();
    DefaultTableModel dtm = new DefaultTableModel();
    List<Inmueble> inmuebles = inmServ.consultaTodos();

    private void actualizarTabla() {
        String filtroNombre = txtFiltro.getText().toUpperCase().trim();

        dtm.setRowCount(0);

        for (Inmueble inm : inmuebles) {
            String direccion = inm.getDireccion().toUpperCase();
           

            boolean cumpleFiltroNombre = filtroNombre.isEmpty() || !filtroNombre.equals("FILTRAR POR DIRECCION");
            if (cumpleFiltroNombre) {

                if (direccion.contains(filtroNombre)) {
                    dtm.addRow(new Object[]{inm.getId(), inm.getDireccion(), inm.altaObaja(inm)});
                }

            } else {

                dtm.addRow(new Object[]{inm.getId(), inm.getDireccion(), inm.altaObaja(inm)});

            }

        }
    }

    public InmList() {
        initComponents();
        String[] titulos = new String[]{"ID", "DIRECCION", "ALTA/BAJA"};
        dtm.setColumnIdentifiers(titulos);
 txtFiltro.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                actualizarTabla();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                actualizarTabla();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                actualizarTabla();
            }
        });
        tblInm.setModel(dtm);
        tblInm.getColumnModel().getColumn(0).setPreferredWidth(15); // ID
        tblInm.getColumnModel().getColumn(1).setPreferredWidth(250); // DIRECCION
        tblInm.getColumnModel().getColumn(2).setPreferredWidth(15);
        actualizarTabla();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contentPI = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblInm = new javax.swing.JTable();
        txtFiltro = new javax.swing.JTextField();

        setBackground(new java.awt.Color(0, 0, 0));
        setMinimumSize(new java.awt.Dimension(490, 480));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(490, 480));
        setRequestFocusEnabled(false);
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        contentPI.setBackground(new java.awt.Color(255, 255, 255));
        contentPI.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("LISTADO DE INMUEBLES");
        contentPI.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 460, -1));

        tblInm.setBackground(new java.awt.Color(255, 255, 255));
        tblInm.setForeground(new java.awt.Color(0, 0, 0));
        tblInm.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblInm);

        contentPI.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 450, 390));

        txtFiltro.setText("Filtrar por direccion");
        contentPI.add(txtFiltro, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 130, 20));

        add(contentPI, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 460, 460));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel contentPI;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblInm;
    private javax.swing.JTextField txtFiltro;
    // End of variables declaration//GEN-END:variables
}
