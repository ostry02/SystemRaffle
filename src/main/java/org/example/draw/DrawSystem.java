package org.example.draw;

import org.example.raffle.RaffleSizesStock;
import org.example.sql.DataBaseControllerRaffleProducts;
import org.example.sql.DataBaseControllerSubmissions;
import org.example.user.UserInfo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class DrawSystem{

    DataBaseControllerRaffleProducts dBCRProd;
    DataBaseControllerSubmissions dBCSub;
    SeparateSizes separateSizes;
    RaffleSizesStock raffleSizesStock;
    private Random random = new Random();

    public DrawSystem(DataBaseControllerSubmissions dBCSub,SeparateSizes separateSizes,DataBaseControllerRaffleProducts dataBaseControllerRaffleProducts) {
        this.dBCSub = dBCSub;
        this.separateSizes = separateSizes;
        this.dBCRProd=dataBaseControllerRaffleProducts;
    }
    List<Integer> listOfWinnersID = new ArrayList<>();
    List<String> listOfWinnersEmail = new ArrayList<>();

    public void DrawSize(Integer raffleID, Double size){
        List<Integer> listOfIds = separateSizes.idsOfSize(raffleID, size);
        List<UserInfo> listOfUsers = dBCSub.displayAllUsersFromRaffleSpecSize(raffleID, size);
//        System.out.println(listOfIds);
//        System.out.println(listOfUsers);
//        System.out.println(dBCRProd.getStockPerSize(raffleID).get(0).getStockForSize65());

//        if (dBCRProd.getStockPerSize(raffleID).get(0).getStockForSize65()<listOfUsers.size()){
        List<Integer> listOfStock = Arrays.asList(dBCRProd.getStockPerSize(raffleID).get(0).getStockForSize4(),
                dBCRProd.getStockPerSize(raffleID).get(0).getStockForSize45(),dBCRProd.getStockPerSize(raffleID).get(0).getStockForSize5(),
                dBCRProd.getStockPerSize(raffleID).get(0).getStockForSize55(),dBCRProd.getStockPerSize(raffleID).get(0).getStockForSize6(),
                dBCRProd.getStockPerSize(raffleID).get(0).getStockForSize65(),dBCRProd.getStockPerSize(raffleID).get(0).getStockForSize7(),
                dBCRProd.getStockPerSize(raffleID).get(0).getStockForSize75(),dBCRProd.getStockPerSize(raffleID).get(0).getStockForSize8(),
                dBCRProd.getStockPerSize(raffleID).get(0).getStockForSize85(),dBCRProd.getStockPerSize(raffleID).get(0).getStockForSize9(),
                dBCRProd.getStockPerSize(raffleID).get(0).getStockForSize95(),dBCRProd.getStockPerSize(raffleID).get(0).getStockForSize10(),
                dBCRProd.getStockPerSize(raffleID).get(0).getStockForSize105(),dBCRProd.getStockPerSize(raffleID).get(0).getStockForSize11(),
                dBCRProd.getStockPerSize(raffleID).get(0).getStockForSize115(),dBCRProd.getStockPerSize(raffleID).get(0).getStockForSize12(),
                dBCRProd.getStockPerSize(raffleID).get(0).getStockForSize125(),dBCRProd.getStockPerSize(raffleID).get(0).getStockForSize13(),
                dBCRProd.getStockPerSize(raffleID).get(0).getStockForSize135(),dBCRProd.getStockPerSize(raffleID).get(0).getStockForSize14()
                );
//        System.out.println(listOfStock);
        for (int j=0;j<listOfStock.size();j++) {
            for (int i = 0; i < listOfStock.get(j); i++) {
                try {
                    Integer randomID = listOfIds.get(random.nextInt(listOfIds.size()));
                    System.out.println("Wylosowany numer to: " + randomID);
                    System.out.println("Email ziomka: " + listOfUsers.get(listOfIds.indexOf(randomID)).getEmail());
                    listOfWinnersEmail.add(listOfUsers.get(listOfIds.indexOf(randomID)).getEmail());
                    listOfUsers.remove(listOfIds.indexOf(randomID));
                    System.out.println("To jest dla size "+listOfStock.get(j));
                    listOfWinnersID.add(randomID);
                    listOfIds.remove(randomID);
                    System.out.println("Rozmiar tablicy: " + listOfIds.size());
                    System.out.println("Pozostale id: " + listOfIds);
                    System.out.println();
                } catch (Exception e) {
                    System.out.println("nie ma wicej typa");
                }
            }
        }
//        }else {
//            for (int i=0;i<listOfIds.size();i++){
//                System.out.println(listOfIds.get(i));
//            }
//        }
    }

    public List<Integer> getListOfWinnersID() {
        return listOfWinnersID;
    }

    public List<String> getListOfWinnersEmail() {
        return listOfWinnersEmail;
    }
}
