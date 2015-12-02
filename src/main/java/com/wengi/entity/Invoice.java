/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wengi.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

/**
 * Modelo que representa una Factura de Venta
 * 
 * @author jhoanseve2
 */
public class Invoice {
    /**
     * Representa el domino de los diferentes tipos de venta
     */
    public static enum TYPE {
        CONTADO("CONT"),
        CREDITO("CRED"),;
        
        private TYPE(String value) {
            this.value = value;
        }
        
        String value;
    }
    
    /**
     * Representa los diferentes estados que tiene una factura
     */
    public static enum STATUS {
        PENDIENTE("PP"),
        PAGO_COMPLETO("PC"),
        PAGO_PARCIAL("PI"),
        ANULADA("AN"),;
        
        private STATUS(String value) {
            this.value = value;
        }
        
        String value;
    }
    
    @Id
    private String id;
    
    /** prefijo asignado a la factura */
    @NotBlank
    @Length(min = 1)
    private String prefix;
    /** numero asignado a la factura */
    @NotBlank
    @Length(min = 1)
    private String number;
    /** fecha de la facturacion */
    @NotNull
    private Calendar dateInvoice;
    /** fecha en que se registro la factura en el sistema */
    private Calendar dateRegister;
    /** tipo de venta realizada */
    @NotNull
    private TYPE type;
    /** esatdo actual de la factura */
    private STATUS status = STATUS.PENDIENTE;
    /** indica si se registra el pago automaticamente se genera la factura */
    private boolean autoPay;
    /** usuario que registro la factura en el sistema */
    private String userSession;
    
    /** caja donde se genero la factura */
    @NotNull
    @DBRef
    private Caja caja;
    /** resoluccion utilizada para la facturacion */
    @NotNull
    @DBRef
    private Resolution resolution;
    /** cliente al que se le genero la factura */
    @DBRef
    @NotNull
    private Cliente client;
    /** empleado que realiza la venta */
    @DBRef
    private Empleado employed;
    /** cliente que remite o refiere a otro para la facturacion
      * - al momento del registro de la factura hay que validar que 
      *   si tiene remitente, este tenga el indicador activo
     */
    @DBRef
    private Cliente sender;
    
    /** total de la factura */
    private BigDecimal total;
    /** total de servicios cargados en la factura */
    private BigDecimal totalServices;
    /** total de productos cargados en la factura */
    private BigDecimal totalProducts;
    /** total de impuestos pagados en la factura */
    private BigDecimal totalImpost;
    /** saldo actual de la factura */
    private BigDecimal residue;
    
    /** nombre de la persona que recibe la compra (si aplica) */
    private String receiveBy;
    
    /** datos de la compania/empresa al momento de la generacion de la factura */
    private String companyName;
    private String companyNIT;
    private String companyRegimen;
    private Address companyAddress;
    
    /** leyendas asignadas a la factura */
    private String leyend1;
    private String leyend2;
    private String leyend3;
    
    /**
     * Detalles de la factura
     */
    @NotNull
    @NotEmpty
    private List<ServiceInvoice> services; 

    public Invoice() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Calendar getDateInvoice() {
        return dateInvoice;
    }

    public void setDateInvoice(Calendar dateInvoice) {
        this.dateInvoice = dateInvoice;
    }

    public Calendar getDateRegister() {
        return dateRegister;
    }

    public void setDateRegister(Calendar dateRegister) {
        this.dateRegister = dateRegister;
    }

    public TYPE getType() {
        return type;
    }

    public void setType(TYPE type) {
        this.type = type;
    }

    public STATUS getStatus() {
        return status;
    }

    public void setStatus(STATUS status) {
        this.status = status;
    }

    public boolean isAutoPay() {
        return autoPay;
    }

    public void setAutoPay(boolean autoPay) {
        this.autoPay = autoPay;
    }

    public String getUserSession() {
        return userSession;
    }

    public void setUserSession(String userSession) {
        this.userSession = userSession;
    }

    public Caja getCaja() {
        return caja;
    }

    public void setCaja(Caja caja) {
        this.caja = caja;
    }

    public Resolution getResolution() {
        return resolution;
    }

    public void setResolution(Resolution resolution) {
        this.resolution = resolution;
    }

    public Cliente getClient() {
        return client;
    }

    public void setClient(Cliente client) {
        this.client = client;
    }

    public Empleado getEmployed() {
        return employed;
    }

    public void setEmployed(Empleado employed) {
        this.employed = employed;
    }

    public Cliente getSender() {
        return sender;
    }

    public void setSender(Cliente sender) {
        this.sender = sender;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getTotalServices() {
        return totalServices;
    }

    public void setTotalServices(BigDecimal totalServices) {
        this.totalServices = totalServices;
    }

    public BigDecimal getTotalProducts() {
        return totalProducts;
    }

    public void setTotalProducts(BigDecimal totalProducts) {
        this.totalProducts = totalProducts;
    }

    public BigDecimal getTotalImpost() {
        return totalImpost;
    }

    public void setTotalImpost(BigDecimal totalImpost) {
        this.totalImpost = totalImpost;
    }

    public BigDecimal getResidue() {
        return residue;
    }

    public void setResidue(BigDecimal residue) {
        this.residue = residue;
    }

    public String getReceiveBy() {
        return receiveBy;
    }

    public void setReceiveBy(String receiveBy) {
        this.receiveBy = receiveBy;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyNIT() {
        return companyNIT;
    }

    public void setCompanyNIT(String companyNIT) {
        this.companyNIT = companyNIT;
    }

    public String getCompanyRegimen() {
        return companyRegimen;
    }

    public void setCompanyRegimen(String companyRegimen) {
        this.companyRegimen = companyRegimen;
    }

    public Address getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(Address companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getLeyend1() {
        return leyend1;
    }

    public void setLeyend1(String leyend1) {
        this.leyend1 = leyend1;
    }

    public String getLeyend2() {
        return leyend2;
    }

    public void setLeyend2(String leyend2) {
        this.leyend2 = leyend2;
    }

    public String getLeyend3() {
        return leyend3;
    }

    public void setLeyend3(String leyend3) {
        this.leyend3 = leyend3;
    }

    public List<ServiceInvoice> getServices() {
        return services;
    }

    public void setServices(List<ServiceInvoice> services) {
        this.services = services;
    }

    
    
    public void addServiceItem(ServiceInvoice item) {
        if(services == null)
            services = new ArrayList<>();
        
        services.add(item);
    }

    
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.id);
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
        final Invoice other = (Invoice) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "FacturaVenta{" + "id=" + id + ", prefix=" + prefix + ", number=" + number + ", dateInvoice=" + dateInvoice + ", dateRegister=" + dateRegister + ", type=" + type + ", status=" + status + ", autoPay=" + autoPay + ", userSession=" + userSession + ", caja=" + caja + ", resolution=" + resolution + ", client=" + client + ", employed=" + employed + ", sender=" + sender + ", total=" + total + ", totalServices=" + totalServices + ", totalProducts=" + totalProducts + ", totalImpost=" + totalImpost + ", residue=" + residue + ", receiveBy=" + receiveBy + ", companyName=" + companyName + ", companyNIT=" + companyNIT + ", companyRegimen=" + companyRegimen + ", companyAddress=" + companyAddress + ", leyend1=" + leyend1 + ", leyend2=" + leyend2 + ", leyend3=" + leyend3 + '}';
    }
}
