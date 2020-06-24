package com.cdm.microservicoexamen.services;

import com.cdm.microservicoexamen.models.Asignatura;
import com.cdm.microservicoexamen.models.Examen;
import com.cdm.microservicoexamen.repositories.AsignaturasRepository;
import com.cdm.microservicoexamen.repositories.ExamenRepository;
import com.cdm.microservicoexamen.utils.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ExamenServiceImpl extends GenericServiceImpl<Examen, Long> implements ExamenServiceAPI {

    @Autowired
    ExamenRepository repository;

    @Autowired
    AsignaturasRepository asignaturasRepository;

    @Override
    public CrudRepository<Examen, Long> getRepository() {
        return repository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Examen> findByNombre(String term) { return repository.findByNombre(term); }

    @Override
    @Transactional(readOnly = true)
    public List<Asignatura> findAllAsignatura() {
        return asignaturasRepository.findAll();
    }
}
