/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wengi.data.repository;

import com.wengi.entity.Invoice;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author jhoanseve2
 */
public interface InvoiceRepository extends MongoRepository<Invoice, String>{
    
}
