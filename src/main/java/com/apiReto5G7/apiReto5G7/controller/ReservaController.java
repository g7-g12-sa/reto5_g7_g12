/*
 * Creación de API /Reservation/ con peticiones GET y POST.
 */
package com.apiReto5G7.apiReto5G7.controller;

import com.apiReto5G7.apiReto5G7.entity.Reserva;
import com.apiReto5G7.apiReto5G7.reports.ReporteClientesTop;
import com.apiReto5G7.apiReto5G7.reports.ReporteReservas;
import com.apiReto5G7.apiReto5G7.service.ReservaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author J. Sebastián Beltrán
 */
@RestController
@CrossOrigin(origins="*", methods={RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api/Reservation")
public class ReservaController {
    /**
     * Instancear el servicio de Reserva.
     */
    @Autowired
    private ReservaService servicioReserva;
    
    /**
     * Petición GET para API Reservation.
     * @return lista de Reservas encontrados.
     */
    @GetMapping("/all")
    public List <Reserva> getAllReservas(){
        return servicioReserva.getAllReservas();
    }
    
    /**
     * Petición POST para API Reservation.
     * @param reserva el objeto Json que se enviará.
     * @return código de estado de respuesta HTTP (201).
     */
    @PostMapping("/save")
    public ResponseEntity saveReserva(@RequestBody Reserva reserva){
        servicioReserva.saveReserva(reserva);
        
        return ResponseEntity.status(201).build();
    }
    
    /**
     * Petición PUT para API Reservation.
     * @param reserva el objeto Json que se enviará.
     * @return código de estado de respuesta HTTP (201).
     */
    @PutMapping("/update")
    public ResponseEntity updateReserva(@RequestBody Reserva reserva){
        servicioReserva.updateReserva(reserva);
        
        return ResponseEntity.status(201).build();
    }
    
    /**
     * Petición DELETE para API Reservation.
     * @param idReserva el objeto Json que se enviará.
     * @return código de estado de respuesta HTTP (204).
     */
    @DeleteMapping("/{id}")
    public ResponseEntity deleteReserva(@PathVariable("id") int idReserva){
        servicioReserva.deleteReserva(idReserva);
        
        return ResponseEntity.status(204).build();
    }
    
    /**
     * Crea el reporte de las reservas hechas en un intervalo de tiempo.
     * @param dateOne fecha inicio de intervalo
     * @param dateTwo fecha fin de intervalo
     * @return lista de Reservas dentro del intervalo indicado.
     */
    @GetMapping("/report-dates/{dateOne}/{dateTwo}")
    public List <Reserva> getReportDatesReserva(
            @PathVariable("dateOne") String dateOne,
            @PathVariable("dateTwo") String dateTwo){
        
        return servicioReserva.getReservasPeriod(dateOne, dateTwo);
    }
    
    /**
     * Crea el reporte de las reservas con estatus de creadas o completadas.
     * @return un objeto ReporteReservas con los números de las reservas que
     * cumplan con las condiciones.
     */
    @GetMapping("/report-status")
    public ReporteReservas getReportStatusReserva(){
        return servicioReserva.getReportReservas();
    }
    
    /**
     * Crea el reporte de los clientes con mayor número de reservas.
     * @return una lista de ReporteClientesTop con el total de reservas por
     * cliente y el Cliente.
     */
    @GetMapping("/report-clients")
    public List<ReporteClientesTop> getReportTopClientes(){
        return servicioReserva.getReportTopClientes();
    }
}