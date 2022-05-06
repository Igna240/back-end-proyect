package com.dh.clase36.integradora.service;

import com.dh.clase36.integradora.entities.Turno;
import com.dh.clase36.integradora.exceptions.ResourceNotFoundException;
import com.dh.clase36.integradora.repository.TurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurnoService {
    @Autowired
    TurnoRepository repository;

    public Turno registrarTurno(Turno turno){
        return repository.save(turno);
    }

    public List<Turno> listarTurno(){
        return repository.findAll();
    }

    public void eliminar (Long id) throws ResourceNotFoundException{
        Optional<Turno> turnoBuscado= buscar(id);
        if (turnoBuscado.isPresent())
            repository.deleteById(id);
        else
            throw new ResourceNotFoundException("No existe el turno con id: "+id+", no se pudo borrar");
    }

    public Turno actualizar(Turno turno){
        Optional<Turno> turnoBuscado=buscar(turno.getId());
       if (turnoBuscado.isPresent())
           return repository.save(turno);
       else
           return null;
    }

    public Optional<Turno> buscar(Long id){
        return repository.findById(id);
    }
}
