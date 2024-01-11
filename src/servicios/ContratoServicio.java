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
            System.out.println(nombreInquilino);

            String direccionInmueble = contrato.getInmueble().getDireccion();
            System.out.println(direccionInmueble);

            String telefonoInquilino = contrato.getInquilino().getTelefono();
            System.out.println(telefonoInquilino);

            String cuitInquilino = contrato.getInquilino().getCuit();
            System.out.println(cuitInquilino);

            String cuitGarante = contrato.getGarante().getCuit();
            System.out.println(cuitGarante);

            String telefonoGarante = contrato.getGarante().getTelefono();
            System.out.println(telefonoGarante);

            String direccionGarante = contrato.getGarante().getDireccion();
            System.out.println(direccionGarante);

            String mesInicio = String.valueOf(contrato.getFechaInicio().getMonthValue());
            System.out.println(mesInicio);

            String anioInicio = String.valueOf(contrato.getFechaInicio().getYear());
            System.out.println(anioInicio);

            String diaInicio = String.valueOf(contrato.getFechaInicio().getDayOfMonth());
            System.out.println(diaInicio);

            String cantMeses = String.valueOf(contrato.getIndexacionMeses());
            System.out.println(cantMeses);

            String hInqr = hInq;
            System.out.println(hInqr);

            String hGarr = hGar;
            System.out.println(hGarr);

            String destinoInm = destino;
            System.out.println(destinoInm);

            String diferenciaEnMeses = String.valueOf(ChronoUnit.MONTHS.between(contrato.getFechaInicio(), contrato.getFechaFin()) + 1);
            System.out.println(diferenciaEnMeses);

            String mesFin = String.valueOf(contrato.getFechaFin().getMonthValue());
            System.out.println(mesFin);
            String montoAlquiler = String.valueOf(contrato.getMontoAlquiler());
            String nombreGarante = contrato.getGarante().getApellido() + ", " + contrato.getGarante().getNombre();
            String anioFin = String.valueOf(contrato.getFechaFin().getYear());
            System.out.println(anioFin);

            String diaFin = String.valueOf(contrato.getFechaFin().getDayOfMonth());
            System.out.println(diaFin);
            String art, gart, gen, ggen, ggen2, dest;

            art = hInqr.equalsIgnoreCase("SR.") ? "EL" : (hInqr.equalsIgnoreCase("SRA.") ? "LA" : "");
            System.out.println(art);

            gen = hInqr.equalsIgnoreCase("SR.") ? "O" : (hInqr.equalsIgnoreCase("SRA.") ? "A" : "");
            System.out.println(gen);

            ggen = hGarr.equalsIgnoreCase("SR.") ? "o" : (hInqr.equalsIgnoreCase("SRA.") ? "a" : "");
            System.out.println(ggen);

            gart = hGarr.equalsIgnoreCase("SR.") ? "el" : (hInqr.equalsIgnoreCase("SRA.") ? "la" : "");
            System.out.println(gart);

            ggen2 = hGarr.equalsIgnoreCase("SR.") ? " " : (hInqr.equalsIgnoreCase("SRA.") ? "a" : "");
            System.out.println(ggen2);
            dest = destino;
            System.out.println(dest);
            String mesesLetras = Globales.convertirNumeroALetras(Integer.parseInt(diferenciaEnMeses));
            System.out.println(mesesLetras);

            for (XWPFParagraph paragraph : document.getParagraphs()) {
                for (XWPFRun run : paragraph.getRuns()) {
                    String text = run.getText(0);
                    if (text != null) {
                        text = reemplazarEtiquetas(text, nombreInquilino, cuitInquilino, telefonoInquilino,
                                dest, direccionInmueble, diferenciaEnMeses, diaInicio, mesInicio,
                                anioInicio, diaFin, mesFin, anioFin, montoAlquiler, cantMeses, nombreGarante,
                                cuitGarante, direccionGarante, telefonoGarante, hInqr,
                                hGarr, gen, ggen, ggen2, art, gart, dest, mesesLetras
                        );

                        run.setText(text, 0);
                    }
                }
            }

            // Guardar el documento modificado en formato Word
            String filePathModificado = documentosDir + "\\Contratos\\" + "Contrato " + nombreInquilino + " " + diaInicio + "-" + mesInicio + "-" + anioInicio + ".docx";
            FileOutputStream fos = new FileOutputStream(filePathModificado);
            document.write(fos);
            fos.close();
            fis.close();

            System.out.println("Documento modificado guardado correctamente en formato Word en: " + filePathModificado);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private String reemplazarEtiquetas(String text, String nombreInquilino, String cuitInquilino, String telefonoInquilino,
            String destinoInm, String direccionInmueble, String diferenciaEnMeses, String diaInicio, String mesInicio,
            String anioInicio, String diaFin, String mesFin, String anioFin, String montoAlquiler, String cantMeses,
            String nombreGarante, String cuitGarante, String direccionGarante, String telefonoGarante, String hInqr,
            String hGarr, String gen, String ggen, String ggen2, String art, String gart, String dest, String mesesLetras) {

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

        for (String etiqueta : etiquetas.keySet()) {
            if (text.contains(etiqueta)) {
                text = text.replace(etiqueta, etiquetas.get(etiqueta));
                System.out.println(text);
            }
        }
        System.out.println("FINAL STRING..." + text);

        return text;
    }

}
