package dev.rvz.escola.domain.studant;

import java.util.List;

public interface StudantRepository {
    void registration(Studant studant);
    Studant findByCPF(CPF cpf);
    List<Studant> getAllRegistrations();
}
