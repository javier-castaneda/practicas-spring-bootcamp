package com.jfcc.food.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;

@Data
@NoArgsConstructor
public class ResponseDTO {
    private String name;
    private Integer totalCalories;
    private List<IngredientResponseDTO> ingredients;
    private String MostCaloricIngredient;

}
