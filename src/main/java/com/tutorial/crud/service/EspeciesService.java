package com.tutorial.crud.service;
import com.tutorial.crud.entity.Especies;
import com.tutorial.crud.repository.EspeciesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class EspeciesService {
    @Autowired
    EspeciesRepository especiesRepository;

    public List<Especies> list() {return especiesRepository.findAll();}
    public Optional<Especies> getOne(int id){
        return especiesRepository.findById(id);
    } // Obtener uno por id
    public Optional<Especies> getByNombreEspecie(String nombreEspecie){
        return especiesRepository.findByNombreEspecie(nombreEspecie);
    }

    public void  save(Especies especies){especiesRepository.save(especies);}
    public void delete(int id) {especiesRepository.deleteById(id);}

    public boolean existsById(int id){return especiesRepository.existsById(id);
    }

    public boolean existsByNombreEspecie(String nombreEspecie) {return especiesRepository.existsByNombreEspecie(nombreEspecie);
    }
}
