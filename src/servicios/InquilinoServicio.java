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
    List<Inquilino> inquilinos;

    public List<Inquilino> consultaTodos() {
        return inquilinoJpa.findInquilinoEntities();
    }

    public List<Inquilino> buscarInquilinoPorCuit(Inquilino inq) {
        inquilinos = inquilinoJpa.findInquilinoByCuit(inq.getCuit());

        return inquilinos;
    }

    public Inquilino guardar(Inquilino inquilino) {
        inquilinos = this.buscarInquilinoPorCuit(inquilino);
        if (inquilinos.isEmpty()) {
            inquilinoJpa.create(inquilino);
            return inquilino;
        } else {
           return inquilinos.get(0);
        }
        
    }

}
