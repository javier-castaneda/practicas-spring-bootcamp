package com.jfcc.notas.dto;

import lombok.Data;

@Data
public class DTODiploma {
    private String alumno;
    private float promedio;
    private String mensaje;

    public DTODiploma(DTOAlumno estudiante) {
        alumno = estudiante.getNombre();
        promedio = 0;
        int notas = 0;
        for (DTOAsignatura i : estudiante.getNotas()) {
            promedio += i.getNota();
            notas++;
        }
        promedio = promedio / notas;

        if (promedio > 9) {
            mensaje = "Felicitaciones, has obtenido una de las mejores notas!!";
        } else {
            mensaje = "Felicitaciones";
        }

    }
}
