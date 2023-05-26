package org.example.draw;

import org.example.raffle.RaffleSelectSizesStock;
import org.example.sql.DataBaseControllerSubmissions;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DrawSystem extends RaffleSelectSizesStock{


    DataBaseControllerSubmissions dBCSub;
    RaffleSelectSizesStock raffleSelectSizesStock;
    DrawSeparateSizes drawSeparateSizes;
    private Random random = new Random();

    public DrawSystem(Integer stockForSize4, Integer stockForSize45, Integer stockForSize5, Integer stockForSize55, Integer stockForSize6, Integer stockForSize65, Integer stockForSize7, Integer stockForSize75, Integer stockForSize8, Integer stockForSize85, Integer stockForSize9, Integer stockForSize95, Integer stockForSize10, Integer stockForSize105, Integer stockForSize11, Integer stockForSize115, Integer stockForSize12, Integer stockForSize125, Integer stockForSize13, Integer stockForSize135, Integer stockForSize14, DataBaseControllerSubmissions dBCSub) {
        super(stockForSize4, stockForSize45, stockForSize5, stockForSize55, stockForSize6, stockForSize65, stockForSize7, stockForSize75, stockForSize8, stockForSize85, stockForSize9, stockForSize95, stockForSize10, stockForSize105, stockForSize11, stockForSize115, stockForSize12, stockForSize125, stockForSize13, stockForSize135, stockForSize14);
        this.dBCSub = dBCSub;
    }


//    public void DrawForSize65(int raffleID){
//        List<Integer> listOfIds = new ArrayList<>();
//        drawSeparateSizes.separateSizes(raffleID);
//        if (getStockForSize65()<listOfIds.size()){
//            for (int i = 0; i<getStockForSize65(); i++) {
//                Integer randomID = listOfIds.get(random.nextInt(listOfIds.size()));
//                System.out.println("Wylosowany numer to: " + randomID);
//
//                listOfIds.remove(randomID);
//                System.out.println("Rozmiar tablicy: " + listOfIds.size());
//                System.out.println("Pozostale id: " + listOfIds);
//                System.out.println();
//            }
//        }else {
//            for (int i=0;i<listOfIds.size();i++){
//                System.out.println(listOfIds.get(i));
//            }
//        }
//    }
    public void DrawForSize65(int raffleID){
        List<Integer> listOfIds = dBCSub.displayALLIDsRaffle(raffleID);
        if (getStockForSize65()<listOfIds.size()){
            for (int i = 0; i<getStockForSize65(); i++) {
                Integer randomID = listOfIds.get(random.nextInt(listOfIds.size()));
                System.out.println("Wylosowany numer to: " + randomID);
                System.out.println("email tego zioma "+dBCSub.displayAllUsersFromRaffle(raffleID).get(randomID).getEmail());

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
    public void DrawForSize75(){
        List<Integer> listOfIds = dBCSub.displayALLIDsRaffle(3);
        Integer sizeOfListId = dBCSub.displayALLIDsRaffle(3).size();
        for (int i = 0; i<getStockForSize75(); i++){
            Integer randomID = listOfIds.get(random.nextInt(sizeOfListId));
            System.out.println("Wylosowany numer to: "+randomID);

            listOfIds.remove(randomID);
            System.out.println("Rozmiar tablicy: "+sizeOfListId);
            System.out.println("Pozostale id: "+listOfIds);
            System.out.println();
        }
    }
    public void DrawForSize8(){
        List<Integer> listOfIds = dBCSub.displayALLIDsRaffle(4);
        Integer sizeOfListId = dBCSub.displayALLIDsRaffle(4).size();
        for (int i = 0; i<getStockForSize8(); i++){
            Integer randomID = listOfIds.get(random.nextInt(sizeOfListId));
            System.out.println("Wylosowany numer to: "+randomID);

            listOfIds.remove(randomID);
            System.out.println("Rozmiar tablicy: "+sizeOfListId);
            System.out.println("Pozostale id: "+listOfIds);
            System.out.println();
        }
    }
    public void DrawForSize85(){
        List<Integer> listOfIds = dBCSub.displayALLIDsRaffle(5);
        Integer sizeOfListId = dBCSub.displayALLIDsRaffle(5).size();
        for (int i = 0; i<getStockForSize85(); i++){
            Integer randomID = listOfIds.get(random.nextInt(sizeOfListId));
            System.out.println("Wylosowany numer to: "+randomID);

            listOfIds.remove(randomID);
            System.out.println("Rozmiar tablicy: "+sizeOfListId);
            System.out.println("Pozostale id: "+listOfIds);
            System.out.println();
        }
    }
    public void DrawForSize9(){
        List<Integer> listOfIds = dBCSub.displayALLIDsRaffle(6);
        Integer sizeOfListId = dBCSub.displayALLIDsRaffle(6).size();
        for (int i = 0; i<getStockForSize9(); i++){
            Integer randomID = listOfIds.get(random.nextInt(sizeOfListId));
            System.out.println("Wylosowany numer to: "+randomID);

            listOfIds.remove(randomID);
            System.out.println("Rozmiar tablicy: "+sizeOfListId);
            System.out.println("Pozostale id: "+listOfIds);
            System.out.println();
        }
    }
    public void DrawForSize95(){
        List<Integer> listOfIds = dBCSub.displayALLIDsRaffle(7);
        Integer sizeOfListId = dBCSub.displayALLIDsRaffle(7).size();
        for (int i = 0; i<getStockForSize95(); i++){
            Integer randomID = listOfIds.get(random.nextInt(sizeOfListId));
            System.out.println("Wylosowany numer to: "+randomID);

            listOfIds.remove(randomID);
            System.out.println("Rozmiar tablicy: "+sizeOfListId);
            System.out.println("Pozostale id: "+listOfIds);
            System.out.println();
        }
    }
    public void DrawForSize10(){
        List<Integer> listOfIds = dBCSub.displayALLIDsRaffle(8);
        Integer sizeOfListId = dBCSub.displayALLIDsRaffle(8).size();
        for (int i = 0; i<getStockForSize10(); i++){
            Integer randomID = listOfIds.get(random.nextInt(sizeOfListId));
            System.out.println("Wylosowany numer to: "+randomID);

            listOfIds.remove(randomID);
            System.out.println("Rozmiar tablicy: "+sizeOfListId);
            System.out.println("Pozostale id: "+listOfIds);
            System.out.println();
        }
    }
    public void DrawForSize105(){
        List<Integer> listOfIds = dBCSub.displayALLIDsRaffle(9);
        Integer sizeOfListId = dBCSub.displayALLIDsRaffle(9).size();
        for (int i = 0; i<getStockForSize105(); i++){
            Integer randomID = listOfIds.get(random.nextInt(sizeOfListId));
            System.out.println("Wylosowany numer to: "+randomID);

            listOfIds.remove(randomID);
            System.out.println("Rozmiar tablicy: "+sizeOfListId);
            System.out.println("Pozostale id: "+listOfIds);
            System.out.println();
        }
    }
    public void DrawForSize11(){
        List<Integer> listOfIds = dBCSub.displayALLIDsRaffle(10);
        Integer sizeOfListId = dBCSub.displayALLIDsRaffle(10).size();
        for (int i = 0; i<getStockForSize11(); i++){
            Integer randomID = listOfIds.get(random.nextInt(sizeOfListId));
            System.out.println("Wylosowany numer to: "+randomID);

            listOfIds.remove(randomID);
            System.out.println("Rozmiar tablicy: "+sizeOfListId);
            System.out.println("Pozostale id: "+listOfIds);
            System.out.println();
        }
    }
    public void DrawForSize115(){
        List<Integer> listOfIds = dBCSub.displayALLIDsRaffle(11);
        Integer sizeOfListId = dBCSub.displayALLIDsRaffle(11).size();
        for (int i = 0; i<getStockForSize115(); i++){
            Integer randomID = listOfIds.get(random.nextInt(sizeOfListId));
            System.out.println("Wylosowany numer to: "+randomID);

            listOfIds.remove(randomID);
            System.out.println("Rozmiar tablicy: "+sizeOfListId);
            System.out.println("Pozostale id: "+listOfIds);
            System.out.println();
        }
    }
    public void DrawForSize12(){
        List<Integer> listOfIds = dBCSub.displayALLIDsRaffle(12);
        Integer sizeOfListId = dBCSub.displayALLIDsRaffle(12).size();
        for (int i = 0; i<getStockForSize12(); i++){
            Integer randomID = listOfIds.get(random.nextInt(sizeOfListId));
            System.out.println("Wylosowany numer to: "+randomID);

            listOfIds.remove(randomID);
            System.out.println("Rozmiar tablicy: "+sizeOfListId);
            System.out.println("Pozostale id: "+listOfIds);
            System.out.println();
        }
    }
    public void DrawForSize125(){
        List<Integer> listOfIds = dBCSub.displayALLIDsRaffle(13);
        Integer sizeOfListId = dBCSub.displayALLIDsRaffle(13).size();
        for (int i = 0; i<getStockForSize125(); i++){
            Integer randomID = listOfIds.get(random.nextInt(sizeOfListId));
            System.out.println("Wylosowany numer to: "+randomID);

            listOfIds.remove(randomID);
            System.out.println("Rozmiar tablicy: "+sizeOfListId);
            System.out.println("Pozostale id: "+listOfIds);
            System.out.println();
        }
    }
    public void DrawForSize13(){
        List<Integer> listOfIds = dBCSub.displayALLIDsRaffle(14);
        Integer sizeOfListId = dBCSub.displayALLIDsRaffle(14).size();
        for (int i = 0; i<getStockForSize13(); i++){
            Integer randomID = listOfIds.get(random.nextInt(sizeOfListId));
            System.out.println("Wylosowany numer to: "+randomID);

            listOfIds.remove(randomID);
            System.out.println("Rozmiar tablicy: "+sizeOfListId);
            System.out.println("Pozostale id: "+listOfIds);
            System.out.println();
        }
    }
    public void DrawForSize135(){
        List<Integer> listOfIds = dBCSub.displayALLIDsRaffle(15);
        Integer sizeOfListId = dBCSub.displayALLIDsRaffle(15).size();
        for (int i = 0; i<getStockForSize135(); i++){
            Integer randomID = listOfIds.get(random.nextInt(sizeOfListId));
            System.out.println("Wylosowany numer to: "+randomID);

            listOfIds.remove(randomID);
            System.out.println("Rozmiar tablicy: "+sizeOfListId);
            System.out.println("Pozostale id: "+listOfIds);
            System.out.println();
        }
    }
}
