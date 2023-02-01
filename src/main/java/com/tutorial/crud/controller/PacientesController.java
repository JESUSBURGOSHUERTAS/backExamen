package com.tutorial.crud.controller;

import java.util.List;


import com.tutorial.crud.dto.Mensaje;

import com.tutorial.crud.entity.Pacientes;
import com.tutorial.crud.entity.Razas;
import com.tutorial.crud.service.PacientesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pacientes")
@CrossOrigin(origins = "http://localhost:4200")
public class PacientesController {

    @Autowired
    PacientesService pacientesService;


    @GetMapping("/lista")
    public ResponseEntity<List<Pacientes>> list(){
        List<Pacientes> list = pacientesService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    @GetMapping("detail/{idpaciente}")
    public ResponseEntity<Pacientes> getById(@PathVariable("idpaciente") int idpaciente){
        if (!pacientesService.existsById(idpaciente))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Pacientes pacientes = pacientesService.getOne(idpaciente).get();
        return new ResponseEntity(pacientes, HttpStatus.OK);
    }

    @GetMapping("/detailname/{nombre}")
    public ResponseEntity<Pacientes> getByNombre(@PathVariable("nombre") String nombre){
        if(!pacientesService.existsByNombre(nombre))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Pacientes pacientes = pacientesService.getByNombre(nombre).get();
        return new ResponseEntity(pacientes, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Pacientes> save(@RequestBody Pacientes pacientes) {
        pacientesService.save(pacientes);
        return ResponseEntity.ok(pacientes);
    }

    @PutMapping("/update/{idpaciente}")
    public ResponseEntity<Pacientes> update(@PathVariable int idpaciente, @RequestBody Pacientes pacientes) {
        if (!pacientesService.existsById(idpaciente)) {
            return ResponseEntity.notFound().build();
        }
        pacientes.setIdpaciente(idpaciente);
        pacientesService.save(pacientes);
        return ResponseEntity.ok(pacientes);
    }


    @DeleteMapping("/delete/{idpaciente}")
    public ResponseEntity<?> delete(@PathVariable("idpaciente")int idpaciente){
        if(!pacientesService.existsById(idpaciente))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        pacientesService.delete(idpaciente);
        return new ResponseEntity(new Mensaje("paciente eliminado"), HttpStatus.OK);
    }


}
