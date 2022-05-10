package dev.rvz.escola.infra.studant;

import dev.rvz.escola.domain.studant.CipherPassword;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CipherPasswordWithMD5 implements CipherPassword {

    @Override
    public String cryptPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] digest = md.digest();
            String myHash = DatatypeConverter
                    .printHexBinary(digest).toUpperCase();

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
