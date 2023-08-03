/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicios;

import controladores.InmuebleJpaController;
import controladores.InquilinoJpaController;
import java.util.List;
import models.Inquilino;

/**
 *
 * @author Mario
 */
public class InquilinoServicio {
   InquilinoJpaController inquilinoJpa = new InquilinoJpaController();
    List<Inquilino> inquilinos;

    public List<Inquilino> consultaTodos() {
        return inquilinoJpa.findInquilinoEntities();
    }

  

    public String guardar(Inquilino inquilino) {
        inquilinos = inquilinoJpa.findInquilinoEntities();
        String mensaje;
        boolean inquilinoExistente = false;
        for (Inquilino existingInquilino : inquilinos) {
            if (existingInquilino.getCuit().equals(inquilino.getCuit())) {

                inquilinoExistente = true;
                break;
            }
        }

        if (!inquilinoExistente) {
            // Si el inquiino no existe, lo guardamos en la base de datos
            try {
                inquilinoJpa.create(inquilino);
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
