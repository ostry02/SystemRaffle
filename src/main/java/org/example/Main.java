package org.example;

import org.example.raffle.RaffleActivity;
import org.example.raffle.RaffleInfo;
import org.example.sql.DataBaseControllerRaffleProducts;
import org.example.sql.DataBaseControllerSubmissions;
import org.example.user.UserInfo;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        DataBaseControllerSubmissions dBCSub = new DataBaseControllerSubmissions();
        DataBaseControllerRaffleProducts dBCRProd = new DataBaseControllerRaffleProducts();
        System.out.println();
//        RaffleInfo jordan4 = new RaffleActivity("Jordan 4","CT852-0","899",
//                LocalDate.of(2023,4,10),LocalDate.of(2023,4,20));
//        RaffleActivity raffleActivity = new RaffleActivity("Jordan 4","CT852-0","899",
//                LocalDate.of(2023,4,10),LocalDate.of(2023,4,20));
//        jordan4.setProductPrice("1203");
//        jordan4.setProductSKU("asdasdasqe123-123");
//        dBCRProd.AddRaffle(jordan4,raffleActivity);
//        System.out.println(dBCRProd.displayID());
//        System.out.println(dBCRProd.getLastID());
        UserInfo userInfo = new UserInfo("Jakub","Ostrowski","ostry.dasdasdasdasd1dasdasdasd810@gmail.com",
                "3322132132","Irysowa","15","52-200","poland",
                "40","kubaadasdsdoosdsddasdsdasdastry");
        dBCSub.addSubmission(userInfo,29);
        System.out.println(dBCSub.displayIDRaffle(29));


//        RaffleActivity raffleActivity = new RaffleActivity(
//                dBCRProd.displayDataBaseRAFFLEPRODUCTS().get(0).getProductName(),
//                dBCRProd.displayDataBaseRAFFLEPRODUCTS().get(0).getProductSKU(),
//                dBCRProd.displayDataBaseRAFFLEPRODUCTS().get(0).getProductPrice(),
//                dBCRProd.displayDataBaseRAFFLEPRODUCTS().get(0).getStartRaffleDate(),
//                dBCRProd.displayDataBaseRAFFLEPRODUCTS().get(0).getEndRaffleDate()
//                );
//
//        System.out.println(raffleActivity.isActive());

    }
}