package dev.rvz.escola.application.matriculate;

import dev.rvz.escola.domain.studant.CPF;
import dev.rvz.escola.domain.studant.Studant;
import dev.rvz.escola.domain.studant.StudantRepository;
import dev.rvz.escola.infra.studant.StudantRepositoryJDBC;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Connection;

class MatriculateCommandLineTest {

    @Test
    void craeteMatriculateWithSuccess() {
        String[] args = {
                "350.776.070-36",
                "Rodrigo Vaz",
                "rodrigo.vaz@email.com"
        };

        MatriculateCommandLine.main(args);

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("school-database");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        StudantRepository studantRepository = new StudantRepositoryJDBC(entityManager.unwrap(Connection.class));

        Studant studantExpect = studantRepository.findByCPF(new CPF("350.776.070-36"));

        Assertions.assertEquals("350.776.070-36", studantExpect.getCpf().getValue());
    }
}