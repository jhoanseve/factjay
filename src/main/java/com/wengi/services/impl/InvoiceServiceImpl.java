/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wengi.services.impl;

import com.wengi.data.repository.InvoiceRepository;
import com.wengi.entity.Invoice;
import com.wengi.entity.ServiceInvoice;
import com.wengi.services.InvoiceService;
import com.wengi.util.LogUtil;
import java.math.BigDecimal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author jhoanseve2
 */
@Component
public class InvoiceServiceImpl implements LogUtil, InvoiceService {
    private static final Logger logger = LoggerFactory.getLogger(InvoiceServiceImpl.class);

    @Autowired private InvoiceRepository invoiceRepository;
    
    @Override
    public Invoice generate(Invoice invoice) {
        logDebug(logger, "Invocando 'generate' ==>> {}", invoice);
        
        BigDecimal total = new BigDecimal(0);
//        invoice.getServices().stream().forEach((service) -> {
//            final BigDecimal subtotal = new BigDecimal(service.getQuantity() * service.getUnitaryValue());
//            total = subtotal.add(total);
//        });
        for(ServiceInvoice service : invoice.getServices()) {
            total = total.add(new BigDecimal(service.getQuantity() * service.getUnitaryValue()));
        }
        
        //Agregando totales
        invoice.setTotal(total);
        
        Invoice invoice2 = invoiceRepository.save(invoice);
        logDebug(logger, "Factura guardada en la BD", invoice2);

        return invoice2;
    }
    
}
