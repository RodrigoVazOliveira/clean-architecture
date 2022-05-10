package dev.rvz.escola.domain.studant;

public interface CipherPassword {
    String cryptPassword(String password);
    Boolean  validatePassword(String passwordCrypt, String password);
}
