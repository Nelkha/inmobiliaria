/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicios;

import controladores.GaranteJpaController;
import java.util.List;
import models.Garante;

/**
 *
 * @author Nelkha
 */
public class GaranteServicio {
     GaranteJpaController garanteJpa = new GaranteJpaController();
     
    public Garante buscarGarantePorCuit(String cuit) {
        List<Garante> inquilinos = garanteJpa.findGaranteByCuit(cuit);

        if (inquilinos.isEmpty()) {
            return null;
        } else {
            return inquilinos.get(0);
        }
    }
     public Garante guardar(Garante garante) throws Exception {
    Garante garanteExistente = buscarGarantePorCuit(garante.getCuit());

    if (garanteExistente == null) {
        garanteJpa.create(garante);
        return garante;
    } else {
        
        if (!garanteExistente.getTelefono().equals(garante.getTelefono())) {
            garanteExistente.setTelefono(garante.getTelefono());
            garanteJpa.edit(garanteExistente); 
        }
        return garanteExistente;
    }
}
}
