package org.example;

import org.example.raffle.RaffleActivity;
import org.example.raffle.RaffleInfo;
import org.example.sql.DataBaseControllerRaffleProducts;
import org.example.sql.DataBaseControllerSubmissions;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        DataBaseControllerSubmissions dBCSub = new DataBaseControllerSubmissions();
        DataBaseControllerRaffleProducts dBCRProd = new DataBaseControllerRaffleProducts();
        System.out.println(dBCSub.displayDataBaseSUBMISSIONS());
        System.out.println(dBCRProd.displayDataBaseRAFFLEPRODUCTS());
        RaffleInfo raffleInfo = new RaffleInfo("Jordan 4",
                "CT8527-400",
                "899",
                LocalDate.of(2023, 4,10),
                LocalDate.of(2023, 4,15));
        RaffleActivity raffleActivity = new RaffleActivity(raffleInfo.getProductName(), raffleInfo.getProductSKU(),
                raffleInfo.getProductPrice(), raffleInfo.getStartRaffleDate(),raffleInfo.getEndRaffleDate());
        System.out.println(raffleActivity.isActive());
    }
}