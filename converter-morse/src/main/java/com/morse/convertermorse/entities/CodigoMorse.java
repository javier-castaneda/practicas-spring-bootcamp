package com.morse.convertermorse.entities;

import lombok.Data;

@Data
public class CodigoMorse {

    private String morse;
    private String frase;

    public CodigoMorse(String codMorse){
        morse = codMorse;
        String copiaMorse = new String(morse);

        copiaMorse = copiaMorse
                .replaceAll("\\-\\.\\.\\.", "B")
                .replaceAll("\\-\\.\\-\\.", "C")
                .replaceAll("\\.\\.\\-\\.","F")
                .replaceAll("\\.\\.\\.\\.","H")
                .replaceAll("\\.\\-\\-\\-","J")
                .replaceAll("\\.\\-\\.\\.","L")
                .replaceAll("\\.\\-\\-\\.","P")
                .replaceAll("\\-\\-\\.\\-","Q")
                .replaceAll("\\.\\.\\.\\-","V")
                .replaceAll("\\-\\.\\.\\-","X")
                .replaceAll("\\-\\.\\-\\-","Y")
                .replaceAll("\\-\\-\\.\\.","Z")
                .replaceAll("\\.\\.\\-","U")
                .replaceAll("\\.\\-\\-","W")
                .replaceAll("\\-\\.\\.","D")
                .replaceAll("\\.\\-\\.","R")
                .replaceAll("\\-\\.\\-","K")
                .replaceAll("\\-\\-\\.","G")
                .replaceAll("\\.\\.\\.","S")
                .replaceAll("\\-\\-\\-","O")
                .replaceAll("\\-\\.","N")
                .replaceAll("\\.\\-","A")
                .replaceAll("\\.\\.","I")
                .replaceAll("\\-\\-","M")
                .replaceAll("\\.","E")
                .replaceAll("\\-","T")
                .replaceAll("   ","_")
                .replaceAll("\\s","")
                .replaceAll("_"," ");

        frase = copiaMorse;


    }



}
