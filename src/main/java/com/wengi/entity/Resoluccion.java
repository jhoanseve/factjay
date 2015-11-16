/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wengi.entity;

import java.util.Calendar;
import java.util.Objects;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;

/**
 *
 * @author jhoanseve2
 */
public class Resoluccion {
    @Id
    private String id;
    
    private String prefix;
    private String number;
    private int anio;
    private Calendar dateApprobation;
    private Calendar dateRequest;
    private Calendar dateExpiration;
    @Indexed @DBRef private Empresa company;
    
    private long initialRange;
    private long finalRange;
    private long currentNumber;

    public Resoluccion() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public Calendar getDateApprobation() {
        return dateApprobation;
    }

    public void setDateApprobation(Calendar dateApprobation) {
        this.dateApprobation = dateApprobation;
    }

    public Calendar getDateRequest() {
        return dateRequest;
    }

    public void setDateRequest(Calendar dateRequest) {
        this.dateRequest = dateRequest;
    }

    public Calendar getDateExpiration() {
        return dateExpiration;
    }

    public void setDateExpiration(Calendar dateExpiration) {
        this.dateExpiration = dateExpiration;
    }

    public Empresa getCompany() {
        return company;
    }

    public void setCompany(Empresa company) {
        this.company = company;
    }

    public long getInitialRange() {
        return initialRange;
    }

    public void setInitialRange(long initialRange) {
        this.initialRange = initialRange;
    }

    public long getFinalRange() {
        return finalRange;
    }

    public void setFinalRange(long finalRange) {
        this.finalRange = finalRange;
    }

    public long getCurrentNumber() {
        return currentNumber;
    }

    public void setCurrentNumber(long currentNumber) {
        this.currentNumber = currentNumber;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.id);
        hash = 17 * hash + Objects.hashCode(this.prefix);
        hash = 17 * hash + Objects.hashCode(this.number);
        hash = 17 * hash + this.anio;
        hash = 17 * hash + Objects.hashCode(this.dateApprobation);
        hash = 17 * hash + Objects.hashCode(this.dateRequest);
        hash = 17 * hash + Objects.hashCode(this.dateExpiration);
        hash = 17 * hash + Objects.hashCode(this.company);
        hash = 17 * hash + (int) (this.initialRange ^ (this.initialRange >>> 32));
        hash = 17 * hash + (int) (this.finalRange ^ (this.finalRange >>> 32));
        hash = 17 * hash + (int) (this.currentNumber ^ (this.currentNumber >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Resoluccion other = (Resoluccion) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.prefix, other.prefix)) {
            return false;
        }
        if (!Objects.equals(this.number, other.number)) {
            return false;
        }
        if (this.anio != other.anio) {
            return false;
        }
        if (!Objects.equals(this.dateApprobation, other.dateApprobation)) {
            return false;
        }
        if (!Objects.equals(this.dateRequest, other.dateRequest)) {
            return false;
        }
        if (!Objects.equals(this.dateExpiration, other.dateExpiration)) {
            return false;
        }
        if (!Objects.equals(this.company, other.company)) {
            return false;
        }
        if (this.initialRange != other.initialRange) {
            return false;
        }
        if (this.finalRange != other.finalRange) {
            return false;
        }
        if (this.currentNumber != other.currentNumber) {
            return false;
        }
        return true;
    }
    
    
}
