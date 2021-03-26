package com.romanos.converter.entities;

import lombok.Data;

@Data
public class Romano {
    private String numeroRom;
    int numero;

    public Romano(int number) {
        this.numero = number;

        if(number > 3999 || number<0){
            numeroRom = "No se puede convertir el número "  + this.numero;
            return;
        }

        numeroRom ="";

        int miles, centenas, decenas, unidades;

        miles = number/1000;
        centenas = (number%1000)/100;
        decenas = ((number%1000)%100)/10;
        unidades = (((number %1000)%100)%10);


        for(int i = 0; i<miles;i++){
            numeroRom += "M";
        }

        if(centenas == 9){
            numeroRom +="CM";
        }else if (centenas >= 5){
            numeroRom += "D";
            for (int i = 6; i<=centenas;i++){
                numeroRom += "C";
            }
        }else if (centenas == 4){
            numeroRom += "CD";
        }else{
            for (int i = 0; i < centenas; i++) {
                numeroRom += "C";
            }
        }

        if(decenas == 9){
            numeroRom +="XC";
        }else if (decenas >= 5){
            numeroRom += "L";
            for (int i = 6; i<=decenas;i++){
                numeroRom += "X";
            }
        }else if (decenas == 4){
            numeroRom += "XL";
        }else{
            for (int i = 0; i < decenas; i++) {
                numeroRom += "X";
            }
        }


        if(unidades == 9){
            numeroRom +="IX";
        }else if (unidades >= 5){
            numeroRom += "V";
            for (int i = 6; i<=unidades;i++){
                numeroRom += "I";
            }
        }else if (unidades == 4){
            numeroRom += "IV";
        }else{
            for (int i = 0; i < unidades; i++) {
                numeroRom += "I";
            }
        }
    }
}
