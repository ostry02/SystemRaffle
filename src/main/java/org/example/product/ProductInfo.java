package org.example.product;




public class ProductInfo{
    private Integer id;
    private String productName;
    private String productSKU;
    private Double productPrice;

    public ProductInfo(String productName, String productSKU, Double productPrice) {
        this.productName = productName;
        this.productSKU = productSKU;
        this.productPrice = productPrice;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductSKU() {
        return productSKU;
    }

    public void setProductSKU(String productSKU) {
        this.productSKU = productSKU;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }


}
