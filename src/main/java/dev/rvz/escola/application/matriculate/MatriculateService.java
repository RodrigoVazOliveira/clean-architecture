package dev.rvz.escola.application.matriculate;

import dev.rvz.escola.domain.PublishEvents;
import dev.rvz.escola.domain.studant.Studant;
import dev.rvz.escola.domain.studant.StudantRepository;
import dev.rvz.escola.domain.studant.StudentMatriculated;

public class MatriculateService {

    private final StudantRepository studantRepository;
    private final PublishEvents publishEvents;

    public MatriculateService(StudantRepository studantRepository, PublishEvents publishEvents) {
        this.studantRepository = studantRepository;
        this.publishEvents = publishEvents;
    }

    public void execute(MatriculateDTO matriculateDTO) {
        Studant studant = matriculateDTO.createStudent();
        this.studantRepository.registration(studant);

        StudentMatriculated studentMatriculated = new StudentMatriculated(studant.getCpf());
        this.publishEvents.publish(studentMatriculated);
    }
}
