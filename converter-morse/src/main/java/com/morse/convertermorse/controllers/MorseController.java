package com.morse.convertermorse.controllers;

import com.morse.convertermorse.entities.CodigoMorse;
import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;

@RestController
public class MorseController {

    @GetMapping("/morse")
    public ResponseEntity<CodigoMorse> convertirMorse(@RequestParam(value = "word") String word){
        return new ResponseEntity<CodigoMorse>(new CodigoMorse(word), HttpStatus.OK);
    }

}
