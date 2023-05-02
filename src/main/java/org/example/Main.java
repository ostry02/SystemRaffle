package org.example;

import org.example.product.ProductSizes;
import org.example.raffle.RaffleActivity;
import org.example.raffle.RaffleInfo;
import org.example.raffle.RaffleSizesStock;
import org.example.sql.DataBaseControllerRaffleProducts;
import org.example.sql.DataBaseControllerSubmissions;
import org.example.user.UserInfo;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        DataBaseControllerSubmissions dBCSub = new DataBaseControllerSubmissions();
        DataBaseControllerRaffleProducts dBCRProd = new DataBaseControllerRaffleProducts();
        System.out.println();
        RaffleSizesStock raffleSizesStock = new RaffleSizesStock(1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1);
        raffleSizesStock.assignStock();
        RaffleInfo defultRaffleInfo = new RaffleActivity("Nike jordan 1 high","DZ5485-031","829.99",
                LocalDate.of(2023,4,10), LocalDate.of(2023,5,6)); // to jest nie wazne
        RaffleActivity raffleActivity = new RaffleActivity(defultRaffleInfo.getProductName(), defultRaffleInfo.getProductSKU(), defultRaffleInfo.getProductSKU(),  defultRaffleInfo.getStartRaffleDate(),defultRaffleInfo.getEndRaffleDate());


        dBCRProd.AddRaffle(defultRaffleInfo, raffleActivity,raffleSizesStock);

        dBCRProd.displayID(); dBCRProd.getLastID();


        ProductSizes productSizes = new ProductSizes();



        UserInfo userInfo = new UserInfo("Jakub","Ostrowski","ostrysd1dasdasdasd810@gmail.com",
                "3323212132132","Irysowa","15","52-200","poland",
                "40","kasdasubaadasdsdoosdsddasdsdasdastry");

        dBCSub.addSubmission(userInfo,1);
        System.out.println(dBCSub.displayIDsRaffle(1));






    }
}