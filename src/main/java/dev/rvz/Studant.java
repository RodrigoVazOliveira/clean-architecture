package dev.rvz;

import java.util.List;

public class Studant {

    private final CPF CPF;
    private final String name;
    private final Contact contact;

    public Studant(dev.rvz.CPF CPF, String name, Contact contact) {
        this.CPF = CPF;
        this.name = name;
        this.contact = contact;
    }

    public void addTelephone(String ddd, String number) {
        List<Telephone> telephones = this.contact.getTelephones();
        telephones.add(new Telephone(ddd, number));
    }
}