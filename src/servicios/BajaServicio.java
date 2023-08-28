/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicios;

import controladores.BajaJpaController;
import java.time.LocalDate;
import models.Baja;
import models.Contrato;

/**
 *
 * @author Nelkha
 */
public class BajaServicio {
    BajaJpaController bajaJpa = new BajaJpaController();
    
    public void guardar(Contrato contrato, LocalDate fecha){
    Baja baja = new Baja(contrato,fecha);
    bajaJpa.create(baja);
        
    }
}
