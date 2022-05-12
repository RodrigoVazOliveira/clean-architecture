package dev.rvz.escola.game.domain.stamp;

import dev.rvz.escola.academic.domain.student.CPF;

public interface StampRepository {
    Stamp register(Stamp stamp);

    Stamp findByCPF(CPF cpf);
}
