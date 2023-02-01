package com.tutorial.crud.repository;

import com.tutorial.crud.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> { //tipo de dato y tipo de dato del id
    Optional<Producto> findByNombre(String nombre);
    boolean existsByNombre(String nombre);
}
