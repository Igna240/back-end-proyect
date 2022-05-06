package com.dh.clase36.integradora.controller;

import com.dh.clase36.integradora.entities.Domicilio;
import com.dh.clase36.integradora.service.DomicilioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/domicilios")
public class DomicilioController {
    @Autowired
    private DomicilioService domicilioService;


    @GetMapping
    public List<Domicilio> buscarDomicilios(){
        return domicilioService.buscarTodos();
    }

    @PostMapping
    public Domicilio registrarDomicilio(@RequestBody Domicilio domicilio){
        return domicilioService.registrarDomicilio(domicilio);
    }
}

