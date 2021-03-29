package com.jfcc.casa.services;

import com.jfcc.casa.dto.DTOCasa;
import com.jfcc.casa.dto.DTOHabitacion;

import java.util.HashMap;

public class PostmanServices {

    public static double getTotalMetros(DTOCasa casa){
        double total = 0;
        for (DTOHabitacion hab:casa.getHabitaciones()) {
            total += hab.getAncho()*hab.getLargo();
        }
        return total;
    }

    public static double getValor(DTOCasa casa){
        double total = 0;
        for (DTOHabitacion hab:casa.getHabitaciones()) {
            total += hab.getAncho()*hab.getLargo()*800;
        }
        return total;
    }

    public static DTOHabitacion getHabMayor(DTOCasa casa){
        DTOHabitacion habMay = new DTOHabitacion();
        double areaMayor = 0;
        for (DTOHabitacion hab:casa.getHabitaciones()) {
            if(hab.getAncho()*hab.getLargo()>areaMayor){
                habMay =hab;
                areaMayor = hab.getAncho()*hab.getLargo();
            }
        }
        return habMay;
    }

    public static HashMap<String, Double> getAreas(DTOCasa casa){
        HashMap<String, Double> habs = new HashMap<>();

        for (DTOHabitacion hab: casa.getHabitaciones()) {
            habs.put(hab.getNombre(),hab.getAncho()*hab.getLargo());
        }
        return habs;
    }

}
