package org.example.draw;

import org.example.raffle.RaffleSizesStock;
import org.example.sql.DataBaseControllerRaffleProducts;
import org.example.sql.DataBaseControllerSubmissions;
import org.example.user.UserInfo;

import java.util.ArrayList;
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
        System.out.println(listOfIds);
        System.out.println(listOfUsers);
        System.out.println(dBCRProd.getStockPerSize(raffleID).get(0).getStockForSize65());

//        if (dBCRProd.getStockPerSize(raffleID).get(0).getStockForSize65()<listOfUsers.size()){
            for (int i = 0; i<dBCRProd.getStockPerSize(raffleID).get(0).getStockForSize65(); i++) {
                try {
                    Integer randomID = listOfIds.get(random.nextInt(listOfIds.size()));
                    System.out.println("Wylosowany numer to: " + randomID);
                    System.out.println("Email ziomka: " + listOfUsers.get(listOfIds.indexOf(randomID)).getEmail());
                    listOfWinnersEmail.add(listOfUsers.get(listOfIds.indexOf(randomID)).getEmail());
                    listOfUsers.remove(listOfIds.indexOf(randomID));

                    listOfWinnersID.add(randomID);
                    listOfIds.remove(randomID);
                    System.out.println("Rozmiar tablicy: " + listOfIds.size());
                    System.out.println("Pozostale id: " + listOfIds);
                    System.out.println();
                }catch (Exception e){
                    System.out.println("nie ma wicej typa");
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
