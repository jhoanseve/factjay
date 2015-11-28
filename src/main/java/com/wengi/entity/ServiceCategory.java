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
public class ServiceCategory {
    @Id
    private String id;
    
    private String code;
    private String name;

    public ServiceCategory() {
    }

    public ServiceCategory(String code, String name) {
        this.code = code;
        this.name = name;
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

    @Override
    public String toString() {
        return "ServiceCategory{" + "id=" + id + ", code=" + code + ", name=" + name + '}';
    }
}
