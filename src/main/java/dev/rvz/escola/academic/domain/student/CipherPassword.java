package dev.rvz.escola.academic.domain.student;

public interface CipherPassword {
    String cryptPassword(String password);

    Boolean validatePassword(String passwordCrypt, String password);
}
