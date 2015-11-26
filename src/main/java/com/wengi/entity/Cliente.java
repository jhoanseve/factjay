/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wengi.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author jhoanseve2
 */
@Document
@CompoundIndex(name = "identf_company", def = "{'identificacion': 1, 'company': 1}")
public class Cliente extends Persona {
    public static enum TYPE {
        NATURAL("N"),
        JURIDICA("N"),;
        
        private TYPE(String value) {
            this.value = value;
        }
        
        String value;
    }
    
    @Id
    private String id;  
    private boolean isSender;
    private boolean status;
    @DBRef private Empresa company;

    public Cliente() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isIsSender() {
        return isSender;
    }

    public void setIsSender(boolean isSender) {
        this.isSender = isSender;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Empresa getCompany() {
        return company;
    }

    public void setCompany(Empresa company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + "," + super.toString() + ", isSender=" + isSender + ", status=" + status + ", company=" + company + '}';
    }
}
