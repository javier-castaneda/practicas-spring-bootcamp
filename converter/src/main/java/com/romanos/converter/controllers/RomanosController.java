package com.romanos.converter.controllers;


import com.romanos.converter.entities.Romano;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RomanosController {

    @GetMapping("/roman")
    public Romano getRoman(@RequestParam(value = "number", defaultValue = "0") String number){
        return new Romano(Integer.parseInt(number));
    }

}
