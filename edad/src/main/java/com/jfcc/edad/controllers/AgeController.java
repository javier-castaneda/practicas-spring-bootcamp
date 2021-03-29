package com.jfcc.edad.controllers;


import com.jfcc.edad.services.AgeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AgeController {

    @GetMapping("/{day}/{month}/{year}")
    public int getAge(@PathVariable int day, @PathVariable int month, @PathVariable int year){

        return AgeService.convertirEdad(day, month, year);
    }
}
