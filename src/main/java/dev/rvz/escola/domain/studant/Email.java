package dev.rvz.escola.domain.studant;

public class Email {

    private final String address;

    public Email(String address) {
        validationAddressMail(address);

        this.address = address;
    }

    private void validationAddressMail(String address) {
        if (address == null || !address.matches("^(.+)@(.+)$")) {
            throw new IllegalArgumentException("Address e-mail invalid!");
        }
    }

    public String getAddress() {
        return address;
    }
}
