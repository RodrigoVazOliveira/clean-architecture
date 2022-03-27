package dev.rvz.studant;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TelephoneTest {

    @Test
    void CreateTelephoneWithDDDInvalid() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Telephone(null, "91234-1234"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Telephone("", "91234-1234"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Telephone("000", "91234-1234"));
    }

    @Test
    void CreateTelephoneWithNumberInvalid() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Telephone("034", null));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Telephone("034", ""));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Telephone("034", "911234-1234"));
    }

    @Test
    void createTelephoneWithSuccess() {
        Telephone telephone = new Telephone("034", "91234-4321");
        Assertions.assertTrue(telephone.getDdd().equals("034"));
        Assertions.assertTrue(telephone.getNumber().equals("91234-4321"));
    }
}