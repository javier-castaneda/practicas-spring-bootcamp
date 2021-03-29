package com.jfcc.notas.controllers;


import com.jfcc.notas.dto.DTOAlumno;
import com.jfcc.notas.services.ServiceAlumno;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerAlumno {

    @PostMapping("/diploma")
    public ResponseEntity getDiploma(@RequestBody DTOAlumno alumno){

        return new ResponseEntity(ServiceAlumno.getDiploma(alumno), HttpStatus.OK);
    }
}
