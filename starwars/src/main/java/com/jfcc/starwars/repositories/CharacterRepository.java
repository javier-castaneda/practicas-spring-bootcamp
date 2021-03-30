package com.jfcc.starwars.repositories;

import com.jfcc.starwars.dto.CharacterDTO;

import java.util.List;

public interface CharacterRepository {
    public List<CharacterDTO> getbyNameCoincidences(String s);
}
