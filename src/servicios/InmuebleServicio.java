/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicios;

import controladores.InmuebleJpaController;
import java.util.List;
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

}
