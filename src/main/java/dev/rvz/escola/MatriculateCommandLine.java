package dev.rvz.escola;

import dev.rvz.escola.application.matriculate.MatriculateDTO;
import dev.rvz.escola.application.matriculate.MatriculateService;
import dev.rvz.escola.domain.PublishEvents;
import dev.rvz.escola.domain.studant.LogStudentMatriculated;
import dev.rvz.escola.domain.studant.StudantRepository;
import dev.rvz.escola.infra.studant.StudantRepositoryJDBC;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MatriculateCommandLine {
    public static void main(String[] args) {
        PublishEvents publishEvents = new PublishEvents();
        publishEvents.add(new LogStudentMatriculated());

        MatriculateService matriculateService = new MatriculateService(createStudentRepository(), publishEvents);
        matriculateService.execute(createDTO(args));
    }

    private static MatriculateDTO createDTO(String[] args) {
        String CPF = args[0];
        String name = args[1];
        String email = args[2];
        MatriculateDTO matriculateDTO = new MatriculateDTO(CPF, email, name);

        return matriculateDTO;
    }

    private static StudantRepository createStudentRepository() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("dev.rvz.escola.DATABASE");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        StudantRepository studantRepository = new StudantRepositoryJDBC(entityManager);

        return studantRepository;
    }
}
