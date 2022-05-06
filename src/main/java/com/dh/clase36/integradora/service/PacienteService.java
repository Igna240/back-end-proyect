package com.dh.clase36.integradora.service;

import com.dh.clase36.integradora.entities.Paciente;
import com.dh.clase36.integradora.exceptions.ResourceNotFoundException;
import com.dh.clase36.integradora.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PacienteService{
    @Autowired
    PacienteRepository repository;

    public List<Paciente> buscarTodos(){
        return repository.findAll();
    }

    public Paciente guardar(Paciente p){
        return repository.save(p);
    }

    public void eliminar(Long id) throws ResourceNotFoundException{
        Optional<Paciente> pacienteBuscado=buscar(id);
        if (pacienteBuscado.isPresent()){
            repository.deleteById(id);
        }
        else{
            throw new ResourceNotFoundException("No existe el paciente con id: "+id+", no se puede borrar.");
        }
    }


    public Optional<Paciente> buscar(Long id){
        return repository.findById(id);
    }

    public Paciente actualizar(Paciente p){
        Optional<Paciente> pacienteBuscado=buscar(p.getId());
        if (pacienteBuscado.isPresent())
            return repository.save(p);
        else
            return null;
    }

}
