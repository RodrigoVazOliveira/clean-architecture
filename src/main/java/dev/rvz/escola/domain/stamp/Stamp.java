package dev.rvz.escola.domain.stamp;

import dev.rvz.escola.domain.studant.CPF;

public class Stamp {

    private final CPF cpf;
    private final String name;

    public Stamp(CPF cpf, String name) {
        this.cpf = cpf;
        this.name = name;
    }

    public CPF getCpf() {
        return cpf;
    }

    public String getName() {
        return name;
    }
}
