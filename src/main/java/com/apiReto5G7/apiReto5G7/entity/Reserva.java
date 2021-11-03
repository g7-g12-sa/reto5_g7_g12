/*
 * Creación de entidad "Reserva" y de tabla "Reserva"
 */
package com.apiReto5G7.apiReto5G7.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
@Table(name="Reserva")
public class Reserva implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="idReservation")
    private Integer idReservation;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date devolutionDate;
    
    @Column(name="status", nullable=false, length=45)
    private String status="created";
    
    @ManyToOne(optional=false)
    @JoinColumn(name="Auditorio_id", nullable=false)
    @JsonIgnoreProperties("reservations")
    private Auditorio audience;
    
    @ManyToOne(optional=false)
    @JoinColumn(name="Cliente_id", nullable=false)
    @JsonIgnoreProperties({"messages", "reservations"})
    private Cliente client;
    
    @OneToMany(cascade={CascadeType.PERSIST}, mappedBy="reservation")
    @JsonIgnoreProperties("reservation")
    private List<Calificacion> score;
}