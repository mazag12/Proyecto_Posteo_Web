package org.instituto.repository;

import org.instituto.model.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComentarioRespository extends JpaRepository<Comentario, Long> {

	
}
