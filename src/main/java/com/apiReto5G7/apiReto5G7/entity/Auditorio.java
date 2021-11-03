/*
 * Creación de entidad "Auditorio" y de tabla "Auditorio"
 */
package com.apiReto5G7.apiReto5G7.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
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
@Table(name="Auditorio")
public class Auditorio implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="name", nullable=false, length=45)
    private String name;
    
    @Column(name="owner", nullable=false, length=45)
    private String owner;
        
    @Column(name="capacity")
    private Integer capacity;
    
    @Column(name="description", length=250)
    private String description;
    
    @ManyToOne(optional=true)
    @JoinColumn(name="Categoria_id", nullable=true)
    @JsonIgnoreProperties("audiences")
    private Categoria category;
    
    @OneToMany(cascade={CascadeType.PERSIST}, mappedBy="audience")
    @JsonIgnoreProperties({"client", "audience"})
    private List<Mensaje> messages;
    
    @OneToMany(cascade={CascadeType.PERSIST}, mappedBy="audience")
    @JsonIgnoreProperties("audience")
    private List<Reserva> reservations;
}