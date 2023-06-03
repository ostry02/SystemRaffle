package org.example;


import org.example.draw.DrawSystem;
import org.example.draw.SeparateSizes;
import org.example.draw.email.MailMessagePrep;
import org.example.draw.email.MailSender;
import org.example.product.ProductSizes;
import org.example.raffle.RaffleActivity;
import org.example.raffle.RaffleInfo;
import org.example.raffle.RaffleSizesStock;
import org.example.sql.DataBaseControllerRaffleProducts;
import org.example.sql.DataBaseControllerSubmissions;
import org.example.user.UserInfo;

import javax.mail.Transport;
import javax.mail.internet.MimeMessage;
import java.time.LocalDate;


import static java.util.Collections.singletonList;

public class Main {

    public static void main(String[] args) {
        /* Podłącznie sie do Baz Danych */
        DataBaseControllerSubmissions dBCSub = new DataBaseControllerSubmissions();
        DataBaseControllerRaffleProducts dBCRProd = new DataBaseControllerRaffleProducts();
        System.out.println();

        /* Ustalamy stock dla każdego rozmiru z osobna */
        RaffleSizesStock raffleSizesStock = new RaffleSizesStock(1,1,1,1,1,5,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1);
        raffleSizesStock.assignStock();

        /* Ustalamy dane nowego raffla i tworzymy funkcje która sprawdzy czy jest aktywyny */
        RaffleInfo defultRaffleInfo = new RaffleInfo("Yeezy 450 ","BC3234",1100.0,
                LocalDate.of(2023,5,2), LocalDate.of(2023,5,10)); // to jest nie wazne
        RaffleActivity raffleActivity = new RaffleActivity(defultRaffleInfo.getProductName(), defultRaffleInfo.getProductSKU(), defultRaffleInfo.getProductPrice(),  defultRaffleInfo.getStartRaffleDate(),defultRaffleInfo.getEndRaffleDate());

        /* Dodajemy raffla do naszej bazy danych z danymi ustalonymi wcześniej */
//        dBCRProd.AddRaffle(defultRaffleInfo, raffleActivity, raffleSizesStock);
        System.out.println();


        /* Tworzymy rozmiary dla uzytkownika */
        ProductSizes productSizes = new ProductSizes();


        /* Ustalenie dancyh uzytkownika, ktory zostanie dodany do danego raffle */
        UserInfo userInfo = new UserInfo("Iwona","Ostrowska","q@gdadsamail.com",
                "43ewewdsdaad344", singletonList(productSizes.universalSizesCM().get(5)),"Grabiszynka","337","52-402","poland",
                "dsqwewdaeedsww");

        /* Dodanie uzytkownika do danego raffle z danymi wyżej ustalonymi */
//        dBCSub.addSubmission(userInfo,15);



        /* Tworzenie danych do losowania na bazie wczeniejszych stock */
        SeparateSizes separateSizes = new SeparateSizes(dBCSub);
        DrawSystem drawSystem = new DrawSystem(raffleSizesStock.getStockForSize4(), raffleSizesStock.getStockForSize45(), raffleSizesStock.getStockForSize5(), raffleSizesStock.getStockForSize55(), raffleSizesStock.getStockForSize6(), raffleSizesStock.getStockForSize65(), raffleSizesStock.getStockForSize7(), raffleSizesStock.getStockForSize75(), raffleSizesStock.getStockForSize8(), raffleSizesStock.getStockForSize85(), raffleSizesStock.getStockForSize9(), raffleSizesStock.getStockForSize95(), raffleSizesStock.getStockForSize10(), raffleSizesStock.getStockForSize105(), raffleSizesStock.getStockForSize11(), raffleSizesStock.getStockForSize115(), raffleSizesStock.getStockForSize12(), raffleSizesStock.getStockForSize125(), raffleSizesStock.getStockForSize13(), raffleSizesStock.getStockForSize135(), raffleSizesStock.getStockForSize14(),dBCSub,separateSizes);
        /* Losowanie danego rozmiaru */
        drawSystem.DrawForSize(15,4.0);

        MailSender mailSender = new MailSender(drawSystem);
        mailSender.SendEmail();

    }
}