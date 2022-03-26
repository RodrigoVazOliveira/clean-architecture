package dev.rvz;

public class Telephone {
    private final String ddd;
    private final String number;

    public Telephone(String ddd, String number) {
        invalidDDD(ddd);
        invalidNumber(number);
        this.ddd = ddd;
        this.number = number;
    }

    private void invalidNumber(String number) {
        if (number == null || !number.matches("^(?:[2-8]|9[1-9])[0-9]{3}\\-[0-9]{4}$")) {
            throw new IllegalArgumentException("number inputed is invalid!");
        }
    }

    private void invalidDDD(String ddd) {
        if (ddd == null || !ddd.matches("^[0][1-9][1-9]$")) {
            throw new IllegalArgumentException("DDD inputed is invalid!");
        }
    }

    public String getDdd() {
        return ddd;
    }

    public String getNumber() {
        return number;
    }
}