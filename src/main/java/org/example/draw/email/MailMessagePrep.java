package org.example.draw.email;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailMessagePrep {
    public static MimeMessage prepareTextMessageObject(String recipent, String subject, String content) throws MessagingException {
        MimeMessage textMessage = prepareTextMessageObject(recipent, subject);
        textMessage.setText(content);
        return textMessage;
    }

    private static MimeMessage prepareTextMessageObject(String recipent, String subject) throws MessagingException {
        Properties properties = MailConfig.getConfiguration();
        MailAuth authentication = new MailAuth();

        Session session = Session.getInstance(properties, authentication);

        MimeMessage mimeMessage = new MimeMessage(session);
        mimeMessage.setSubject(subject,"UTF-8");
        PasswordAuthentication passwordAuthentication = authentication.getPasswordAuthentication();
        mimeMessage.setFrom(passwordAuthentication.getUserName());
        mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(recipent));
        return mimeMessage;

    }
}
