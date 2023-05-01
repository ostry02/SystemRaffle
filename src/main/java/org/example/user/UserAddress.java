package org.example.userInfo;

public class UserAddress {
    private String addressStreet;
    private String addressNumber;
    private String addressPostCode;
    private String country;

    public UserAddress(String addressStreet, String addressNumber, String addressPostCode, String country) {
        this.addressStreet = addressStreet;
        this.addressNumber = addressNumber;
        this.addressPostCode = addressPostCode;
        this.country = country;
    }

    public String getAddressStreet() {
        return addressStreet;
    }

    public void setAddressStreet(String addressStreet) {
        this.addressStreet = addressStreet;
    }

    public String getAddressNumber() {
        return addressNumber;
    }

    public void setAddressNumber(String addressNumber) {
        this.addressNumber = addressNumber;
    }

    public String getAddressPostCode() {
        return addressPostCode;
    }

    public void setAddressPostCode(String addressPostCode) {
        this.addressPostCode = addressPostCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
