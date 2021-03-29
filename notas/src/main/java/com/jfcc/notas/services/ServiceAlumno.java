package com.jfcc.notas.services;

import com.jfcc.notas.dto.DTOAlumno;
import com.jfcc.notas.dto.DTODiploma;

public class ServiceAlumno {
    public static DTODiploma getDiploma(DTOAlumno alumno) {
        return new DTODiploma(alumno);
    }
}
