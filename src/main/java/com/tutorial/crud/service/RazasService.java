package com.tutorial.crud.service;


import com.tutorial.crud.entity.Razas;
import com.tutorial.crud.repository.RazasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RazasService {

    @Autowired
    RazasRepository razasRepository;

    public List<Razas> list() {return razasRepository.findAll();}

    public Optional<Razas> getOne(int idraza){
        return razasRepository.findById(idraza);
    } // Obtener uno por id

    public Optional<Razas> getByNombreRaza(String nombreRaza){
        return razasRepository.findByNombreRaza(nombreRaza);
    }

    public void  save(Razas razas){razasRepository.save(razas);}

    public void delete(int idraza) {razasRepository.deleteById(idraza);}

    public boolean existsById(int idraza){return razasRepository.existsById(idraza);
    }
    public boolean existsByNombreRaza(String nombreRaza) {return razasRepository.existsByNombreRaza(nombreRaza);
    }

}
