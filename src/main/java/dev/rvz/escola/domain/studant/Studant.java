package dev.rvz.escola.domain.indication.studant;

import java.util.List;

public class Studant {

    private final CPF CPF;
    private final String name;
    private final Contact contact;

    public Studant(dev.rvz.escola.domain.indication.studant.CPF CPF, String name, Contact contact) {
        this.CPF = CPF;
        this.name = name;
        this.contact = contact;
    }

    public void addTelephone(String ddd, String number) {
        List<Telephone> telephones = this.contact.getTelephones();
        telephones.add(new Telephone(ddd, number));
    }

    public Contact getContact() {
        return contact;
    }

    public dev.rvz.escola.domain.indication.studant.CPF getCPF() {
        return CPF;
    }
}