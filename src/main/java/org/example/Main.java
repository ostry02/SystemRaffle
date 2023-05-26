package org.example;

import org.example.draw.DrawSeparateSizes;
import org.example.draw.DrawSystem;
import org.example.product.ProductSizes;
import org.example.raffle.RaffleActivity;
import org.example.raffle.RaffleInfo;
import org.example.raffle.RaffleSizesStock;
import org.example.sql.DataBaseControllerRaffleProducts;
import org.example.sql.DataBaseControllerSubmissions;
import org.example.user.UserInfo;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Random;

import static java.util.Collections.singletonList;

public class Main {

    public static void main(String[] args) {
        DataBaseControllerSubmissions dBCSub = new DataBaseControllerSubmissions();
        DataBaseControllerRaffleProducts dBCRProd = new DataBaseControllerRaffleProducts();
        System.out.println();
        RaffleSizesStock raffleSizesStock = new RaffleSizesStock(1,1,1,1,1,4,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1);
        raffleSizesStock.assignStock();
//        RaffleInfo defultRaffleInfo = new RaffleActivity("Adidas Superstar","ABasdasCD-123",500.0,
//                LocalDate.of(2023,5,2), LocalDate.of(2023,5,10)); // to jest nie wazne
//        RaffleActivity raffleActivity = new RaffleActivity(defultRaffleInfo.getProductName(), defultRaffleInfo.getProductSKU(), defultRaffleInfo.getProductPrice(),  defultRaffleInfo.getStartRaffleDate(),defultRaffleInfo.getEndRaffleDate());
//
//
//        dBCRProd.AddRaffle(defultRaffleInfo, raffleActivity, raffleSizesStock);
//
//        dBCRProd.displayID(); dBCRProd.getLastID();
//
        System.out.println();
        ProductSizes productSizes = new ProductSizes();

//        System.out.println(productSizes.universalSizesCM()+" "+productSizes.universalSizesCM().size());


        DrawSystem drawSystem = new DrawSystem(raffleSizesStock.getStockForSize4(), raffleSizesStock.getStockForSize45(), raffleSizesStock.getStockForSize5(), raffleSizesStock.getStockForSize55(), raffleSizesStock.getStockForSize6(), raffleSizesStock.getStockForSize65(), raffleSizesStock.getStockForSize7(), raffleSizesStock.getStockForSize75(), raffleSizesStock.getStockForSize8(), raffleSizesStock.getStockForSize85(), raffleSizesStock.getStockForSize9(), raffleSizesStock.getStockForSize95(), raffleSizesStock.getStockForSize10(), raffleSizesStock.getStockForSize105(), raffleSizesStock.getStockForSize11(), raffleSizesStock.getStockForSize115(), raffleSizesStock.getStockForSize12(), raffleSizesStock.getStockForSize125(), raffleSizesStock.getStockForSize13(), raffleSizesStock.getStockForSize135(), raffleSizesStock.getStockForSize14(),dBCSub);
//        drawSystem.DrawForSize65(1);



        UserInfo userInfo = new UserInfo("Iwona","Ostrowska","iawasdda@gmail.com",
                "692823221", singletonList(productSizes.universalSizesCM().get(0)),"Grabiszynka","337","52-402","poland",
                "itdasdddr");

//        dBCSub.addSubmission(userInfo,1);

        DrawSeparateSizes drawSeparateSizes = new DrawSeparateSizes(dBCSub);
//        drawSeparateSizes.separateSizes(1);
        System.out.println(dBCSub.displayAllUsersFromRaffle(1).get(0).getUserSize());


    }
}