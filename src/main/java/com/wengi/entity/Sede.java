/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wengi.entity;

import org.springframework.data.annotation.Id;

/**
 *
 * @author jhoanseve2
 */
public class Sede {
    @Id
    private String id;

    public Sede() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
}
