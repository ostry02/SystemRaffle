package org.example.draw.email;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class MailAuth extends Authenticator { // do logowania
    @Override
    protected PasswordAuthentication getPasswordAuthentication(){
        return new PasswordAuthentication("systemraffle@gmail.com","pinndncnsslnnmxn");
    }
}