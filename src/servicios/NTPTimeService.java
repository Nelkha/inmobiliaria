package servicios;

import org.apache.commons.net.ntp.NTPUDPClient;
import org.apache.commons.net.ntp.TimeInfo;

import java.net.InetAddress;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

public class NTPTimeService {

    private String ntpServer;

    public NTPTimeService(String ntpServer) {
        this.ntpServer = ntpServer;
    }

    public LocalDate obtenerFechaSincronizada() {
        try {
            NTPUDPClient client = new NTPUDPClient();
            client.open();

            // Define la dirección IP del servidor NTP
            InetAddress hostAddr = InetAddress.getByName(ntpServer);

            // Consulta al servidor NTP y obtén la información de tiempo
            TimeInfo timeInfo = client.getTime(hostAddr);
            timeInfo.computeDetails(); // Calcula los detalles

            // Obtiene el tiempo en milisegundos
            long ntpTime = timeInfo.getReturnTime();

            // Convierte el tiempo NTP a una instancia de Instant
            Instant instant = Instant.ofEpochMilli(ntpTime);

            // Convierte el Instant a LocalDate
            LocalDate fecha = instant.atZone(ZoneId.of("UTC")).toLocalDate();

            // Cierra la conexión con el servidor NTP
            client.close();

            return fecha;
        } catch (Exception e) {
            e.printStackTrace();
            return obtenerFechaActualDelSistema();
        }
    }

    private LocalDate obtenerFechaActualDelSistema() {
        return LocalDate.now();
    }
}
