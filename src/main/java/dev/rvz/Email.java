package dev.rvz;

public class Email {

    private final String address;

    public Email(String address) {
        validationAddressMail(address);

        this.address = address;
    }

    private void validationAddressMail(String address) {
        if (address == null ||
                address.matches("/^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$/")) {
            throw new IllegalArgumentException("Address e-mail invalid!");
        }
    }
}
