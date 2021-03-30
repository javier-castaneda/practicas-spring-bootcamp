package com.jfcc.food.services;

import com.jfcc.food.dto.PlateDTO;
import com.jfcc.food.dto.ResponseDTO;

import java.util.List;

public interface CalculateService {
    public ResponseDTO calculate(PlateDTO plate);
    public List<ResponseDTO> calculateMultiple(List<PlateDTO> plateList);
}
