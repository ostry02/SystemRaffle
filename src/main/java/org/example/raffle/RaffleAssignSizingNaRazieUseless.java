package org.example.raffle;

import org.example.product.ProductSizes;

public class RaffleAssignSizingNaRazieUseless {
    ProductSizes productSizes;
    RaffleInfo raffleInfo;

    public void assignSizes() {
        String productBrand = raffleInfo.getProductName().toLowerCase();
        if (productBrand.contains("nike") || productBrand.contains("jordan")){
            productSizes.nikeSizesM();
        }else if (productBrand.contains("adidas")){
            productSizes.adidasSizesM();
        }else if (productBrand.contains("pants") && productBrand.contains("tee")&& productBrand.contains("coat")) {
            productSizes.clothesSizesM();
        }else{
            productSizes.universalSizesCM();
        }

    }
}
