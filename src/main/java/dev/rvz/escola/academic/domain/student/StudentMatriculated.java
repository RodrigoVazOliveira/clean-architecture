package dev.rvz.escola.academic.domain.student;

import dev.rvz.escola.shared.domain.CPF;
import dev.rvz.escola.shared.domain.events.Event;
import dev.rvz.escola.shared.domain.events.TypeEvent;

import java.time.LocalDateTime;
import java.util.Map;

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

    @Override
    public TypeEvent type() {
        return TypeEvent.STUDENT_MATRICULATED;
    }

    @Override
    public Map<String, Object> getInfo() {
        return Map.of("CPF", this.cpf);
    }

    public CPF getCpf() {
        return cpf;
    }
}