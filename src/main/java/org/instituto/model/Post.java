package org.instituto.model;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import javax.validation.constraints.NotBlank;
import org.springframework.lang.Nullable;


public class Post {

	@Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "POST_ID")
    private Long postId;

    @Column(name = "POST_NOMBRE", nullable = false)
    @NotBlank(message = "El nombre del Post no puede ser vacio")
    private String postNombre;

    @Column(name = "POST_URL")
    @Nullable
    private String postUrl;

    @Column(name = "POST_DESCRIPCION")
    @Nullable
    @Lob
    private String postDescripcion;

    @Column(name = "POST_CONT_VOTO")
    private Integer postContVoto = 0;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "POST_USU_ID", referencedColumnName = "USU_ID")
    private Usuario usuario;

    @Column(name = "POST_FEC_CREA", updatable = false)
    private Instant postFecCrea;

    @Column(name = "POST_FEC_ACTUALIZA")
    private Instant postFecActualiza;

    @Column(name = "POST_ESTADO")
    private boolean postEstado;
    
    @PrePersist
    void creationDate(){
        postContVoto = 0;
        postFecCrea = java.time.Instant.now();
    }

    @PreUpdate
    void updateDate(){
        postFecActualiza = java.time.Instant.now();
    }
	
}
