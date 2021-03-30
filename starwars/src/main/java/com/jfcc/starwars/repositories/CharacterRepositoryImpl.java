package com.jfcc.starwars.repositories;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jfcc.starwars.dto.CharacterDTO;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


@Repository
public class CharacterRepositoryImpl implements CharacterRepository {

    @Override
    public List<CharacterDTO> getbyNameCoincidences(String s) {
        List<CharacterDTO> characterDTOs = null;
        characterDTOs = loadDB();
        List<CharacterDTO> result = new ArrayList<>();
        if (characterDTOs != null) {
            for (CharacterDTO character : characterDTOs) {
                if (character.getName().contains(s)) {
                    result.add(character);
                }
            }
        }
        return result;
    }

    private List<CharacterDTO> loadDB() {
        File file = null;

        try {
            file = ResourceUtils.getFile("classpath:starwars.json");
        } catch (Exception e) {
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<CharacterDTO>> typeReference = new TypeReference<>() {
        };
        List<CharacterDTO> characterList = null;
        try {
            characterList = objectMapper.readValue(file, typeReference);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return characterList;

    }

}
