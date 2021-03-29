package com.jfcc.casa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DTOHabitacion {
    private String nombre;
    private double ancho;
    private double largo;
}
