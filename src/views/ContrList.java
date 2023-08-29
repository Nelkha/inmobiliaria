/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package views;

import java.util.List;
import java.util.Locale;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import models.Contrato;
import servicios.ContratoServicio;
import static servicios.Globales.comportamientoTextField;

/**
 *
 * @author Nelkha
 */
public class ContrList extends javax.swing.JPanel {

    ContratoServicio contServ = new ContratoServicio();
    DefaultTableModel dtm = new DefaultTableModel();
    List<Contrato> contratos = contServ.consultaTodos();

    private void actualizarTabla() {
        String filtroNombre = txtFiltro.getText().toUpperCase().trim();
        boolean mostrarVigentes = rbtnVig.isSelected();
        boolean mostrarNoVigentes = rbtnNoVig.isSelected();
        boolean mostrarTodos = rbtnAll.isSelected();

        dtm.setRowCount(0);

        for (Contrato cont : contratos) {
            String nombreCompleto = cont.getInquilino().getNombre() + " " + cont.getInquilino().getApellido();
            nombreCompleto = nombreCompleto.toUpperCase().trim();
            boolean esVigente = cont.isAlta();
            boolean mostrarContrato = mostrarTodos
                    || (mostrarVigentes && esVigente)
                    || (mostrarNoVigentes && !esVigente);
            boolean cumpleFiltroNombre = filtroNombre.isEmpty() || !filtroNombre.equals("FILTRAR POR NOMBRE");
            if (cumpleFiltroNombre) {

                if (mostrarContrato && nombreCompleto.contains(filtroNombre.toUpperCase())) {
                    dtm.addRow(new Object[]{cont.getId(), nombreCompleto, cont.getInmueble().getDireccion(), cont.getIndexacionMeses()});
                }

            } else {
                if (mostrarContrato) {
                    dtm.addRow(new Object[]{cont.getId(), nombreCompleto, cont.getInmueble().getDireccion(), cont.getIndexacionMeses()});
                }

            }

        }
    }

    public ContrList() {
        initComponents();
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
        comportamientoTextField(txtFiltro, "Filtrar por nombre");
        String[] titulos = new String[]{"C. ID", "INQUILINO", "INMUEBLE", "INDEX"};
        dtm.setColumnIdentifiers(titulos);

        tblCont.setModel(dtm);
        tblCont.getColumnModel().getColumn(0).setPreferredWidth(5);
        tblCont.getColumnModel().getColumn(1).setPreferredWidth(125);
        tblCont.getColumnModel().getColumn(2).setPreferredWidth(125);
        tblCont.getColumnModel().getColumn(3).setPreferredWidth(5);
        actualizarTabla();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        contentPI = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCont = new javax.swing.JTable();
        txtFiltro = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txaDetalles = new javax.swing.JTextArea();
        lblInqTitle1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        rbtnNoVig = new javax.swing.JRadioButton();
        rbtnAll = new javax.swing.JRadioButton();
        rbtnVig = new javax.swing.JRadioButton();

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
        jLabel1.setText("LISTADO DE CONTRATOS");
        contentPI.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 460, -1));

        tblCont.setBackground(new java.awt.Color(255, 255, 255));
        tblCont.setForeground(new java.awt.Color(0, 0, 0));
        tblCont.setModel(new javax.swing.table.DefaultTableModel(
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
        tblCont.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblContMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCont);

        contentPI.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 450, 170));

        txtFiltro.setText("Filtrar por nombre");
        contentPI.add(txtFiltro, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 130, 20));

        txaDetalles.setEditable(false);
        txaDetalles.setColumns(20);
        txaDetalles.setRows(5);
        txaDetalles.setBorder(null);
        jScrollPane2.setViewportView(txaDetalles);

        contentPI.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 230, 180));

        lblInqTitle1.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        lblInqTitle1.setForeground(new java.awt.Color(204, 0, 0));
        lblInqTitle1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblInqTitle1.setText("DETALLES");
        contentPI.add(lblInqTitle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 460, 30));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/info.png"))); // NOI18N
        contentPI.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 320, -1, -1));

        rbtnNoVig.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rbtnNoVig);
        rbtnNoVig.setForeground(new java.awt.Color(51, 51, 51));
        rbtnNoVig.setText("NO VIGENTES");
        rbtnNoVig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnNoVigActionPerformed(evt);
            }
        });
        contentPI.add(rbtnNoVig, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 40, -1, 20));

        rbtnAll.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rbtnAll);
        rbtnAll.setForeground(new java.awt.Color(51, 51, 51));
        rbtnAll.setSelected(true);
        rbtnAll.setText("TODOS");
        rbtnAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnAllActionPerformed(evt);
            }
        });
        contentPI.add(rbtnAll, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, 90, 20));

        rbtnVig.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rbtnVig);
        rbtnVig.setForeground(new java.awt.Color(51, 51, 51));
        rbtnVig.setText("VIGENTES");
        rbtnVig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnVigActionPerformed(evt);
            }
        });
        contentPI.add(rbtnVig, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 40, 90, 20));

        add(contentPI, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 460, 460));
    }// </editor-fold>//GEN-END:initComponents

    private void tblContMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblContMouseClicked
        int selectedRow = tblCont.getSelectedRow();
        if (selectedRow >= 0) {
            long idCont = (long) tblCont.getValueAt(selectedRow, 0);
            Contrato contrato = contServ.buscarContratoPorId(idCont);
            StringBuilder importesText = new StringBuilder();
            for (Double importe : contrato.getImportesAlquiler()) {
                importesText.append(importe).append(", ");
            }
            String baja;
            if (contrato.getBaja() != null) {
                baja = "Fecha baja: " + contrato.getBaja().getFechaBaja();
                
            } else {
                baja = "Fecha baja: Sigue vigente";
            }
            txaDetalles.setText("ID Contrato: " + contrato.getId() + "\n"
                    + "Inquilino: " + contrato.getInquilino().getNombre() + " " + contrato.getInquilino().getApellido() + "\n"
                    + "Inmueble: " + contrato.getInmueble().getDireccion() + "\n"
                    + "Fecha de Inicio: " + contrato.getFechaInicio() + "\n"
                    + "Fecha de Fin: " + contrato.getFechaFin() + "\n"
                    + "Monto Actual: " + contrato.getMontoAlquiler() + "\n"
                    + "Index Meses: " + contrato.getIndexacionMeses() + "\n"
                    + "Importes historicos: " + importesText.toString() + "\n"
                    + baja
            );

        }
    }//GEN-LAST:event_tblContMouseClicked

    private void rbtnNoVigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnNoVigActionPerformed
        actualizarTabla();
    }//GEN-LAST:event_rbtnNoVigActionPerformed

    private void rbtnAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnAllActionPerformed
        actualizarTabla();
    }//GEN-LAST:event_rbtnAllActionPerformed

    private void rbtnVigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnVigActionPerformed
        actualizarTabla();
    }//GEN-LAST:event_rbtnVigActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel contentPI;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblInqTitle1;
    private javax.swing.JRadioButton rbtnAll;
    private javax.swing.JRadioButton rbtnNoVig;
    private javax.swing.JRadioButton rbtnVig;
    private javax.swing.JTable tblCont;
    private javax.swing.JTextArea txaDetalles;
    private javax.swing.JTextField txtFiltro;
    // End of variables declaration//GEN-END:variables
}
