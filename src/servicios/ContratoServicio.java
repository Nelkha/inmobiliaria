/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicios;

import controladores.ContratoJpaController;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import models.Contrato;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

/**
 *
 * @author Mario
 */
public class ContratoServicio {

    ContratoJpaController contratoJpa = new ContratoJpaController();

    public List<Contrato> consultaTodos() {
        return contratoJpa.findContratoEntities();
    }

    public boolean guardar(Contrato contrato) {
        try {
            contratoJpa.create(contrato);
            return true;
        } catch (Exception e) {

            return false;
        }

    }

    public Contrato buscarContratoPorId(long id) {
        return contratoJpa.findContrato(id);

    }

    public void editarContrato(Contrato contrato) throws Exception {
        contratoJpa.edit(contrato);
    }

    public List<Contrato> buscarVigentes(LocalDate fechaActual) {
        List<Contrato> contratosFechaVigente = contratoJpa.findVigentes(fechaActual);
        List<Contrato> contratosVigentes = new ArrayList<>();
        for (Contrato contrato : contratosFechaVigente) {
            if (contrato.isAlta()) {
                contratosVigentes.add(contrato);
            }
        }
        return contratosVigentes;
    }

    public List<Contrato> buscarVencidos(LocalDate fechaActual) {
        List<Contrato> contratosFechaVencidos = contratoJpa.findVencidos(fechaActual);
        List<Contrato> contratosVencidos = new ArrayList<>();
        for (Contrato contrato : contratosFechaVencidos) {
            if (contrato.isAlta()) {
                contratosVencidos.add(contrato);
            }
        }
        return contratosVencidos;
    }

    public void generarContrato(String rutaBase, Contrato contrato, String destino, String hInq, String hGar, String rutaDestino, LocalDate fechaFirma) {
        try {
            String documentosDir = System.getProperty("user.home") + "\\Documents";
            FileInputStream fis = new FileInputStream(rutaBase);

            XWPFDocument document = new XWPFDocument(fis);
            Path carpetaContratos = Paths.get(documentosDir, "Contratos");

            if (Files.notExists(carpetaContratos)) {
                Files.createDirectories(carpetaContratos);
            }

            // Datos del inquilino
            String nombreInquilino = contrato.getInquilino().getApellido() + ", " + contrato.getInquilino().getNombre();
            String direccionInmueble = contrato.getInmueble().getDireccion();
            String telefonoInquilino = contrato.getInquilino().getTelefono();
            String cuitInquilino = contrato.getInquilino().getCuit();
            String cuitGarante = contrato.getGarante().getCuit();
            String telefonoGarante = contrato.getGarante().getTelefono();
            String direccionGarante = contrato.getGarante().getDireccion();
            String mesInicio = String.valueOf(contrato.getFechaInicio().getMonthValue());
            String anioInicio = String.valueOf(contrato.getFechaInicio().getYear());
            String diaInicio = String.valueOf(contrato.getFechaInicio().getDayOfMonth());
            String hInqr = hInq;
            String hGarr = hGar;
            String destinoInm = destino;
            String diferenciaEnMeses = String.valueOf(ChronoUnit.MONTHS.between(contrato.getFechaFin(), contrato.getFechaInicio()));
            String mesFin = String.valueOf(contrato.getFechaFin().getMonthValue());
            String anioFin = String.valueOf(contrato.getFechaFin().getYear());
            String diaFin = String.valueOf(contrato.getFechaFin().getDayOfMonth());
            for (XWPFParagraph paragraph : document.getParagraphs()) {
                for (XWPFRun run : paragraph.getRuns()) {
                    String text = run.getText(0);
                    if (text != null && text.contains("[INQUILINO]")) {
                        text = text.replace("[INQUILINO]", nombreInquilino);
                        run.setText(text, 0);
                    }
                    if (text != null && text.contains("[CUIT]")) {
                        text = text.replace("[CUIT]", cuitInquilino);
                        run.setText(text, 0);
                    }
                     if (text != null && text.contains("[TELEFONO INQUILINO]")) {
                        text = text.replace("[TELEFONO INQUILINO]", telefonoInquilino);
                        run.setText(text, 0);
                    }
                   
                   
                    if (text != null && text.contains("[DESTINO]")) {
                        text = text.replace("[DESTINO]", destinoInm);
                        run.setText(text, 0);
                    }
                    if (text != null && text.contains("[DIRECCIONI]")) {
                        text = text.replace("[DIRECCIONI]", direccionInmueble);
                        run.setText(text, 0);
                    }
                    if (text != null && text.contains("([MESES NRO]")) {
                        text = text.replace("([MESES NRO]", diferenciaEnMeses);
                        run.setText(text, 0);
                    }
                    if (text != null && text.contains("([DIA INICIO]")) {
                        text = text.replace("([DIA INICIO]", diaInicio);
                        run.setText(text, 0);
                    }
                    if (text != null && text.contains("([MES INICIO]")) {
                        text = text.replace("([MES INICIO]", mesInicio);
                        run.setText(text, 0);
                    }
                    if (text != null && text.contains("([ANIO INICIO]")) {
                        text = text.replace("([ANIO INICIO]", anioInicio);
                        run.setText(text, 0);
                    }
                    if (text != null && text.contains("([DIA FIN]")) {
                        text = text.replace("([DIA FIN]", diaFin);
                        run.setText(text, 0);
                    }
                    if (text != null && text.contains("([MES FIN]")) {
                        text = text.replace("([MES FIN]", mesFin);
                        run.setText(text, 0);
                    }
                    if (text != null && text.contains("([ANIO FIN]")) {
                        text = text.replace("([ANIO FIN]", anioFin);
                        run.setText(text, 0);
                    }
                    if (text != null && text.contains("([MONTO INICIAL]")) {
                        text = text.replace("([MONTO INICIAL]", String.valueOf(contrato.getMontoAlquiler()));
                        run.setText(text, 0);
                    }
                    if (text != null && text.contains("([CANT MESES]")) {
                        text = text.replace("([CANT MESES]", String.valueOf(contrato));
                        run.setText(text, 0);
                    }
                    if (text != null && text.contains("([GARANTE]")) {
                        text = text.replace("([GARANTE]", contrato.getGarante().getApellido() + ", " + contrato.getGarante().getNombre());
                        run.setText(text, 0);
                    }
                    if (text != null && text.contains("([CUIT GARANTE]")) {
                        text = text.replace("([CUIT GARANTE]", cuitGarante);
                        run.setText(text, 0);
                    }
                    if (text != null && text.contains("([DIRECCION GARANTE]")) {
                        text = text.replace("([DIRECCION GARANTE]", direccionGarante);
                        run.setText(text, 0);
                    }
                       if (text != null && text.contains("([TELEFONO GARANTE]")) {
                        text = text.replace("([TELEFONO GARANTE]", telefonoGarante);
                        run.setText(text, 0);
                    }
                }
            }

            // Guardar el documento modificado en formato Word
            String filePathModificado = documentosDir+"\\Contratos\\"+"Contrato "+nombreInquilino+" "+diaInicio+"-"+mesInicio+"-"+anioInicio+".docx";
            FileOutputStream fos = new FileOutputStream(filePathModificado);
            document.write(fos);
            fos.close();
            fis.close();

            System.out.println("Documento modificado guardado correctamente en formato Word en: " + filePathModificado);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
