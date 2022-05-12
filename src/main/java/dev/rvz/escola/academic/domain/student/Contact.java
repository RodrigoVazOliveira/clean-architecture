package dev.rvz.escola.academic.domain.student;

import java.util.List;

public class Contact {

    private final Email email;
    private final List<Telephone> telephones;

    public Contact(Email email, List<Telephone> telephones) {
        this.email = email;
        this.telephones = telephones;
    }

    public Email getEmail() {
        return email;
    }

    public List<Telephone> getTelephones() {
        return telephones;
    }
}
