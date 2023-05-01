package org.example.raffle;

import java.time.LocalDate;

public class RaffleActivity extends RaffleInfo{
    public RaffleActivity(String productName, String productSKU, String productPrice, LocalDate startRaffleDate, LocalDate endRaffleDate) {
        super(productName, productSKU, productPrice, startRaffleDate, endRaffleDate);
    }


    private LocalDate startRaffle = getStartRaffleDate();
    private LocalDate endRaffle = getEndRaffleDate();
    private LocalDate timeNow = getLocalDate();



    public boolean isActive(){
        if (timeNow.isBefore(startRaffle)){
            System.out.println("Raffle jeszcze sie nie rozpoczal");
            return false;
        }else if ((timeNow.isAfter(startRaffle)&& timeNow.isBefore(endRaffle)|| timeNow.equals(startRaffle))){
            System.out.println("Raffle juz trwa");
            return true;
        } else if (timeNow.isAfter(endRaffle)) {
            System.out.println("Raffle juz sie skonczyl");
            return false;
        }else
            System.out.println("cos nie tak");
            return false;
    }

//    public LocalDate getStartRaffle() {
//        return startRaffle;
//    }
//
//    public LocalDate getEndRaffle() {
//        return endRaffle;
//    }
//
//    public LocalDate getTimeNow() {
//        return timeNow;
//    }
}
