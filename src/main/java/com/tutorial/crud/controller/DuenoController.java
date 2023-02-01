package com.tutorial.crud.controller;

import com.tutorial.crud.dto.DuenoDto;

import com.tutorial.crud.dto.Mensaje;
import com.tutorial.crud.entity.Dueno;

import com.tutorial.crud.service.DuenoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/duenos")
@CrossOrigin(origins = "http://localhost:4200")
public class DuenoController {

    @Autowired
    private DuenoService duenoService;

    @GetMapping("/lista")
    public ResponseEntity<List<Dueno>> list(){
        List<Dueno> list = duenoService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("detail/{idDueno}")
    public ResponseEntity<Dueno> getById(@PathVariable("idDueno") int idDueno){
        if (!duenoService.existsById(idDueno))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Dueno dueno = duenoService.getOne(idDueno).get();
        return new ResponseEntity(dueno, HttpStatus.OK);
    }

    @GetMapping("/detailname/{nombre}")
    public ResponseEntity<Dueno> getByNombre(@PathVariable("nombre") String nombre){
        if(!duenoService.existsByNombre(nombre))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Dueno dueno = duenoService.getByNombre(nombre).get();
        return new ResponseEntity(dueno, HttpStatus.OK);
    }




    @PostMapping("/create")
    public ResponseEntity<Dueno> save(@RequestBody Dueno dueno) {
        duenoService.save(dueno);
        return ResponseEntity.ok(dueno);
    }

    @PutMapping("/update/{idDueno}")
    public ResponseEntity<Dueno> update(@PathVariable int idDueno, @RequestBody Dueno dueno) {
        if (!duenoService.existsById(idDueno)) {
            return ResponseEntity.notFound().build();
        }
        dueno.setIdDueno(idDueno);
        duenoService.save(dueno);
        return ResponseEntity.ok(dueno);
    }

    @DeleteMapping("/delete/{idDueno}")
    public ResponseEntity<?> delete(@PathVariable("idDueno")int idDueno){
        if(!duenoService.existsById(idDueno))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        duenoService.delete(idDueno);
        return new ResponseEntity(new Mensaje("especie eliminada"), HttpStatus.OK);
    }

}
