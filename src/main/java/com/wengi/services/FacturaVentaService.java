/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wengi.services;

import com.wengi.entity.FacturaVenta;

/**
 *
 * @author jhoanseve2
 */
public interface FacturaVentaService {
    
    /***
     * Metodo encargado de la generacion de una factura
     * @param facturaVenta
     * @return 
     */
    FacturaVenta generate(FacturaVenta facturaVenta);
}
