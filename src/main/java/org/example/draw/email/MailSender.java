package org.example.draw.email;

import org.example.draw.DrawSystem;

import javax.mail.Transport;
import javax.mail.internet.MimeMessage;

public class MailSender{
    DrawSystem drawSystem;


    public MailSender(DrawSystem drawSystem) {
        this.drawSystem = drawSystem;
    }

    public void SendEmail(){
        try {
            for (int i=0;i<drawSystem.getListOfWinnersEmail().size();i++) {
                MimeMessage message = MailMessagePrep.prepareTextMessageObject(drawSystem.getListOfWinnersEmail().get(i),
                        "Gratulacje, Wygrales Raffle",
                        "BRAWOOO \n " +
                                "Wygrałes Raffle odnośnie\n" +
                                "tym samym masz szanse zakupu butów");
                Transport.send(message);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
