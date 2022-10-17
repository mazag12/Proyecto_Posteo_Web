package org.instituto.model;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Comunidad {
	@Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "COM_ID")
    private Long comId;

    @Column(name = "COM_NOMBRE", nullable = false)
    @NotBlank(message = "El nombre de la comunidad es requerido")
    private String comNombre;

    @Column(name = "COM_DESCRIPCION", nullable = false)
    @NotBlank(message = "La descripcion de la comunidad es requerida")
    private String comDescripcion;

    @Column(name = "COM_FEC_CREA", updatable = false)
    private Instant comFecCrea;

    @Column(name = "COM_FEC_ACTUALIZA")
    private Instant comFecActualiza;

    @ManyToOne(fetch = LAZY)
    private Usuario usuario;

    @Column(name = "COM_ESTADO")
    private boolean comEstado;

    @PrePersist
    void creationDate(){
        comFecCrea = java.time.Instant.now();
    }

    @PreUpdate
    void updateDate(){
        comFecActualiza = java.time.Instant.now();
    }
}
