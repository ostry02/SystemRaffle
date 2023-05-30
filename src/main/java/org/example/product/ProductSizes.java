package org.example.product;



import java.util.Arrays;
import java.util.List;

public class ProductSizes {
    private List<Double> productShoeSizes;
    private List<String> productClothesSizes;

    /* Na razie nie uzywamy */
    public List<Double> nikeSizesM(){
        List<Double> nikeSizing = Arrays.asList(
                36.0, 36.5, 37.0, 37.5, 38.0, 38.5, 39.0, 39.5,
                40.0, 40.5, 41.0, 41.5, 42.0, 42.5, 43.0,
                44.0, 44.5, 45.0, 45.5, 46.0, 47.0, 48.0
        );
        this.productShoeSizes = nikeSizing;
        return productShoeSizes;
    }

    /* Na razie nie uzywamy */
    public List<Double> adidasSizesM(){
        List<Double> adidasSizing = Arrays.asList(
                36.0, 36.7, 37.3, 38.0, 38.7, 39.3, 40.0,
                40.7, 41.3, 42.0, 42.7, 43.3, 44.0, 44.7, 45.3,
                46.0, 46.7, 47.3, 48.0);
        this.productShoeSizes = adidasSizing;
        return productShoeSizes;
    }

    /* Na razie nie uzywamy */
    public List<String> clothesSizesM(){
        List<String> clothesSizing = Arrays.asList(
                "S","M","L","XL","XXL");
        this.productClothesSizes = clothesSizing;
        return productClothesSizes;
    }

    /* Uzywamy tylko universalSizesCM */
    public List<Double> universalSizesCM(){
        List<Double> universalSizing = Arrays.asList(
                4.0,4.5,5.0,5.5,6.0,6.5,7.0,7.5,8.0,8.5,9.0,
                9.5,10.0,10.5,11.0,11.5,12.0,12.5,13.0,13.5,14.0
        );
        this.productShoeSizes = universalSizing;
        return productShoeSizes;
    }


    public List<Double> getProductShoeSizes() {
        return productShoeSizes;
    }

    public void setProductShoeSizes(List<Double> productShoeSizes) {
        this.productShoeSizes = productShoeSizes;
    }

    public List<String> getProductClothesSizes() {
        return productClothesSizes;
    }

    public void setProductClothesSizes(List<String> productClothesSizes) {
        this.productClothesSizes = productClothesSizes;
    }
}
