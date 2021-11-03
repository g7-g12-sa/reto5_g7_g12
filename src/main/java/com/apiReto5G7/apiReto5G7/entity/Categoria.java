/*
 * Creación de entidad "Categoria" y de tabla "Categoria"
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
@Table(name="Categoria")
public class Categoria implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    
    @Column(name="name", nullable=false, length=45)
    private String name;
    
    @Column(name="description", nullable=false, length=250)
    private String description;
    
    @OneToMany(cascade={CascadeType.PERSIST}, mappedBy="category")
    @JsonIgnoreProperties("category")
    private List<Auditorio> audiences;
}
