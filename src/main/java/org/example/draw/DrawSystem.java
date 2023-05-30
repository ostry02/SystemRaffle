package org.example.draw;

import org.example.raffle.RaffleSelectSizesStock;
import org.example.sql.DataBaseControllerSubmissions;
import org.example.user.UserInfo;

import java.util.List;
import java.util.Random;

public class DrawSystem extends RaffleSelectSizesStock{


    DataBaseControllerSubmissions dBCSub;
    SeparateSizes separateSizes;
    private Random random = new Random();

    public DrawSystem(Integer stockForSize4, Integer stockForSize45, Integer stockForSize5, Integer stockForSize55, Integer stockForSize6, Integer stockForSize65, Integer stockForSize7, Integer stockForSize75, Integer stockForSize8, Integer stockForSize85, Integer stockForSize9, Integer stockForSize95, Integer stockForSize10, Integer stockForSize105, Integer stockForSize11, Integer stockForSize115, Integer stockForSize12, Integer stockForSize125, Integer stockForSize13, Integer stockForSize135, Integer stockForSize14, DataBaseControllerSubmissions dBCSub,SeparateSizes separateSizes) {
        super(stockForSize4, stockForSize45, stockForSize5, stockForSize55, stockForSize6, stockForSize65, stockForSize7, stockForSize75, stockForSize8, stockForSize85, stockForSize9, stockForSize95, stockForSize10, stockForSize105, stockForSize11, stockForSize115, stockForSize12, stockForSize125, stockForSize13, stockForSize135, stockForSize14);
        this.dBCSub = dBCSub;
        this.separateSizes = separateSizes;
    }


    public void DrawForSize(Integer raffleID, Double size){
        List<Integer> listOfIds = separateSizes.idsOfSize(raffleID,size);
        List<UserInfo> listOfUsers = dBCSub.displayAllUsersFromRaffleSpecSize(raffleID,size);

        if (getStockForSize65()<listOfUsers.size()){
            for (int i = 0; i<getStockForSize65(); i++) {
                Integer randomID = listOfIds.get(random.nextInt(listOfIds.size()));
                System.out.println("Wylosowany numer to: " + randomID);
                System.out.println("Email ziomka: "+ listOfUsers.get(listOfIds.indexOf(randomID)).getEmail());
                listOfUsers.remove(listOfIds.indexOf(randomID));
                listOfIds.remove(randomID);
                System.out.println("Rozmiar tablicy: " + listOfIds.size());
                System.out.println("Pozostale id: " + listOfIds);
                System.out.println();
            }
        }else {
            for (int i=0;i<listOfIds.size();i++){
                System.out.println(listOfIds.get(i));
            }
        }
    }
}
