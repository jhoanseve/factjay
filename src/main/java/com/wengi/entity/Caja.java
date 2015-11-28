/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wengi.entity;

import java.util.Objects;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

/**
 *
 * @author jhoanseve2
 */
public class Caja {
    @Id
    private String id;
    
    private String code;
    private String description;
    @DBRef private Sede sede;
    @DBRef private Resolution resolution;

    public Caja() {
    }

    public Caja(String code, String description, Sede sede, Resolution resolution) {
        this.code = code;
        this.description = description;
        this.sede = sede;
        this.resolution = resolution;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Sede getSede() {
        return sede;
    }

    public void setSede(Sede sede) {
        this.sede = sede;
    }

    public Resolution getResolution() {
        return resolution;
    }

    public void setResolution(Resolution resolution) {
        this.resolution = resolution;
    }

    @Override
    public String toString() {
        return "Caja{" + "id=" + id + ", code=" + code + ", description=" + description + ", sede=" + sede + ", resolution=" + resolution + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.id);
        hash = 89 * hash + Objects.hashCode(this.code);
        hash = 89 * hash + Objects.hashCode(this.description);
        hash = 89 * hash + Objects.hashCode(this.sede);
        hash = 89 * hash + Objects.hashCode(this.resolution);
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
        final Caja other = (Caja) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.code, other.code)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.sede, other.sede)) {
            return false;
        }
        if (!Objects.equals(this.resolution, other.resolution)) {
            return false;
        }
        return true;
    }
}
