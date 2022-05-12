package dev.rvz.escola.game.domain.stamp;

import dev.rvz.escola.shared.domain.CPF;

public interface StampRepository {
    Stamp register(Stamp stamp);

    Stamp findByCPF(CPF cpf);
}
