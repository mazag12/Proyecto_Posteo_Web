package org.instituto.model;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Comentario {
	@Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "COME_ID")
    private Long comeId;

    @Column(name = "COME_TEXTO", nullable = false)
    @NotEmpty
    private String comeTexto;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "COME_POST_ID", referencedColumnName = "POST_ID")
    private Post post;

    @Column(name = "COME_FEC_CREA", updatable = false)
    private Instant comeFecCrea;

    @Column(name = "COME_FEC_ACTUALIZA")
    private Instant comeFecActualiza;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "COME_USU_ID", referencedColumnName = "USU_ID")
    private Usuario usuario;

    @Column(name = "COME_ESTADO")
    private boolean comeEstado;

    @PrePersist
    void creationDate(){
        comeFecCrea = java.time.Instant.now();
    }

    @PreUpdate
    void updateDate(){
        comeFecActualiza = java.time.Instant.now();
    }
}
