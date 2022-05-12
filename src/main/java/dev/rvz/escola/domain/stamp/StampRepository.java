package dev.rvz.escola.domain.stamp;

import dev.rvz.escola.domain.studant.CPF;

public interface StampRepository {
    Stamp register(Stamp stamp);

    Stamp findByCPF(CPF cpf);
}
