/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wengi.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author jhoanseve2
 */
@Document
public class Impost {
    public static enum TYPE {
        VALUE("V"),
        PERCENTAGE("P");
        
        String value;

        private TYPE(String value) {
            this.value = value;
        }
    }
    
    @Id
    private String id;
    
    private String code;
    private String name;
    private TYPE type;
    private boolean status;

    public Impost() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TYPE getType() {
        return type;
    }

    public void setType(TYPE type) {
        this.type = type;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Impost{" + "id=" + id + ", code=" + code + ", name=" + name + ", type=" + type + ", status=" + status + '}';
    }
    
}
