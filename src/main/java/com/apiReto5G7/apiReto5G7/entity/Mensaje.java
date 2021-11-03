/*
 * Creación de entidad "Mensaje" y de tabla "Mensaje"
 */
package com.apiReto5G7.apiReto5G7.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name="Mensaje")
public class Mensaje implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="idMessage")
    private Integer idMessage;
    
    @Column(name="messageText", nullable=false, length=250)
    private String messageText;
    
    @ManyToOne(optional=false)
    @JoinColumn(name="Auditorio_id", nullable=false)
    @JsonIgnoreProperties({"messages", "reservations"})
    private Auditorio audience;
    
    @ManyToOne(optional=false)
    @JoinColumn(name="Cliente_id", nullable=false)
    @JsonIgnoreProperties({"messages", "reservations"})
    private Cliente client;
}
