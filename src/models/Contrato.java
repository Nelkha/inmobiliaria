package models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author Mario
 */
@Entity
public class Contrato implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "inquilino_id")
    private Inquilino inquilino;

    @ManyToOne
    @JoinColumn(name = "inmueble_id")
    private Inmueble inmueble;

    @Column(nullable = false)
    private LocalDate fechaInicio;

    @Column(nullable = false)
    private LocalDate fechaFin;

    @Column(nullable = false)
    private double montoAlquiler;

    @Column(nullable = false)
    private int indexacionMeses;

    @Column(nullable = false)
    private boolean alta;

    @ElementCollection
    @CollectionTable(name = "importes_alquiler", joinColumns = @JoinColumn(name = "contrato_id"))
    @Column(name = "importe")
    private List<Double> importesAlquiler;

    @OneToOne(mappedBy = "contrato")
    private Baja baja;

    public Baja getBaja() {
        return baja;
    }

    public void setBaja(Baja baja) {
        this.baja = baja;
    }

    public Contrato() {
    }

    public Contrato(Inquilino inquilino, Inmueble inmueble, LocalDate fechaInicio, LocalDate fechaFin, double montoAlquiler, int indexacionMeses, boolean alta, List<Double> importesAlquiler) {

        this.inquilino = inquilino;
        this.inmueble = inmueble;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.montoAlquiler = montoAlquiler;
        this.indexacionMeses = indexacionMeses;
        this.alta = alta;
        this.importesAlquiler = importesAlquiler;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Inquilino getInquilino() {
        return inquilino;
    }

    public void setInquilino(Inquilino inquilino) {
        this.inquilino = inquilino;
    }

    public Inmueble getInmueble() {
        return inmueble;
    }

    public void setInmueble(Inmueble inmueble) {
        this.inmueble = inmueble;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public double getMontoAlquiler() {
        return montoAlquiler;
    }

    public void setMontoAlquiler(double montoAlquiler) {
        this.montoAlquiler = montoAlquiler;
    }

    public int getIndexacionMeses() {
        return indexacionMeses;
    }

    public void setIndexacionMeses(int indexacionMeses) {
        this.indexacionMeses = indexacionMeses;
    }

    public boolean isAlta() {
        return alta;
    }

    public void setAlta(boolean alta) {
        this.alta = alta;
    }

    public List<Double> getImportesAlquiler() {
        return importesAlquiler;
    }

    public void setImportesAlquiler(List<Double> importesAlquiler) {
        this.importesAlquiler = importesAlquiler;
    }

    @Override
    public String toString() {
        return "Contrato{" + "id=" + id + ", inquilino=" + inquilino + ", inmueble=" + inmueble + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", montoAlquiler=" + montoAlquiler + ", indexacionMeses=" + indexacionMeses + ", alta=" + alta + ", importesAlquiler=" + importesAlquiler + ", baja=" + baja + '}';
    }

   

}
