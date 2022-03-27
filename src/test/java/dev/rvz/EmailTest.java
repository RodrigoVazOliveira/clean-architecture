package dev.rvz;

import dev.rvz.studant.Email;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class EmailTest {

    @Test
    void notCreateEmailInvalid() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Email(null);
        });

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Email("");
        });

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Email("emailinvalido");
        });
    }

    @Test
    void createdWithEmailValid() {
        Email email = new Email("email@gmail.com");

        Assertions.assertEquals("email@gmail.com", email.getAddress());
    }
}