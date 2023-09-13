/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicios;

import controladores.BajaJpaController;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Baja;
import models.Contrato;

/**
 *
 * @author Nelkha
 */
public class BajaServicio {
    BajaJpaController bajaJpa = new BajaJpaController();
    ContratoServicio contServ=new ContratoServicio();
    public void guardar(Contrato contrato, LocalDate fecha){
        try {
            Baja baja = new Baja(contrato,fecha);
            bajaJpa.create(baja);
            contrato.setBaja(baja);
            contServ.editarContrato(contrato);
        } catch (Exception ex) {
            Logger.getLogger(BajaServicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
