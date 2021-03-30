package com.jfcc.starwars.controllers;

import com.jfcc.starwars.dto.InputDTO;
import com.jfcc.starwars.dto.ResponseDTO;
import com.jfcc.starwars.services.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CharacterController {

    @Autowired
    private CharacterService characterService;

    @PostMapping("/coincidences")
    public ResponseDTO getCoincidences(@RequestBody InputDTO input){
        return characterService.getCharacters(input.getWord());
    }

}
