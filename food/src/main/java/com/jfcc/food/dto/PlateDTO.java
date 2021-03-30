package com.jfcc.food.dto;

import lombok.Data;

import java.util.HashMap;
import java.util.List;

@Data
public class PlateDTO {
    private String name;
    private List<IngredientInputDTO> ingredients;
}
