package dev.rvz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ContactTest {

    @Test
    void CreatedWithDDDInvalid() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Contact(null, "98156-0125"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Contact("", "98156-0125"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Contact("000", "98156-0125"));
    }

    @Test
    void createdWithNumberInvalids() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Contact("034", null));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Contact("034", ""));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Contact("034", "00000-00000"));
    }

    @Test
    void createdContactWithDDDAndNumberValid() {
        Contact contact = new Contact("034", "98156-0125");
        Assertions.assertTrue(contact.getDdd().equals("034"));
        Assertions.assertTrue(contact.getNumber().equals("98156-0125"));
    }
}