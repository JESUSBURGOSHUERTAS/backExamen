package com.tutorial.crud.repository;

import com.tutorial.crud.entity.Especies;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
@Repository
public interface EspeciesRepository extends JpaRepository<Especies, Integer> {
    Optional<Especies> findByNombreEspecie(String nombreEspecie);
    boolean existsByNombreEspecie(String nombreEspecie);

}
