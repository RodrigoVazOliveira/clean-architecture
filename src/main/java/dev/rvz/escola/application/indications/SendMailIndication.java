package dev.rvz.escola.application.indications;

import dev.rvz.escola.domain.studant.Studant;

import javax.mail.MessagingException;

public interface SendMailIndication {
    void sendTo(Studant StudantIndication) throws MessagingException;
}
