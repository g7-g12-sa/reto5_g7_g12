/*
 * Creación de repositorio para la tabla Reserva.
 */
package com.apiReto5G7.apiReto5G7.repository;

import com.apiReto5G7.apiReto5G7.entity.Reserva;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author J. Sebastián Beltrán
 */
public interface ReservaRepository extends JpaRepository<Reserva, Integer>{
    /**
     * Recupera las reservas realizadas dentro de un intervalo de tiempo.
     * @param dateOne fecha inicio intervalo.
     * @param dateTwo fecha fin intervalo.
     * @return lista de Reservas creadas dentro del intervalo.
     */
    public List<Reserva> findAllByStartDateAfterAndStartDateBefore
                         (Date dateOne, Date dateTwo);
    
    /**
     * Recupera las reservas que tenga un estado específico.
     * @param status el estado de la reserva.
     * @return Una lista de Reservas que cumplan con las condiciones.
     */
    public List<Reserva> findAllByStatus(String status);
    
    /**
     * Recuperar los clientes que más han hecho reservas en orden descendente.
     * @return una lista de un arreglo de objetos.
     */
    // SELECT Client_id, COUNT(*) AS total FROM Reserva GROUP BY Client_id
    //      ORDER BY desc;
    @Query("SELECT c.client, COUNT(c.client) from Reserva AS c group by c.client order by COUNT(c.client)DESC")
    public List<Object[]> countTotalReservationsByClient();
}
