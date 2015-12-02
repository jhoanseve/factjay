/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wengi.entity;

import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author jhoanseve2
 */
@Document
@CompoundIndexes({
    @CompoundIndex(name = "service_code_company", def = "{'company': 1, 'code': 1}", unique = true),
    @CompoundIndex(name = "service_name_company", def = "{'company': 1, 'name': 1}", unique = true)
})
public class Service {

    @Id
    private String id;
    
    private String code;
    private String name;
    private Double unitaryValue;
    
    @DBRef
    @NotNull
    private ServiceCategory category;
    private boolean status;
    
    @NotNull
    @Indexed
    @DBRef
    private Company company;
    
    private List<ServiceImpost> imposts;

    public Service() {
    }

    public Service(String code, String name, Double unitaryValue, ServiceCategory category, boolean status, Company company) {
        this.code = code;
        this.name = name;
        this.unitaryValue = unitaryValue;
        this.category = category;
        this.status = status;
        this.company = company;
    }
    
    public void addImpost(Impost impost, Double value) {        
        addImpost(new ServiceImpost(impost, value));
    }
    
    public void addImpost(ServiceImpost serviceImpost) {
        if(imposts == null) {
            imposts = new ArrayList<>();
        }
        
        imposts.add(serviceImpost);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getUnitaryValue() {
        return unitaryValue;
    }

    public void setUnitaryValue(Double unitaryValue) {
        this.unitaryValue = unitaryValue;
    }

    public ServiceCategory getCategory() {
        return category;
    }

    public void setCategory(ServiceCategory category) {
        this.category = category;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<ServiceImpost> getImposts() {
        return imposts;
    }

    public void setImposts(List<ServiceImpost> imposts) {
        this.imposts = imposts;
    }

    @Override
    public String toString() {
        return "Service{" + "id=" + id + ", code=" + code + ", name=" + name + ", unitaryValue=" + unitaryValue + ", category=" + category + ", status=" + status + ", company=" + company + '}';
    }
}
