package com.cdm.microservicoexamen.repositories;

import com.cdm.microservicoexamen.models.Asignatura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AsignaturasRepository  extends JpaRepository<Asignatura, Long> {
}
