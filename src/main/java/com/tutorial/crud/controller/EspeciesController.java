package com.tutorial.crud.controller;

import com.tutorial.crud.dto.EspeciesDto;
import com.tutorial.crud.dto.Mensaje;
import com.tutorial.crud.entity.Especies;
import com.tutorial.crud.service.EspeciesService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/especies")
@CrossOrigin(origins = "http://localhost:4200")
public class EspeciesController {

    @Autowired
    EspeciesService especiesService;

    @GetMapping("/lista")
    public ResponseEntity<List<Especies>> list(){
        List<Especies> list = especiesService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("detail/{id}")
    public ResponseEntity<Especies> getById(@PathVariable("id") int id){
        if (!especiesService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Especies especies = especiesService.getOne(id).get();
        return new ResponseEntity(especies, HttpStatus.OK);
    }

    @GetMapping("/detailname/{nombre}")
    public ResponseEntity<Especies> getByNombre(@PathVariable("nombreEspecie") String nombreEspecie){
        if(!especiesService.existsByNombreEspecie(nombreEspecie))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Especies especies = especiesService.getByNombreEspecie(nombreEspecie).get();
        return new ResponseEntity(especies, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody EspeciesDto especiesDto){
        if(StringUtils.isBlank(especiesDto.getNombreEspecie()))
            return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(especiesService.existsByNombreEspecie(especiesDto.getNombreEspecie()))
            return new ResponseEntity(new Mensaje("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        Especies especies = new Especies(especiesDto.getNombreEspecie());
        especiesService.save(especies);
        return new ResponseEntity(new Mensaje("especie creada"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody EspeciesDto especiesDto){
        if(!especiesService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        if(especiesService.existsByNombreEspecie(especiesDto.getNombreEspecie()) && especiesService.getByNombreEspecie(especiesDto.getNombreEspecie()).get().getId() != id)
            return new ResponseEntity(new Mensaje("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(especiesDto.getNombreEspecie()))
            return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);


        Especies especies = especiesService.getOne(id).get(); //obtengo el producto por id
        especies.setNombreEspecie(especiesDto.getNombreEspecie());
        especiesService.save(especies);
        return new ResponseEntity(new Mensaje("especie actualizada"), HttpStatus.OK); //codigo 200
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        if(!especiesService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        especiesService.delete(id);
        return new ResponseEntity(new Mensaje("especie eliminada"), HttpStatus.OK);
    }

}
