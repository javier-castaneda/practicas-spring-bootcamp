package com.jfcc.starwars.services;

import com.jfcc.starwars.dto.ResponseDTO;

public interface CharacterService {
    public ResponseDTO getCharacters(String s);
}
