package com.tutorial.crud.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tutorial.crud.entity.Pacientes;

import java.util.Optional;

@Repository
public interface PacientesRepository extends JpaRepository<Pacientes, Integer> {

    Optional<Pacientes> findByNombre(String nombre);
    boolean existsByNombre(String nombre);
}
