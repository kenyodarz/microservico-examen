package com.cdm.microservicoexamen.controllers;

import com.cdm.microservicoexamen.models.Examen;
import com.cdm.microservicoexamen.services.ExamenServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ExamenRestController {

    @Autowired
    ExamenServiceAPI serviceApi;

    @GetMapping
    public List<Examen> getAll(){
        return serviceApi.getAll();
    }

    @GetMapping("/{id}")
    public Examen find(@PathVariable Long id){
        return serviceApi.get(id);
    }

    @PostMapping("/save")
    public ResponseEntity<Examen> save (@RequestBody Examen examen){
        Examen obj = serviceApi.save(examen);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity <Examen> delete (@PathVariable Long id){
        Examen examen = serviceApi.get(id);
        if (examen != null){
            serviceApi.delete(id);
        }else {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(examen, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> edit(@RequestBody Examen examen, @PathVariable Long id){
        Examen optionalExamen = serviceApi.get(id);

        if (optionalExamen== null){
            return ResponseEntity.notFound().build();
        }

        optionalExamen.setNombre(examen.getNombre());

        /*
          -> Vamos a resumir el siguiente código para hacerlo mas simple <-

          List<Pregunta> eliminadas = new ArrayList<>();

          optionalExamen.getPreguntas().forEach(pregunta -> {
          if (!examen.getPreguntas().contains(pregunta)){
          eliminadas.add(pregunta);}});
          eliminadas.forEach(optionalExamen::removePreguntas);

        */
        // Nuevo Codigo Resumido usando stream.
        optionalExamen.getPreguntas()
                .stream()
                .filter(pregunta -> !examen.getPreguntas().contains(pregunta))
                .forEach(optionalExamen::addPreguntas);

        optionalExamen.setPreguntas(examen.getPreguntas());

        return ResponseEntity.status(HttpStatus.CREATED).body(serviceApi.save(optionalExamen));
    }

    @GetMapping("/filtrar/{term}")
    public ResponseEntity<?> filtrar(@PathVariable String term){
        return ResponseEntity.ok(serviceApi.findByNombre(term));
    }

    @GetMapping("/asignaturas")
    public ResponseEntity<?> listarAsignaturas(){
        return ResponseEntity.ok(serviceApi.findAllAsignatura());
    }

}
