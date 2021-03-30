package com.jfcc.starwars.services;

import com.jfcc.starwars.dto.CharacterDTO;
import com.jfcc.starwars.dto.ResponseDTO;
import com.jfcc.starwars.repositories.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CharacterServiceImpl implements CharacterService{

    @Autowired
    private CharacterRepository characterRepository;

    private List<String> getCharacterNames(List<CharacterDTO> characterDTOList){
        List<String> result = new ArrayList<>();
        for (CharacterDTO character:characterDTOList) {
            result.add(character.getName());
        }
        return result;
    }

    @Override
    public ResponseDTO getCharacters(String s) {
        ResponseDTO response = new ResponseDTO();
        response.setCoincidences(getCharacterNames(characterRepository.getbyNameCoincidences(s)));
        return response;
    }
}
