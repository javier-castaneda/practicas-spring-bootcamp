package com.jfcc.food.controllers;


import com.jfcc.food.dto.PlateDTO;
import com.jfcc.food.dto.ResponseDTO;
import com.jfcc.food.services.CalculateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CalculatorController {

    @Autowired
    private CalculateService calculateService;

    @PostMapping("/calculate")
    public ResponseDTO getCalculation(@RequestBody PlateDTO plate){
        return calculateService.calculate(plate);
    }

    @PostMapping("/calculateMultiple")
    public List<ResponseDTO> getCalculationList(@RequestBody List<PlateDTO> platelist){
        return calculateService.calculateMultiple(platelist);
    }
}
