/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicios;

import controladores.InquilinoJpaController;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Contrato;
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

    public List<Contrato> buscarContratosInquilino(Inquilino inq) {
        List<Contrato> contratos = inquilinoJpa.findContratosInquilino(inq);
        return contratos;

    }

    public Inquilino buscarInquilinoPorCuit(String cuit) {
        List<Inquilino> inquilinos = inquilinoJpa.findInquilinoByCuit(cuit);

        if (inquilinos.isEmpty()) {
            return null;
        } else {
            return inquilinos.get(0);
        }
    }

    public Inquilino guardar(Inquilino inquilino) throws Exception {
    Inquilino inquilinoExistente = buscarInquilinoPorCuit(inquilino.getCuit());

    if (inquilinoExistente == null) {
        inquilinoJpa.create(inquilino);
        return inquilino;
    } else {
        
        if (!inquilinoExistente.getTelefono().equals(inquilino.getTelefono())) {
            inquilinoExistente.setTelefono(inquilino.getTelefono());
            inquilinoJpa.edit(inquilinoExistente); 
        }
        return inquilinoExistente;
    }
}

    public void agregarContrato(Inquilino inquilino, Contrato contrato) {
        try {
            List<Contrato> contratosAttached = inquilino.getContratos();
            contratosAttached.add(contrato);
            inquilino.setContratos(contratosAttached);
            inquilinoJpa.edit(inquilino);
        } catch (Exception ex) {
            Logger.getLogger(InquilinoServicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void editarInquilino(Inquilino inquilino) throws Exception{
    inquilinoJpa.edit(inquilino);
    }

}
