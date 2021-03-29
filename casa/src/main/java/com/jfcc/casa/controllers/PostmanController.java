package com.jfcc.casa.controllers;

import com.jfcc.casa.dto.DTOCasa;
import com.jfcc.casa.dto.DTOHabitacion;
import com.jfcc.casa.services.PostmanServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostmanController {

    @PostMapping("/totalMetros")
    public ResponseEntity getMetros(@RequestBody DTOCasa casa){
        return new ResponseEntity(PostmanServices.getTotalMetros(casa), HttpStatus.OK);
    }

    @PostMapping("/cotizacion")
    public ResponseEntity getValor(@RequestBody DTOCasa casa){
        return new ResponseEntity(PostmanServices.getValor(casa), HttpStatus.OK);
    }

    @PostMapping("/habMayor")
    public ResponseEntity getMayor(@RequestBody DTOCasa casa){
        return new ResponseEntity(PostmanServices.getHabMayor(casa), HttpStatus.OK);
    }

    @PostMapping("/habitaciones")
    public ResponseEntity getHabs(@RequestBody DTOCasa casa){
        return new ResponseEntity(PostmanServices.getAreas(casa), HttpStatus.OK);
    }


}
