package com.dh.clase36.integradora.service;

import com.dh.clase36.integradora.entities.Odontologo;
import com.dh.clase36.integradora.exceptions.ResourceNotFoundException;
import com.dh.clase36.integradora.repository.OdontologoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OdontologoService {
    @Autowired
    OdontologoRepository repository;

    public Optional<Odontologo> buscar(Long id){
        return repository.findById(id);
    }

    public List<Odontologo> buscarTodos(){
        return repository.findAll();
    }

    public Odontologo registrarOdontologo(Odontologo odontologo){
        return repository.save(odontologo);
    }

    public void eliminarOdontologo(Long id) throws ResourceNotFoundException{
        Optional<Odontologo> odontologoBuscado= buscar(id);
        if (odontologoBuscado.isPresent()){
            repository.deleteById(id);
        }
        else{
            throw new ResourceNotFoundException("No se puede borrar el odontologo con id: "+id+", error al borrar");
        }

    }

    public Odontologo actualizar(Odontologo odontologo){
        if (buscar(odontologo.getId()).isPresent())
            return repository.save(odontologo);
        else
            return null;
    }
}
