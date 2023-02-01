package com.tutorial.crud.repository;

import com.tutorial.crud.entity.Dueno;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DuenoRepository extends JpaRepository<Dueno, Integer> {
    Optional<Dueno> findByNombre(String nombre);
    boolean existsByNombre(String nombre);
}
