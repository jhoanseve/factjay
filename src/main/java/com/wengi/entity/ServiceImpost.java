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
public class ServiceImpost {
    private Impost impost;
    private Double value;

    public ServiceImpost() {
    }

    public ServiceImpost(Impost impost, Double value) {
        this.impost = impost;
        this.value = value;
    }

    public Impost getImpost() {
        return impost;
    }

    public void setImpost(Impost impost) {
        this.impost = impost;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ServiceImpost{" + "impost=" + impost + ", value=" + value + '}';
    }
}
