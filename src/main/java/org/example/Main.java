package org.example;

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
        drawSystem.DrawForSize65();
//        System.out.println(dBCSub.displayIDsRaffle(1).size());
//
//        UserInfo userInfo = new UserInfo("Iwona","Ostrowska","iawda@gmail.com",
//                "6928221", singletonList(productSizes.universalSizesCM().get(5)),"Grabiszynka","337","52-402","poland",
//                "itddr");
//

//        System.out.println(dBCSub.displayIDsRaffle(1).size());
//        dBCSub.addSubmission(userInfo,1);




//        System.out.println(dBCSub.displayIDsRaffle(1));
//        Random random = new Random();
//            if (dBCSub.displayIDsRaffle(1).size()> raffleSizesStock.getStockForSize1()) {
//                for (int i=0; i< raffleSizesStock.getStockForSize1();i++) {
//                    int randomID = dBCSub.displayIDsRaffle(1).get(random.nextInt(dBCSub.displayIDsRaffle(1).size()));
//                    System.out.println(randomID);
//                    dBCSub.displayIDsRaffle(1).remove(randomID);
//                }
//            }else {
//                System.out.println(dBCSub.displayIDsRaffle(1));
//
//            }







    }
}