/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wengi.services.impl;

import com.wengi.data.repository.InvoiceRepository;
import com.wengi.entity.Caja;
import com.wengi.entity.Cliente;
import com.wengi.entity.Impost;
import static com.wengi.entity.Impost.TYPE.PERCENTAGE;
import com.wengi.entity.Invoice;
import com.wengi.entity.ServiceInvoice;
import com.wengi.entity.Resolution;
import com.wengi.entity.Sede;
import com.wengi.entity.Service;
import com.wengi.entity.ServiceImpost;
import com.wengi.services.InvoiceService;
import java.math.BigDecimal;
import java.util.Calendar;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.BeanUtils;

/**
 *
 * @author jhoanseve2
 */
@RunWith(MockitoJUnitRunner.class)
public class InvoiceServiceImplTest {
    @Mock private InvoiceRepository invoiceRepository;
    @InjectMocks private final InvoiceService service = new InvoiceServiceImpl();
    
    public InvoiceServiceImplTest() {
    }

    /**
     * Factura con un solo item servicio sin impuestos
     */
    @Test
    public void testGenerate$1() {
        Double unitaryValue = 12000.0;
        ServiceInvoice iService = serviceBuilder(unitaryValue, 1, false, 0.0);
        Invoice invoice = invoiceBuilder(iService);
        String id = "123123456";
        Invoice invoice2 = invoiceBuilder(id, invoice, BigDecimal.valueOf(unitaryValue), 
                BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.valueOf(unitaryValue));
        
        //definicion de escenario
        when(invoiceRepository.save(invoice)).thenReturn(invoice2);
        
        //Invocaion de servicio
        Invoice response = service.generate(invoice);
        
        //validaciones
        verify(invoiceRepository).save(invoice);
        assertNotNull(response);
        assertNotNull(response.getId());
        assertNotNull(response.getTotal());
        assertNotNull(response.getTotalImpost());
        assertNotNull(response.getTotalProducts());
        assertNotNull(response.getTotalServices());
        assertEquals(response.getTotal(), BigDecimal.valueOf(unitaryValue));
        assertEquals(response.getTotalProducts(), BigDecimal.ZERO);
        assertEquals(response.getTotalServices(), BigDecimal.valueOf(unitaryValue));
        assertEquals(response.getId(), id);
    }

    /**
     * Factura con un solo item servicio con impuestos
     */
    @Test
    public void testGenerate$2() {
        Double unitaryValue = 10000.0;
        Double ivaValue = 16.0;
        Double total = (unitaryValue * ivaValue / 100) + unitaryValue;
        
        ServiceInvoice iService = serviceBuilder(unitaryValue, 1, true, ivaValue);
        Invoice invoice = invoiceBuilder(iService);
        String id = "123123456";
        Invoice invoice2 = invoiceBuilder(id, invoice, BigDecimal.valueOf(unitaryValue), 
                BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.valueOf(unitaryValue));
        
        //definicion de escenario
        when(invoiceRepository.save(invoice)).thenReturn(invoice2);
        
        //Invocaion de servicio
        Invoice response = service.generate(invoice);
        
        //validaciones
        verify(invoiceRepository).save(invoice);
        assertNotNull(response);
        assertNotNull(response.getId());
        assertNotNull(response.getTotal());
        assertNotNull(response.getTotalImpost());
        assertNotNull(response.getTotalProducts());
        assertNotNull(response.getTotalServices());
        assertEquals(BigDecimal.valueOf(total), response.getTotal());
        assertEquals(BigDecimal.ZERO, response.getTotalProducts());
        assertEquals(BigDecimal.valueOf(total), response.getTotalServices());
        assertEquals(id, response.getId());
    }
    
    
    
    
    private Invoice invoiceBuilder(String id, Invoice source, BigDecimal total, 
            BigDecimal totalImpost, BigDecimal totalProducts, BigDecimal totalService) {
        Invoice invoice = new Invoice();
        BeanUtils.copyProperties(source, invoice);
        invoice.setId(id);
        invoice.setTotal(total);
        invoice.setTotalImpost(totalImpost);
        invoice.setTotalProducts(totalProducts);
        invoice.setTotalServices(totalService);
        
        return invoice;
    }

    private Invoice invoiceBuilder(ServiceInvoice item) {
        Invoice invoice = new Invoice();
        invoice.setPrefix("ABC");
        invoice.setNumber("123");
        invoice.setClient(new Cliente());
        invoice.setType(Invoice.TYPE.CONTADO);
        invoice.setDateInvoice(Calendar.getInstance());
        Resolution resolution = new Resolution();
        invoice.setCaja(new Caja("CAJA01", "Caja Principal", new Sede(), resolution));
        invoice.setResolution(resolution);
        
        invoice.addServiceItem(item);
        
        
        return invoice;
    }

    private ServiceInvoice serviceBuilder(Double unitaryValue, int quantity, boolean iva, Double ivaValue) {
        Service s = new Service("SC01", "SN01", unitaryValue, null, true, null);
        
        if(iva) {
            Impost impost = new Impost();
            impost.setCode("IVA");
            impost.setName("IVA");
            impost.setType(PERCENTAGE);
            s.addImpost(impost, ivaValue);
        }
        
        ServiceInvoice item = new ServiceInvoice(s, s.getUnitaryValue(), quantity);
        return item;
    }
    
}
