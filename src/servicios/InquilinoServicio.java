/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicios;

import controladores.InquilinoJpaController;
import java.util.List;
import models.Inquilino;

/**
 *
 * @author Mario
 */
public class InquilinoServicio {

    InquilinoJpaController inquilinoJpa = new InquilinoJpaController();
 

    public List<Inquilino> consultaTodos() {
        return inquilinoJpa.findInquilinoEntities();
    }

     public Inquilino buscarInquilinoPorCuit(String cuit) {
        List<Inquilino> inquilinos = inquilinoJpa.findInquilinoByCuit(cuit);
        
        if (inquilinos.isEmpty()) {
            return null;
        } else {
            return inquilinos.get(0);
        }
    }

    public Inquilino guardar(Inquilino inquilino) {
        Inquilino inquilinoExistente = buscarInquilinoPorCuit(inquilino.getCuit());
        
        if (inquilinoExistente == null) {
            inquilinoJpa.create(inquilino);
            return inquilino;
        } else {
            return inquilinoExistente;
        }
    }

    }


