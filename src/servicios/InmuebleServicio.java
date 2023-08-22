/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicios;

import controladores.InmuebleJpaController;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.List;
import models.Contrato;
import models.Inmueble;

/**
 *
 * @author Mario
 */
public class InmuebleServicio {

    InmuebleJpaController inmuebleJpa = new InmuebleJpaController();
    List<Inmueble> inmuebles;

    public List<Inmueble> consultaTodos() {
        return inmuebleJpa.findInmuebleEntities();
    }

    public String getAlta(Inmueble inm) {
        String alta;
        if (inm.isAlta()) {
            alta = "ALTA";
            return alta;

        } else {
            alta
                    = "BAJA";
            return alta;
        }

    }

    public String guardar(Inmueble inmueble) {
        inmuebles = inmuebleJpa.findInmuebleEntities();
        String mensaje;
        boolean inmuebleExistente = false;
        for (Inmueble existingInmueble : inmuebles) {
            if (existingInmueble.getDireccion().equals(inmueble.getDireccion())) {

                inmuebleExistente = true;
                break;
            }
        }

        if (!inmuebleExistente) {
            // Si el inmueble no existe, lo guardamos en la base de datos
            try {
                inmuebleJpa.create(inmueble);
                mensaje = "El inmueble se ha guardado correctamente.";
            } catch (Exception e) {
                // Manejar la excepción en caso de que ocurra un error durante la creación
                e.printStackTrace();
                mensaje = "Error al guardar el inmueble. Por favor, inténtalo de nuevo.";
            }
        } else {
            // Realizar alguna acción aquí si el inmueble ya existe
            mensaje = "El inmueble ya existe con la misma dirección. No se ha guardado.";

        }
        return mensaje;
    }
    
    public void agregarContrato(Inmueble inmueble,Contrato contrato){
        
        try {
            List<Contrato> contratosAttached=inmueble.getContratos();
            contratosAttached.add(contrato);
            inmueble.setContratos(contratosAttached);
            inmuebleJpa.edit(inmueble);
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(InmuebleServicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    public Inmueble buscarInmuebleDireccion(String direccion) {
        Inmueble inm=inmuebleJpa.findInmuebleByDir(direccion);
        
        return inm;
    }
    public Inmueble buscarInmuebleId(long id) {
        Inmueble inm=inmuebleJpa.findInmueble(id);
        
        return inm;
    }
    public List<Contrato>buscarContratosInmuble(Inmueble inm){
    List<Contrato>contratos=inmuebleJpa.findContratosInmueble(inm);
    return contratos;
}
public void editarInmueble(Inmueble inmueble) throws Exception{
    inmuebleJpa.edit(inmueble);
    }

}
