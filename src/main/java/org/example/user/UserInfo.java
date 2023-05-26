package org.example.user;

import org.example.product.ProductSizes;

import java.util.List;

public class UserInfo extends UserAddress{
    ProductSizes productSizes = new ProductSizes();
    private Integer id;

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private List<Double> userSelectedSize;
    private Double userSize; // zmienna aby sciagnac jaki rozmiar wybral uzytkownik z Listy userSelectedSize

    private String instagramHandle;

    public Double getUserSize() {
        return userSize;
    }

    public void setUserSize(Double userSize) {
        this.userSize = userSize;
    }

    public UserInfo(Integer id, String firstName, String lastName, String email, String phoneNumber, String addressStreet, String addressNumber, String addressPostCode, String country, Double userSelectedSize, String instagramHandle) {
        super(addressStreet, addressNumber, addressPostCode, country);
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.userSize = userSelectedSize;
        this.instagramHandle = instagramHandle;

    }

    public UserInfo(String firstName,
                    String lastName,
                    String email,
                    String phoneNumber,
                    List<Double> userSelectedSize,
                    String addressStreet,
                    String addressNumber,
                    String addressPostCode,
                    String country,
                    String instagramHandle) {
        super(addressStreet, addressNumber, addressPostCode, country);
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.userSelectedSize = userSelectedSize;
        this.phoneNumber = phoneNumber;
        this.instagramHandle = instagramHandle;
    }

    public UserInfo(String addressStreet, String addressNumber, String addressPostCode, String country, ProductSizes productSizes, Integer id, String firstName, String lastName, String email, String phoneNumber, List<Double> userSelectedSize, String instagramHandle) {
        super(addressStreet, addressNumber, addressPostCode, country);
        this.productSizes = productSizes;
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.userSelectedSize = userSelectedSize;
        this.instagramHandle = instagramHandle;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void selectingSize(){
        userSelectedSize = productSizes.universalSizesCM();
    }

    public List<Double> getUserSelectedSize() {
        return userSelectedSize;
    }

    public void setUserSelectedSize(List<Double> userSelectedSize) {
        this.userSelectedSize = userSelectedSize;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getInstagramHandle() {
        return instagramHandle;
    }

    public void setInstagramHandle(String instagramHandle) {
        this.instagramHandle = instagramHandle;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", instagramHandle='" + instagramHandle + '\'' +
                " addressStreet='" + getAddressStreet() + '\'' +
                ", addressNumber='" + getAddressNumber() + '\'' +
                ", addressPostCode='" + getAddressPostCode() + '\'' +
                ", country='" + getCountry() + '\'' +
                '}';
    }
}
