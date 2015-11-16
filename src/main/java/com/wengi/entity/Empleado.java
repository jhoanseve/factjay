/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wengi.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;

/**
 *
 * @author jhoanseve2
 */
class Empleado extends Persona {
    @Id
    private String id;
    
    private boolean status;
    private User userFact;
    @Indexed
    @DBRef
    private Empresa company;

    public Empleado() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public User getUserFact() {
        return userFact;
    }

    public void setUserFact(User userFact) {
        this.userFact = userFact;
    }

    public Empresa getCompany() {
        return company;
    }

    public void setCompany(Empresa company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "Empleado{" + "id=" + id + ", " + super.toString() + ", status=" + status + ", userFact=" + userFact + '}';
    }
}
