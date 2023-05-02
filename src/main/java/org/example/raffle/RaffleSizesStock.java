package org.example.raffle;

import java.util.ArrayList;
import java.util.List;

public class RaffleSizesStock extends RaffleSelectSizesStock {
    private List<Integer> productStockList = new ArrayList<>();

    public RaffleSizesStock(Integer stockForSize1, Integer stockForSize2, Integer stockForSize3, Integer stockForSize4, Integer stockForSize5, Integer stockForSize6, Integer stockForSize7, Integer stockForSize8, Integer stockForSize9, Integer stockForSize10, Integer stockForSize11, Integer stockForSize12, Integer stockForSize13, Integer stockForSize14, Integer stockForSize15, Integer stockForSize16, Integer stockForSize17, Integer stockForSize18, Integer stockForSize19, Integer stockForSize20, Integer stockForSize21) {
        super(stockForSize1, stockForSize2, stockForSize3, stockForSize4, stockForSize5, stockForSize6, stockForSize7, stockForSize8, stockForSize9, stockForSize10, stockForSize11, stockForSize12, stockForSize13, stockForSize14, stockForSize15, stockForSize16, stockForSize17, stockForSize18, stockForSize19, stockForSize20, stockForSize21);
    }


    public void assignStock(){
        productStockList.add(getStockForSize1());
        productStockList.add(getStockForSize2());
        productStockList.add(getStockForSize3());
        productStockList.add(getStockForSize4());
        productStockList.add(getStockForSize5());
        productStockList.add(getStockForSize6());
        productStockList.add(getStockForSize7());
        productStockList.add(getStockForSize8());
        productStockList.add(getStockForSize9());
        productStockList.add(getStockForSize10());
        productStockList.add(getStockForSize11());
        productStockList.add(getStockForSize12());
        productStockList.add(getStockForSize13());
        productStockList.add(getStockForSize14());
        productStockList.add(getStockForSize15());
        productStockList.add(getStockForSize16());
        productStockList.add(getStockForSize17());
        productStockList.add(getStockForSize18());
        productStockList.add(getStockForSize19());
        productStockList.add(getStockForSize20());
        productStockList.add(getStockForSize21());
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
