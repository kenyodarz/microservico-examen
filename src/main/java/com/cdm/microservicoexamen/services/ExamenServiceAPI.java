package com.cdm.microservicoexamen.services;

import com.cdm.microservicoexamen.models.Asignatura;
import com.cdm.microservicoexamen.models.Examen;
import com.cdm.microservicoexamen.utils.GenericServiceAPI;

import java.util.List;

public interface ExamenServiceAPI extends GenericServiceAPI <Examen, Long> {

    List<Examen> findByNombre(String term);

    List<Asignatura> findAllAsignatura();
}
