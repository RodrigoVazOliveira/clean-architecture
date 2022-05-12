package dev.rvz.escola.academic.domain.student;

public class CPF {

    private final String value;

    public CPF(String value) {
        isValidValueCPF(value);
        this.value = value;
    }

    private void isValidValueCPF(String value) {
        if (value == null || !value.matches("^([0-9]{3}\\.?){3}-?[0-9]{2}$")) {
            throw new IllegalArgumentException("CPF inputed is invalid!");
        }
    }

    public String getValue() {
        return value;
    }
}
