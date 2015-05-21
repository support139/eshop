package com.epam.khodyka.bean;

/**
 * Created by Andrii_Khodyka on 5/21/2015.
 */
public class ShopperBean {

    private String firstName;
    private String lastName;
    private String email;
    private String mobilePhone;
    private String country;
    private String state;
    private String adress;
    private String zipCode;
    private String payment;
    private String cardId;

    public ShopperBean(String firstName, String lastName, String email, String mobilePhone, String country, String state, String adress, String zipCode, String payment, String cardId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.mobilePhone = mobilePhone;
        this.country = country;
        this.state = state;
        this.adress = adress;
        this.zipCode = zipCode;
        this.payment = payment;
        this.cardId = cardId;
    }

    public ShopperBean() {

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

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    @Override
    public String toString() {
        return "ShopperBean{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", country='" + country + '\'' +
                ", state='" + state + '\'' +
                ", adress='" + adress + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", payment='" + payment + '\'' +
                ", cardId='" + cardId + '\'' +
                '}';
    }
}
