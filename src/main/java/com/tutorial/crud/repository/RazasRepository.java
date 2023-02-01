package com.tutorial.crud.repository;


import com.tutorial.crud.entity.Razas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface RazasRepository extends JpaRepository<Razas, Integer> {
    Optional<Razas> findByNombreRaza(String nombreRaza);
    boolean existsByNombreRaza(String nombreRaza);
}
