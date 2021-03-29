package com.jfcc.notas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class DTOAlumno {
    private String nombre;
    private List<DTOAsignatura> notas;
}
