package dev.rvz.studant;

import dev.rvz.studant.Contact;
import dev.rvz.studant.Email;
import dev.rvz.studant.Telephone;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ContactTest {

    @Test
    void createContactWithEmailInvalid() {
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact(new Email("emailInvalido"), new ArrayList<>());
        });
        Assertions.assertTrue(exception.getMessage().equals("Address e-mail invalid!"));
    }

    @Test
    void createContactWithTelephoneInvalid() {
        IllegalArgumentException exceptionDDD = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact(new Email("email@gmail.com"), new ArrayList<>(Arrays.asList(new Telephone("000", "91234-4321"))));
        });
        IllegalArgumentException exceptionNumber = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact(new Email("email@gmail.com"), new ArrayList<>(Arrays.asList(new Telephone("034", "912341-4321"))));
        });

        Assertions.assertTrue(exceptionDDD.getMessage().equals("DDD inputed is invalid!"));
        Assertions.assertTrue(exceptionNumber.getMessage().equals("number inputed is invalid!"));
    }

    @Test
    void createContactWithSuccess() {
        Email email = new Email("email@gmail.com");
        Telephone telephone = new Telephone("034", "91234-4321");
        List<Telephone> telephones = new ArrayList<>();
        telephones.add(telephone);

        Contact contact = new Contact(email, telephones);

        Assertions.assertTrue(contact.getEmail().equals(email));
        Assertions.assertTrue(contact.getTelephones().size() == telephones.size());
    }
}