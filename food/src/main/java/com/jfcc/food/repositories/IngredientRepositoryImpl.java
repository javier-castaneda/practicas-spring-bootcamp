package com.jfcc.food.repositories;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jfcc.food.dto.IngredientDTO;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.List;
import java.util.Optional;

@Repository
public class IngredientRepositoryImpl implements IngredientRepository {

    public Boolean exist(String name){
        List<IngredientDTO> preciosDTOs = null;
        preciosDTOs = loadDB();
        if (preciosDTOs != null) {
            Optional<IngredientDTO> item = preciosDTOs.stream()
                    .filter(priceDTO -> priceDTO.getName().equals(name))
                    .findFirst();
            return item.isPresent();
        }
        return false;
    }

    @Override
    public IngredientDTO findbyName(String name) {
        List<IngredientDTO> ingredientDTOs = null;
        ingredientDTOs = loadDB();
        IngredientDTO result = null;
        if (ingredientDTOs != null) {
            Optional<IngredientDTO> item = ingredientDTOs.stream()
                    .filter(priceDTO -> priceDTO.getName().equals(name))
                    .findFirst();
            if (item.isPresent()) {
                result = item.get();
            }
        }
        return result;
    }

    private List<IngredientDTO> loadDB() {
        File file = null;

        try {
            file = ResourceUtils.getFile("classpath:food.json");
        } catch (Exception e) {
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<IngredientDTO>> typeReference = new TypeReference<>() {};
        List<IngredientDTO> ingredientList = null;
        try {
            ingredientList = objectMapper.readValue(file, typeReference);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ingredientList;

    }
}
