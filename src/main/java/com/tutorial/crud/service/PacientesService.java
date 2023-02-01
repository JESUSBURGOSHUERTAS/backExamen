package com.tutorial.crud.service;

import java.util.List;
import java.util.Optional;

import com.tutorial.crud.entity.Pacientes;
import com.tutorial.crud.repository.PacientesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PacientesService {

    @Autowired
    PacientesRepository pacientesRepository;

    public List<Pacientes> list() {return pacientesRepository.findAll();}

    public Optional<Pacientes> getOne(int idpaciente){
        return pacientesRepository.findById(idpaciente);
    } // Obtener uno por id

    public Optional<Pacientes> getByNombre(String nombre){
        return pacientesRepository.findByNombre(nombre);
    }

    public void  save(Pacientes pacientes){pacientesRepository.save(pacientes);}


    public boolean existsById(int idpaciente){return pacientesRepository.existsById(idpaciente);
    }


    public void delete(int idpaciente) {pacientesRepository.deleteById(idpaciente);}

    public boolean existsByNombre(String nombre) {return pacientesRepository.existsByNombre(nombre);
    }


}
