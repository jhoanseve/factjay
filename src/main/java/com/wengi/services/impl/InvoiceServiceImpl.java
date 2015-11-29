/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wengi.services.impl;

import com.wengi.entity.Invoice;
import com.wengi.services.InvoiceService;
import com.wengi.util.LogUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author jhoanseve2
 */
public class InvoiceServiceImpl implements LogUtil, InvoiceService {
    private static final Logger logger = LoggerFactory.getLogger(InvoiceServiceImpl.class);

    @Override
    public Invoice generate(Invoice facturaVenta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
