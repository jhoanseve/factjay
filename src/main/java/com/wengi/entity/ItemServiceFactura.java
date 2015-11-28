/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wengi.entity;

import java.math.BigDecimal;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Range;

/**
 *
 * @author jhoanseve2
 */
public class ItemServiceFactura {
    @NotNull
    private Service service;
    @NotNull
    @Min(value = 0, message = "El valor unitario de un Servicio NO puede ser menor que cero(0)")
    private Double unitaryValue;
    @NotNull
    @Min(0)
    private Integer quantity;
    @NotNull
    private BigDecimal subtotal;
    private Double imposts;
    private Double discounts;

    public ItemServiceFactura() {
    }

    public ItemServiceFactura(Service service, Double unitaryValue, Integer quantity) {
        this.service = service;
        this.unitaryValue = unitaryValue;
        this.quantity = quantity;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Double getUnitaryValue() {
        return unitaryValue;
    }

    public void setUnitaryValue(Double unitaryValue) {
        this.unitaryValue = unitaryValue;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public Double getImposts() {
        return imposts;
    }

    public void setImposts(Double imposts) {
        this.imposts = imposts;
    }

    public Double getDiscounts() {
        return discounts;
    }

    public void setDiscounts(Double discounts) {
        this.discounts = discounts;
    }

    @Override
    public String toString() {
        return "ItemServiceFactura{" + "service=" + service + ", unitaryValue=" + unitaryValue + ", quantity=" + quantity + ", subtotal=" + subtotal + ", imposts=" + imposts + ", discounts=" + discounts + '}';
    }
}
