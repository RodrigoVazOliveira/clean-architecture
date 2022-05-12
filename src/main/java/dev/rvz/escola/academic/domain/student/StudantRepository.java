package dev.rvz.escola.academic.domain.student;

import dev.rvz.escola.shared.domain.CPF;

import java.util.List;

public interface StudantRepository {
    void registration(Studant studant);

    Studant findByCPF(CPF cpf);

    List<Studant> getAllRegistrations();
}
