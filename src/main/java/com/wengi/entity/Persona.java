/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wengi.entity;

import java.util.Calendar;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.mongodb.core.index.Indexed;

/**
 *
 * @author jhoanseve2
 */
public class Persona {
    protected Cliente.TYPE type;
    protected TipoIdentificacionEnum tipoIdentificacion;
    @Indexed protected String identificacion;
    protected String firstName;
    protected String lastName;
    protected Calendar birthday;
    @CreatedDate
    protected Calendar recordDay;
    protected String phones;
    protected Address address;

    public Persona() {
    }

    public Cliente.TYPE getType() {
        return type;
    }

    public void setType(Cliente.TYPE type) {
        this.type = type;
    }

    public TipoIdentificacionEnum getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(TipoIdentificacionEnum tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Persona{" + "type=" + type + ", tipoIdentificacion=" + tipoIdentificacion + ", identificacion=" + identificacion + ", firstName=" + firstName + ", lastName=" + lastName + '}';
    }
}
