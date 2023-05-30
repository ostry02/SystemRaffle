package org.example.draw.email;

import java.util.Properties;

public class MailConfig {
    public static Properties getConfiguration(){
        Properties properties = new Properties();
        properties.put("mail.smtp.auth","true"); // odpowiada za wlaczneie i wylaczenie autoryzacja\i
        properties.put("mail.smtp.starttls.enable","true"); // odblokowujemy uzycie protokolu tls, rozszerzenie ssl ,dane przesylane do serwera poczty sa dod szyfrowane
        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.smtp.port","587");// lub 465
        return properties;
    }
}
