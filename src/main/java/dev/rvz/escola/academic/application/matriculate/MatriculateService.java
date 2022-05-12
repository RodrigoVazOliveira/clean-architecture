package dev.rvz.escola.academic.application.matriculate;

import dev.rvz.escola.academic.domain.PublishEvents;
import dev.rvz.escola.academic.domain.student.Studant;
import dev.rvz.escola.academic.domain.student.StudantRepository;
import dev.rvz.escola.academic.domain.student.StudentMatriculated;

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
