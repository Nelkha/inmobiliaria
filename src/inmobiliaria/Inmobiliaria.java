
package inmobiliaria;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import javax.swing.JOptionPane;
import servicios.NTPTimeService;
import views.Principal;

/**
 *
 * @author Nelkha
 */
public class Inmobiliaria {

   
    public static void main(String[] args) {
         String ntpServer = "time.google.com";
         NTPTimeService timeService = new NTPTimeService(ntpServer);
         LocalDate fechaSincronizada = timeService.obtenerFechaSincronizada();

    
        LocalDate fechaExpiracionPrueba = LocalDate.of(2024, 9,24 );  // Ajusta según la fecha real de expiración

        // Obtener la fecha sincronizada
        

        // Verificar si la fecha actual es mayor a la fecha de expiración
        if (fechaSincronizada.isAfter(fechaExpiracionPrueba)) {
            // Mostrar el mensaje de que la prueba ha finalizado
            JOptionPane.showMessageDialog(null, "La prueba ha finalizado", "Fin de prueba", JOptionPane.WARNING_MESSAGE);
            // Cerrar el programa
            System.exit(0);
        } else {
            // Calcular cuántos días faltan para que expire la prueba
            long diasRestantes = ChronoUnit.DAYS.between(fechaSincronizada, fechaExpiracionPrueba);
            // Mostrar el mensaje con los días restantes
            JOptionPane.showMessageDialog(null, "La prueba no ha finalizado. Te quedan " + diasRestantes + " días.", "Días restantes", JOptionPane.INFORMATION_MESSAGE);
        Principal ventPrincipal = new Principal();
        ventPrincipal.setVisible(true);
        }
    

        
    }
    
}
