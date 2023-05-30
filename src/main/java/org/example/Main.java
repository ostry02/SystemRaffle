package org.example;


import org.example.draw.DrawSystem;
import org.example.draw.SeparateSizes;
import org.example.product.ProductSizes;
import org.example.raffle.RaffleActivity;
import org.example.raffle.RaffleInfo;
import org.example.raffle.RaffleSizesStock;
import org.example.sql.DataBaseControllerRaffleProducts;
import org.example.sql.DataBaseControllerSubSizes;
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


        SeparateSizes separateSizes = new SeparateSizes(dBCSub);
//        separateSizes.separateSizesInSubmissions(15);
//        System.out.println(dBCSub.displayAllUsersFromRaffle(1).get(0).getUserSize());

        /* Tworzenie danych do losowania na bazie wczeniejszych stock */
        DrawSystem drawSystem = new DrawSystem(raffleSizesStock.getStockForSize4(), raffleSizesStock.getStockForSize45(), raffleSizesStock.getStockForSize5(), raffleSizesStock.getStockForSize55(), raffleSizesStock.getStockForSize6(), raffleSizesStock.getStockForSize65(), raffleSizesStock.getStockForSize7(), raffleSizesStock.getStockForSize75(), raffleSizesStock.getStockForSize8(), raffleSizesStock.getStockForSize85(), raffleSizesStock.getStockForSize9(), raffleSizesStock.getStockForSize95(), raffleSizesStock.getStockForSize10(), raffleSizesStock.getStockForSize105(), raffleSizesStock.getStockForSize11(), raffleSizesStock.getStockForSize115(), raffleSizesStock.getStockForSize12(), raffleSizesStock.getStockForSize125(), raffleSizesStock.getStockForSize13(), raffleSizesStock.getStockForSize135(), raffleSizesStock.getStockForSize14(),dBCSub,separateSizes);
        /* Losowanie danego rozmiaru */
//        System.out.println("id dla 65 "+separateSizes.getIdlistOfSize65());
        drawSystem.DrawForSize65(15,6.5);
//        System.out.println("stock 65 "+drawSystem.getStockForSize65());

//        drawSystem.DrawForSize4(1);

//        System.out.println(dBCSub.displayAllUsersFromRaffleSpecSize(15, 6.5).get(0).getId());
//        System.out.println(separateSizes.idsOfSize(15,6.5));


    }
}