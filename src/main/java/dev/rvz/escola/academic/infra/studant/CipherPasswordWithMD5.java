package dev.rvz.escola.academic.infra.studant;

import dev.rvz.escola.academic.domain.student.CipherPassword;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class CipherPasswordWithMD5 implements CipherPassword {

    @Override
    public String cryptPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] digest = md.digest();
            String myHash = Base64.getEncoder().encode(digest).toString();

            return myHash;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e.getMessage());
        }

    }

    @Override
    public Boolean validatePassword(String passwordCrypt, String password) {
        return passwordCrypt.equals(this.cryptPassword(password));
    }
}
