package dev.rvz.escola;

import dev.rvz.escola.academic.application.matriculate.MatriculateDTO;
import dev.rvz.escola.academic.application.matriculate.MatriculateService;
import dev.rvz.escola.academic.domain.student.LogStudentMatriculated;
import dev.rvz.escola.academic.domain.student.StudantRepository;
import dev.rvz.escola.academic.infra.studant.StudantRepositoryJDBC;
import dev.rvz.escola.game.GenerateStampStudentNewber;
import dev.rvz.escola.game.domain.stamp.StampRepository;
import dev.rvz.escola.game.infra.stamp.StampRepositoryJDBC;
import dev.rvz.escola.shared.domain.events.PublishEvents;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MatriculateCommandLine {
    public static void main(String[] args) {
        PublishEvents publishEvents = new PublishEvents();
        publishEvents.add(new LogStudentMatriculated());
        publishEvents.add(new GenerateStampStudentNewber(getStampRepository()));

        MatriculateService matriculateService = new MatriculateService(createStudentRepository(), publishEvents);
        matriculateService.execute(createDTO(args));
    }

    private static StampRepository getStampRepository() {
        StampRepository stampRepository = new StampRepositoryJDBC(getEntityManager());
        return stampRepository;
    }

    private static MatriculateDTO createDTO(String[] args) {
        String CPF = args[0];
        String name = args[1];
        String email = args[2];
        MatriculateDTO matriculateDTO = new MatriculateDTO(CPF, email, name);

        return matriculateDTO;
    }

    private static StudantRepository createStudentRepository() {
        EntityManager entityManager = getEntityManager();
        StudantRepository studantRepository = new StudantRepositoryJDBC(entityManager);

        return studantRepository;
    }

    private static EntityManager getEntityManager() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("dev.rvz.escola.DATABASE");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager;
    }
}
