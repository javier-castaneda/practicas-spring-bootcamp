package com.jfcc.food.services;

import com.jfcc.food.dto.*;
import com.jfcc.food.repositories.IngredientRepositoryImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class CalculatorServiceImpl implements CalculateService {

    private IngredientRepositoryImpl ingredientRepository;


    private Integer calculateCalories(String ingName, Integer weight){
        IngredientDTO ing;
        ing = ingredientRepository.findbyName(ingName);
        return ing.getCalories()*weight;
    }
    
    private Integer calculateTotalCalories(PlateDTO plate){
        Integer total = 0;
        for (IngredientInputDTO entry: plate.getIngredients()) {
            total += calculateCalories(entry.getName(),entry.getWeight());
        }
        return total;
    }

    private List<IngredientResponseDTO> calculateIngredients(PlateDTO plate){
        List<IngredientResponseDTO> ingredientDTOS = new ArrayList<>();
        for (IngredientInputDTO ing: plate.getIngredients()) {
            if(ingredientRepository.exist(ing.getName())){
                IngredientResponseDTO ingredientResponseDTO = new IngredientResponseDTO();
                ingredientResponseDTO.setName(ing.getName());
                ingredientResponseDTO.setWeight(ing.getWeight());
                ingredientResponseDTO.setCalories(ingredientRepository.findbyName(ing.getName()).getCalories());
                ingredientDTOS.add(ingredientResponseDTO);
            }
        }
        return ingredientDTOS;
    }

    private String calculateMostCaloric(PlateDTO plate){
        String mostCaloric = "";
        Integer maxCalories = 0;
        for (IngredientInputDTO ing: plate.getIngredients()) {
            if(ingredientRepository.exist(ing.getName())){
                if(ingredientRepository.findbyName(ing.getName()).getCalories()>maxCalories){
                    mostCaloric = ing.getName();
                    maxCalories = ingredientRepository.findbyName(ing.getName()).getCalories();
                }
            }
        }
        return mostCaloric;
    }

    @Override
    public ResponseDTO calculate(PlateDTO plate) {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setName(plate.getName());
        responseDTO.setTotalCalories(calculateTotalCalories(plate));
        responseDTO.setIngredients(calculateIngredients(plate));
        responseDTO.setMostCaloricIngredient(calculateMostCaloric(plate));
        return responseDTO;
    }

    public List<ResponseDTO> calculateMultiple(List<PlateDTO> listPlate){
        List<ResponseDTO> listResponse = new ArrayList<>();
        for (PlateDTO plate: listPlate) {
            listResponse.add(calculate(plate));
        }
        return listResponse;
    }

}
