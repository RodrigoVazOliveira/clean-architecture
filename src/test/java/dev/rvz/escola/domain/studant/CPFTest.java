package dev.rvz.escola.domain.studant;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CPFTest {

    @Test
    void notValidCPFValue() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new CPF(null);
        });

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new CPF("");
        });

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new CPF("00.000.000-00");
        });
    }

    @Test
    void createdWithCPFValid() {
        CPF cpf = new CPF("519.792.040-80");
        Assertions.assertTrue(cpf.getValue().equals("519.792.040-80"));
    }
}