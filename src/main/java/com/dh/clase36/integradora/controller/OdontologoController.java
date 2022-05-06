package com.dh.clase36.integradora.controller;

import com.dh.clase36.integradora.entities.Odontologo;
import com.dh.clase36.integradora.exceptions.ResourceNotFoundException;
import com.dh.clase36.integradora.service.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {
    @Autowired
    OdontologoService service;

    @GetMapping
    public List<Odontologo> buscarOdontologos(){
        return service.buscarTodos();
    }

    @PostMapping
    public Odontologo registrarOdontologo(@RequestBody Odontologo odontologo){
        return service.registrarOdontologo(odontologo);
    }
    @PutMapping
    public ResponseEntity<Odontologo> actualizarOdontologo(@RequestBody Odontologo odontologo){
        Odontologo odontologoActualizado=service.actualizar(odontologo);
        if (odontologoActualizado!=null){
            return ResponseEntity.ok(odontologoActualizado);
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Odontologo> buscarOdontologo(@PathVariable Long id){
        Optional<Odontologo> odontologoActualizado=service.buscar(id);
        if(odontologoActualizado.isPresent()){
            return ResponseEntity.ok(odontologoActualizado.get());
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarOdontologo(@PathVariable Long id) throws ResourceNotFoundException {
        service.eliminarOdontologo(id);
           return ResponseEntity.ok("Odontologo eliminado");

    }
}
