/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wengi.controller;

import com.wengi.FactjayApplicationTestsConfig;
import com.wengi.TestUtil;
import com.wengi.entity.FacturaVenta;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

/**
 *
 * @author jhoanseve2
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {FactjayApplicationTestsConfig.class})
@WebAppConfiguration
public class FacturaVentaControllerTest {
    
    private MockMvc mockMvc;
    
    @Autowired
    private FacturaVentaController controller;
    
    public FacturaVentaControllerTest() {
    }

    @Test
    public void testGenerate() throws Exception {
        FacturaVenta facturaVenta = new FacturaVenta();
        facturaVenta.setNumber("123");
        facturaVenta.setPrefix("ABC");
        
        when(controller.generate(facturaVenta)).thenReturn(facturaVenta);
        
        mockMvc.perform(post("/facturas/generate")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(facturaVenta))
        );
    }
    
}
