package com.wengi;

import com.wengi.controller.FacturaVentaController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = FactjayApplication.class)
public class FactjayApplicationTestsConfig {

	@Bean
        public FacturaVentaController facturaVentaController() {
            return Mockito.mock(FacturaVentaController.class);
        }

}
