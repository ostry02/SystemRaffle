package org.example.raffle;

import java.time.LocalDate;

public class RaffleActivity extends RaffleInfo {


    public RaffleActivity(String productName, String productSKU, String productPrice, LocalDate startRaffleDate, LocalDate endRaffleDate) {
        super(productName, productSKU, productPrice, startRaffleDate, endRaffleDate);
    }

    public boolean isActive(){
        if (getLocalDate().isBefore(getStartRaffleDate())){
            System.out.println("Raffle jeszcze sie nie rozpoczal");
            return false;
        }else if (getLocalDate().isAfter(getStartRaffleDate())&& getLocalDate().isBefore(getEndRaffleDate())){
            System.out.println("Raffle juz trwa");
            return true;
        } else if (getLocalDate().isAfter(getEndRaffleDate())) {
            System.out.println("Raffle juz sie skonczyl");
            return false;
        }else
            return false;
    }
}
