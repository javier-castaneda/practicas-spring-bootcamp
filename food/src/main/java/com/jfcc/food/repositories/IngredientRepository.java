package com.jfcc.food.repositories;

import com.jfcc.food.dto.IngredientDTO;

public interface IngredientRepository {
    public IngredientDTO findbyName(String name);
}
