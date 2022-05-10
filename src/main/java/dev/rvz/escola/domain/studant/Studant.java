package dev.rvz.escola.domain.studant;

import java.util.List;


public class Studant {

    private final CPF cpf;
    private final String name;
    private final Contact contact;
    private final String password;

    public Studant(CPF cpf, String name, Contact contact, String password) {
        this.cpf = cpf;
        this.name = name;
        this.contact = contact;
        this.password = password;
    }

    public void addTelephone(String ddd, String number) {
        List<Telephone> telephones = this.contact.getTelephones();
        telephones.add(new Telephone(ddd, number));
    }

    public Contact getContact() {
        return contact;
    }

    public CPF getCpf() {
        return cpf;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}