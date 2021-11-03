/*
 * Creación de entidad "Calificación" y de tabla "Calificacion"
 */
package com.apiReto5G7.apiReto5G7.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 *
 * @author J. Sebastián Beltrán
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Calificacion")
public class Calificacion implements Serializable {
    @Id
    @GeneratedValue
    @Column(name="id")
    private Integer id;
    
    @Column(name="score", nullable=false)
    private Integer score;
    
    @Column(name="message", length=250)
    private String message;
    
    @ManyToOne(optional=true)
    @JoinColumn(name="Reserva_id", nullable=false)
    @JsonIgnoreProperties("score")
    private Reserva reservation;
}
