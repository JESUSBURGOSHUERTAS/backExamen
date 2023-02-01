package com.tutorial.crud.service;

import com.tutorial.crud.entity.Dueno;

import com.tutorial.crud.repository.DuenoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Transactional
@Service
public class DuenoService {

    @Autowired
    DuenoRepository duenoRepository;



    public List<Dueno> list() {return duenoRepository.findAll();}

    public Optional<Dueno> getOne(int idDueno){
        return duenoRepository.findById(idDueno);
    } // Obtener uno por id

    public Optional<Dueno> getByNombre(String nombre){
        return duenoRepository.findByNombre(nombre);
    }

    public void  save(Dueno dueno){duenoRepository.save(dueno);}

    public void delete(int idDueno) {duenoRepository.deleteById(idDueno);}

    public boolean existsById(int idDueno){return duenoRepository.existsById(idDueno);
    }

    public boolean existsByNombre(String nombre) {return duenoRepository.existsByNombre(nombre);
    }
}
