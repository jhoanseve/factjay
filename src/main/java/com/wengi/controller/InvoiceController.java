/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wengi.controller;

import com.wengi.entity.Invoice;
import com.wengi.exception.FactjayException;
import com.wengi.services.InvoiceService;
import com.wengi.util.LogUtil;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jhoanseve2
 */
@RestController
@RequestMapping("/invoice")
public class InvoiceController implements LogUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(InvoiceController.class);
    
    @Autowired private InvoiceService invoiceService;

    @RequestMapping(value = "/generate", method = RequestMethod.POST)
    public Invoice generate(@Valid @RequestBody Invoice invoice) {
        logInfo(LOGGER, "Intentando generar factura [{}]", invoice);
        if(invoice == null) {
            LOGGER.error("La factura a generar NO puede ser nula");
            throw new FactjayException("La factura a generar no puede ser nula");
        }
        
        logDebug(LOGGER, "Invocando servicio de generacion de facturas");
        invoice = invoiceService.generate(invoice);
        
        return invoice;
    }

}
