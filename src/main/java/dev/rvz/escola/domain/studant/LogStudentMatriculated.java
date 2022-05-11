package dev.rvz.escola.domain.studant;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogStudentMatriculated {

    public void reactTo(StudentMatriculated studentMatriculated) {
        CPF cpf = studentMatriculated.getCpf();
        LocalDateTime moment = studentMatriculated.moment();
        String dateMomentFormatted = moment.format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss"));

        System.out.println("Student with CPF " + cpf.getValue() + " on date " + dateMomentFormatted);
    }
}
