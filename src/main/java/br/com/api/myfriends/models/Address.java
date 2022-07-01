package br.com.api.myfriends.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {

    @Column(nullable = false, length = 10)
    private String zipCode;

    @Column(nullable = false, length = 50)
    private String street;

    @Column(nullable = false, length = 6)
    private String number;

    @Column(length = 20)
    private String complement;

    @Column(nullable = false, length = 70)
    private String city;

    @Column(nullable = false, length = 2)
    private String state;

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
