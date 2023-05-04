package org.example.raffle;

import java.util.ArrayList;
import java.util.List;

public class RaffleSizesStock extends RaffleSelectSizesStock {
    private List<Integer> productStockList = new ArrayList<>();

    public RaffleSizesStock(Integer stockForSize4, Integer stockForSize45, Integer stockForSize5, Integer stockForSize55, Integer stockForSize6, Integer stockForSize65, Integer stockForSize7, Integer stockForSize75, Integer stockForSize8, Integer stockForSize85, Integer stockForSize9, Integer stockForSize95, Integer stockForSize10, Integer stockForSize105, Integer stockForSize11, Integer stockForSize115, Integer stockForSize12, Integer stockForSize125, Integer stockForSize13, Integer stockForSize135, Integer stockForSize14) {
        super(stockForSize4, stockForSize45, stockForSize5, stockForSize55, stockForSize6, stockForSize65, stockForSize7, stockForSize75, stockForSize8, stockForSize85, stockForSize9, stockForSize95, stockForSize10, stockForSize105, stockForSize11, stockForSize115, stockForSize12, stockForSize125, stockForSize13, stockForSize135, stockForSize14);
    }

    public void assignStock(){
        productStockList.add(getStockForSize4());
        productStockList.add(getStockForSize45());
        productStockList.add(getStockForSize5());
        productStockList.add(getStockForSize55());
        productStockList.add(getStockForSize6());
        productStockList.add(getStockForSize65());
        productStockList.add(getStockForSize7());
        productStockList.add(getStockForSize75());
        productStockList.add(getStockForSize8());
        productStockList.add(getStockForSize85());
        productStockList.add(getStockForSize9());
        productStockList.add(getStockForSize95());
        productStockList.add(getStockForSize10());
        productStockList.add(getStockForSize105());
        productStockList.add(getStockForSize11());
        productStockList.add(getStockForSize115());
        productStockList.add(getStockForSize12());
        productStockList.add(getStockForSize125());
        productStockList.add(getStockForSize13());
        productStockList.add(getStockForSize135());
        productStockList.add(getStockForSize14());
    }

    public Integer totalStock(){
        int sum = 0;
        for (int i=0;i< productStockList.size();i++){
            sum+=productStockList.get(i);
        }
        return sum;
    }


    public List<Integer> getProductStockList() {
        return productStockList;
    }

    public void setProductStockList(List<Integer> productStockList) {
        this.productStockList = productStockList;
    }
}
