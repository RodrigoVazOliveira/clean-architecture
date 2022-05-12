package dev.rvz.escola.application.matriculate;

import dev.rvz.escola.domain.PublishEvents;
import dev.rvz.escola.domain.studant.LogStudentMatriculated;
import dev.rvz.escola.domain.studant.StudantRepository;
import dev.rvz.escola.infra.studant.StudantRepositoryJDBC;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Connection;

public class MatriculateCommandLine {
    public static void main(String[] args) {
        String CPF = args[1];
        String name = args[2];
        String email = args[3];

        PublishEvents publishEvents = new PublishEvents();
        publishEvents.add(new LogStudentMatriculated());

        MatriculateDTO matriculateDTO = new MatriculateDTO(CPF, email, name);

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("com.rvz.escola.DATABASE");

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        StudantRepository studantRepository = new StudantRepositoryJDBC(entityManager.unwrap(Connection.class));

        studantRepository.registration(matriculateDTO.createStudent());
    }
}
