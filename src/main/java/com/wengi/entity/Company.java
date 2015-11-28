/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wengi.entity;

import java.util.List;
import java.util.Objects;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

/**
 *
 * @author jhoanseve2
 */
public class Company {
    @Id
    private String id;
    
    private String nit;
    private String businessName;
    private String regime;
    private List<String> phones;
    private List<String> emails;
    
    @DBRef
    private Sede principalSede;
    private Address address;

    public Company() {
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getRegime() {
        return regime;
    }

    public void setRegime(String regime) {
        this.regime = regime;
    }

    public List<String> getPhones() {
        return phones;
    }

    public void setPhones(List<String> phones) {
        this.phones = phones;
    }

    public List<String> getEmails() {
        return emails;
    }

    public void setEmails(List<String> emails) {
        this.emails = emails;
    }

    public Sede getPrincipalSede() {
        return principalSede;
    }

    public void setPrincipalSede(Sede principalSede) {
        this.principalSede = principalSede;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.id);
        hash = 89 * hash + Objects.hashCode(this.nit);
        hash = 89 * hash + Objects.hashCode(this.businessName);
        hash = 89 * hash + Objects.hashCode(this.regime);
        hash = 89 * hash + Objects.hashCode(this.phones);
        hash = 89 * hash + Objects.hashCode(this.emails);
        hash = 89 * hash + Objects.hashCode(this.principalSede);
        hash = 89 * hash + Objects.hashCode(this.address);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Company other = (Company) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.nit, other.nit)) {
            return false;
        }
        if (!Objects.equals(this.businessName, other.businessName)) {
            return false;
        }
        if (!Objects.equals(this.regime, other.regime)) {
            return false;
        }
        if (!Objects.equals(this.phones, other.phones)) {
            return false;
        }
        if (!Objects.equals(this.emails, other.emails)) {
            return false;
        }
        if (!Objects.equals(this.principalSede, other.principalSede)) {
            return false;
        }
        if (!Objects.equals(this.address, other.address)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Empresa{" + "id=" + id + ", nit=" + nit + ", businessName=" + businessName + ", regime=" + regime + ", phones=" + phones + ", emails=" + emails + ", principalSede=" + principalSede + ", address=" + address + '}';
    }
}