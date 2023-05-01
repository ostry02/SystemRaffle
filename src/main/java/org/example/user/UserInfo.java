package org.example.userInfo;

public class UserInfo extends UserAddress{
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String productSize;
    private String instagramHandle;

    public UserInfo(String firstName,
                    String lastName,
                    String email,
                    String phoneNumber,
                    String addressStreet,
                    String addressNumber,
                    String addressPostCode,
                    String country,
                    String productSize,
                    String instagramHandle) {
        super(addressStreet, addressNumber, addressPostCode, country);
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.productSize = productSize;
        this.instagramHandle = instagramHandle;
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

    public String getProductSize() {
        return productSize;
    }

    public void setProductSize(String productSize) {
        this.productSize = productSize;
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
                ", productSize='" + productSize + '\'' +
                ", instagramHandle='" + instagramHandle + '\'' +
                " addressStreet='" + getAddressStreet() + '\'' +
                ", addressNumber='" + getAddressNumber() + '\'' +
                ", addressPostCode='" + getAddressPostCode() + '\'' +
                ", country='" + getCountry() + '\'' +
                '}';
    }
}
