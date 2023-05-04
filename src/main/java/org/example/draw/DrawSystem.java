package org.example.draw;

import org.example.raffle.RaffleSelectSizesStock;
import org.example.sql.DataBaseControllerSubmissions;

import java.util.Random;

public class DrawSystem extends RaffleSelectSizesStock{


    DataBaseControllerSubmissions dBCSub;
    private Random random = new Random();

    public DrawSystem(Integer stockForSize4, Integer stockForSize45, Integer stockForSize5, Integer stockForSize55, Integer stockForSize6, Integer stockForSize65, Integer stockForSize7, Integer stockForSize75, Integer stockForSize8, Integer stockForSize85, Integer stockForSize9, Integer stockForSize95, Integer stockForSize10, Integer stockForSize105, Integer stockForSize11, Integer stockForSize115, Integer stockForSize12, Integer stockForSize125, Integer stockForSize13, Integer stockForSize135, Integer stockForSize14, DataBaseControllerSubmissions dBCSub) {
        super(stockForSize4, stockForSize45, stockForSize5, stockForSize55, stockForSize6, stockForSize65, stockForSize7, stockForSize75, stockForSize8, stockForSize85, stockForSize9, stockForSize95, stockForSize10, stockForSize105, stockForSize11, stockForSize115, stockForSize12, stockForSize125, stockForSize13, stockForSize135, stockForSize14);
        this.dBCSub = dBCSub;
    }


    public void DrawForSize65(){
        for (int i = 0; i<getStockForSize65(); i++){
            int randomID = dBCSub.displayIDsRaffle(1).get(random.nextInt(dBCSub.displayIDsRaffle(1).size()));
            System.out.println("Wylosowany numer to: "+randomID);

//            dBCSub.displayIDsRaffle(1).remove(randomID);
            System.out.println("Rozmiar tablicy: "+dBCSub.displayIDsRaffle(1).size());
            System.out.println("Pozostale id: "+dBCSub.displayIDsRaffle(1));
            System.out.println();
        }
    }
}
