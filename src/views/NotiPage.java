/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package views;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import javax.swing.table.DefaultTableModel;
import models.Contrato;
import models.Inquilino;
import servicios.ContratoServicio;
import servicios.Globales;
import servicios.InquilinoServicio;

/**
 *
 * @author Nelkha
 */
public class NotiPage extends javax.swing.JPanel {

    ContratoServicio contServ = new ContratoServicio();
    DefaultTableModel dtm = new DefaultTableModel();

    public NotiPage(List<Contrato> contratosPorVencer, List<Contrato> contratosPorActualizar, LocalDate fechaSincronizada, Map<Contrato, LocalDate> fechasActualizacionContrato) {
        initComponents();
        String[] titulos = new String[]{"ID", "INM", "I.ACTUAL", "ACTUALIZAR", "VENCE"};
        dtm.setColumnIdentifiers(titulos);

        tblContInq.setModel(dtm);
        tblContInq.getColumnModel().getColumn(0).setPreferredWidth(5); // ID
        tblContInq.getColumnModel().getColumn(1).setPreferredWidth(125); // DIRECCION
        tblContInq.getColumnModel().getColumn(2).setPreferredWidth(55);
        tblContInq.getColumnModel().getColumn(3).setPreferredWidth(50);
        tblContInq.getColumnModel().getColumn(4).setPreferredWidth(50);

        // Formatear el BigDecimal
        DecimalFormat formato = new DecimalFormat("#,##0.00");

        for (Contrato cont : contratosPorVencer) {
            long diferenciaEnDias = cont.getFechaFin().toEpochDay() - fechaSincronizada.toEpochDay();

            String diasMensaje = (diferenciaEnDias == 0) ? "HOY" : "En " + diferenciaEnDias + " dias";

            dtm.addRow(new Object[]{cont.getId(), cont.getInmueble().getDireccion(),
                "$ " + formato.format(BigDecimal.valueOf(cont.getMontoAlquiler())), "-", diasMensaje});
        }

        for (Contrato cont : contratosPorActualizar) {
            LocalDate fechaActualizacionContrato = fechasActualizacionContrato.get(cont);

            long diferenciaEnDiasA = fechaActualizacionContrato.toEpochDay() - fechaSincronizada.toEpochDay();

            String diasMensajeA = (diferenciaEnDiasA == 0) ? "HOY" : "En " + diferenciaEnDiasA + " dias";

            Object[] rowData = new Object[]{cont.getId(), cont.getInmueble().getDireccion(),
                "$ " + formato.format(BigDecimal.valueOf(cont.getMontoAlquiler())), diasMensajeA, "-"};

            dtm.addRow(rowData);
        
        }}

        /**
         * This method is called from within the constructor to initialize the
         * form. WARNING: Do NOT modify this code. The content of this method is
         * always regenerated by the Form Editor.
         */
        @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contentPI = new javax.swing.JPanel();
        lblInqTitle = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblContInq = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaDetalles = new javax.swing.JTextArea();
        lblInqTitle1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 0, 0));
        setMinimumSize(new java.awt.Dimension(490, 480));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(490, 480));
        setRequestFocusEnabled(false);
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        contentPI.setBackground(new java.awt.Color(255, 255, 255));
        contentPI.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblInqTitle.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        lblInqTitle.setForeground(new java.awt.Color(204, 0, 0));
        lblInqTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblInqTitle.setText("VENCIMIENTO Y ACTUALIZACIONES");
        contentPI.add(lblInqTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 460, 30));

        tblContInq.setModel(new javax.swing.table.DefaultTableModel(
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
        tblContInq.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblContInqMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblContInq);

        contentPI.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, 180));

        txaDetalles.setEditable(false);
        txaDetalles.setColumns(20);
        txaDetalles.setRows(5);
        txaDetalles.setBorder(null);
        jScrollPane1.setViewportView(txaDetalles);

        contentPI.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 230, 180));

        lblInqTitle1.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        lblInqTitle1.setForeground(new java.awt.Color(204, 0, 0));
        lblInqTitle1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblInqTitle1.setText("DETALLES");
        contentPI.add(lblInqTitle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 460, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/info.png"))); // NOI18N
        contentPI.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 320, -1, -1));

        add(contentPI, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 460, 460));
    }// </editor-fold>//GEN-END:initComponents

    private void tblContInqMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblContInqMouseClicked
        int selectedRow = tblContInq.getSelectedRow();
        if (selectedRow >= 0) {
            long idCont = (long) tblContInq.getValueAt(selectedRow, 0);
            Contrato contrato = contServ.buscarContratoPorId(idCont);
            String importesText = Globales.mostrarImportesAnteriores(contrato);
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
                    + "Importes historicos: " + "\n" + importesText + "\n"
                    + baja + "\n"
                    + "Garante: " + contrato.getGarante().getNombre() + " " + contrato.getGarante().getApellido()
            );

        }


    }//GEN-LAST:event_tblContInqMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel contentPI;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblInqTitle;
    private javax.swing.JLabel lblInqTitle1;
    private javax.swing.JTable tblContInq;
    private javax.swing.JTextArea txaDetalles;
    // End of variables declaration//GEN-END:variables
}
