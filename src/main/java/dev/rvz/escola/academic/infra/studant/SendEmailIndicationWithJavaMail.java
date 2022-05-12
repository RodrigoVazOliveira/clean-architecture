package dev.rvz.escola.academic.infra.studant;

import dev.rvz.escola.academic.application.indications.SendMailIndication;
import dev.rvz.escola.academic.domain.student.Studant;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SendEmailIndicationWithJavaMail implements SendMailIndication {
    @Override
    public void sendTo(Studant StudentIndication) throws MessagingException {
        Properties properties = setPropertiesSendEmail();
        Session session = getSession(properties);

        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(StudentIndication.getContact().getEmail().getAddress()));
        Address[] toUser = InternetAddress.parse("emaildestinatario@servidor.com");
        message.setRecipients(Message.RecipientType.TO, toUser);
        message.setSubject("Assunto");
        message.setText("Texto", "utf-8", "html");

        Transport.send(message);
    }

    private Properties setPropertiesSendEmail() {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        return props;
    }

    private Session getSession(Properties props) {
        return Session.getDefaultInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("emailrementente@servidor.com", "senha");
            }
        });
    }
}
