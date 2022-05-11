package dev.rvz.escola.domain.studant;

import dev.rvz.escola.domain.Event;
import dev.rvz.escola.domain.Listenner;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogStudentMatriculated extends Listenner {

    @Override
    protected void reactTo(Event event) {
        CPF cpf = ((StudentMatriculated) event).getCpf();
        LocalDateTime moment = event.moment();
        String dateMomentFormatted = moment.format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss"));

        System.out.println("Student with CPF " + cpf.getValue() + " on date " + dateMomentFormatted);
    }

    @Override
    protected Boolean shouldProcess(Event event) {
        return event instanceof StudentMatriculated;
    }
}
