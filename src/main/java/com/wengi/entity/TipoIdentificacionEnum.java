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
public enum TipoIdentificacionEnum {
    CEDULA("CC"),
    NIT("NI"),
    PASAPORTE("PA"),
    CEDULA_EXT("CE"),
    TARJETA_IDENTIDAD("TI");
    
        
    private TipoIdentificacionEnum(String value) {
        this.value = value;
    }
    String value;
}
