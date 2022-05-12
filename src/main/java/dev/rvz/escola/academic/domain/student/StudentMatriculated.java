package dev.rvz.escola.academic.domain.student;

import dev.rvz.escola.academic.domain.Event;
import dev.rvz.escola.shared.domain.CPF;

import java.time.LocalDateTime;

public class StudentMatriculated implements Event {
    private final CPF cpf;
    private final LocalDateTime moment;

    public StudentMatriculated(CPF cpf) {
        this.cpf = cpf;
        this.moment = LocalDateTime.now();
    }

    @Override
    public LocalDateTime moment() {
        return this.moment;
    }

    public CPF getCpf() {
        return cpf;
    }
}