package dev.rvz.escola.academic.domain.indication;

import dev.rvz.escola.academic.domain.student.Studant;

import java.time.LocalDateTime;

public class Indication {

    private final Studant indicated;
    private final Studant pointer;
    private final LocalDateTime dateIndication;

    public Indication(Studant indicated, Studant pointer, LocalDateTime dateIndication) {
        this.indicated = indicated;
        this.pointer = pointer;
        this.dateIndication = dateIndication;
    }

    public Studant getIndicated() {
        return indicated;
    }

    public Studant getPointer() {
        return pointer;
    }

    public LocalDateTime getDateIndication() {
        return dateIndication;
    }
}
