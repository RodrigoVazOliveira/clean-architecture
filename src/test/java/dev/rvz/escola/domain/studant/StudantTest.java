package dev.rvz.escola.domain.studant;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class StudantTest {

    @Test
    void createCPFInvalid() {
        Assertions
                .assertThrows(IllegalArgumentException.class, () -> new Studant(new CPF(null), "fulano", new Contact(new Email("fulano@gmail.com"), new ArrayList<>())));
        Assertions
                .assertThrows(IllegalArgumentException.class, () -> new Studant(new CPF(""), "fulano", new Contact(new Email("fulano@gmail.com"), new ArrayList<>())));
        Assertions
                .assertThrows(IllegalArgumentException.class, () -> new Studant(new CPF("000"), "fulano", new Contact(new Email("fulano@gmail.com"), new ArrayList<>())));
    }

    @Test
    void createEmailInvalid() {
        Assertions
                .assertThrows(IllegalArgumentException.class, () -> new Studant(new CPF("000.000.000-00"), "fulano", new Contact(new Email(null), new ArrayList<>())));
        Assertions
                .assertThrows(IllegalArgumentException.class, () -> new Studant(new CPF("000.000.000-00"), "fulano", new Contact(new Email(""), new ArrayList<>())));
        Assertions
                .assertThrows(IllegalArgumentException.class, () -> new Studant(new CPF("000.000.000-00"), "fulano", new Contact(new Email("fulanail.com"), new ArrayList<>())));
    }

    @Test
    void createAddTelephoneInvalidInvalid() {
        CPF cpf = new CPF("000.000.000-00");
        Email email = new Email("fulano@gmail.com");
        Contact contact = new Contact(email, new ArrayList<>());
        Studant studant = new Studant(cpf, "fulano", contact);

        Assertions.assertThrows(IllegalArgumentException.class, () -> studant.addTelephone(null, null));
        Assertions.assertThrows(IllegalArgumentException.class, () -> studant.addTelephone("", null));
        Assertions.assertThrows(IllegalArgumentException.class, () -> studant.addTelephone("000", null));
        Assertions.assertThrows(IllegalArgumentException.class, () -> studant.addTelephone("034", null));
        Assertions.assertThrows(IllegalArgumentException.class, () -> studant.addTelephone("034", ""));
        Assertions.assertThrows(IllegalArgumentException.class, () -> studant.addTelephone("034", "912345-4132"));
    }

    @Test
    void createStudantWithSuccess() {
        CPF cpf = new CPF("000.000.000-00");
        Email email = new Email("fulano@gmail.com");
        Contact contact = new Contact(email, new ArrayList<>());
        Studant studant = new Studant(cpf, "fulano", contact);
        studant.addTelephone("034", "91234-4321");

        Assertions.assertTrue(cpf.getValue().equals(studant.getCPF().getValue()));
        Assertions.assertTrue(email.getAddress().equals(studant.getContact().getEmail().getAddress()));
        Assertions.assertTrue("034".equals(studant.getContact().getTelephones().get(0).getDdd()));
        Assertions.assertTrue("91234-4321".equals(studant.getContact().getTelephones().get(0).getNumber()));
    }
}