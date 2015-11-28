/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wengi.controller;

import com.wengi.FactjayException;
import static com.wengi.TestUtil.APPLICATION_JSON_UTF8;
import static com.wengi.TestUtil.convertObjectToJsonBytes;
import com.wengi.WebTestConfig;
import com.wengi.entity.*;
import com.wengi.services.FacturaVentaService;
import java.util.Calendar;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

/**
 *
 * @author jhoanseve2
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WebTestConfig.class})
@WebAppConfiguration
public class FacturaVentaControllerTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(FacturaVentaControllerTest.class);

    private MockMvc mockMvc;

    @InjectMocks
    private FacturaVentaController controller;
    
    @Mock
    private FacturaVentaService facturaVentaService;

    public FacturaVentaControllerTest() {
    }

    @Before
    public void setup() {
        LOGGER.info("Inyectando mocks...");

        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(controller)
                .defaultRequest(get("/")
                        .accept(APPLICATION_JSON_UTF8)).build();
    }

    /**
     * Verifica que el servicio este habilitado
     * @throws Exception 
     */
    @Test
    public void testGenerate$1() throws Exception {
        FacturaVenta facturaVenta = facturaBuilder();
        FacturaVenta facturaVenta2 = facturaBuilder("123456");

        when(facturaVentaService.generate(facturaVenta)).thenReturn(facturaVenta2);
        
        ResultActions ra = mockMvc.perform(post("/facturas/generate")
                .contentType(APPLICATION_JSON_UTF8)
                .content(convertObjectToJsonBytes(facturaVenta))
        ).andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(facturaVenta2.getId())));
        
        LOGGER.info("Response testGenerate$1()==>> [{}]", ra.andReturn().getResponse().getContentAsString());
        verify(facturaVentaService).generate(facturaVenta);
    }

    
    /**
     * Verifica la validacion cuando la factura es null
     * @throws Exception 
     */
    @Test
    public void testGenerate$2_factura_null() throws Exception {
        FacturaVenta facturaVenta = null;
        
        
        mockMvc.perform(post("/facturas/generate")
                .contentType(APPLICATION_JSON_UTF8)
                .content(convertObjectToJsonBytes(facturaVenta))
        ).andExpect(status().is5xxServerError());
        
        verify(facturaVentaService, never()).generate(facturaVenta);
    }

    private FacturaVenta facturaBuilder(String id) {
        FacturaVenta facturaVenta = facturaBuilder();
        facturaVenta.setId(id);
        
        return facturaVenta;
    }

    private FacturaVenta facturaBuilder() {
        FacturaVenta facturaVenta = new FacturaVenta();
        facturaVenta.setPrefix("ABC");
        facturaVenta.setNumber("123");
        facturaVenta.setClient(new Cliente());
        facturaVenta.setType(FacturaVenta.TYPE.CONTADO);
        facturaVenta.setDateInvoice(Calendar.getInstance());
        Resolution resolution = new Resolution();
        facturaVenta.setCaja(new Caja("CAJA01", "Caja Principal", new Sede(), resolution));
        facturaVenta.setResolution(resolution);
        
        Service s = new Service("SC01", "SN01", 12000.0, null, true, null);
        ItemServiceFactura item = new ItemServiceFactura(s, s.getUnitaryValue(), 1);
        facturaVenta.addServiceItem(item);
        
        
        return facturaVenta;
    }
}
