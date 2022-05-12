package dev.rvz.escola.academic.domain.student;

public class Email {
    private final String address;

    public Email(String address) {
        validationAddressMail(address);

        this.address = address;
    }

    private void validationAddressMail(String address) {
        if (address == null || !address.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            throw new IllegalArgumentException("Address e-mail invalid!");
        }
    }

    public String getAddress() {
        return address;
    }
}
