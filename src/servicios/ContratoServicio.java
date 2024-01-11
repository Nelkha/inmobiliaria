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
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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

    public void generarContrato(String rutaBase, Contrato contrato, String destino, String hInq, String hGar, LocalDate fechaFirma) {
        try {
            String documentosDir = System.getProperty("user.home") + "\\Documents";
            FileInputStream fis = new FileInputStream(rutaBase);

            XWPFDocument document = new XWPFDocument(fis);
            Path carpetaContratos = Paths.get(documentosDir, "Contratos");

            if (Files.notExists(carpetaContratos)) {
                Files.createDirectories(carpetaContratos);
            }

            String nombreInquilino = contrato.getInquilino().getApellido() + ", " + contrato.getInquilino().getNombre();

            String direccionInmueble = contrato.getInmueble().getDireccion();

            String telefonoInquilino = contrato.getInquilino().getTelefono();

            String cuitInquilino = contrato.getInquilino().getCuit();

            String cuitGarante = contrato.getGarante().getCuit();

            String telefonoGarante = contrato.getGarante().getTelefono();

            String direccionGarante = contrato.getGarante().getDireccion();
            String diaFin = (contrato.getFechaFin().getDayOfMonth() < 10)
                    ? "0" + contrato.getFechaFin().getDayOfMonth()
                    : String.valueOf(contrato.getFechaFin().getDayOfMonth());
            String mesInicio = obtenerNombreMes(contrato.getFechaInicio().getMonthValue());
            String mesFin = obtenerNombreMes(contrato.getFechaFin().getMonthValue());

            String anioInicio = String.valueOf(contrato.getFechaInicio().getYear());
            String anioFin = String.valueOf(contrato.getFechaFin().getYear());

            String diaInicio = (contrato.getFechaInicio().getDayOfMonth() < 10)
                    ? "0" + contrato.getFechaInicio().getDayOfMonth()
                    : String.valueOf(contrato.getFechaInicio().getDayOfMonth());

            String cantMeses = String.valueOf(contrato.getIndexacionMeses());
            String diaFirma = (fechaFirma.getDayOfMonth() < 10)
                    ? "0" + fechaFirma.getDayOfMonth()
                    : String.valueOf(fechaFirma.getDayOfMonth());
            String mesFirma = obtenerNombreMes(fechaFirma.getMonthValue());
            String anioFirma = String.valueOf(fechaFirma.getYear());
            String hInqr = hInq;

            String hGarr = hGar;

            String diferenciaEnMeses = String.valueOf(ChronoUnit.MONTHS.between(contrato.getFechaInicio(), contrato.getFechaFin()) + 1);

            String montoAlquiler = String.valueOf(contrato.getMontoAlquiler());
            String nombreGarante = contrato.getGarante().getApellido() + ", " + contrato.getGarante().getNombre();

            String art, gart, gen, ggen, ggen2, dest;

            art = hInqr.equalsIgnoreCase("SR.") ? "EL" : (hInqr.equalsIgnoreCase("SRA.") ? "LA" : "");

            gen = hInqr.equalsIgnoreCase("SR.") ? "O" : (hInqr.equalsIgnoreCase("SRA.") ? "A" : "");

            ggen = hGarr.equalsIgnoreCase("SR.") ? "o" : (hGarr.equalsIgnoreCase("SRA.") ? "a" : "");

            gart = hGarr.equalsIgnoreCase("SR.") ? "el" : (hGarr.equalsIgnoreCase("SRA.") ? "la" : "");

            ggen2 = hGarr.equalsIgnoreCase("SR.") ? " " : (hGarr.equalsIgnoreCase("SRA.") ? "a" : "");

            dest = destino;

            String mesesLetras = Globales.convertirNumeroALetras(Integer.parseInt(diferenciaEnMeses));

            for (XWPFParagraph paragraph : document.getParagraphs()) {
                // Clona el párrafo original
                XWPFParagraph newParagraph = document.createParagraph();
                newParagraph.getCTP().setPPr(paragraph.getCTP().getPPr());

                StringBuilder paragraphText = new StringBuilder();

                for (XWPFRun run : paragraph.getRuns()) {
                    String text = run.getText(0);
                    if (text != null) {
                        paragraphText.append(text);
                    }
                }

                String text = paragraphText.toString().trim();
                System.out.println(text);

                // Reemplaza "null" por guiones solo en líneas vacías
                if (text.isEmpty()) {
                    text = "-";
                } else {
                    text = reemplazarEtiquetas(text, nombreInquilino, cuitInquilino, telefonoInquilino,
                            dest, direccionInmueble, diferenciaEnMeses, diaInicio, mesInicio,
                            anioInicio, diaFin, mesFin, anioFin, montoAlquiler, cantMeses, nombreGarante,
                            cuitGarante, direccionGarante, telefonoGarante, hInqr,
                            hGarr, gen, ggen, ggen2, art, gart, dest, mesesLetras, diaFirma, mesFirma, anioFirma
                    );
                }

                // Elimina todo el contenido del párrafo original
                for (int i = paragraph.getRuns().size() - 1; i >= 0; i--) {
                    paragraph.removeRun(i);
                }

                // Agrega el nuevo contenido al párrafo original
                XWPFRun newRun = newParagraph.createRun();
                newRun.setText(text, 0);
            }

            // Guardar el documento modificado en formato Word
            String filePathModificado = documentosDir + "\\Contratos\\" + "Contrato " + nombreInquilino + " " + diaInicio + "-" + mesInicio + "-" + anioInicio + ".docx";
            FileOutputStream fos = new FileOutputStream(filePathModificado);
            document.write(fos);
            fos.close();
            fis.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private String reemplazarEtiquetas(String text, String nombreInquilino, String cuitInquilino, String telefonoInquilino,
            String destinoInm, String direccionInmueble, String diferenciaEnMeses, String diaInicio, String mesInicio,
            String anioInicio, String diaFin, String mesFin, String anioFin, String montoAlquiler, String cantMeses,
            String nombreGarante, String cuitGarante, String direccionGarante, String telefonoGarante, String hInqr,
            String hGarr, String gen, String ggen, String ggen2, String art, String gart, String dest, String mesesLetras, String diaFirma, String mesFirma, String anioFirma) {

        Map<String, String> etiquetas = new HashMap<>();

        // Puedes agregar más etiquetas y valores de reemplazo según tus necesidades
        etiquetas.put("[1]", nombreInquilino);
        etiquetas.put("[2]", cuitInquilino);
        etiquetas.put("[3]", telefonoInquilino);
        etiquetas.put("[4]", destinoInm);
        etiquetas.put("[5]", direccionInmueble);
        etiquetas.put("[6]", diferenciaEnMeses);
        etiquetas.put("[7]", diaInicio);
        etiquetas.put("[8]", mesInicio);
        etiquetas.put("[9]", anioInicio);
        etiquetas.put("[10]", diaFin);
        etiquetas.put("[11]", mesFin);
        etiquetas.put("[12]", anioFin);
        etiquetas.put("[13]", montoAlquiler);
        etiquetas.put("[14]", cantMeses);
        etiquetas.put("[15]", nombreGarante);
        etiquetas.put("[16]", cuitGarante);
        etiquetas.put("[17]", direccionGarante);
        etiquetas.put("[18]", telefonoGarante);
        etiquetas.put("[19]", hInqr);
        etiquetas.put("[20]", hGarr);
        etiquetas.put("[21]", gen);
        etiquetas.put("[22]", ggen);
        etiquetas.put("[23]", ggen2);
        etiquetas.put("[24]", art);
        etiquetas.put("[25]", gart);
        etiquetas.put("[26]", dest);
        etiquetas.put("[27]", mesesLetras);
        etiquetas.put("[28]", diaFirma);
        etiquetas.put("[29]", mesFirma);
        etiquetas.put("[30]", anioFirma);

        for (Map.Entry<String, String> entry : etiquetas.entrySet()) {
            String etiqueta = entry.getKey();
            String valorReemplazo = entry.getValue();
            text = text.replaceAll(Pattern.quote(etiqueta), Matcher.quoteReplacement(valorReemplazo));
        }

        return text;
    }

    private static String obtenerNombreMes(int numeroMes) {

        String[] nombresMeses = {"ENERO", "FEBRERO", "MARZO", "ABRIL", "MAYO", "JUNIO", "JULIO", "AGOSTO", "SEPTIEMBRE", "OCTUBRE", "NOVIEMBRE", "DICIEMBRE"};

        return nombresMeses[numeroMes - 1];
    }

}
