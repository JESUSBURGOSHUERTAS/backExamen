package com.tutorial.crud.controller;


import com.tutorial.crud.dto.ProductoDto;
import com.tutorial.crud.dto.RazasDto;
import com.tutorial.crud.dto.Mensaje;
import com.tutorial.crud.entity.Especies;
import com.tutorial.crud.entity.Producto;
import com.tutorial.crud.entity.Razas;
import com.tutorial.crud.repository.EspeciesRepository;
import com.tutorial.crud.service.RazasService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/razas")
@CrossOrigin(origins = "http://localhost:4200")
public class RazasController {

    @Autowired
    RazasService razasService;
    @Autowired
    private EspeciesRepository especiesRepository;

    @GetMapping("/lista")
    public ResponseEntity<List<Razas>> list(){
        List<Razas> list = razasService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("detail/{idraza}")
    public ResponseEntity<Razas> getById(@PathVariable("idraza") int idraza){
        if (!razasService.existsById(idraza))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Razas razas = razasService.getOne(idraza).get();
        return new ResponseEntity(razas, HttpStatus.OK);
    }

    @GetMapping("/detailname/{nombre}")
    public ResponseEntity<Razas> getByNombre(@PathVariable("nombreRaza") String nombreRaza){
        if(!razasService.existsByNombreRaza(nombreRaza))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Razas razas = razasService.getByNombreRaza(nombreRaza).get();
        return new ResponseEntity(razas, HttpStatus.OK);
    }


    @PostMapping("/create")
    public ResponseEntity<RazasDto> create(@Valid @RequestBody RazasDto razasDto) {
        Especies especies = especiesRepository.findById(razasDto.getId()).orElse(null);
        Razas razas = new Razas(razasDto.getNombreRaza(), especies);
        razasService.save(razas);
        RazasDto razasDtoCreada = new RazasDto(razas.getNombreRaza(), razas.getEspecies().getId());
        return new ResponseEntity<>(razasDtoCreada, HttpStatus.CREATED);
    }

    @PutMapping("/update/{idraza}")
    public ResponseEntity<RazasDto> update(@PathVariable("idraza") int idraza, @Valid @RequestBody RazasDto razasDto) {
        if (!razasService.existsById(idraza))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Especies especies = especiesRepository.findById(razasDto.getId()).orElse(null);
        Razas razas = new Razas(razasDto.getNombreRaza(), especies);
        razas.setIdraza(idraza);
        razasService.save(razas);
        RazasDto razasDtoActualizada = new RazasDto(razas.getNombreRaza(), razas.getEspecies().getId());
        return new ResponseEntity<>(razasDtoActualizada, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{idraza}")
    public ResponseEntity<?> delete(@PathVariable("idraza")int idraza){
        if(!razasService.existsById(idraza))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        razasService.delete(idraza);
        return new ResponseEntity(new Mensaje("producto eliminado"), HttpStatus.OK);
    }




}
