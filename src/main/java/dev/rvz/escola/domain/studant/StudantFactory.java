package dev.rvz.escola.domain.studant;

import java.util.ArrayList;

public class StudantFactory {

    private Studant studant;

    public StudantFactory createStudanteWithNameAndCPFAndEmail(String name, String CPF, String addressEmail) {
        CPF cpf = new CPF(CPF);
        Email email = new Email(addressEmail);
        Contact contact = new Contact(email, new ArrayList<>());

        this.studant = new Studant(cpf, name, contact);

        return this;
    }

    public StudantFactory withTelephone(String ddd, String number) {
        studantIsNull();
        this.studant.addTelephone(ddd, number);
        return this;
    }

    private void studantIsNull() {
        if (this.studant == null) {
            throw new NullPointerException("Not created Studant!");
        }
    }

    public Studant created() {
        return studant;
    }
}
