/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wengi.entity;

/**
 *
 * @author jhoanseve2
 */
public class Address {
    
    private String country;
    private String city;
    private String nomenclature;

    public Address() {
    }

    public Address(String country, String city, String nomenclature) {
        this.country = country;
        this.city = city;
        this.nomenclature = nomenclature;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNomenclature() {
        return nomenclature;
    }

    public void setNomenclature(String nomenclature) {
        this.nomenclature = nomenclature;
    }

    @Override
    public String toString() {
        return "Address{" + "country=" + country + ", city=" + city + ", nomenclature=" + nomenclature + '}';
    }
}
