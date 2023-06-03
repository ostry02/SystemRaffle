package org.example;


import org.example.draw.DrawSystem;
import org.example.draw.SeparateSizes;
import org.example.draw.email.MailSender;
import org.example.product.ProductSizes;
import org.example.raffle.RaffleActivity;
import org.example.raffle.RaffleInfo;
import org.example.raffle.RaffleSizesStock;
import org.example.sql.DataBaseControllerRaffleProducts;
import org.example.sql.DataBaseControllerSubmissions;
import org.example.user.UserInfo;

import java.time.LocalDate;


import static java.util.Collections.singletonList;

public class Main {

    public static void main(String[] args) {
        /* Podłącznie sie do Baz Danych */
        DataBaseControllerSubmissions dBCSub = new DataBaseControllerSubmissions();
        DataBaseControllerRaffleProducts dBCRProd = new DataBaseControllerRaffleProducts();
        System.out.println();

        /* Ustalamy stock dla każdego rozmiru z osobna */
        RaffleSizesStock raffleSizesStock = new RaffleSizesStock(1,1,
                1,1,1,5,1,
                1,1,1,1,1,
                1,1,1,1,1,
                1,1,1,1);
        raffleSizesStock.assignStock();

        /* Ustalamy dane nowego raffla i tworzymy funkcje która sprawdzy czy jest aktywyny */
        RaffleInfo raffleInfo = new RaffleInfo("Yeezy 450 ","BC3234",1100.0,
                LocalDate.of(2023,5,2), LocalDate.of(2023,5,10)); // to jest nie wazne
        RaffleActivity raffleActivity = new RaffleActivity(raffleInfo.getProductName(), raffleInfo.getProductSKU(),
                raffleInfo.getProductPrice(),  raffleInfo.getStartRaffleDate(), raffleInfo.getEndRaffleDate());

        /* Dodajemy raffla do naszej bazy danych z danymi ustalonymi wcześniej */
//        dBCRProd.AddRaffle(defultRaffleInfo, raffleActivity, raffleSizesStock);
        System.out.println();


        /* Tworzymy rozmiary dla uzytkownika */
        ProductSizes productSizes = new ProductSizes();


        /* Ustalenie dancyh uzytkownika, ktory zostanie dodany do danego raffle */
        UserInfo userInfo = new UserInfo("Iwona","Ostrowska","q@gdadsamail.com",
                "43ewewdsdaad344", singletonList(productSizes.universalSizesCM().get(5)),
                "Grabiszynka","337","52-402","poland",
                "dsqwewdaeedsww");

        /* Dodanie uzytkownika do danego raffle z danymi wyżej ustalonymi */
//        dBCSub.addSubmission(userInfo,15);



        /* Tworzenie danych do losowania na bazie wczeniejszych stock */
        SeparateSizes separateSizes = new SeparateSizes(dBCSub);
        DrawSystem drawSystem = new DrawSystem(
                dBCSub, separateSizes, dBCRProd);
        /* Losowanie danego rozmiaru */
        drawSystem.DrawSize(15,6.5);

        /* Wysylanie maili do wygranych */
        MailSender mailSender = new MailSender(drawSystem);
//        mailSender.SendEmail();
//        System.out.println(dBCRProd.getStockPerSize(15).get(0).getStockForSize65());
    }
}