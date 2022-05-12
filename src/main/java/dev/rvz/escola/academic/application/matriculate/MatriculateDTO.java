package dev.rvz.escola.academic.application.matriculate;

import dev.rvz.escola.academic.domain.student.CPF;
import dev.rvz.escola.academic.domain.student.Contact;
import dev.rvz.escola.academic.domain.student.Email;
import dev.rvz.escola.academic.domain.student.Studant;

import java.util.ArrayList;

public class MatriculateDTO {
    private final String CPF;
    private final String email;
    private final String name;

    public MatriculateDTO(String CPF, String email, String name) {
        this.CPF = CPF;
        this.email = email;
        this.name = name;
    }

    public Studant createStudent() {
        Email email = new Email(this.email);
        Contact contact = new Contact(email, new ArrayList<>());
        CPF cpf = new CPF(this.CPF);
        Studant studant = new Studant(cpf, this.name, contact, null);
        return studant;
    }
}
