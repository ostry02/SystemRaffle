package org.example.raffle;

import org.example.product.ProductInfo;

import java.time.LocalDate;


public class RaffleInfo extends ProductInfo {
    private LocalDate startRaffleDate;
    private LocalDate endRaffleDate;
    private final LocalDate localDate = LocalDate.now();

    public RaffleInfo(String productName, String productSKU, Double productPrice, LocalDate startRaffleDate, LocalDate endRaffleDate) {
        super(productName, productSKU, productPrice);
        this.startRaffleDate = startRaffleDate;
        this.endRaffleDate = endRaffleDate;
    }


    public LocalDate getStartRaffleDate() {
        return startRaffleDate;
    }

    public void setStartRaffleDate(LocalDate startRaffleDate) {
        this.startRaffleDate = startRaffleDate;
    }

    public LocalDate getEndRaffleDate() {
        return endRaffleDate;
    }

    public void setEndRaffleDate(LocalDate endRaffleDate) {
        this.endRaffleDate = endRaffleDate;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    @Override
    public String toString() {
        return "RaffleInfo{" +
                "startRaffleDate=" + startRaffleDate +
                "endRaffleDate=" + endRaffleDate +
                " productName='" + getProductName() + '\'' +
                ", productSKU='" + getProductSKU() + '\'' +
                ", productPrice='" + getProductPrice() + '\'' +
                '}';
    }
}
