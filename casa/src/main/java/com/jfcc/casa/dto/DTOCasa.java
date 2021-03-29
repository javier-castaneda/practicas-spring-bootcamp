package com.jfcc.casa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class DTOCasa {

    private String nombre;
    private String direccion;
    private List<DTOHabitacion> habitaciones;


}
