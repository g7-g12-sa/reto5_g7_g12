/*
 * Creación de servicio para la ejecución de operaciones GET, POST, PUT y
 * DELETE en tabla Reserva.
 */
package com.apiReto5G7.apiReto5G7.service;

import com.apiReto5G7.apiReto5G7.entity.Cliente;
import com.apiReto5G7.apiReto5G7.entity.Reserva;
import com.apiReto5G7.apiReto5G7.reports.ReporteClientesTop;
import com.apiReto5G7.apiReto5G7.reports.ReporteReservas;
import com.apiReto5G7.apiReto5G7.repository.ReservaRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author J. Sebastián Beltrán
 */
@Service
public class ReservaService {
    /**
     * Instancia de ReservaRepository.
     */
    @Autowired
    private ReservaRepository repositorioReserva;
    
    /**
     * Devuelve una lista con los registros de la tabla Reserva.
     * @return la lista con los objetos Reserva de la tabla Reserva.
     */
    public List<Reserva> getAllReservas(){
        return repositorioReserva.findAll();
    }
    
    /**
     * Recupera una reserva específica de la tabla Reserva.
     * @param idReserva el id del objeto que se recuperará.
     * @return el objeto Reserva si existe.
     */
    public Optional<Reserva> getReserva(int idReserva){
        return repositorioReserva.findById(idReserva);
    }
    
    /**
     * Crea una nueva Reserva en la tabla Reserva.
     * @param reserva la reserva que se creará.
     * @return el objeto Reserva creado.
     */
    public Reserva saveReserva(Reserva reserva){
        /**
         * Si reserva no tiene ID, guardarlo.
         */
        if(reserva.getIdReservation()==null){
            return repositorioReserva.save(reserva);        
        } else {
            /**
             * Busca la reserva por el ID, si la encuentra, la guarda en
             * existeReserva.
             */
            Optional<Reserva> existeReserva = getReserva(reserva.getIdReservation());
            /**
             * Si existeReserva está vacío, guardar reserva. Si no, devolver
             * reserva.
             */
            if(existeReserva.isEmpty()){
                return repositorioReserva.save(reserva);
            } else {
                return reserva;
            }
        }
    }
    
    /**
     * Actualiza los valores de una reserva en la tabla Reserva.
     * @param reserva la reserva con los valores a actualizar.
     * @return el objeto reserva actualizado.
     */
    public Reserva updateReserva(Reserva reserva){
        /**
         * Verificar que el objeto auditorio recibido tenga un ID.
         */
        if (reserva.getIdReservation()!=null){
            /**
             * Verificar la existencia del objeto en BD.
             */
            Optional<Reserva> existeReserva = getReserva(reserva.getIdReservation());
            /**
             * Si el objeto existe en la BD, editarlo. Si no,retornarlo como
             * está.
             */
            if (!existeReserva.isEmpty()){
                /**
                 * Si el objeto reserva tiene un valor startDate, asignarlo a
                 * existeCliente.
                 */
                if (reserva.getStartDate()!=null){
                    existeReserva.get().setStartDate(reserva.getStartDate());
                }
                /**
                 * Si el objeto cliente tiene un valor devolutionDate, asignarlo
                 * a existeCliente.
                 */
                if (reserva.getDevolutionDate()!=null){
                    existeReserva.get().setDevolutionDate(reserva.getDevolutionDate());
                }
                /**
                 * Si el objeto reserva tiene un valor status, asignarlo a
                 * existeCliente.
                 */
                if (reserva.getStatus()!=null){
                    existeReserva.get().setStatus(reserva.getStatus());
                }
                /**
                 * Si el objeto reserva tiene un valor audience, asignarlo
                 * a existeCliente.
                 */
                if (reserva.getAudience()!=null){
                    existeReserva.get().setAudience(reserva.getAudience());
                }
                /**
                 * Si el objeto reserva tiene un valor client, asignarlo
                 * a existeCliente.
                 */
                if (reserva.getClient()!=null){
                    existeReserva.get().setClient(reserva.getClient());
                }
                /**
                 * Devolver existeCliente con valores ajustados.
                 */
                return repositorioReserva.save(existeReserva.get());
            } else {
                return reserva;
            }
        } else {
            return reserva;
        }
    }
    
    /**
     * Borra un cliente de la tabla Reserva.
     * @param idReserva el id del cliente que se borrará.
     */
    public void deleteReserva(int idReserva){
        repositorioReserva.deleteById(idReserva);
    }
    
    /**
     * Obtiene todas las reservas realizadas dentro un intervalo de tiempo.
     * @param dateOne fecha inicio de intervalo.
     * @param dateTwo fecha fin de intervalo.
     * @return una lista de Reservas realizadas dentro del intervalo.
     */
    public List<Reserva> getReservasPeriod(String dateOne, String dateTwo){
        /**
         * Instancia de SimpleDateFormat para dar formato correcto a fechas.
         */
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
        /**
         * Crear nuevos objetos Date para recibir fechas fomateadas.
         */
        Date dateOneFormatted = new Date();
        Date dateTwoFormatted = new Date();
        /**
         * Intentar convertir las fechas a objetos Date; mostrar registro de
         * la excepción si no se puede.
         */
        try {
            dateOneFormatted = parser.parse(dateOne);
            dateTwoFormatted = parser.parse(dateTwo);
        } catch (ParseException except) {
            except.printStackTrace();
        }
        /**
         * Si la fecha inicial es anterior a la fecha final, devuelve una lista
         * de Reservas creadas dentro del intervalo de fechas; si no, devuelve
         * un ArrayList vacío.
         */
        if (dateOneFormatted.before(dateTwoFormatted)){
            return repositorioReserva.findAllByStartDateAfterAndStartDateBefore
                                      (dateOneFormatted, dateTwoFormatted);
        } else {
            return new ArrayList<>();
        }
    }
    
    /**
     * Obtiene el número de reservas canceladas y completadas.
     * @return un objeto ReporteReservas con los valores reservas canceladas y
     * completadas.
     */
    public ReporteReservas getReportReservas(){
        /**
         * Traer una lista de Reservas completadas.
         */
        List<Reserva> resCompletadas = repositorioReserva.findAllByStatus("completed");
        /**
         * Traer una lista de Reservas canceladas.
         */
        List<Reserva> resCanceladas = repositorioReserva.findAllByStatus("cancelled");
        /**
         * Retornar un objeto ReporteReservas con la longitud de las listas.
         */
        return new ReporteReservas(resCompletadas.size(), resCanceladas.size());
    }
    
    public List<ReporteClientesTop> getReportTopClientes(){
        /**
         * Instanciar una lista de arreglos vacía.
         */
        List<ReporteClientesTop> reporte = new ArrayList<>();
        /**
         * Crear una lista de objetos con el resultado de la consulta en el
         * repositorio.
         */
        List<Object[]> resConsulta = repositorioReserva.countTotalReservationsByClient();
        /**
         * Iterar en resConsulta para crear objetos ReporteClientesTop con los
         * datos obtenidos.
         */
        for(int i=0; i<resConsulta.size(); i++){
            reporte.add(new ReporteClientesTop((Long) resConsulta.get(i)[1],
                                              (Cliente) resConsulta.get(i)[0]));
        }
    
        return reporte;
    }
}