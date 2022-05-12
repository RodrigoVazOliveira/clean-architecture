package dev.rvz.escola.academic.application.indications;

import dev.rvz.escola.academic.domain.student.Studant;

import javax.mail.MessagingException;

public interface SendMailIndication {
    void sendTo(Studant StudantIndication) throws MessagingException;
}
