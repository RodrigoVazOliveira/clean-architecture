package dev.rvz;

public class Contact {
    private final String ddd;
    private final String number;

    public Contact(String ddd, String number) {
        if (ddd == null || !ddd.matches("^[0][1-9][1-9]$")) {
            throw new IllegalArgumentException("DDD inputed is invalid!");
        }

        if (number == null || !number.matches("^(?:[2-8]|9[1-9])[0-9]{3}\\-[0-9]{4}$")) {
            throw new IllegalArgumentException("number inputed is invalid!");
        }

        this.ddd = ddd;
        this.number = number;
    }

    public String getDdd() {
        return ddd;
    }

    public String getNumber() {
        return number;
    }
}
