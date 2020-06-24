package com.cdm.microservicoexamen.utils;

import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class GenericServiceImpl <T, ID extends Serializable> implements GenericServiceAPI<T, ID> {

    @Override
    public T save(T entity) {
        return getRepository().save(entity);
    }

    @Override
    public void delete(ID id) {
        getRepository().deleteById(id);
    }

    @Override
    public T get(ID id) {
        Optional<T> optional = getRepository().findById(id); // Retorna un Opcional de Java 8
        // Si no es encontrado, retornara nulo o tira error.
        return optional.orElse(null);
    }

    @Override
    public List<T> getAll() {
        List<T> returnList = new ArrayList<>();
        getRepository().findAll().forEach(returnList:: add);
        return returnList;
    }

    public abstract CrudRepository<T, ID> getRepository();
}
