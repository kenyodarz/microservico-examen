package com.cdm.microservicoexamen.repositories;

import com.cdm.microservicoexamen.models.Examen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExamenRepository extends JpaRepository<Examen, Long> {

    @Query("select e from Examen e where e.nombre like %?1%")
    List<Examen> findByNombre(String term);
}
