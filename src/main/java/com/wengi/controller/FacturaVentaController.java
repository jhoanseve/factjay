/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wengi.controller;

import com.wengi.entity.FacturaVenta;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jhoanseve2
 */
@RestController
@RequestMapping("/facturas")
public class FacturaVentaController {

    private static final Logger LOGGER = LoggerFactory.getLogger(FacturaVentaController.class);

    @RequestMapping(value = "/generate", method = RequestMethod.POST)
    public FacturaVenta generate(@Valid @RequestBody FacturaVenta facturaVenta) {
        System.out.println("generate: " + facturaVenta);
        throw new UnsupportedOperationException();
    }

}
