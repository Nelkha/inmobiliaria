/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicios;

import controladores.ContratoJpaController;
import java.time.LocalDate;
import java.util.ArrayList;
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
     public boolean guardar(Contrato contrato){
     try{
     contratoJpa.create(contrato);
     return true;
     }
     catch(Exception e){
         
         return false;
     }
         
     }
     public Contrato buscarContratoPorId(long id){
     return contratoJpa.findContrato(id);
   
     }
     public void editarContrato(Contrato contrato) throws Exception{
     contratoJpa.edit(contrato);
     }
     
     public List<Contrato>buscarVigentes(LocalDate fechaActual){
     List<Contrato>contratosFechaVigente=contratoJpa.findVigentes(fechaActual);
     List<Contrato>contratosVigentes=new ArrayList<>();
     for(Contrato contrato:contratosFechaVigente){
     if(contrato.isAlta()){
     contratosVigentes.add(contrato);
     }
     }
     return contratosVigentes;
     }
}
