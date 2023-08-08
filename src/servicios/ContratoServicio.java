/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicios;

import controladores.ContratoJpaController;
import java.util.List;
import models.Contrato;

/**
 *
 * @author Mario
 */
public class ContratoServicio {
     ContratoJpaController contratoJpa = new ContratoJpaController();
     
     public List<Contrato>consultaTodos(){
     return contratoJpa.findContratoEntities();
     }
     public void guardar(Contrato contrato){
     contratoJpa.create(contrato);
     }
}
